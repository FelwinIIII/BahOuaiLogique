package fr.WalexFelwin.OktaliaAPI.Bukkit.Inventory.SystémeModération;

import java.util.ArrayList;
import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Pig;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.material.MaterialData;

import fr.WalexFelwin.OktaliaAPI.Bukkit.Main;
import fr.WalexFelwin.OktaliaAPI.Bukkit.API.API_Vanish;
import fr.WalexFelwin.OktaliaAPI.Bukkit.Commands.Freeze;
import fr.WalexFelwin.OktaliaAPI.Bukkit.Commands.Moderation;
import fr.WalexFelwin.OktaliaAPI.Bukkit.Inventory.InventoryPlayerModération;


public class InventoryHotBarClick implements Listener{

	
	public InventoryHotBarClick(Main main){
		
	}
	
	@EventHandler(priority=EventPriority.HIGHEST)
	public void onPlayerClickModo(PlayerInteractEntityEvent e){ 
		
		Player p = e.getPlayer(); 

		        if ((e.getRightClicked() instanceof Player)){
		           
		        	Player mp = (Player) e.getRightClicked();
		        	
				    int itemdata = p.getItemInHand().getType().getId();
				    
				  //  p.sendMessage("§aTEST :§e "+itemdata);
				  //p.sendMessage("§aPlayer :§e "+mp.getName()); 
				    
				    if(itemdata ==  381)
				    {
				    	if(Moderation.SystémeModo.containsKey(p)){
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
				    }

				    if(itemdata == 339){

						
				    	if(Moderation.SystémeModo.containsKey(p)){
				    		//InventoryLogs.InventaireKits(p, mp);
				    	}
				    }
					
				    if(itemdata == 54){
					
			    	if(Moderation.SystémeModo.containsKey(p)){
			    	if(Moderation.playermodo.containsKey(p)){
			    		
			    		Moderation.playermodo.remove(p);
			    		Moderation.playermodo.put(p, mp);


				    	InventoryPlayerModération.InventoryModération(p, mp);
			    	} else {
			    		
			    		Moderation.playermodo.put(p, mp);


				    	InventoryPlayerModération.InventoryModération(p, mp);
			    		
			    	}
			    	}
			    	}
				
				
		            }
		        
		}
	
	
	@EventHandler(priority=EventPriority.HIGHEST)
	public void OnClickHotBar(PlayerInteractEvent e){ 
		
		
		Player p = e.getPlayer();
		
		if(Moderation.SystémeModo.containsKey(p)){
		int itemid = p.getItemInHand().getType().getId();
	    
	     if(p.getItemInHand().getType().equals(Material.ENDER_CHEST)){
	    	 //InventoryReport.ForteressPNJ1(p);
	     }
	     
	     if(p.getItemInHand().getType().equals(Material.ENDER_PEARL)){
	    	//InventoryGamemode.gamemode(p);
	    	 p.performCommand("god");
	     }
	     
	     if(p.getItemInHand().getType().equals(Material.FEATHER)){
	    	 p.performCommand("fly");
	     }	    
	     
	     if(p.getItemInHand().getType().equals(Material.ARROW)){
	    	 random(p);
	     }
		
		if(itemid == 351){
			
      		String dataitem = ""+p.getItemInHand().getData().getData();
    	    if(p.hasPermission("perm.vanish")){
      		
      		if(dataitem.equalsIgnoreCase("5")){
      			// DESACTIVER LE VANISH
	    		p.sendMessage("§aLe Vanish a été désactivée");
      			API_Vanish.VanishToFalse(p);
      			
      		}
      		
      		if(dataitem.equalsIgnoreCase("8")){
      			// ACTIVER LE VANISH
	    		p.sendMessage("§aLe Vanish a été activée");
      			API_Vanish.VanishToTrue(p);
      		}} else {
      			p.sendMessage("§cVanish indisponible.");
      		}
		}
		}
		
		
	}
	public void random(Player player){
	    ArrayList<Player> players = new ArrayList<Player>();
	    for (Player e : Bukkit.getOnlinePlayers()) players.add(e);
	    Player randomPlayer = players.get(new Random().nextInt(players.size()));
	    if(randomPlayer != player){
	    player.teleport(randomPlayer.getLocation());
	    player.sendMessage("§cTP aléatoire: " + randomPlayer.getName());
	    }else{
	    	return;
	    }
	    
	    
	}
}
