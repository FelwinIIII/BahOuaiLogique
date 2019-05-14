package fr.WalexFelwin.OktaliaAPI.BungeeCord.SystémeModération;

import fr.WalexFelwin.OktaliaAPI.BungeeCord.Utils;
import fr.WalexFelwin.OktaliaAPI.BungeeCord.API.API_INFOPERM;
import fr.WalexFelwin.OktaliaAPI.BungeeCord.API.API_TEMPMUTE;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class TempMute extends Command {

	public TempMute() {
	    super("tempmute", null, new String[0]);
		// TODO Auto-generated constructor stub
	}

	 public void execute(CommandSender sender, String[] args)
	  {
			

			String statsperm = ""+API_INFOPERM.gettempmuteperm(sender.getName()); 
				if(statsperm.equalsIgnoreCase("TRUE")){

		
			
	      if (args.length < 4)
	      {
	        sender.sendMessage(Utils.prefix + ChatColor.GREEN + "/tempmute <joueur> <Temps> <s/m/h/j/w> <raison>§e | tempmute le joueur du serveur");
	      }
	      else
	      {
	        String TimeUnit = args[2];
	        String message = "";
	        for (int i = 3; i < args.length; i++) {
	          message = message + args[i] + " ";
	        }
	        int Time = Integer.parseInt(args[1]);
	        if ((TimeUnit.equalsIgnoreCase("sec")) || 
	          (TimeUnit.equalsIgnoreCase("s")) || 
	          (TimeUnit.equalsIgnoreCase("second")) || 
	          (TimeUnit.equalsIgnoreCase("seconds")) || 
	          (TimeUnit.equalsIgnoreCase("secs")))
	        {
			    sender.sendMessage((Utils.prefix + ChatColor.GREEN + args[0] + " a été mute sur le serveur !"));
	          
			    
	          API_TEMPMUTE.mute(args[0], message, sender.getName(), Time * 1);
	          
			    
	          
	        }
	        else if ((TimeUnit.equalsIgnoreCase("min")) || 
	          (TimeUnit.equalsIgnoreCase("minute")) || 
	          (TimeUnit.equalsIgnoreCase("m")) || 
	          (TimeUnit.equalsIgnoreCase("mins")) || 
	          (TimeUnit.equalsIgnoreCase("minutes")))
	        {
			    sender.sendMessage((Utils.prefix + ChatColor.GREEN + args[0] + " a été mute sur le serveur !"));
			    
			    API_TEMPMUTE.mute(args[0], message, sender.getName(), 
	            Time * 60);
	        }
	        else if ((TimeUnit.equalsIgnoreCase("h")) || 
	          (TimeUnit.equalsIgnoreCase("hour")) || 
	          (TimeUnit.equalsIgnoreCase("hours")))
	        {
			    sender.sendMessage((Utils.prefix + ChatColor.GREEN + args[0] + " a été mute sur le serveur !"));
			    
			    API_TEMPMUTE.mute(args[0], message, sender.getName(), 
	            Time * 60 * 60);
	        }
	        else if ((TimeUnit.equalsIgnoreCase("j")) || 
	          (TimeUnit.equalsIgnoreCase("jour")) || 
	          (TimeUnit.equalsIgnoreCase("jours")))
	        {
			    sender.sendMessage((Utils.prefix + ChatColor.GREEN + args[0] + " a été mute sur le serveur !"));

			    API_TEMPMUTE.mute(args[0], message, sender.getName(), 
	            Time * 60 * 60 * 24);
	        }
	        else if ((TimeUnit.equalsIgnoreCase("w")) || 
	          (TimeUnit.equalsIgnoreCase("week")) || 
	          (TimeUnit.equalsIgnoreCase("weeks")))
	        {
			    sender.sendMessage((Utils.prefix + ChatColor.GREEN + args[0] + " a été mute sur le serveur !"));
			    
			    API_TEMPMUTE.mute(args[0], message, sender.getName(), Time * 
	            60 * 60 * 24 * 7);
	        }
	        else
	        {
	          sender.sendMessage(Utils.prefix + "!");
	          sender.sendMessage(Utils.prefix + 
	            "§c< sec | min | h | j | w >");
	        }
	      }
	    }
	    else {

	    
	  }
	
	}


}
