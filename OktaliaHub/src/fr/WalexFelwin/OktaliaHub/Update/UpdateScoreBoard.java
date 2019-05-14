package fr.WalexFelwin.OktaliaHub.Update;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import fr.WalexFelwin.OktaliaAPI.Bukkit.API.API_Tab;
import fr.WalexFelwin.OktaliaHub.ScoreBoard.Scoreboard;


public class UpdateScoreBoard {


	
	private static int clock2;

	  public static void clock()
	  {
	    clock2 = Bukkit.getScheduler().scheduleSyncRepeatingTask(Bukkit.getPluginManager().getPlugin("OktaliaHub"), new Runnable()
	    {
	      public void run()
	      {	
	    	  
	    	  for (Player p : Bukkit.getOnlinePlayers())
	    	    {
	    		  
	    		  Scoreboard.ScoreboardReloadCoins(p);
	      		
	    	    }
	      }
	    }, 40, 40);
	  }
}
