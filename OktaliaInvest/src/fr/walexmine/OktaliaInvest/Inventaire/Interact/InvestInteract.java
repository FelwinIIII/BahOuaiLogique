package fr.walexmine.OktaliaInvest.Inventaire.Interact;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

import fr.walexmine.OktaliaInvest.Main;
import fr.walexmine.OktaliaInvest.Event.PlayerMove;


public class InvestInteract implements Listener{

	public InvestInteract(Main main) {
		
	}
	
	 @EventHandler
	  public void onInventoryClickEvent(InventoryClickEvent e)
	  {
		 
	    Player p = (Player)e.getWhoClicked();


	    
	    if (p.getOpenInventory().getTopInventory().getTitle().equalsIgnoreCase("§6§l/Invest"))
	    {

	     
	    	e.setCancelled(true);     
	        if ((e.getCurrentItem() == null) && (e.getCurrentItem().getType() == Material.AIR))
	        {
	        	return;
	        } else {
	            
	   	     if(e.getCurrentItem().getType() == Material.EYE_OF_ENDER){
	   	    	 
	   		    	 if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§a - §6§l30 Minutes §a-")){

	   		    		 long end = 1000L*60*2;
	   		    		 long start = 1000L*60*2 + System.currentTimeMillis();
	   		    		 
	   		    		 PlayerMove.Invest.put(p, "30m");
	   		    		 PlayerMove.TimeEND.put(p, ""+end);
	   		    		 PlayerMove.TimeStart.put(p, ""+start);

	   					p.sendMessage("INVEST 30 M 2 MIN");
	   		    		 }
	   		    		 
	   		    		 
	   		    	 }
	   		  }
	   }
	
	    
	 }
}