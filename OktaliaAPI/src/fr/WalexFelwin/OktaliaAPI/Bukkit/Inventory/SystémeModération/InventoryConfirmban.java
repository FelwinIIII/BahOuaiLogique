package fr.WalexFelwin.OktaliaAPI.Bukkit.Inventory.SystémeModération;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.DyeColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class InventoryConfirmban {

	 private static Inventory inv1;
		
	  public static void InventaireConfirmBan(Player p, Player mp, String Raison)
	  {
		    inv1 = Bukkit.createInventory(null, 27, "§4Confirmation Ban "+mp.getName());
		    
		    ItemStack ban = new ItemStack(Material.WOOL, 1, DyeColor.GREEN.getData());
		    ItemMeta statsban = ban.getItemMeta();
		    statsban.setDisplayName("§4✖  Ban ✖");
		    ArrayList<String> banlore = new ArrayList();
		    banlore.add("");
		    banlore.add("§4Ban le joueur:");
		    banlore.add("§4"+mp.getName());
		    banlore.add("");
		    banlore.add("§7Pour la raison:");
		    banlore.add("§e"+Raison);
		    statsban.setLore(banlore);
		    ban.setItemMeta(statsban);
		    
		    inv1.setItem(12, ban);
		    
		    
		    
		    ItemStack no = new ItemStack(Material.WOOL, 1, DyeColor.RED.getData());
		    ItemMeta statsno = no.getItemMeta();
		    statsno.setDisplayName("§4✖  Arreter la procédure de ban ✖");
		    no.setItemMeta(statsno);
		    
		    inv1.setItem(14, no);
		    
		    p.openInventory(inv1);
	  }
}
