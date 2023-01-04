package fr.omny.commands;


import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.omny.App;
import fr.omny.guis.OGui;

public class GuiCommand extends Command {

	private App main;

	public GuiCommand(App main) {
		super("gui");
		this.main = main;
	}

	@Override
	public boolean execute(CommandSender sender, String what, String[] arg2) {
		if (sender instanceof Player player) {
			OGui.open(player, this.main.getTestManager());
			return true;
		}
		return false;
	}

}
