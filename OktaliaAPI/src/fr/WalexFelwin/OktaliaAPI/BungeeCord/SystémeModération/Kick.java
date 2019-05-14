package fr.WalexFelwin.OktaliaAPI.BungeeCord.SystémeModération;

import fr.WalexFelwin.OktaliaAPI.BungeeCord.Utils;
import fr.WalexFelwin.OktaliaAPI.BungeeCord.API.API_INFOPERM;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class Kick extends Command {

	public Kick() {
	    super("kick", null, new String[0]);
		// TODO Auto-generated constructor stub
	}

	@SuppressWarnings("deprecation")
	@Override
	public void execute(CommandSender sender, String[] arg1) {

		String statsperm = ""+API_INFOPERM.getkickperm(sender.getName()); 
		if(statsperm.equalsIgnoreCase("TRUE")){
	    if (arg1.length == 0)
	    {
	    	sender.sendMessage(new TextComponent(Utils.prefix+ChatColor.GREEN + "/kick <joueur> <raison>§e | kické le joueur du serveur"));
	      return;
	    }
		//////////////////////////////////////////////////////////////
		ProxiedPlayer p = ProxyServer.getInstance().getPlayer(arg1[0]);
		
	    if (p == null)
	    {
	      sender.sendMessage(new TextComponent(ChatColor.RED + "Le joueurs n'est pas connectée! " + arg1[0] + "."));
	      return;
	    }
	    
	    if (p.hasPermission("admin")){
	    	sender.sendMessage(new TextComponent("§4 Tu ne peut pas kick un membre du staff"));
	    } else {
	    	
	        String reason = "";
	        for (int i = 1; i < arg1.length; i++) {
	          reason = (reason == "" ? "" : new StringBuilder(String.valueOf(reason)).append(" ").toString()) + arg1[i];
	        }
	        
		    p.disconnect(Utils.prefixTitle+"\n§aVous venez de vous faire kick du serveur \n \n Raison: "+ reason);
		    sender.sendMessage(new TextComponent(Utils.prefix+ChatColor.GREEN + arg1[0] + " a été kick du serveur !"));
	      
	      }
		} else {
			
		}
	
	}

}
