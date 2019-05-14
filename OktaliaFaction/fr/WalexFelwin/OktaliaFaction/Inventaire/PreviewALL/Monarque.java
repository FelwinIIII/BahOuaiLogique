package fr.WalexFelwin.OktaliaFaction.Inventaire.PreviewALL;

import org.bukkit.Bukkit;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

import fr.WalexFelwin.OktaliaAPI.Bukkit.API.API_Inventaire;

public class Monarque {
	
	public static void MonarquePreview(Player p) {
		Inventory inv = Bukkit.createInventory(null, 54, "§7§lKit §9§lMonarque");
		
		//------------------CONTOUR---------------------//
		
		API_Inventaire.additems(160, 1, 7, inv, "", null, 0);
		API_Inventaire.additems(160, 1, 7, inv, "", null, 1);
		API_Inventaire.additems(160, 1, 7, inv, "", null, 2);
		API_Inventaire.additems(160, 1, 7, inv, "", null, 3);
		API_Inventaire.additems(160, 1, 7, inv, "", null, 4);
		API_Inventaire.additems(160, 1, 7, inv, "", null, 5);
		API_Inventaire.additems(160, 1, 7, inv, "", null, 6);
		API_Inventaire.additems(160, 1, 7, inv, "", null, 7);
		API_Inventaire.additems(160, 1, 7, inv, "", null, 8);
		API_Inventaire.additems(160, 1, 7, inv, "", null, 9);
		API_Inventaire.additemsenchant(276, 1, 0, inv, Enchantment.DAMAGE_ALL, 4, Enchantment.DURABILITY, 2, "", null, 11);
		API_Inventaire.additemsenchant(306, 1, 0, inv, Enchantment.PROTECTION_ENVIRONMENTAL, 3, Enchantment.DURABILITY, 2, "", null, 12);
		API_Inventaire.additemsenchant(311, 1, 0, inv, Enchantment.PROTECTION_ENVIRONMENTAL, 3, Enchantment.DURABILITY, 2, "", null, 13);
		API_Inventaire.additemsenchant(312, 1, 0, inv, Enchantment.PROTECTION_ENVIRONMENTAL, 3, Enchantment.DURABILITY, 2, "", null, 14);
		API_Inventaire.additemsenchant(309, 1, 0, inv, Enchantment.PROTECTION_ENVIRONMENTAL, 3, Enchantment.DURABILITY, 2, "", null, 15);
		API_Inventaire.additems(160, 1, 7, inv, "", null, 17);
		API_Inventaire.additems(160, 1, 7, inv, "", null, 18);
		API_Inventaire.additems(322, 8, 0, inv, "", null, 20);
		API_Inventaire.additemsenchant(278, 1, 0, inv, Enchantment.DIG_SPEED, 5, Enchantment.DURABILITY, 2, "", null, 21);
		API_Inventaire.additemsenchant(277, 1, 0, inv, Enchantment.DIG_SPEED, 5, Enchantment.DURABILITY, 2, "", null, 22);
		API_Inventaire.additemsenchant(277, 1, 0, inv, Enchantment.DIG_SPEED, 5, Enchantment.DURABILITY, 2, "", null, 23);
		API_Inventaire.additems(368, 6, 0, inv, "", null, 24);
		API_Inventaire.additems(160, 1, 7, inv, "", null, 26);
		API_Inventaire.additems(160, 1, 7, inv, "", null, 27);
		API_Inventaire.additems(160, 1, 7, inv, "", null, 35);
		API_Inventaire.additems(160, 1, 7, inv, "", null, 36);
		API_Inventaire.additems(160, 1, 7, inv, "", null, 44);
		API_Inventaire.additems(160, 1, 7, inv, "", null, 45);
		API_Inventaire.additems(160, 1, 7, inv, "", null, 46);
		API_Inventaire.additems(160, 1, 7, inv, "", null, 47);
		API_Inventaire.additems(160, 1, 7, inv, "", null, 48);
		API_Inventaire.additems(399, 1, 0, inv, "§2Retour Preview", null, 49);
		API_Inventaire.additems(160, 1, 7, inv, "", null, 50);
		API_Inventaire.additems(160, 1, 7, inv, "", null, 51);
		API_Inventaire.additems(160, 1, 7, inv, "", null, 52);
		API_Inventaire.additems(160, 1, 7, inv, "", null, 53);
		
		//------------------CONTOUR---------------------//
		
		p.openInventory(inv);
	}

}
