package Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import JumpDown.Main;

public class Arena3 implements CommandExecutor {
	
	private Main plugin;
	
	public Arena3(Main plugin) {
		this.plugin = plugin;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player) sender;
		
		if(p.hasPermission("jumpdown.admin")) {
			plugin.getConfig().set("Arena3.world", p.getLocation().getWorld().getName());
			plugin.getConfig().set("Arena3.x", p.getLocation().getX());
			plugin.getConfig().set("Arena3.y", p.getLocation().getY());
			plugin.getConfig().set("Arena3.z", p.getLocation().getZ());
			p.sendMessage(plugin.prefix() + " §aDer Spawn der dritten Arena wurde gesetzt!");
			
			
			plugin.saveConfig();
		} else {
			p.sendMessage(plugin.getConfig().getString("Nachrichten.noperm"));
		}
		
		
		return true;
	}

}
