package Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import JumpDown.Main;

public class Arena2 implements CommandExecutor {
	
	private Main plugin;
	
	public Arena2(Main plugin) {
		this.plugin = plugin;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player) sender;
    		if(p.hasPermission("jumpdown.admin")) {
    			plugin.getConfig().set("Arena2.world", p.getLocation().getWorld().getName());
    			plugin.getConfig().set("Arena2.x", p.getLocation().getX());
    			plugin.getConfig().set("Arena2.y", p.getLocation().getY());
    			plugin.getConfig().set("Arena2.z", p.getLocation().getZ());
    			p.sendMessage(plugin.prefix() + " §aDer Spawn der zweiten Arena wurde gesetzt!");
    			
    			
    			plugin.saveConfig();
    		} else {
    			p.sendMessage(plugin.getConfig().getString("Nachrichten.Noperm"));
    		}
		
		
		return true;
	}
	
	

}
