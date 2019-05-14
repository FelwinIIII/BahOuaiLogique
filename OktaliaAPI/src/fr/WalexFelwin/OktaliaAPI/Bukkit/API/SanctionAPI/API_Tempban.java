package fr.WalexFelwin.OktaliaAPI.Bukkit.API.SanctionAPI;

import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import fr.WalexFelwin.OktaliaAPI.Bukkit.Update;
import fr.WalexFelwin.OktaliaAPI.Bukkit.API.API_OktaCoins;

public class API_Tempban implements Listener{
	
	
	  public static void Ban(String playername, String Raison, String BanPar, long seconds, int ping)
	  {
	    long current = System.currentTimeMillis();
	    long end = current + seconds * 1000L;
	    if (seconds == -1L) {
	      end = -1L;
	    }
		String date = new SimpleDateFormat("d/MMMMM/y / HH:mm:ss").format(new Date(System.currentTimeMillis()));
	    boolean exist2 = false;
	    try
	    {
	      ResultSet rs = Update.Query("SELECT `id` FROM `InfoTempBan` WHERE `Pseudo`='" + playername + "'");
	      while (rs.next()) {
	        exist2 = Boolean.valueOf(true).booleanValue();
			setbandeco(playername, 10);
		    setbanpar(playername, BanPar);
		    setdate(playername, date);
		    setping(playername, ping);
		    setend(playername, Long.valueOf(end));
		    setraison(playername, Raison);
	      }
	    }
	    catch (Exception err)
	    {
	      System.err.println(err);
	      err.printStackTrace();
	    }
	    if (!exist2) {
	     Update.Update("INSERT INTO `InfoTempBan` (`UUID`, `Pseudo`, `RaisonDuBan`, `Ping`, `FinDuBan`, `DateDuBan`, `BanPar`, `TRUE/FALSE`) VALUES ('" + API_OktaCoins.getuuid(playername) + "', '" + playername + "', '"+Raison+"', '"+ping+"', '"+Long.valueOf(end)+"', '"+date+"', '"+BanPar+"', '10')");
	    }


	   
	    }
	  
	  public static long getEnd(String playername)
	  {
		    long end = -1L;
		    try
		    {
		      ResultSet rs = Update.Query("SELECT `FinDuBan` FROM `InfoTempBan` WHERE `Pseudo`='" + playername + "'");
		      while (rs.next()) {
		        end = rs.getLong(1);
		      }
		    }
		    catch (Exception err)
		    {
		      System.err.println(err);
		      err.printStackTrace();
		    }
	    return end;
	  }
	  
	  
	  
	  public static void setend(String p, Long long1)
	  {
		  
		    long c = getEnd(p);
		    long a = 0;
		    c = a + long1;
		Update.Update("UPDATE `InfoTempBan` SET `FinDuBan`='" + c + "' WHERE `Pseudo`='" + p + "'");
	  }
	  
	  
	  public static long getunban(String playername)
	  {
		    int end = 0;
		    try
		    {
		      ResultSet rs = Update.Query("SELECT `FinDuBan` FROM `InfoTempBan` WHERE `Pseudo`='" + playername + "'");
		      while (rs.next()) {
		        end = rs.getInt(1);
		      }
		    }
		    catch (Exception err)
		    {
		      System.err.println(err);
		      err.printStackTrace();
		    }
	    return end;
	  }
	  
	  public static void setunban(String p, int long1)
	  {
		  
		    long c = getunban(p);
		    long a = 0;
		    c = a + long1;
		Update.Update("UPDATE `InfoTempBan` SET `FinDuBan`='" + c + "' WHERE `Pseudo`='" + p + "'");
	  }
	  
