package fr.omny.plugin.managers;

import java.util.Optional;
import java.util.UUID;

import org.bukkit.entity.Player;

import fr.omny.flow.data.MongoRepository;
import fr.omny.flow.data.Repository;

@Repository
public interface UserRepository extends MongoRepository<User, UUID>{
	
	default Optional<User> get(Player player){
		return findById(player.getUniqueId());
	}

}
