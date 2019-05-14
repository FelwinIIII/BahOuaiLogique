package fr.walexmine.OktaliaRuche.Event;

import java.util.Arrays;
import java.util.List;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockState;
import org.bukkit.block.Skull;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.EntityExplodeEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

import com.massivecraft.factions.entity.BoardColl;
import com.massivecraft.factions.entity.Faction;
import com.massivecraft.factions.entity.MPlayer;
import com.massivecraft.massivecore.ps.PS;

import fr.walexmine.OktaliaRuche.Main;

public class Break implements Listener{

	
	public Break(Main main) {
		
	}
	
	  @EventHandler
	  public void boom(EntityExplodeEvent event)
	  {
	    List<Block> b1 = event.blockList();
	    for (int i = 0; i < b1.size(); i++)
	    {
	      Block b = (Block)b1.get(i);
	      if (b.getType() != Material.SKULL) {
	        b.breakNaturally();
	      }
	      if (b.getType() == Material.SKULL)
	      {
	        BlockState bs = b.getState();
	        Skull skulle = (Skull)bs;
	        if (skulle.hasOwner())
	        {
	          if (skulle.getOwner().equalsIgnoreCase("eSport_"))
	          {
	            ItemStack skull = new ItemStack(Material.SKULL_ITEM, 1, (short)3);
	            SkullMeta skullMeta = (SkullMeta)skull.getItemMeta();
	            skullMeta.setOwner("eSport_");
	            skullMeta.setDisplayName("§e§k!!! §bRuche §e§k!!!");
	            skull.setItemMeta(skullMeta);
	            
	            event.setCancelled(true);
	            b.getWorld().dropItem(b.getLocation(), new ItemStack(skull));
	            b.setType(Material.AIR);
	          }
	          if (skulle.getOwner().equalsIgnoreCase("_FayWin_"))
	          {
	            ItemStack skull = new ItemStack(Material.SKULL_ITEM, 1, (short)3);
	            SkullMeta skullMeta = (SkullMeta)skull.getItemMeta();
	            skullMeta.setOwner("eSport_");
	            skullMeta.setDisplayName("§e§k!!! §bRuche §e§k!!!");
	            skull.setItemMeta(skullMeta);
	            
	            ItemStack miel = new ItemStack(Material.CAULDRON_ITEM);
	            ItemMeta mielMeta = miel.getItemMeta();
	  	      mielMeta.setDisplayName("§6Pôt de Miel");
	  	      mielMeta.setLore(Arrays.asList(new String[] { "§8§ §aShift §e+ §aClique droit §epour revendre." }));
	            miel.setItemMeta(mielMeta);
	            
	            event.setCancelled(true);
	            b.getWorld().dropItem(b.getLocation(), new ItemStack(miel));
	            b.getWorld().dropItem(b.getLocation(), new ItemStack(skull));
	            b.setType(Material.AIR);
	          }
	          b1.remove(b1);
	        }
	        if (b1.size() == 0) {
	          break;
	        }
	      }
	    }
	  }
	  
	  @EventHandler
	  public void breakRuche(BlockBreakEvent event)
	  {
	    Block b = event.getBlock();
	    Player p = event.getPlayer();
	    
	    
	    if (b.getType() == Material.SKULL)
	    {
	        Faction faction = null;
	        faction = BoardColl.get().getFactionAt(PS.valueOf(event.getBlock().getLocation()));
	        
	        MPlayer mp = MPlayer.get(p);
	        if ((mp.getFaction().getId().equalsIgnoreCase(faction.getId())) || (faction.isNone()))
	        {
	      ItemStack skull = new ItemStack(Material.SKULL_ITEM, 1, (short)3);
	      SkullMeta skullMeta = (SkullMeta)skull.getItemMeta();
	      skullMeta.setOwner("eSport_");
	      skullMeta.setDisplayName("§e§k!!! §bRuche §e§k!!!");
	      skull.setItemMeta(skullMeta);
	      
	      ItemStack miel = new ItemStack(Material.CAULDRON_ITEM);
	      ItemMeta mielMeta = miel.getItemMeta();
	      mielMeta.setDisplayName("§6Pôt de Miel");
	      mielMeta.setLore(Arrays.asList(new String[] { "§8§ §aShift §e+ §aClique droit §epour revendre." }));
	      miel.setItemMeta(mielMeta);
	      
	      BlockState bs = b.getState();
	      Skull skulle = (Skull)bs;
	      
	      if (skulle.hasOwner())
	      {
	        if (skulle.getOwner().equalsIgnoreCase("_FayWin_"))
	        {
	          b.getWorld().dropItem(event.getBlock().getLocation(), new ItemStack(miel));
	          b.getWorld().dropItem(event.getBlock().getLocation(), new ItemStack(skull));
	          event.setCancelled(true);

	          b.setType(Material.AIR);
	        }
	        if (skulle.getOwner().equalsIgnoreCase("eSport_"))
	        {
	          b.getWorld().dropItem(event.getBlock().getLocation(), new ItemStack(skull));
	          event.setCancelled(true);
	          b.setType(Material.AIR);
	        }
	      }
	    }}
	  }
}
