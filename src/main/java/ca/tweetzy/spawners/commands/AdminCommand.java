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
package ca.tweetzy.spawners.commands;

import ca.tweetzy.flight.command.AllowedExecutor;
import ca.tweetzy.flight.command.Command;
import ca.tweetzy.flight.command.CommandContext;
import ca.tweetzy.flight.command.ReturnType;
import ca.tweetzy.flight.settings.TranslationManager;
import ca.tweetzy.flight.utils.Common;
import ca.tweetzy.spawners.Spawners;
import ca.tweetzy.spawners.guis.admin.SpawnersAdminGUI;
import ca.tweetzy.spawners.settings.Translations;
import org.bukkit.NamespacedKey;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.persistence.PersistentDataType;

import java.util.List;


/**
 * Date Created: June 02 2022
 * Time Created: 3:51 p.m.
 *
 * @author Kiran Hart
 */
public final class AdminCommand extends Command {

	public AdminCommand() {
		super(AllowedExecutor.PLAYER, "admin");
	}

	@Override
	protected ReturnType execute(CommandContext context) {
		if (!context.isPlayer()) return ReturnType.FAIL;

		final Player player = context.getPlayer();

		if (!context.hasArg(0)) {
			Spawners.getGuiManager().showGUI(player, new SpawnersAdminGUI(player));
			return ReturnType.SUCCESS;
		}

		switch(context.getArg(0)) {
			case "bypass":
				if (!player.getPersistentDataContainer().has(Spawners.getAdminModeKey())) {
					player.getPersistentDataContainer().set(new NamespacedKey(Spawners.getInstance(), "ADMIN_MODE"), PersistentDataType.BOOLEAN, true);
					Common.tell(player, TranslationManager.string(Translations.ADMIN_MODE_ENABLED));
				} else {
					player.getPersistentDataContainer().remove(Spawners.getAdminModeKey());
					Common.tell(player, TranslationManager.string(Translations.ADMIN_MODE_DISABLED));
				}
				break;
		}

		return ReturnType.SUCCESS;
	}

	@Override
	protected ReturnType execute(CommandSender sender, String... args) {
		return execute(new CommandContext(sender, args, getSubCommands().isEmpty() ? "" : getSubCommands().get(0)));
	}

	@Override
	protected List<String> tab(CommandContext context) {
		if (context.hasArg(0) && context.getArgCount() == 1)
			return List.of("bypass");
		return null;
	}

	@Override
	protected List<String> tab(CommandSender sender, String... args) {
		return tab(new CommandContext(sender, args, getSubCommands().isEmpty() ? "" : getSubCommands().get(0)));
	}

	@Override
	public String getPermissionNode() {
		return "spawners.command.admin";
	}

	@Override
	public String getSyntax() {
		return null;
	}

	@Override
	public String getDescription() {
		return "Opens the administration menu";
	}
}
