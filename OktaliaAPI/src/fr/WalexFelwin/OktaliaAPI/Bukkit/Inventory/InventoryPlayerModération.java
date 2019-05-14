package fr.WalexFelwin.OktaliaAPI.Bukkit.Inventory;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.DyeColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryAction;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.material.Dye;
import org.bukkit.material.MaterialData;

public class InventoryPlayerModération {

	 private static Inventory inv1;
		
	  public static void InventoryModération(Player p, Player mp)
	  {
		    inv1 = Bukkit.createInventory(null, 36, "§aSystéme Modération");
		    
		    ItemStack ban = new ItemStack(Material.STAINED_CLAY, 1, DyeColor.RED.getData());
		    ItemMeta statsban = ban.getItemMeta();
		    statsban.setDisplayName("§4✖  Ban ✖");
		    ArrayList<String> banlore = new ArrayList();
		    banlore.add("");
		    banlore.add("§4Ban le joueur:");
		    banlore.add("§4"+mp.getName());
		    banlore.add("");
		    statsban.setLore(banlore);
		    ban.setItemMeta(statsban);
		    
		    inv1.setItem(1, ban);
		    
		    ItemStack tempban = new ItemStack(Material.STAINED_CLAY, 1, DyeColor.PINK.getData());
		    ItemMeta statstempban = tempban.getItemMeta();
		    statstempban.setDisplayName("§c✖  TempBan ✖");
		    ArrayList<String> tempbanlore = new ArrayList();
		    tempbanlore.add("");
		    tempbanlore.add("§cTempBan le joueur:");
		    tempbanlore.add("§c"+mp.getName());
		    tempbanlore.add("");
		    statstempban.setLore(tempbanlore);
		    tempban.setItemMeta(statstempban);
		    
		    inv1.setItem(3, tempban);
		    
		    ItemStack kick = new ItemStack(Material.DARK_OAK_DOOR_ITEM);
		    ItemMeta statskick = kick.getItemMeta();
		    statskick.setDisplayName("§a✖  Kick ✖");
		    ArrayList<String> kicklore = new ArrayList();
		    kicklore.add("");
		    kicklore.add("§akick le joueur:");
		    kicklore.add("§c"+mp.getName());
		    kicklore.add("");
		    statskick.setLore(kicklore);
		    kick.setItemMeta(statskick);
		    
		    inv1.setItem(21, kick);
		    
		    
		    ItemStack kill = new ItemStack(Material.SKULL_ITEM);
		    ItemMeta statskill = kill.getItemMeta();
		    statskill.setDisplayName("§7✖  kill ✖");
		    ArrayList<String> killlore = new ArrayList();
		    killlore.add("");
		    killlore.add("§4Kill le joueur:");
		  //  killlore.add("§c"+mp.getName());
		    killlore.add("§cEn développement");
		    statskill.setLore(killlore);
		    kill.setItemMeta(statskill);
		    
		    inv1.setItem(23, kill);
		    
		    
		    ItemStack mute = new ItemStack(Material.STAINED_CLAY, 1, DyeColor.ORANGE.getData());
		    ItemMeta statsmute = mute.getItemMeta();
		    statsmute.setDisplayName("§6✖  Mute ✖");
		    ArrayList<String> mutelore = new ArrayList();
		    mutelore.add("");
		    mutelore.add("§6Mute le joueur:");
		    mutelore.add("§6"+mp.getName());
		    mutelore.add("");
		    statsmute.setLore(mutelore);
		    mute.setItemMeta(statsmute);
		    
		    inv1.setItem(5, mute);
		    
		    
		    ItemStack tempmute = new ItemStack(Material.STAINED_CLAY, 1, DyeColor.YELLOW.getData());
		    ItemMeta statstempmute = tempmute.getItemMeta();
		    statstempmute.setDisplayName("§e✖  TempMute ✖");
		    ArrayList<String> tempmutelore = new ArrayList();
		    tempmutelore.add("");
		    tempmutelore.add("§eTempMute le joueur:");
		  //  tempmutelore.add("§e"+mp.getName());
		    tempmutelore.add("§cEn développement");
		    statstempmute.setLore(tempmutelore);
		    tempmute.setItemMeta(statstempmute);
		    
		    inv1.setItem(7, tempmute);
		    

		    ItemStack freeze = new ItemStack(Material.BARRIER);
		    ItemMeta statsfrezze = ban.getItemMeta();
		    statsfrezze.setDisplayName("§a✖ Freeze ✖");
		    ArrayList<String> frezzelore = new ArrayList();
		    frezzelore.add("");
		    frezzelore.add("§aFreeze le joueur:");
		    frezzelore.add("§e"+mp.getName());
		    frezzelore.add("");
		    statsfrezze.setLore(frezzelore);
		    freeze.setItemMeta(statsfrezze);
		    
		    inv1.setItem(35, freeze);
		    
		    

		    ItemStack inventory = new ItemStack(Material.CHEST);
		    ItemMeta statsinv = inventory.getItemMeta();
		    statsinv.setDisplayName("§aInventaire de "+mp.getName());
		    ArrayList<String> loreinv = new ArrayList();
		    loreinv.add("");
		    loreinv.add("§aOuvrir l'inventaire de");
		    loreinv.add("§e"+mp.getName());
		    loreinv.add("");
		    statsinv.setLore(loreinv);
		    inventory.setItemMeta(statsinv);
		    
		    inv1.setItem(27, inventory);
		    

		    ItemStack inventoryender = new ItemStack(Material.ENDER_CHEST);
		    ItemMeta statsender = inventoryender.getItemMeta();
		    statsender.setDisplayName("§aEnderChest de "+mp.getName());
		    ArrayList<String> loreinvender = new ArrayList();
		    loreinvender.add("");
		    loreinvender.add("§aOuvrir l'enderchest de");
		    loreinvender.add("§e"+mp.getName());
		    loreinvender.add("");
		    statsender.setLore(loreinvender);
		    inventoryender.setItemMeta(statsender);
		    
		    inv1.setItem(28, inventoryender);
		    
		    

		    ItemStack glass = new ItemStack(Material.STAINED_GLASS_PANE, 1, DyeColor.GRAY.getData());
		    ItemMeta statsglass = glass.getItemMeta();
		    statsglass.setDisplayName("§7Barriere");
		    statsglass.setLore(null);
		    glass.setItemMeta(statsglass);
		    
		    inv1.setItem(9, glass);
		    inv1.setItem(10, glass);
		    inv1.setItem(11, glass);
		    inv1.setItem(12, glass);
		    inv1.setItem(13, glass);
		    inv1.setItem(14, glass);
		    inv1.setItem(15, glass);
		    inv1.setItem(16, glass);
		    inv1.setItem(17, glass);
		    
		    p.openInventory(inv1);
	  }
}
