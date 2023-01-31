package fr.omny.plugin;


import org.bukkit.plugin.Plugin;

import fr.omny.flow.plugins.FlowPlugin;
import lombok.Getter;

@Getter
public class App extends FlowPlugin {

	@Override
	public void load() {}

	@Override
	public String getPackageName() {
		return getClass().getPackageName();
	}

	@Override
	public void serverStart(Plugin plugin) {
		
	}

	@Override
	public void serverStop(Plugin plugin) {
		
	}

}
