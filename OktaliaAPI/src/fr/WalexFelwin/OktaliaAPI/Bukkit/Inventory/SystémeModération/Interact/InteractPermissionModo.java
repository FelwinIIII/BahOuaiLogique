package fr.WalexFelwin.OktaliaAPI.Bukkit.Inventory.SystémeModération.Interact;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import fr.WalexFelwin.OktaliaAPI.Bukkit.Main;
import fr.WalexFelwin.OktaliaAPI.Bukkit.API.API_Infoperm;


public class InteractPermissionModo implements Listener{
	
	
	public InteractPermissionModo(Main main) {
		// TODO Auto-generated constructor stub
	}
	@EventHandler(priority=EventPriority.HIGHEST)
	public void OnClickHotBar(InventoryClickEvent e){ 
		

	    Player p = (Player)e.getWhoClicked();
	    if (e.getInventory().getName().startsWith("Gestion des permissions de "))
	    {
		Player mp = (Player)Bukkit.getServer().getPlayer(e.getInventory().getName().replaceAll("Gestion des permissions de ", ""));

		int itemid = p.getItemInHand().getType().getId();
		
		e.setCancelled(true);

      	
      		if(e.getClick().isRightClick()){
	    		 
      			if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§aPermission du /ban:")){
      			   
      				ItemStack banperm = new ItemStack(Material.STAINED_GLASS_PANE, 1, ((short)14));//5 14
      			    ItemMeta statsbanperm = banperm.getItemMeta();
      			    statsbanperm.setDisplayName("§aPermission du /ban:");
      			    ArrayList<String> banpermlore = new ArrayList();
      			    banpermlore.add("");
      				    banpermlore.add("§ePermission: §cNon permis");
      			  
      			    banpermlore.add("");
      			    banpermlore.add("§b>> Clic droit : §cNe pas accordée la permission");
      			    banpermlore.add("§b>> Clic gauche : §aAccordée la permission");
      			    banpermlore.add("");
      			    statsbanperm.setLore(banpermlore);
      			    banperm.setItemMeta(statsbanperm);
      			    
      			    e.getClickedInventory().setItem(0, banperm);
      			    
	    			 API_Infoperm.setbanperm(mp, "FALSE");
	    			 
	    		 } else if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§aPermission du /tempban:")){
	    			 

	    			    ItemStack tempbanperm = new ItemStack(Material.STAINED_GLASS_PANE, 1, ((short)14));//5 14
	    			    ItemMeta statstempbanperm = tempbanperm.getItemMeta();
	    			    statstempbanperm.setDisplayName("§aPermission du /tempban:");
	    			    ArrayList<String> tempbanpermlore = new ArrayList();
	    			    tempbanpermlore.add("");
	    				    tempbanpermlore.add("§ePermission: §cNon permis");
	    			    tempbanpermlore.add("");
	    			    tempbanpermlore.add("§b>> Clic droit : §cNe pas accordée la permission");
	    			    tempbanpermlore.add("§b>> Clic gauche : §aAccordée la permission");
	    			    tempbanpermlore.add("");
	    			    statstempbanperm.setLore(tempbanpermlore);
	    			    tempbanperm.setItemMeta(statstempbanperm);

	      			    e.getClickedInventory().setItem(1, tempbanperm);
	      			    
	    			 API_Infoperm.settempbanperm(mp, "FALSE");
	    			 
	    		 } else if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§aPermission du /mute:")){
	    			    ItemStack muteperm = new ItemStack(Material.STAINED_GLASS_PANE, 1, ((short)14));//5 14
	    			    ItemMeta statsmuteperm = muteperm.getItemMeta();
	    			    statsmuteperm.setDisplayName("§aPermission du /mute:");
	    			    ArrayList<String> mutepermlore = new ArrayList();
	    			    mutepermlore.add("");
	    				    mutepermlore.add("§ePermission: §cNon permis");
	    			    
	    			    mutepermlore.add("");
	    			    mutepermlore.add("§b>> Clic droit : §cNe pas accordée la permission");
	    			    mutepermlore.add("§b>> Clic gauche : §aAccordée la permission");
	    			    mutepermlore.add("");
	    			    statsmuteperm.setLore(mutepermlore);
	    			    muteperm.setItemMeta(statsmuteperm);

	      			    e.getClickedInventory().setItem(2, muteperm);
	    			 API_Infoperm.setmuteperm(mp, "FALSE");
	    			 
	    		 } else if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§aPermission du /tempmute:")){
	    			    
