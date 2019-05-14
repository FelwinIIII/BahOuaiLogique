package fr.WalexFelwin.OktaliaAPI.BungeeCord.API;

import java.sql.ResultSet;
import java.util.UUID;

import fr.WalexFelwin.OktaliaAPI.BungeeCord.Update;
import net.md_5.bungee.api.connection.ProxiedPlayer;

public class API_GRADES {

	
	 
	  public static String getgrades(UUID player)
	  {
	    String c = "";
	    try
	    {
	      ResultSet rs = Update.Query("SELECT `Grades` FROM `InfoGrades` WHERE `UUID`='" + player + "'");
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
	  
	  public static void setgrades(ProxiedPlayer p, String setgrades)
	  {
		  
		String status = "UNban";
		status = setgrades;
		Update.Update("UPDATE `InfoGrades` SET `Grades`='" + status + "' WHERE `UUID`='" + p.getUniqueId() + "'");
	  }
	  
	  public static String get(String player)
	  {
	    String c = "";
	    try
	    {
	      ResultSet rs = Update.Query("SELECT `UUID` FROM `InfoGrades` WHERE `Pseudo`='" + player + "'");
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
	  
	  public static long getEnd(String playername)
	  {
		    long end = -1L;
		    try
		    {
		      ResultSet rs = Update.Query("SELECT `FinDuGrades` FROM `InfoGrades` WHERE `UUID`='" + playername + "'");
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
		Update.Update("UPDATE `InfoGrades` SET `FinDuGrades`='" + c + "' WHERE `UUID`='" + p + "'");
	  }

	  
	  public static void setgradesdeco(String p, String setgrades)
	  {
		  
		String status = "UNban";
		status = setgrades;
		Update.Update("UPDATE `InfoGrades` SET `Grades`='" + status + "' WHERE `Pseudo`='" + p + "'");
	  }
	  
}
