package fr.walexmine.OktaliaMinage.ScoreBoard;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import fr.WalexFelwin.OktaliaAPI.Bukkit.API.API_Scoreboard;
import fr.WalexFelwin.OktaliaAPI.Bukkit.Utils.COINS;
import fr.WalexFelwin.OktaliaAPI.Bukkit.Utils.HASHMAP;
import fr.WalexFelwin.OktaliaGrades.Chat_Tab.ChatUtils;
import fr.walexmine.OktaliaMinage.Inventaire.StatsMine.Stats;

public class Scoreboard {

	public static Map<Player, API_Scoreboard> sslist = new HashMap<Player, API_Scoreboard>();

	public static void ScoreboardReloadCoins(Player p){
		
		
		if(sslist.get(p).getLine(8).contains("§aExpériences: loading !")) {
			return;
		} else {

			String getscoreboardexp = sslist.get(p).getLine(8).replace("§aExpériences: §e", "");
			String getscoreboardniv = sslist.get(p).getLine(10).replace("§9Niveau: §b", "");

			float exp = Float.parseFloat(getscoreboardexp);
			float niv = Float.parseFloat(getscoreboardniv.substring(0, 1));
			
		
		
		if(exp != Stats.EXP.get(p)) {

			
			Scoreboard.sslist.get(p).setLine(8, "§aExpériences: §e"+Stats.EXP.get(p));
      		
		}		
  		  int NIVEAU = Stats.LEVEL.get(p);
		  
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
  		Scoreboard.sslist.get(p).setLine(10, "§9Niveau: §b"+Stats.LEVEL.get(p)+" §e| §6"+perctforma+" §a§l%");
      		
		}
		
	}
	
	public static void Scoreboardstart(final Player p){
		
		
		final API_Scoreboard sb = new API_Scoreboard(p, "ScoreBoard1");
		
		sb.create();
		sb.setObjectiveName(" §b§lOKTALIA §f§lNETWORK ");
		
		sb.setLine(11, "§9");
		sb.setLine(10, "§9Niveau: §bloading !");
		sb.setLine(9, "§§");    	
		sb.setLine(8, "§aExpériences: loading !");    		    	
		Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Bukkit.getPluginManager().getPlugin("OktaliaMine"), new Runnable() {
              public void run() {
	    		  
	    		  int NIVEAU = Stats.LEVEL.get(p);
	    		  
	    		  int max = 25000;
	    		  
	    		  if(NIVEAU == 2) {
	    			  max += 30000;
	    		  } else if(NIVEAU == 3) {
	    			  max += 60000;
	    		  } else if(NIVEAU == 4) {
	    			  max += 90000;
	    		  } else if(NIVEAU == 5) {
	    			  max += 120000;
	    		  }
	    		  
	  	        float percent = (float) Stats.EXP.get(p) / max;

	  	       float progressBars = (100 * percent);

	                DecimalFormat format = new DecimalFormat("0.00");
	                
	    		  String perctforma = format.format(progressBars);
            		sb.setLine(10, "§9Niveau: §b"+Stats.LEVEL.get(p)+" §e| §6"+perctforma+" §a§l%");
              		sb.setLine(8, "§aExpériences: §e"+Stats.EXP.get(p));
              }
      }, 20);
		sb.setLine(7, "§§§§   ");
		sb.setLine(6, "§fGrade: §7"+ChatUtils.getpreffix(p));
		sb.setLine(5, "§§   ");
		sb.setLine(4, "§fServeur: §a"+Bukkit.getServerName());
		sb.setLine(3, "§fJoueurs: §6§l"+Bukkit.getOnlinePlayers().size());
		sb.setLine(2, "§c   ");
		sb.setLine(1, "§6play.oktalia.fr");
		
		sslist.put(p, sb); 
	}

}
