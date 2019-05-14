package fr.WalexFelwin.OktaliaFaction.Event;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.inventory.Inventory;

public class InvCloseEvent implements Listener {
	
	@EventHandler
	public void closeinv(InventoryCloseEvent event) {
		
		Inventory inv = event.getInventory();
		
		if(inv.getName().equalsIgnoreCase("§7§lKit §6§lMaitre")){
			event.getPlayer().sendMessage("");
			event.getPlayer().sendMessage("§7§m§l                                       ");
			event.getPlayer().sendMessage("");
			event.getPlayer().sendMessage("§eSi tu souhaite avoir plus de détail§f: §6https://www.oktalia.fr/");
			event.getPlayer().sendMessage("");
			event.getPlayer().sendMessage("§7§m§l                                       ");
			event.getPlayer().sendMessage("");
            
            }
        if(inv.getName().equalsIgnoreCase("§7§lKit §b§lVIP")){
        	
        	event.getPlayer().sendMessage("");
			event.getPlayer().sendMessage("§7§m§l                                       ");
			event.getPlayer().sendMessage("");
			event.getPlayer().sendMessage("§eSi tu souhaite avoir plus de détail§f: §6https://www.oktalia.fr/");
			event.getPlayer().sendMessage("");
			event.getPlayer().sendMessage("§7§m§l                                       ");
			event.getPlayer().sendMessage("");
            
            }
        if(inv.getName().equalsIgnoreCase("§7§lKit §e§lVIP+")){
        	
        	event.getPlayer().sendMessage("");
			event.getPlayer().sendMessage("§7§m§l                                       ");
			event.getPlayer().sendMessage("");
			event.getPlayer().sendMessage("§eSi tu souhaite avoir plus de détail§f: §6https://www.oktalia.fr/");
			event.getPlayer().sendMessage("");
			event.getPlayer().sendMessage("§7§m§l                                       ");
			event.getPlayer().sendMessage("");
            
            }
        if(inv.getName().equalsIgnoreCase("§7§lKit §b§lLegionnaire")){
            
        	event.getPlayer().sendMessage("");
			event.getPlayer().sendMessage("§7§m§l                                       ");
			event.getPlayer().sendMessage("");
			event.getPlayer().sendMessage("§eSi tu souhaite avoir plus de détail§f: §6https://www.oktalia.fr/");
			event.getPlayer().sendMessage("");
			event.getPlayer().sendMessage("§7§m§l                                       ");
			event.getPlayer().sendMessage("");
        	
            }
        if(inv.getName().equalsIgnoreCase("§7§lKit §2§lVoyageur")){
        	
        	event.getPlayer().sendMessage("");
			event.getPlayer().sendMessage("§7§m§l                                       ");
			event.getPlayer().sendMessage("");
			event.getPlayer().sendMessage("§eSi tu souhaite avoir plus de détail§f: §6https://www.oktalia.fr/");
			event.getPlayer().sendMessage("");
			event.getPlayer().sendMessage("§7§m§l                                       ");
			event.getPlayer().sendMessage("");

            }
        if(inv.getName().equalsIgnoreCase("§7§lKit §9§lMonarque")){
        	
        	event.getPlayer().sendMessage("");
			event.getPlayer().sendMessage("§7§m§l                                       ");
			event.getPlayer().sendMessage("");
			event.getPlayer().sendMessage("§eSi tu souhaite avoir plus de détail§f: §6https://www.oktalia.fr/");
			event.getPlayer().sendMessage("");
			event.getPlayer().sendMessage("§7§m§l                                       ");
			event.getPlayer().sendMessage("");

            }
	}
}
