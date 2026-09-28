/*
 * Spawners
 * Copyright 2022 Kiran Hart
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
package ca.tweetzy.spawners.settings;

import ca.tweetzy.flight.comp.enums.CompMaterial;
import ca.tweetzy.flight.config.ConfigEntry;
import ca.tweetzy.flight.config.tweetzy.TweetzyYamlConfig;
import ca.tweetzy.flight.gui.helper.InventoryBorder;
import ca.tweetzy.flight.settings.FlightSettings;
import ca.tweetzy.spawners.Spawners;
import lombok.SneakyThrows;
import org.bukkit.entity.EntityType;

import java.util.List;

/**
 * Date Created: May 03 2022
 * Time Created: 4:53 p.m.
 *
 * @author Kiran Hart
 */
public final class Settings extends FlightSettings {

	static final TweetzyYamlConfig config = Spawners.getCoreConfig();

	public static final ConfigEntry PREFIX = config.createEntry("prefix", "<GRADIENT:fc67fa>&LSpawners</GRADIENT:f4c4f3> &8»").withComment("The global prefix for the plugin");
	public static final ConfigEntry LANGUAGE = config.createEntry("language", "en_us").withComment("The default language for the plugin");

	public static final ConfigEntry UPGRADE_CURRENCY = config.createEntry("currency.upgrade", "vault").withComment("If you are using something like UltraEconomy you can use 'UltraEconomy:theCurrencyName' instead");
	public static final ConfigEntry UPGRADE_SPAWNER_SHOP = config.createEntry("currency.spawner shop", "vault").withComment("If you are using something like UltraEconomy you can use 'UltraEconomy:theCurrencyName' instead");

	public static final ConfigEntry SPAWNER_ITEM = config.createEntry("spawner item", CompMaterial.SPAWNER.name()).withComment("This should probably be a block if you decide to change it..");
	public static final ConfigEntry ALLOW_NON_OWNER_PLACE = config.createEntry("allow non owner place", false).withComment("If true, player's who don't own the spawner item/block can still place it");
	public static final ConfigEntry ALLOW_NON_OWNER_BREAK = config.createEntry("allow non owner break", false).withComment("If true, player's who don't own the spawner item/block can still break it");
	public static final ConfigEntry ENABLE_SHOP = config.createEntry("enable shop", true).withComment("If true, the shop icon will appear in /spawners for users to buy spawners (items need to be added first)");

	public static final ConfigEntry USE_SHOPS_FOR_SELLING  = config.createEntry("shop.use shops for selling", false).withComment("If true spawners will use the specified shop from the Shops plugin (by Tweetzy) instead of the built-in one.");
	public static final ConfigEntry SHOPS_ID  = config.createEntry("shop.shops store id", "spawners").withComment("This is the id of the shop name from Shops, if this is not correct it will default to the built in one. (the shops category can be private)");

	public static final ConfigEntry SPAWNER_REQUIRE_REDSTONE_SIGNAL = config.createEntry("redstone.spawners require redstone signal", false).withComment("If true, if a Spawners' spawner doesn't have a redstone signal it will not be able to spawn anything.");
	public static final ConfigEntry SPAWNER_DISABLES_WITH_REDSTONE_SIGNAL = config.createEntry("redstone.spawners disable with redstone signal", false).withComment("If true the spawner will disable when a redstone signal is applied.");
	public static final ConfigEntry ATTEMPT_TO_PLACE_IN_INVENTORY = config.createEntry("mine.attempt to place in inventory", false).withComment("If true, Spawners will try to place the item in their player's inventory before dropping it.");
	public static final ConfigEntry REQUIRE_SHIFT_FOR_SPAWNER_VIEW = config.createEntry("require shift to view spawner menu", true).withComment("If true, Players will need to shift while right clicking to open the spawner menu");

	public static final ConfigEntry MAX_SPAWNER_PER_CHUNK_ENABLED = config.createEntry("max spawners per chunk.enabled", true).withComment("If true, spawners will limit the amount of spawners within a chunk");
	public static final ConfigEntry MAX_SPAWNER_PER_CHUNK = config.createEntry("max spawners per chunk.max", 16).withComment("If max spawners per chunk.enabled is enabled, it will use this limit");
	public static final ConfigEntry MAX_SPAWNER_PER_PLAYER = config.createEntry("max spawners per player", 16).withComment("Can be overridden using the perm: spawners.maxplace.#, # being the new total");

	public static final ConfigEntry DEFAULT_SPAWNER_ENTITY = config.createEntry("spawner defaults.entity", EntityType.PIG.name()).withComment("For non Spawners spawners, what should the default mob be when placed");
	public static final ConfigEntry DEFAULT_SPAWNER_DELAY = config.createEntry("spawner defaults.delay", 20 * 12);
	public static final ConfigEntry DEFAULT_SPAWNER_SPAWN_COUNT = config.createEntry("spawner defaults.spawn count", 4);
	public static final ConfigEntry DEFAULT_SPAWNER_ACTIVATION_RANGE = config.createEntry("spawner defaults.activation range", 16);
	public static final ConfigEntry DEFAULT_SPAWNER_MAX_NEARBY_ENTITIES = config.createEntry("spawner defaults.max nearby entities", 12);
	public static final ConfigEntry DEFAULT_LEVEL_COST = config.createEntry("spawner defaults.default level cost", 1000D);

	public static final ConfigEntry ALLOW_SPAWNER_CHANGE_WITH_EGG = config.createEntry("eggs.allow spawner change", true).withComment("If a player right clicks a spawner with a spawn egg, should it update the entity? Normal ownership rules will apply");
	public static final ConfigEntry REMOVE_EGG_ON_SPAWNER_CHANGE = config.createEntry("eggs.remove egg on spawner change", true).withComment("Should the egg be used when they apply it to the spawner?");
	public static final ConfigEntry ALLOW_SPAWN_EGG_THROW = config.createEntry("eggs.allow spawn egg throw", true).withComment("Should players be able to throw spawn eggs?");

	public static final ConfigEntry ASSIGN_OWNER_TO_NATURAL = config.createEntry("assign owner to natural", true).withComment("When a natural spawner is broken, should the miner become the owner?");

