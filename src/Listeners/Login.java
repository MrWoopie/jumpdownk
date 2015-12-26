package Listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;

import JumpDown.Main;

public class Login implements Listener {

	private Main plugin;
	
	public Login(Main plugin) {
		this.plugin = plugin;
		this.plugin.getServer().getPluginManager().registerEvents(this, plugin);
	}
	
	  @EventHandler
	  public void onMayorJoin(PlayerLoginEvent event) {
	    if (plugin.GameState) {
	      String c1 = plugin.getConfig().getString("Message.RoundRunning").replace("&", "§").replace("%PREFIX%", plugin.prefix());
	      event.disallow(PlayerLoginEvent.Result.KICK_OTHER, c1);
	    }
	  }
	
	
}
