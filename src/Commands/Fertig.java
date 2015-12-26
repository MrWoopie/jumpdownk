package Commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import JumpDown.Main;

public class Fertig implements CommandExecutor {
	
	private Main plugin;
	
	public Fertig(Main plugin) {
		this.plugin = plugin;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player) sender;
		
		if (p.hasPermission("jumpdown.admin")) {
	        if (plugin.getConfig().getBoolean("setupfinished")) {
	          p.sendMessage("§7[§c§oServer§7] §c§lHej! §fDu hast das Setup noch nicht fertiggestellt! /fertig");
	        }  else {
	          plugin.getConfig().set("setupfinished", Boolean.valueOf(true));
	          plugin.saveConfig();
	          Bukkit.reload();
	          for(Player alle : Bukkit.getOnlinePlayers()) {
	        	  alle.kickPlayer("");
	          }
	        }
	      } else {
	        p.sendMessage(plugin.getConfig().getString("Nachrichten.Noperm"));
	      }
		return true;
	}


}