	public static final ConfigEntry MINE_DROP_CHANCE = config.createEntry("mine.drop chance", 50D).withComment("Chance for the spawner to drop when mined");
	public static final ConfigEntry MINE_REQUIRES_SILK_TOUCH = config.createEntry("mine.requires silk touch", true).withComment("Should silk touch be required to mine spawners?");
	public static final ConfigEntry MINE_WITHOUT_SILK_BREAKS = config.createEntry("mine.no silk drops nothing", true).withComment("If a player mines a spawner (natural) without silk touch, it drops nothing");
	public static final ConfigEntry MINE_PREVENT_NATURAL_MINING = config.createEntry("mine.prevent natural mining", true).withComment("Prevents players from mining natural spawners if enabled");

	public static final ConfigEntry EXPLOSION_DROP_ENABLED = config.createEntry("explosion.drop enabled", true).withComment("Should spawners break during an explosion");
	public static final ConfigEntry EXPLOSION_DROP_CHANCE = config.createEntry("explosion.drop chance", 25D).withComment("The chance for the spawner to drop if exploded by tnt");
	public static final ConfigEntry EXPLOSION_RESETS_OWNER = config.createEntry("explosion.reset owner", true).withComment("If the spawner is dropped by explosion, should the owner be reset?");
	public static final ConfigEntry EXPLOSION_PREVENT_UNKNOWN_SOURCE = config.createEntry("explosion.prevent unknown source", true).withComment("If the spawner is broken due to an unknown explosion source, should it cancel?");

	public static final ConfigEntry MOB_STACKING_ENABLED = config.createEntry("mob stacking.enabled", true).withComment("If true, mobs spawned from spawners will automatically stack together to reduce entity count");
	public static final ConfigEntry MOB_STACKING_MAX_SIZE = config.createEntry("mob stacking.max size", 1000).withComment("Maximum number of mobs that can be stacked in a single entity");
	public static final ConfigEntry MOB_STACKING_MERGE_RADIUS = config.createEntry("mob stacking.merge radius", 10D).withComment("Radius in blocks to search for nearby stacked mobs to merge with");
	public static final ConfigEntry MOB_STACKING_NAME_FORMAT = config.createEntry("mob stacking.name format", "&e{entity} &fx&e{count}").withComment("Format for stacked mob names. Use {entity} for entity name and {count} for stack count. Example: '{entity} x{count}' or '[{count}] {entity}'");

	public static ConfigEntry GUI_SHARED_ITEMS_BACK_BUTTON = create("gui.shared buttons.back button.item", CompMaterial.DARK_OAK_DOOR.name());
	public static ConfigEntry GUI_SHARED_ITEMS_EXIT_BUTTON = create("gui.shared buttons.exit button.item", CompMaterial.BARRIER.name());
	public static ConfigEntry GUI_SHARED_ITEMS_PREVIOUS_BUTTON = create("gui.shared buttons.previous button.item", CompMaterial.ARROW.name());
	public static ConfigEntry GUI_SHARED_ITEMS_NEXT_BUTTON = create("gui.shared buttons.next button.item", CompMaterial.ARROW.name());

	public static final ConfigEntry GUI_ENTITY_CHANGE_ROWS = config.createEntry("gui.entity change.rows", 6).withComment("The size (rows, min = 2, max = 6) of the spawner mob change gui");
	public static final ConfigEntry GUI_ENTITY_CHANGE_BG = config.createEntry("gui.entity change.background", CompMaterial.BLACK_STAINED_GLASS_PANE.name()).withComment("The default background material");
	public static final ConfigEntry GUI_ENTITY_CHANGE_FILL_SLOTS = config.createEntry("gui.entity change.fill slots", InventoryBorder.getInsideBorders(5)).withComment("The slots in which mob heads will be placed into");
	public static final ConfigEntry GUI_ENTITY_CHANGE_FILL_DECORATION = config.createEntry("gui.entity change.decoration", List.of("0:BLACK_STAINED_GLASS_PANE")).withComment("Option Decoration items (slot:material_name)");

	public static final ConfigEntry GUI_PLAYER_SELECT_ROWS = config.createEntry("gui.player select.rows", 6).withComment("The size (rows, min = 2, max = 6) of the player select change gui");
	public static final ConfigEntry GUI_PLAYER_SELECT_BG = config.createEntry("gui.player select.background", CompMaterial.BLACK_STAINED_GLASS_PANE.name()).withComment("The default background material");
	public static final ConfigEntry GUI_PLAYER_SELECT_FILL_SLOTS = config.createEntry("gui.player select.fill slots", InventoryBorder.getInsideBorders(5)).withComment("The slots in which player heads will be placed into");
	public static final ConfigEntry GUI_PLAYER_SELECT_FILL_DECORATION = config.createEntry("gui.player select.decoration", List.of("0:BLACK_STAINED_GLASS_PANE")).withComment("Option Decoration items (slot:material_name)");


	public static final ConfigEntry GUI_MAIN_ROWS = config.createEntry("gui.main.rows", 3).withComment("The size (rows, min = 2, max = 6) of the main player gui");
	public static final ConfigEntry GUI_MAIN_BG = config.createEntry("gui.main.background", CompMaterial.BLACK_STAINED_GLASS_PANE.name()).withComment("The default background material");
	public static final ConfigEntry GUI_MAIN_FILL_DECORATION = config.createEntry("gui.main.decoration", List.of("0:BLACK_STAINED_GLASS_PANE")).withComment("Option Decoration items (slot:material_name)");

	public static final ConfigEntry GUI_MERGE_OR_SPLIT_ROWS = config.createEntry("gui.merge or split.rows", 3).withComment("The size (rows, min = 2, max = 6) of the merge/split gui");
	public static final ConfigEntry GUI_MERGE_OR_SPLIT_BG = config.createEntry("gui.merge or split.background", CompMaterial.BLACK_STAINED_GLASS_PANE.name()).withComment("The default background material");

