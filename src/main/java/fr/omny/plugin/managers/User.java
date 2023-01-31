package fr.omny.plugin.managers;


import java.util.UUID;

import org.bukkit.entity.Player;

import lombok.Getter;

@Getter
public class User {

	private UUID id;
	private int token;
	private String data;

	public User(Player player) {
		this.id = player.getUniqueId();
		this.token = 0;
		this.data = "";
	}

}
