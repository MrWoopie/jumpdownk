package Listeners.Interactions;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerPickupItemEvent;

import JumpDown.Main;

public class PlayerEvents implements Listener {
	
	private Main plugin;
	
	public PlayerEvents(Main plugin) {
		this.plugin = plugin;
		this.plugin.getServer().getPluginManager().registerEvents(this, plugin);
	}
	
	@EventHandler
	public void onBlockBreak(BlockBreakEvent e) {
		if(plugin.running) {
			if(e.getPlayer().hasPermission("user.admin")) {
				e.setCancelled(false);
			} else {
		e.setCancelled(true);
			}
		}
	}
	
		@EventHandler
	public void onBlockPlace(BlockPlaceEvent e) {
		if(plugin.running) {
			if(e.getPlayer().hasPermission("user.admin")) {
				e.setCancelled(false);
			} else {
		e.setCancelled(true);
			}
		}
	}
		@EventHandler
	public void onPickup(PlayerPickupItemEvent e) {
		if(plugin.running) {
			if(e.getPlayer().hasPermission("user.admin")) {
				e.setCancelled(false);
			} else {
		e.setCancelled(true);
			}
		}
	}
		@EventHandler
	public void onDrop(PlayerDropItemEvent e) {
		if(plugin.running) {
			if(e.getPlayer().hasPermission("user.admin")) {
				e.setCancelled(false);
			} else {
		e.setCancelled(true);
			}
		}
	}
		
	@EventHandler
	public void onInv(InventoryClickEvent e) {
		if(plugin.running) {
			if(e.getWhoClicked().hasPermission("user.admin")) {
				e.setCancelled(false);
			} else {
		e.setCancelled(true);
			}
		}
	}

		@EventHandler
		public void onFood(FoodLevelChangeEvent e) {
			e.setCancelled(true);
		}
		
	    @EventHandler
	    public void onTestEntityDamage(EntityDamageByEntityEvent event) {
	    	if(plugin.runde1 == false && plugin.runde2 == false && plugin.runde3 == false) {
	        event.setCancelled(true);
	    } else {
	    	event.setCancelled(false);
	    }
	    }
	    
	    @EventHandler
	    public void onDamage(EntityDamageEvent e) {
	    	if(plugin.runde1 == false && plugin.runde2 == false && plugin.runde3 == false) {
	    		e.setCancelled(true);
	    	} else {
	    		e.setCancelled(false);
	    	}
	    }
		

		
	
	

}
