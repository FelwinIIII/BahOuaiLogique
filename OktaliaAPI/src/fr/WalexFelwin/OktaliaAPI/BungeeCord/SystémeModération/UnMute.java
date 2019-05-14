package fr.WalexFelwin.OktaliaAPI.BungeeCord.SystémeModération;

import java.text.SimpleDateFormat;
import java.util.Date;

import fr.WalexFelwin.OktaliaAPI.BungeeCord.Utils;
import fr.WalexFelwin.OktaliaAPI.BungeeCord.API.API_INFOPERM;
import fr.WalexFelwin.OktaliaAPI.BungeeCord.API.API_MUTE;
import fr.WalexFelwin.OktaliaAPI.BungeeCord.API.API_TEMPMUTE;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class UnMute extends Command{

	
	public UnMute() {
	    super("unmute", null, new String[0]);
		// TODO Auto-generated constructor stub
	}
	@SuppressWarnings("deprecation")
	@Override
	public void execute(CommandSender sender, String[] arg1) {

		String statsperm = ""+API_INFOPERM.getmuteperm(""+sender.getName()); 
			if(statsperm.equalsIgnoreCase("TRUE")){
		    if (arg1.length < 1)
		    {
		    	sender.sendMessage(new TextComponent( Utils.prefix+ChatColor.GREEN + "/unmute <joueur>§e | unmute le joueur du serveur"));
		      return;
		    }
			/* 
			 * 
			 * Méthode set le int du getban à 1 = UNBAN
			 * SetRaison Affiche le UNBAN par +la personnes du staff est la date du unban
			 * /!\ La Personne doit déja être ban Vérif 
			 * 
		    */
		    long getmute = API_MUTE.getmutedeco(arg1[0]);
		    long gettempmute = API_TEMPMUTE.getmutedeco(arg1[0]);
		    if (gettempmute <= 1){
		    	 if (getmute <= 1) {
				    	
				    	sender.sendMessage(Utils.prefix+" §aLe joueur "+arg1[0]+" n'est pas mute !");
				    	
				    } else {
				    	
				    	
				    	
						String date = new SimpleDateFormat("d/MMMMM/y / HH:mm:ss").format(new Date(System.currentTimeMillis()));

					       
					    sender.sendMessage(new TextComponent(Utils.prefix+ChatColor.GREEN + arg1[0] + " a été unmute du serveur !"));
					    String reason = "UNBAN par : "+sender.getName()+" le : "+date;
					    
					    API_MUTE.setraison(arg1[0], reason);
					    API_MUTE.setmutedeco(arg1[0], 1);
				    }
		    	
		    } else {
		    	
		    	
		    	
				String date = new SimpleDateFormat("d/MMMMM/y / HH:mm:ss").format(new Date(System.currentTimeMillis()));

			       
			    sender.sendMessage(new TextComponent(Utils.prefix+ChatColor.GREEN + arg1[0] + " a été unmute du serveur !"));
			    String reason = "UNMUTE par : "+sender.getName()+" le : "+date;

			    API_TEMPMUTE.setraison(arg1[0], reason);
			    API_TEMPMUTE.setend(arg1[0], (long) 0.000);
			    API_TEMPMUTE.setmutedeco(arg1[0], 1);
		    }
		   
		    
		}
		

		}
}