	public static final ConfigEntry GUI_SPAWNER_OVERVIEW_ROWS = config.createEntry("gui.spawner overview.rows", 5);
	public static final ConfigEntry GUI_SPAWNER_OVERVIEW_ITEMS_MERGE_SLOT = config.createEntry("gui.spawner overview.items.merge.slot", 31).withComment("Set to -1 to hide/disable in gui");
	public static final ConfigEntry GUI_SPAWNER_OVERVIEW_ITEMS_ENTITY_SLOT = config.createEntry("gui.spawner overview.items.change entity.slot", 29).withComment("Set to -1 to hide/disable in gui");
	public static final ConfigEntry GUI_SPAWNER_OVERVIEW_ITEMS_OWNER_SLOT = config.createEntry("gui.spawner overview.items.owner.slot", 33).withComment("Set to -1 to hide/disable in gui");
	public static final ConfigEntry GUI_SPAWNER_OVERVIEW_ITEMS_DELAY_SLOT = config.createEntry("gui.spawner overview.items.spawn delay.slot", 10).withComment("Set to -1 to hide/disable in gui");
	public static final ConfigEntry GUI_SPAWNER_OVERVIEW_ITEMS_COUNT_SLOT = config.createEntry("gui.spawner overview.items.spawn count.slot", 12).withComment("Set to -1 to hide/disable in gui");
	public static final ConfigEntry GUI_SPAWNER_OVERVIEW_ITEMS_MAX_ENTITY_SLOT = config.createEntry("gui.spawner overview.items.max nearby entities.slot", 14).withComment("Set to -1 to hide/disable in gui");
	public static final ConfigEntry GUI_SPAWNER_OVERVIEW_ITEMS_ACTIVATION_RANGE_SLOT = config.createEntry("gui.spawner overview.items.activation range.slot", 16).withComment("Set to -1 to hide/disable in gui");

	public static final ConfigEntry GUI_SPAWNER_OVERVIEW_BG = config.createEntry("gui.spawner overview.background", CompMaterial.BLACK_STAINED_GLASS_PANE.name()).withComment("The default background material");
	public static final ConfigEntry GUI_SPAWNER_OVERVIEW_DECORATION = config.createEntry("gui.spawner overview.decoration", List.of(
			"slot:0-45 item:BLACK_STAINED_GLASS_PANE"
	)).withComment("List of decorations. Ex. slot:0-8 item:BLACK_STAINED_GLASS_PANE or slot:9 item:BLACK_STAINED_GLASS_PANE");


	public static final ConfigEntry GUI_YOUR_SPAWNERS_ROWS = config.createEntry("gui.your spawners.rows", 6).withComment("The size (rows, min = 2, max = 6)");
	public static final ConfigEntry GUI_YOUR_SPAWNERS_BG = config.createEntry("gui.your spawners.background", CompMaterial.BLACK_STAINED_GLASS_PANE.name()).withComment("The default background material");
	public static final ConfigEntry GUI_YOUR_SPAWNERS_FILL_SLOTS = config.createEntry("gui.your spawners.fill slots", InventoryBorder.getInsideBorders(5)).withComment("The slots in which items will be placed into");
	public static final ConfigEntry GUI_YOUR_SPAWNERS_FILL_DECORATION = config.createEntry("gui.your spawners.decoration", List.of("0:BLACK_STAINED_GLASS_PANE")).withComment("Option Decoration items (slot:material_name)");

	public static final ConfigEntry GUI_SHOP_ROWS = config.createEntry("gui.spawner shop.rows", 6).withComment("The size (rows, min = 2, max = 6)");
	public static final ConfigEntry GUI_SHOP_BG = config.createEntry("gui.spawner shop.background", CompMaterial.BLACK_STAINED_GLASS_PANE.name()).withComment("The default background material");
	public static final ConfigEntry GUI_SHOP_FILL_SLOTS = config.createEntry("gui.spawner shop.fill slots", InventoryBorder.getInsideBorders(5)).withComment("The slots in which items will be placed into");
	public static final ConfigEntry GUI_SHOP_FILL_DECORATION = config.createEntry("gui.spawner shop.decoration", List.of("0:BLACK_STAINED_GLASS_PANE")).withComment("Option Decoration items (slot:material_name)");


