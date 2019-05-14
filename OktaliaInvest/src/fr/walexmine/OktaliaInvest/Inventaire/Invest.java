package fr.walexmine.OktaliaInvest.Inventaire;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

import fr.WalexFelwin.OktaliaAPI.Bukkit.API.API_Inventaire;

public class Invest {


	  private static Inventory inv1;
	
	  public static void invest(Player p) {

		  inv1 = Bukkit.createInventory(null, 36, "§6§l/Invest");

		  ArrayList<String> lore = new ArrayList<>();
		    lore.add("");
		    lore.add("§ePrix de l'investisement: §a50 000 $");
		    lore.add("");
		    lore.add("§aBénéfice: §e§l100 000 $");
		    lore.add("");
		    
		  API_Inventaire.additems(381, 1, 0, inv1, "§a - §6§l30 Minutes §a-", lore, 12);
		  
				p.openInventory(inv1);
				
	  }	  
	  
}
