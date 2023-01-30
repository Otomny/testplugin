package fr.omny.plugin.commands;


import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.omny.flow.commands.Cmd;
import fr.omny.guis.OGui;
import fr.omny.odi.Autowired;
import fr.omny.plugin.gui.TestManager;

public class GuiCommand extends Cmd {

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