	public static final ConfigEntry MOB_CHANGE_ELDER_GUARDIAN_ENABLED = config.createEntry("mob change.elder guardian.enabled", true).withComment("Should players be able to set their spawner to a Elder Guardian");
	public static final ConfigEntry MOB_CHANGE_ELDER_GUARDIAN_COST = config.createEntry("mob change.elder guardian.cost", 5000D).withComment("The cost to switch the spawner to a Elder Guardian");
	public static final ConfigEntry MOB_CHANGE_WITHER_SKELETON_ENABLED = config.createEntry("mob change.wither skeleton.enabled", true).withComment("Should players be able to set their spawner to a Wither Skeleton");
	public static final ConfigEntry MOB_CHANGE_WITHER_SKELETON_COST = config.createEntry("mob change.wither skeleton.cost", 5000D).withComment("The cost to switch the spawner to a Wither Skeleton");
	public static final ConfigEntry MOB_CHANGE_STRAY_ENABLED = config.createEntry("mob change.stray.enabled", true).withComment("Should players be able to set their spawner to a Stray");
	public static final ConfigEntry MOB_CHANGE_STRAY_COST = config.createEntry("mob change.stray.cost", 5000D).withComment("The cost to switch the spawner to a Stray");
	public static final ConfigEntry MOB_CHANGE_HUSK_ENABLED = config.createEntry("mob change.husk.enabled", true).withComment("Should players be able to set their spawner to a Husk");
	public static final ConfigEntry MOB_CHANGE_HUSK_COST = config.createEntry("mob change.husk.cost", 5000D).withComment("The cost to switch the spawner to a Husk");
	public static final ConfigEntry MOB_CHANGE_ZOMBIE_VILLAGER_ENABLED = config.createEntry("mob change.zombie villager.enabled", true).withComment("Should players be able to set their spawner to a Zombie Villager");
	public static final ConfigEntry MOB_CHANGE_ZOMBIE_VILLAGER_COST = config.createEntry("mob change.zombie villager.cost", 5000D).withComment("The cost to switch the spawner to a Zombie Villager");
	public static final ConfigEntry MOB_CHANGE_SKELETON_HORSE_ENABLED = config.createEntry("mob change.skeleton horse.enabled", true).withComment("Should players be able to set their spawner to a Skeleton Horse");
	public static final ConfigEntry MOB_CHANGE_SKELETON_HORSE_COST = config.createEntry("mob change.skeleton horse.cost", 5000D).withComment("The cost to switch the spawner to a Skeleton Horse");
	public static final ConfigEntry MOB_CHANGE_ZOMBIE_HORSE_ENABLED = config.createEntry("mob change.zombie horse.enabled", true).withComment("Should players be able to set their spawner to a Zombie Horse");
	public static final ConfigEntry MOB_CHANGE_ZOMBIE_HORSE_COST = config.createEntry("mob change.zombie horse.cost", 5000D).withComment("The cost to switch the spawner to a Zombie Horse");
	public static final ConfigEntry MOB_CHANGE_DONKEY_ENABLED = config.createEntry("mob change.donkey.enabled", true).withComment("Should players be able to set their spawner to a Donkey");
	public static final ConfigEntry MOB_CHANGE_DONKEY_COST = config.createEntry("mob change.donkey.cost", 5000D).withComment("The cost to switch the spawner to a Donkey");
	public static final ConfigEntry MOB_CHANGE_MULE_ENABLED = config.createEntry("mob change.mule.enabled", true).withComment("Should players be able to set their spawner to a Mule");
	public static final ConfigEntry MOB_CHANGE_MULE_COST = config.createEntry("mob change.mule.cost", 5000D).withComment("The cost to switch the spawner to a Mule");
	public static final ConfigEntry MOB_CHANGE_EVOKER_ENABLED = config.createEntry("mob change.evoker.enabled", true).withComment("Should players be able to set their spawner to a Evoker");
	public static final ConfigEntry MOB_CHANGE_EVOKER_COST = config.createEntry("mob change.evoker.cost", 5000D).withComment("The cost to switch the spawner to a Evoker");
	public static final ConfigEntry MOB_CHANGE_VEX_ENABLED = config.createEntry("mob change.vex.enabled", true).withComment("Should players be able to set their spawner to a Vex");
	public static final ConfigEntry MOB_CHANGE_VEX_COST = config.createEntry("mob change.vex.cost", 5000D).withComment("The cost to switch the spawner to a Vex");
	public static final ConfigEntry MOB_CHANGE_VINDICATOR_ENABLED = config.createEntry("mob change.vindicator.enabled", true).withComment("Should players be able to set their spawner to a Vindicator");
	public static final ConfigEntry MOB_CHANGE_VINDICATOR_COST = config.createEntry("mob change.vindicator.cost", 5000D).withComment("The cost to switch the spawner to a Vindicator");
	public static final ConfigEntry MOB_CHANGE_ILLUSIONER_ENABLED = config.createEntry("mob change.illusioner.enabled", true).withComment("Should players be able to set their spawner to a Illusioner");
	public static final ConfigEntry MOB_CHANGE_ILLUSIONER_COST = config.createEntry("mob change.illusioner.cost", 5000D).withComment("The cost to switch the spawner to a Illusioner");
	public static final ConfigEntry MOB_CHANGE_CREEPER_ENABLED = config.createEntry("mob change.creeper.enabled", true).withComment("Should players be able to set their spawner to a Creeper");
	public static final ConfigEntry MOB_CHANGE_CREEPER_COST = config.createEntry("mob change.creeper.cost", 5000D).withComment("The cost to switch the spawner to a Creeper");
	public static final ConfigEntry MOB_CHANGE_SKELETON_ENABLED = config.createEntry("mob change.skeleton.enabled", true).withComment("Should players be able to set their spawner to a Skeleton");
	public static final ConfigEntry MOB_CHANGE_SKELETON_COST = config.createEntry("mob change.skeleton.cost", 5000D).withComment("The cost to switch the spawner to a Skeleton");
	public static final ConfigEntry MOB_CHANGE_SPIDER_ENABLED = config.createEntry("mob change.spider.enabled", true).withComment("Should players be able to set their spawner to a Spider");
	public static final ConfigEntry MOB_CHANGE_SPIDER_COST = config.createEntry("mob change.spider.cost", 5000D).withComment("The cost to switch the spawner to a Spider");
	public static final ConfigEntry MOB_CHANGE_GIANT_ENABLED = config.createEntry("mob change.giant.enabled", true).withComment("Should players be able to set their spawner to a Giant");
	public static final ConfigEntry MOB_CHANGE_GIANT_COST = config.createEntry("mob change.giant.cost", 5000D).withComment("The cost to switch the spawner to a Giant");
	public static final ConfigEntry MOB_CHANGE_ZOMBIE_ENABLED = config.createEntry("mob change.zombie.enabled", true).withComment("Should players be able to set their spawner to a Zombie");
	public static final ConfigEntry MOB_CHANGE_ZOMBIE_COST = config.createEntry("mob change.zombie.cost", 5000D).withComment("The cost to switch the spawner to a Zombie");
	public static final ConfigEntry MOB_CHANGE_SLIME_ENABLED = config.createEntry("mob change.slime.enabled", true).withComment("Should players be able to set their spawner to a Slime");
	public static final ConfigEntry MOB_CHANGE_SLIME_COST = config.createEntry("mob change.slime.cost", 5000D).withComment("The cost to switch the spawner to a Slime");
	public static final ConfigEntry MOB_CHANGE_GHAST_ENABLED = config.createEntry("mob change.ghast.enabled", true).withComment("Should players be able to set their spawner to a Ghast");
	public static final ConfigEntry MOB_CHANGE_GHAST_COST = config.createEntry("mob change.ghast.cost", 5000D).withComment("The cost to switch the spawner to a Ghast");
	public static final ConfigEntry MOB_CHANGE_ZOMBIFIED_PIGLIN_ENABLED = config.createEntry("mob change.zombified piglin.enabled", true).withComment("Should players be able to set their spawner to a Zombified Piglin");
	public static final ConfigEntry MOB_CHANGE_ZOMBIFIED_PIGLIN_COST = config.createEntry("mob change.zombified piglin.cost", 5000D).withComment("The cost to switch the spawner to a Zombified Piglin");
	public static final ConfigEntry MOB_CHANGE_ENDERMAN_ENABLED = config.createEntry("mob change.enderman.enabled", true).withComment("Should players be able to set their spawner to a Enderman");
	public static final ConfigEntry MOB_CHANGE_ENDERMAN_COST = config.createEntry("mob change.enderman.cost", 5000D).withComment("The cost to switch the spawner to a Enderman");
	public static final ConfigEntry MOB_CHANGE_CAVE_SPIDER_ENABLED = config.createEntry("mob change.cave spider.enabled", true).withComment("Should players be able to set their spawner to a Cave Spider");
	public static final ConfigEntry MOB_CHANGE_CAVE_SPIDER_COST = config.createEntry("mob change.cave spider.cost", 5000D).withComment("The cost to switch the spawner to a Cave Spider");
	public static final ConfigEntry MOB_CHANGE_SILVERFISH_ENABLED = config.createEntry("mob change.silverfish.enabled", true).withComment("Should players be able to set their spawner to a Silverfish");
	public static final ConfigEntry MOB_CHANGE_SILVERFISH_COST = config.createEntry("mob change.silverfish.cost", 5000D).withComment("The cost to switch the spawner to a Silverfish");
	public static final ConfigEntry MOB_CHANGE_BLAZE_ENABLED = config.createEntry("mob change.blaze.enabled", true).withComment("Should players be able to set their spawner to a Blaze");
	public static final ConfigEntry MOB_CHANGE_BLAZE_COST = config.createEntry("mob change.blaze.cost", 5000D).withComment("The cost to switch the spawner to a Blaze");
	public static final ConfigEntry MOB_CHANGE_MAGMA_CUBE_ENABLED = config.createEntry("mob change.magma cube.enabled", true).withComment("Should players be able to set their spawner to a Magma Cube");
	public static final ConfigEntry MOB_CHANGE_MAGMA_CUBE_COST = config.createEntry("mob change.magma cube.cost", 5000D).withComment("The cost to switch the spawner to a Magma Cube");
	public static final ConfigEntry MOB_CHANGE_ENDER_DRAGON_ENABLED = config.createEntry("mob change.ender dragon.enabled", true).withComment("Should players be able to set their spawner to a Ender Dragon");
	public static final ConfigEntry MOB_CHANGE_ENDER_DRAGON_COST = config.createEntry("mob change.ender dragon.cost", 5000D).withComment("The cost to switch the spawner to a Ender Dragon");
	public static final ConfigEntry MOB_CHANGE_WITHER_ENABLED = config.createEntry("mob change.wither.enabled", true).withComment("Should players be able to set their spawner to a Wither");
	public static final ConfigEntry MOB_CHANGE_WITHER_COST = config.createEntry("mob change.wither.cost", 5000D).withComment("The cost to switch the spawner to a Wither");
	public static final ConfigEntry MOB_CHANGE_BAT_ENABLED = config.createEntry("mob change.bat.enabled", true).withComment("Should players be able to set their spawner to a Bat");
	public static final ConfigEntry MOB_CHANGE_BAT_COST = config.createEntry("mob change.bat.cost", 5000D).withComment("The cost to switch the spawner to a Bat");
	public static final ConfigEntry MOB_CHANGE_WITCH_ENABLED = config.createEntry("mob change.witch.enabled", true).withComment("Should players be able to set their spawner to a Witch");
	public static final ConfigEntry MOB_CHANGE_WITCH_COST = config.createEntry("mob change.witch.cost", 5000D).withComment("The cost to switch the spawner to a Witch");
	public static final ConfigEntry MOB_CHANGE_ENDERMITE_ENABLED = config.createEntry("mob change.endermite.enabled", true).withComment("Should players be able to set their spawner to a Endermite");
	public static final ConfigEntry MOB_CHANGE_ENDERMITE_COST = config.createEntry("mob change.endermite.cost", 5000D).withComment("The cost to switch the spawner to a Endermite");
	public static final ConfigEntry MOB_CHANGE_GUARDIAN_ENABLED = config.createEntry("mob change.guardian.enabled", true).withComment("Should players be able to set their spawner to a Guardian");
	public static final ConfigEntry MOB_CHANGE_GUARDIAN_COST = config.createEntry("mob change.guardian.cost", 5000D).withComment("The cost to switch the spawner to a Guardian");
	public static final ConfigEntry MOB_CHANGE_SHULKER_ENABLED = config.createEntry("mob change.shulker.enabled", true).withComment("Should players be able to set their spawner to a Shulker");
	public static final ConfigEntry MOB_CHANGE_SHULKER_COST = config.createEntry("mob change.shulker.cost", 5000D).withComment("The cost to switch the spawner to a Shulker");
	public static final ConfigEntry MOB_CHANGE_PIG_ENABLED = config.createEntry("mob change.pig.enabled", true).withComment("Should players be able to set their spawner to a Pig");
	public static final ConfigEntry MOB_CHANGE_PIG_COST = config.createEntry("mob change.pig.cost", 5000D).withComment("The cost to switch the spawner to a Pig");
	public static final ConfigEntry MOB_CHANGE_SHEEP_ENABLED = config.createEntry("mob change.sheep.enabled", true).withComment("Should players be able to set their spawner to a Sheep");
	public static final ConfigEntry MOB_CHANGE_SHEEP_COST = config.createEntry("mob change.sheep.cost", 5000D).withComment("The cost to switch the spawner to a Sheep");
	public static final ConfigEntry MOB_CHANGE_COW_ENABLED = config.createEntry("mob change.cow.enabled", true).withComment("Should players be able to set their spawner to a Cow");
	public static final ConfigEntry MOB_CHANGE_COW_COST = config.createEntry("mob change.cow.cost", 5000D).withComment("The cost to switch the spawner to a Cow");
	public static final ConfigEntry MOB_CHANGE_CHICKEN_ENABLED = config.createEntry("mob change.chicken.enabled", true).withComment("Should players be able to set their spawner to a Chicken");
	public static final ConfigEntry MOB_CHANGE_CHICKEN_COST = config.createEntry("mob change.chicken.cost", 5000D).withComment("The cost to switch the spawner to a Chicken");
	public static final ConfigEntry MOB_CHANGE_SQUID_ENABLED = config.createEntry("mob change.squid.enabled", true).withComment("Should players be able to set their spawner to a Squid");
	public static final ConfigEntry MOB_CHANGE_SQUID_COST = config.createEntry("mob change.squid.cost", 5000D).withComment("The cost to switch the spawner to a Squid");
	public static final ConfigEntry MOB_CHANGE_WOLF_ENABLED = config.createEntry("mob change.wolf.enabled", true).withComment("Should players be able to set their spawner to a Wolf");
	public static final ConfigEntry MOB_CHANGE_WOLF_COST = config.createEntry("mob change.wolf.cost", 5000D).withComment("The cost to switch the spawner to a Wolf");
	public static final ConfigEntry MOB_CHANGE_MUSHROOM_COW_ENABLED = config.createEntry("mob change.mushroom cow.enabled", true).withComment("Should players be able to set their spawner to a Mushroom Cow");
	public static final ConfigEntry MOB_CHANGE_MUSHROOM_COW_COST = config.createEntry("mob change.mushroom cow.cost", 5000D).withComment("The cost to switch the spawner to a Mushroom Cow");
	public static final ConfigEntry MOB_CHANGE_SNOWMAN_ENABLED = config.createEntry("mob change.snowman.enabled", true).withComment("Should players be able to set their spawner to a Snowman");
	public static final ConfigEntry MOB_CHANGE_SNOWMAN_COST = config.createEntry("mob change.snowman.cost", 5000D).withComment("The cost to switch the spawner to a Snowman");
	public static final ConfigEntry MOB_CHANGE_OCELOT_ENABLED = config.createEntry("mob change.ocelot.enabled", true).withComment("Should players be able to set their spawner to a Ocelot");
	public static final ConfigEntry MOB_CHANGE_OCELOT_COST = config.createEntry("mob change.ocelot.cost", 5000D).withComment("The cost to switch the spawner to a Ocelot");
	public static final ConfigEntry MOB_CHANGE_IRON_GOLEM_ENABLED = config.createEntry("mob change.iron golem.enabled", true).withComment("Should players be able to set their spawner to a Iron Golem");
	public static final ConfigEntry MOB_CHANGE_IRON_GOLEM_COST = config.createEntry("mob change.iron golem.cost", 5000D).withComment("The cost to switch the spawner to a Iron Golem");
	public static final ConfigEntry MOB_CHANGE_HORSE_ENABLED = config.createEntry("mob change.horse.enabled", true).withComment("Should players be able to set their spawner to a Horse");
	public static final ConfigEntry MOB_CHANGE_HORSE_COST = config.createEntry("mob change.horse.cost", 5000D).withComment("The cost to switch the spawner to a Horse");
	public static final ConfigEntry MOB_CHANGE_RABBIT_ENABLED = config.createEntry("mob change.rabbit.enabled", true).withComment("Should players be able to set their spawner to a Rabbit");
	public static final ConfigEntry MOB_CHANGE_RABBIT_COST = config.createEntry("mob change.rabbit.cost", 5000D).withComment("The cost to switch the spawner to a Rabbit");
	public static final ConfigEntry MOB_CHANGE_POLAR_BEAR_ENABLED = config.createEntry("mob change.polar bear.enabled", true).withComment("Should players be able to set their spawner to a Polar Bear");
	public static final ConfigEntry MOB_CHANGE_POLAR_BEAR_COST = config.createEntry("mob change.polar bear.cost", 5000D).withComment("The cost to switch the spawner to a Polar Bear");
	public static final ConfigEntry MOB_CHANGE_LLAMA_ENABLED = config.createEntry("mob change.llama.enabled", true).withComment("Should players be able to set their spawner to a Llama");
	public static final ConfigEntry MOB_CHANGE_LLAMA_COST = config.createEntry("mob change.llama.cost", 5000D).withComment("The cost to switch the spawner to a Llama");
	public static final ConfigEntry MOB_CHANGE_PARROT_ENABLED = config.createEntry("mob change.parrot.enabled", true).withComment("Should players be able to set their spawner to a Parrot");
	public static final ConfigEntry MOB_CHANGE_PARROT_COST = config.createEntry("mob change.parrot.cost", 5000D).withComment("The cost to switch the spawner to a Parrot");
	public static final ConfigEntry MOB_CHANGE_VILLAGER_ENABLED = config.createEntry("mob change.villager.enabled", true).withComment("Should players be able to set their spawner to a Villager");
	public static final ConfigEntry MOB_CHANGE_VILLAGER_COST = config.createEntry("mob change.villager.cost", 5000D).withComment("The cost to switch the spawner to a Villager");
	public static final ConfigEntry MOB_CHANGE_TURTLE_ENABLED = config.createEntry("mob change.turtle.enabled", true).withComment("Should players be able to set their spawner to a Turtle");
	public static final ConfigEntry MOB_CHANGE_TURTLE_COST = config.createEntry("mob change.turtle.cost", 5000D).withComment("The cost to switch the spawner to a Turtle");
	public static final ConfigEntry MOB_CHANGE_PHANTOM_ENABLED = config.createEntry("mob change.phantom.enabled", true).withComment("Should players be able to set their spawner to a Phantom");
	public static final ConfigEntry MOB_CHANGE_PHANTOM_COST = config.createEntry("mob change.phantom.cost", 5000D).withComment("The cost to switch the spawner to a Phantom");
	public static final ConfigEntry MOB_CHANGE_COD_ENABLED = config.createEntry("mob change.cod.enabled", true).withComment("Should players be able to set their spawner to a Cod");
	public static final ConfigEntry MOB_CHANGE_COD_COST = config.createEntry("mob change.cod.cost", 5000D).withComment("The cost to switch the spawner to a Cod");
	public static final ConfigEntry MOB_CHANGE_SALMON_ENABLED = config.createEntry("mob change.salmon.enabled", true).withComment("Should players be able to set their spawner to a Salmon");
	public static final ConfigEntry MOB_CHANGE_SALMON_COST = config.createEntry("mob change.salmon.cost", 5000D).withComment("The cost to switch the spawner to a Salmon");
	public static final ConfigEntry MOB_CHANGE_PUFFERFISH_ENABLED = config.createEntry("mob change.pufferfish.enabled", true).withComment("Should players be able to set their spawner to a Pufferfish");
	public static final ConfigEntry MOB_CHANGE_PUFFERFISH_COST = config.createEntry("mob change.pufferfish.cost", 5000D).withComment("The cost to switch the spawner to a Pufferfish");
	public static final ConfigEntry MOB_CHANGE_TROPICAL_FISH_ENABLED = config.createEntry("mob change.tropical fish.enabled", true).withComment("Should players be able to set their spawner to a Tropical Fish");
	public static final ConfigEntry MOB_CHANGE_TROPICAL_FISH_COST = config.createEntry("mob change.tropical fish.cost", 5000D).withComment("The cost to switch the spawner to a Tropical Fish");
	public static final ConfigEntry MOB_CHANGE_DROWNED_ENABLED = config.createEntry("mob change.drowned.enabled", true).withComment("Should players be able to set their spawner to a Drowned");
	public static final ConfigEntry MOB_CHANGE_DROWNED_COST = config.createEntry("mob change.drowned.cost", 5000D).withComment("The cost to switch the spawner to a Drowned");
	public static final ConfigEntry MOB_CHANGE_DOLPHIN_ENABLED = config.createEntry("mob change.dolphin.enabled", true).withComment("Should players be able to set their spawner to a Dolphin");
	public static final ConfigEntry MOB_CHANGE_DOLPHIN_COST = config.createEntry("mob change.dolphin.cost", 5000D).withComment("The cost to switch the spawner to a Dolphin");
	public static final ConfigEntry MOB_CHANGE_CAT_ENABLED = config.createEntry("mob change.cat.enabled", true).withComment("Should players be able to set their spawner to a Cat");
	public static final ConfigEntry MOB_CHANGE_CAT_COST = config.createEntry("mob change.cat.cost", 5000D).withComment("The cost to switch the spawner to a Cat");
	public static final ConfigEntry MOB_CHANGE_PANDA_ENABLED = config.createEntry("mob change.panda.enabled", true).withComment("Should players be able to set their spawner to a Panda");
	public static final ConfigEntry MOB_CHANGE_PANDA_COST = config.createEntry("mob change.panda.cost", 5000D).withComment("The cost to switch the spawner to a Panda");
	public static final ConfigEntry MOB_CHANGE_PILLAGER_ENABLED = config.createEntry("mob change.pillager.enabled", true).withComment("Should players be able to set their spawner to a Pillager");
	public static final ConfigEntry MOB_CHANGE_PILLAGER_COST = config.createEntry("mob change.pillager.cost", 5000D).withComment("The cost to switch the spawner to a Pillager");
	public static final ConfigEntry MOB_CHANGE_RAVAGER_ENABLED = config.createEntry("mob change.ravager.enabled", true).withComment("Should players be able to set their spawner to a Ravager");
	public static final ConfigEntry MOB_CHANGE_RAVAGER_COST = config.createEntry("mob change.ravager.cost", 5000D).withComment("The cost to switch the spawner to a Ravager");
	public static final ConfigEntry MOB_CHANGE_TRADER_LLAMA_ENABLED = config.createEntry("mob change.trader llama.enabled", true).withComment("Should players be able to set their spawner to a Trader Llama");
	public static final ConfigEntry MOB_CHANGE_TRADER_LLAMA_COST = config.createEntry("mob change.trader llama.cost", 5000D).withComment("The cost to switch the spawner to a Trader Llama");
	public static final ConfigEntry MOB_CHANGE_WANDERING_TRADER_ENABLED = config.createEntry("mob change.wandering trader.enabled", true).withComment("Should players be able to set their spawner to a Wandering Trader");
	public static final ConfigEntry MOB_CHANGE_WANDERING_TRADER_COST = config.createEntry("mob change.wandering trader.cost", 5000D).withComment("The cost to switch the spawner to a Wandering Trader");
	public static final ConfigEntry MOB_CHANGE_FOX_ENABLED = config.createEntry("mob change.fox.enabled", true).withComment("Should players be able to set their spawner to a Fox");
	public static final ConfigEntry MOB_CHANGE_FOX_COST = config.createEntry("mob change.fox.cost", 5000D).withComment("The cost to switch the spawner to a Fox");
	public static final ConfigEntry MOB_CHANGE_BEE_ENABLED = config.createEntry("mob change.bee.enabled", true).withComment("Should players be able to set their spawner to a Bee");
	public static final ConfigEntry MOB_CHANGE_BEE_COST = config.createEntry("mob change.bee.cost", 5000D).withComment("The cost to switch the spawner to a Bee");
	public static final ConfigEntry MOB_CHANGE_HOGLIN_ENABLED = config.createEntry("mob change.hoglin.enabled", true).withComment("Should players be able to set their spawner to a Hoglin");
	public static final ConfigEntry MOB_CHANGE_HOGLIN_COST = config.createEntry("mob change.hoglin.cost", 5000D).withComment("The cost to switch the spawner to a Hoglin");
	public static final ConfigEntry MOB_CHANGE_PIGLIN_ENABLED = config.createEntry("mob change.piglin.enabled", true).withComment("Should players be able to set their spawner to a Piglin");
	public static final ConfigEntry MOB_CHANGE_PIGLIN_COST = config.createEntry("mob change.piglin.cost", 5000D).withComment("The cost to switch the spawner to a Piglin");
	public static final ConfigEntry MOB_CHANGE_STRIDER_ENABLED = config.createEntry("mob change.strider.enabled", true).withComment("Should players be able to set their spawner to a Strider");
	public static final ConfigEntry MOB_CHANGE_STRIDER_COST = config.createEntry("mob change.strider.cost", 5000D).withComment("The cost to switch the spawner to a Strider");
	public static final ConfigEntry MOB_CHANGE_ZOGLIN_ENABLED = config.createEntry("mob change.zoglin.enabled", true).withComment("Should players be able to set their spawner to a Zoglin");
	public static final ConfigEntry MOB_CHANGE_ZOGLIN_COST = config.createEntry("mob change.zoglin.cost", 5000D).withComment("The cost to switch the spawner to a Zoglin");
	public static final ConfigEntry MOB_CHANGE_PIGLIN_BRUTE_ENABLED = config.createEntry("mob change.piglin brute.enabled", true).withComment("Should players be able to set their spawner to a Piglin Brute");
	public static final ConfigEntry MOB_CHANGE_PIGLIN_BRUTE_COST = config.createEntry("mob change.piglin brute.cost", 5000D).withComment("The cost to switch the spawner to a Piglin Brute");
	public static final ConfigEntry MOB_CHANGE_AXOLOTL_ENABLED = config.createEntry("mob change.axolotl.enabled", true).withComment("Should players be able to set their spawner to a Axolotl");
	public static final ConfigEntry MOB_CHANGE_AXOLOTL_COST = config.createEntry("mob change.axolotl.cost", 5000D).withComment("The cost to switch the spawner to a Axolotl");
	public static final ConfigEntry MOB_CHANGE_GLOW_SQUID_ENABLED = config.createEntry("mob change.glow squid.enabled", true).withComment("Should players be able to set their spawner to a Glow Squid");
	public static final ConfigEntry MOB_CHANGE_GLOW_SQUID_COST = config.createEntry("mob change.glow squid.cost", 5000D).withComment("The cost to switch the spawner to a Glow Squid");
	public static final ConfigEntry MOB_CHANGE_GOAT_ENABLED = config.createEntry("mob change.goat.enabled", true).withComment("Should players be able to set their spawner to a Goat");
	public static final ConfigEntry MOB_CHANGE_GOAT_COST = config.createEntry("mob change.goat.cost", 5000D).withComment("The cost to switch the spawner to a Goat");

