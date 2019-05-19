package fr.walexmine.OktaliaInvest.Event;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

import fr.walexmine.OktaliaInvest.Main;
import fr.walexmine.OktaliaInvest.API.API_Invest;

public class PlayerQuitt  implements Listener{


	
	public PlayerQuitt(Main main) {
		// TODO Auto-generated constructor stub
	}

	@EventHandler
	public void Playerquitt(PlayerQuitEvent e) {
		
		Player p = e.getPlayer();

		
		
		if(PlayerMove.GetInfo.containsKey(p)) {


			if(PlayerMove.Invest.get(p).equalsIgnoreCase("NULL")) {
				
				// PAS D'INVEST A SAVE
				API_Invest.setTemps(p, Long.parseLong(PlayerMove.Timeleft.get(p)));
				return;
				
			}

				
			API_Invest.setInvest(p, PlayerMove.Invest.get(p));
			API_Invest.setTemps(p, Long.parseLong(PlayerMove.Timeleft.get(p)));
			PlayerMove.Investzone.remove(p);
			System.out.println("SAVE "+p.getName());
		

			

			PlayerMove.GetInfo.remove(p);

		}	
	}
}
