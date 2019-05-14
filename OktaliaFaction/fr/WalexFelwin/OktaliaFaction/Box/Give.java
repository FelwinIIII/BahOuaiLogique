package fr.WalexFelwin.OktaliaFaction.Box;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.plugin.PluginManager;
import org.bukkit.scheduler.BukkitScheduler;

public class Give
{
  public static void GiveLoots(final Player p, ItemStack loot)
  {
    Loots.FinalInvBox(p, "gold", loot);
    
    p.getInventory().addItem(new ItemStack[] { loot });
    
    int sec = 3;
    
    Bukkit.getScheduler().scheduleSyncDelayedTask(Bukkit.getPluginManager().getPlugin("OktaliaFaction"), new Runnable()
    {
      public void run()
      {
        p.closeInventory();
      }
    }, sec * 20L);
  }
}
