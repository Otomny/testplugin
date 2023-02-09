package fr.omny.plugin.commands;


import java.util.List;

import org.bukkit.command.CommandSender;

import fr.omny.flow.commands.Cmd;
import fr.omny.flow.commands.wrapper.Arguments;
import fr.omny.plugin.commands.subi18n.SetTranslationSubCommand;

public class TranslationCommand extends Cmd {

	public TranslationCommand() {
		// super("i18n");
		super("translation", "CRUD actions for translations", "", List.of("i18n"));
		rc(0, new SetTranslationSubCommand(false));
	}

	@Override
	public void execute(CommandSender sender, Arguments args) {
		// TODO Auto-generated method stub

	}

}
