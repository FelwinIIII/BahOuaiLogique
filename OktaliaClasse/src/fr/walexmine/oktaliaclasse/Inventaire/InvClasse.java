package fr.walexmine.oktaliaclasse.Inventaire;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;
import fr.walexmine.oktaliaclasse.PRESTIGE;

public class InvClasse {
	
	
	 public static String getProgressBar(int current, int max, int totalBars, String symbol, String completedColor, String notCompletedColor){

	        float percent = (float) current / max;

	        int progressBars = (int) ((int) totalBars * percent);

	        int leftOver = (totalBars - progressBars);

	        StringBuilder sb = new StringBuilder();
	        sb.append(ChatColor.translateAlternateColorCodes('&', completedColor));
	        for (int i = 0; i < progressBars; i++) {
	            sb.append(symbol);
	        }
	        sb.append(ChatColor.translateAlternateColorCodes('&', notCompletedColor));
	        for (int i = 0; i < leftOver; i++) {
	            sb.append(symbol);
	        }
	        return sb.toString();
	    }
	
	public static void openinvClasse(Player p) {
		
		 Inventory menu = Bukkit.createInventory(null, 27, "§eMenu Classe §6!");

		  
		  int NIVEAU = (int) PRESTIGE.getLVL(p);
		  int NIVEAUA = NIVEAU+1;
		  
 		  int max = 0;
 		  int expa = (int) PRESTIGE.getEXP(p);
 		  
 		  if(NIVEAU == 2) {
 			  max += 30000;
 			  expa -= 25000;
 		  } else if(NIVEAU == 3) {
 			  max += 30000;  			  
 			  expa -= 55000;
 		  } else if(NIVEAU == 4) {
 			  max += 30000;
 			  expa -= 85000;
 		  } else if(NIVEAU == 5) {

 		  } else {
 			  max = 25000;
 		  }
 		  
	        float percent = (float) expa/ max;
 		  
	       float progressBars = (100 * percent);

           DecimalFormat format = new DecimalFormat("0.00");
           
		  String perctforma = format.format(progressBars);
	      
	      ItemStack head = new ItemStack(Material.SKULL_ITEM, 1, (short)3);
			
		  ArrayList<String> lore = new ArrayList<>();
		    lore.add("");
		    lore.add("§dPrestige: §f§l"+NIVEAU);
		    lore.add("");
		    lore.add("§aExperiences: §e§l"+PRESTIGE.getEXP(p));
		    lore.add("");
		    lore.add("§7Progression:");
		    lore.add("");
		    lore.add(""+ getProgressBar(expa, max, 23, "❚", "&a", "&f"));
		    lore.add("§7------§e[§9§l"+perctforma+" §a§l%§e]§7------");
		    SkullMeta headM = (SkullMeta)head.getItemMeta();
	      headM.setOwner(p.getName());
	      headM.setDisplayName(p.getName());
	      headM.setDisplayName("§a» Informations:");
	      headM.setLore(lore);
	      
	      
	      ItemStack shop = new ItemStack(Material.ENDER_CHEST, 1);
	      ItemMeta shopM = shop.getItemMeta();
	      shopM.setDisplayName("§6»§f» §aShop Classe ! §6«§f«");
	      shopM.setLore(Arrays.asList(new String[] { "DESCRIPTIF A FAIRE" }));
	      
	      ItemStack verre = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)7);
	      
	      shop.setItemMeta(shopM);
	      head.setItemMeta(headM);
	      
	      menu.setItem(0, verre);
	      menu.setItem(1, verre);
	      menu.setItem(2, verre);
	      menu.setItem(3, verre);
	      menu.setItem(4, verre);
	      menu.setItem(5, verre);
	      menu.setItem(6, verre);
	      menu.setItem(7, verre);
	      menu.setItem(8, verre);
	      menu.setItem(9, verre);
	      menu.setItem(10, verre);
	      menu.setItem(11, verre);
	      menu.setItem(13, verre);
	      menu.setItem(14, shop);
	      menu.setItem(12, head);
	      menu.setItem(15, verre);
	      menu.setItem(17, verre);
	      menu.setItem(16, verre);
	      menu.setItem(18, verre);
	      menu.setItem(19, verre);
	      menu.setItem(20, verre);
	      menu.setItem(21, verre);
	      menu.setItem(22, verre);
	      menu.setItem(23, verre);
	      menu.setItem(24, verre);
	      menu.setItem(25, verre);
	      menu.setItem(26, verre);
	      p.openInventory(menu);
	}
}
