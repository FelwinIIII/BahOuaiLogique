package fr.WalexFelwin.OktaliaAPI.BungeeCord.SystémeModération;

import java.text.SimpleDateFormat;
import java.util.Date;

import fr.WalexFelwin.OktaliaAPI.BungeeCord.Utils;
import fr.WalexFelwin.OktaliaAPI.BungeeCord.API.API_BAN;
import fr.WalexFelwin.OktaliaAPI.BungeeCord.API.API_BANIP;
import fr.WalexFelwin.OktaliaAPI.BungeeCord.API.API_INFOPERM;
import fr.WalexFelwin.OktaliaAPI.BungeeCord.API.API_Login;
import fr.WalexFelwin.OktaliaAPI.BungeeCord.API.API_TEMPBAN;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.plugin.Command;

public class UnBan extends Command{

	
	public UnBan() {
	    super("unban", null, new String[0]);
		// TODO Auto-generated constructor stub
	}
	@SuppressWarnings("deprecation")
	@Override
	public void execute(CommandSender sender, String[] arg1) {


		String statsperm = ""+API_INFOPERM.getbanperm(sender.getName()); 
			if(statsperm.equalsIgnoreCase("TRUE")){
		    if (arg1.length == 0)
		    {
		    	sender.sendMessage(new TextComponent(Utils.prefix+ChatColor.GREEN + "/unban <joueur>§e | unban le joueur du serveur"));
		      return;
		    }
			/* 
			 * 
			 * Méthode set le int du getban à 1 = UNBAN
			 * SetRaison Affiche le UNBAN par +la personnes du staff est la date du unban
			 * /!\ La Personne doit déja être ban Vérif 
			 * 
		    */
		    long getban = API_BAN.getbandeco(arg1[0]);
		    long gettempban = API_TEMPBAN.getbandeco(arg1[0]);
		    if (gettempban <= 1){
		    	
			    	
			    	if (getban <= 1){
			    		
			    		sender.sendMessage(Utils.prefix+" §aLe joueur "+arg1[0]+" n'est pas ban !");
			    		
			    		
			    	} else {
			    	  	
				    	
						String date = new SimpleDateFormat("d/MMMMM/y / HH:mm:ss").format(new Date(System.currentTimeMillis()));

					       
					    sender.sendMessage(new TextComponent(Utils.prefix+ChatColor.GREEN + arg1[0] + " a été unban du serveur !"));
					    String reason = "UNBAN par : "+sender.getName()+" le : "+date;
					    
					    API_BAN.setraison(arg1[0], reason);
					    API_BANIP.setbandeco(API_Login.getip(arg1[0]), 1);
					    API_BANIP.setraison(API_Login.getip(arg1[0]), reason);
					    API_BAN.setbanTYPEDeco(arg1[0], 1);
					    return;
				    }
		    	
		    } else {
		    	
		    	
		    	
				String date = new SimpleDateFormat("d/MMMMM/y / HH:mm:ss").format(new Date(System.currentTimeMillis()));

			       
			    sender.sendMessage(new TextComponent(Utils.prefix+ChatColor.GREEN + arg1[0] + " a été unban du serveur !"));
			    String reason = "UNBAN par : "+sender.getName()+" le : "+date;

			    API_TEMPBAN.setbandeco(arg1[0], 1);
			    API_BANIP.setbandeco(API_Login.getip(arg1[0]), 1);
			    API_BANIP.setraison(API_Login.getip(arg1[0]), reason);
			    API_TEMPBAN.setraison(arg1[0], reason);
			    return;
		    }
		}
		    

		

	}
		
}
