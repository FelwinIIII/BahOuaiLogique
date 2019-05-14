package fr.WalexFelwin.OktaliaAPI.BungeeCord.SystémeModération;

import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;

import fr.WalexFelwin.OktaliaAPI.BungeeCord.Update;
import fr.WalexFelwin.OktaliaAPI.BungeeCord.Utils;
import fr.WalexFelwin.OktaliaAPI.BungeeCord.API.API_INFOPERM;
import fr.WalexFelwin.OktaliaAPI.BungeeCord.API.API_MUTE;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.connection.Connection;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class Mute extends Command {

	public Mute() {
	    super("mute", null, new String[0]);
		// TODO Auto-generated constructor stub
	}
	@SuppressWarnings("deprecation")
	@Override
	public void execute(CommandSender sender, String[] arg1) {
		
		String Sendercmd = ""+sender.getName();
		String statsperm = ""+API_INFOPERM.getmuteperm(Sendercmd); 
			if(statsperm.equalsIgnoreCase("TRUE")){
			
		    if (arg1.length < 2)
		    {
		    	sender.sendMessage(new TextComponent(Utils.prefix + ChatColor.GREEN + "/mute <joueur> <raison>§e | mute le joueur du serveur"));
		      return;
		    }
		    
	        String reason = "";
	        for (int i = 1; i < arg1.length; i++) {
	          reason = (reason == "" ? "" : new StringBuilder(String.valueOf(reason)).append(" ").toString()) + arg1[i];
	        }
			// 
			ProxiedPlayer p = ProxyServer.getInstance().getPlayer(arg1[0]);
			
		    if (p == null)
		    {
		    	sender.sendMessages((Utils.prefix +"§4Le joueur non connecté a été enregistré dans la BDD "));
		    	sender.sendMessages((Utils.prefix + ChatColor.GREEN + arg1[0] + " a été mute sur le serveur !"));
			    
				String date = new SimpleDateFormat("d/MMMMM/y / HH:mm:ss").format(new Date(System.currentTimeMillis()));
			   
				API_MUTE.setdate(arg1[0], date);
				API_MUTE.setmutepar(arg1[0], sender.getName());
				API_MUTE.setraison(arg1[0], reason);
				API_MUTE.setmutedeco(arg1[0], 10);
		      return;
		    } else {
		    	
			    p.sendMessage(Utils.prefix +" §cVous avez été mute sur le serveur §7(§cDurée: §ePermanent§7) Raison: "+ reason);
			    sender.sendMessage((Utils.prefix + ChatColor.GREEN + arg1[0] + " a été mute sur le serveur !"));
			    
				String date = new SimpleDateFormat("d/MMMMM/y / HH:mm:ss").format(new Date(System.currentTimeMillis()));
			   
				
			    boolean exist3 = false;
			    try
			    {
			      ResultSet rs = Update.Query("SELECT `id` FROM `InfoMute` WHERE `UUID`='" + p.getUniqueId() + "'");
		
			      while (rs.next()) {
			        exist3 = Boolean.valueOf(true).booleanValue();
					API_MUTE.setdate(arg1[0], date);
					API_MUTE.setping(arg1[0], p.getPing());
					API_MUTE.setmutepar(arg1[0], sender.getName());
					API_MUTE.setraison(arg1[0], reason);
					API_MUTE.setmute(p, 10);
			      }
			    }
			    catch (Exception err)
			    {
			      System.err.println(err);
			      err.printStackTrace();
			    }
			    if (!exist3) {
			     Update.Update("INSERT INTO `InfoMute` (`UUID`, `Pseudo`, `RaisonDuMute`, `DateDuMute`, `MutePar`, `TRUE/FALSE`) VALUES ('" + p.getUniqueId() + "', '" + p.getName() + "', '"+reason+"', '"+date+"', '"+sender.getName()+"', '10')");
			    }
			    
			    

		    	
		    }
		    
	
		        

				
			  }

			
	}

}

