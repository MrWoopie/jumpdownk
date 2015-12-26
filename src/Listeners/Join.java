package Listeners;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import JumpDown.Main;

public class Join implements Listener {
	
	private Main plugin;
	
	private int counter = 41;
	private int lobbycounter;
	
	public Join(Main plugin) {
		this.plugin = plugin;
		this.plugin.getServer().getPluginManager().registerEvents(this, plugin);
	}
	
	@EventHandler(priority=EventPriority.HIGHEST, ignoreCancelled=true)
	  public void onLogin(PlayerJoinEvent event) {
		Player p = event.getPlayer();
		plugin.game.add(p);
	    final int msg = plugin.getConfig().getInt("start.limit");
	    if (plugin.getConfig().getBoolean("setupfinished")) {
	      
	      double x = plugin.getConfig().getDouble("Lobby.x");
	      double y = plugin.getConfig().getDouble("Lobby.y");
	      double z = plugin.getConfig().getDouble("Lobby.z");
	      
	      String w = plugin.getConfig().getString("Lobby.world");
	      plugin.saveConfig();
	      World world = Bukkit.getServer().getWorld(w);
	      Location loc = new Location(world, x, y, z);
	      
	      p.teleport(loc);
	      event.setJoinMessage(null);
	      
	      if (plugin.game.size() == msg) {
	        if (!plugin.starting)   {
	          plugin.starting = true;
	          
	        lobbycounter = Bukkit.getScheduler().scheduleSyncRepeatingTask(plugin, new Runnable() {
				
				@Override
				public void run() {
					if(counter != -1) {
						if(counter != 0) {
							counter--;
							for(Player alle : Bukkit.getOnlinePlayers()) {
								alle.setLevel(counter);
							}
							if(counter == 40) {
								for(Player alle : Bukkit.getOnlinePlayers()) {
									alle.playSound(alle.getLocation(), Sound.ANVIL_LAND, 10F, 1F);
								}
								Bukkit.broadcastMessage("                                                ");
								Bukkit.broadcastMessage("           §6Der Countdown hat begonnen           ");
								Bukkit.broadcastMessage("                                                ");
							}
	
							
							if(counter == 30 || counter == 20 || counter == 15 || counter == 10 || counter == 5
									|| counter == 4 || counter == 3 || counter == 2 || counter == 1) {
								for(Player alle : Bukkit.getOnlinePlayers()) {
									alle.playSound(alle.getLocation(), Sound.NOTE_PIANO, 10F, 1F);
								}
								Bukkit.broadcastMessage(plugin.prefix() + plugin.getConfig().getString("Countdown").replace('&', '§').replace("%COUNT%", String.valueOf(counter)));
							}
						}
						if(counter == 0) {
							Bukkit.getScheduler().cancelTask(lobbycounter);
						}
					}
					
				}
			}, 20, 20);
	          
	          
	          Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
				
				@Override
				public void run() {
					
					
					if (plugin.game.size() < msg) {
						
						Bukkit.getScheduler().cancelAllTasks();
						String message = plugin.getConfig().getString("Nachrichten.Nichtgenug").replace("&", "§").replace("%PREFIX%", plugin.prefix()).replace("%PREFIX%", plugin.prefix());
	
		                plugin.starting = false;
		                Bukkit.broadcastMessage(message);
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
		              }
					
				}
			}, 20*42L);
	          
	        }
	      }
	    }
	 
	  }


}
