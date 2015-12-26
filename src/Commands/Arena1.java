package Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import JumpDown.Main;

public class Arena1 implements CommandExecutor {
	
	private Main plugin;
	
	public Arena1(Main plugin) {
		this.plugin = plugin;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player) sender;
		if (p.hasPermission("Jumpdown.admin")) {
	        plugin.getConfig().set("Arena1.world", p.getLocation().getWorld().getName());
	        plugin.getConfig().set("Arena1.x", Double.valueOf(p.getLocation().getX()));
	        plugin.getConfig().set("Arena1.y", Double.valueOf(p.getLocation().getY()));
	        plugin.getConfig().set("Arena1.z", Double.valueOf(p.getLocation().getZ()));
	        p.sendMessage(plugin.prefix() + " §aDer Spawn der ersten Arena wurde gesetzt!");
	        plugin.saveConfig();
	      } else {
	        p.sendMessage(plugin.getConfig().getString("Nachrichten.Noperm"));
	      }
		
		
		
		return true;
	}

}
