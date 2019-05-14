package fr.WalexFelwin.OktaliaAPI.BungeeCord.ServerEvent.Join;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import fr.WalexFelwin.OktaliaAPI.BungeeCord.Main;
import fr.WalexFelwin.OktaliaAPI.BungeeCord.Utils;
import fr.WalexFelwin.OktaliaAPI.BungeeCord.API.API_BAN;
import fr.WalexFelwin.OktaliaAPI.BungeeCord.API.API_BANIP;
import fr.WalexFelwin.OktaliaAPI.BungeeCord.API.API_Login;
import fr.WalexFelwin.OktaliaAPI.BungeeCord.API.API_TEMPBAN;
import fr.WalexFelwin.OktaliaAPI.BungeeCord.ServerEvent.ServeurEnum;
import net.md_5.bungee.BungeeCord;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.config.ServerInfo;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.connection.Server;
import net.md_5.bungee.api.event.LoginEvent;
import net.md_5.bungee.api.event.PlayerDisconnectEvent;
import net.md_5.bungee.api.event.PlayerHandshakeEvent;
import net.md_5.bungee.api.event.PostLoginEvent;
import net.md_5.bungee.api.event.PreLoginEvent;
import net.md_5.bungee.api.event.ServerConnectEvent;
import net.md_5.bungee.api.event.ServerKickEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.config.Configuration;
import net.md_5.bungee.event.EventHandler;
import net.md_5.bungee.protocol.KickStringWriter;

	public class PlayerJoin implements Listener{
		

		
		@EventHandler
		public void onkick(ServerKickEvent e){
			e.getKickReasonComponent();
		}
		  
		  @SuppressWarnings("deprecation")
		@EventHandler
		  public void onlogin(PostLoginEvent e){
			  ProxiedPlayer p = e.getPlayer();

		      API_BAN.setpseudo(p.getUniqueId(), p.getName());
				String date = new SimpleDateFormat("d/MMMMM/y / HH:mm:ss").format(new Date(System.currentTimeMillis()));
			      //API_INFOPLAYER.setConnectionRécente(p, date);
			      
	
		  }
		  
		  @EventHandler
		  public void ondisco(PlayerDisconnectEvent e)
		  {
			  ProxiedPlayer p = e.getPlayer();
			  int connectplayer = BungeeCord.getInstance().getOnlineCount();
				String date = new SimpleDateFormat("d/MMMMM/y / HH:mm:ss").format(new Date(System.currentTimeMillis()));
			     // API_INFOPLAYER.setDéconnectionRécente(p, date);
					API_Login.setlogin(p, 0);
			

		  }
		
		  public Configuration getConfig()
		  {
			  return Main.yamlConfig.getConfig();
		  }

		  @EventHandler(priority=32)
		  public void onLogin(LoginEvent e)
		  {
		     
		      if(ServeurEnum.isState(ServeurEnum.MAINTENANCE)){
					 return;
				 }
		      
		      // Vérif de ban ip déf joueur
		      

				String date = new SimpleDateFormat("d/MMMMM/y / HH:mm:ss").format(new Date(System.currentTimeMillis()));
				
		      long getbanip = API_BANIP.getbandeco(e.getConnection().getAddress().getHostString());
		      if(getbanip >= 2){
		          e.setCancelled(true);
				    e.setCancelReason(Utils.prefixTitle+"\n§aVous avez été banni ip du serveur Oktalia \n"
				    		+ "\n"
				    		+ " §7(§cDurée: §aPermanent§7)  \n"
				    		+ "Raison: "+ API_BANIP.getbanreason(e.getConnection().getAddress().getHostString()));
		      
				    long getban = API_BAN.getbandeco(e.getConnection().getName());
				      if(getban >= 2){

							return;
				    	  
				    	  
				      } else {
							API_BAN.setdate(e.getConnection().getName(), date);
							API_BAN.setbanpar(e.getConnection().getName(), "Systéme Ban ip");
							API_BAN.setraison(e.getConnection().getName(), "Tentative de connection avec une ip ban-ip!");
							API_BAN.setbanTYPEDeco(e.getConnection().getName(), 10);
							
							return;
				    	  
				      }
		      }
		      
		      long getban = API_BAN.getbandeco(e.getConnection().getName());
		      if(getban >= 2){
		          e.setCancelled(true);
				    e.setCancelReason(Utils.prefixTitle+"\n§aVous avez été banni du serveur Oktalia \n"
				    		+ "\n"
				    		+ " §7(§cDurée: §aPermanent§7)  \n"
				    		+ "Raison: "+ API_BAN.getbanreason(e.getConnection().getName()));

					return;
		      }
		      
			    long istempbanip = API_BANIP.getbandeco(e.getConnection().getAddress().getHostString());
			    if (istempbanip == 2)
			    {
			      Long current = Long.valueOf(System.currentTimeMillis());
			      Long end = Long.valueOf(API_BANIP.getEnd(e.getConnection().getAddress().getHostString()));
			      if ((end.longValue() < current.longValue()))
			      {
			        e.setCancelled(false);
			        
			        API_BANIP.setbandeco(e.getConnection().getAddress().getHostString(), 1);
			      }
			      else
			      {
			        e.setCancelled(true);
			        e.setCancelReason(Utils.prefixTitle+"\n§aVous avez été banni ip temporairement du serveur Oktalia \n"
			        		+ "\n"
			        		+ " §7(§cDurée: §a"+API_TEMPBAN.getRemainingTime(e.getConnection().getAddress().getHostString())+"§7)  \n"
			        		+ "Raison: "+ API_TEMPBAN.getbanreason(e.getConnection().getAddress().getHostString()));
			        
			        long isban = API_TEMPBAN.getbandeco(e.getConnection().getName());
				    if (isban >= 2)
				    {
						return;
				    	
				    } else {
				    	
				    	long GETENDBANIP = API_BANIP.getEnd(e.getConnection().getAddress().getHostString());
				    	
				    	
				    	
				    	API_TEMPBAN.setend(e.getConnection().getName(), GETENDBANIP);
				    	API_TEMPBAN.setraison(e.getConnection().getName(), "Tentative de connection avec une ip temporairement ban-ip!");
				    	API_TEMPBAN.setdate(e.getConnection().getName(), date);
				    	API_TEMPBAN.setbanpar(e.getConnection().getName(), "Systéme de ban-ip");
				    	API_TEMPBAN.setbandeco(e.getConnection().getName(), 10);

						return;
				    }
			        
			        
			        
			      }

			     }
		      
		      
			    long isban = API_TEMPBAN.getbandeco(e.getConnection().getName());
			    if (isban >= 2)
			    {
			      Long current = Long.valueOf(System.currentTimeMillis());
			      Long end = Long.valueOf(API_TEMPBAN.getEnd(e.getConnection().getName()));
			      if ((end.longValue() < current.longValue()) && (end.longValue() != -1L))
			      {
			        e.setCancelled(false);
			        
			        API_TEMPBAN.setbandeco(e.getConnection().getName(), 1);
			      }
			      else
			      {
			        e.setCancelled(true);
			        e.setCancelReason(Utils.prefixTitle+"\n§aVous avez été banni temporairement du serveur Oktalia \n"
			        		+ "\n"
			        		+ " §7(§cDurée: §a"+API_TEMPBAN.getRemainingTime(e.getConnection().getName())+"§7)  \n"
			        		+ "Raison: "+ API_TEMPBAN.getbanreason(e.getConnection().getName()));
			      }

			    }
			    /*
			     * 
			     * INFO PLAY
			     * 
			     */
			   

			   /* try {
					
					PreparedStatement preparedStatement = Main.conn.prepareStatement("SELECT id FROM InfoPlayer WHERE UUID = ?");
					preparedStatement.setString(1, e.getConnection().getUniqueId().toString());
					
					ResultSet rs = preparedStatement.executeQuery();
					if(!rs.next()) {
						preparedStatement.close();
						preparedStatement = Main.conn.prepareStatement("INSERT INTO InfoPlayer (UUID, Pseudo, PremiéreConnection, ConnectionRécente, DéconnectionRécente, IP) VALUES (?, ?, ?, ?, ?, ?)");
						preparedStatement.setString(1, e.getConnection().getUniqueId().toString());
						preparedStatement.setString(2, e.getConnection().getName());
						preparedStatement.setString(3, date);
						preparedStatement.setString(4, date);
						preparedStatement.setString(5, "");
						preparedStatement.setString(6, e.getConnection().getAddress().getHostString());
						preparedStatement.executeUpdate();
		
						preparedStatement.close();
					}
					
					
				} catch (SQLException err) {
				      System.err.println(err);
				      err.printStackTrace();
				}*/

			    
				

		    API_Login.setip(e.getConnection().getName(), e.getConnection().getAddress().getHostString());  
		  
	
		  }
	

}
