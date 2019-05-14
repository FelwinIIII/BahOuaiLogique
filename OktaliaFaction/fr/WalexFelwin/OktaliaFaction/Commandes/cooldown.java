package fr.WalexFelwin.OktaliaFaction.Commandes;

import java.util.ArrayList;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChatEvent;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.plugin.PluginManager;
import org.bukkit.scheduler.BukkitScheduler;

public class cooldown
  implements Listener
{
  static ArrayList<Player> cooldown = new ArrayList();
  static ArrayList<Player> cooldown2 = new ArrayList();
  
  @EventHandler
  public void CommandProcess(PlayerCommandPreprocessEvent e)
  {
    final Player p = e.getPlayer();
    if (!p.isOp()) {
      if (cooldown.contains(p))
      {
        e.setCancelled(true);
        p.sendMessage(ChatColor.GOLD + "Tu dois attendre 2 secondes !");
      }
      else
      {
        cooldown.add(p);
        int sec = 2;
        Bukkit.getScheduler().scheduleSyncDelayedTask(Bukkit.getPluginManager().getPlugin("OktaliaFaction"), new Runnable()
        {
          public void run()
          {
            cooldown.remove(p);
          }
        }, sec * 20L);
      }
    }
  }
  
  @EventHandler
  public void PlayerSpam(PlayerChatEvent e)
  {
    final Player p = e.getPlayer();
    if (!p.isOp()) {
      if (cooldown2.contains(p))
      {
        e.setCancelled(true);
        p.sendMessage(ChatColor.GOLD + "Tu dois attendre 2 secondes !");
      }
      else
      {
        cooldown2.add(p);
        int sec = 2;
        Bukkit.getScheduler().scheduleSyncDelayedTask(Bukkit.getPluginManager().getPlugin("OktaliaFaction"), new Runnable()
        {
          public void run()
          {
            cooldown2.remove(p);
          }
        }, sec * 20L);
      }
    }
  }
}
