package GameManager;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

import API.TitleAPI;
import JumpDown.Main;

public class Move2 implements Listener {
	
	private Main plugin;
	
	public Move2(Main plugin) {
		this.plugin = plugin;
		this.plugin.getServer().getPluginManager().registerEvents(this, plugin);
	}
	
	@SuppressWarnings("deprecation")
	@EventHandler (priority = EventPriority.HIGHEST)
	public void onMove2(PlayerMoveEvent event) {
		Player p = event.getPlayer();
		
		if(plugin.GameState) {
			if(plugin.runde2) {
				int Y = plugin.getConfig().getInt("Height2.y");
				
				if(event.getTo().getY() <= Y && p.isOnGround()) {
					
					
					if(p.isDead()) {
						double x = plugin.getConfig().getDouble("Arena2.x");
						double y = plugin.getConfig().getDouble("Arena2.y");
						double z = plugin.getConfig().getDouble("Arena2.z");
						
						String welt = plugin.getConfig().getString("Arena2.world");
						World world = plugin.getServer().getWorld(welt);
						Location loc = new Location(world, x, y, z);
						
						p.teleport(loc);
					} else {
						plugin.GameState = false;
						plugin.runde2 = false;
						
						plugin.gewinner2.add(p);
						
				          Bukkit.broadcastMessage(plugin.getConfig().getString("Nachrichten.Isonground").replace("%PLAYER%", p.getDisplayName()).replace('&', '§').replace("%PREFIX%", plugin.prefix()));

				        
				          for(Player alle : Bukkit.getOnlinePlayers()) {
				        	 TitleAPI.sendFullTitle(alle, 20, 20*3, 20, "§6Gewinner!", "§6" + p.getDisplayName());
				        	 alle.playSound(alle.getLocation(), Sound.FIREWORK_LAUNCH, 10F, 1F);
				        	 alle.playSound(alle.getLocation(), Sound.FIREWORK_BLAST, 10F, 1F);
				         }
				          
				          Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
								
								@Override
								public void run() {
									for(Player alle : Bukkit.getOnlinePlayers()) {
									alle.sendMessage(plugin.getConfig().getString("Nachrichten.Nextround").replace("%PREFIX%", plugin.prefix()).replace('&', '§'));
									}
								}
							}, 20*10L);
				        	 
				        	 Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
								
								@Override
								public void run() {
									plugin.GameState = true;
									plugin.runde3 = true;
									
									double x3 = plugin.getConfig().getDouble("Arena3.x");
									double y3 = plugin.getConfig().getDouble("Arena3.y");
									double z3 = plugin.getConfig().getDouble("Arena3.z");
									 
							        String welt3 = plugin.getConfig().getString("Arena3.world");
							        plugin.saveConfig();
							        World world3 = Bukkit.getServer().getWorld(welt3);
							        Location loca = new Location(world3, x3, y3, z3);
							        
							        for(Player alle : Bukkit.getOnlinePlayers()) {
							        	alle.teleport(loca);
							        	
							        }
									
								}
							}, 20*12L);
				         }
				          
				          
				          
					}
					
					
					
					
				}
					
				
			}
		}
	}


