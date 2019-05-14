package fr.WalexFelwin.OktaliaAPI.BungeeCord.ServerEvent;

import net.md_5.bungee.api.ServerPing;
import net.md_5.bungee.api.plugin.Listener;

public class ServeurVersion implements Listener{
	
	  private static ServerPing.Protocol version;
	  private String name;
	  
	  public static void setoldversion(ServerPing response)
	  {
		  
	    if (response != null)
	    {
	      version = response.getVersion();
	      version.setName("Otkalia 1.8-1.13");
	//      version.setProtocol(999);
	    
	      
	      response.setVersion(version);
	    }
	    
	  }

}
