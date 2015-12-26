package Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import JumpDown.Main;

public class Lobby implements CommandExecutor {
	
	private Main plugin;
	
	public Lobby(Main plugin) {
		this.plugin = plugin;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		Player p = (Player) sender;
		
		 if (p.hasPermission("Jumpdown.admin")) {
	        plugin.getConfig().set("Lobby.world", p.getLocation().getWorld().getName());
	        plugin.getConfig().set("Lobby.x", Double.valueOf(p.getLocation().getX()));
	        plugin.getConfig().set("Lobby.y", Double.valueOf(p.getLocation().getY()));
	        plugin.getConfig().set("Lobby.z", Double.valueOf(p.getLocation().getZ()));
	        p.sendMessage(plugin.prefix() + " §aDer Spawn der Lobby wurde gesetzt!");
	        
	        plugin.saveConfig();
	      }	else {
	        p.sendMessage(plugin.getConfig().getString("Nachrichten.Noperm"));
	      }
		
		
		return true;
	}


}
