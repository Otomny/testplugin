package fr.omny.plugin.commands;


import java.util.Optional;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.omny.flow.commands.Cmd;
import fr.omny.odi.Autowired;
import fr.omny.plugin.managers.User;
import fr.omny.plugin.managers.UserRepository;

public class UserCommand extends Cmd {

	@Autowired
	private UserRepository userRepository;

	public UserCommand() {
		super("user");
	}

	@Override
	public boolean execute(CommandSender sender, String arg1, String[] arg2) {
		if (sender instanceof Player player) {
			Optional<User> user = userRepository.get(player);
			user.ifPresent(data -> {
				sender.sendMessage("§eToken: " + data.getToken());
				sender.sendMessage("§eData: §7" + data.getData());
			});
		}
		return true;
	}

}
