package fr.walexmine.OktaliaRuche.Event;

import java.util.ArrayList;
import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockState;
import org.bukkit.block.Skull;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.scheduler.BukkitRunnable;

import fr.walexmine.OktaliaRuche.Main;

public class Place implements Listener{

	
	public Place(Main main) {
		
	}

	  public static HashMap<Player, ArrayList<String>> RucheUUID = new HashMap();
	  public static HashMap<String, Location> RucheLoc = new HashMap();
	  
	@EventHandler
	  public void placeRuche(BlockPlaceEvent event)
	  {
	    Block b = event.getBlock();
	    Player p = event.getPlayer();
	    
	    if (b.getType() == Material.SKULL && p.getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase("§e§k!!! §bRuche §e§k!!!"))
	    {
	    	
	      ItemStack skull = new ItemStack(Material.SKULL_ITEM, 1, (short)3);
	      
	      SkullMeta skullMeta = (SkullMeta)skull.getItemMeta();
	      
	      skullMeta.setOwner("eSport_");
	      
	      skull.setItemMeta(skullMeta);
	      
	      BlockState bs = b.getState();
	      
	      final Skull skulle = (Skull)bs;
	      
	      if ((skulle.hasOwner()) && 
	        (skulle.getOwner().equalsIgnoreCase("eSport_"))) {
	    	  new BukkitRunnable()
	          {
	            int ticks = 6000;
	            
	            public void run()
	            {
	              this.ticks -= 1;
	              if (this.ticks < 0)
	              {
	                skulle.setOwner("_FayWin_");
	                skulle.update();
	                
	                cancel();
	              }
	            }
	          }.runTaskTimer(Bukkit.getPluginManager().getPlugin("OktaliaRuche"), 0L, 1L);
			  /*ArrayList<String> lore = new ArrayList<>();
			    lore.add("");*/
	              

	      }
	    }
	  }
	
	
	
}
