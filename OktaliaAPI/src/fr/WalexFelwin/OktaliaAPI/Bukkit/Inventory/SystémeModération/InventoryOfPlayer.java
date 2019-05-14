package fr.WalexFelwin.OktaliaAPI.Bukkit.Inventory.SystémeModération;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

public class InventoryOfPlayer {
	
	  public static void onOpen(Player p, Player mp)
	  {
		  
		  
	    Inventory inv2 = Bukkit.createInventory(null, 54, "§7Inventaire de "+mp.getName());
	    
	    Inventory inv = mp.getInventory();
	    
	    ItemStack boots = mp.getInventory().getBoots();
	    ItemStack chestplate = mp.getInventory().getChestplate();
	    ItemStack helmet = mp.getInventory().getHelmet();
	    ItemStack leggins = mp.getInventory().getLeggings();
	    
	    ItemStack sk1 = new ItemStack(Material.SKULL_ITEM, 1, (short)3);
	    SkullMeta sk1m = (SkullMeta)sk1.getItemMeta();
	    sk1m.setOwner("MHF_ArrowLeft");
	    sk1m.setDisplayName("§6Returner au systéme de modération");
	    sk1.setItemMeta(sk1m);
	    
	    ItemStack reloadblock = new ItemStack(Material.REDSTONE_BLOCK, 1);
	    ItemMeta reloadblockmeta = reloadblock.getItemMeta();
	    reloadblockmeta.setDisplayName("§cRelaod l'inventaire du joueur");
	    reloadblock.setItemMeta(reloadblockmeta);
	    
	    
	    ItemStack clearblock = new ItemStack(Material.BARRIER, 1);
	    ItemMeta clearblockmeta = clearblock.getItemMeta();
	    clearblockmeta.setDisplayName("§cSupprimer l'inventaire");
	    clearblock.setItemMeta(clearblockmeta);
	    
	    inv2.clear();
	    
	    inv2.setItem(0, helmet);inv2.setItem(1, chestplate);inv2.setItem(2, leggins);inv2.setItem(3, boots);
	    
	    inv2.setItem(6, clearblock);
	    inv2.setItem(7, reloadblock);
	    inv2.setItem(8, sk1);
	    
	    inv2.setItem(18, inv.getItem(9));inv2.setItem(19, inv.getItem(10));inv2.setItem(20, inv.getItem(11));
	    inv2.setItem(21, inv.getItem(12));inv2.setItem(22, inv.getItem(13));inv2.setItem(23, inv.getItem(14));
	    inv2.setItem(24, inv.getItem(15));inv2.setItem(25, inv.getItem(16));inv2.setItem(26, inv.getItem(17));
	    
	    inv2.setItem(45, inv.getItem(0));inv2.setItem(46, inv.getItem(1));inv2.setItem(47, inv.getItem(2));
	    inv2.setItem(48, inv.getItem(3));inv2.setItem(49, inv.getItem(4));inv2.setItem(50, inv.getItem(5));
	    inv2.setItem(51, inv.getItem(6));inv2.setItem(52, inv.getItem(7));inv2.setItem(53, inv.getItem(8));
	    
	    inv2.setItem(27, inv.getItem(18));inv2.setItem(28, inv.getItem(19));inv2.setItem(29, inv.getItem(20));
	    inv2.setItem(30, inv.getItem(21));inv2.setItem(31, inv.getItem(22));inv2.setItem(32, inv.getItem(23));
	    inv2.setItem(33, inv.getItem(24));inv2.setItem(34, inv.getItem(25));inv2.setItem(35, inv.getItem(26));
	    
	    inv2.setItem(36, inv.getItem(18));inv2.setItem(37, inv.getItem(28));inv2.setItem(38, inv.getItem(29));
	    inv2.setItem(39, inv.getItem(30));inv2.setItem(40, inv.getItem(31));inv2.setItem(41, inv.getItem(32));
	    inv2.setItem(42, inv.getItem(33));inv2.setItem(43, inv.getItem(34));inv2.setItem(44, inv.getItem(35));
	    
	    p.openInventory(inv2);
	  }
}
