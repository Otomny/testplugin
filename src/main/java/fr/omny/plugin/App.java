package fr.omny.plugin;

import org.bson.codecs.pojo.PojoCodecProvider;
import org.bukkit.plugin.Plugin;

import fr.omny.flow.plugins.FlowPlugin;
import fr.omny.flow.utils.mongodb.FlowCodec;
import fr.omny.odi.Injector;
import fr.omny.plugin.config.DatabaseConfiguration;
import fr.omny.plugin.managers.User;
import lombok.Getter;

@Getter
public class App extends FlowPlugin {

	@Override
	public void load() {
	}

	@Override
	public void loadComponents() {
		var codec = Injector.getService(FlowCodec.class);
		codec.registerCodecProvider(PojoCodecProvider.builder().register(User.class).build());
		try {
			Injector.addSpecial(DatabaseConfiguration.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public String getPackageName() {
		return App.class.getPackageName();
	}

	@Override
	public void serverStart(Plugin plugin) {
	}

	@Override
	public void serverStop(Plugin plugin) {

	}

}