	  public static String getRemainingTime(String playername)
	  {
	    String remainingTime = "";
	    long isban = API_Tempban.getbandeco(playername);
	    if (isban >= 2)
	    {
	      long current = System.currentTimeMillis();
	      long end = getEnd(playername);
	      long difference = end - current;
	      if (end == -1L) {
	        return "§ePERMANENT";
	      }
	      int seconds = 0;
	      int minutes = 0;
	      int hours = 0;
	      int days = 0;
	      int weeks = 0;
	      while (difference >= 1000L)
	      {
	        difference -= 1000L;
	        seconds++;
	      }
	      while (seconds >= 60)
	      {
	        seconds -= 60;
	        minutes++;
	      }
	      while (minutes >= 60)
	      {
	        minutes -= 60;
	        hours++;
	      }
	      while (hours >= 24)
	      {
	        hours -= 24;
	        days++;
	      }
	      while (days >= 7)
	      {
	        days -= 7;
	        weeks++;
	      }
	      remainingTime = 
	        "§e" + weeks + " Semaine, " + days + " Jour(s), " + hours + " heure(s), " + minutes + " minute(s) et " + seconds + " secondes.";
	    }
	    return remainingTime;
	  }
	    

	       
	  /**
	   * 
	   * 
	   * 
	   *
	   *
	   *
	   *
	   */
	  public static int getban(Player p)
	  {
	    int c = 0;
	    try
	    {
	      ResultSet rs = Update.Query("SELECT `TRUE/FALSE` FROM `InfoTempBan` WHERE `UUID`='" + p.getUniqueId() + "'");
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
	  
	  public static int getbandeco(String string)
	  {
	    int c = 0;
	    try
	    {
	      ResultSet rs = Update.Query("SELECT `TRUE/FALSE` FROM `InfoTempBan` WHERE `Pseudo`='" + string + "'");
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
	  
	  public static String getbanreason(String p)
	  {
	    String c = "";
	    try
	    {
	      ResultSet rs = Update.Query("SELECT `RaisonDuBan` FROM `InfoTempBan` WHERE `Pseudo`='" + p + "'");
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
	      ResultSet rs = Update.Query("SELECT `Ping` FROM `InfoTempBan` WHERE `Pseudo`='" + p + "'");
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
		Update.Update("UPDATE `InfoTempBan` SET `RaisonDuBan`='" + status + "' WHERE `Pseudo`='" + p + "'");
	  }
	  public static void setdate(String p, String setdate)
	  {
		  
		String status = "UNban";
		status = setdate;
		Update.Update("UPDATE `InfoTempBan` SET `DateDuBan`='" + status + "' WHERE `Pseudo`='" + p + "'");
	  }
	  public static void setping(String p, int i)
	  {
		  
		    int c = getping(p);
		    int a = 0;
		    c = a + i;
		Update.Update("UPDATE `InfoTempBan` SET `Ping`='" + c + "' WHERE `Pseudo`='" + p + "'");
	  }
	  
	  public static void setpseudo(UUID uuid, String setpseudo)
	  {
		  
		String status = "UNban";
		status = setpseudo;
		Update.Update("UPDATE `InfoTempBan` SET `Pseudo`='" + status + "' WHERE `UUID`='" + uuid + "'");
	  }
	  
	  public static void setbanpar(String p, String setban)
	  {
		  
		String status = "";
		status = setban;
		Update.Update("UPDATE `InfoTempBan` SET `BanPar`='" + status + "' WHERE `Pseudo`='" + p + "'");
	  }
	  
	  public static void setban(Player p, int RubyzCoins)
	  {
	    int c = getban(p);
	    int a = 0;
	    c = a + RubyzCoins;
	    Update.Update("UPDATE `InfoTempBan` SET `TRUE/FALSE`='" + c + "' WHERE `UUID`='" + p.getUniqueId() + "'");
	  }
	  public static void setbandeco(String p, int RubyzCoins)
	  {
	    int c = getbandeco(p);
	    int a = 0;
	    c = a + RubyzCoins;
	    Update.Update("UPDATE `InfoTempBan` SET `TRUE/FALSE`='" + c + "' WHERE `Pseudo`='" + p + "'");
	  }

}