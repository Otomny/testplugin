package fr.omny.plugin.commands;


import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.omny.flow.commands.Cmd;
import fr.omny.flow.commands.wrapper.Arguments;
import fr.omny.guis.backend.sign.SignGUIBuilder;
import fr.omny.guis.utils.FunctionalUtils;

public class SignGUITestCommand extends Cmd {

	public SignGUITestCommand() {
		super("tsigngui");
	}

	@Override
	public boolean execute(CommandSender sender, String cmd, String[] args) {
		if (sender instanceof Player player) {
			new SignGUIBuilder(FunctionalUtils::isInt).onClose(signValue -> sender.sendMessage("Int value is = " + signValue))
					.title("Hello there!").open(player);

			return true;
		}
		return false;
	}

	@Override
	public void execute(CommandSender sender, Arguments args) {
		// TODO Auto-generated method stub

	}
}
