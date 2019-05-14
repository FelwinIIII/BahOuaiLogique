package fr.walexmine.OktaliaInvest.Commands;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Invest implements CommandExecutor{
	

	 
	  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
	  {

		  
	    if (label.equalsIgnoreCase("invest"))
	    {                  
	    	

	    	if (args.length == 1 && sender.hasPermission("perm.invest")){
	    		
	
	    		
		   		   if (args[0].equalsIgnoreCase("reload"))
			          {
		   			   
		   			   sender.sendMessage("§a[OktaliaInvest] §eLe plugin d'invest a été reload !");
		   			   
		   			
			          }
	    		
	    	
	    	
	    	
	    	
	    	
	    	} else {

	    	    Player p = (Player)sender;
	    	    
	    		fr.walexmine.OktaliaInvest.Inventaire.Invest.invest(p);
	    		
	    		
	    	}
	    }
	    return true;
	  }

}