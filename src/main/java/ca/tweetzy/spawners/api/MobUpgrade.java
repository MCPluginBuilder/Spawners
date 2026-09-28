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
package ca.tweetzy.spawners.api;

import ca.tweetzy.flight.settings.TranslationManager;
import ca.tweetzy.spawners.settings.Settings;
import ca.tweetzy.spawners.settings.Translations;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.bukkit.entity.EntityType;

/**
 * Date Created: May 18 2022
 * Time Created: 12:55 p.m.
 *
 * @author Kiran Hart
 */
@AllArgsConstructor
@Getter
public enum MobUpgrade {

	ELDER_GUARDIAN(Settings.MOB_CHANGE_ELDER_GUARDIAN_ENABLED.getBoolean(), Settings.MOB_CHANGE_ELDER_GUARDIAN_COST.getDouble(), SpawnerMob.ELDER_GUARDIAN),
	WITHER_SKELETON(Settings.MOB_CHANGE_WITHER_SKELETON_ENABLED.getBoolean(), Settings.MOB_CHANGE_WITHER_SKELETON_COST.getDouble(), SpawnerMob.WITHER_SKELETON),
	STRAY(Settings.MOB_CHANGE_STRAY_ENABLED.getBoolean(), Settings.MOB_CHANGE_STRAY_COST.getDouble(), SpawnerMob.STRAY),
	HUSK(Settings.MOB_CHANGE_HUSK_ENABLED.getBoolean(), Settings.MOB_CHANGE_HUSK_COST.getDouble(), SpawnerMob.HUSK),
	ZOMBIE_VILLAGER(Settings.MOB_CHANGE_ZOMBIE_VILLAGER_ENABLED.getBoolean(), Settings.MOB_CHANGE_ZOMBIE_VILLAGER_COST.getDouble(), SpawnerMob.ZOMBIE_VILLAGER),
	SKELETON_HORSE(Settings.MOB_CHANGE_SKELETON_HORSE_ENABLED.getBoolean(), Settings.MOB_CHANGE_SKELETON_HORSE_COST.getDouble(), SpawnerMob.SKELETON_HORSE),
	ZOMBIE_HORSE(Settings.MOB_CHANGE_ZOMBIE_HORSE_ENABLED.getBoolean(), Settings.MOB_CHANGE_ZOMBIE_HORSE_COST.getDouble(), SpawnerMob.ZOMBIE_HORSE),
	DONKEY(Settings.MOB_CHANGE_DONKEY_ENABLED.getBoolean(), Settings.MOB_CHANGE_DONKEY_COST.getDouble(), SpawnerMob.DONKEY),
	MULE(Settings.MOB_CHANGE_MULE_ENABLED.getBoolean(), Settings.MOB_CHANGE_MULE_COST.getDouble(), SpawnerMob.MULE),
	EVOKER(Settings.MOB_CHANGE_EVOKER_ENABLED.getBoolean(), Settings.MOB_CHANGE_EVOKER_COST.getDouble(), SpawnerMob.EVOKER),
	VEX(Settings.MOB_CHANGE_VEX_ENABLED.getBoolean(), Settings.MOB_CHANGE_VEX_COST.getDouble(), SpawnerMob.VEX),
	VINDICATOR(Settings.MOB_CHANGE_VINDICATOR_ENABLED.getBoolean(), Settings.MOB_CHANGE_VINDICATOR_COST.getDouble(), SpawnerMob.VINDICATOR),
	ILLUSIONER(Settings.MOB_CHANGE_ILLUSIONER_ENABLED.getBoolean(), Settings.MOB_CHANGE_ILLUSIONER_COST.getDouble(), SpawnerMob.ILLUSIONER),
	CREEPER(Settings.MOB_CHANGE_CREEPER_ENABLED.getBoolean(), Settings.MOB_CHANGE_CREEPER_COST.getDouble(), SpawnerMob.CREEPER),
	SKELETON(Settings.MOB_CHANGE_SKELETON_ENABLED.getBoolean(), Settings.MOB_CHANGE_SKELETON_COST.getDouble(), SpawnerMob.SKELETON),
	SPIDER(Settings.MOB_CHANGE_SPIDER_ENABLED.getBoolean(), Settings.MOB_CHANGE_SPIDER_COST.getDouble(), SpawnerMob.SPIDER),
	GIANT(Settings.MOB_CHANGE_GIANT_ENABLED.getBoolean(), Settings.MOB_CHANGE_GIANT_COST.getDouble(), SpawnerMob.GIANT),
	ZOMBIE(Settings.MOB_CHANGE_ZOMBIE_ENABLED.getBoolean(), Settings.MOB_CHANGE_ZOMBIE_COST.getDouble(), SpawnerMob.ZOMBIE),
	SLIME(Settings.MOB_CHANGE_SLIME_ENABLED.getBoolean(), Settings.MOB_CHANGE_SLIME_COST.getDouble(), SpawnerMob.SLIME),
	GHAST(Settings.MOB_CHANGE_GHAST_ENABLED.getBoolean(), Settings.MOB_CHANGE_GHAST_COST.getDouble(), SpawnerMob.GHAST),
	ZOMBIFIED_PIGLIN(Settings.MOB_CHANGE_ZOMBIFIED_PIGLIN_ENABLED.getBoolean(), Settings.MOB_CHANGE_ZOMBIFIED_PIGLIN_COST.getDouble(), SpawnerMob.ZOMBIFIED_PIGLIN),
	ENDERMAN(Settings.MOB_CHANGE_ENDERMAN_ENABLED.getBoolean(), Settings.MOB_CHANGE_ENDERMAN_COST.getDouble(), SpawnerMob.ENDERMAN),
	CAVE_SPIDER(Settings.MOB_CHANGE_CAVE_SPIDER_ENABLED.getBoolean(), Settings.MOB_CHANGE_CAVE_SPIDER_COST.getDouble(), SpawnerMob.CAVE_SPIDER),
	SILVERFISH(Settings.MOB_CHANGE_SILVERFISH_ENABLED.getBoolean(), Settings.MOB_CHANGE_SILVERFISH_COST.getDouble(), SpawnerMob.SILVERFISH),
	BLAZE(Settings.MOB_CHANGE_BLAZE_ENABLED.getBoolean(), Settings.MOB_CHANGE_BLAZE_COST.getDouble(), SpawnerMob.BLAZE),
	MAGMA_CUBE(Settings.MOB_CHANGE_MAGMA_CUBE_ENABLED.getBoolean(), Settings.MOB_CHANGE_MAGMA_CUBE_COST.getDouble(), SpawnerMob.MAGMA_CUBE),
	ENDER_DRAGON(Settings.MOB_CHANGE_ENDER_DRAGON_ENABLED.getBoolean(), Settings.MOB_CHANGE_ENDER_DRAGON_COST.getDouble(), SpawnerMob.ENDER_DRAGON),
	WITHER(Settings.MOB_CHANGE_WITHER_ENABLED.getBoolean(), Settings.MOB_CHANGE_WITHER_COST.getDouble(), SpawnerMob.WITHER),
	BAT(Settings.MOB_CHANGE_BAT_ENABLED.getBoolean(), Settings.MOB_CHANGE_BAT_COST.getDouble(), SpawnerMob.BAT),
	WITCH(Settings.MOB_CHANGE_WITCH_ENABLED.getBoolean(), Settings.MOB_CHANGE_WITCH_COST.getDouble(), SpawnerMob.WITCH),
	ENDERMITE(Settings.MOB_CHANGE_ENDERMITE_ENABLED.getBoolean(), Settings.MOB_CHANGE_ENDERMITE_COST.getDouble(), SpawnerMob.ENDERMITE),
	GUARDIAN(Settings.MOB_CHANGE_GUARDIAN_ENABLED.getBoolean(), Settings.MOB_CHANGE_GUARDIAN_COST.getDouble(), SpawnerMob.GUARDIAN),
	SHULKER(Settings.MOB_CHANGE_SHULKER_ENABLED.getBoolean(), Settings.MOB_CHANGE_SHULKER_COST.getDouble(), SpawnerMob.SHULKER),
	PIG(Settings.MOB_CHANGE_PIG_ENABLED.getBoolean(), Settings.MOB_CHANGE_PIG_COST.getDouble(), SpawnerMob.PIG),
	SHEEP(Settings.MOB_CHANGE_SHEEP_ENABLED.getBoolean(), Settings.MOB_CHANGE_SHEEP_COST.getDouble(), SpawnerMob.SHEEP),
	COW(Settings.MOB_CHANGE_COW_ENABLED.getBoolean(), Settings.MOB_CHANGE_COW_COST.getDouble(), SpawnerMob.COW),
	CHICKEN(Settings.MOB_CHANGE_CHICKEN_ENABLED.getBoolean(), Settings.MOB_CHANGE_CHICKEN_COST.getDouble(), SpawnerMob.CHICKEN),
	SQUID(Settings.MOB_CHANGE_SQUID_ENABLED.getBoolean(), Settings.MOB_CHANGE_SQUID_COST.getDouble(), SpawnerMob.SQUID),
	WOLF(Settings.MOB_CHANGE_WOLF_ENABLED.getBoolean(), Settings.MOB_CHANGE_WOLF_COST.getDouble(), SpawnerMob.WOLF),
	MUSHROOM_COW(Settings.MOB_CHANGE_MUSHROOM_COW_ENABLED.getBoolean(), Settings.MOB_CHANGE_MUSHROOM_COW_COST.getDouble(), SpawnerMob.MUSHROOM_COW),
	SNOWMAN(Settings.MOB_CHANGE_SNOWMAN_ENABLED.getBoolean(), Settings.MOB_CHANGE_SNOWMAN_COST.getDouble(), SpawnerMob.SNOWMAN),
	OCELOT(Settings.MOB_CHANGE_OCELOT_ENABLED.getBoolean(), Settings.MOB_CHANGE_OCELOT_COST.getDouble(), SpawnerMob.OCELOT),
	IRON_GOLEM(Settings.MOB_CHANGE_IRON_GOLEM_ENABLED.getBoolean(), Settings.MOB_CHANGE_IRON_GOLEM_COST.getDouble(), SpawnerMob.IRON_GOLEM),
	HORSE(Settings.MOB_CHANGE_HORSE_ENABLED.getBoolean(), Settings.MOB_CHANGE_HORSE_COST.getDouble(), SpawnerMob.HORSE),
	RABBIT(Settings.MOB_CHANGE_RABBIT_ENABLED.getBoolean(), Settings.MOB_CHANGE_RABBIT_COST.getDouble(), SpawnerMob.RABBIT),
	POLAR_BEAR(Settings.MOB_CHANGE_POLAR_BEAR_ENABLED.getBoolean(), Settings.MOB_CHANGE_POLAR_BEAR_COST.getDouble(), SpawnerMob.POLAR_BEAR),
	LLAMA(Settings.MOB_CHANGE_LLAMA_ENABLED.getBoolean(), Settings.MOB_CHANGE_LLAMA_COST.getDouble(), SpawnerMob.LLAMA),
	PARROT(Settings.MOB_CHANGE_PARROT_ENABLED.getBoolean(), Settings.MOB_CHANGE_PARROT_COST.getDouble(), SpawnerMob.PARROT),
	VILLAGER(Settings.MOB_CHANGE_VILLAGER_ENABLED.getBoolean(), Settings.MOB_CHANGE_VILLAGER_COST.getDouble(), SpawnerMob.VILLAGER),
	TURTLE(Settings.MOB_CHANGE_TURTLE_ENABLED.getBoolean(), Settings.MOB_CHANGE_TURTLE_COST.getDouble(), SpawnerMob.TURTLE),
	PHANTOM(Settings.MOB_CHANGE_PHANTOM_ENABLED.getBoolean(), Settings.MOB_CHANGE_PHANTOM_COST.getDouble(), SpawnerMob.PHANTOM),
	COD(Settings.MOB_CHANGE_COD_ENABLED.getBoolean(), Settings.MOB_CHANGE_COD_COST.getDouble(), SpawnerMob.COD),
	SALMON(Settings.MOB_CHANGE_SALMON_ENABLED.getBoolean(), Settings.MOB_CHANGE_SALMON_COST.getDouble(), SpawnerMob.SALMON),
	PUFFERFISH(Settings.MOB_CHANGE_PUFFERFISH_ENABLED.getBoolean(), Settings.MOB_CHANGE_PUFFERFISH_COST.getDouble(), SpawnerMob.PUFFERFISH),
	TROPICAL_FISH(Settings.MOB_CHANGE_TROPICAL_FISH_ENABLED.getBoolean(), Settings.MOB_CHANGE_TROPICAL_FISH_COST.getDouble(), SpawnerMob.TROPICAL_FISH),
	DROWNED(Settings.MOB_CHANGE_DROWNED_ENABLED.getBoolean(), Settings.MOB_CHANGE_DROWNED_COST.getDouble(), SpawnerMob.DROWNED),
	DOLPHIN(Settings.MOB_CHANGE_DOLPHIN_ENABLED.getBoolean(), Settings.MOB_CHANGE_DOLPHIN_COST.getDouble(), SpawnerMob.DOLPHIN),
	CAT(Settings.MOB_CHANGE_CAT_ENABLED.getBoolean(), Settings.MOB_CHANGE_CAT_COST.getDouble(), SpawnerMob.CAT),
	PANDA(Settings.MOB_CHANGE_PANDA_ENABLED.getBoolean(), Settings.MOB_CHANGE_PANDA_COST.getDouble(), SpawnerMob.PANDA),
	PILLAGER(Settings.MOB_CHANGE_PILLAGER_ENABLED.getBoolean(), Settings.MOB_CHANGE_PILLAGER_COST.getDouble(), SpawnerMob.PILLAGER),
	RAVAGER(Settings.MOB_CHANGE_RAVAGER_ENABLED.getBoolean(), Settings.MOB_CHANGE_RAVAGER_COST.getDouble(), SpawnerMob.RAVAGER),
	TRADER_LLAMA(Settings.MOB_CHANGE_TRADER_LLAMA_ENABLED.getBoolean(), Settings.MOB_CHANGE_TRADER_LLAMA_COST.getDouble(), SpawnerMob.TRADER_LLAMA),
	WANDERING_TRADER(Settings.MOB_CHANGE_WANDERING_TRADER_ENABLED.getBoolean(), Settings.MOB_CHANGE_WANDERING_TRADER_COST.getDouble(), SpawnerMob.WANDERING_TRADER),
	FOX(Settings.MOB_CHANGE_FOX_ENABLED.getBoolean(), Settings.MOB_CHANGE_FOX_COST.getDouble(), SpawnerMob.FOX),
	BEE(Settings.MOB_CHANGE_BEE_ENABLED.getBoolean(), Settings.MOB_CHANGE_BEE_COST.getDouble(), SpawnerMob.BEE),
	HOGLIN(Settings.MOB_CHANGE_HOGLIN_ENABLED.getBoolean(), Settings.MOB_CHANGE_HOGLIN_COST.getDouble(), SpawnerMob.HOGLIN),
	PIGLIN(Settings.MOB_CHANGE_PIGLIN_ENABLED.getBoolean(), Settings.MOB_CHANGE_PIGLIN_COST.getDouble(), SpawnerMob.PIGLIN),
	STRIDER(Settings.MOB_CHANGE_STRIDER_ENABLED.getBoolean(), Settings.MOB_CHANGE_STRIDER_COST.getDouble(), SpawnerMob.STRIDER),
	ZOGLIN(Settings.MOB_CHANGE_ZOGLIN_ENABLED.getBoolean(), Settings.MOB_CHANGE_ZOGLIN_COST.getDouble(), SpawnerMob.ZOGLIN),
	PIGLIN_BRUTE(Settings.MOB_CHANGE_PIGLIN_BRUTE_ENABLED.getBoolean(), Settings.MOB_CHANGE_PIGLIN_BRUTE_COST.getDouble(), SpawnerMob.PIGLIN_BRUTE),
	AXOLOTL(Settings.MOB_CHANGE_AXOLOTL_ENABLED.getBoolean(), Settings.MOB_CHANGE_AXOLOTL_COST.getDouble(), SpawnerMob.AXOLOTL),
	GLOW_SQUID(Settings.MOB_CHANGE_GLOW_SQUID_ENABLED.getBoolean(), Settings.MOB_CHANGE_GLOW_SQUID_COST.getDouble(), SpawnerMob.GLOW_SQUID),
	GOAT(Settings.MOB_CHANGE_GOAT_ENABLED.getBoolean(), Settings.MOB_CHANGE_GOAT_COST.getDouble(), SpawnerMob.GOAT),

