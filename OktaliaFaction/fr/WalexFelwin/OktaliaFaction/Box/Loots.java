package fr.WalexFelwin.OktaliaFaction.Box;

import fr.WalexFelwin.OktaliaAPI.Bukkit.API.API_Inventaire;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Loots
{
  public static void FinalInvBox(Player p, String box, ItemStack loot)
  {
    if (box == "gold")
    {
      Inventory inv = Bukkit.createInventory(null, 27, "OK");
      
      API_Inventaire.additems(160, 1, 7, inv, "", null, 0);
      API_Inventaire.additems(160, 1, 7, inv, "", null, 1);
      API_Inventaire.additems(160, 1, 7, inv, "", null, 2);
      API_Inventaire.additems(160, 1, 8, inv, "", null, 3);
      API_Inventaire.additems(160, 1, 8, inv, "", null, 4);
      API_Inventaire.additems(160, 1, 8, inv, "", null, 5);
      API_Inventaire.additems(160, 1, 7, inv, "", null, 6);
      API_Inventaire.additems(160, 1, 7, inv, "", null, 7);
      API_Inventaire.additems(160, 1, 7, inv, "", null, 8);
      API_Inventaire.additems(160, 1, 7, inv, "", null, 9);
      API_Inventaire.additems(160, 1, 7, inv, "", null, 10);
      API_Inventaire.additems(160, 1, 7, inv, "", null, 11);
      
      API_Inventaire.additems(160, 1, 8, inv, "", null, 12);
      API_Inventaire.additems(loot.getTypeId(), 1, loot.getData().getData(), inv, "", null, 13);
      API_Inventaire.additems(160, 1, 8, inv, "", null, 14);
      
      API_Inventaire.additems(160, 1, 7, inv, "", null, 15);
      API_Inventaire.additems(160, 1, 7, inv, "", null, 16);
      API_Inventaire.additems(160, 1, 7, inv, "", null, 17);
      API_Inventaire.additems(160, 1, 7, inv, "", null, 18);
      API_Inventaire.additems(160, 1, 7, inv, "", null, 19);
      API_Inventaire.additems(160, 1, 7, inv, "", null, 20);
      API_Inventaire.additems(160, 1, 8, inv, "", null, 21);
      API_Inventaire.additems(160, 1, 8, inv, "", null, 22);
      API_Inventaire.additems(160, 1, 8, inv, "", null, 23);
      API_Inventaire.additems(160, 1, 7, inv, "", null, 24);
      API_Inventaire.additems(160, 1, 7, inv, "", null, 25);
      API_Inventaire.additems(160, 1, 7, inv, "", null, 26);
      
      p.openInventory(inv);
    }
  }
  
  public static void loots(String box, Player p)
  {
    double random = Math.random() * 99.0D;
    int n = (int)random;
    if (box.equalsIgnoreCase("gold")) {
      if (n < 30)
      {
        ItemStack give = new ItemStack(Material.BOOK, 1);
        ItemMeta givemeta = give.getItemMeta();
        givemeta.setDisplayName("�7�lKit �b�lVIP");
        give.setItemMeta(givemeta);
        Give.GiveLoots(p, give);
      }
      else if ((n > 30) && (n < 45))
      {
        ItemStack give = new ItemStack(Material.ENDER_PEARL, 16);
        Give.GiveLoots(p, give);
      }
      else if ((n > 45) && (n < 60))
      {
        ItemStack give = new ItemStack(Material.TNT, 10);
        Give.GiveLoots(p, give);
      }
      else if ((n > 60) && (n < 67))
      {
        ItemStack give = new ItemStack(Material.MONSTER_EGG, 5, (short)50);
        Give.GiveLoots(p, give);
      }
      else if ((n > 67) && (n < 87))
      {
        ItemStack give = new ItemStack(Material.OBSIDIAN, 64);
        Give.GiveLoots(p, give);
      }
      else if ((n > 87) && (n < 95))
      {
        ItemStack give = new ItemStack(Material.MOB_SPAWNER, 1);
        Give.GiveLoots(p, give);
      }
      else if ((n > 95) && (n < 100))
      {
        p.sendMessage("Tu as recu 1000 GOLD");
      }
    }
  }
}
