package fr.WalexFelwin.OktaliaFaction.Event;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class hachelegendaire
  implements Listener
{
  @EventHandler
  public void Playermove(PlayerMoveEvent e)
  {
    Player p = e.getPlayer();
    if ((p.getItemInHand().getType().equals(Material.DIAMOND_AXE)) && 
      (p.getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase("§7§lHache §2§lLégendaire")) && 
      (p.getItemInHand().getItemMeta().hasEnchant(Enchantment.DAMAGE_ALL)))
    {
      PotionEffect force = PotionEffectType.INCREASE_DAMAGE.createEffect(100, 0);
      PotionEffect speed = PotionEffectType.SPEED.createEffect(100, 1);
      PotionEffect fireresistance = PotionEffectType.FIRE_RESISTANCE.createEffect(100, 1);
      p.addPotionEffect(force);
      p.addPotionEffect(fireresistance);
      p.addPotionEffect(speed);
    }
  }
}
