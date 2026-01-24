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
import ca.tweetzy.spawners.Spawners;
import ca.tweetzy.spawners.api.spawner.SpawnerUser;
import ca.tweetzy.spawners.guis.user.SpawnersMainGUI;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.List;

/**
 * Date Created: May 04 2022
 * Time Created: 10:42 a.m.
 *
 * @author Kiran Hart
 */
public final class SpawnersCommand extends Command {

	public SpawnersCommand() {
		super(AllowedExecutor.BOTH, "spawners");
	}

	@Override
	protected ReturnType execute(CommandContext context) {
		if (context.isPlayer()) {
			final Player player = context.getPlayer();
			final SpawnerUser user = Spawners.getPlayerManager().findUser(player);

			if (user != null)
				Spawners.getGuiManager().showGUI(player, new SpawnersMainGUI(player, user));
			else
				Spawners.getPlayerManager().createPlayer(player, (created, createdUser) -> {
					Spawners.getGuiManager().showGUI(player, new SpawnersMainGUI(player, createdUser));
				});
		}

		return ReturnType.SUCCESS;
	}

	@Override
	protected ReturnType execute(CommandSender sender, String... args) {
		return execute(new CommandContext(sender, args, getSubCommands().isEmpty() ? "" : getSubCommands().get(0)));
	}

	@Override
	protected List<String> tab(CommandContext context) {
		return null;
	}

	@Override
	protected List<String> tab(CommandSender sender, String... args) {
		return tab(new CommandContext(sender, args, getSubCommands().isEmpty() ? "" : getSubCommands().get(0)));
	}

	@Override
	public String getPermissionNode() {
		return "spawners.command";
	}

	@Override
	public String getSyntax() {
		return null;
	}

	@Override
	public String getDescription() {
		return "The main command for the plugin";
	}
}
