package fr.omny.plugin.config;


import java.util.Optional;

import org.bson.UuidRepresentation;
import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.codec.JsonJacksonCodec;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;

import fr.omny.flow.config.Config;
import fr.omny.flow.plugins.Env;
import fr.omny.flow.utils.mongodb.FlowCodec;
import fr.omny.odi.Autowired;
import fr.omny.odi.Component;

@Component(requireWire = true)
public class DatabaseConfiguration {

	@Config("db.redis.uri")
	private String redisUri;

	@Config("db.mongodb.uri")
	private String mongoDbUri;

	@Config("db.name")
	private Optional<String> dbName;

	@Autowired
	private FlowCodec codec;

	@Component("databaseName")
	public String databaseName() {
		return dbName.or(() -> Env.get(Env.DATABASE_NAME)).orElse("flow");
	}

	@Component
	public RedissonClient redisClient() {
		org.redisson.config.Config config = new org.redisson.config.Config();
		config.setCodec(new JsonJacksonCodec());
		config.useSingleServer().setAddress(this.redisUri).setConnectionMinimumIdleSize(4).setConnectionPoolSize(8);
		return Redisson.create(config);
	}

	@Component
	public MongoClient mongoClient() {
		return MongoClients.create(MongoClientSettings.builder().uuidRepresentation(UuidRepresentation.STANDARD)
				.codecRegistry(codec.getCodecRegistries()).applyConnectionString(new ConnectionString(this.mongoDbUri))
				.applyToConnectionPoolSettings(b -> b.maxSize(10).minSize(2)).build());
	}

}