	public static final ConfigEntry MOB_CHANGE_ALLAY_ENABLED = config.createEntry("mob change.allay.enabled", true).withComment("Should players be able to set their spawner to a Allay");
	public static final ConfigEntry MOB_CHANGE_ALLAY_COST = config.createEntry("mob change.allay.cost", 5000D).withComment("The cost to switch the spawner to a Allay");

	public static final ConfigEntry MOB_CHANGE_FROG_ENABLED = config.createEntry("mob change.frog.enabled", true).withComment("Should players be able to set their spawner to a Frog");
	public static final ConfigEntry MOB_CHANGE_FROG_COST = config.createEntry("mob change.frog.cost", 5000D).withComment("The cost to switch the spawner to a Frog");

	public static final ConfigEntry MOB_CHANGE_TADPOLE_ENABLED = config.createEntry("mob change.tadpole.enabled", true).withComment("Should players be able to set their spawner to a Tadpole");
	public static final ConfigEntry MOB_CHANGE_TADPOLE_COST = config.createEntry("mob change.tadpole.cost", 5000D).withComment("The cost to switch the spawner to a Tadpole");

	public static final ConfigEntry MOB_CHANGE_WARDEN_ENABLED = config.createEntry("mob change.warden.enabled", true).withComment("Should players be able to set their spawner to a Warden");
	public static final ConfigEntry MOB_CHANGE_WARDEN_COST = create("mob change.warden.cost", 5000D).withComment("The cost to switch the spawner to a Warden");

