package Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import JumpDown.Main;

public class Boden2 implements CommandExecutor {
	
	private Main plugin;
	
	public Boden2(Main plugin) {
		this.plugin = plugin;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player) sender;
		
    		if(p.hasPermission("jumpdown.admin")) {
				plugin.getConfig().set("Height2.y", Double.valueOf(p.getLocation().getY()));
				p.sendMessage(plugin.prefix() + " §aDer Boden von der zweiten Arena wurde gesetzt");
				
				plugin.saveConfig();
    		} else {
    			p.sendMessage(plugin.getConfig().getString("Nachrichten.Noperm"));
    		}
		return true;
	}


}
