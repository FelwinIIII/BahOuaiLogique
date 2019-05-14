package fr.walexmine.OktaliaMinage.Event;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

import fr.walexmine.OktaliaMinage.Main;
import fr.walexmine.OktaliaMinage.API.API_Inventory;
import fr.walexmine.OktaliaMinage.API.API_Joueur;
import fr.walexmine.OktaliaMinage.API.API_Temps;
import fr.walexmine.OktaliaMinage.Inventaire.Reserve;
import fr.walexmine.OktaliaMinage.Inventaire.StatsMine.Stats;
import fr.walexmine.OktaliaMinage.ScoreBoard.Scoreboard;

public class PlayerQuitt implements Listener {
	
	public PlayerQuitt(Main main) {
		
	}

	@EventHandler
	public void PlayerQuitt(PlayerQuitEvent e) {
		
		Player p = e.getPlayer();

			
			API_Inventory.saveReserveMine(p, API_Inventory.toBase64(PlayerBreak.ReserveM.get(p)));

			long timeco = Long.parseLong(API_Temps.TIMECO.get(p));
			long timenow = System.currentTimeMillis();
			
			long timesession = timenow - timeco;
			
			API_Joueur.addTIME(p, timesession);


			int joueur = Bukkit.getOnlinePlayers().size()-1;
			   for (Player o : Bukkit.getOnlinePlayers())
			    {
				   Scoreboard.sslist.get(o).setLine(3, "§fJoueurs: §6§l"+joueur);
			    }

				Scoreboard.sslist.get(p).destroy();
				Scoreboard.sslist.remove(p);
				e.setQuitMessage(null);
				
			
			
			API_Joueur.SetEXP(p, Stats.EXP.get(p));
			API_Joueur.SetLVL(p, Stats.LEVEL.get(p));
			
			
			Stats.EXP.remove(p);
			Stats.LEVEL.remove(p);
			
			
			
	}
	

}
