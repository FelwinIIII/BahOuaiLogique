package fr.WalexFelwin.OktaliaAPI.BungeeCord.SystémeModération;

import java.text.SimpleDateFormat;
import java.util.Date;

import fr.WalexFelwin.OktaliaAPI.BungeeCord.Utils;
import fr.WalexFelwin.OktaliaAPI.BungeeCord.API.API_BAN;
import fr.WalexFelwin.OktaliaAPI.BungeeCord.API.API_BANIP;
import fr.WalexFelwin.OktaliaAPI.BungeeCord.API.API_INFOPERM;
import fr.WalexFelwin.OktaliaAPI.BungeeCord.API.API_Login;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class BanIp  extends Command {

	public BanIp() {
	    super("banip", null, new String[]{"ban-ip"});
		// TODO Auto-generated constructor stub
	}
	@SuppressWarnings("deprecation")
	@Override
	public void execute(CommandSender sender, String[] arg1) {

		String statsperm = ""+API_INFOPERM.getbanperm(sender.getName()); 
			if(statsperm.equalsIgnoreCase("TRUE")){
		    if (arg1.length < 1)
		    {
		    	sender.sendMessage(new TextComponent(Utils.prefix + ChatColor.GREEN + "/banip <joueur> <raison>§e | ban le joueur du serveur"));
		      
		    	
		    	return;
		    }
			ProxiedPlayer p = ProxyServer.getInstance().getPlayer(arg1[0]);
			
		    	 String reason = "";
			        for (int i = 1; i < arg1.length; i++) {
			          reason = (reason == "" ? "" : new StringBuilder(String.valueOf(reason)).append(" ").toString()) + arg1[i];
			        }
		    
					// TODO Auto-generated method stub
				    if (p == null)
				    {
				    	
				    	String IP = API_Login.getip(arg1[0]);
				    	
				    	if(IP == null){
				    	sender.sendMessage("§cLe joueurs ne c'est jamais connectée sur Oktalia");
				    	sender.sendMessage("§cVérifier si le pseudo est exacte");
				    		return;
				    	} else {
				    	
				    	sender.sendMessages((Utils.prefix +"§4Le joueur non connecté a été enregistré dans la BDD "));
				    	sender.sendMessages((Utils.prefix + ChatColor.GREEN + arg1[0] + " a été ban ip du serveur !"));
					    
						String date = new SimpleDateFormat("d/MMMMM/y / HH:mm:ss").format(new Date(System.currentTimeMillis()));
					   
						
						   
						API_BAN.setdate(arg1[0], date);
						API_BAN.setbanpar(arg1[0], sender.getName());
						API_BAN.setraison(arg1[0], reason);
						API_BAN.setbanTYPEDeco(arg1[0], 10);
						API_BANIP.Ban(IP, reason, sender.getName(), 0);

				      return;
				    	}
				    } else {
				    	String IP = p.getAddress().getHostString();
				    	
				    	
					    p.disconnect(Utils.prefixTitle +"\n§aVous avez été banni ip du serveur Oktalia \n\n §7(§cDurée: §ePermanent§7)  \nRaison: "+ reason);
					    sender.sendMessage((Utils.prefix + ChatColor.GREEN + arg1[0] + " a été ban ip du serveur !"));
					    
						String date = new SimpleDateFormat("d/MMMMM/y / HH:mm:ss").format(new Date(System.currentTimeMillis()));
						 
						API_BANIP.Ban(IP, reason, sender.getName(), 0);

						API_BANIP.setping(IP, p.getPing());

				    	
				    }
				    
			
				        

						
					  
		    	
		    	
		    	
		    }


	       
		    
			
	}


}
