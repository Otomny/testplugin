package fr.omny.plugin.listeners;


import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import fr.omny.flow.tasks.Dispatcher;
import fr.omny.odi.Autowired;
import fr.omny.plugin.managers.User;
import fr.omny.plugin.managers.UserRepository;

public class Connection implements Listener {

	@Autowired
	private UserRepository users;
	@Autowired
	private Dispatcher dispatcher;

	@EventHandler
	public void onJoin(PlayerJoinEvent event) {
		var player = event.getPlayer();
		if (!users.existsById(player.getUniqueId())) {
			// create user
			users.saveAsync(new User(player)).thenRun(() -> users.getAsync(player));
		} else {
			users.getAsync(player);
		}
	}

	@EventHandler
	public void onQuit(PlayerQuitEvent event) {
		users.getAsync(event.getPlayer()).thenAcceptAsync(opt -> opt.ifPresent(this.users::save));
	}

}
