package fr.omny;


import java.util.List;
import java.util.Optional;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandMap;
import org.bukkit.plugin.java.JavaPlugin;

import fr.omny.commands.GuiCommand;
import fr.omny.commands.SignGUITestCommand;
import fr.omny.gui.TestManager;
import fr.omny.gui.TestManager.TestObject;
import fr.omny.guis.OGui;
import fr.omny.guis.utils.ReflectionUtils;
import fr.omny.odi.Autowired;
import fr.omny.odi.Injector;
import lombok.Getter;

/**
 * Hello world!
 */
@Getter
public class App extends JavaPlugin {

	private static App instance;

	public static App getInstance() {
		return instance;
	}

	@Autowired
	private TestManager testManager;

	@Override
	public void onEnable() {
		super.onEnable();
		instance = this;
		OGui.register(this);
		Injector.startApplication(getClass(), getLogger());
		Injector.wire(this);
		testManager.getList().add(new TestObject());

		quickRegister(new GuiCommand(), new SignGUITestCommand(this));
	}

	@Override
	public void onDisable() {
		super.onDisable();
	}

	public void quickRegister(Command... commands) {
		Optional<CommandMap> map = ReflectionUtils.get(Bukkit.getServer(), "commandMap");
		map.ifPresentOrElse(commandMap -> {
			List.of(commands).stream().peek(Injector::wire)
					.forEach(command -> commandMap.register(command.getName(), "", command));
		}, () -> getLogger().warning("Could not find commandMap"));
	}

}
