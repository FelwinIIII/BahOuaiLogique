package fr.WalexFelwin.OktaliaFaction.Scoreboard;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;


public class UpdateScoreboard {


	
	private static int clock2;

	  public static void clock()
	  {
	    clock2 = Bukkit.getScheduler().scheduleSyncRepeatingTask(Bukkit.getPluginManager().getPlugin("OktaliaFaction"), new Runnable()
	    {
	      public void run()
	      {	
	    	  
	    	  for (Player p : Bukkit.getOnlinePlayers())
	    	    {
	    		  
	    		  Scoreboard.ScoreboardReload(p);
	      		
	    	    }
	      }
	    }, 40, 40);
	  }
}