	// 1.19
	ALLAY(Settings.MOB_CHANGE_ALLAY_ENABLED.getBoolean(), Settings.MOB_CHANGE_ALLAY_COST.getDouble(), SpawnerMob.ALLAY),
	FROG(Settings.MOB_CHANGE_FROG_ENABLED.getBoolean(), Settings.MOB_CHANGE_FROG_COST.getDouble(), SpawnerMob.FROG),
	TADPOLE(Settings.MOB_CHANGE_TADPOLE_ENABLED.getBoolean(), Settings.MOB_CHANGE_TADPOLE_COST.getDouble(), SpawnerMob.TADPOLE),
	WARDEN(Settings.MOB_CHANGE_WARDEN_ENABLED.getBoolean(), Settings.MOB_CHANGE_WARDEN_COST.getDouble(), SpawnerMob.WARDEN),

	// 1.20
	CAMEL(Settings.MOB_CHANGE_CAMEL_ENABLED.getBoolean(), Settings.MOB_CHANGE_CAMEL_COST.getDouble(), SpawnerMob.CAMEL),
	SNIFFER(Settings.MOB_CHANGE_SNIFFER_ENABLED.getBoolean(), Settings.MOB_CHANGE_SNIFFER_COST.getDouble(), SpawnerMob.SNIFFER),

