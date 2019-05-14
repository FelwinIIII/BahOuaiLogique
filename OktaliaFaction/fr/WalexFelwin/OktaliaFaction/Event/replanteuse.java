package fr.WalexFelwin.OktaliaFaction.Event;

import com.massivecraft.factions.entity.BoardColl;
import com.massivecraft.factions.entity.Faction;
import com.massivecraft.factions.entity.MPlayer;
import com.massivecraft.massivecore.ps.PS;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;

public class replanteuse
  implements Listener
{
  @EventHandler
  public void Blockbreak(BlockBreakEvent e)
  {
    Player p = e.getPlayer();
    if (e.getPlayer().getItemInHand().getType() == Material.SHEARS) {
      if (e.getPlayer().getItemInHand().getItemMeta().getDisplayName().equals("§9§lReplanteuse"))
      {
        Faction faction = null;
        faction = BoardColl.get().getFactionAt(PS.valueOf(e.getBlock().getLocation()));
        
        MPlayer mp = MPlayer.get(p);
        if ((mp.getFaction().getId().equalsIgnoreCase(faction.getId())) || (faction.isNone()))
        {
          if (e.getBlock().getType() == Material.CROPS) {
            if (e.getBlock().getData() == 7)
            {
              e.setCancelled(true);
              e.getBlock().setTypeId(59);
              
              ItemStack drop = new ItemStack(Material.WHEAT);
              
              p.getInventory().addItem(new ItemStack[] { drop });
            }
            else
            {
              e.setCancelled(true);
            }
          }
          if (e.getBlock().getType() == Material.CARROT) {
            if (e.getBlock().getData() == 7)
            {
              e.setCancelled(true);
              e.getBlock().setTypeId(141);
              
              ItemStack drop = new ItemStack(Material.CARROT_ITEM);
              
              p.getInventory().addItem(new ItemStack[] { drop });
            }
            else
            {
              e.setCancelled(true);
            }
          }
          if (e.getBlock().getType() == Material.POTATO) {
            if (e.getBlock().getData() == 7)
            {
              e.setCancelled(true);
              e.getBlock().setTypeId(142);
              
              ItemStack drop = new ItemStack(Material.POTATO_ITEM);
              
              p.getInventory().addItem(new ItemStack[] { drop });
            }
            else
            {
              e.setCancelled(true);
            }
          }
        }
      }
    }
  }
}
