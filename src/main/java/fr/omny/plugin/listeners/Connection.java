package fr.omny.plugin.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import fr.omny.odi.Autowired;
import fr.omny.plugin.managers.User;
import fr.omny.plugin.managers.UserRepository;

public class Connection implements Listener{
	
	@Autowired
	private UserRepository users;

	@EventHandler
	public void onJoin(PlayerJoinEvent event){
		var player = event.getPlayer();
		if(!users.existsById(player.getUniqueId())){
			// create user
			users.save(new User(player));
		}
	}

	@EventHandler
	public void onQuit(PlayerQuitEvent event){

	}

}
