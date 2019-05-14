package fr.walexmine.OktaliaMinage.Event;

import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.Inventory;

import fr.WalexFelwin.OktaliaAPI.Bukkit.API.API_Title;
import fr.walexmine.OktaliaMinage.Main;
import fr.walexmine.OktaliaMinage.API.API_Inventory;
import fr.walexmine.OktaliaMinage.API.API_Joueur;
import fr.walexmine.OktaliaMinage.API.API_Temps;
import fr.walexmine.OktaliaMinage.Inventaire.Minage;
import fr.walexmine.OktaliaMinage.Inventaire.StatsMine.Stats;
import fr.walexmine.OktaliaMinage.ScoreBoard.Scoreboard;

public class PlayerJoin implements Listener{
	
	public PlayerJoin(Main main) {
		
	}


	@EventHandler
	public void playerjoin (PlayerJoinEvent e) {
		
		Player p = e.getPlayer();
		
		API_Inventory.CreateProfil(p);
		API_Joueur.CreateProfil(p);
		
		Minage.itemSpawn(p);

		Stats.EXP.put(p, API_Joueur.getEXP(p));
		Stats.LEVEL.put(p, API_Joueur.getlevel(p));
		API_Temps.TIMECO.put(p, ""+System.currentTimeMillis());
		API_Temps.TIME.put(p, ""+API_Joueur.getTIME(p));
		
		
		String invinit = API_Inventory.getReserveMine(""+p.getUniqueId());
		Inventory inv = null;
		try {
			inv = API_Inventory.fromBase64(invinit);
		} catch (IOException e1) {
			
			e1.printStackTrace();
		}
		
		if(inv != null) {
			
			Inventory inv2 = Bukkit.createInventory(null, 36, "§eReserve Minage");
			inv2.setContents(inv.getContents());
				PlayerBreak.ReserveM.put(p, inv2);
	
		}
	
	    API_Title.sendTitle(p, "§f» §bOKTALIA §fNETWORK §6«", "§eServeur Minage §7§l| §9Niveau "+Stats.LEVEL.get(p), 50);

	    Scoreboard.Scoreboardstart(p);
	    
		int joueur = Bukkit.getOnlinePlayers().size();
		   for (Player o : Bukkit.getOnlinePlayers())
		    {
			   Scoreboard.sslist.get(o).setLine(3, "§fJoueurs: §6§l"+joueur);
		    }
	}
	

}