	public static final ConfigEntry MOB_CHANGE_CAMEL_ENABLED = config.createEntry("mob change.camel.enabled", true).withComment("Should players be able to set their spawner to a Camel");
	public static final ConfigEntry MOB_CHANGE_CAMEL_COST = create("mob change.camel.cost", 5000D).withComment("The cost to switch the spawner to a Camel");

	public static final ConfigEntry MOB_CHANGE_SNIFFER_ENABLED = config.createEntry("mob change.sniffer.enabled", true).withComment("Should players be able to set their spawner to a Sniffer");
	public static final ConfigEntry MOB_CHANGE_SNIFFER_COST = create("mob change.sniffer.cost", 5000D).withComment("The cost to switch the spawner to a Sniffer");

	public static final ConfigEntry MOB_CHANGE_ARMADILLO_ENABLED = config.createEntry("mob change.armadillo.enabled", true).withComment("Should players be able to set their spawner to an Armadillo");
	public static final ConfigEntry MOB_CHANGE_ARMADILLO_COST = create("mob change.armadillo.cost", 5000D).withComment("The cost to switch the spawner to a Armadillo");

	public static final ConfigEntry MOB_CHANGE_BOGGED_ENABLED = config.createEntry("mob change.bogged.enabled", true).withComment("Should players be able to set their spawner to a Bogged");
	public static final ConfigEntry MOB_CHANGE_BOGGED_COST = create("mob change.bogged.cost", 5000D).withComment("The cost to switch the spawner to a Bogged");

