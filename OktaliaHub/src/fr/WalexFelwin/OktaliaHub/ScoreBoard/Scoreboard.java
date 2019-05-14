package fr.WalexFelwin.OktaliaHub.ScoreBoard;

import java.util.HashMap;
import java.util.Map;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import fr.WalexFelwin.OktaliaAPI.Bukkit.API.API_Scoreboard;
import fr.WalexFelwin.OktaliaAPI.Bukkit.Utils.COINS;
import fr.WalexFelwin.OktaliaAPI.Bukkit.Utils.HASHMAP;
import fr.WalexFelwin.OktaliaGrades.Chat_Tab.ChatUtils;

public class Scoreboard {

	public static Map<Player, API_Scoreboard> sslist = new HashMap<Player, API_Scoreboard>();

	public static void ScoreboardReloadCoins(Player p){
		
		
		if(sslist.get(p).getLine(8).contains("§aOktaCoins: loading !")) {
			return;
		} else {

			String getscoreboardcoins = sslist.get(p).getLine(8).replace("§aOktaCoins: §e", "").replace(" $", "");
			String getscoreboardgolds = sslist.get(p).getLine(9).replace("§6§lGolds: §b", "");

			float coins = Float.parseFloat(getscoreboardcoins);
			float golds = Float.parseFloat(getscoreboardgolds);
		
		
		
		if(coins != COINS.getoktacoins(p)) {

			
			Scoreboard.sslist.get(p).setLine(8, "§aOktaCoins: §e"+COINS.getoktacoins(p)+" $");
      		
		}		
		if(golds != COINS.getBoutiquecoins(p)) {

			
			Scoreboard.sslist.get(p).setLine(9, "§6§lGolds: §b"+COINS.getBoutiquecoins(p)+"");
      		
		}
		}
		
	}
	
	public static void Scoreboardstart(final Player p){
		
		
		final API_Scoreboard sb = new API_Scoreboard(p, "ScoreBoard1");
		sb.create();
		sb.setObjectiveName(" §b§lOKTALIA §f§lNETWORK ");

		sb.setLine(10, "§9");
		sb.setLine(9, "§6§lGolds: loading !");    	
		sb.setLine(8, "§aOktaCoins: loading !");    		    	
		Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Bukkit.getPluginManager().getPlugin("OktaliaHub"), new Runnable() {
              public void run() {

            		sb.setLine(9, "§6§lGolds: §b"+COINS.getBoutiquecoins(p)+"");
              		sb.setLine(8, "§aOktaCoins: §e"+COINS.getoktacoins(p)+" $");
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
