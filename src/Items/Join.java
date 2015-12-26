package Items;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.ItemMeta;

import JumpDown.Main;

public class Join implements Listener{
	
	private Main plugin;
	
	public Join(Main plugin) {
		this.plugin = plugin;
		this.plugin.getServer().getPluginManager().registerEvents(this, plugin);
	}
	
	@EventHandler
	public void onInvOnJoin(PlayerJoinEvent e) {
		Player p = e.getPlayer();
		PlayerInventory i = p.getInventory();
		
		ItemStack slime = new ItemStack(Material.SLIME_BALL);
		ItemMeta cmeta = slime.getItemMeta();
		cmeta.setDisplayName("§cVerlassen");
		slime.setItemMeta(cmeta);
		
		ItemStack papier = new ItemStack(Material.PAPER);
		ItemMeta papmeta = papier.getItemMeta();
		papmeta.setDisplayName("§3Map-Vote");
		papier.setItemMeta(papmeta);
		
		
		
		if(p.hasPlayedBefore()) {
			if(!i.contains(papier) || i.contains(slime)) {
				i.setItem(8, slime);
				i.setItem(0, papier);
			} else {
				return;
			}
		} else {
			if(i.contains(papier) || i.contains(slime)) {
				i.setItem(8, slime);
				i.setItem(0, papier);
			}
		}
			}

}
