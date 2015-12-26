package JumpDown;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.plugin.java.JavaPlugin;

import API.TitleAPI;
import Commands.Arena1;
import Commands.Arena2;
import Commands.Arena3;
import Commands.Boden1;
import Commands.Boden2;
import Commands.Boden3;
import Commands.Fertig;
import Commands.Lobby;
import Commands.Start;
import Extras.Sidebar;
import GameManager.Move;
import GameManager.Move2;
import GameManager.Move3;
import Items.Interact;
import Listeners.Join;
import Listeners.JoinMSG;
import Listeners.Login;
import Listeners.Quit;
import Listeners.QuitMSG;
import Listeners.Interactions.CancelledEvents;
import Listeners.Interactions.Death;
import Listeners.Interactions.PlayerEvents;

public class Main extends JavaPlugin{
	
public Inventory inv = null;
	
  public ArrayList<String> TodNachrichten = new ArrayList<>();
  public ArrayList<Player> gewinner1 = new ArrayList<>();
  public ArrayList<Player> gewinner2 = new ArrayList<>();
  public ArrayList<Player> gewinner3 = new ArrayList<>();
  public ArrayList<Player> game = new ArrayList<>();
  
  public List<String> lore = new ArrayList<String>();
  
  public String welt = getConfig().getString("Arena1.world");
  public String welt2 = getConfig().getString("Arena2.world");
  public String welt3 = getConfig().getString("Arena3.world");
  
  public ArrayList<Player> voted = new ArrayList<>();
  public HashMap<String, Integer> votes = new HashMap<String, Integer>();
  public List<String> arenas = new ArrayList<>();
  
  
  public boolean GameState = false;
  public boolean running = false;
  public boolean starting = false;
  public boolean InGame = false;
  public boolean runde1 = false;
  public boolean runde2 = false;
  public boolean runde3 = false;
  public boolean restart = false;
  public boolean won = false;
  
  public int countdown = 5;
  String prefix;
  
  public void loadConfig() {
	    getConfig().options().copyDefaults(true);
	    saveConfig();
  }
  
  public void onEnable() {
	onenablemsg();
    initializeClasses();
    initCommands();
    invgui();
    lore();
    randomTod();
    Extras();
    loadConfig();
    GameManagers();
    getArenas();
    this.GameState = false;
    this.starting = false;
    this.running = true;
    this.InGame = false;
    this.restart = false;
    this.won = false;
  }
  
  public void onDisable() {
	  Bukkit.getConsoleSender().sendMessage("              §cDEACTIVATED               ");
  }
  public String prefix() {
	  
	  prefix = getConfig().getString("Prefix").replace('&', '§');
	  
	  return prefix;
  }
  
  public void invgui() {
	  new Interact(this);
	  new Items.Join(this);
  }
  
  public void initCommands() {
	  Start start = new Start(this);
	  Arena1 a1 = new Arena1(this);
	  Arena2 a2 = new Arena2(this);
	  Arena3 a3 = new Arena3(this);
	  Boden1 b1 = new Boden1(this);
	  Boden2 b2 = new Boden2(this);
	  Boden3 b3 = new Boden3(this);
	  Lobby l = new Lobby(this);
	  Fertig f = new Fertig(this);
	  
	  
	  getCommand("start").setExecutor(start);
	  getCommand("arena1").setExecutor(a1);
	  getCommand("arena2").setExecutor(a2);
	  getCommand("arena3").setExecutor(a3);
	  getCommand("boden1").setExecutor(b1);
	  getCommand("boden2").setExecutor(b2);
	  getCommand("boden3").setExecutor(b3);
	  getCommand("lobby").setExecutor(l);
	  getCommand("fertig").setExecutor(f);
  }
  
  public void lore() {
	  lore.add(ChatColor.AQUA + "Votes " + votes.values().toString());
  }
  
  
  public void initializeClasses() {
	  new Join(this);
	  new JoinMSG(this);
	  new Death(this);
	  new Login(this);
	  new CancelledEvents(this);
	  new Quit(this);
	  new QuitMSG(this);
	  new PlayerEvents(this);
	  new TitleAPI(this);
	  
	
  }
  
  public void GameManagers() {
	  new Move(this);
	  new Move2(this);
	  new Move3(this);
  }
  
  public void Extras() {
	  new Sidebar(this);
  }
  
  public void getArenas() {
	  
	  arenas.add(welt);
	  arenas.add(welt2);
	  arenas.add(welt3);
	  
	  votes.put(welt, 0);
	  votes.put(welt2, 0);
	  votes.put(welt3, 0);
	  
  }
  
  public void onenablemsg() {
		Bukkit.getConsoleSender().sendMessage("                             ");
		Bukkit.getConsoleSender().sendMessage("              §2§lACTIVE              ");
		Bukkit.getConsoleSender().sendMessage("                             ");
	    Bukkit.getConsoleSender().sendMessage("===========§7[§3§lJumpDown§7]§r============");
	    Bukkit.getConsoleSender().sendMessage("§a§oAuthor | " + this.getDescription().getAuthors());
	    Bukkit.getConsoleSender().sendMessage("§a§oVersion | " + this.getDescription().getVersion());
	    Bukkit.getConsoleSender().sendMessage("§a§oCommands |" + this.getDescription().getCommands().toString());
	    Bukkit.getConsoleSender().sendMessage("==========§7[§a§oby MrWoopie]§r==========");
	    Bukkit.getConsoleSender().sendMessage("                             ");
	    Bukkit.getConsoleSender().sendMessage("              §2§lACTIVE              ");
	    Bukkit.getConsoleSender().sendMessage("                             ");
  }
  
	public void randomTod() {
		TodNachrichten.add(getConfig().getString("Randomtod.1").replace("%PREFIX%", prefix()));
		TodNachrichten.add(getConfig().getString("Randomtod.2").replace("%PREFIX%", prefix()));
		TodNachrichten.add(getConfig().getString("Randomtod.4").replace("%PREFIX%", prefix()));
		TodNachrichten.add(getConfig().getString("Randomtod.5").replace("%PREFIX%", prefix()));
		TodNachrichten.add(getConfig().getString("Randomtod.6").replace("%PREFIX%", prefix()));
		TodNachrichten.add(getConfig().getString("Randomtod.7").replace("%PREFIX%", prefix()));
		TodNachrichten.add(getConfig().getString("Randomtod.8").replace("%PREFIX%", prefix()));
		TodNachrichten.add(getConfig().getString("Randomtod.9").replace("%PREFIX%", prefix()));
		TodNachrichten.add(getConfig().getString("Randomtod.10").replace("%PREFIX%", prefix()));
		TodNachrichten.add(getConfig().getString("Randomtod.11").replace("%PREFIX%", prefix()));
		TodNachrichten.add(getConfig().getString("Randomtod.12").replace("%PREFIX%", prefix()));
	}

  
}
