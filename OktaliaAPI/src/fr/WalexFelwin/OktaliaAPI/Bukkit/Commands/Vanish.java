package fr.WalexFelwin.OktaliaAPI.Bukkit.Commands;

import java.util.HashMap;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.WalexFelwin.OktaliaAPI.Bukkit.API.API_Vanish;
import fr.WalexFelwin.OktaliaAPI.Bukkit.Utils.Message;

public class Vanish implements CommandExecutor{

	
	public static HashMap<Player, String> Vanish = new HashMap();
	
	  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
	  {
	    Player p = (Player)sender;

	    if (label.equalsIgnoreCase("vanish"))
	    {
		    if(p.hasPermission("perm.vanish")){
	    	
	    
	    	if(args.length == 0){
	    	
		    	if(Vanish.containsKey(p)){
		    		
		    		API_Vanish.VanishToFalse(p);
		    	    
		    	}else{
		    		
		    		API_Vanish.VanishToTrue(p);
		    		
		    	}
		    }
	    	
	    	if(args.length > 0){
	    		p.sendMessage("§a/Vanish §e| Activée et Désactivée");
	    	}
		    } else {
		    	Message.RETURNNOPERMISSION(p);
		    }
	    }
	    
	    return true;
	  }
}
