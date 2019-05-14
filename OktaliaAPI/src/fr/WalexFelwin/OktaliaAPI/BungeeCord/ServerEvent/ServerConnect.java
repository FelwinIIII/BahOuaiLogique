package fr.WalexFelwin.OktaliaAPI.BungeeCord.ServerEvent;

import net.md_5.bungee.api.config.ServerInfo;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.event.ServerConnectEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;

public class ServerConnect implements Listener{

	
	@EventHandler(priority = 64)
	  public void onPlayerJoin(ServerConnectEvent event)
	  {
		  ProxiedPlayer p = event.getPlayer();
		  ServerInfo s = event.getTarget();
		  
		  
		  p.getServer().getInfo().getPlayers();
	
	  }
}
