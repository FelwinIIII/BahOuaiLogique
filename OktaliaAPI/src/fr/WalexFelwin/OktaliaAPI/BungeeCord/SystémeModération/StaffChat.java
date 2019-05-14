package fr.WalexFelwin.OktaliaAPI.BungeeCord.SystémeModération;

import org.apache.logging.log4j.core.net.Priority;

import fr.WalexFelwin.OktaliaAPI.BungeeCord.API.API_INFOPERM;
import net.md_5.bungee.BungeeCord;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.event.ChatEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;
import net.md_5.bungee.event.EventPriority;

public class StaffChat implements Listener{

	
	  @EventHandler(priority = EventPriority.HIGHEST)
	public void onPlayerChat(ChatEvent e) {
		if(!(e.getSender() instanceof ProxiedPlayer)) {
			return;
		}

		ProxiedPlayer player = (ProxiedPlayer) e.getSender();

		String statsperm = ""+API_INFOPERM.getCHATSTAFFperm(player.getName()); 
		if(statsperm.equalsIgnoreCase("TRUE")){
			if(e.getMessage().startsWith("%")) {
				
				for (ProxiedPlayer all : BungeeCord.getInstance().getPlayers()) {

					String perm = ""+API_INFOPERM.getCHATSTAFFperm(all.getName()); 
					if(perm.equalsIgnoreCase("TRUE")){

						all.sendMessage(("§a(StaffChat) §e"+player.getName()+":§7 " + e.getMessage().replace("%", "")));
							e.setCancelled(true);
							e.setMessage(null);
						
					}
				}
				
				
			}
		}
	}

}