	public static final ConfigEntry MOB_CHANGE_BREEZE_ENABLED = config.createEntry("mob change.breeze.enabled", true).withComment("Should players be able to set their spawner to a Breeze");
	public static final ConfigEntry MOB_CHANGE_BREEZE_COST = create("mob change.breeze.cost", 5000D).withComment("The cost to switch the spawner to a Breeze");

	public static final ConfigEntry MOB_CHANGE_CREAKING_ENABLED = config.createEntry("mob change.creaking.enabled", true).withComment("Should players be able to set their spawner to a Creaking");
	public static final ConfigEntry MOB_CHANGE_CREAKING_COST = config.createEntry("mob change.creaking.cost", 5000D).withComment("The cost to switch the spawner to a Creaking");

	public static final ConfigEntry MOB_CHANGE_HAPPY_GHAST_ENABLED = config.createEntry("mob change.happy ghast.enabled", true).withComment("Should players be able to set their spawner to a Happy Ghast");
	public static final ConfigEntry MOB_CHANGE_HAPPY_GHAST_COST = config.createEntry("mob change.happy ghast.cost", 5000D).withComment("The cost to switch the spawner to a Happy Ghast");

	public static final ConfigEntry MOB_CHANGE_COPPER_GOLEM_ENABLED = config.createEntry("mob change.copper golem.enabled", true).withComment("Should players be able to set their spawner to a Copper Golem");
	public static final ConfigEntry MOB_CHANGE_COPPER_GOLEM_COST = config.createEntry("mob change.copper golem.cost", 5000D).withComment("The cost to switch the spawner to a Copper Golem");

