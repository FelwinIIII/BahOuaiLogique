package fr.walexmine.oktaliaclasse.Event;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import fr.walexmine.oktaliaclasse.PRESTIGE;
import fr.walexmine.oktaliaclasse.Main;
import fr.walexmine.oktaliaclasse.API.API_Classe;

public class PlayerJQ implements Listener{

	  
	  public PlayerJQ(Main main) {
		// TODO Auto-generated constructor stub
	}

		@EventHandler
		  public void PlayerJoin(PlayerJoinEvent e)
		  {
			Player p = e.getPlayer();
			
			
			API_Classe.CreateProfil(p);

			  
			PRESTIGE.EXP.put(p, API_Classe.getEXP(p));
			PRESTIGE.LEVEL.put(p, API_Classe.getlevel(p));
			
			  p.sendMessage(p.getName()+" "+API_Classe.getEXP(p)+" EXP");
			
		  }
		
		
		@EventHandler
		  public void PlayerQuitt(PlayerQuitEvent e)
		  {
			Player p = e.getPlayer();
			
			API_Classe.SetEXP(p, PRESTIGE.EXP.get(p));
			API_Classe.SetLVL(p, PRESTIGE.LEVEL.get(p));

			
		  }
}
