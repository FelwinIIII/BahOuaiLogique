package fr.WalexFelwin.OktaliaFaction.Event;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class nerf
  implements Listener
{
  @EventHandler
  public void closeinv(PlayerItemConsumeEvent e)
  {
    Player p = e.getPlayer();
    
    ItemStack gapple = new ItemStack(Material.GOLDEN_APPLE);
    ItemStack force2 = new ItemStack(Material.POTION);
    if ((e.getItem().getType().equals(gapple.getType())) && 
      (e.getItem().getData().getData() == 1))
    {
      e.setCancelled(true);
      
      ItemStack give = new ItemStack(Material.GOLDEN_APPLE, p.getItemInHand().getAmount() - 1, (short)1);
      
      PotionEffect regen = PotionEffectType.REGENERATION.createEffect(320, 1);
      PotionEffect absorption = PotionEffectType.ABSORPTION.createEffect(3600, 0);
      p.addPotionEffect(regen);
      p.addPotionEffect(absorption);
      
      p.setItemInHand(give);
    }
    if (e.getItem().getType().equals(force2.getType())) {
      if (e.getItem().getData().getData() == 41)
      {
        e.setCancelled(true);
        
        PotionEffect force = PotionEffectType.INCREASE_DAMAGE.createEffect(3600, 7);
        
        p.addPotionEffect(force);
        
        ItemStack give = new ItemStack(Material.POTION, p.getItemInHand().getAmount() - 1, (short)41);
        
        p.setItemInHand(give);
      }
    }
  }
}
