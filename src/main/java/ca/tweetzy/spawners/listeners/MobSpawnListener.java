/*
 * Spawners
 * Copyright 2026 Kiran Hart
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */
package ca.tweetzy.spawners.listeners;

import ca.tweetzy.flight.utils.Common;
import ca.tweetzy.spawners.Spawners;
import ca.tweetzy.spawners.api.spawner.Spawner;
import ca.tweetzy.spawners.settings.Settings;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.entity.SpawnerSpawnEvent;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public final class MobSpawnListener implements Listener {

	private static final NamespacedKey SPAWNERS_ENTITY_OWNER_KEY = new NamespacedKey(Spawners.getInstance(), "SpawnersEntityOwner");
	private static final NamespacedKey TEMP_DROP_ENTITY_KEY = new NamespacedKey(Spawners.getInstance(), "TempDropEntity");
	
	private static final Map<EntityType, String> ENTITY_NAME_CACHE = new HashMap<>();

	@EventHandler(priority = EventPriority.HIGHEST)
	public void onSpawnerSpawn(SpawnerSpawnEvent event) {
		// Early return if mob stacking is disabled
		if (!Settings.MOB_STACKING_ENABLED.getBoolean()) {
			return;
		}

		// Early return if entity type is not a LivingEntity
		final EntityType entityType = event.getEntityType();
		if (!LivingEntity.class.isAssignableFrom(entityType.getEntityClass())) {
			return;
		}

		// Get spawner from the event's spawner block location
		final Spawner spawner = Spawners.getSpawnerManager().find(event.getSpawner().getLocation());
		if (spawner == null) {
			return;
		}

		// Get spawn location from event
		final Location spawnLocation = event.getLocation();
		final double radius = Settings.MOB_STACKING_MERGE_RADIUS.getDouble();

		// Construct owner string in the same format as EntityListeners uses
		final String ownerString = spawner.getOwnerName() + ":" + spawner.getOwner().toString();

		// Find nearby merge target (stacked or fresh mob)
		final LivingEntity mergeTarget = findNearbyMergeTarget(
				null, // No entity to exclude yet since it hasn't spawned
				spawnLocation,
				entityType,
				radius,
				ownerString
		);

		if (mergeTarget != null) {
			// Cancel the spawn and merge into existing stack
			event.setCancelled(true);
			incrementStackCount(mergeTarget);
		}
		// If no merge target found, allow the spawn to proceed
		// The entity will be set up as a new stack in a separate handler if needed
	}

	@EventHandler(priority = EventPriority.MONITOR, ignoreCancelled = true)
	public void onSpawnerSpawnMonitor(SpawnerSpawnEvent event) {
		// This handler runs after spawn to set up new stacks if they weren't merged
		if (!Settings.MOB_STACKING_ENABLED.getBoolean()) {
			return;
		}

		final Entity entity = event.getEntity();
		if (!(entity instanceof LivingEntity)) {
			return;
		}

		final LivingEntity livingEntity = (LivingEntity) entity;

		// Skip temp drop entities
		if (livingEntity.getPersistentDataContainer().has(TEMP_DROP_ENTITY_KEY, PersistentDataType.BOOLEAN)) {
			return;
		}

		Bukkit.getScheduler().runTask(Spawners.getInstance(), () -> {
			if (livingEntity.isDead() || !livingEntity.isValid()) {
				return;
			}

			// Check if entity has owner key (set by EntityListeners at LOW priority)
			if (!livingEntity.getPersistentDataContainer().has(SPAWNERS_ENTITY_OWNER_KEY, PersistentDataType.STRING)) {
				return;
			}

			if (!isVanillaMob(livingEntity)) {
				return;
			}

			// If entity doesn't have stack count, initialize it
			if (getStackCount(livingEntity) == 0) {
				setStackCount(livingEntity, 1);
				updateStackDisplayName(livingEntity, 1);
			}
		});
	}

	@EventHandler(priority = EventPriority.HIGHEST)
	public void onEntityDamage(EntityDamageEvent event) {
		if (!Settings.MOB_STACKING_ENABLED.getBoolean()) {
			return;
		}

		if (!(event.getEntity() instanceof LivingEntity)) {
			return;
		}

		final LivingEntity entity = (LivingEntity) event.getEntity();
		final int stackCount = getStackCount(entity);

		if (stackCount <= 1) {
			return;
		}

		final double currentHealth = entity.getHealth();
		final double damage = event.getFinalDamage();
		final double finalHealth = currentHealth - damage;
		
		if (finalHealth <= 0) {
			final double estimatedMaxHealth = Math.max(currentHealth, 20.0);
			
			final double newDamage = Math.max(0, currentHealth - 1.0);
			event.setDamage(newDamage);
			
			final int newCount = stackCount - 1;
			setStackCount(entity, newCount);
			updateStackDisplayName(entity, newCount);
			
			final Location dropLocation = entity.getLocation();
			final EntityType entityType = entity.getType();
			final Player killer = resolveKiller(event);

			Bukkit.getScheduler().runTask(Spawners.getInstance(), () -> {
				if (entity.isValid() && !entity.isDead()) {
					try {
						entity.setHealth(estimatedMaxHealth);
					} catch (IllegalArgumentException e) {
						try {
							entity.setHealth(10.0);
						} catch (IllegalArgumentException e2) {
							entity.setHealth(1.0);
						}
					}
				}

				spawnDropsFromTempEntity(entityType, dropLocation, killer);
			});
		}
	}

	@EventHandler(priority = EventPriority.HIGHEST)
	public void onEntityDeath(EntityDeathEvent event) {
		if (!Settings.MOB_STACKING_ENABLED.getBoolean()) {
			return;
		}

		final LivingEntity entity = event.getEntity();
		final int stackCount = getStackCount(entity);

		if (stackCount <= 0) {
			return;
		}

		removeStackData(entity);
	}

	private boolean isVanillaMob(LivingEntity entity) {
		if (getStackCount(entity) > 0) {
			return true;
		}
		
		final String customName = entity.getCustomName();
		if (customName != null) {
			return false;
		}

		return true;
	}

	/**
	 * Finds a nearby mob that can be merged with. Returns either:
	 * 1. A stacked mob that hasn't reached max size (preferred)
	 * 2. A fresh spawner mob without a stack count
	 * 
	 * @param excludeEntity Entity to exclude from search (can be null)
	 * @param location Location to search around
	 * @param entityType Type of entity to find
	 * @param radius Search radius
	 * @param ownerUuid Owner UUID string to match (format: "ownerName:uuid")
	 * @return LivingEntity to merge with, or null if none found
	 */
	private LivingEntity findNearbyMergeTarget(LivingEntity excludeEntity, Location location, EntityType entityType, double radius, String ownerUuid) {
		final Collection<Entity> nearbyEntities = location.getWorld().getNearbyEntities(
				location, radius, radius, radius
		);

		LivingEntity bestStacked = null;
		LivingEntity bestFresh = null;

		for (Entity nearby : nearbyEntities) {
			if (excludeEntity != null && nearby.equals(excludeEntity)) {
				continue;
			}
			
			if (!(nearby instanceof LivingEntity)) {
				continue;
			}

			final LivingEntity nearbyLiving = (LivingEntity) nearby;

			if (nearbyLiving.getType() != entityType) {
				continue;
			}

			// Check if entity has owner key and matches owner
			final PersistentDataContainer pdc = nearbyLiving.getPersistentDataContainer();
			if (!pdc.has(SPAWNERS_ENTITY_OWNER_KEY, PersistentDataType.STRING)) {
				continue;
			}

			// Verify owner matches
			final String entityOwner = pdc.get(SPAWNERS_ENTITY_OWNER_KEY, PersistentDataType.STRING);
			if (!entityOwner.equals(ownerUuid)) {
				continue;
			}

			final int stackCount = getStackCount(nearbyLiving);

			if (stackCount > 0) {
				// This is a stacked mob
				if (!isVanillaMob(nearbyLiving)) {
					continue;
				}

				final int maxSize = Settings.MOB_STACKING_MAX_SIZE.getInt();
				if (stackCount >= maxSize) {
					continue;
				}

				// Prefer stacked mobs over fresh ones
				if (bestStacked == null) {
					bestStacked = nearbyLiving;
				}
			} else {
				// This is a fresh mob without stack count
				if (nearbyLiving.getCustomName() != null) {
					continue;
				}

				// Only consider fresh mob if we haven't found a stacked one yet
				if (bestStacked == null && bestFresh == null) {
					bestFresh = nearbyLiving;
				}
			}
		}

		// Return stacked mob if found, otherwise return fresh mob
		return bestStacked != null ? bestStacked : bestFresh;
	}

	private int getStackCount(LivingEntity entity) {
		final PersistentDataContainer pdc = entity.getPersistentDataContainer();
		if (pdc.has(Spawners.STACKED_MOB_COUNT, PersistentDataType.INTEGER)) {
			return pdc.get(Spawners.STACKED_MOB_COUNT, PersistentDataType.INTEGER);
		}
		return 0;
	}

	private void setStackCount(LivingEntity entity, int count) {
		final PersistentDataContainer pdc = entity.getPersistentDataContainer();
		if (count > 0) {
			pdc.set(Spawners.STACKED_MOB_COUNT, PersistentDataType.INTEGER, count);
		} else {
			pdc.remove(Spawners.STACKED_MOB_COUNT);
		}
	}

	private void updateStackDisplayName(LivingEntity entity, int stackCount) {
		if (stackCount >= 1) {
			final String entityName = getFormattedEntityName(entity.getType());
			String nameFormat = Settings.MOB_STACKING_NAME_FORMAT.getString();
			
			String displayName = nameFormat
					.replace("{entity}", entityName)
					.replace("{count}", String.valueOf(stackCount));
			
			entity.setCustomName(Common.colorize(displayName));
			entity.setCustomNameVisible(true);
		} else {
			entity.setCustomName(null);
			entity.setCustomNameVisible(false);
		}
	}

	private String getFormattedEntityName(EntityType entityType) {
		return ENTITY_NAME_CACHE.computeIfAbsent(entityType, type -> {
			final String entityName = type.name().toLowerCase().replace("_", " ");
			final String[] words = entityName.split(" ");
			final StringBuilder formattedName = new StringBuilder();
			for (int i = 0; i < words.length; i++) {
				if (i > 0) {
					formattedName.append(" ");
				}
				if (words[i].length() > 0) {
					formattedName.append(Character.toUpperCase(words[i].charAt(0)));
					if (words[i].length() > 1) {
						formattedName.append(words[i].substring(1));
					}
				}
			}
			return formattedName.toString();
		});
	}

	/**
	 * Increments the stack count of an existing entity by 1
	 */
	private void incrementStackCount(LivingEntity entity) {
		final int currentCount = getStackCount(entity);
		final int newCount = currentCount > 0 ? currentCount + 1 : 2; // If 0, make it 2 (1 existing + 1 new)
		setStackCount(entity, newCount);
		updateStackDisplayName(entity, newCount);
	}

	private void removeStackData(LivingEntity entity) {
		final PersistentDataContainer pdc = entity.getPersistentDataContainer();
		pdc.remove(Spawners.STACKED_MOB_COUNT);
		entity.setCustomName(null);
		entity.setCustomNameVisible(false);
	}

	/**
	 * Resolves the player killer from a damage event, if any (e.g. direct hit or projectile).
	 */
	private Player resolveKiller(EntityDamageEvent event) {
		if (!(event instanceof EntityDamageByEntityEvent)) {
			return null;
		}
		final Entity damager = ((EntityDamageByEntityEvent) event).getDamager();
		if (damager instanceof Projectile) {
			if (((Projectile) damager).getShooter() instanceof Player) {
				return (Player) ((Projectile) damager).getShooter();
			}
			return null;
		}
		if (damager instanceof Player) {
			return (Player) damager;
		}
		return null;
	}

	private void spawnDropsFromTempEntity(EntityType entityType, Location location, Player killer) {
		try {
			final Location spawnLoc = location.clone().add(0, 0.1, 0);
			final LivingEntity tempEntity = (LivingEntity) spawnLoc.getWorld().spawnEntity(spawnLoc, entityType);

			tempEntity.getPersistentDataContainer().set(TEMP_DROP_ENTITY_KEY, PersistentDataType.BOOLEAN, true);

			if (killer != null) {
				tempEntity.damage(9999, killer);
			} else {
				tempEntity.setHealth(0);
			}

			Bukkit.getScheduler().runTaskLater(Spawners.getInstance(), () -> {
				if (tempEntity.isValid()) {
					tempEntity.remove();
				}
			}, 2L);
		} catch (Exception e) {
		}
	}
}
