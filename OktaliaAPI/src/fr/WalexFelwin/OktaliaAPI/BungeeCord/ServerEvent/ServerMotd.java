package fr.WalexFelwin.OktaliaAPI.BungeeCord.ServerEvent;

import org.omg.CORBA.RepositoryIdHelper;

import fr.WalexFelwin.OktaliaAPI.BungeeCord.HASHMAP;
import fr.WalexFelwin.OktaliaAPI.BungeeCord.Main;
import fr.WalexFelwin.OktaliaAPI.BungeeCord.CMD.Server.Slots;
import net.md_5.bungee.BungeeCord;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.ServerPing;
import net.md_5.bungee.api.connection.PendingConnection;
import net.md_5.bungee.api.event.ProxyPingEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.api.plugin.Plugin;
import net.md_5.bungee.event.EventHandler;

public class ServerMotd implements Listener{
	
	
	  private static ServerPing.Protocol version;
	  private String name;
	
	  public static void setVersion(ServerPing response)
	  {

	    if (ServeurEnum.isState(ServeurEnum.MAINTENANCE)) {
	    	
		      version = response.getVersion();
		      version.setName("§c✖  Maintenance ✖");
		      version.setProtocol(999);
		      
		      
		      response.setVersion(version);
		    
	    	}
	    
	    
	    }
	
	@EventHandler(priority = 64)
	public void ProxyPing(ProxyPingEvent e)
	{
	      ServerPing ping = e.getResponse();
	      PendingConnection con = e.getConnection();
			 
			 int connectplayer = BungeeCord.getInstance().getPlayers().size();

		      
		      if (connectplayer >= Slots.slots){
				 
				 
		    	  
		    		PlayerJoinFullEvent.Join = true;
		    		HASHMAP.StatsMotd.remove("full");
		    		HASHMAP.StatsMotd.put("full", "true");
				 
			 } else {
				 
			    		PlayerJoinFullEvent.Join = false;
			    		HASHMAP.StatsMotd.remove("full");
			    		HASHMAP.StatsMotd.put("full", "false");
					 
			 }
	      
	      String motd = ChatColor.translateAlternateColorCodes('&', Main.getConfig().getString("Motd.normal"));
	      String motdfull = ChatColor.translateAlternateColorCodes('&', Main.getConfig().getString("Motd.full"));
		  String maintenance = ChatColor.translateAlternateColorCodes('&', Main.getConfig().getString("Motd.maintenance"));
		  
	      motd = motd.replace("{newline}", "\n");

	      motdfull = motdfull.replace("{newline}", "\n");
	      String at = ""+PlayerJoinFullEvent.Join; 
	      if(ServeurEnum.getState() == ServeurEnum.MAINTENANCE){
	    	  ping.setDescription(maintenance);
		      setVersion(e.getResponse());	
		      return;
	      }else if(HASHMAP.StatsMotd.get("full").equalsIgnoreCase("true")){
	    	  
	    	  ping.setDescription(motdfull);
	          
	      
	      } else {
	    	  
	      ping.setDescription(motd);
	      
	      }
	   
	      
	      ServeurVersion.setoldversion(e.getResponse());
	      
	      
	   }

}
