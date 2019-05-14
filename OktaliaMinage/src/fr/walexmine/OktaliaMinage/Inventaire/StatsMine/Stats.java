package fr.walexmine.OktaliaMinage.Inventaire.StatsMine;

import java.util.ArrayList;
import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

import fr.walexmine.OktaliaMinage.API.API_Temps;



public class Stats {


	  public static HashMap<Player, Integer> EXP = new HashMap();
	  public static HashMap<Player, Integer> LEVEL = new HashMap();
	
	  private static Inventory inv1;
		
	  public static void STATISTIQUES(Player p) {

		  inv1 = Bukkit.createInventory(null, 27, "§6Statistiques");

	  		ArrayList<String> stats = new ArrayList<>();
	  		stats.add("");
	  		stats.add("§7§l-----------------");
	  		stats.add("");
	  		stats.add("§bTemps Connectées §7§l: §e"+API_Temps.getRemainingTime(p));
	  		stats.add("");
	  		stats.add("§bEXP §7§l: §a"+EXP.get(p));
	  		stats.add("");
	  		stats.add("§9Niveau §7§l: §b"+LEVEL.get(p));
	  		stats.add("");
	  		stats.add("§7§l-----------------");
	  		
		    ItemStack Stats = new ItemStack(Material.SKULL_ITEM, 1, (short)3);
		    SkullMeta Statsmeta = (SkullMeta)Stats.getItemMeta();   	
		    Statsmeta.setOwner(p.getName());
		    Statsmeta.setDisplayName("§6§lStatistiques:");
		    Statsmeta.setLore(stats);
		    Stats.setItemMeta(Statsmeta);

	  	
	  		ArrayList<String> Infolore = new ArrayList<>();
	  		Infolore.add("");
	  		Infolore.add("§7§l-----------------");
	  		Infolore.add("");
	  		Infolore.add("§c>> §9Niveau 2: §a25000 §eExp");
	  		Infolore.add("§c>> §9Niveau 3: §a55000 §eExp");
	  		Infolore.add("§c>> §9Niveau 4: §a85000 §eExp");
	  		Infolore.add("§c>> §9Niveau 5: §a115000 §eExp");
	  		Infolore.add("");
	  		Infolore.add("§7Pour augmenter de niveau dans le serveur minage");
	  		Infolore.add("§7il faut obtenir suffisamment d'expériences.");
	  		Infolore.add("§7L'expérience ce récupère en cassent des blocs.");
	  		Infolore.add("§7Suivants les blocs vous obtenez plus ou moins d'expériences");
	  		Infolore.add("");
	  		Infolore.add("§7§l-----------------");
	  		
		    ItemStack Info = new ItemStack(Material.EMERALD, 1);
		    ItemMeta Infometa = Info.getItemMeta();   	
		    Infometa.setDisplayName("§aSystème du minage:");
		    Infometa.setLore(Infolore);
		    Info.setItemMeta(Infometa);

			inv1.setItem(13, Stats);
			
			inv1.setItem(11, Info);
			
			
				p.openInventory(inv1);
	  }	 
	  
	  
	  
}
