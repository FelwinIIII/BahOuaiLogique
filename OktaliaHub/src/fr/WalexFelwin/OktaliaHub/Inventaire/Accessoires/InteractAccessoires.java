package fr.WalexFelwin.OktaliaHub.Inventaire.Accessoires;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

import fr.WalexFelwin.OktaliaHub.Main;

public class InteractAccessoires implements Listener{

	
	public InteractAccessoires(Main main){
		
	}

	  @EventHandler
	  public void onInventoryClickEvent(InventoryClickEvent e)
	  {
		 
	    Player p = (Player)e.getWhoClicked();
	    if (p.getOpenInventory().getTopInventory().getTitle().startsWith("§6§lAccessoires"))
	    {

	   	e.setCancelled(true);     
        if ((e.getCurrentItem() == null) && (e.getCurrentItem().getType() == Material.AIR))
        {
        	return;
        }
	    
	     if(e.getCurrentItem().getItemMeta().getDisplayName().contains("Monture")){

	    	 p.sendMessage("Bientôt disponible !");
	    	 
	     }
	     p.closeInventory();
	    }
	  
	  }

}
