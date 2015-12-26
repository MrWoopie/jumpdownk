package Listeners;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

import JumpDown.Main;

public class Quit implements Listener{
	
	private Main plugin;
	
	private int lobby = 18;
	
	public Quit(Main plugin) {
		this.plugin = plugin;
		this.plugin.getServer().getPluginManager().registerEvents(this, plugin);
	}
	
	  @EventHandler
	  public void onLeft(PlayerQuitEvent event) {
	    Player p = event.getPlayer();
	    plugin.game.remove(p);
	    event.setQuitMessage("");
	    
	    if(plugin.GameState) {
	    	if(plugin.game.size() == 0) {
	    		Bukkit.shutdown();
	    	}
	    	if(plugin.runde1 || plugin.runde2 || plugin.runde3) {
	    		if(plugin.game.size() == 1) {
	    			Bukkit.broadcastMessage("§7[§c§oAbbruch§7] Du befindest dich alleine in der Runde");
	    			Bukkit.getScheduler().cancelAllTasks();
	    			
	    			Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
						
						@Override
						public void run() {
							double x = plugin.getConfig().getDouble("Lobby.x");
						      double y = plugin.getConfig().getDouble("Lobby.y");
						      double z = plugin.getConfig().getDouble("Lobby.z");
						      
						      String w = plugin.getConfig().getString("Lobby.world");
						      plugin.saveConfig();
						      World world = Bukkit.getServer().getWorld(w);
						      Location loc = new Location(world, x, y, z);
						      
						     for(Player alle : Bukkit.getOnlinePlayers()) {
						    	 alle.teleport(loc);
						     }
							
						}
					}, 20*2L);
	    			
	    			Bukkit.getScheduler().scheduleSyncRepeatingTask(plugin, new Runnable() {
						
						@Override
						public void run() {
							if(lobby != 1) {
								if(lobby != 0) {
									lobby --;
									if(lobby == 15 || lobby == 10 || lobby == 5 || lobby == 4 || lobby == 3 || lobby == 2 ||
											lobby == 1) {
										for(Player alle : Bukkit.getOnlinePlayers()) {
											alle.playSound(alle.getLocation(), Sound.LAVA_POP, 10F, 1F);
										}
										Bukkit.broadcastMessage("§7[§c§oServer§7] Der Server startet in §e" + lobby + " §7Sekunden neu");
									}
								} 
									
							}
							
						}
					}, 20, 20);
	    			
	    			Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
						
						@Override
						public void run() {
							Bukkit.shutdown();
							
						}
					}, 20*19L);
	    		}
	    	}
	    }
	    
	  }

}
