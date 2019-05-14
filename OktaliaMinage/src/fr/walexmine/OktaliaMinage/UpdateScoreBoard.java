package fr.walexmine.OktaliaMinage;

import java.text.DecimalFormat;
import java.text.NumberFormat;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import fr.WalexFelwin.OktaliaAPI.Bukkit.API.API_Title;
import fr.walexmine.OktaliaMinage.API.API_ProgressBar;
import fr.walexmine.OktaliaMinage.Inventaire.StatsMine.Stats;
import fr.walexmine.OktaliaMinage.ScoreBoard.Scoreboard;


public class UpdateScoreBoard {


	
	private static int clock2;

	  public static void clock()
	  {
	    clock2 = Bukkit.getScheduler().scheduleSyncRepeatingTask(Bukkit.getPluginManager().getPlugin("OktaliaMine"), new Runnable()
	    {
	      public void run()
	      {	
	    	  
	    	  for (Player p : Bukkit.getOnlinePlayers())
	    	    {
	    		  
	    		  Scoreboard.ScoreboardReloadCoins(p);
	    		  
	    		  int NIVEAU = Stats.LEVEL.get(p);
	    		  int NIVEAUA = NIVEAU+1;
	    		  
	      		  int max = 0;
	      		  int expa = Stats.EXP.get(p);
	      		  
	      		  if(NIVEAU == 2) {
	      			  max += 30000;
	      			  expa -= 25000;
	      		  } else if(NIVEAU == 3) {
	      			  max += 30000;  			  
	      			  expa -= 55000;
	      		  } else if(NIVEAU == 4) {
	      			  max += 30000;
	      			  expa -= 85000;
	      		  } else if(NIVEAU == 5) {

	      		  } else {
	      			  max = 25000;
	      		  }
	      		  
	    	        float percent = (float) expa/ max;
	      		  
	  	       float progressBars = (100 * percent);

	                DecimalFormat format = new DecimalFormat("0.00");
	                
	    		  String perctforma = format.format(progressBars);
	                
	    		  API_Title.sendActionBar(p, "§7§l[§9§lNiveau "+NIVEAU+" §b➠ §9§l"+NIVEAUA+"§7§l] §8§l | §8§l[§r" + API_ProgressBar.getProgressBar(expa, max, 25, "❚", "&a", "&f")+"§8§l] §6§l"+perctforma+" §a§l%");


	    	    }
	      }
	    }, 20, 20);
	  }
}
