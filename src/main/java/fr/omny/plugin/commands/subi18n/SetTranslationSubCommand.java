package fr.omny.plugin.commands.subi18n;

import org.bukkit.command.CommandSender;

import fr.omny.flow.commands.SubCmd;
import fr.omny.flow.commands.arguments.EnumStringArgument;
import fr.omny.flow.commands.arguments.SentenceArgument;
import fr.omny.flow.commands.arguments.StringArgument;
import fr.omny.flow.commands.wrapper.Arguments;
import fr.omny.flow.translation.I18N;
import fr.omny.odi.Autowired;

public class SetTranslationSubCommand extends SubCmd{

	@Autowired
	I18N i18n;

	public SetTranslationSubCommand(boolean optional) {
		super("set", optional);
		rc(0, new EnumStringArgument("Language", false, "fr", "en", "es", "de"));
		rc(1, new StringArgument("Key", false));
		rc(2, new SentenceArgument("Translation", false));
	}

	@Override
	public void execute(CommandSender sender, Arguments args) {
		var lang = args.get(0, String.class);
		var key = args.get(1, String.class);
		var translation = args.get(2, String.class); 
		i18n.put(lang, key, translation);
	}
	
}
