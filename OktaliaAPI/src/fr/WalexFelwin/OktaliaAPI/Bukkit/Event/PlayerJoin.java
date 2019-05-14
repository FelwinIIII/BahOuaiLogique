package fr.WalexFelwin.OktaliaAPI.Bukkit.Event;

import java.sql.ResultSet;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import fr.WalexFelwin.OktaliaAPI.Bukkit.Main;
import fr.WalexFelwin.OktaliaAPI.Bukkit.Update;
import fr.WalexFelwin.OktaliaAPI.Bukkit.UpdateTab;
import fr.WalexFelwin.OktaliaAPI.Bukkit.API.API_OktaCoins;
import fr.WalexFelwin.OktaliaAPI.Bukkit.API.API_Tab;
import fr.WalexFelwin.OktaliaAPI.Bukkit.Utils.COINS;
import fr.WalexFelwin.OktaliaAPI.Bukkit.Utils.HASHMAP;


public class PlayerJoin implements Listener{
	
	
	public PlayerJoin(Main main) {
		// TODO Auto-generated constructor stub
	}

	@EventHandler(priority = EventPriority.HIGHEST)
	public static void Playerj(PlayerJoinEvent e) {
		Player p = e.getPlayer();
		
		RegisterCoins(p);
		
		
	}
	
	

	@EventHandler(priority = EventPriority.LOWEST)
	public static void Playerload(PlayerJoinEvent e) {

		final Player p = e.getPlayer();
		

		if(Main.COINSLOAD == false) {
		
			return;
		}
	    API_Tab.setPlayerList(p, UpdateTab.tabhaut
		    	  , UpdateTab.tabbas);
		System.out.print(p.getName()+" COINS LOADING ...");
		Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Bukkit.getPluginManager().getPlugin("OktaliaAPI"), new Runnable() {
            public void run() {
        		COINS.setoktacoins(p, API_OktaCoins.getoktacoins(p));
        		COINS.setBoutiquecoins(p, API_OktaCoins.getBoutiquecoins(p));

        		System.out.print(p.getName()+" JOIN WITH COINS : "+API_OktaCoins.getoktacoins(p)+" GOLDS : "+API_OktaCoins.getBoutiquecoins(p));
            }
    }, 13);
		
	}
	@EventHandler(priority = EventPriority.HIGHEST)
	public static void playerq(PlayerQuitEvent e) {
		
		Player p = e.getPlayer();


		if(Main.COINSLOAD == false) {
		
			return;
		}
		

		API_OktaCoins.setoktacoins(p, COINS.getoktacoins(p));
		API_OktaCoins.setBoutiquecoins(p, COINS.getBoutiquecoins(p));

		System.out.print(p.getName()+" LEAVE SQL WITH COINS : "+API_OktaCoins.getoktacoins(p)+" GOLDS : "+API_OktaCoins.getBoutiquecoins(p));
		System.out.print(p.getName()+" LEAVE CASH WITH COINS : "+COINS.getoktacoins(p)+" GOLDS : "+COINS.getBoutiquecoins(p));
		
		HASHMAP.Coins.remove(p);
		HASHMAP.CoinsBoutique.remove(p);
	}
	
	public static void RegisterCoins(Player p ) {
	    boolean exist = false;
	    try
	    {
	      ResultSet rs = Update.Query("SELECT `id` FROM `InfoOktaCoins` WHERE `UUID`='" + p.getUniqueId() + "'");
	      while (rs.next()) {
	    	  
	        exist = Boolean.valueOf(true).booleanValue();
	      }
	    }
	    catch (Exception err)
	    {
	      System.err.println(err);
	      err.printStackTrace();
	    }
	    if (!exist) {
	      Update.Update("INSERT INTO `InfoOktaCoins` (`UUID`, `Pseudo`, `OktaCoins`, `BoutiqueCoins`) VALUES ('" + p.getUniqueId()+ "', '" + p.getName() + "', '0', '0')");
	    }
	}
}
