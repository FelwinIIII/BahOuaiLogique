package fr.WalexFelwin.OktaliaFaction.Event;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class randomkit
  implements Listener
{
  @EventHandler
  public void onPlayerUse(PlayerInteractEvent e)
  {
    Player p = e.getPlayer();
    if ((e.getAction().equals(Action.RIGHT_CLICK_AIR)) || (e.getAction().equals(Action.RIGHT_CLICK_BLOCK)))
    {
      if ((p.getItemInHand().getType().equals(Material.BOOK)) && 
        (p.getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase("§7§lKit §2§lVoyageur")))
      {
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "kit voyageur " + p.getName());
        
        ItemStack give = new ItemStack(Material.BOOK, p.getItemInHand().getAmount() - 1);
        ItemMeta givemeta = give.getItemMeta();
        givemeta.setDisplayName("§7§lKit §2§lVoyageur");
        give.setItemMeta(givemeta);
        p.setItemInHand(give);
      }
      if ((p.getItemInHand().getType().equals(Material.BOOK)) && 
        (p.getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase("§7§lKit §b§lLegionnaire")))
      {
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "kit legionnaire " + p.getName());
        
        ItemStack give = new ItemStack(Material.BOOK, p.getItemInHand().getAmount() - 1);
        ItemMeta givemeta = give.getItemMeta();
        givemeta.setDisplayName("§7§lKit §b§lLegionnaire");
        give.setItemMeta(givemeta);
        p.setItemInHand(give);
      }
      if ((p.getItemInHand().getType().equals(Material.BOOK)) && 
        (p.getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase("§7§lKit §6§lMaitre")))
      {
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "kit maitre " + p.getName());
        
        ItemStack give = new ItemStack(Material.BOOK, p.getItemInHand().getAmount() - 1);
        ItemMeta givemeta = give.getItemMeta();
        givemeta.setDisplayName("§7§lKit §6§lMaitre");
        give.setItemMeta(givemeta);
        p.setItemInHand(give);
      }
      if ((p.getItemInHand().getType().equals(Material.BOOK)) && 
        (p.getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase("§7§lKit §9§lMonarque")))
      {
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "kit monarque " + p.getName());
        
        ItemStack give = new ItemStack(Material.BOOK, p.getItemInHand().getAmount() - 1);
        ItemMeta givemeta = give.getItemMeta();
        givemeta.setDisplayName("§7§lKit §9§lMonarque");
        give.setItemMeta(givemeta);
        p.setItemInHand(give);
      }
      if ((p.getItemInHand().getType().equals(Material.BOOK)) && 
        (p.getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase("§7§lKit §b§lVIP")))
      {
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "kit vip " + p.getName());
        
        ItemStack give = new ItemStack(Material.BOOK, p.getItemInHand().getAmount() - 1);
        ItemMeta givemeta = give.getItemMeta();
        givemeta.setDisplayName("§7§lKit §b§lVIP");
        give.setItemMeta(givemeta);
        p.setItemInHand(give);
      }
      if ((p.getItemInHand().getType().equals(Material.BOOK)) && 
        (p.getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase("§7§lKit §e§lVIP+")))
      {
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "kit vipplus " + p.getName());
        
        ItemStack give = new ItemStack(Material.BOOK, p.getItemInHand().getAmount() - 1);
        ItemMeta givemeta = give.getItemMeta();
        givemeta.setDisplayName("§7§lKit §e§lVIP+");
        give.setItemMeta(givemeta);
        p.setItemInHand(give);
      }
    }
  }
}