	// 1.20.5  - 1.21
	ARMADILLO(Settings.MOB_CHANGE_ARMADILLO_ENABLED.getBoolean(), Settings.MOB_CHANGE_ARMADILLO_COST.getDouble(), SpawnerMob.ARMADILLO),
	BREEZE(Settings.MOB_CHANGE_BREEZE_ENABLED.getBoolean(), Settings.MOB_CHANGE_BREEZE_COST.getDouble(), SpawnerMob.BREEZE),
	BOGGED(Settings.MOB_CHANGE_BOGGED_ENABLED.getBoolean(), Settings.MOB_CHANGE_BOGGED_COST.getDouble(), SpawnerMob.BOGGED),

	// 1.21.4
	CREAKING(Settings.MOB_CHANGE_CREAKING_ENABLED.getBoolean(), Settings.MOB_CHANGE_CREAKING_COST.getDouble(), SpawnerMob.CREAKING),

	// 1.21.6/7
	HAPPY_GHAST(Settings.MOB_CHANGE_HAPPY_GHAST_ENABLED.getBoolean(), Settings.MOB_CHANGE_HAPPY_GHAST_COST.getDouble(), SpawnerMob.HAPPY_GHAST),

	// 1.21.9
	COPPER_GOLEM(Settings.MOB_CHANGE_COPPER_GOLEM_ENABLED.getBoolean(), Settings.MOB_CHANGE_COPPER_GOLEM_COST.getDouble(), SpawnerMob.COPPER_GOLEM),

