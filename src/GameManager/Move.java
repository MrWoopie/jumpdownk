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

public class Move implements Listener{ 
	
	private Main plugin;
	
	private int cc;
	
	
	public Move(Main plugin) {
		this.plugin = plugin;
		this.plugin.getServer().getPluginManager().registerEvents(this, plugin);
	}
	
	@SuppressWarnings("deprecation")
	@EventHandler (priority = EventPriority.HIGHEST)
	  public void onMoveArena3(PlayerMoveEvent event) {
	
	    
	    
	    Player p = event.getPlayer();
	    if (plugin.GameState) {
	    	if(plugin.runde1) {
	    		int Y = plugin.getConfig().getInt("Height1.y");
	      if ((event.getTo().getY() <= Y) && (p.isOnGround()))  {
	        
	        if (p.isDead()) {
		        double xx = plugin.getConfig().getDouble("Arena1.x");
		        double yy = plugin.getConfig().getDouble("Arena1.y");
		        double zz = plugin.getConfig().getDouble("Arena1.z");
		        
		        
		        String arena1 = plugin.getConfig().getString("Arena1.world");
		        plugin.saveConfig();
		        World world = Bukkit.getServer().getWorld(arena1);
		        Location loce = new Location(world, xx, yy, zz);
	          p.teleport(loce);
	        } else {
	          plugin.runde1 = false;
	          plugin.GameState = false;
	          
	          plugin.gewinner1.add(p);
	          
	          Bukkit.broadcastMessage(plugin.getConfig().getString("Nachrichten.Isonground").replace("%PLAYER%", p.getDisplayName()).replace('&', '§').replace("%PREFIX%", plugin.prefix()));

			          
			          for(Player alle : Bukkit.getOnlinePlayers()) {
				        	 TitleAPI.sendFullTitle(alle, 20, 20*3, 20, "§6Gewinner!", "§6" + p.getDisplayName());
				        	 alle.playSound(alle.getLocation(), Sound.FIREWORK_LAUNCH, 10F, 1F);
				        	 alle.playSound(alle.getLocation(), Sound.FIREWORK_BLAST, 10F, 1F);
				          }
	        	 
	        	 
	        cc = Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
					
					@Override
					public void run() {
						for(Player alle : Bukkit.getOnlinePlayers()) {
							alle.sendMessage(plugin.getConfig().getString("Nachrichten.Nextround").replace("%PREFIX%", plugin.prefix()).replace('&', '§'));
						}
					Bukkit.getScheduler().cancelTask(cc);
					}
					
				}, 20*10L);
	        	 
	        	 Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
					
					@Override
					public void run() {
						plugin.GameState = true;
						plugin.runde2 = true;
						
						double x2 = plugin.getConfig().getDouble("Arena2.x");
						double y2 = plugin.getConfig().getDouble("Arena2.y");
						double z2 = plugin.getConfig().getDouble("Arena2.z");
						 
				        String zwei = plugin.getConfig().getString("Arena2.world");
				        plugin.saveConfig();
				        World world2 = Bukkit.getServer().getWorld(zwei);
				        Location loca = new Location(world2, x2, y2, z2);
				        
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


