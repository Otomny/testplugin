package fr.omny.commands;


import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.omny.gui.TestManager;
import fr.omny.guis.OGui;
import fr.omny.odi.Autowired;

public class GuiCommand extends Command {

	@Autowired
	private TestManager manager;

	public GuiCommand() {
		super("gui");
	}

	@Override
	public boolean execute(CommandSender sender, String what, String[] arg2) {
		if (sender instanceof Player player) {
			OGui.open(player, manager);
			return true;
		}
		return false;
	}

}
