package fr.WalexFelwin.OktaliaFaction.Inventaire.MagasinALL.Interact;

import fr.WalexFelwin.OktaliaAPI.Bukkit.Utils.COINS;
import fr.WalexFelwin.OktaliaFaction.Inventaire.Utils.FinalInv;
import fr.WalexFelwin.OktaliaFaction.Main;
import java.util.List;
import java.util.Map;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryView;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.material.MaterialData;

public class InteractBlock
  implements Listener
{
  public InteractBlock(Main main) {}
  
  @EventHandler
  public void onInventoryClickEvent(InventoryClickEvent e)
  {
    Player p = (Player)e.getWhoClicked();
    String name = p.getOpenInventory().getTopInventory().getTitle();
    if ((name == "§6Block") || (name == "§6Block§8(§71§8)") || (name == "§6Farm") || (name == "§6Minerais") || (name == "§6Alchimie") || (name == "§6Nourriture") || (name == "§6Potions") || (name == "§6Spawner") || (name == "§6Kits") || (name == "§6D§coration") || (name == "§6Enchantement") || (name == "§6Pillage"))
    {
      e.setCancelled(true);
      if ((e.getCurrentItem() == null) && (e.getCurrentItem().getType() == Material.AIR)) {
        return;
      }
      int i;
      if (e.isLeftClick())
      {
        int Prix = Integer.valueOf(((String)e.getCurrentItem().getItemMeta().getLore().get(2)).replace("§c» §7Prix Vente: §6", "").replace("$ unité", "")).intValue();
        
        ItemStack item = new ItemStack(e.getCurrentItem().getType(), e.getCurrentItem().getAmount(), (short)e.getCurrentItem().getData().getData());
        
        ItemStack current = e.getCurrentItem();
        
        i = 0;
        for (i++; i > 36;)
        {
          Bukkit.broadcastMessage("");
          if (p.getInventory().getItem(i).getType().equals(current.getType()))
          {
            int nb = p.getInventory().getItem(i).getAmount();
            
            Bukkit.broadcastMessage(""+nb);
          }
          else
          {
            Bukkit.broadcastMessage("test");
          }
        }
      }
      else if (e.isRightClick())
      {
        ItemStack Item4 = new ItemStack(e.getCurrentItem());
        
        String newprix = ((String)Item4.getItemMeta().getLore().get(1)).replace("§c» §7Prix Achat: §6", "").replace("$ unité", "");
        int Prix = Integer.valueOf(newprix).intValue();
        
        FinalInv.getInv.containsKey(p);
        
        FinalInv.FinalInv1(e.getCurrentItem(), Integer.valueOf(Prix), p, p.getOpenInventory().getTopInventory());
      }
      if (p.getOpenInventory().getTopInventory().getTitle().contains(" > Achat"))
      {
        int Prix = Integer.valueOf(((String)p.getOpenInventory().getTopInventory().getItem(4).getItemMeta().getLore().get(1)).replace("§c» §7Prix Achat: §6", "").replace("$ unité", "")).intValue();
        
        int Quantité = Integer.valueOf(((String)p.getOpenInventory().getTopInventory().getItem(4).getItemMeta().getLore().get(3)).replace("§bQuantité: §e", "")).intValue();
        int Argent = (int)COINS.getoktacoins(p);
        if (Prix < Argent) {
          //i = new ItemStack(p.getOpenInventory().getTopInventory().getItem(4).getType(), Quantité, (short)p.getOpenInventory().getTopInventory().getItem(4).getData().getData());
        }
      }
    }
  }
}
