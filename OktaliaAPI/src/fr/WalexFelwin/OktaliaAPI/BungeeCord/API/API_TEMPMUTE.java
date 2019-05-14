package fr.WalexFelwin.OktaliaAPI.BungeeCord.API;

import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import fr.WalexFelwin.OktaliaAPI.BungeeCord.Update;
import net.md_5.bungee.BungeeCord;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Listener;

public class API_TEMPMUTE implements Listener{
	
	
	  public static void mute(String playername, String Raison, String BanPar, long seconds)
	  {
	    long current = System.currentTimeMillis();
	    long end = current + seconds * 1000L;
	    if (seconds == -1L) {
	      end = -1L;
	    }
		String date = new SimpleDateFormat("d/MMMMM/y / HH:mm:ss").format(new Date(System.currentTimeMillis()));

			    boolean exist5 = false;
			    try
			    {
			      ResultSet rs = Update.Query("SELECT `id` FROM `InfoTempMute` WHERE `UUID`='" + API_Coins.getuuid(playername) + "'");
			      while (rs.next()) {
			        exist5 = Boolean.valueOf(true).booleanValue();
					setmutedeco(playername, 10);
				    setmutepar(playername, BanPar);
				    setdate(playername, date);
				    setend(playername, Long.valueOf(end));
				    setraison(playername, Raison);
				      
			      }
			    }
			    catch (Exception err)
			    {
			      System.err.println(err);
			      err.printStackTrace();
			    }
			    if (!exist5) {
			      Update.Update("INSERT INTO `InfoTempMute` (`UUID`, `Pseudo`, `RaisonDuMute`, `Ping`, `FinDuMute`, `DateDuMute`, `MutePar`, `TRUE/FALSE`) VALUES ('" +  API_Coins.getuuid(playername)  + "', '" + playername+ "', '"+Raison+"', '0', '"+Long.valueOf(end)+"', '"+date+"', '"+BanPar+"', '10')");
			    }
	    
	    ProxiedPlayer target = BungeeCord.getInstance().getPlayer(playername);
	    if (target != null) {
	    	target.sendMessage(" §cVous avez été mute sur le serveur §7(§cDurée: §e"+getRemainingTime(target.getName())+"§7) Raison: "+ getmutereason(target.getName()));
	    }

	    
	    
	      
	    }
	  
	  public static long getEnd(String playername)
	  {
		    long end = -1L;
		    try
		    {
		      ResultSet rs = Update.Query("SELECT `FinDuMute` FROM `InfoTempMute` WHERE `Pseudo`='" + playername + "'");
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
		Update.Update("UPDATE `InfoTempMute` SET `FinDuMute`='" + c + "' WHERE `Pseudo`='" + p + "'");
	  }
	  
	  
	  public static long getunmute(String playername)
	  {
		    int end = 0;
		    try
		    {
		      ResultSet rs = Update.Query("SELECT `FinDuMute` FROM `InfoTempMute` WHERE `Pseudo`='" + playername + "'");
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
		  
		    long c = getunmute(p);
		    long a = 0;
		    c = a + long1;
		Update.Update("UPDATE `InfoTempMute` SET `FinDuBan`='" + c + "' WHERE `Pseudo`='" + p + "'");
	  }
	  
	  public static String getRemainingTime(String playername)
	  {
	    String remainingTime = "";
	    long isban = API_TEMPMUTE.getmutedeco(playername);
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
	        "§e" + days + " Jour(s), " + hours + " heure(s), " + minutes + " minute(s) et " + seconds + " secondes.";
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
	  public static int getmute(ProxiedPlayer p)
	  {
	    int c = 0;
	    try
	    {
	      ResultSet rs = Update.Query("SELECT `TRUE/FALSE` FROM `InfoTempMute` WHERE `UUID`='" + p.getUniqueId() + "'");
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
	      ResultSet rs = Update.Query("SELECT `TRUE/FALSE` FROM `InfoTempMute` WHERE `Pseudo`='" + string + "'");
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
	      ResultSet rs = Update.Query("SELECT `RaisonDuMute` FROM `InfoTempMute` WHERE `Pseudo`='" + p + "'");
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
	      ResultSet rs = Update.Query("SELECT `Ping` FROM `InfoTempMute` WHERE `Pseudo`='" + p + "'");
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
		Update.Update("UPDATE `InfoTempMute` SET `RaisonDuMute`='" + status + "' WHERE `Pseudo`='" + p + "'");
	  }
	  public static void setdate(String p, String setdate)
	  {
		  
		String status = "UNban";
		status = setdate;
		Update.Update("UPDATE `InfoTempMute` SET `DateDuMute`='" + status + "' WHERE `Pseudo`='" + p + "'");
	  }
	  public static void setping(String p, int i)
	  {
		  
		    int c = getping(p);
		    int a = 0;
		    c = a + i;
		Update.Update("UPDATE `InfoTempMute` SET `Ping`='" + c + "' WHERE `Pseudo`='" + p + "'");
	  }
	  
	  public static void setpseudo(UUID uuid, String setpseudo)
	  {
		  
		String status = "UNban";
		status = setpseudo;
		Update.Update("UPDATE `InfoTempMute` SET `Pseudo`='" + status + "' WHERE `UUID`='" + uuid + "'");
	  }
	  
	  public static void setmutepar(String p, String setban)
	  {
		  
		String status = "";
		status = setban;
		Update.Update("UPDATE `InfoTempMute` SET `MutePar`='" + status + "' WHERE `Pseudo`='" + p + "'");
	  }
	  
	  public static void setmute(ProxiedPlayer p, int RubyzCoins)
	  {
	    int c = getmute(p);
	    int a = 0;
	    c = a + RubyzCoins;
	    Update.Update("UPDATE `InfoTempMute` SET `TRUE/FALSE`='" + c + "' WHERE `UUID`='" + p.getUniqueId() + "'");
	  }
	  public static void setmutedeco(String p, int RubyzCoins)
	  {
	    int c = getmutedeco(p);
	    int a = 0;
	    c = a + RubyzCoins;
	    Update.Update("UPDATE `InfoTempMute` SET `TRUE/FALSE`='" + c + "' WHERE `Pseudo`='" + p + "'");
	  }

}