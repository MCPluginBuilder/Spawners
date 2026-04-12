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
package ca.tweetzy.spawners;


import ca.tweetzy.flight.FlightPlugin;
import ca.tweetzy.flight.command.CommandManager;
import ca.tweetzy.flight.config.tweetzy.TweetzyYamlConfig;
import ca.tweetzy.flight.database.DataMigrationManager;
import ca.tweetzy.flight.database.DatabaseConnector;
import ca.tweetzy.flight.database.SQLiteConnector;
import ca.tweetzy.flight.gui.GuiManager;
import ca.tweetzy.flight.utils.Common;
import ca.tweetzy.spawners.api.SpawnersAPI;
import ca.tweetzy.spawners.api.manager.Manager;
import ca.tweetzy.spawners.commands.*;
import ca.tweetzy.spawners.database.DataManager;
import ca.tweetzy.spawners.database.migrations._1_InitialMigration;
import ca.tweetzy.spawners.database.migrations._2_SpawnerPresetMigration;
import ca.tweetzy.spawners.database.migrations._3_SpawnerShopItemMigration;
import ca.tweetzy.spawners.impl.APIImplementation;
import ca.tweetzy.spawners.listeners.*;
import ca.tweetzy.spawners.model.manager.*;
import ca.tweetzy.spawners.settings.Settings;
import ca.tweetzy.spawners.settings.Translations;
import co.aikar.taskchain.BukkitTaskChainFactory;
import co.aikar.taskchain.TaskChain;
import co.aikar.taskchain.TaskChainFactory;
import net.milkbowl.vault.economy.Economy;
import org.bukkit.NamespacedKey;
import org.bukkit.plugin.RegisteredServiceProvider;

import java.util.Arrays;

/**
 * Date Created: May 04 2022
 * Time Created: 10:35 a.m.
 *
 * @author Kiran Hart
 */
public final class Spawners extends FlightPlugin {

	private static TaskChainFactory taskChainFactory;
	private final TweetzyYamlConfig coreConfig = new TweetzyYamlConfig(this, "config.yml");

	public NamespacedKey ADMIN_MODE;
	public static NamespacedKey STACKED_MOB_COUNT;


	private final GuiManager guiManager = new GuiManager(this);
	private final CommandManager commandManager = new CommandManager(this);

	private final PlayerManager playerManager = new PlayerManager();
	private final LevelManager levelManager = new LevelManager();
	private final SpawnerManager spawnerManager = new SpawnerManager();
	private final PresetManager presetManager = new PresetManager();
	private final ShopItemManager shopItemManager = new ShopItemManager();
	private final RegionHookManager regionHookManager = new RegionHookManager();

	private final SpawnersAPI spawnersAPI = new APIImplementation();

	private Economy economy = null;

	// database
	@SuppressWarnings("FieldCanBeLocal")
	private DatabaseConnector databaseConnector;

	@SuppressWarnings("FieldCanBeLocal")
	private DataManager dataManager;

	@Override
	protected void onFlight() {
		// settings & locale setup
		Settings.setup();
		Translations.init();

		Common.setPrefix(Settings.PREFIX.getString());
		taskChainFactory = BukkitTaskChainFactory.create(this);


		// Set up the database if enabled
		this.databaseConnector = new SQLiteConnector(this);
		this.dataManager = new DataManager(this.databaseConnector, this);

		final DataMigrationManager dataMigrationManager = new DataMigrationManager(this.databaseConnector, this.dataManager, new _1_InitialMigration(), new _2_SpawnerPresetMigration(), new _3_SpawnerShopItemMigration());

		// run migrations for tables
		dataMigrationManager.runMigrations();

		// check vault
		setupEconomy();

		Arrays.asList(this.playerManager, this.levelManager, this.spawnerManager, this.presetManager, this.shopItemManager, this.regionHookManager).forEach(Manager::load);

		// setup command manager
		this.commandManager.registerCommandDynamically(new SpawnersCommand()).addSubCommands(new GiveCommand(), new AdminCommand(), new SetCommand(), new ButcherCommand(), new ReloadCommand());

		// initialize gui manager
		this.guiManager.init();

		getServer().getPluginManager().registerEvents(new JoinListeners(), this);
		getServer().getPluginManager().registerEvents(new BlockListeners(), this);
		getServer().getPluginManager().registerEvents(new EntityListeners(), this);
		getServer().getPluginManager().registerEvents(new EggListeners(), this);
		getServer().getPluginManager().registerEvents(new PlayerListeners(), this);
		getServer().getPluginManager().registerEvents(new MobSpawnListener(), this);

		ADMIN_MODE = new NamespacedKey(Spawners.getInstance(), "ADMIN_MODE");
		STACKED_MOB_COUNT = new NamespacedKey(Spawners.getInstance(), "STACKED_MOB_COUNT");

	}

	@Override
	protected void onSleep() {
		shutdownDataManager(this.dataManager);
	}

	// instance
	public static Spawners getInstance() {
		return (Spawners) FlightPlugin.getInstance();
	}


	public static TweetzyYamlConfig getCoreConfig() {
		return getInstance().coreConfig;
	}

	// data manager
	public static DataManager getDataManager() {
		return getInstance().dataManager;
	}

	// gui manager
	public static GuiManager getGuiManager() {
		return getInstance().guiManager;
	}

	// player manager
	public static PlayerManager getPlayerManager() {
		return getInstance().playerManager;
	}

	// level manager
	public static LevelManager getLevelManager() {
		return getInstance().levelManager;
	}

	// spawner manager
	public static SpawnerManager getSpawnerManager() {
		return getInstance().spawnerManager;
	}

	// spawner preset manager
	public static PresetManager getPresetManager() {
		return getInstance().presetManager;
	}

	// shop item manager
	public static ShopItemManager getShopItemManager() {
		return getInstance().shopItemManager;
	}

	// region manager
	public static RegionHookManager getRegionHookManager() {
		return getInstance().regionHookManager;
	}

	public static NamespacedKey getAdminModeKey() {
		return getInstance().ADMIN_MODE;
	}

	// economy
	public static Economy getEconomy() {
		return getInstance().economy;
	}

	public static SpawnersAPI getAPI() {
		return getInstance().spawnersAPI;
	}

	@Override
	protected int getBStatsId() {
		return 12416;
	}

	public static <T> TaskChain<T> newChain() {
		return taskChainFactory.newChain();
	}


	// helpers
	private void setupEconomy() {
		if (getServer().getPluginManager().getPlugin("Vault") == null) {
			return;
		}

		final RegisteredServiceProvider<Economy> rsp = getServer().getServicesManager().getRegistration(Economy.class);

		if (rsp == null) {
			return;
		}

		this.economy = rsp.getProvider();
	}
}
