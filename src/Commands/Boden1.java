package Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import JumpDown.Main;

public class Boden1 implements CommandExecutor {
	
	private Main plugin;
	
	public Boden1(Main plugin) {
		this.plugin = plugin;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player) sender;
		
		 if (p.hasPermission("Jumpdown.admin")) {
	        plugin.getConfig().set("Height1.y", Double.valueOf(p.getLocation().getY()));
	        
	        p.sendMessage(plugin.prefix() + " �aDer Boden von der ersten Arena wurde gesetzt");
	        
	        plugin.saveConfig();
	      } else {
	        p.sendMessage(plugin.getConfig().getString("Nachrichten.Noperm"));
	      }
		return true;
	}

}