	// 1.21.11
	NAUTILUS(Settings.MOB_CHANGE_NAUTILUS_ENABLED.getBoolean(), Settings.MOB_CHANGE_NAUTILUS_COST.getDouble(), SpawnerMob.NAUTILUS),
	ZOMBIE_NAUTILUS(Settings.MOB_CHANGE_ZOMBIE_NAUTILUS_ENABLED.getBoolean(), Settings.MOB_CHANGE_ZOMBIE_NAUTILUS_COST.getDouble(), SpawnerMob.ZOMBIE_NAUTILUS),

	// 26.3
	CAMEL_HUSK(Settings.MOB_CHANGE_CAMEL_HUSK_ENABLED.getBoolean(), Settings.MOB_CHANGE_CAMEL_HUSK_COST.getDouble(), SpawnerMob.CAMEL_HUSK),
	SULFUR_CUBE(Settings.MOB_CHANGE_SULFUR_CUBE_ENABLED.getBoolean(), Settings.MOB_CHANGE_SULFUR_CUBE_COST.getDouble(), SpawnerMob.SULFUR_CUBE),
	PARCHED(Settings.MOB_CHANGE_PARCHED_ENABLED.getBoolean(), Settings.MOB_CHANGE_PARCHED_COST.getDouble(), SpawnerMob.PARCHED),


	;

	private boolean enabled;
	private double cost;
	private SpawnerMob spawnerMob;
}
