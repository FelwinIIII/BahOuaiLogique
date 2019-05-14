package fr.WalexFelwin.OktaliaAPI.BungeeCord.API;

import java.sql.ResultSet;
import java.util.UUID;

import fr.WalexFelwin.OktaliaAPI.BungeeCord.Update;
import net.md_5.bungee.api.connection.ProxiedPlayer;

public class API_MUTE {

	
	public static int getmute(ProxiedPlayer p)
	  {
	    int c = 0;
	    try
	    {
	      ResultSet rs = Update.Query("SELECT `TRUE/FALSE` FROM `InfoMute` WHERE `UUID`='" + p.getUniqueId() + "'");
	      while (rs.next()) {
	        c = rs.getInt(1);
	      }
	    }
	    catch (Exception err)
	    {
	      System.err.println(err);
	      err.printStackTrace();
	    }
	    return c;
	  }
	  
	  public static int getmutedeco(String string)
	  {
	    int c = 0;
	    try
	    {
	      ResultSet rs = Update.Query("SELECT `TRUE/FALSE` FROM `InfoMute` WHERE `Pseudo`='" + string + "'");
	      while (rs.next()) {
	        c = rs.getInt(1);
	      }
	    }
	    catch (Exception err)
	    {
	      System.err.println(err);
	      err.printStackTrace();
	    }
	    return c;
	  }
	  
	  public static String getmutereason(String p)
	  {
	    String c = "";
	    try
	    {
	      ResultSet rs = Update.Query("SELECT `RaisonDuMute` FROM `InfoMute` WHERE `Pseudo`='" + p + "'");
	      while (rs.next()) {
	        c = rs.getString(1);
	      }
	    }
	    catch (Exception err)
	    {
	      System.err.println(err);
	      err.printStackTrace();
	    }
	    return c;
	  }
	  
	  
	  public static int getping(String p)
	  {
	    int c = 0;
	    try
	    {
	      ResultSet rs = Update.Query("SELECT `Ping` FROM `InfoMute` WHERE `Pseudo`='" + p + "'");
	      while (rs.next()) {
	        c = rs.getInt(1);
	      }
	    }
	    catch (Exception err)
	    {
	      System.err.println(err);
	      err.printStackTrace();
	    }
	    return c;
	  }
	  
	  public static void setraison(String p, String setraison)
	  {
		  
		String status = "UNban";
		status = setraison;
		Update.Update("UPDATE `InfoMute` SET `RaisonDuMute`='" + status + "' WHERE `Pseudo`='" + p + "'");
	  }
	  public static void setdate(String p, String setdate)
	  {
		  
		String status = "UNban";
		status = setdate;
		Update.Update("UPDATE `InfoMute` SET `DateDuMute`='" + status + "' WHERE `Pseudo`='" + p + "'");
	  }
	  public static void setping(String p, int i)
	  {
		  
		    int c = getping(p);
		    int a = 0;
		    c = a + i;
		Update.Update("UPDATE `InfoMute` SET `Ping`='" + c + "' WHERE `Pseudo`='" + p + "'");
	  }
	  
	  public static void setpseudo(UUID uuid, String setpseudo)
	  {
		  
		String status = "UNban";
		status = setpseudo;
		Update.Update("UPDATE `InfoMute` SET `Pseudo`='" + status + "' WHERE `UUID`='" + uuid + "'");
	  }
	  
	  public static void setmutepar(String p, String setban)
	  {
		  
		String status = "";
		status = setban;
		Update.Update("UPDATE `InfoMute` SET `MutePar`='" + status + "' WHERE `Pseudo`='" + p + "'");
	  }
	  
	  public static void setmute(ProxiedPlayer p, int RubyzCoins)
	  {
	    int c = getmute(p);
	    int a = 0;
	    c = a + RubyzCoins;
	    Update.Update("UPDATE `InfoMute` SET `TRUE/FALSE`='" + c + "' WHERE `UUID`='" + p.getUniqueId() + "'");
	  }
	  public static void setmutedeco(String p, int RubyzCoins)
	  {
	    int c = getmutedeco(p);
	    int a = 0;
	    c = a + RubyzCoins;
	    Update.Update("UPDATE `InfoMute` SET `TRUE/FALSE`='" + c + "' WHERE `Pseudo`='" + p + "'");
	  }
}
