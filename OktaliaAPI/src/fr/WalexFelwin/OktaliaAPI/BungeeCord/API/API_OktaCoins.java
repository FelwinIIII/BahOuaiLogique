package fr.WalexFelwin.OktaliaAPI.BungeeCord.API;

import java.sql.ResultSet;


import fr.WalexFelwin.OktaliaAPI.Bukkit.Update;
import net.md_5.bungee.api.connection.ProxiedPlayer;


public class API_OktaCoins {
	
	  public static String getuuid(String ProxiedPlayername)
	  {
		    String end = "";
		    try
		    {
		      ResultSet rs = Update.Query("SELECT `UUID` FROM `InfoOktaCoins` WHERE `Pseudo`='" + ProxiedPlayername + "'");
		      while (rs.next()) {
		        end = rs.getString(1);
		      }
		    }
		    catch (Exception err)
		    {
		      System.err.println(err);
		      err.printStackTrace();
		    }
	    return end;
	  }
	  
	  public static float getoktacoins(ProxiedPlayer p)
	  {
		  float c = 0;
	    try
	    {
	      ResultSet rs = Update.Query("SELECT `OktaCoins` FROM `InfoOktaCoins` WHERE `UUID`='" + p.getUniqueId() + "'");
	      while (rs.next()) {
	        c = rs.getFloat(1);
	    	  
	      }
	    }
	    catch (Exception err)
	    {
	      System.err.print(err);
	      err.printStackTrace();
	    }
	    return c;
	  }
	  
	  public static void removeoktacoins(ProxiedPlayer p, float c2)
	  {
		  float c = getoktacoins(p);
	    c -= c2;
	    Update.Update("UPDATE `InfoOktaCoins` SET `OktaCoins`='" + c + "' WHERE `UUID`='" + p.getUniqueId() + "'");
	  }
	  
	  public static void addoktacoins(ProxiedPlayer p, float coins)
	  {
		  float c = getoktacoins(p);
	    c += coins;
	    Update.Update("UPDATE `InfoOktaCoins` SET `OktaCoins`='" + c + "' WHERE `UUID`='" + p.getUniqueId() + "'");
	  }
	  
	  public static void setoktacoins(ProxiedPlayer p, float coins)
	  {
		  float c = 0;
	    c = coins;
	    Update.Update("UPDATE `InfoOktaCoins` SET `OktaCoins`='" + c + "' WHERE `UUID`='" + p.getUniqueId() + "'");
	  }

	  
	  public static float getBoutiquecoins(ProxiedPlayer p)
	  {
		  float c = 0;
	    try
	    {
	      ResultSet rs = Update.Query("SELECT `OktaCoins` FROM `InfoOktaCoins` WHERE `UUID`='" + p.getUniqueId() + "'");
	      while (rs.next()) {
	        c = rs.getFloat(1);
	      }
	    }
	    catch (Exception err)
	    {
	      System.err.print(err);
	      err.printStackTrace();
	    }
	    return c;
	  }
	  
	  public static void removeBoutiquecoins(ProxiedPlayer p, float c2)
	  {
		  float c = getBoutiquecoins(p);
	    c -= c2;
	    Update.Update("UPDATE `InfoOktaCoins` SET `BoutiqueCoins`='" + c + "' WHERE `UUID`='" + p.getUniqueId() + "'");
	  }
	  
	  public static void addBoutiquecoins(ProxiedPlayer p, float coins)
	  {
		  float c = getBoutiquecoins(p);
	    c += coins;
	    Update.Update("UPDATE `InfoOktaCoins` SET `BoutiqueCoins`='" + c + "' WHERE `UUID`='" + p.getUniqueId() + "'");
	  }
	  
	  public static void setBoutiquecoins(ProxiedPlayer p, float coins)
	  {
		  float c = 0;
	    c = coins;
	    Update.Update("UPDATE `InfoOktaCoins` SET `BoutiqueCoins`='" + c + "' WHERE `UUID`='" + p.getUniqueId() + "'");
	  }

	  
 
}
