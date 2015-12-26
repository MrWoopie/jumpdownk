package Listeners;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

import JumpDown.Main;

public class QuitMSG implements Listener{
	
	private Main plugin;
	
	public QuitMSG(Main plugin) {
		this.plugin = plugin;
		this.plugin.getServer().getPluginManager().registerEvents(this, plugin);
	}
	
	@EventHandler
	public void onQuitNachrichten(PlayerQuitEvent event) {
		Player p = event.getPlayer();
		
		if (plugin.game.size() == 23) {
		      String c1 = plugin.getConfig().getString("Quit.Wenn23").replace("&", "§").replace("%PREFIX%", plugin.prefix()).replace("%LIMIT%", String.valueOf(plugin.getConfig().getInt("start.max")));
		      c1 = c1.replace("%PLAYER%", p.getName());
		      Bukkit.broadcastMessage(c1);
		      
		    }
		if (plugin.game.size() == 22) {
		      String c1 = plugin.getConfig().getString("Quit.Wenn22").replace("&", "§").replace("%PREFIX%", plugin.prefix()).replace("%LIMIT%", String.valueOf(plugin.getConfig().getInt("start.max")));
		      c1 = c1.replace("%PLAYER%", p.getName());
		      Bukkit.broadcastMessage(c1);
		      
		    }
		if (plugin.game.size() == 21) {
		      String c1 = plugin.getConfig().getString("Quit.Wenn21").replace("&", "§").replace("%PREFIX%", plugin.prefix()).replace("%LIMIT%", String.valueOf(plugin.getConfig().getInt("start.max")));
		      c1 = c1.replace("%PLAYER%", p.getName());
		      Bukkit.broadcastMessage(c1);
		      
		    }
		if (plugin.game.size() == 20) {
		      String c1 = plugin.getConfig().getString("Quit.Wenn20").replace("&", "§").replace("%PREFIX%", plugin.prefix()).replace("%LIMIT%", String.valueOf(plugin.getConfig().getInt("start.max")));
		      c1 = c1.replace("%PLAYER%", p.getName());
		      Bukkit.broadcastMessage(c1);
		      
		    }
		if (plugin.game.size() == 19) {
		      String c1 = plugin.getConfig().getString("Quit.Wenn19").replace("&", "§").replace("%PREFIX%", plugin.prefix()).replace("%LIMIT%", String.valueOf(plugin.getConfig().getInt("start.max")));
		      c1 = c1.replace("%PLAYER%", p.getName());
		      Bukkit.broadcastMessage(c1);
		      
		    }
		if (plugin.game.size() == 18) {
		      String c1 = plugin.getConfig().getString("Quit.Wenn18").replace("&", "§").replace("%PREFIX%", plugin.prefix()).replace("%LIMIT%", String.valueOf(plugin.getConfig().getInt("start.max")));
		      c1 = c1.replace("%PLAYER%", p.getName());
		      Bukkit.broadcastMessage(c1);
		      
		    }
		if (plugin.game.size() == 17) {
		      String c1 = plugin.getConfig().getString("Quit.Wenn17").replace("&", "§").replace("%PREFIX%", plugin.prefix()).replace("%LIMIT%", String.valueOf(plugin.getConfig().getInt("start.max")));
		      c1 = c1.replace("%PLAYER%", p.getName());
		      Bukkit.broadcastMessage(c1);
		      
		    }
		if (plugin.game.size() == 16) {
		      String c1 = plugin.getConfig().getString("Quit.Wenn16").replace("&", "§").replace("%PREFIX%", plugin.prefix()).replace("%LIMIT%", String.valueOf(plugin.getConfig().getInt("start.max")));
		      c1 = c1.replace("%PLAYER%", p.getName());
		      Bukkit.broadcastMessage(c1);
		      
		    }
		if (plugin.game.size() == 15) {
		      String c1 = plugin.getConfig().getString("Quit.Wenn15").replace("&", "§").replace("%PREFIX%", plugin.prefix()).replace("%LIMIT%", String.valueOf(plugin.getConfig().getInt("start.max")));
		      c1 = c1.replace("%PLAYER%", p.getName());
		      Bukkit.broadcastMessage(c1);
		      
		    }
		if (plugin.game.size() == 14) {
		      String c1 = plugin.getConfig().getString("Quit.Wenn14").replace("&", "§").replace("%PREFIX%", plugin.prefix()).replace("%LIMIT%", String.valueOf(plugin.getConfig().getInt("start.max")));
		      c1 = c1.replace("%PLAYER%", p.getName());
		      Bukkit.broadcastMessage(c1);
		      
		    }
		if (plugin.game.size() == 13) {
		      String c1 = plugin.getConfig().getString("Quit.Wenn13").replace("&", "§").replace("%PREFIX%", plugin.prefix()).replace("%LIMIT%", String.valueOf(plugin.getConfig().getInt("start.max")));
		      c1 = c1.replace("%PLAYER%", p.getName());
		      Bukkit.broadcastMessage(c1);
		      
		    }
		if (plugin.game.size() == 12) {
			      String c1 = plugin.getConfig().getString("Quit.Wenn12").replace("&", "§").replace("%PREFIX%", plugin.prefix()).replace("%LIMIT%", String.valueOf(plugin.getConfig().getInt("start.max")));
			      c1 = c1.replace("%PLAYER%", p.getName());
			      Bukkit.broadcastMessage(c1);
			      
			    }
		if (plugin.game.size() == 11) {
		      String c1 = plugin.getConfig().getString("Quit.Wenn11").replace("&", "§").replace("%PREFIX%", plugin.prefix()).replace("%LIMIT%", String.valueOf(plugin.getConfig().getInt("start.max")));
		      c1 = c1.replace("%PLAYER%", p.getName());
		      Bukkit.broadcastMessage(c1);
		      
		    }
		    

		if (plugin.game.size() == 10) {
		      String c1 = plugin.getConfig().getString("Quit.Wenn10").replace("&", "§").replace("%PREFIX%", plugin.prefix()).replace("%LIMIT%", String.valueOf(plugin.getConfig().getInt("start.max")));
		      c1 = c1.replace("%PLAYER%", p.getName());
		      Bukkit.broadcastMessage(c1);
		      
		    }
		if (plugin.game.size() == 9) {
		      String c1 = plugin.getConfig().getString("Quit.Wenn9").replace("&", "§").replace("%PREFIX%", plugin.prefix()).replace("%LIMIT%", String.valueOf(plugin.getConfig().getInt("start.max")));
		      c1 = c1.replace("%PLAYER%", p.getName());
		      Bukkit.broadcastMessage(c1);
		      
		    }
		    if (plugin.game.size() == 8)
		    {
		      String c1 = plugin.getConfig().getString("Quit.Wenn8").replace("&", "§").replace("%PREFIX%", plugin.prefix()).replace("%LIMIT%", String.valueOf(plugin.getConfig().getInt("start.max")));
		      c1 = c1.replace("%PLAYER%", p.getName());
		      Bukkit.broadcastMessage(c1);
		    }
		    if (plugin.game.size() == 7)
		    {
		      String c1 = plugin.getConfig().getString("Quit.Wenn7").replace("&", "§").replace("%PREFIX%", plugin.prefix()).replace("%LIMIT%", String.valueOf(plugin.getConfig().getInt("start.max")));
		      c1 = c1.replace("%PLAYER%", p.getName());
		      Bukkit.broadcastMessage(c1);
		    }
		    if (plugin.game.size() == 6)
		    {
		      String c1 = plugin.getConfig().getString("Quit.Wenn6").replace("&", "§").replace("%PREFIX%", plugin.prefix()).replace("%LIMIT%", String.valueOf(plugin.getConfig().getInt("start.max")));
		      c1 = c1.replace("%PLAYER%", p.getName());
		      Bukkit.broadcastMessage(c1);
		    }
		    if (plugin.game.size() == 5)
		    {
		      String c1 = plugin.getConfig().getString("Quit.Wenn5").replace("&", "§").replace("%PREFIX%", plugin.prefix()).replace("%LIMIT%", String.valueOf(plugin.getConfig().getInt("start.max")));
		      c1 = c1.replace("%PLAYER%", p.getName());
		      Bukkit.broadcastMessage(c1);
		    }
		    if (plugin.game.size() == 4)
		    {
		      String c1 = plugin.getConfig().getString("Quit.Wenn4").replace("&", "§").replace("%PREFIX%", plugin.prefix()).replace("%LIMIT%", String.valueOf(plugin.getConfig().getInt("start.max")));
		      c1 = c1.replace("%PLAYER%", p.getName());
		      Bukkit.broadcastMessage(c1);
		    }
		    if (plugin.game.size() == 3)
		    {
		      String c1 = plugin.getConfig().getString("Quit.Wenn3").replace("&", "§").replace("%PREFIX%", plugin.prefix()).replace("%LIMIT%", String.valueOf(plugin.getConfig().getInt("start.max")));
		      c1 = c1.replace("%PLAYER%", p.getName());
		      Bukkit.broadcastMessage(c1);
		    }
		    if (plugin.game.size() == 2)
		    {
		      String c1 = plugin.getConfig().getString("Quit.Wenn2").replace("&", "§").replace("%PREFIX%", plugin.prefix()).replace("%LIMIT%", String.valueOf(plugin.getConfig().getInt("start.max")));
		      c1 = c1.replace("%PLAYER%", p.getName());
		      Bukkit.broadcastMessage(c1);
		    }
		    if(plugin.game.size() == 1) {
		    	String c1 = plugin.getConfig().getString("Quit.Wenn1").replace("&", "§").replace("%PREFIX%", plugin.prefix()).replace("%LIMIT%", String.valueOf(plugin.getConfig().getInt("start.max")));
			      c1 = c1.replace("%PLAYER%", p.getName());
			      Bukkit.broadcastMessage(c1);
		    }
	}
}
