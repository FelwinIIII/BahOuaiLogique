package fr.WalexFelwin.OktaliaAPI.Bukkit.Inventory.SystémeModération;

import java.util.ArrayList;

import org.bukkit.DyeColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import fr.WalexFelwin.OktaliaAPI.Bukkit.API.API_Vanish;


public class HotBarItem {
	
	  public static void itemmodération(Player p)
	  {
		  
		  ItemStack InventoryModération = new ItemStack(Material.CHEST, 1);
		    ItemMeta InventoryModérationsm = InventoryModération.getItemMeta();
		    InventoryModérationsm.setDisplayName("§aSystéme de Modération §7(Clic droit)");
		    ArrayList<String> InventoryModérationlore = new ArrayList();
		    InventoryModérationlore.add("");
		    InventoryModérationlore.add("§7Systéme de modération");
		    InventoryModérationlore.add("");
		    InventoryModérationlore.add("");
		    InventoryModérationsm.setLore(InventoryModérationlore);
		    InventoryModération.setItemMeta(InventoryModérationsm);		  
		    
		    
		    ItemStack Report = new ItemStack(Material.ENDER_CHEST, 1);
		    ItemMeta Reportsm = Report.getItemMeta();
		    Reportsm.setDisplayName("§aSystéme de report");
		    ArrayList<String> Reportlore = new ArrayList();
		    Reportlore.add("");
		    Reportlore.add("§7Systéme de report");
		    Reportlore.add("");
		    Reportlore.add("");
		    Reportsm.setLore(Reportlore);
		    Report.setItemMeta(Reportsm);
		  
		    ItemStack VanishOn = new ItemStack(351, 1, DyeColor.LIME.getData());
		    ItemMeta VanishOnmeta = VanishOn.getItemMeta();
		    VanishOnmeta.setDisplayName("§7§lVanish: §aON");
		    VanishOn.setItemMeta(VanishOnmeta);
		    
		    ItemStack VanishOFF = new ItemStack(351, 1, DyeColor.SILVER.getData());
		    ItemMeta VanishOFFmeta = VanishOFF.getItemMeta();
		    VanishOFFmeta.setDisplayName("§7§lVanish: §cOFF");
		    VanishOFF.setItemMeta(VanishOFFmeta);
		  
		    ItemStack Freeze = new ItemStack(381, 1);
		    ItemMeta Freezemeta = VanishOFF.getItemMeta();
		    Freezemeta.setDisplayName("§7§lFreeze");
		    Freeze.setItemMeta(Freezemeta);
		  
		    ItemStack Gamemode = new ItemStack(Material.ENDER_PEARL, 1);
		    ItemMeta Gamemodemeta = Gamemode.getItemMeta();
		    Gamemodemeta.setDisplayName("§7§lGod");
		    Gamemode.setItemMeta(Gamemodemeta);		  
		    
		    ItemStack Fly = new ItemStack(Material.FEATHER, 1);
		    ItemMeta Flymeta = Fly.getItemMeta();
		    Flymeta.setDisplayName("§6§lFly");
		    Fly.setItemMeta(Flymeta);		   
		    
		    ItemStack AntiKb = new ItemStack(Material.BLAZE_ROD, 1);
		    ItemMeta AntiKbmeta = AntiKb.getItemMeta();
		    AntiKbmeta.addEnchant(Enchantment.KNOCKBACK, 5, true);
		    AntiKbmeta.setDisplayName("§5§lBaton anti KB");
		    AntiKb.setItemMeta(AntiKbmeta);
		  
		    ItemStack Logs = new ItemStack(Material.PAPER, 1);
		    ItemMeta Logsmeta = Logs.getItemMeta();
		    Logsmeta.setDisplayName("§aLogs du joueur §7(Clic droit)");
		    Logs.setItemMeta(Logsmeta);

			  
		    ItemStack Aléatoire = new ItemStack(Material.ARROW, 1);
		    ItemMeta Aléatoiremeta = Aléatoire.getItemMeta();
		    Aléatoiremeta.setDisplayName("§aTp aléatoire§7(Clic droit)");
		    Aléatoire.setItemMeta(Aléatoiremeta);
		    
		    p.getInventory().clear();
		       	
		    	if(p.hasPermission("perm.vanish")){
	      		

	      			// ACTIVER LE VANISH
				    p.getInventory().setItem(8, VanishOn);
		    		p.sendMessage("§aLe Vanish a été activée");
				    API_Vanish.VanishToTrue(p); 
	      		} else {
	      			p.sendMessage("§cVanish indisponible.");
	      		}
		    p.getInventory().setItem(4, InventoryModération);
		    p.getInventory().setItem(7, Report);
		    p.getInventory().setItem(6, Logs);
		    p.getInventory().setItem(5, Aléatoire);
		    p.getInventory().setItem(3, AntiKb);
		    p.getInventory().setItem(2, Fly);
		    p.getInventory().setItem(1, Gamemode);
		    p.getInventory().setItem(0, Freeze);

		  
		  
		  
		  
	  }
}
