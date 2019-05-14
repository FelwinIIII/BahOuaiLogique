package fr.WalexFelwin.OktaliaAPI.BungeeCord.ServerEvent;

import fr.WalexFelwin.OktaliaAPI.BungeeCord.Main;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.ServerPing;
import net.md_5.bungee.api.connection.PendingConnection;
import net.md_5.bungee.api.event.ProxyPingEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;

public class ServerProxy implements Listener{

	@EventHandler(priority = 64)
	public void ProxyPing(ProxyPingEvent e)
	{
	      ServerPing ping = e.getResponse();
	      PendingConnection con = e.getConnection();
	      
	      String motd = ChatColor.translateAlternateColorCodes('&', Main.getConfig().getString("Motd.normal"));
		  String motdfull = ChatColor.translateAlternateColorCodes('&', Main.getConfig().getString("Motd.full"));
		  String maintenance = ChatColor.translateAlternateColorCodes('&', Main.getConfig().getString("Motd.maintenance"));
		  
	      motd = motd.replace("{newline}", "\n");

	      motdfull = motdfull.replace("{newline}", "\n");
	      

	      
	      if (ServeurEnum.isState(ServeurEnum.MAINTENANCE)){
	    	  
	    	  ping.setDescription(maintenance);
	    	  
	      } else if(ServeurEnum.isState(ServeurEnum.FULLJOIN)){
	    	  
	    	  ping.setDescription(motdfull);
	    	  
	      } else  {
	    	  
	    	  ping.setDescription(motd);
	      }
	      
	      
	      
	   }
}
