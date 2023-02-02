package fr.omny.plugin.managers;


import java.util.UUID;

import org.bukkit.entity.Player;
import org.redisson.api.annotation.REntity;
import org.redisson.api.annotation.RId;

import fr.omny.flow.data.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@REntity
public class User {

	@RId
	@Id
	private UUID id;
	private int token = 0;
	private String data = "";

	public User(){}

	public User(Player player) {
		this.id = player.getUniqueId();
		this.token = 0;
		this.data = "";
	}

}
