package fr.WalexFelwin.OktaliaAPI.Bukkit.Inventory.SystémeModération.Interact;

import net.minecraft.server.v1_8_R3.InventoryEnderChest;

import org.bukkit.DyeColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.material.EnderChest;

import fr.WalexFelwin.OktaliaAPI.Bukkit.Main;
import fr.WalexFelwin.OktaliaAPI.Bukkit.Commands.Freeze;
import fr.WalexFelwin.OktaliaAPI.Bukkit.Commands.Moderation;
import fr.WalexFelwin.OktaliaAPI.Bukkit.Inventory.SystémeModération.InventoryBan;
import fr.WalexFelwin.OktaliaAPI.Bukkit.Inventory.SystémeModération.InventoryMute;
import fr.WalexFelwin.OktaliaAPI.Bukkit.Inventory.SystémeModération.InventoryOfEnderChest;
import fr.WalexFelwin.OktaliaAPI.Bukkit.Inventory.SystémeModération.InventoryOfPlayer;


public class InventoryClickModération implements Listener{

	
	public InventoryClickModération(Main main) {

	}
	
	  @EventHandler
	  public void onInventoryClickEvent(InventoryClickEvent e)
	  {
		 
	    Player p = (Player)e.getWhoClicked();
	    Player mp = (Player)Moderation.playermodo.get(p);
	    
    	if(Moderation.playermodo.containsKey(p)){
	    if (p.getOpenInventory().getTopInventory().getTitle().equalsIgnoreCase("§aSystéme Modération"))
	    {
	      e.setCancelled(true);
	      	if (e.getCurrentItem().getType().equals(Material.STAINED_CLAY))
	      	{
	      		String dataitem = ""+e.getCurrentItem().getData().getData();
	    
	      		
	      		if(dataitem.equalsIgnoreCase("14")){
	      			// BAN
	      			InventoryBan.InventaireBan(p);
	      		}
	      		if(dataitem.equalsIgnoreCase("6")){
	      			//TEMPBAN
	      		}
	      		if(dataitem.equalsIgnoreCase("1")){
	      			//MUTE
	      			InventoryMute.InventaireMute(p);
	      		}
   				if(dataitem.equalsIgnoreCase("4")){
   					//TEMPMUTE
   				}
	      		
	      		
	        }
	      	if (e.getCurrentItem().getType().equals(Material.SKULL_ITEM))
	      	{
	      		mp.setHealth(0);
	      	}
	      	if (e.getCurrentItem().getType().equals(Material.DARK_OAK_DOOR_ITEM))
	      	{
	      		mp.kickPlayer("§aVous venez de vous faire kick du serveur par un modérateur");
	      	}
	      	if (e.getCurrentItem().getType().equals(Material.ENDER_CHEST))
	      	{
	      		InventoryOfEnderChest.onOpen(p, mp);
	      	}
	      	if (e.getCurrentItem().getType().equals(Material.CHEST))
	      	{
	      		InventoryOfPlayer.onOpen(p, mp);
	      	}
	    	if (e.getCurrentItem().getType().equals(Material.BARRIER))
	      	{
	    		if(Freeze.FreezePlayer.containsKey(mp.getName())){
	    			
	    			Freeze.FreezePlayer.remove(mp.getName());
		    		p.sendMessage("§aLe joueur §e"+mp.getName()+"§a n'est plus freeze !");
	    			mp.sendMessage("§aTu n'est plus freeze !");
	    		} else {
	    			
	    			Freeze.FreezePlayer.put(mp.getName(), "");
		    		p.sendMessage("§aLe joueur §e"+mp.getName()+"§a a été freeze");
		    		mp.sendMessage("§aTu a été freeze tu ne peut plus bouger !");
	    			
	    		}
	      	}
	    }}
	}
}
