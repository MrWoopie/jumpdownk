package Commands;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

import JumpDown.Main;

public class Start implements CommandExecutor {
	
	private Main plugin;
	
	private int count = 11;
	public int counter;
	
	public Start(Main plugin) {
		this.plugin = plugin;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if((sender instanceof Player)) {
			Player p = (Player) sender;
			
			if(p.hasPermission("jumpdown.start")) {
				Bukkit.getScheduler().cancelAllTasks();
				
				p.sendMessage("§7[§c§oStart§7] Du hast die Wartezeit verkürzt");
				
				
				counter = Bukkit.getScheduler().scheduleSyncRepeatingTask(plugin, new Runnable() {
					
					@Override
					public void run() {
						if(count != -1) {
							if(count != 0) {
								count--;
								for(Player alle : Bukkit.getOnlinePlayers()) {
									alle.setLevel(count);
								}
								if(count == 10) {
									for(Player alle : Bukkit.getOnlinePlayers()) {
										alle.playSound(alle.getLocation(), Sound.NOTE_PIANO, 10F, 1F);
									}
									Bukkit.broadcastMessage(plugin.prefix() + " Die Wartezeit wurde verkürzt");
									Bukkit.broadcastMessage(plugin.prefix() + " Die Spielphase beginnt in §a" + count + " §7Sekunden");
								}
								if(count == 5 || count == 4 || count == 3 || count == 2 || count == 1) {
									for(Player alle : Bukkit.getOnlinePlayers()) {
										alle.playSound(alle.getLocation(), Sound.NOTE_PIANO, 10F, 1F);
									}
									Bukkit.broadcastMessage(plugin.prefix() + " Die Spielphase beginnt in §a" + count + " §7Sekunden");
								}
							} else {
								int msg = plugin.getConfig().getInt("start.limit");
								if (plugin.game.size() < msg) {
									
									String message = plugin.getConfig().getString("Nachrichten.Nichtgenug").replace("&", "§").replace("%PREFIX%", plugin.prefix()).replace("%PREFIX%", plugin.prefix().replace("ue", "ü"));

									Bukkit.reload();
									
					                plugin.running = true;
					                plugin.starting = false;
					    
					             
					                Bukkit.broadcastMessage(message);
					               for(Player alle : Bukkit.getOnlinePlayers()) {
					            	   alle.kickPlayer(null);
					               }
					               Bukkit.getScheduler().cancelTask(counter);
					              
					              } else {
					               
					 
					                plugin.GameState = true;
					                plugin.InGame = true;
					                plugin.runde1 = true;
					              
								
								double x = plugin.getConfig().getDouble("Arena1.x");
				                double y = plugin.getConfig().getDouble("Arena1.y");
				                double z = plugin.getConfig().getDouble("Arena1.z");
				                
				                String w = plugin.getConfig().getString("Arena1.world");
				                plugin.saveConfig();
				                World world = Bukkit.getServer().getWorld(w);
				                Location loc = new Location(world, x, y, z);
								
								for(Player player : Bukkit.getServer().getOnlinePlayers()) {
					                  player.teleport(loc);
					                  player.getInventory().clear();
					                  player.setLevel(0);
					                  player.setHealth(20);
					                  
					                }
								Bukkit.getScheduler().cancelAllTasks();
					              }
							}
						}
						
					}
				}, 20, 20);
				
			} else {
				p.sendMessage(plugin.getConfig().getString("Nachrichten.Noperm").replace('&', '§').replace("%PREFIX%", plugin.prefix()));
			}
		} else 
			if((sender instanceof ConsoleCommandSender)) {
				Bukkit.getConsoleSender().sendMessage("§7[§c§oStart§7] Dieser Befehl kann nur von Spielern ausgeführt werden");
			}
		
		
		
		
		return true;
	}
	
}
