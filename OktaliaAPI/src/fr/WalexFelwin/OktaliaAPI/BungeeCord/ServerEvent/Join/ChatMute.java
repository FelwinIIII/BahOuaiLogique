package fr.WalexFelwin.OktaliaAPI.BungeeCord.ServerEvent.Join;

import fr.WalexFelwin.OktaliaAPI.BungeeCord.Utils;
import fr.WalexFelwin.OktaliaAPI.BungeeCord.API.API_MUTE;
import fr.WalexFelwin.OktaliaAPI.BungeeCord.API.API_TEMPMUTE;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.event.ChatEvent;
import net.md_5.bungee.event.EventHandler;
import net.md_5.bungee.event.EventPriority;

public class ChatMute implements net.md_5.bungee.api.plugin.Listener{
	
	@EventHandler(priority=64)
	public void chat(ChatEvent e){ 
		ProxiedPlayer p = (ProxiedPlayer)e.getSender();
		
		if(e.getMessage().startsWith("/")){
			return;
		}
		
		long ap = API_MUTE.getmutedeco(p.getName());
	    if (ap >= 2)
	    {
	        e.setCancelled(true);
	    	p.sendMessage(Utils.prefix +"§cVous avez été mute sur le serveur §7(§cDurée: §ePermanent§7) Raison: "+ API_MUTE.getmutereason(p.getName()));
	    }
	    else
	    {
	        e.setCancelled(false);
	        
	   	}
	    long isban2 = API_TEMPMUTE.getmutedeco(p.getName());
	    if (isban2 >= 2)
	    {
	      Long current = Long.valueOf(System.currentTimeMillis());
	      Long end = Long.valueOf(API_TEMPMUTE.getEnd(p.getName()));
	      if ((end.longValue() < current.longValue()) && (end.longValue() != -1L))
	      {
	        e.setCancelled(false);  
	        
	        API_TEMPMUTE.setmutedeco(p.getName(), 1);
	      }
	      else
	      {
	        e.setCancelled(true);
	        p.sendMessage(Utils.prefix +"§cVous avez été mute sur le serveur §7(§cDurée: §e"+API_TEMPMUTE.getRemainingTime(p.getName())+"§7) Raison: "+ API_TEMPMUTE.getmutereason(p.getName()));
	      }
	    }
		
		
	}

}
