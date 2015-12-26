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

public class Move3 implements Listener {
	
	private Main plugin;
	
	private int lobby = 28;
	
	public Move3(Main plugin) {
		this.plugin = plugin;
		this.plugin.getServer().getPluginManager().registerEvents(this, plugin);
	}
	
	@SuppressWarnings("deprecation")
	@EventHandler (priority = EventPriority.HIGHEST)
	public void onArena3(PlayerMoveEvent event) {
		Player p = event.getPlayer();
		
		if(plugin.GameState) {
			if(plugin.runde3) {
				int Y = plugin.getConfig().getInt("Height3.y");
				if(event.getTo().getY() <= Y && p.isOnGround()) {
					
					
					if(p.isDead()) {
						double x = plugin.getConfig().getDouble("Arena3.x");
						double y = plugin.getConfig().getDouble("Arena3.y");
						double z = plugin.getConfig().getDouble("Arena3.z");
						
						String welt = plugin.getConfig().getString("Arena3.world");
						plugin.saveConfig();
						World world = plugin.getServer().getWorld(welt);
						Location loc = new Location(world, x, y, z);
						
						p.teleport(loc);
					} else {
						plugin.GameState = false;
						plugin.runde3 = false;
						
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
								Bukkit.broadcastMessage(plugin.prefix() + " Kehre zurück zur Lobby");
								
							}
						}, 20*8L);
						
						Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
							
							double xl = plugin.getConfig().getDouble("Lobby.x");
							double yl = plugin.getConfig().getDouble("Lobby.y");
							double zl = plugin.getConfig().getDouble("Lobby.z");
							String lobby = plugin.getConfig().getString("Lobby.world");
							World worldl = plugin.getServer().getWorld(lobby);
							Location lob = new Location(worldl, xl, yl, zl);
							
							
							
							@Override
							public void run() {
								for(Player alle : Bukkit.getOnlinePlayers()) {
									alle.teleport(lob);
									alle.playSound(alle.getLocation(), Sound.SUCCESSFUL_HIT, 10F, 1F);
								}
								String allplayers1 = "";
								for(Player x : plugin.gewinner1) {
									allplayers1 += x.getDisplayName();
								}
								
								String allplayers2 = "";
								for(Player x : plugin.gewinner1) {
									allplayers2 += x.getDisplayName();
								}
								
								String allplayers3 = "";
								for(Player x : plugin.gewinner1) {
									allplayers3 += x.getDisplayName();
								}
								
								
								Bukkit.broadcastMessage(plugin.prefix() + plugin.getConfig().getString("Nachrichten.Runde1").replace("%PLAYER%", allplayers1.substring(0, allplayers1.length())).replace('&', '§'));
								Bukkit.broadcastMessage(plugin.prefix() + plugin.getConfig().getString("Nachrichten.Runde2").replace("%PLAYER%", allplayers2.substring(0, allplayers2.length())).replace('&', '§'));
								Bukkit.broadcastMessage(plugin.prefix() + plugin.getConfig().getString("Nachrichten.Runde3").replace("%PLAYER%", allplayers3.substring(0, allplayers3.length())).replace('&', '§'));

							}
						}, 20*10L);
						
						
						
						
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
					}, 20*28L);
						
						
								
						
						
						
						
						
						
						
					}
						
				
						
			
					
				}
	
			}
		}
		
		
		
		
		
		
		
		
		
		
		
	}

}
