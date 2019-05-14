package fr.WalexFelwin.OktaliaAPI.BungeeCord.API;

import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import fr.WalexFelwin.OktaliaAPI.BungeeCord.Update;
import fr.WalexFelwin.OktaliaAPI.BungeeCord.Utils;
import net.md_5.bungee.BungeeCord;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.connection.ProxiedPlayer;

public class API_BANIP {

	
	
	
	  public static void Ban(String IP, String Raison, String BanPar, long seconds)
	  {
	    long current = System.currentTimeMillis();
	    long end;
	    int ban;
	    
	    if(seconds >= 1){
	    end = current + seconds * 1000L;
	    setbandeco(IP, 2);
	    } else {
	    end = 0;
	    setbandeco(IP, 10);
	    }

		String date = new SimpleDateFormat("d/MMMMM/y / HH:mm:ss").format(new Date(System.currentTimeMillis()));
		
	    setbanpar(IP, BanPar);
	    setdate(IP, date);
	    setend(IP, Long.valueOf(end));
	    setraison(IP, Raison);
        for (ProxiedPlayer all : BungeeCord.getInstance().getPlayers()) {
        
        	if(all.getAddress().getHostString().equalsIgnoreCase(IP)){
        		//BotDetect.BotDetect.remove(IP);
        		all.disconnect(Utils.prefixTitle+"\n§aVous avez été banni ip du serveur Oktalia \n\n §7(§cDurée: §e"+API_BANIP.getRemainingTime(IP)+"§7)  \nRaison: "+ API_BANIP.getbanreason(IP));        		
        	}
        }


	    
	    
	      
	    }
	  
	  public static long getEnd(String playername)
	  {
		    long end = -1L;
		    try
		    {
		      ResultSet rs = Update.Query("SELECT `FinDuBan` FROM `InfoBanIp` WHERE `IP`='" + playername + "'");
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
		Update.Update("UPDATE `InfoBanIp` SET `FinDuBan`='" + c + "' WHERE `IP`='" + p + "'");
	  }
	  
	  
	  public static long getunban(String playername)
	  {
		    int end = 0;
		    try
		    {
		      ResultSet rs = Update.Query("SELECT `FinDuBan` FROM `InfoBanIp` WHERE `IP`='" + playername + "'");
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
		Update.Update("UPDATE `InfoBanIp` SET `FinDuBan`='" + c + "' WHERE `IP`='" + p + "'");
	  }
	  
	  public static String getRemainingTime(String playername)
	  {
	    String remainingTime = "";
	    long isban = API_TEMPBAN.getbandeco(playername);
	    if (isban >= 2)
	    {
	      long current = System.currentTimeMillis();
	      long end = getEnd(playername);
	      long difference = end - current;
	      if (end == 0) {
	        return "§ePermanent";
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
	  public static int getban(ProxiedPlayer p)
	  {
	    int c = 0;
	    try
	    {
	      ResultSet rs = Update.Query("SELECT `TRUE/FALSE` FROM `InfoBanIp` WHERE `UUID`='" + p.getUniqueId() + "'");
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
	      ResultSet rs = Update.Query("SELECT `TRUE/FALSE` FROM `InfoBanIp` WHERE `IP`='" + string + "'");
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
	      ResultSet rs = Update.Query("SELECT `RaisonDuBan` FROM `InfoBanIp` WHERE `IP`='" + p + "'");
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
	      ResultSet rs = Update.Query("SELECT `Ping` FROM `InfoBanIp` WHERE `IP`='" + p + "'");
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
		Update.Update("UPDATE `InfoBanIp` SET `RaisonDuBan`='" + status + "' WHERE `IP`='" + p + "'");
	  }
	  public static void setdate(String p, String setdate)
	  {
		  
		String status = "UNban";
		status = setdate;
		Update.Update("UPDATE `InfoBanIp` SET `DateDuBan`='" + status + "' WHERE `IP`='" + p + "'");
	  }
	  public static void setping(String p, int i)
	  {
		  
		    int c = getping(p);
		    int a = 0;
		    c = a + i;
		Update.Update("UPDATE `InfoBanIp` SET `Ping`='" + c + "' WHERE `IP`='" + p + "'");
	  }
	  

	  
	  public static void setbanpar(String p, String setban)
	  {
		  
		String status = "";
		status = setban;
		Update.Update("UPDATE `InfoBanIp` SET `BanPar`='" + status + "' WHERE `IP`='" + p + "'");
	  }
	  
	  public static void setban(ProxiedPlayer p, int Integer)
	  {
	    int c = getban(p);
	    int a = 0;
	    c = a + Integer;
	    Update.Update("UPDATE `InfoBanIp` SET `TRUE/FALSE`='" + c + "' WHERE `IP`='" + p + "'");
	  }
	  public static void setbandeco(String p, int Integer)
	  {
	    int c = getbandeco(p);
	    int a = 0;
	    c = a + Integer;
	    Update.Update("UPDATE `InfoBanIp` SET `TRUE/FALSE`='" + c + "' WHERE `IP`='" + p + "'");
	  }

}
