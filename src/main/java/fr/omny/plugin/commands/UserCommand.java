package fr.omny.plugin.commands;


import java.util.Optional;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.omny.flow.commands.Cmd;
import fr.omny.flow.commands.wrapper.Arguments;
import fr.omny.odi.Autowired;
import fr.omny.plugin.commands.subuser.UserSetLocaleSubCommand;
import fr.omny.plugin.managers.User;
import fr.omny.plugin.managers.UserRepository;

public class UserCommand extends Cmd {

	@Autowired
	private UserRepository userRepository;

	public UserCommand() {
		super("user");
		rc(0, new UserSetLocaleSubCommand(true));
	}

	@Override
	public void execute(CommandSender sender, Arguments args) {
		if (sender instanceof Player player) {
			Optional<User> user = userRepository.get(player);
			user.ifPresent(data -> {
				sender.sendMessage("§eToken: " + data.getToken());
				sender.sendMessage("§eLocale: §7" + data.getLocale());
			});
		}
	}

}