	public static final ConfigEntry MOB_CHANGE_NAUTILUS_ENABLED = config.createEntry("mob change.nautilus.enabled", true).withComment("Should players be able to set their spawner to a nautilus");
	public static final ConfigEntry MOB_CHANGE_NAUTILUS_COST = config.createEntry("mob change.nautilus.cost", 5000D).withComment("The cost to switch the spawner to a nautilus");

	public static final ConfigEntry MOB_CHANGE_ZOMBIE_NAUTILUS_ENABLED = config.createEntry("mob change.zombie nautilus.enabled", true).withComment("Should players be able to set their spawner to a zombie nautilus");
	public static final ConfigEntry MOB_CHANGE_ZOMBIE_NAUTILUS_COST = config.createEntry("mob change.zombie nautilus.cost", 5000D).withComment("The cost to switch the spawner to a zombie nautilus");

	public static final ConfigEntry MOB_CHANGE_CAMEL_HUSK_ENABLED = config.createEntry("mob change.camel husk.enabled", true).withComment("Should players be able to set their spawner to a camel husk");
	public static final ConfigEntry MOB_CHANGE_CAMEL_HUSK_COST = config.createEntry("mob change.camel husk.cost", 5000D).withComment("The cost to switch the spawner to a camel husk");

	public static final ConfigEntry MOB_CHANGE_PARCHED_ENABLED = config.createEntry("mob change.parched.enabled", true).withComment("Should players be able to set their spawner to a parched");
	public static final ConfigEntry MOB_CHANGE_PARCHED_COST = config.createEntry("mob change.parched.cost", 5000D).withComment("The cost to switch the spawner to a parched");

	public static final ConfigEntry MOB_CHANGE_SULFUR_CUBE_ENABLED = config.createEntry("mob change.sulfur cube.enabled", true).withComment("Should players be able to set their spawner to a sulfur cube");
	public static final ConfigEntry MOB_CHANGE_SULFUR_CUBE_COST = config.createEntry("mob change.sulfur cube.cost", 5000D).withComment("The cost to switch the spawner to a sulfur cube");

	@SneakyThrows
	public static void setup() {
		config.init();
	}

}
