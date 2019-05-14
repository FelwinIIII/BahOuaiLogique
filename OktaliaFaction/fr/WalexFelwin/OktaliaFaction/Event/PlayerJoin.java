package fr.WalexFelwin.OktaliaFaction.Event;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import fr.WalexFelwin.OktaliaAPI.Bukkit.API.API_Title;
import fr.WalexFelwin.OktaliaFaction.Scoreboard.Scoreboard;

public class PlayerJoin implements Listener {


	@EventHandler
	public void OnClickHotBar(PlayerJoinEvent e){ 
		
		Player p = e.getPlayer();
		
		Scoreboard.Scoreboardstart(p);
		
	    API_Title.sendTitle(p, "§f» §bOKTALIA §fNETWORK §b«", "§aServeur Faction §e!", 30);

		int joueur = Bukkit.getOnlinePlayers().size();
		   for (Player o : Bukkit.getOnlinePlayers())
		    {
			   Scoreboard.sslist.get(o).setLine(3, "§fJoueurs: §6§l"+joueur);
		    }


	    
	}
	
	@EventHandler(priority = EventPriority.HIGH)
	public void playerquitt(PlayerQuitEvent e){
		Player p = e.getPlayer();
		

		int joueur = Bukkit.getOnlinePlayers().size()-1;
		
		   for (Player o : Bukkit.getOnlinePlayers())
		    {
			   Scoreboard.sslist.get(o).setLine(3, "§fJoueurs: §6§l"+joueur);
		    }

			Scoreboard.sslist.get(p).destroy();
			Scoreboard.sslist.remove(p);
			
		   
	}
	
}