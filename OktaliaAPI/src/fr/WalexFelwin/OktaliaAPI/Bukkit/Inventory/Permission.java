package fr.WalexFelwin.OktaliaAPI.Bukkit.Inventory;

import java.util.ArrayList;
import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import fr.WalexFelwin.OktaliaAPI.Bukkit.API.API_Infoperm;


public class Permission {


	  private static Inventory inv1;
	  
	  
	public static void InventaireServeur(Player p, Player permad)
	  {
		    inv1 = Bukkit.createInventory(null, 9, "Gestion des permissions de "+permad.getName());
		    
		    int b;
		    if(API_Infoperm.getbanperm(permad).equalsIgnoreCase("TRUE")){
		    	b = 5;
		    } else {
		    	b = 14;
		    }
		    int tb;
		    if(API_Infoperm.gettempbanperm(permad).equalsIgnoreCase("TRUE")){
		    	tb = 5;
		    } else {
		    	tb = 14;
		    }

		    int m;
		    if(API_Infoperm.getmuteperm(permad).equalsIgnoreCase("TRUE")){
		    	m = 5;
		    } else {
		    	m = 14;
		    }
		    int tm;
		    if(API_Infoperm.gettempmuteperm(permad).equalsIgnoreCase("TRUE")){
		    	tm = 5;
		    } else {
		    	tm = 14;
		    }

		    int chat;
		    if(API_Infoperm.getCHATSTAFFperm(permad).equalsIgnoreCase("TRUE")){
		    	chat = 5;
		    } else {
		    	chat = 14;
		    }
		    int kick2;
		    if(API_Infoperm.getkickperm(permad).equalsIgnoreCase("TRUE")){
		    	kick2 = 5;
		    } else {
		    	kick2 = 14;
		    }
		    int broadcast2;
		    if(API_Infoperm.getbroadcastperm(permad).equalsIgnoreCase("TRUE")){
		    	broadcast2 = 5;
		    } else {
		    	broadcast2 = 14;
		    }
		    	
		    ItemStack banperm = new ItemStack(Material.STAINED_GLASS_PANE, 1, ((short)b));//5 14
		    ItemMeta statsbanperm = banperm.getItemMeta();
		    statsbanperm.setDisplayName("§aPermission du /ban:");
		    ArrayList<String> banpermlore = new ArrayList();
		    banpermlore.add("");
		    if(b == 5){
		    banpermlore.add("§ePermission: §aAccordée");
		    } else {
			    banpermlore.add("§ePermission: §cNon permis");
		    }
		    banpermlore.add("");
		    banpermlore.add("§b>> Clic droit : §cNe pas accordée la permission");
		    banpermlore.add("§b>> Clic gauche : §aAccordée la permission");
		    banpermlore.add("");
		    statsbanperm.setLore(banpermlore);
		    banperm.setItemMeta(statsbanperm);
		    
		    ItemStack tempbanperm = new ItemStack(Material.STAINED_GLASS_PANE, 1, ((short)tb));//5 14
		    ItemMeta statstempbanperm = tempbanperm.getItemMeta();
		    statstempbanperm.setDisplayName("§aPermission du /tempban:");
		    ArrayList<String> tempbanpermlore = new ArrayList();
		    tempbanpermlore.add("");
		    if(tb == 5){
		    tempbanpermlore.add("§ePermission: §aAccordée");
		    } else {
			    tempbanpermlore.add("§ePermission: §cNon permis");
		    }
		    tempbanpermlore.add("");
		    tempbanpermlore.add("§b>> Clic droit : §cNe pas accordée la permission");
		    tempbanpermlore.add("§b>> Clic gauche : §aAccordée la permission");
		    tempbanpermlore.add("");
		    statstempbanperm.setLore(tempbanpermlore);
		    tempbanperm.setItemMeta(statstempbanperm);
		    
		    ItemStack muteperm = new ItemStack(Material.STAINED_GLASS_PANE, 1, ((short)m));//5 14
		    ItemMeta statsmuteperm = muteperm.getItemMeta();
		    statsmuteperm.setDisplayName("§aPermission du /mute:");
		    ArrayList<String> mutepermlore = new ArrayList();
		    mutepermlore.add("");
		    if(m == 5){
		    mutepermlore.add("§ePermission: §aAccordée");
		    } else {
			    mutepermlore.add("§ePermission: §cNon permis");
		    }
		    mutepermlore.add("");
		    mutepermlore.add("§b>> Clic droit : §cNe pas accordée la permission");
		    mutepermlore.add("§b>> Clic gauche : §aAccordée la permission");
		    mutepermlore.add("");
		    statsmuteperm.setLore(mutepermlore);
		    muteperm.setItemMeta(statsmuteperm);
		    
		    ItemStack tempmuteperm = new ItemStack(Material.STAINED_GLASS_PANE, 1, ((short)tm));//5 14
		    ItemMeta statstempmuteperm = tempmuteperm.getItemMeta();
		    statstempmuteperm.setDisplayName("§aPermission du /tempmute:");
		    ArrayList<String> tempmutepermlore = new ArrayList();
		    tempmutepermlore.add("");
		    if(tm == 5){
		    tempmutepermlore.add("§ePermission: §aAccordée");
		    } else {
			    tempmutepermlore.add("§ePermission: §cNon permis");
		    }
		    tempmutepermlore.add("");
		    tempmutepermlore.add("§b>> Clic droit : §cNe pas accordée la permission");
		    tempmutepermlore.add("§b>> Clic gauche : §aAccordée la permission");
		    tempmutepermlore.add("");
		    statstempmuteperm.setLore(tempmutepermlore);
		    tempmuteperm.setItemMeta(statstempmuteperm);
		    
		    ItemStack chatstaff = new ItemStack(Material.STAINED_GLASS_PANE, 1, ((short)chat));//5 14
		    ItemMeta statschatstaff = chatstaff.getItemMeta();
		    statschatstaff.setDisplayName("§aPermission du chat du staff:");
		    ArrayList<String> chatstafflore = new ArrayList();
		    chatstafflore.add("");
		    if(chat == 5){
		    chatstafflore.add("§ePermission: §aAccordée");
		    } else {
			    chatstafflore.add("§ePermission: §cNon permis");
		    }
		    chatstafflore.add("");
		    chatstafflore.add("§b>> Clic droit : §cNe pas accordée la permission");
		    chatstafflore.add("§b>> Clic gauche : §aAccordée la permission");
		    chatstafflore.add("");
		    statschatstaff.setLore(chatstafflore);
		    chatstaff.setItemMeta(statschatstaff);
		    
		    ItemStack kick = new ItemStack(Material.STAINED_GLASS_PANE, 1, ((short)kick2));//5 14
		    ItemMeta statskick = kick.getItemMeta();
		    statskick.setDisplayName("§aPermission du /kick:");
		    ArrayList<String> kicklore = new ArrayList();
		    kicklore.add("");
		    if(kick2 == 5){
		    kicklore.add("§ePermission: §aAccordée");
		    } else {
			    kicklore.add("§ePermission: §cNon permis");
		    }
		    kicklore.add("");
		    kicklore.add("§b>> Clic droit : §cNe pas accordée la permission");
		    kicklore.add("§b>> Clic gauche : §aAccordée la permission");
		    kicklore.add("");
		    statskick.setLore(kicklore);
		    kick.setItemMeta(statskick);
		    
		    ItemStack broadcast = new ItemStack(Material.STAINED_GLASS_PANE, 1, ((short)broadcast2));//5 14
		    ItemMeta statsbroadcast = broadcast.getItemMeta();
		    statsbroadcast.setDisplayName("§aPermission du /broadcast:");
		    ArrayList<String> broadcastlore = new ArrayList();
		    broadcastlore.add("");
		    if(broadcast2 == 5){
		    broadcastlore.add("§ePermission: §aAccordée");
		    } else {
			    broadcastlore.add("§ePermission: §cNon permis");
		    }
		    broadcastlore.add("");
		    broadcastlore.add("§b>> Clic droit : §cNe pas accordée la permission");
		    broadcastlore.add("§b>> Clic gauche : §aAccordée la permission");
		    broadcastlore.add("");
		    statsbroadcast.setLore(broadcastlore);
		    broadcast.setItemMeta(statsbroadcast);
		    



		    inv1.setItem(0, banperm);
		    inv1.setItem(1, tempbanperm);
		    inv1.setItem(2, muteperm);
		    inv1.setItem(3, tempmuteperm);
		    inv1.setItem(4, chatstaff);
		    inv1.setItem(5, kick);
		    inv1.setItem(6, broadcast);
		    
		    p.openInventory(inv1);
	  }
}