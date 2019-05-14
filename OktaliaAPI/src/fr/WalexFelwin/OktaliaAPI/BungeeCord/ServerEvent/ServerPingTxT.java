package fr.WalexFelwin.OktaliaAPI.BungeeCord.ServerEvent;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.net.InetSocketAddress;
import java.util.ArrayList;
import java.util.List;

import org.fusesource.jansi.internal.Kernel32.INPUT_RECORD;

import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.ServerPing;
import net.md_5.bungee.api.ServerPing.PlayerInfo;
import net.md_5.bungee.api.ServerPing.Players;
import net.md_5.bungee.api.connection.PendingConnection;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.event.ProxyPingEvent;
import net.md_5.bungee.api.event.ServerSwitchEvent;
import net.md_5.bungee.api.plugin.Command;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.api.plugin.PluginManager;
import net.md_5.bungee.event.EventHandler;

public class ServerPingTxT implements Listener{
	
	 public List<String> input = new ArrayList();
	 
	
	  public static ServerPing handleServerPing(ServerPing ping, List<String> lines)
	  {
	    if (lines.size() == 0)
	    {
	    	
	      ping.getPlayers().setSample(null);
	      return ping;
	      
	    }
	    ServerPing.PlayerInfo[] players = new ServerPing.PlayerInfo[lines.size()];
	    
	    for (int i = 0; i < players.length; i++) {
	    	
	      players[i] = new ServerPing.PlayerInfo((String)lines.get(i), "");
	      
	    }
	    
	    
	    ping.getPlayers().setSample(players);
	    
	    lines.remove(1);
	    return ping;
	  }
	  
	  
	  @EventHandler
	  public void Ping(ProxyPingEvent e){
		  ServerPing ping = e.getResponse();
	      PendingConnection con = e.getConnection();
	      
	    //  input.add("Test");
	      
	     
	      
	  }

}
