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
				
				return;
				
			}
			
			long timea = 0;
			
				
				// DANS LA ZONE AU MOMENT DE LA DECONNECTION §
				
				long Timeadd = 0;
				
				if(PlayerMove.TimeStart.containsKey(p)) {

				//	if(System.currentTimeMillis() > Long.parseLong(PlayerMove.TimeStart.get(p))){

						Timeadd = System.currentTimeMillis() - Long.parseLong(PlayerMove.TimeStart.get(p));
						
				/*	} else {
						
						Timeadd = Long.parseLong(PlayerMove.TimeStart.get(p))-System.currentTimeMillis() ;		
						
					}*/
					
				}
				

			if(PlayerMove.TimetoSave.containsKey(p)) {
				
				// SI IL A PLUSIEUR SAUVEGARDE A PRENDRE EN COMPTE
				
				long timeh = Long.parseLong(PlayerMove.TimetoSave.get(p));
				
				timea = timeh + Timeadd;
				
				PlayerMove.TimetoSave.put(p, ""+timea);

				PlayerMove.TimeStart.remove(p);

				API_Invest.setTempsRestant(p, timea);
			} else {
				
				// 1 SAVE
				
				PlayerMove.TimetoSave.put(p, ""+Timeadd);
				
				PlayerMove.TimeStart.remove(p);
				
				
				API_Invest.setTempsRestant(p, Timeadd);
			}

			API_Invest.setInvest(p, PlayerMove.Invest.get(p));
			API_Invest.setTemps(p, Long.parseLong(PlayerMove.TimeEND.get(p)));
			PlayerMove.Investzone.remove(p);
			System.out.println("SAVE "+p.getName());
		

			

		PlayerMove.GetInfo.remove(p);
	
		}	
	}
}
