package fr.WalexFelwin.OktaliaAPI.BungeeCord.SystémeModération;

import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;

import fr.WalexFelwin.OktaliaAPI.BungeeCord.Update;
import fr.WalexFelwin.OktaliaAPI.BungeeCord.Utils;
import fr.WalexFelwin.OktaliaAPI.BungeeCord.API.API_BAN;
import fr.WalexFelwin.OktaliaAPI.BungeeCord.API.API_Coins;
import fr.WalexFelwin.OktaliaAPI.BungeeCord.API.API_INFOPERM;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.connection.Connection;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class Ban extends Command {

	public Ban() {
	    super("ban", null, new String[0]);
		// TODO Auto-generated constructor stub
	}
	@SuppressWarnings("deprecation")
	@Override
	public void execute(CommandSender sender, String[] arg1) {

		String statsperm = ""+API_INFOPERM.getbanperm(sender.getName()); 
			if(statsperm.equalsIgnoreCase("TRUE")){
		    if (arg1.length < 1)
		    {
		    	sender.sendMessage(new TextComponent(Utils.prefix + ChatColor.GREEN + "/ban <joueur> <raison>§e | ban le joueur du serveur"));
		      
		    	
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
				    	sender.sendMessages((Utils.prefix +"§4Le joueur non connecté a été enregistré dans la BDD "));
				    	sender.sendMessages((Utils.prefix + ChatColor.GREEN + arg1[0] + " a été ban du serveur !"));
					    
						String date = new SimpleDateFormat("d/MMMMM/y / HH:mm:ss").format(new Date(System.currentTimeMillis()));
			
					    boolean exist = false;
					    try
					    {
					      ResultSet rs = Update.Query("SELECT `id` FROM `InfoBan` WHERE `UUID`='" + API_Coins.getuuid(arg1[0]) + "'");
					      while (rs.next()) {
							   
								API_BAN.setdate(arg1[0], date);
								API_BAN.setbanpar(arg1[0], sender.getName());
								API_BAN.setraison(arg1[0], reason);
								API_BAN.setbanTYPEDeco(arg1[0], 10);
								
					        exist = Boolean.valueOf(true).booleanValue();
					      }
					    }
					    catch (Exception err)
					    {
					      System.err.println(err);
					      err.printStackTrace();
					    }
					    if (!exist) {
					      Update.Update("INSERT INTO `InfoBan` (`UUID`, `Pseudo`, `RaisonDuBan`, `TYPE`, `Ping`, `DateDuBan`, `BanPar`) VALUES ('" + API_Coins.getuuid(arg1[0]) + "', '" + arg1[0] + "', '"+reason+"', '10', '0', '"+date+"', '"+sender.getName()+"')");
					    }
					    
				      return;
				    } else {
				    	
					    p.disconnect(Utils.prefixTitle +"\n§aVous avez été banni du serveur Oktalia \n\n §7(§cDurée: §ePermanent§7)  \nRaison: "+ reason);
					    sender.sendMessage((Utils.prefix + ChatColor.GREEN + arg1[0] + " a été ban du serveur !"));
					    
						String date = new SimpleDateFormat("d/MMMMM/y / HH:mm:ss").format(new Date(System.currentTimeMillis()));
					   
			
					    boolean exist = false;
					    try
					    {
					      ResultSet rs = Update.Query("SELECT `id` FROM `InfoBan` WHERE `UUID`='" + API_Coins.getuuid(arg1[0]) + "'");
					      while (rs.next()) {
								API_BAN.setdate(arg1[0], date);
								API_BAN.setping(arg1[0], p.getPing());
								API_BAN.setbanpar(arg1[0], sender.getName());
								API_BAN.setraison(arg1[0], reason);
								API_BAN.setbanTYPE(p, 10);
								
					        exist = Boolean.valueOf(true).booleanValue();
					      }
					    }
					    catch (Exception err)
					    {
					      System.err.println(err);
					      err.printStackTrace();
					    }
					    if (!exist) {
					      Update.Update("INSERT INTO `InfoBan` (`UUID`, `Pseudo`, `RaisonDuBan`, `TYPE`, `Ping`, `DateDuBan`, `BanPar`) VALUES ('" + p.getUniqueId() + "', '" + p.getName() + "', '"+reason+"', '10', '"+p.getPing()+"', '"+date+"', '"+sender.getName()+"')");
					    }
				    	
				    }
				    
			
				        

						
					  
		    	
		    	
		    	
		    }


	       
		    
			
	}


}
