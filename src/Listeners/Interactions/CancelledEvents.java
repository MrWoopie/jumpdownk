package Listeners.Interactions;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;

import JumpDown.Main;

public class CancelledEvents implements Listener {

	private Main plugin;
	
	public CancelledEvents(Main plugin) {
		this.plugin = plugin;
		this.plugin.getServer().getPluginManager().registerEvents(this, plugin);
	}
	
	  @EventHandler
	  public void onPlayerFoodLevel(FoodLevelChangeEvent event) {
	    event.setCancelled(true);
	  }
	  
	  @EventHandler
	  public void onBreak(BlockBreakEvent event)  {
	    Player p = event.getPlayer();
	   
	    if (p.hasPermission("jumpdown.admin")) {
	      event.setCancelled(false);
	    }
	    else {
	      event.setCancelled(true);
	    }
	  }
	
}
