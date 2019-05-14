package fr.WalexFelwin.OktaliaAPI.Bukkit.Commands;

import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.WalexFelwin.OktaliaAPI.Bukkit.Utils.Message;


public class Freeze implements CommandExecutor {
	
	
	  public static HashMap<String, String> FreezePlayer = new HashMap();
	  
	  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
	  {
	    Player p = (Player)sender;
	    
	    
	    
	    if (label.equalsIgnoreCase("freeze"))
	    {
	    	if(p.hasPermission("perm.freeze")){
	    	
	  
	    		if(args.length == 0){
	    			p.sendMessage("§a/freeze §e[player]");
	    		}
	    		
	    		if(args.length == 1){
	    		
	    		Player freeze = Bukkit.getServer().getPlayer(args[0]);
	    		
	    		if(freeze == null){
	    			Message.RETURNPLAYERNULL(p);
	    			return false;
	    		}
	    	
	    		if(FreezePlayer.containsKey(freeze.getName())){
	    			
	    			FreezePlayer.remove(freeze.getName());
		    		p.sendMessage("§aLe joueur §e"+freeze.getName()+"§a n'es plus freeze !");
	    			freeze.sendMessage("§aTu n'es plus freeze !");
	    		} else {
	    			
	    			FreezePlayer.put(freeze.getName(), "");
		    		p.sendMessage("§aLe joueur §e"+freeze.getName()+"§a a été freeze");
		    		freeze.sendMessage("§aTu as été freeze tu ne peut plus bouger !");
	    			
	    		}
	    		}
	    		
	    	
	    	
	    	
	    } else {
	    	Message.RETURNNOPERMISSION(p);
	      }
	   }
	    
	    return true; 
	  }

}
