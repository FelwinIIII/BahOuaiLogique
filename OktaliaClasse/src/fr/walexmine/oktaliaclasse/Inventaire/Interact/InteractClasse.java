package fr.walexmine.oktaliaclasse.Inventaire.Interact;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

import fr.walexmine.oktaliaclasse.Main;


public class InteractClasse  implements Listener{

	public InteractClasse(Main main) {
		
	}
	
	 @EventHandler
	  public void onInventoryClickEvent(InventoryClickEvent e)
	  {
		 
	    Player p = (Player)e.getWhoClicked();

	    
	    if (p.getOpenInventory().getTopInventory().getTitle().equalsIgnoreCase("§eMenu Classe §6!"))
	    {

	     
	    	e.setCancelled(true);     
	        if ((e.getCurrentItem() == null) && (e.getCurrentItem().getType() == Material.AIR))
	        {
	        	return;
	        } else {
	        	
	        	ItemStack item = e.getCurrentItem();

	        }
	    }
	  }
}
