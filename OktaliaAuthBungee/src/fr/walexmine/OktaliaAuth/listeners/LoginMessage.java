package fr.walexmine.OktaliaAuth.listeners;


import com.google.common.io.ByteArrayDataInput;
import com.google.common.io.ByteStreams;

import fr.WalexFelwin.OktaliaAPI.BungeeCord.PluginMessage;
import fr.WalexFelwin.OktaliaAPI.BungeeCord.Utils;
import fr.walexmine.OktaliaAuth.AuthPlugin;
import fr.walexmine.OktaliaAuth.data.DataUser;
import fr.walexmine.OktaliaAuth.utils.Logger;
import net.md_5.bungee.BungeeCord;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.config.ServerInfo;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.event.PluginMessageEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;

public class LoginMessage implements Listener{


	
	@EventHandler(priority = 64)
	public void Message(PluginMessageEvent e) {

		if(e.getTag().equals("BungeeLogin")) {

			final ByteArrayDataInput in = ByteStreams.newDataInput(e.getData());
			final String sub = in.readUTF();

			if(sub.equals("isLogin")) {
				
				final String p = in.readUTF();
				
				
				final ProxiedPlayer player = ProxyServer.getInstance().getPlayer(p);

			    DataUser localDataUser = AuthPlugin.INSTANCE.getUser(player);
			    
			    localDataUser.setLogged(true);
				localDataUser.update();
		    	Logger.info(Utils.prefix+"&ePlugin Message SUB: isLogin SET: Logged:true VERIFY:"+localDataUser.isLogged());
			}
			
			if(sub.equals("Connect")) {
				
				final String servertp = in.readUTF();
				final String p = in.readUTF();
				
				
				final ProxiedPlayer player = ProxyServer.getInstance().getPlayer(p);
				
				
				ServerInfo HUB = BungeeCord.getInstance().getServerInfo(""+servertp);
				
				player.connect(HUB);
				
			}

			
			if(sub.equals("SendHub")) {
				
				
				final String player = in.readUTF(); 
				
				ProxiedPlayer p = ProxyServer.getInstance().getPlayer(player);
				
				
				final String HubSelect = in.readUTF(); 
				System.out.println(""+HubSelect);

	        	ServerInfo HUB = BungeeCord.getInstance().getServerInfo(PluginMessage.HubRedirect.get(p));
	        	p.connect(HUB);
				/*ServerInfo HUB = BungeeCord.getInstance().getServerInfo(""+HubSelect);
				
				p.connect(HUB);*/
			}
			

		}
	}
}
