package fr.WalexFelwin.OktaliaFaction.Box;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.plugin.PluginManager;
import org.bukkit.scheduler.BukkitScheduler;

public class ClickEventBox
  implements Listener
{
  @EventHandler
  public void onPlayerUse(PlayerInteractEvent e)
  {
    if (e.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {
      if ((e.getClickedBlock().getType().equals(Material.COAL_BLOCK)) && 
        (e.getClickedBlock().getX() < 100) && 
        (e.getClickedBlock().getZ() < 100) && 
        (e.getClickedBlock().getX() > -100) && 
        (e.getClickedBlock().getZ() > -100))
      {
        int sec = 1;
        int secc = 2;
        int seccc = 3;
        final Player p = e.getPlayer();
        
        Animation.Etape1(p, 1);
        
        Bukkit.getScheduler().scheduleSyncDelayedTask(Bukkit.getPluginManager().getPlugin("OktaliaFaction"), new Runnable()
        {
          public void run()
          {
            Animation.Etape1(p, 2);
          }
        }, sec * 20L);
        
        Bukkit.getScheduler().scheduleSyncDelayedTask(Bukkit.getPluginManager().getPlugin("OktaliaFaction"), new Runnable()
        {
          public void run()
          {
            Animation.Etape1(p, 3);
          }
        }, secc * 20L);
        
        Bukkit.getScheduler().scheduleSyncDelayedTask(Bukkit.getPluginManager().getPlugin("OktaliaFaction"), new Runnable()
        {
          public void run()
          {
            Loots.loots("gold", p);
          }
        }, seccc * 20L);
      }
    }
  }
}
