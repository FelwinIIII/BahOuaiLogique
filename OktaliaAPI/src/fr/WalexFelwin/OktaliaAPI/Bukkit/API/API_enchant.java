package fr.WalexFelwin.OktaliaAPI.Bukkit.API;

import java.util.ArrayList;

import org.bukkit.craftbukkit.v1_8_R3.inventory.CraftItemStack;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import net.minecraft.server.v1_8_R3.NBTTagCompound;
import net.minecraft.server.v1_8_R3.NBTTagList;

public class API_enchant {

	
	
	public static ItemStack addgloweffect(ItemStack item) {
		
		net.minecraft.server.v1_8_R3.ItemStack nmsItem = CraftItemStack.asNMSCopy(item);
		
		NBTTagCompound nbt = nmsItem.getTag() == null ? new NBTTagCompound() : nmsItem.getTag();
		
		NBTTagList ench = new NBTTagList();
				
		nbt.set("ench", ench);
		nmsItem.setTag(nbt);
		
		return CraftItemStack.asBukkitCopy(nmsItem);
		
		
	}
	
	public static void additemsenchant(int Item, int NB, int data, Inventory inv1, Enchantment enchant1, int nvenchant1, Enchantment enchant2, int nvenchant2, String DisplayName, ArrayList<String> lore, int Place){

        int spec = 0;

        ItemStack item = null;

        if(!(data == 0)){
            spec = data;
            item = new ItemStack(Item, NB, ((short)spec));
        } else {
        item = new ItemStack(Item, NB);
        }
        ItemMeta itemmeta = item.getItemMeta();
            itemmeta.setDisplayName(DisplayName);
            itemmeta.setLore(lore);
            itemmeta.addEnchant(enchant1, nvenchant1, true);
            itemmeta.addEnchant(enchant2, nvenchant2, true);
        item.setItemMeta(itemmeta);


            inv1.setItem(Place, item);



	}
	
	public static void additemsenchant2(int Item, int NB, int data, Inventory inv1, Enchantment enchant1, int nvenchant1, Enchantment enchant2, int nvenchant2, String DisplayName, ArrayList<String> lore, int Place){
	
	    int spec = 0;
	
	    ItemStack item = null;
	
	    if(!(data == 0)){
	        spec = data;
	        item = new ItemStack(Item, NB, ((short)spec));
	    } else {
	    item = new ItemStack(Item, NB);
	    }
	    ItemMeta itemmeta = item.getItemMeta();
	        itemmeta.setDisplayName(DisplayName);
	        itemmeta.setLore(lore);
	        itemmeta.addEnchant(enchant1, nvenchant1, true);
	        itemmeta.addEnchant(enchant2, nvenchant2, true);
	    item.setItemMeta(itemmeta);
	
	
	        inv1.setItem(Place, item);
	
	
	
	}
}
