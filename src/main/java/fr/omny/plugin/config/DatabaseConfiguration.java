package fr.omny.plugin.config;


import org.bson.UuidRepresentation;
import org.redisson.Redisson;
import org.redisson.api.RedissonClient;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;

import fr.omny.flow.config.Config;
import fr.omny.odi.Component;

@Component
public class DatabaseConfiguration {

	@Config("db.redis.uri")
	private String redisUri;

	@Config("db.mongodb.uri")
	private String mongoDbUri;

	@Component
	public RedissonClient redisClient() {
		org.redisson.config.Config config = new org.redisson.config.Config();
		config.useSingleServer().setAddress(this.redisUri).setConnectionMinimumIdleSize(4).setConnectionPoolSize(8);
		return Redisson.create(config);
	}

	@Component
	public MongoClient mongoClient() {
		return MongoClients.create(MongoClientSettings.builder().uuidRepresentation(UuidRepresentation.STANDARD)
				.applyConnectionString(new ConnectionString(this.mongoDbUri))
				.applyToConnectionPoolSettings(b -> b.maxSize(10).minSize(2)).build());
	}

}
