package fr.WalexFelwin.OktaliaAPI.BungeeCord;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.UUID;

import com.google.common.io.ByteArrayDataInput;
import com.google.common.io.ByteStreams;

import fr.WalexFelwin.OktaliaAPI.Bukkit.API.API_OktaCoins;
import fr.WalexFelwin.OktaliaAPI.BungeeCord.API.API_Coins;
import net.md_5.bungee.BungeeCord;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.config.ServerInfo;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.event.PluginMessageEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;

public class PluginMessage implements Listener{


	  public static HashMap<ProxiedPlayer, String> HubRedirect = new HashMap();
	
	@EventHandler(priority = 64)
	public void Message(PluginMessageEvent e) {

		if(e.getTag().equals("BungeeInterconnect")) {

			final ByteArrayDataInput in = ByteStreams.newDataInput(e.getData());
			final String sub = in.readUTF();

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
				HubRedirect.put(p, HubSelect);

	        	ServerInfo HUB = BungeeCord.getInstance().getServerInfo(PluginMessage.HubRedirect.get(p));
	        	p.connect(HUB);
				/*ServerInfo HUB = BungeeCord.getInstance().getServerInfo(""+HubSelect);
				
				p.connect(HUB);*/
			}
			
			
			
			

			if(sub.equals("Coins")) {

				final String player = in.readUTF(); 

				ProxiedPlayer p = ProxyServer.getInstance().getPlayer(player);
				
				final String sub2 = in.readUTF(); 

				final float coins = in.readFloat();
				
				if(p == null) {

					UUID UUID = java.util.UUID.fromString(API_Coins.getuuid(player));
					
					if(UUID == null) {
						return;
					}
					
					if(sub2.equals("ADD")) {
						
						API_Coins.addoktacoins(UUID, coins);
						System.out.println("§eCOINS §7| §aADD §7"+coins+" §aOktaCoins §ePseudo: §a"+player);
					} else if(sub2.equals("REMOVE")) {

						API_Coins.removeoktacoins(UUID, coins);
						System.out.println("§eCOINS §7| §aREMOVE §7"+coins+" §aOktaCoins §ePseudo: §a"+player);
					} else if(sub2.equals("SET")) {

						API_Coins.setoktacoins(UUID, coins);
						System.out.println("§eCOINS §7| §aSET §7"+coins+" §aOktaCoins §ePseudo: §a"+player);
					}
					return;
					
				} else {
					
			        ByteArrayOutputStream b = new ByteArrayOutputStream();
			        DataOutputStream out = new DataOutputStream(b);
					

					try {
						
						out.writeUTF("CoinsC");
						out.writeUTF(""+player);
						out.writeUTF(sub2);
						out.writeFloat(coins);
						
						
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					ServerInfo server = BungeeCord.getInstance().getServerInfo(p.getServer().getInfo().getName());
					
					server.sendData("BungeeInterconnect", b.toByteArray());
					
				}

				
			}
			
			
			if(sub.equals("Golds")) {

				final String player = in.readUTF(); 

				ProxiedPlayer p = ProxyServer.getInstance().getPlayer(player);
				
				final String sub2 = in.readUTF(); 

				final float coins = in.readFloat();
				
				if(p == null) {

					UUID UUID = java.util.UUID.fromString(API_Coins.getuuid(player));
					
					if(UUID == null) {
						return;
					}
					
					if(sub2.equals("ADD")) {
						
						API_Coins.addBoutiquecoins(UUID, coins);
						System.out.println("§eCOINS §7| §aADD §7"+coins+" §6§lGolds §ePseudo: §a"+player);
						
					} else if(sub2.equals("REMOVE")) {

						API_Coins.removeBoutiquecoins(UUID, coins);
						System.out.println("§eCOINS §7| §aREMOVE §7"+coins+" §6§lGolds §ePseudo: §a"+player);
						
					} else if(sub2.equals("SET")) {

						API_Coins.setBoutiquecoins(UUID, coins);
						System.out.println("§eCOINS §7| §aSET §7"+coins+" §6§lGolds §ePseudo: §a"+player);
					}
					return;
					
				} else {
					
			        ByteArrayOutputStream b = new ByteArrayOutputStream();
			        DataOutputStream out = new DataOutputStream(b);
					

					try {
						
						out.writeUTF("GoldsC");
						out.writeUTF(""+player);
						out.writeUTF(sub2);
						out.writeFloat(coins);
						
						
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					ServerInfo server = BungeeCord.getInstance().getServerInfo(p.getServer().getInfo().getName());
					
					server.sendData("BungeeInterconnect", b.toByteArray());
					
				}

				
			}
			
			
		}
	}
}
