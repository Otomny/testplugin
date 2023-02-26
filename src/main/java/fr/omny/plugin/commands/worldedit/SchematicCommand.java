package fr.omny.plugin.commands.worldedit;

import java.util.List;

import org.bukkit.command.CommandSender;

import fr.omny.flow.commands.Cmd;
import fr.omny.flow.commands.wrapper.Arguments;

public class SchematicCommand extends Cmd {

	public SchematicCommand() {
		super("schematic", "Schematic related commands", "/schem <>", List.of("schem"));
	}

	@Override
	public void execute(CommandSender sender, Arguments args) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'execute'");
	}

}