	    			    ItemStack tempmuteperm = new ItemStack(Material.STAINED_GLASS_PANE, 1, ((short)14));//5 14
	    			    ItemMeta statstempmuteperm = tempmuteperm.getItemMeta();
	    			    statstempmuteperm.setDisplayName("§aPermission du /tempmute:");
	    			    ArrayList<String> tempmutepermlore = new ArrayList();
	    			    tempmutepermlore.add("");
	    				    tempmutepermlore.add("§ePermission: §cNon permis");
	    			    
	    			    tempmutepermlore.add("");
	    			    tempmutepermlore.add("§b>> Clic droit : §cNe pas accordée la permission");
	    			    tempmutepermlore.add("§b>> Clic gauche : §aAccordée la permission");
	    			    tempmutepermlore.add("");
	    			    statstempmuteperm.setLore(tempmutepermlore);
	    			    tempmuteperm.setItemMeta(statstempmuteperm);
	    			    
	      			    e.getClickedInventory().setItem(3, tempmuteperm);
	    			    
	    			 API_Infoperm.settempmuteperm(mp, "FALSE");
	    			 
	    		 } else if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§aPermission du chat du staff:")){

	    			    
	    			    ItemStack chatstaff = new ItemStack(Material.STAINED_GLASS_PANE, 1, ((short)14));//5 14
	    			    ItemMeta statschatstaff = chatstaff.getItemMeta();
	    			    statschatstaff.setDisplayName("§aPermission du chat du staff:");
	    			    ArrayList<String> chatstafflore = new ArrayList();
	    			    chatstafflore.add("");
	    				    chatstafflore.add("§ePermission: §cNon permis");
	    			    
	    			    chatstafflore.add("");
	    			    chatstafflore.add("§b>> Clic droit : §cNe pas accordée la permission");
	    			    chatstafflore.add("§b>> Clic gauche : §aAccordée la permission");
	    			    chatstafflore.add("");
	    			    statschatstaff.setLore(chatstafflore);
	    			    chatstaff.setItemMeta(statschatstaff);

	    			    e.getClickedInventory().setItem(4, chatstaff);
	    			    
	    			 API_Infoperm.setCHATSTAFFperm(mp, "FALSE");
	    			 
	    		 } else if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§aPermission du /kick:")){
	 			    ItemStack kick = new ItemStack(Material.STAINED_GLASS_PANE, 1, ((short)14));//5 14
    			    ItemMeta statskick = kick.getItemMeta();
    			    statskick.setDisplayName("§aPermission du /kick:");
    			    ArrayList<String> kicklore = new ArrayList();
    			    kicklore.add("");
    			    kicklore.add("§ePermission: §cNon permis");
    			    kicklore.add("");
    			    kicklore.add("§b>> Clic droit : §cNe pas accordée la permission");
    			    kicklore.add("§b>> Clic gauche : §aAccordée la permission");
    			    kicklore.add("");
    			    statskick.setLore(kicklore);
    			    kick.setItemMeta(statskick);

    			    e.getClickedInventory().setItem(5, kick);
	    			 API_Infoperm.setkickperm(mp, "FALSE");
	    			 
	    		 } else if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§aPermission du /broadcast:")){
	    			    ItemStack broadcast = new ItemStack(Material.STAINED_GLASS_PANE, 1, ((short)14));//5 14
	    			    ItemMeta statsbroadcast = broadcast.getItemMeta();
	    			    statsbroadcast.setDisplayName("§aPermission du /broadcast:");
	    			    ArrayList<String> broadcastlore = new ArrayList();
	    			    broadcastlore.add("");
	    			    broadcastlore.add("§ePermission: §cNon Permis");
	    			    broadcastlore.add("");
	    			    broadcastlore.add("§b>> Clic droit : §cNe pas accordée la permission");
	    			    broadcastlore.add("§b>> Clic gauche : §aAccordée la permission");
	    			    broadcastlore.add("");
	    			    statsbroadcast.setLore(broadcastlore);
	    			    broadcast.setItemMeta(statsbroadcast);

	    			    e.getClickedInventory().setItem(6, broadcast);
	    			 API_Infoperm.setbroadcastperm(mp, "FALSE");
	    		 } 
	    		 
	    	 } else if (e.getClick().isLeftClick()){
	    		 
	      			if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§aPermission du /ban:")){
	       			   
	      				ItemStack banperm = new ItemStack(Material.STAINED_GLASS_PANE, 1, ((short)5));//5 14
	      			    ItemMeta statsbanperm = banperm.getItemMeta();
	      			    statsbanperm.setDisplayName("§aPermission du /ban:");
	      			    ArrayList<String> banpermlore = new ArrayList();
	      			    banpermlore.add("");
	      			    banpermlore.add("§ePermission: §aAccordée");
	      			    banpermlore.add("");
	      			    banpermlore.add("§b>> Clic droit : §cNe pas accordée la permission");
	      			    banpermlore.add("§b>> Clic gauche : §aAccordée la permission");
	      			    banpermlore.add("");
	      			    statsbanperm.setLore(banpermlore);
	      			    banperm.setItemMeta(statsbanperm);
	      			    
	      			    e.getClickedInventory().setItem(0, banperm);
	      			    
		    			 API_Infoperm.setbanperm(mp, "TRUE");
		    			 
		    		 } else if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§aPermission du /tempban:")){

		    			    ItemStack tempbanperm = new ItemStack(Material.STAINED_GLASS_PANE, 1, ((short)5));//5 14
		    			    ItemMeta statstempbanperm = tempbanperm.getItemMeta();
		    			    statstempbanperm.setDisplayName("§aPermission du /tempban:");
		    			    ArrayList<String> tempbanpermlore = new ArrayList();
		    			    tempbanpermlore.add("");
		    			    tempbanpermlore.add("§ePermission: §aAccordée");
		    			    tempbanpermlore.add("");
		    			    tempbanpermlore.add("§b>> Clic droit : §cNe pas accordée la permission");
		    			    tempbanpermlore.add("§b>> Clic gauche : §aAccordée la permission");
		    			    tempbanpermlore.add("");
		    			    statstempbanperm.setLore(tempbanpermlore);
		    			    tempbanperm.setItemMeta(statstempbanperm);
		    			    
		      			    e.getClickedInventory().setItem(1, tempbanperm);
		      			    
		    			 API_Infoperm.settempbanperm(mp, "TRUE");
		    			 
		    		 } else if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§aPermission du /mute:")){
		    			    ItemStack muteperm = new ItemStack(Material.STAINED_GLASS_PANE, 1, ((short)5));//5 14
		    			    ItemMeta statsmuteperm = muteperm.getItemMeta();
		    			    statsmuteperm.setDisplayName("§aPermission du /mute:");
		    			    ArrayList<String> mutepermlore = new ArrayList();
		    			    mutepermlore.add("");
		    			    mutepermlore.add("§ePermission: §aAccordée");
		    			    mutepermlore.add("");
		    			    mutepermlore.add("§b>> Clic droit : §cNe pas accordée la permission");
		    			    mutepermlore.add("§b>> Clic gauche : §aAccordée la permission");
		    			    mutepermlore.add("");
		    			    statsmuteperm.setLore(mutepermlore);
		    			    muteperm.setItemMeta(statsmuteperm);

		    			    
		      			    e.getClickedInventory().setItem(2, muteperm);
		      			    
		    			 API_Infoperm.setmuteperm(mp, "TRUE");
		    			 
		    		 } else if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§aPermission du /tempmute:")){
		    			    
		    			    ItemStack tempmuteperm = new ItemStack(Material.STAINED_GLASS_PANE, 1, ((short)5));//5 14
		    			    ItemMeta statstempmuteperm = tempmuteperm.getItemMeta();
		    			    statstempmuteperm.setDisplayName("§aPermission du /tempmute:");
		    			    ArrayList<String> tempmutepermlore = new ArrayList();
		    			    tempmutepermlore.add("");
		    			    tempmutepermlore.add("§ePermission: §aAccordée");
		    			    tempmutepermlore.add("");
		    			    tempmutepermlore.add("§b>> Clic droit : §cNe pas accordée la permission");
		    			    tempmutepermlore.add("§b>> Clic gauche : §aAccordée la permission");
		    			    tempmutepermlore.add("");
		    			    statstempmuteperm.setLore(tempmutepermlore);
		    			    tempmuteperm.setItemMeta(statstempmuteperm);
		    			    
		    			    e.getClickedInventory().setItem(3, tempmuteperm);
		    			 API_Infoperm.settempmuteperm(mp, "TRUE");
		    			 
		    		 } else if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§aPermission du chat du staff:")){

		    			    
		    			    ItemStack chatstaff = new ItemStack(Material.STAINED_GLASS_PANE, 1, ((short)5));//5 14
		    			    ItemMeta statschatstaff = chatstaff.getItemMeta();
		    			    statschatstaff.setDisplayName("§aPermission du chat du staff:");
		    			    ArrayList<String> chatstafflore = new ArrayList();
		    			    chatstafflore.add("");
		    			    chatstafflore.add("§ePermission: §aAccordée");
		    			    chatstafflore.add("");
		    			    chatstafflore.add("§b>> Clic droit : §cNe pas accordée la permission");
		    			    chatstafflore.add("§b>> Clic gauche : §aAccordée la permission");
		    			    chatstafflore.add("");
		    			    statschatstaff.setLore(chatstafflore);
		    			    chatstaff.setItemMeta(statschatstaff);

		    			    e.getClickedInventory().setItem(4, chatstaff);
		    			 API_Infoperm.setCHATSTAFFperm(mp, "TRUE");
		    			 
		    		 } else if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§aPermission du /kick:")){
		    			    
		    			    ItemStack kick = new ItemStack(Material.STAINED_GLASS_PANE, 1, ((short)5));//5 14
		    			    ItemMeta statskick = kick.getItemMeta();
		    			    statskick.setDisplayName("§aPermission du /kick:");
		    			    ArrayList<String> kicklore = new ArrayList();
		    			    kicklore.add("");
		    			    kicklore.add("§ePermission: §aAccordée");
		    			    kicklore.add("");
		    			    kicklore.add("§b>> Clic droit : §cNe pas accordée la permission");
		    			    kicklore.add("§b>> Clic gauche : §aAccordée la permission");
		    			    kicklore.add("");
		    			    statskick.setLore(kicklore);
		    			    kick.setItemMeta(statskick);

		    			    e.getClickedInventory().setItem(5, kick);
		    			 API_Infoperm.setkickperm(mp, "TRUE");
		    			 
		    		 } else if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§aPermission du /broadcast:")){
		    			    
		    			    ItemStack broadcast = new ItemStack(Material.STAINED_GLASS_PANE, 1, ((short)5));//5 14
		    			    ItemMeta statsbroadcast = broadcast.getItemMeta();
		    			    statsbroadcast.setDisplayName("§aPermission du /broadcast:");
		    			    ArrayList<String> broadcastlore = new ArrayList();
		    			    broadcastlore.add("");
		    			    broadcastlore.add("§ePermission: §aAccordée");
		    			    broadcastlore.add("");
		    			    broadcastlore.add("§b>> Clic droit : §cNe pas accordée la permission");
		    			    broadcastlore.add("§b>> Clic gauche : §aAccordée la permission");
		    			    broadcastlore.add("");
		    			    statsbroadcast.setLore(broadcastlore);
		    			    broadcast.setItemMeta(statsbroadcast);

		    			    e.getClickedInventory().setItem(6, broadcast);
		    			 API_Infoperm.setbroadcastperm(mp, "TRUE");
		    			 
		    		 } 
	    		 
	    	 }
		
		
		
	    }
	}
	

}
