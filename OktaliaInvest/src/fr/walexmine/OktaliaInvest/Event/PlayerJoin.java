package fr.walexmine.OktaliaInvest.Event;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import fr.walexmine.OktaliaInvest.Main;
import fr.walexmine.OktaliaInvest.API.API_Invest;

public class PlayerJoin implements Listener{


	
	public PlayerJoin(Main main) {
		// TODO Auto-generated constructor stub
	}

	@EventHandler
	public void Playerj(PlayerJoinEvent e) {
		
		Player p = e.getPlayer();
		
		API_Invest.Register(p);

		PlayerMove.Investzone.put(p, false);
		if(PlayerMove.Investzone.get(p)) {
			
			
			
			
		}
		
		
	}

}
