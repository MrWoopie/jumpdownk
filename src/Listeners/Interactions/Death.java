package Listeners.Interactions;

import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;

import JumpDown.Main;

import org.bukkit.event.entity.PlayerDeathEvent;

public class Death implements Listener{ 
	
	private Main plugin;
	
	public Death(Main plugin) {
		this.plugin = plugin;
		this.plugin.getServer().getPluginManager().registerEvents(this, plugin);
	}
	
	  @EventHandler (priority = EventPriority.HIGHEST)
	  public void onPlayerDeath(PlayerDeathEvent event) {
	   Player p = event.getEntity().getPlayer();
	   Player killer = event.getEntity().getKiller();
	   
	   event.setDeathMessage(null);
	   
	   Entity ent = event.getEntity();
	   EntityDamageEvent ede = ent.getLastDamageCause();
	   DamageCause dc = ede.getCause();
	   
	   
	   Random r = new Random();
		 String todesnachricht = null;
		 todesnachricht = plugin.TodNachrichten.get(r.nextInt(plugin.TodNachrichten.size()));
		  
		
		 if(ent instanceof Player && dc == DamageCause.FALL) {
		 Bukkit.broadcastMessage(plugin.prefix() + " " + todesnachricht.replace("%PLAYER%", p.getDisplayName()).replace('&', '§').replace("%PREFIX%", plugin.prefix()));
		 }
		 
		 if(ent instanceof Player && dc == DamageCause.ENTITY_ATTACK) {
		 Bukkit.broadcastMessage(plugin.getConfig().getString("Nachrichten.Todkiller").replace('&', '§').replace("%KILLER%", killer.getDisplayName()).replace("%PLAYER%", p.getDisplayName()).replace("oe", "ö").replace("%PREFIX%", plugin.prefix()));
		 }
		 
		 	double x3 = plugin.getConfig().getDouble("Arena3.x");
			double y3 = plugin.getConfig().getDouble("Arena3.y");
			double z3 = plugin.getConfig().getDouble("Arena3.z");
			 
	        String welt3 = plugin.getConfig().getString("Arena3.world");
	        plugin.saveConfig();
	        World world3 = Bukkit.getServer().getWorld(welt3);
	        Location loca = new Location(world3, x3, y3, z3);
	        
	        double x = plugin.getConfig().getDouble("Arena2.x");
			double y = plugin.getConfig().getDouble("Arena2.y");
			double z = plugin.getConfig().getDouble("Arena2.z");
			
			String welt = plugin.getConfig().getString("Arena2.world");
			World world = plugin.getServer().getWorld(welt);
			Location loc = new Location(world, x, y, z);
			
			double xx = plugin.getConfig().getDouble("Arena1.x");
	        double yy = plugin.getConfig().getDouble("Arena1.y");
	        double zz = plugin.getConfig().getDouble("Arena1.z");
	        
	        
	        String arena1 = plugin.getConfig().getString("Arena1.world");
	        World world1 = Bukkit.getServer().getWorld(arena1);
	        Location loce = new Location(world1, xx, yy, zz);
		 
		 
	    if(p.isDead()) {
	    	
	    	if(plugin.runde1) {
	    		event.getEntity().spigot().respawn();
	    		p.teleport(loce);
	    	} else
	    		
	    	if(plugin.runde2) {
	    		event.getEntity().spigot().respawn();
	    		p.teleport(loc);
	    	} else
	    		
	    	if(plugin.runde3) {
	    		event.getEntity().spigot().respawn();
	    		p.teleport(loca);
	    	}
	    	
			
	    }
	    

	    
	  }
	  

}
