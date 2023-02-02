package fr.omny.plugin.config;


import org.redisson.Redisson;
import org.redisson.api.RedissonClient;

import fr.omny.flow.config.Config;
import fr.omny.odi.Component;

@Component
public class DatabaseConfiguration {

	@Config("db.redis.uri")
	private String redisUri;

	@Config("db.mongodb.uri")
	private String mongoDbUri;

	@Component
	public RedissonClient client() {
		org.redisson.config.Config config = new org.redisson.config.Config();
		config.useSingleServer().setAddress(this.redisUri).setConnectionMinimumIdleSize(4).setConnectionPoolSize(8);
		return Redisson.create(config);
	}

}
