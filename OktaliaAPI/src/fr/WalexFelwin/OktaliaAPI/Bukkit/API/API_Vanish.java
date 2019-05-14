package fr.WalexFelwin.OktaliaAPI.Bukkit.API;

import org.bukkit.Bukkit;
import org.bukkit.DyeColor;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import fr.WalexFelwin.OktaliaAPI.Bukkit.Commands.Moderation;
import fr.WalexFelwin.OktaliaAPI.Bukkit.Commands.Vanish;


public class API_Vanish {

	
	
	public static void VanishToTrue(Player p){
		
		/*if(!p.hasPotionEffect(PotionEffectType.INVISIBILITY)){
			p.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, Integer.MAX_VALUE, 1));
		}*/
	    for (Player pl : Bukkit.getOnlinePlayers())
	    {
	    	pl.hidePlayer(p);
	    }

		Vanish.Vanish.put(p, "1");
	    if(Moderation.SystémeModo.containsKey(p)){
	    ItemStack VanishOn = new ItemStack(351, 1, DyeColor.LIME.getData());
	    ItemMeta VanishOnmeta = VanishOn.getItemMeta();
	    VanishOnmeta.setDisplayName("§7§lVanish: §aON");
	    VanishOn.setItemMeta(VanishOnmeta);
	    
		p.getInventory().setItem(8, VanishOn);
	    }
	}
	
	
	public static void VanishToFalse(Player p){
		
/*
		if(p.hasPotionEffect(PotionEffectType.INVISIBILITY)){
			p.removePotionEffect(PotionEffectType.INVISIBILITY);
		}*/

	    for (Player pl : Bukkit.getOnlinePlayers())
	    {

	    	pl.showPlayer(p);
	    }
		Vanish.Vanish.remove(p);
	    if(Moderation.SystémeModo.containsKey(p)){
	    ItemStack VanishOFF = new ItemStack(351, 1, DyeColor.SILVER.getData());
	    ItemMeta VanishOFFmeta = VanishOFF.getItemMeta();
	    VanishOFFmeta.setDisplayName("§7§lVanish: §cOFF");
	    VanishOFF.setItemMeta(VanishOFFmeta);
	    
		p.getInventory().setItem(8, VanishOFF);
	    }
	}
}
