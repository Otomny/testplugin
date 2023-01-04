package fr.omny.commands;


import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.omny.App;
import fr.omny.guis.backend.sign.SignGUIBuilder;
import fr.omny.guis.utils.FunctionalUtils;

public class SignGUITestCommand extends Command {

	public SignGUITestCommand(App main) {
		super("tsigngui");
	}

	@Override
	public boolean execute(CommandSender sender, String cmd, String[] args) {
		if (sender instanceof Player player) {
			new SignGUIBuilder(FunctionalUtils::isInt).onClose(signValue -> sender.sendMessage("Int value is = "+signValue))
					.title("Hello there!").open(player);

			return true;
		}
		return false;
	}

}
