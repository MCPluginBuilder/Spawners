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
import ca.tweetzy.spawners.api.spawner.Preset;
import ca.tweetzy.spawners.model.SpawnerBuilder;
import ca.tweetzy.spawners.settings.Translations;
import org.apache.commons.lang.math.NumberUtils;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Date Created: May 04 2022
 * Time Created: 10:43 p.m.
 *
 * @author Kiran Hart
 */
public final class GiveCommand extends Command {

	public GiveCommand() {
		super(AllowedExecutor.BOTH, "give");
	}

	@Override
	protected ReturnType execute(CommandContext context) {
		if (!context.hasArg(0)) {
			return ReturnType.SUCCESS;
		}

		final boolean isGivingAll = context.getArg(0).equals("*");

		final Player target = Bukkit.getPlayerExact(context.getArg(0));

		if (!isGivingAll)
			if (target == null) {
				Common.tell(context.getSender(), TranslationManager.string(Translations.PLAYER_OFFLINE, "player", context.getArg(0)));
				return ReturnType.FAIL;
			}

		int amount = 1;

		if (context.hasArg(1)) {
			if (NumberUtils.isNumber(context.getArg(1)))
				amount = Integer.parseInt(context.getArg(1));
		}

		// check for flags
		final EntityType entityType = CommandFlag.get(EntityType.class, "entity", EntityType.PIG, context.getArgs().toArray(new String[0]));
		final String preset = CommandFlag.get(String.class, "preset", null, context.getArgs().toArray(new String[0]));
		final boolean noOwner = context.getArgs().contains("-noowner");

		Preset presetFound = null;

		if (preset != null) {
			presetFound = Spawners.getPresetManager().find(preset);
		}

		if (isGivingAll)
			for (Player player : Bukkit.getOnlinePlayers()) {
				SpawnerBuilder builder;
				if (presetFound != null) {
					builder = SpawnerBuilder.of(player, presetFound);
				} else {
					builder = SpawnerBuilder.of(player, entityType);
				}
				
				if (noOwner) {
					builder.setNoOwner();
				}
				
				final ItemStack spawnerItem = builder.make();

				for (int i = 0; i < amount; i++)
					player.getInventory().addItem(spawnerItem);
			}
		else {
			SpawnerBuilder builder;
			if (presetFound != null) {
				builder = SpawnerBuilder.of(target, presetFound);
			} else {
				builder = SpawnerBuilder.of(target, entityType);
			}
			
			if (noOwner) {
				builder.setNoOwner();
			}
			
			final ItemStack spawnerItem = builder.make();

			for (int i = 0; i < amount; i++)
				target.getInventory().addItem(spawnerItem);
		}

		return ReturnType.SUCCESS;
	}

	@Override
	protected ReturnType execute(CommandSender sender, String... args) {
		return execute(new CommandContext(sender, args, getSubCommands().isEmpty() ? "" : getSubCommands().get(0)));
	}

	@Override
	protected List<String> tab(CommandContext context) {
		if (context.getArgCount() == 0 || context.getArgCount() == 1) {
			final List<String> completions = new ArrayList<>();
			completions.add("*");
			completions.addAll(Bukkit.getOnlinePlayers().stream().map(Player::getName).collect(Collectors.toList()));
			return completions;
		}
		return null;
	}

	@Override
	protected List<String> tab(CommandSender sender, String... args) {
		return tab(new CommandContext(sender, args, getSubCommands().isEmpty() ? "" : getSubCommands().get(0)));
	}

	@Override
	public String getPermissionNode() {
		return "spawners.command.give";
	}

	@Override
	public String getSyntax() {
		return "<player/*> [[-preset <presetId>]/[-entity <entityType>]] [-noowner]";
	}

	@Override
	public String getDescription() {
		return "Give users a spawner";
	}
}
