package fr.omny.plugin.commands.worldedit;

import java.util.stream.Collectors;

import org.bukkit.Material;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.omny.flow.commands.Cmd;
import fr.omny.flow.commands.arguments.BlockArgument;
import fr.omny.flow.commands.wrapper.Arguments;
import fr.omny.flow.world.Area;
import fr.omny.flow.world.BlockPasteRunnable;
import fr.omny.flow.world.BlockUpdate;
import fr.omny.odi.Autowired;

public class SetCommand extends Cmd {

	@Autowired
	BlockPasteRunnable blockpaste;

	public SetCommand() {
		super("set");
		rc(0, new BlockArgument(false));
	}

	@Override
	public void execute(CommandSender sender, Arguments args) {
		if (sender instanceof Player player) {
			var type = args.get(0, Material.class);
			var baseLocation = player.getLocation();
			Area area = new Area(baseLocation.clone()
					.subtract(10, 10, 10), baseLocation.clone().subtract(5, 5, 5));
			var blockUpdates = area.getBlockUpdate()
					.stream()
					.map(BlockUpdate.setType(type))
					.collect(Collectors.toList());
			blockpaste.add(blockUpdates);
		}
	}

}
