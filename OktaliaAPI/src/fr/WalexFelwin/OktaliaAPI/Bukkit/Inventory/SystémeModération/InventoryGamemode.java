package fr.WalexFelwin.OktaliaAPI.Bukkit.Inventory.SystémeModération;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.bukkit.Bukkit;
import org.bukkit.DyeColor;
import org.bukkit.Material;
import org.bukkit.block.banner.Pattern;
import org.bukkit.block.banner.PatternType;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BannerMeta;
import org.bukkit.inventory.meta.ItemMeta;

public class InventoryGamemode {
	  private static Inventory inv1;
		
	  public static void gamemode(Player p)
	  {
		    String date = new SimpleDateFormat("HH:mm").format(new Date(System.currentTimeMillis()));
		    inv1 = Bukkit.createInventory(null, 9, "§egamemode");
		    
		    ItemStack gamemode0 = new ItemStack(Material.SLIME_BALL, 1);
		    ItemMeta gamemode0meta = gamemode0.getItemMeta();
		    gamemode0meta.setDisplayName("§aGamemode 0");
		    gamemode0.setItemMeta(gamemode0meta);
		    
		    ItemStack gamemode1 = new ItemStack(381, 1);
		    ItemMeta gamemode1meta = gamemode1.getItemMeta();
		    gamemode1meta.setDisplayName("§aGamemode 1");
		    gamemode1.setItemMeta(gamemode1meta);
		    
		    ItemStack gamemode2 = new ItemStack(Material.ENDER_PEARL, 1);
		    ItemMeta gamemode2meta = gamemode2.getItemMeta();
		    gamemode2meta.setDisplayName("§aGamemode 3");
		    gamemode2.setItemMeta(gamemode2meta);
		    
		    

		    inv1.setItem(0, gamemode0);
		    inv1.setItem(1, gamemode1);
		    inv1.setItem(2, gamemode2);
		    
		    
		    p.openInventory(inv1);
	  }
}
