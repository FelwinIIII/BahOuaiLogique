package fr.WalexFelwin.OktaliaFaction.Event.Portal;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class PlayerDeath implements Listener{


	public PlayerDeath() {

	}

	@EventHandler
	public void Playerinvest(PlayerDeathEvent e) {
	
		e.setDeathMessage(null);
	
	}

}
