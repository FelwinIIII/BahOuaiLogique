package fr.walexmine.OktaliaRuche;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;


public class RucheCommand implements CommandExecutor{
	

	
	 public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
	  {
	   
	    if (label.equalsIgnoreCase("ruche"))
	    {


	    	if(sender.hasPermission("perm.admin"))
	    	{
	    		
	    	sender.sendMessage("§a/ruche give <joueur>");
	    	
	        if (args[0].equalsIgnoreCase("give"))
	          {
	        	
	        	
	        	Player target = sender.getServer().getPlayer(args[1]);
	        	
	        	
	            ItemStack skull = new ItemStack(Material.SKULL_ITEM, 1, (short)3);
	            SkullMeta skullMeta = (SkullMeta)skull.getItemMeta();
	            skullMeta.setOwner("eSport_");
	            skullMeta.setDisplayName("§e§k!!! §bRuche §e§k!!!");
	            skull.setItemMeta(skullMeta);

	            target.getInventory().addItem(skull);

	            target.sendMessage("§7[§bOktalia§7] §aVous avez reçu votre §eRuche §a!");
	            sender.sendMessage("§7[§bOktalia§7] §aLa ruche a bien été donnée à §e"+target.getName()+" §a!");
	            
	          }

	        
	      
	    	}
	    

	    }
	    
	    
	  return true;
	  }
}
