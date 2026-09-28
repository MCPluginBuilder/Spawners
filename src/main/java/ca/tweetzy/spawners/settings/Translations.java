/*
 * Spawners
 * Copyright 2023 Kiran Hart
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

import ca.tweetzy.flight.settings.TranslationEntry;
import ca.tweetzy.flight.settings.TranslationManager;
import ca.tweetzy.spawners.Spawners;
import lombok.NonNull;
import org.bukkit.plugin.java.JavaPlugin;

public final class Translations extends TranslationManager {

	public Translations(@NonNull JavaPlugin plugin) {
		super(plugin);
		this.mainLanguage = Settings.LANGUAGE.getString();
	}


	public static void init() {
		new Translations(Spawners.getInstance()).setup(Spawners.getInstance());
	}

	/*
============= misc =============
 */
	public static final TranslationEntry MISC_IS_ALLOWED = create("conditionals.is allowed", "&aAllowed");
	public static final TranslationEntry MISC_IS_DISALLOWED = create("conditionals.is disallowed", "&cDisallowed");
	public static final TranslationEntry NOT_ENOUGH_MONEY = create("misc.not enough money", "&cYou do not have enough money!");
	public static final TranslationEntry NOT_A_NUMBER = create("misc.not a number", "&cThat is not a valid number");
	public static final TranslationEntry PLAYER_OFFLINE = create("misc.player not found", "&cThe player &4%player% &cis not online!");
	public static final TranslationEntry MONEY_REMOVE = create("misc.money remove", "&c&l- $%amount%");
	public static final TranslationEntry REMOVED_ENTITIES_ALL = create("misc.entity remove.all", "&cRemoved a total of &4%total% &cspawner mobs.");
	public static final TranslationEntry REMOVED_ENTITIES_ENTITY = create("misc.entity remove.entity", "&cRemoved a total of &4%total% %entity_type% &cspawner mobs.");
	public static final TranslationEntry NO_PRESETS_MADE = create("misc.no presets made", "&cThere are no presets currently made.");
	public static final TranslationEntry NO_INVENTORY_SPACE = create("misc.no inventory space", "&cYou do not have enough inventory space.");

	public static final TranslationEntry NOT_A_SPAWNER = create("misc.not a spawner", "&cThat block is not a spawner!");
	public static final TranslationEntry UPDATED_SPAWN_TYPE = create("misc.updated spawn type", "&aSuccessfully set spawner's entity type to&f: &e%entity_type%");
	public static final TranslationEntry PRESET_ID_TAKEN = create("misc.preset id taken", "&cThe preset id&f: &4%preset_id% &cis already in use.");
	public static final TranslationEntry NEED_TO_MAKE_LEVELS = create("misc.need to create levels", "&cYou need to create 1 level for each upgrade first.");
	public static final TranslationEntry SPAWNER_CHUNK_LIMIT_REACHED = create("misc.spawner per chunk limit reached", "&cYou cannot place anymore spawners within this chunk!");
	public static final TranslationEntry SPAWNER_PLACE_LIMIT_REACHED = create("misc.spawner place limit reached", "&cYou cannot place anymore spawners!");


	public static final TranslationEntry ADMIN_MODE_ENABLED = create("misc.admin mode.enabled", "&aAdmin mode enabled, you can now freely break player spawners");
	public static final TranslationEntry ADMIN_MODE_DISABLED = create("misc.admin mode.disabled", "&cAdmin mode is now disabled.");

	public static TranslationEntry GUI_SHARED_ITEMS_BACK_BUTTON_NAME = create("gui.shared buttons.back button.name", "<GRADIENT:65B1B4>&LGo Back</GRADIENT:2B6F8A>");
	public static TranslationEntry GUI_SHARED_ITEMS_BACK_BUTTON_LORE = create("gui.shared buttons.back button.lore",
			"&e&l%left_click% &7to go back"
	);

	public static TranslationEntry GUI_SHARED_ITEMS_EXIT_BUTTON_NAME = create("gui.shared buttons.exit button.name", "<GRADIENT:65B1B4>&LExit</GRADIENT:2B6F8A>");
	public static TranslationEntry GUI_SHARED_ITEMS_EXIT_BUTTON_LORE = create("gui.shared buttons.exit button.lore",
			"&e&l%left_click% &7to exit menu"
	);

	public static TranslationEntry GUI_SHARED_ITEMS_PREVIOUS_BUTTON_NAME = create("gui.shared buttons.previous button.name", "<GRADIENT:65B1B4>&lPrevious Page</GRADIENT:2B6F8A>");
	public static TranslationEntry GUI_SHARED_ITEMS_PREVIOUS_BUTTON_LORE = create("gui.shared buttons.previous button.lore",
			"&e&l%left_click% &7to go back a page"
	);

	public static TranslationEntry GUI_SHARED_ITEMS_NEXT_BUTTON_NAME = create("gui.shared buttons.next button.name", "<GRADIENT:65B1B4>&lNext Page</GRADIENT:2B6F8A>");
	public static TranslationEntry GUI_SHARED_ITEMS_NEXT_BUTTON_LORE = create("gui.shared buttons.next button.lore",
			"&e&l%left_click% &7to go to next page"
	);

	public static final TranslationEntry MOB_NAME_ALLAY = create("mob names.allay", "Allay");
	public static final TranslationEntry MOB_NAME_FROG = create("mob names.frog", "Frog");
	public static final TranslationEntry MOB_NAME_TADPOLE = create("mob names.tadpole", "Tadpole");
	public static final TranslationEntry MOB_NAME_WARDEN = create("mob names.warden", "Warden");
	public static final TranslationEntry MOB_NAME_ELDER_GUARDIAN = create("mob names.elder guardian", "Elder guardian");
	public static final TranslationEntry MOB_NAME_WITHER_SKELETON = create("mob names.wither skeleton", "Wither skeleton");
	public static final TranslationEntry MOB_NAME_STRAY = create("mob names.stray", "Stray");
	public static final TranslationEntry MOB_NAME_HUSK = create("mob names.husk", "Husk");
	public static final TranslationEntry MOB_NAME_ZOMBIE_VILLAGER = create("mob names.zombie villager", "Zombie villager");
	public static final TranslationEntry MOB_NAME_SKELETON_HORSE = create("mob names.skeleton horse", "Skeleton horse");
	public static final TranslationEntry MOB_NAME_ZOMBIE_HORSE = create("mob names.zombie horse", "Zombie horse");
	public static final TranslationEntry MOB_NAME_DONKEY = create("mob names.donkey", "Donkey");
	public static final TranslationEntry MOB_NAME_MULE = create("mob names.mule", "Mule");
	public static final TranslationEntry MOB_NAME_EVOKER = create("mob names.evoker", "Evoker");
	public static final TranslationEntry MOB_NAME_VEX = create("mob names.vex", "Vex");
	public static final TranslationEntry MOB_NAME_VINDICATOR = create("mob names.vindicator", "Vindicator");
	public static final TranslationEntry MOB_NAME_ILLUSIONER = create("mob names.illusioner", "Illusioner");
	public static final TranslationEntry MOB_NAME_CREEPER = create("mob names.creeper", "Creeper");
	public static final TranslationEntry MOB_NAME_SKELETON = create("mob names.skeleton", "Skeleton");
	public static final TranslationEntry MOB_NAME_SPIDER = create("mob names.spider", "Spider");
	public static final TranslationEntry MOB_NAME_GIANT = create("mob names.giant", "Giant");
	public static final TranslationEntry MOB_NAME_ZOMBIE = create("mob names.zombie", "Zombie");
	public static final TranslationEntry MOB_NAME_SLIME = create("mob names.slime", "Slime");
	public static final TranslationEntry MOB_NAME_GHAST = create("mob names.ghast", "Ghast");
	public static final TranslationEntry MOB_NAME_ZOMBIFIED_PIGLIN = create("mob names.zombified piglin", "Zombified piglin");
	public static final TranslationEntry MOB_NAME_ENDERMAN = create("mob names.enderman", "Enderman");
	public static final TranslationEntry MOB_NAME_CAVE_SPIDER = create("mob names.cave spider", "Cave spider");
	public static final TranslationEntry MOB_NAME_SILVERFISH = create("mob names.silverfish", "Silverfish");
	public static final TranslationEntry MOB_NAME_BLAZE = create("mob names.blaze", "Blaze");
	public static final TranslationEntry MOB_NAME_MAGMA_CUBE = create("mob names.magma cube", "Magma cube");
	public static final TranslationEntry MOB_NAME_ENDER_DRAGON = create("mob names.ender dragon", "Ender dragon");
	public static final TranslationEntry MOB_NAME_WITHER = create("mob names.wither", "Wither");
	public static final TranslationEntry MOB_NAME_BAT = create("mob names.bat", "Bat");
	public static final TranslationEntry MOB_NAME_WITCH = create("mob names.witch", "Witch");
	public static final TranslationEntry MOB_NAME_ENDERMITE = create("mob names.endermite", "Endermite");
	public static final TranslationEntry MOB_NAME_GUARDIAN = create("mob names.guardian", "Guardian");
	public static final TranslationEntry MOB_NAME_SHULKER = create("mob names.shulker", "Shulker");
	public static final TranslationEntry MOB_NAME_PIG = create("mob names.pig", "Pig");
	public static final TranslationEntry MOB_NAME_SHEEP = create("mob names.sheep", "Sheep");
	public static final TranslationEntry MOB_NAME_COW = create("mob names.cow", "Cow");
	public static final TranslationEntry MOB_NAME_CHICKEN = create("mob names.chicken", "Chicken");
	public static final TranslationEntry MOB_NAME_SQUID = create("mob names.squid", "Squid");
	public static final TranslationEntry MOB_NAME_WOLF = create("mob names.wolf", "Wolf");
	public static final TranslationEntry MOB_NAME_MUSHROOM_COW = create("mob names.mushroom cow", "Mushroom cow");
	public static final TranslationEntry MOB_NAME_SNOWMAN = create("mob names.snowman", "Snowman");
	public static final TranslationEntry MOB_NAME_OCELOT = create("mob names.ocelot", "Ocelot");
	public static final TranslationEntry MOB_NAME_IRON_GOLEM = create("mob names.iron golem", "Iron golem");
	public static final TranslationEntry MOB_NAME_HORSE = create("mob names.horse", "Horse");
	public static final TranslationEntry MOB_NAME_RABBIT = create("mob names.rabbit", "Rabbit");
	public static final TranslationEntry MOB_NAME_POLAR_BEAR = create("mob names.polar bear", "Polar bear");
	public static final TranslationEntry MOB_NAME_LLAMA = create("mob names.llama", "Llama");
	public static final TranslationEntry MOB_NAME_PARROT = create("mob names.parrot", "Parrot");
	public static final TranslationEntry MOB_NAME_VILLAGER = create("mob names.villager", "Villager");
	public static final TranslationEntry MOB_NAME_TURTLE = create("mob names.turtle", "Turtle");
	public static final TranslationEntry MOB_NAME_PHANTOM = create("mob names.phantom", "Phantom");
	public static final TranslationEntry MOB_NAME_COD = create("mob names.cod", "Cod");
	public static final TranslationEntry MOB_NAME_SALMON = create("mob names.salmon", "Salmon");
	public static final TranslationEntry MOB_NAME_PUFFERFISH = create("mob names.pufferfish", "Pufferfish");
	public static final TranslationEntry MOB_NAME_TROPICAL_FISH = create("mob names.tropical fish", "Tropical fish");
	public static final TranslationEntry MOB_NAME_DROWNED = create("mob names.drowned", "Drowned");
	public static final TranslationEntry MOB_NAME_DOLPHIN = create("mob names.dolphin", "Dolphin");
	public static final TranslationEntry MOB_NAME_CAT = create("mob names.cat", "Cat");
	public static final TranslationEntry MOB_NAME_PANDA = create("mob names.panda", "Panda");
	public static final TranslationEntry MOB_NAME_PILLAGER = create("mob names.pillager", "Pillager");
	public static final TranslationEntry MOB_NAME_RAVAGER = create("mob names.ravager", "Ravager");
	public static final TranslationEntry MOB_NAME_TRADER_LLAMA = create("mob names.trader llama", "Trader llama");
	public static final TranslationEntry MOB_NAME_WANDERING_TRADER = create("mob names.wandering trader", "Wandering trader");
	public static final TranslationEntry MOB_NAME_FOX = create("mob names.fox", "Fox");
	public static final TranslationEntry MOB_NAME_BEE = create("mob names.bee", "Bee");
	public static final TranslationEntry MOB_NAME_HOGLIN = create("mob names.hoglin", "Hoglin");
	public static final TranslationEntry MOB_NAME_PIGLIN = create("mob names.piglin", "Piglin");
	public static final TranslationEntry MOB_NAME_STRIDER = create("mob names.strider", "Strider");
	public static final TranslationEntry MOB_NAME_ZOGLIN = create("mob names.zoglin", "Zoglin");
	public static final TranslationEntry MOB_NAME_PIGLIN_BRUTE = create("mob names.piglin brute", "Piglin brute");
	public static final TranslationEntry MOB_NAME_AXOLOTL = create("mob names.axolotl", "Axolotl");
	public static final TranslationEntry MOB_NAME_GLOW_SQUID = create("mob names.glow squid", "Glow squid");
	public static final TranslationEntry MOB_NAME_GOAT = create("mob names.goat", "Goat");
	public static final TranslationEntry MOB_NAME_CAMEL = create("mob names.camel", "Camel");
	public static final TranslationEntry MOB_NAME_SNIFFER = create("mob names.sniffer", "Sniffer");
	public static final TranslationEntry MOB_NAME_ARMADILLO = create("mob names.armadillo", "Armadillo");
	public static final TranslationEntry MOB_NAME_HAPPY_GHAST = create("mob names.happy ghast", "Happy Ghast");
	public static final TranslationEntry MOB_NAME_BREEZE = create("mob names.breeze", "Breeze");
	public static final TranslationEntry MOB_NAME_BOGGED = create("mob names.bogged", "Bogged");
	public static final TranslationEntry MOB_NAME_CREAKING = create("mob names.creaking", "Creaking");
	public static final TranslationEntry MOB_NAME_COPPER_GOLEM = create("mob names.copper golem", "Copper Golem");
	public static final TranslationEntry MOB_NAME_NAUTILUS = create("mob names.nautilus", "Nautilus");
	public static final TranslationEntry MOB_NAME_ZOMBIE_NAUTILUS = create("mob names.zombie nautilus", "Zombie Nautilus");

	public static final TranslationEntry MOB_NAME_PARCHED = create("mob names.parched", "Parched");
	public static final TranslationEntry MOB_NAME_CAMEL_HUSK = create("mob names.camel husk", "Camel Husk");
	public static final TranslationEntry MOB_NAME_SULFUR_CUBE = create("mob names.sulfur cube", "Sulfur Cube");


	public static final TranslationEntry SPAWNER_NO_OWNER = create("spawner.no owner", "No Owner");
	public static final TranslationEntry SPAWNER_REQUIRE_SILK = create("spawner.requires silk touch", "&cYou need silk touch to mine spawners!");
	public static final TranslationEntry SPAWNER_REQUIRE_PICKAXE = create("spawner.requires pickaxe", "&cYou need a pickaxe to mine spawners!");
	public static final TranslationEntry SPAWNER_NOT_OWNER = create("spawner.not owner.overview", "&cYou are not the owner of this spawner!");

	// spawner error
	public static final TranslationEntry SPAWNER_NOT_OWNER_PLACE = create("spawner.not owner.place", "&cYou are not allowed to place &4%owner_name%&c's spawner!");
	public static final TranslationEntry SPAWNER_NOT_OWNER_BREAK = create("spawner.not owner.break", "&cYou are not allowed to break &4%owner_name%&c's spawner!");
	public static final TranslationEntry SPAWNER_NOT_OWNER_CHANGE_WITH_EGG = create("spawner.not owner.egg change", "&cYou cannot use eggs &4%owner_name%&c's spawner!");
	public static final TranslationEntry SPAWNER_CANNOT_PLACE_ENTITY = create("spawner.entity permission.place", "&cYou are not allowed to place &4%entity_type%&c spawners!");
	public static final TranslationEntry SPAWNER_CANNOT_BREAK_ENTITY = create("spawner.entity permission.break", "&cYou are not allowed to break &4%entity_type%&c spawners!");
	public static final TranslationEntry SPAWNER_CANNOT_CHANGE_WITH_EGG = create("spawner.entity permission.egg change", "&cYou cannot change spawners with &4%entity_type%&c eggs!");
	public static final TranslationEntry SPAWNER_RECEIVED_OWNERSHIP = create("spawner.received ownership", "&2%player_name% &Agave you ownership of their spawner");
	public static final TranslationEntry SPAWNER_GAVE_OWNERSHIP = create("spawner.gave ownership", "&aYou transferred ownership to &2%player_name%");

	public static final TranslationEntry SPAWNER_MAX_DELAY = create("spawner.upgrade.max.delay", "&cThe spawner is already at the max spawn delay");
	public static final TranslationEntry SPAWNER_MAX_SPAWN_COUNT = create("spawner.upgrade.max.spawn count", "&cThe spawner is already at the max spawn count");
	public static final TranslationEntry SPAWNER_MAX_NEARBY_MOBS = create("spawner.upgrade.max.nearby mobs", "&cThe spawner is already at the max nearby mobs");
	public static final TranslationEntry SPAWNER_MAX_ACTIVATION_RANGE = create("spawner.upgrade.max.activation range", "&cThe spawner is already at the max activation range");

	public static final TranslationEntry SPAWNER_UPGRADED_DELAY = create("spawner.upgrade.upgraded.delay", "&aUpgraded delay from level &F%previous_level% &ato &f%current_level%");
	public static final TranslationEntry SPAWNER_UPGRADED_SPAWN_COUNT = create("spawner.upgrade.upgraded.spawn count", "&aUpgraded spawn count from level &F%previous_level% &ato &f%current_level%");
	public static final TranslationEntry SPAWNER_UPGRADED_NEARBY_MOBS = create("spawner.upgrade.upgraded.nearby mobs", "&aUpgraded max nearby mobs from level &F%previous_level% &ato &f%current_level%");
	public static final TranslationEntry SPAWNER_UPGRADED_ACTIVATION_RANGE = create("spawner.upgrade.upgraded.activation range", "&aUpgraded activation range from level &F%previous_level% &ato &f%current_level%");
	public static final TranslationEntry SPAWNER_UPGRADED_ENTITY_TYPE = create("spawner.upgrade.upgraded.entity type", "&aSuccessfully converted spawner mob to&f: &f%entity_type%");

	public static final TranslationEntry NOT_ALLOWED_TO_THROW_EGG = create("no egg throw permission", "&cYou are not allowed to throw &4%entity_type%&c eggs!");

	/*
	============= spawner =============
	 */
	public static final TranslationEntry SPAWNER_NAME = create("spawner.name", "&e%entity_type% Spawner");
	public static final TranslationEntry SPAWNER_LORE = create("spawner.lore", "&8Owner", "&e%spawner_owner_name%", "", "&7Spawn Delay &8» &e%spawner_spawn_delay_level%", "&7Spawn Count &8» &e%spawner_spawn_count_level%", "&7Max Nearby Entities &8» &e%spawner_max_nearby_entities_level%", "&7Activation Range &8» &e%spawner_player_activation_range_level%", "", "&e&lPlace &8» &7To activate spawner");


	/*
	============= guis =============
	 */


	// PLAYER GUIS
	public static final TranslationEntry GUI_MAIN_TITLE = create("gui.main.title", "<GRADIENT:fc67fa>&lSpawners</GRADIENT:f4c4f3>");
	public static final TranslationEntry GUI_MAIN_ITEMS_YOUR_SPAWNERS_NAME = create("gui.main.items.your spawners.name", "<GRADIENT:fc67fa>&lYour Spawners</GRADIENT:f4c4f3>");
	public static final TranslationEntry GUI_MAIN_ITEMS_YOUR_SPAWNERS_LORE = create("gui.main.items.your spawners.lore", "", "&7Total&f: &e%total_placed_spawners%", "", "&e&lClick &8» &7To view placed spawners");

	public static final TranslationEntry GUI_MAIN_ITEMS_SHOP_NAME = create("gui.main.items.shop.name", "<GRADIENT:fc67fa>&lSpawner Shop</GRADIENT:f4c4f3>");
	public static final TranslationEntry GUI_MAIN_ITEMS_SHOP_LORE = create("gui.main.items.shop.lore", "", "&e&lClick &8» &7To view shop");

	public static final TranslationEntry GUI_SPAWNER_SHOP_TITLE = create("gui.spawner shop.title", "<GRADIENT:fc67fa>&lSpawner Shop</GRADIENT:f4c4f3>");
	public static final TranslationEntry GUI_SPAWNER_SHOP_ITEMS_SPAWNER_NAME = create("gui.spawner shop.items.spawner.name", "<GRADIENT:fc67fa>&l%entity_type% Spawner</GRADIENT:f4c4f3>");
	public static final TranslationEntry GUI_SPAWNER_SHOP_ITEMS_SPAWNER_LORE = create("gui.spawner shop.items.spawner.lore", "", "&7Price&f: &a%shop_item_price%", "&7Quantity&f: &a%shop_item_qty%", "", "&e&lLevels", "    &7Spawn Delay&f: &a%spawn_delay_level% &f(&e%spawn_delay%&as&f)", "    &7Spawn Count&f: &a%spawn_count_level% &f(&e%spawn_count%&f)", "    &7Max Nearby Mobs&f: &a%max_nearby_entities_level% &f(&e%max_nearby_entities%&f)", "    &7Activation Range&f: &a%activation_range_level% &f(&e%activation_range%&f)", "", "&e&lClick &8» &7To purchase item");

	public static final TranslationEntry GUI_YOUR_SPAWNERS_TITLE = create("gui.your spawners.title", "<GRADIENT:fc67fa>&lSpawners</GRADIENT:f4c4f3> &8> &7Your Spawners");
	public static final TranslationEntry GUI_YOUR_SPAWNERS_ITEMS_SPAWNER_NAME = create("gui.your spawners.items.spawner.name", "<GRADIENT:fc67fa>&lSpawner</GRADIENT:f4c4f3>");
	public static final TranslationEntry GUI_YOUR_SPAWNERS_ITEMS_SPAWNER_LORE = create("gui.your spawners.items.spawner.lore", "", "&e&lLocation", "    &7%world_name% &F/ &7%world_x% &f/ &7%world_y% &f/ &7%world_z%", "", "&e&lLevels", "    &7Spawn Delay&f: &a%spawn_delay_level% &f(&e%spawn_delay%&as&f)", "    &7Spawn Count&f: &a%spawn_count_level% &f(&e%spawn_count%&f)", "    &7Max Nearby Mobs&f: &a%max_nearby_entities_level% &f(&e%max_nearby_entities%&f)", "    &7Activation Range&f: &a%activation_range_level% &f(&e%activation_range%&f)", "");

	public static final TranslationEntry GUI_SPAWNER_MERGE_TITLE = create("gui.spawner merge.title", "<GRADIENT:fc67fa>&lSpawner</GRADIENT:f4c4f3> &8> &7Merge");

	public static final TranslationEntry GUI_SPAWNER_MERGE_ITEMS_RING_STATUS_WAIT = create("gui.spawner merge.items.status.wait", "&f&lPlace spawner in center");
	public static final TranslationEntry GUI_SPAWNER_MERGE_ITEMS_RING_STATUS_READY = create("gui.spawner merge.items.status.ready", "&a&lReady to begin merge");
	public static final TranslationEntry GUI_SPAWNER_MERGE_ITEMS_RING_STATUS_INVALID = create("gui.spawner merge.items.status.invalid", "&c&lMerge not possible");

	public static final TranslationEntry GUI_SPAWNER_MERGE_ITEMS_RING_STATUS_MAX = create("gui.spawner merge.items.status.maxed out", "&c&lSpawner Maxed Out");

	public static final TranslationEntry GUI_SPAWNER_MERGE_ITEMS_CONFIRM_BTN_NAME = create("gui.spawner merge.items.confirm.name", "&a&lConfirm Merge");
	public static final TranslationEntry GUI_SPAWNER_MERGE_ITEMS_CONFIRM_BTN_LORE = create("gui.spawner merge.items.confirm.lore", "", "&e&lClick &8» &7To merge levels");

	public static final TranslationEntry GUI_SPAWNER_MERGE_OR_SPLIT_TITLE = create("gui.spawner merge or split.title", "<GRADIENT:fc67fa>&lSpawner</GRADIENT:f4c4f3> &8> &7Merge or Split?");

	public static final TranslationEntry GUI_SPAWNER_MERGE_OR_SPLIT_ITEMS_MERGE_NAME = create("gui.spawner merge or split.items.merge.name", "<GRADIENT:fc67fa>&lMerge</GRADIENT:f4c4f3>");
	public static final TranslationEntry GUI_SPAWNER_MERGE_OR_SPLIT_ITEMS_MERGE_LORE = create("gui.spawner merge or split.items.merge.lore", "", "&e&lClick &8» &7To merge with another spawner");

	public static final TranslationEntry GUI_SPAWNER_MERGE_OR_SPLIT_ITEMS_SPLIT_NAME = create("gui.spawner merge or split.items.split.name", "<GRADIENT:fc67fa>&lSplit</GRADIENT:f4c4f3>");
	public static final TranslationEntry GUI_SPAWNER_MERGE_OR_SPLIT_ITEMS_SPLIT_LORE = create("gui.spawner merge or split.items.split.lore", "", "&e&lClick &8» &7To split spawner levels");

	public static final TranslationEntry GUI_SPAWNER_SPLIT_TITLE = create("gui.spawner split.title", "<GRADIENT:fc67fa>&lSpawner</GRADIENT:f4c4f3> &8> &7Split Levels");
	public static final TranslationEntry GUI_SPAWNER_SPLIT_ITEMS_DECREASE_NAME = create("gui.spawner split.items.decrease.name", "&c&lDecrease");
	public static final TranslationEntry GUI_SPAWNER_SPLIT_ITEMS_DECREASE_LORE = create("gui.spawner split.items.decrease.lore", "", "&e&lClick &8» &7To decrease amount");

	public static final TranslationEntry GUI_SPAWNER_SPLIT_ITEMS_INCREASE_NAME = create("gui.spawner split.items.increase.name", "&a&lIncrease");
	public static final TranslationEntry GUI_SPAWNER_SPLIT_ITEMS_INCREASE_LORE = create("gui.spawner split.items.increase.lore", "", "&e&lClick &8» &7To increase amount");


	public static final TranslationEntry GUI_SPAWNER_SPLIT_ITEMS_DELAY_NAME = create("gui.spawner split.items.delay.name", "<GRADIENT:fc67fa>&lSpawn Delay</GRADIENT:f4c4f3>");
	public static final TranslationEntry GUI_SPAWNER_SPLIT_ITEMS_DELAY_LORE = create("gui.spawner split.items.delay.lore", "", "&7Current&f: &e%current_split_amount%", "&7Available&f: &e%available_split_amount%", "");

	public static final TranslationEntry GUI_SPAWNER_SPLIT_ITEMS_SPAWN_COUNT_NAME = create("gui.spawner split.items.spawn count.name", "<GRADIENT:fc67fa>&lSpawn Count</GRADIENT:f4c4f3>");
	public static final TranslationEntry GUI_SPAWNER_SPLIT_ITEMS_SPAWN_COUNT_LORE = create("gui.spawner split.items.spawn count.lore", "", "&7Current&f: &e%current_split_amount%", "&7Available&f: &e%available_split_amount%", "");

	public static final TranslationEntry GUI_SPAWNER_SPLIT_ITEMS_NEARBY_MOBS_NAME = create("gui.spawner split.items.nearby mobs.name", "<GRADIENT:fc67fa>&lMax Nearby Mobs</GRADIENT:f4c4f3>");
	public static final TranslationEntry GUI_SPAWNER_SPLIT_ITEMS_NEARBY_MOBS_LORE = create("gui.spawner split.items.nearby mobs.lore", "", "&7Current&f: &e%current_split_amount%", "&7Available&f: &e%available_split_amount%", "");

	public static final TranslationEntry GUI_SPAWNER_SPLIT_ITEMS_ACTIVATION_RANGE_NAME = create("gui.spawner split.items.activation range.name", "<GRADIENT:fc67fa>&lActivation Range</GRADIENT:f4c4f3>");
	public static final TranslationEntry GUI_SPAWNER_SPLIT_ITEMS_ACTIVATION_RANGE_LORE = create("gui.spawner split.items.activation range.lore", "", "&7Current&f: &e%current_split_amount%", "&7Available&f: &e%available_split_amount%", "");

	public static final TranslationEntry GUI_SPAWNER_SPLIT_ITEMS_CONFIRM_NAME = create("gui.spawner split.items.confirm.name", "&a&lConfirm Split");
	public static final TranslationEntry GUI_SPAWNER_SPLIT_ITEMS_CONFIRM_LORE = create("gui.spawner split.items.confirm.lore", "", "&e&lClick &8» &7To split levels");

	public static final TranslationEntry GUI_SPAWNER_SPLIT_ITEMS_INVALID_NAME = create("gui.spawner split.items.invalid.name", "&c&lNot Enough Levels");
	public static final TranslationEntry GUI_SPAWNER_SPLIT_ITEMS_INVALID_LORE = create("gui.spawner split.items.invalid.lore", "", "&cYou cannot split anymore levels from this", "&cspawner as it requires at least 2 levels.");

	public static final TranslationEntry GUI_SPAWNER_OVERVIEW_TITLE = create("gui.spawner overview.title", "<GRADIENT:fc67fa>&lSpawner</GRADIENT:f4c4f3> &8> &7Overview");
	public static final TranslationEntry GUI_SPAWNER_OVERVIEW_ITEMS_ENTITY_NAME = create("gui.spawner overview.items.entity.name", "<GRADIENT:fc67fa>&lEntity Type</GRADIENT:f4c4f3>");
	public static final TranslationEntry GUI_SPAWNER_OVERVIEW_ITEMS_ENTITY_LORE = create("gui.spawner overview.items.entity.lore", "", "&7Current&f: &e%entity_type%", "", "&e&lClick &8» &7To change entity");

	public static final TranslationEntry GUI_SPAWNER_OVERVIEW_ITEMS_MERGE_NAME = create("gui.spawner overview.items.merge.name", "<GRADIENT:fc67fa>&lMerge/Split Spawner</GRADIENT:f4c4f3>");
	public static final TranslationEntry GUI_SPAWNER_OVERVIEW_ITEMS_MERGE_LORE = create("gui.spawner overview.items.merge.lore", "", "&7Used to merge another spawner item", "&7levels into this spawner. Or to split", "&7current levels into a new spawner", "", "&e&lClick &8» &7To merge/split spawner");

	public static final TranslationEntry GUI_SPAWNER_OVERVIEW_ITEMS_UPGRADE_DISABLED_NAME = create("gui.spawner overview.items.upgrade disabled.name", "&C&LUpgrade Disabled");
	public static final TranslationEntry GUI_SPAWNER_OVERVIEW_ITEMS_UPGRADE_DISABLED_LORE = create("gui.spawner overview.items.upgrade disabled.lore", "&cYou are not allowed to upgrade", "&cthis particular spawner!");


	public static final TranslationEntry GUI_SPAWNER_OVERVIEW_ITEMS_OWNER_NAME = create("gui.spawner overview.items.owner.name", "<GRADIENT:fc67fa>&lOwner</GRADIENT:f4c4f3>");
	public static final TranslationEntry GUI_SPAWNER_OVERVIEW_ITEMS_OWNER_LORE = create("gui.spawner overview.items.owner.lore", "", "&7Current&f: &e%owner_name%", "", "&e&lClick &8» &7To transfer ownership");

	public static final TranslationEntry GUI_SPAWNER_OVERVIEW_ITEMS_DELAY_LEVEL_NAME = create("gui.spawner overview.items.delay.name", "<GRADIENT:fc67fa>&lSpawn Delay</GRADIENT:f4c4f3>");
	public static final TranslationEntry GUI_SPAWNER_OVERVIEW_ITEMS_DELAY_LEVEL_LORE = create("gui.spawner overview.items.delay.lore", "", "&7Current&f: &a%level_number% &f(&e%level_value%&as&f)", "", "&e&lNext Level", "    &7Level&f: &a%next_level_number% &f(&e%next_level_value%&as&f)", "    &7Cost&f: &a$%level_upgrade_cost%", "", "&e&lClick &8» &7To upgrade");
	public static final TranslationEntry GUI_SPAWNER_OVERVIEW_ITEMS_DELAY_LEVEL_LORE_MAX = create("gui.spawner overview.items.delay.lore max", "", "&aSpawner delay is at max level!", "");

	public static final TranslationEntry GUI_SPAWNER_OVERVIEW_ITEMS_SPAWN_COUNT_LEVEL_NAME = create("gui.spawner overview.items.spawn count.name", "<GRADIENT:fc67fa>&lSpawn Count</GRADIENT:f4c4f3>");
	public static final TranslationEntry GUI_SPAWNER_OVERVIEW_ITEMS_SPAWN_COUNT_LEVEL_LORE = create("gui.spawner overview.items.spawn count.lore", "", "&7Current&f: &a%level_number% &f(&e%level_value%&f)", "", "&e&lNext Level", "    &7Level&f: &a%next_level_number% &f(&e%next_level_value%&f)", "    &7Cost&f: &a$%level_upgrade_cost%", "", "&e&lClick &8» &7To upgrade");
	public static final TranslationEntry GUI_SPAWNER_OVERVIEW_ITEMS_SPAWN_COUNT_LEVEL_LORE_MAX = create("gui.spawner overview.items.spawn count.lore max", "", "&aSpawn count is at max level!", "");

	public static final TranslationEntry GUI_SPAWNER_OVERVIEW_ITEMS_MAX_NEARBY_LEVEL_NAME = create("gui.spawner overview.items.max nearby mobs.name", "<GRADIENT:fc67fa>&lMax Nearby Mobs</GRADIENT:f4c4f3>");
	public static final TranslationEntry GUI_SPAWNER_OVERVIEW_ITEMS_MAX_NEARBY_LEVEL_LORE = create("gui.spawner overview.items.max nearby mobs.lore", "", "&7Current&f: &a%level_number% &f(&e%level_value%&f)", "", "&e&lNext Level", "    &7Level&f: &a%next_level_number% &f(&e%next_level_value%&f)", "    &7Cost&f: &a$%level_upgrade_cost%", "", "&e&lClick &8» &7To upgrade");
	public static final TranslationEntry GUI_SPAWNER_OVERVIEW_ITEMS_MAX_NEARBY_LEVEL_LORE_MAX = create("gui.spawner overview.items.max nearby mobs.lore max", "", "&aMax nearby mobs is at max level!", "");

	public static final TranslationEntry GUI_SPAWNER_OVERVIEW_ITEMS_ACTIVATION_RANGE_LEVEL_NAME = create("gui.spawner overview.items.activation range.name", "<GRADIENT:fc67fa>&lActivation Range</GRADIENT:f4c4f3>");
	public static final TranslationEntry GUI_SPAWNER_OVERVIEW_ITEMS_ACTIVATION_RANGE_LEVEL_LORE = create("gui.spawner overview.items.activation range.lore", "", "&7Current&f: &a%level_number% &f(&e%level_value%&f)", "", "&e&lNext Level", "    &7Level&f: &a%next_level_number% &f(&e%next_level_value%&f)", "    &7Cost&f: &a$%level_upgrade_cost%", "", "&e&lClick &8» &7To upgrade");
	public static final TranslationEntry GUI_SPAWNER_OVERVIEW_ITEMS_ACTIVATION_RANGE_LEVEL_LORE_MAX = create("gui.spawner overview.items.activation range.lore max", "", "&aActivation range is at max level!", "");

	public static final TranslationEntry GUI_ENTITY_CHANGE_TITLE = create("gui.entity change.title", "<GRADIENT:fc67fa>&lSpawners</GRADIENT:f4c4f3> &8> &7Change Mob");
	public static final TranslationEntry GUI_ENTITY_CHANGE_ITEMS_ENTITY_NAME = create("gui.entity change.items.entity.name", "<GRADIENT:fc67fa>&l%entity_name%</GRADIENT:f4c4f3>");
	public static final TranslationEntry GUI_ENTITY_CHANGE_ITEMS_ENTITY_LORE = create("gui.entity change.items.entity.lore", "", "&7Cost&f: &a$%entity_cost%", "", "&e&lClick &8» &7To select entity");

	public static final TranslationEntry GUI_PLAYER_SELECT_TITLE = create("gui.player select.title", "<GRADIENT:fc67fa>&lSpawners</GRADIENT:f4c4f3> &8> &7Select Player");
	public static final TranslationEntry GUI_PLAYER_SELECT_ITEMS_PLAYER_NAME = create("gui.player select.items.player.name", "<GRADIENT:fc67fa>&l%player_name%</GRADIENT:f4c4f3>");
	public static final TranslationEntry GUI_PLAYER_SELECT_ITEMS_PLAYER_LORE = create("gui.player select.items.player.lore", "", "&e&lClick &8» &7To select player");

	public static final TranslationEntry GUI_CONFIRM_TITLE = create("gui.confirm.title", "<GRADIENT:fc67fa>&lSpawners</GRADIENT:f4c4f3> &8> &7Confirm");
	public static final TranslationEntry GUI_CONFIRM_ITEMS_CANCEL_NAME = create("gui.confirm.items.cancel.name", "&c&lCancel");
	public static final TranslationEntry GUI_CONFIRM_ITEMS_CANCEL_LORE = create("gui.confirm.items.cancel.lore", "", "&c&lClick &8» &7To cancel action");
	public static final TranslationEntry GUI_CONFIRM_ITEMS_CONFIRM_NAME = create("gui.confirm.items.confirm.name", "&A&LConfirm");
	public static final TranslationEntry GUI_CONFIRM_ITEMS_CONFIRM_LORE = create("gui.confirm.items.confirm.lore", "", "&e&lClick &8» &7To confirm action", "&c(This cannot be undone)");

	// ADMIN GUIS

	public static final TranslationEntry GUI_ENTITY_SELECTOR_TITLE = create("gui.entity selector.title", "<GRADIENT:fc67fa>&lSpawners</GRADIENT:f4c4f3> &8> &7Select Entity");
	public static final TranslationEntry GUI_ENTITY_SELECTOR_ITEMS_ENTITY_NAME = create("gui.entity selector.items.entity.name", "<GRADIENT:fc67fa>&l%entity_name%</GRADIENT:f4c4f3>");
	public static final TranslationEntry GUI_ENTITY_SELECTOR_ITEMS_ENTITY_LORE = create("gui.entity selector.items.entity.lore", "", "&e&lClick &8» &7To select entity");

	public static final TranslationEntry GUI_ENTITY_SELECTOR_ITEMS_MODE_NAME = create("gui.entity selector.items.mode.name", "&a&lSwitch Mode");
	public static final TranslationEntry GUI_ENTITY_SELECTOR_ITEMS_MODE_LORE = create("gui.entity selector.items.mode.lore", "&8Entity Behaviour", "", "&7Current&f: &e%entity_behaviour%", "", "&e&lClick &8» &7To switch mode");

	public static final TranslationEntry GUI_ADMIN_MAIN_TITLE = create("gui.admin main.title", "<GRADIENT:fc67fa>&LSpawners</GRADIENT:f4c4f3> &7v%plugin_version%");
	public static final TranslationEntry GUI_ADMIN_MAIN_ITEMS_LEVELS_NAME = create("gui.admin main.items.level.name", "<GRADIENT:fc67fa>&lLevels</GRADIENT:f4c4f3>");
	public static final TranslationEntry GUI_ADMIN_MAIN_ITEMS_LEVELS_LORE = create("gui.admin main.items.level.lore", "&7View all the known levels", "", "&e&lClick &8» &7To view levels");

	public static final TranslationEntry GUI_ADMIN_MAIN_ITEMS_SPAWNERS_NAME = create("gui.admin main.items.spawners.name", "<GRADIENT:fc67fa>&lSpawners</GRADIENT:f4c4f3>");
	public static final TranslationEntry GUI_ADMIN_MAIN_ITEMS_SPAWNERS_LORE = create("gui.admin main.items.spawners.lore", "&7View all the known spawners", "", "&e&lClick &8» &7To view player spawners");

	public static final TranslationEntry GUI_ADMIN_MAIN_ITEMS_PRESETS_NAME = create("gui.admin main.items.spawner presets.name", "<GRADIENT:fc67fa>&LSpawner Presets</GRADIENT:f4c4f3>");
	public static final TranslationEntry GUI_ADMIN_MAIN_ITEMS_PRESETS_LORE = create("gui.admin main.items.spawner presets.lore", "&7View all created spawner presets", "", "&e&lClick &8» &7To view presets");

	public static final TranslationEntry GUI_ADMIN_MAIN_ITEMS_SHOP_NAME = create("gui.admin main.items.spawner shop.name", "<GRADIENT:fc67fa>&LSpawner Shop</GRADIENT:f4c4f3>");
	public static final TranslationEntry GUI_ADMIN_MAIN_ITEMS_SHOP_LORE = create("gui.admin main.items.spawner shop.lore", "&7View all spawner shop items", "", "&e&lClick &8» &7To edit shop");
}
