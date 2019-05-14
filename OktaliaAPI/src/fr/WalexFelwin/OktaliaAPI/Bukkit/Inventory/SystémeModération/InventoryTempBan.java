package fr.WalexFelwin.OktaliaAPI.Bukkit.Inventory.SystémeModération;

import java.util.ArrayList;

import net.minecraft.server.v1_8_R3.ItemStack;

import org.bukkit.Bukkit;
import org.bukkit.DyeColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.meta.ItemMeta;

public class InventoryTempBan implements Listener{


	 private static Inventory inv1;
	
	public static void SystémeTempBan(Player p)
	  {
		    inv1 = Bukkit.createInventory(null, 27, "§6Temp du ban");

		    

		    
		    p.openInventory(inv1);
	  }
}
