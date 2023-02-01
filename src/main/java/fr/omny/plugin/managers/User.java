package fr.omny.plugin.managers;


import java.util.UUID;

import org.bukkit.entity.Player;
import org.redisson.api.annotation.REntity;
import org.redisson.api.annotation.RId;

import lombok.Getter;

@Getter
@REntity
public class User {

	@RId
	private UUID id;
	private int token;
	private String data;

	public User(Player player) {
		this.id = player.getUniqueId();
		this.token = 0;
		this.data = "";
	}

}
