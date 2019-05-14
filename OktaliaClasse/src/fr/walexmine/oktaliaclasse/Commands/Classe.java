package fr.walexmine.oktaliaclasse.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.walexmine.oktaliaclasse.Inventaire.InvClasse;

public class Classe implements CommandExecutor{
	

	 
	  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
	  {
	    Player p = (Player)sender;
	    
	    if(sender instanceof Player) {
	    
	    if (label.equalsIgnoreCase("classe"))
	    {                  

	    	
	    	InvClasse.openinvClasse(p);
	    	
	    	
	    }
	    
	    
	    } 
	    return true;
	  }

}