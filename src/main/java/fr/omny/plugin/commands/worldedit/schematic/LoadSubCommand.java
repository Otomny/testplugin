package fr.omny.plugin.commands.worldedit.schematic;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.omny.flow.commands.SubCmd;
import fr.omny.flow.commands.wrapper.Arguments;

public class LoadSubCommand extends SubCmd{

	public LoadSubCommand() {
		super("load", false);
	}

	@Override
	public void execute(CommandSender sender, Arguments args) {
		if(sender instanceof Player player){
			
		}
	}
	
}
