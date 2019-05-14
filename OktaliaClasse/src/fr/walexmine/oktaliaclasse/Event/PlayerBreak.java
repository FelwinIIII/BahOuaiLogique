package fr.walexmine.oktaliaclasse.Event;

import java.util.Random;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;

import fr.WalexFelwin.OktaliaAPI.Bukkit.API.API_Title;
import fr.walexmine.oktaliaclasse.PRESTIGE;
import fr.walexmine.oktaliaclasse.Main;

public class PlayerBreak implements Listener{

	  
	  public PlayerBreak(Main main) {
	}

	@EventHandler
	  public void Interact(BlockBreakEvent event)
	  {
	    Random r = new Random();
	    int low = 10;
	    int high = 30;
	    double re = r.nextInt(high - low + 1) + low;
	    
	    int low1 = 30;
	    int high1 = 50;
	    double re1 = r.nextInt(high1 - low1 + 1) + low1;
	    
	    Block b = event.getBlock();
	    Player p = event.getPlayer();

	    String pUUID = p.getUniqueId().toString();
	    
	    int xp = 0;
	    if ((b.getType() == Material.GOLD_ORE) && 
	      (!event.getPlayer().getItemInHand().getEnchantments().containsKey(Enchantment.SILK_TOUCH)))
	    {

	    	// SET XP
	        
	        API_Title.sendActionBarTime(p, "§8[§bClasse§8] §a+" + re + " XP reçu pour votre classe", 60);
	        
	        PRESTIGE.EXP.put(p, (int) (PRESTIGE.EXP.get(p)+re));

	    }
	    if ((b.getType() == Material.DIAMOND_ORE) && 
	      (!event.getPlayer().getItemInHand().getEnchantments().containsKey(Enchantment.SILK_TOUCH)))
	    {
	    	
	    	// SET XP
	        
	        API_Title.sendActionBarTime(p, "§8[§bClasse§8] §a+" + re1 + " XP reçu pour votre classe", 60);

	        PRESTIGE.EXP.put(p, (int) (PRESTIGE.EXP.get(p)+re1));
	      
	    }
	    if ((b.getType() == Material.EMERALD_ORE) && 
	      (!event.getPlayer().getItemInHand().getEnchantments().containsKey(Enchantment.SILK_TOUCH)))
	    {
	    	// SET XP
	        
	        API_Title.sendActionBarTime(p, "§8[§bClasse§8] §a+" + re + " XP reçu pour votre classe", 60);

	        PRESTIGE.EXP.put(p, (int) (PRESTIGE.EXP.get(p)+re));
	      
	     }
	  }
	  
	  @EventHandler
	  public void Hache(BlockBreakEvent event)
	  {
	    ItemStack it = event.getPlayer().getItemInHand();
	    Integer level = (Integer)it.getEnchantments().get(Enchantment.DIG_SPEED);
	    if (((it.getType() == Material.DIAMOND_AXE) || (it.getType() == Material.IRON_AXE) || (it.getType() == Material.GOLD_AXE) || (it.getType() == Material.STONE_AXE) || (it.getType() == Material.WOOD_AXE)) && 
	      (it.getEnchantments().containsKey(Enchantment.DIG_SPEED)) && (
	      (level.intValue() == 5) || (level.intValue() == 4)))
	    {
	      event.getPlayer().sendMessage("§8[§bOktalia§8] §cCette enchantement est désactivé");
	      it.addEnchantment(Enchantment.DIG_SPEED, 3);
	    }
	  }
}
