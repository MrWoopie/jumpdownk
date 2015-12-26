package Items;

import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import JumpDown.Main;

public class Interact implements Listener {
	
	private Main plugin;
	
	public Interact(Main plugin) {
		this.plugin = plugin;
		this.plugin.getServer().getPluginManager().registerEvents(this, plugin);
	}
	
	
	@EventHandler
	public void onPlayerInteract(PlayerInteractEvent e) {
		Player p = e.getPlayer();
		
		if(e.getAction() == Action.RIGHT_CLICK_AIR | e.getAction() == Action.RIGHT_CLICK_BLOCK) {
				if(e.getMaterial().equals(Material.SLIME_BALL)) {
					p.kickPlayer("§cDu wurdest zurück zur Lobby teleportiert");

					
				} else {

					if(e.getMaterial().equals(Material.PAPER)) {
				
				plugin.inv = p.getServer().createInventory(null, 9, "Map-Vote");
				
				ItemStack ice = new ItemStack(Material.PACKED_ICE);
				ItemMeta imeta = ice.getItemMeta();
				imeta.setDisplayName(plugin.getConfig().getString("Arena1.world"));
				imeta.setLore(plugin.lore);
				ice.setItemMeta(imeta);
				
				plugin.inv.setItem(0, ice);
				
				p.openInventory(plugin.inv);
				p.playSound(p.getLocation(), Sound.CLICK, 10F, 1F);
					}
						
						
						
						
					}
		} 
		}
	
	@EventHandler
	public void onInvClick(InventoryClickEvent e) {
		Player p = (Player) e.getWhoClicked();
		e.setCancelled(true);
		if(e.getInventory().getName().equalsIgnoreCase("Map-Vote")) {
			if(!plugin.voted.contains(p)) {
			plugin.votes.put(plugin.welt, plugin.votes.get(plugin.welt) +1);
			p.closeInventory();
			plugin.voted.add(p);
			p.sendMessage(plugin.prefix() + " Du hast erfolgreich für die Map §e" + plugin.welt + " §7gevoted!");
			} else {
				p.sendMessage(plugin.prefix() + " Du hast schon gevoted");
				p.closeInventory();
				p.playSound(p.getLocation(), Sound.ANVIL_LAND, 10F, 1F);
			}
			
		}
		
		
	}
	
	public void getList(Player p) {

	}
	
	

}
