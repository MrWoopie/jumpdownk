package Listeners;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import JumpDown.Main;

public class JoinMSG implements Listener{
	
	private Main plugin;
	
	public JoinMSG(Main plugin) {
		this.plugin = plugin;
		this.plugin.getServer().getPluginManager().registerEvents(this, plugin);
	}
	
	@EventHandler
	public void onJoinNachrichten(PlayerJoinEvent event) {
		Player p = event.getPlayer();
		

		
		event.setJoinMessage(null);
		
		if (plugin.getConfig().getBoolean("setupfinished") == true)	{
			
			if(plugin.game.size() == 0) {
				String c1 = plugin.getConfig().getString("Join.Wenn0").replace("&", "§").replace("%PREFIX%", plugin.prefix()).replace("%LIMIT%", String.valueOf(plugin.getConfig().getInt("start.max")));
		        c1 = c1.replace("%PLAYER%", p.getDisplayName());
		        Bukkit.broadcastMessage(c1);
			} else
	    	
	    	if (plugin.game.size() == 1) {
		        String c1 = plugin.getConfig().getString("Join.Wenn1").replace("&", "§").replace("%PREFIX%", plugin.prefix()).replace("%LIMIT%", String.valueOf(plugin.getConfig().getInt("start.max")));
		        c1 = c1.replace("%PLAYER%", p.getDisplayName());
		        Bukkit.broadcastMessage(c1);
		      }
		      if (plugin.game.size() == 2) {
		        String c1 = plugin.getConfig().getString("Join.Wenn2").replace("&", "§").replace("%PREFIX%", plugin.prefix()).replace("%LIMIT%", String.valueOf(plugin.getConfig().getInt("start.max")));
		        c1 = c1.replace("%PLAYER%", p.getDisplayName());
		        Bukkit.broadcastMessage(c1);
		      }
		      if (plugin.game.size() == 3) {
		        String c1 = plugin.getConfig().getString("Join.Wenn3").replace("&", "§").replace("%PREFIX%", plugin.prefix()).replace("%LIMIT%", String.valueOf(plugin.getConfig().getInt("start.max")));
		        c1 = c1.replace("%PLAYER%", p.getDisplayName());
		        Bukkit.broadcastMessage(c1);
		      }
		      if (plugin.game.size() == 4)  {
		        String c1 = plugin.getConfig().getString("Join.Wenn4").replace("&", "§").replace("%PREFIX%", plugin.prefix()).replace("%LIMIT%", String.valueOf(plugin.getConfig().getInt("start.max")));
		        c1 = c1.replace("%PLAYER%", p.getDisplayName());
		        Bukkit.broadcastMessage(c1);
		      }
		      if (plugin.game.size() == 5) {
		    	 String c1 = plugin.getConfig().getString("Join.Wenn5").replace("&", "§").replace("%PREFIX%", plugin.prefix()).replace("%LIMIT%", String.valueOf(plugin.getConfig().getInt("start.max")));
		        c1 = c1.replace("%PLAYER%", p.getDisplayName());
		        Bukkit.broadcastMessage(c1);
		      }
		      if (plugin.game.size() == 6) {
		        String c1 = plugin.getConfig().getString("Join.Wenn6").replace("&", "§").replace("%PREFIX%", plugin.prefix()).replace("%LIMIT%", String.valueOf(plugin.getConfig().getInt("start.max")));
		        c1 = c1.replace("%PLAYER%", p.getDisplayName());
		        Bukkit.broadcastMessage(c1);
		      }
		      if (plugin.game.size() == 7)  {
		        String c1 = plugin.getConfig().getString("Join.Wenn7").replace("&", "§").replace("%PREFIX%", plugin.prefix()).replace("%LIMIT%", String.valueOf(plugin.getConfig().getInt("start.max")));
		        c1 = c1.replace("%PLAYER%", p.getDisplayName());
		        Bukkit.broadcastMessage(c1);
		      }
		      if (plugin.game.size() == 8)  {
		        String c1 = plugin.getConfig().getString("Join.Wenn8").replace("&", "§").replace("%PREFIX%", plugin.prefix()).replace("%LIMIT%", String.valueOf(plugin.getConfig().getInt("start.max")));
		        c1 = c1.replace("%PLAYER%", p.getDisplayName());
		        Bukkit.broadcastMessage(c1);
		      }
		      if (plugin.game.size() == 9)	      {
		        String c1 = plugin.getConfig().getString("Join.Wenn9").replace("&", "§").replace("%PREFIX%", plugin.prefix()).replace("%LIMIT%", String.valueOf(plugin.getConfig().getInt("start.max")));
		        c1 = c1.replace("%PLAYER%", p.getDisplayName());
		        Bukkit.broadcastMessage(c1);
		      }
		      if (plugin.game.size() == 10)	      {
		        String c1 = plugin.getConfig().getString("Join.Wenn10").replace("&", "§").replace("%PREFIX%", plugin.prefix()).replace("%LIMIT%", String.valueOf(plugin.getConfig().getInt("start.max")));
		        c1 = c1.replace("%PLAYER%", p.getDisplayName());
		        Bukkit.broadcastMessage(c1);
		      }
		      if (plugin.game.size() == 11)	      {
			        String c1 = plugin.getConfig().getString("Join.Wenn11").replace("&", "§").replace("%PREFIX%", plugin.prefix()).replace("%LIMIT%", String.valueOf(plugin.getConfig().getInt("start.max")));
			        c1 = c1.replace("%PLAYER%", p.getDisplayName());
			        Bukkit.broadcastMessage(c1);
			      }
		      if (plugin.game.size() == 12)	      {
			        String c1 = plugin.getConfig().getString("Join.Wenn12").replace("&", "§").replace("%PREFIX%", plugin.prefix()).replace("%LIMIT%", String.valueOf(plugin.getConfig().getInt("start.max")));
			        c1 = c1.replace("%PLAYER%", p.getDisplayName());
			        Bukkit.broadcastMessage(c1);
			      }
		      if (plugin.game.size() == 13)	      {
			        String c1 = plugin.getConfig().getString("Join.Wenn13").replace("&", "§").replace("%PREFIX%", plugin.prefix()).replace("%LIMIT%", String.valueOf(plugin.getConfig().getInt("start.max")));
			        c1 = c1.replace("%PLAYER%", p.getDisplayName());
			       
			        Bukkit.broadcastMessage(c1);
			      }
		      if (plugin.game.size() == 14)	      {
			        String c1 = plugin.getConfig().getString("Join.Wenn14").replace("&", "§").replace("%PREFIX%", plugin.prefix()).replace("%LIMIT%", String.valueOf(plugin.getConfig().getInt("start.max")));
			        c1 = c1.replace("%PLAYER%", p.getDisplayName());
			        Bukkit.broadcastMessage(c1);
			      }
		      if (plugin.game.size() == 15)	      {
			        String c1 = plugin.getConfig().getString("Join.Wenn15").replace("&", "§").replace("%PREFIX%", plugin.prefix()).replace("%LIMIT%", String.valueOf(plugin.getConfig().getInt("start.max")));
			        c1 = c1.replace("%PLAYER%", p.getDisplayName());
			        Bukkit.broadcastMessage(c1);
			      }
		      if (plugin.game.size() == 16)	      {
			        String c1 = plugin.getConfig().getString("Join.Wenn16").replace("&", "§").replace("%PREFIX%", plugin.prefix()).replace("%LIMIT%", String.valueOf(plugin.getConfig().getInt("start.max")));
			        c1 = c1.replace("%PLAYER%", p.getDisplayName());
			        Bukkit.broadcastMessage(c1);
			      }
		      if (plugin.game.size() == 17)	      {
			        String c1 = plugin.getConfig().getString("Join.Wenn17").replace("&", "§").replace("%PREFIX%", plugin.prefix()).replace("%LIMIT%", String.valueOf(plugin.getConfig().getInt("start.max")));
			        c1 = c1.replace("%PLAYER%", p.getDisplayName());
			        Bukkit.broadcastMessage(c1);
			      }
		      if (plugin.game.size() == 18)	      {
			        String c1 = plugin.getConfig().getString("Join.Wenn18").replace("&", "§").replace("%PREFIX%", plugin.prefix()).replace("%LIMIT%", String.valueOf(plugin.getConfig().getInt("start.max")));
			        c1 = c1.replace("%PLAYER%", p.getDisplayName());
			        Bukkit.broadcastMessage(c1);
			      }
		      if (plugin.game.size() == 19)	      {
			        String c1 = plugin.getConfig().getString("Join.Wenn19").replace("&", "§").replace("%PREFIX%", plugin.prefix()).replace("%LIMIT%", String.valueOf(plugin.getConfig().getInt("start.max")));
			        c1 = c1.replace("%PLAYER%", p.getDisplayName());
			        Bukkit.broadcastMessage(c1);
			      }
		      if (plugin.game.size() == 20)	      {
			        String c1 = plugin.getConfig().getString("Join.Wenn20").replace("&", "§").replace("%PREFIX%", plugin.prefix()).replace("%LIMIT%", String.valueOf(plugin.getConfig().getInt("start.max")));
			        c1 = c1.replace("%PLAYER%", p.getDisplayName());
			        Bukkit.broadcastMessage(c1);
			      }
		      if (plugin.game.size() == 21)	      {
			        String c1 = plugin.getConfig().getString("Join.Wenn21").replace("&", "§").replace("%PREFIX%", plugin.prefix()).replace("%LIMIT%", String.valueOf(plugin.getConfig().getInt("start.max")));
			        c1 = c1.replace("%PLAYER%", p.getDisplayName());
			        Bukkit.broadcastMessage(c1);
			      }
		      if (plugin.game.size() == 22)	      {
			        String c1 = plugin.getConfig().getString("Join.Wenn22").replace("&", "§").replace("%PREFIX%", plugin.prefix()).replace("%LIMIT%", String.valueOf(plugin.getConfig().getInt("start.max")));
			        c1 = c1.replace("%PLAYER%", p.getDisplayName());
			        Bukkit.broadcastMessage(c1);
			      }
		      if (plugin.game.size() == 23)	      {
			        String c1 = plugin.getConfig().getString("Join.Wenn23").replace("&", "§").replace("%PREFIX%", plugin.prefix()).replace("%LIMIT%", String.valueOf(plugin.getConfig().getInt("start.max")));
			        c1 = c1.replace("%PLAYER%", p.getDisplayName());
			        Bukkit.broadcastMessage(c1);
			      }
		      if (plugin.game.size() == 24)	      {
			        String c1 = plugin.getConfig().getString("Join.Wenn24").replace("&", "§").replace("%PREFIX%", plugin.prefix()).replace("%LIMIT%", String.valueOf(plugin.getConfig().getInt("start.max")));
			        c1 = c1.replace("%PLAYER%", p.getDisplayName());
			        Bukkit.broadcastMessage(c1);
			      }
	    	
	    }
		
	}

}
