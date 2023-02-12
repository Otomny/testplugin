package fr.omny.plugin.managers;


import java.util.UUID;

import org.bson.codecs.pojo.annotations.BsonId;
import org.bson.codecs.pojo.annotations.BsonProperty;
import org.bukkit.entity.Player;
import org.redisson.api.annotation.REntity;
import org.redisson.api.annotation.RId;

import fr.omny.flow.data.Id;
import fr.omny.flow.data.Val;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@REntity
public class User {

	@RId
	@BsonId
	@Id
	private UUID id;
	@Val
	@BsonProperty
	private int token = 0;
	@Val
	@BsonProperty
	private String locale = "";

	public User(){}

	public User(Player player) {
		this.id = player.getUniqueId();
		this.token = 0;
		this.locale = "";
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	
	@Override
	public String toString() {
		return "User [id=" + id + ", token=" + token + ", locale=" + locale + "]";
	}

	

}
