package fr.WalexFelwin.OktaliaAPI.Bukkit;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import fr.WalexFelwin.OktaliaAPI.Bukkit.API.API_Tab;


public class UpdateTab {

	public static String tabhaut = 
			"§f§m-----§7§m-------§8§m--------§7§m-------§f§m-----"
	    		
	        + "\n§u§l§oOKTALIA NETWORK"
	    	+ "\n";
	
	public static String tabbas = 
			"\n"
	    	+ "§b/discord§b,§e https://oktalia.fr"
	    			  
	        + "\n§f§m-----§7§m-------§8§m--------§7§m-------§f§m-----";
	
	private static int clock2;

	  public static void clock()
	  {
	    clock2 = Bukkit.getScheduler().scheduleSyncRepeatingTask(Bukkit.getPluginManager().getPlugin("OktaliaAPI"), new Runnable()
	    {
	      public void run()
	      {	
	    	  
	    	  for (final Player p : Bukkit.getOnlinePlayers())
	    	    {

	          	    API_Tab.setPlayerList(p, tabhaut.replace("§u§l§oOKTALIA NETWORK", "§b§lOKTALIA §f§lNETWORK"), tabbas);
	          	    
	    		    	
	      			Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Bukkit.getPluginManager().getPlugin("OktaliaAPI"), new Runnable() {
	    	              public void run() {

	    		          	    API_Tab.setPlayerList(p, tabhaut.replace("§u§l§oOKTALIA NETWORK", "§f§lOKTALIA §b§lNETWORK"), tabbas);
	    	              }
	    	      }, 10);
	      		
	    	    }
	      }
	    }, 20, 20);
	  }
}
