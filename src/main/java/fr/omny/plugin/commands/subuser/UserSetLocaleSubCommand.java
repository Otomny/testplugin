package fr.omny.plugin.commands.subuser;


import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.omny.flow.commands.SubCmd;
import fr.omny.flow.commands.arguments.EnumStringArgument;
import fr.omny.flow.commands.wrapper.Arguments;
import fr.omny.odi.Autowired;
import fr.omny.plugin.managers.UserRepository;

public class UserSetLocaleSubCommand extends SubCmd {

	@Autowired
	private UserRepository userRepository;

	public UserSetLocaleSubCommand(boolean optional) {
		super("setlocale", optional);
		rc(0, new EnumStringArgument("Language", false, "fr", "en", "es", "de"));
	}

	@Override
	public void execute(CommandSender sender, Arguments args) {
		if (sender instanceof Player player) {
			userRepository.get(player).ifPresent(user -> {
				user.setLocale(args.get(0, String.class));
			});
			
		}
	}

}
