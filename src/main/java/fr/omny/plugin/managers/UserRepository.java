package fr.omny.plugin.managers;

import java.util.Optional;
import java.util.UUID;

import org.bukkit.entity.Player;

import fr.omny.flow.data.RedisRepository;
import fr.omny.flow.data.Repository;

@Repository
public interface UserRepository extends RedisRepository<User, UUID>{
	
	default Optional<User> get(Player player){
		return findById(player.getUniqueId());
	}

}
