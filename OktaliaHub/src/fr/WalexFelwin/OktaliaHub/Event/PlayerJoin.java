package fr.WalexFelwin.OktaliaHub.Event;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import fr.WalexFelwin.OktaliaAPI.Bukkit.API.API_Title;
import fr.WalexFelwin.OktaliaHub.Main;
import fr.WalexFelwin.OktaliaHub.API.API_HubPlayer;
import fr.WalexFelwin.OktaliaHub.ScoreBoard.Scoreboard;
import fr.WalexFelwin.OktaliaHub.Slots.SlotsJoueur;

public class PlayerJoin implements Listener{

	public PlayerJoin(Main main) {
		
	}
	
	@EventHandler
	public void OnClickHotBar(PlayerJoinEvent e){ 
		
		Player p = e.getPlayer();
		
		Location loc = new Location(Bukkit.getWorld("world"), -74.5, 78.5, -222.5);
		
		p.setGameMode(GameMode.ADVENTURE);
		p.teleport(loc);
		
		
		
		SlotsJoueur.Item(p);
		
		Scoreboard.Scoreboardstart(p);
		API_HubPlayer.playergradesadd(p);
		
	    API_Title.sendTitle(p, "§f» §bOKTALIA §fNETWORK §b«", "§fUn serveur qui sort de l'ordinaire §b!", 60);

		int joueur = Bukkit.getOnlinePlayers().size();
		   for (Player o : Bukkit.getOnlinePlayers())
		    {
			   Scoreboard.sslist.get(o).setLine(3, "§fJoueurs: §6§l"+joueur);
		    }

	    
	    if(p.isOp()) {
	    	p.setAllowFlight(true);
	    	p.setFlying(true);
	    }
	    
	    
	}
}
