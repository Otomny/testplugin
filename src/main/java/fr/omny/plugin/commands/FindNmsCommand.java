package fr.omny.plugin.commands;

import java.lang.reflect.InvocationTargetException;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;

import fr.omny.flow.commands.Cmd;
import fr.omny.flow.commands.wrapper.Arguments;
import fr.omny.odi.Utils;

public class FindNmsCommand extends Cmd{

	public FindNmsCommand() {
		super("findnms");
	}

	@Override
	public void execute(CommandSender sender, Arguments args) {
		var server = Bukkit.getServer();
		try {
			var result = Utils.callMethod("getHandle", server);
			System.out.println(result);
			System.out.println(result.getClass());
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			e.printStackTrace();
		}
	}
	
}
