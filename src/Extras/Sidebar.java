package Extras;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;

import JumpDown.Main;

public class Sidebar implements Listener {
	
	private Main plugin;
	
	public Sidebar(Main plugin) {
		this.plugin = plugin;
		this.plugin.getServer().getPluginManager().registerEvents(this, plugin);
	}
	
	@EventHandler
	public void onJoin(PlayerJoinEvent event) {
			sendScoreboard(event.getPlayer());

		
	}

	private void sendScoreboard(Player player) {
		Scoreboard board = Bukkit.getScoreboardManager().getNewScoreboard();
		Objective objekt = board.registerNewObjective("bla", "blalalla");
		
		
		objekt.setDisplayName(plugin.getConfig().getString("Scoreboard.title").replace('&', '§'));
		objekt.setDisplaySlot(DisplaySlot.SIDEBAR);
		
		Score zero = objekt.getScore(plugin.getConfig().getString("Scoreboard.0").replace('&', '§'));
		
		zero.setScore(0);
		
		player.setScoreboard(board);
		
	}
	
	@SuppressWarnings("unused")
	private void ScoreboardRundenCountdown(Player player) {
		Scoreboard runde1 = Bukkit.getScoreboardManager().getNewScoreboard();
		Objective obj1 = runde1.registerNewObjective("aa", "asd");
		
		obj1.setDisplayName("");
		obj1.setDisplaySlot(DisplaySlot.SIDEBAR);
		
		Score nulll = obj1.getScore(plugin.getConfig().getString("Scoreboard.0").replace('&', '§'));
		
		nulll.setScore(0);
		
		player.setScoreboard(runde1);
	}
	
	
	

}
