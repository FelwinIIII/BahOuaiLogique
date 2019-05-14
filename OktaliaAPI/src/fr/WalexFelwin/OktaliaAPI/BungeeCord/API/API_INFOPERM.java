package fr.WalexFelwin.OktaliaAPI.BungeeCord.API;

import java.sql.ResultSet;

import fr.WalexFelwin.OktaliaAPI.BungeeCord.Update;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.connection.ProxiedPlayer;

public class API_INFOPERM {
	
	  public static String getbanperm(String sender)
	  {
	    String c = "";
	    try
	    {
	      ResultSet rs = Update.Query("SELECT `BAN` FROM `InfoPerm` WHERE `Pseudo`='" + sender + "'");
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
	  
	  public static void setbanperm(ProxiedPlayer p, String setperm)
	  {
		  
		String status = "BAN";
		status = setperm;
		Update.Update("UPDATE `InfoPerm` SET `BAN`='" + status + "' WHERE `UUID`='" + p.getUniqueId() + "'");
	  }
	  /*
	   * 
	   * 
	   * 
	   * 
	   */
	  public static String gettempbanperm(String p)
	  {
	    String c = "";
	    try
	    {
	      ResultSet rs = Update.Query("SELECT `TEMPBAN` FROM `InfoPerm` WHERE `Pseudo`='" + p + "'");
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
	  
	  public static void settempbanperm(ProxiedPlayer p, String setperm)
	  {
		  
		String status = "TEMPBAN";
		status = setperm;
		Update.Update("UPDATE `InfoPerm` SET `TEMPBAN`='" + status + "' WHERE `UUID`='" + p.getUniqueId() + "'");
	  }
	  /*
	   * 
	   * 
	   * 
	   * 
	   */
	  public static String getmuteperm(String p)
	  {
	    String c = "";
	    try
	    {
	      ResultSet rs = Update.Query("SELECT `MUTE` FROM `InfoPerm` WHERE `Pseudo`='" + p + "'");
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
	  
	  public static void setmuteperm(ProxiedPlayer p, String setperm)
	  {
		  
		String status = "MUTE";
		status = setperm;
		Update.Update("UPDATE `InfoPerm` SET `MUTE`='" + status + "' WHERE `UUID`='" + p.getUniqueId() + "'");
	  }
	  /*
	   * 
	   * 
	   * 
	   * 
	   */
	  public static String gettempmuteperm(String p)
	  {
	    String c = "";
	    try
	    {
	      ResultSet rs = Update.Query("SELECT `TEMPMUTE` FROM `InfoPerm` WHERE `Pseudo`='" + p + "'");
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
	  
	  public static void settempmuteperm(ProxiedPlayer p, String setperm)
	  {
		  
		String status = "TEMPMUTE";
		status = setperm;
		Update.Update("UPDATE `InfoPerm` SET `TEMPMUTE`='" + status + "' WHERE `UUID`='" + p.getUniqueId() + "'");
	  }
	  /*
	   * 
	   * 
	   * 
	   * 
	   */
	  public static String getCHATSTAFFperm(String p)
	  {
	    String c = "";
	    try
	    {
	      ResultSet rs = Update.Query("SELECT `CHATSTAFF` FROM `InfoPerm` WHERE `Pseudo`='" + p + "'");
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
	  
	  public static void setCHATSTAFFperm(ProxiedPlayer p, String setperm)
	  {
		  
		String status = "TEMPMUTE";
		status = setperm;
		Update.Update("UPDATE `InfoPerm` SET `CHATSTAFF`='" + status + "' WHERE `UUID`='" + p.getUniqueId() + "'");
	  }
	  /*
	   * 
	   * 
	   * 
	   * 
	   */
	  public static String getbroadcastperm(String p)
	  {
	    String c = "";
	    try
	    {
	      ResultSet rs = Update.Query("SELECT `BROADCAST` FROM `InfoPerm` WHERE `Pseudo`='" + p + "'");
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
	  
	  public static void setbroadcastperm(ProxiedPlayer p, String setperm)
	  {
		  
		String status = "broadcastperm";
		status = setperm;
		Update.Update("UPDATE `InfoPerm` SET `BROADCAST`='" + status + "' WHERE `UUID`='" + p.getUniqueId() + "'");
	  }
	  
	  /*
	   * 
	   * 
	   * 
	   * 
	   */
	  public static String getkickperm(String p)
	  {
	    String c = "";
	    try
	    {
	      ResultSet rs = Update.Query("SELECT `KICK` FROM `InfoPerm` WHERE `Pseudo`='" + p + "'");
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
	  
	  public static void setkickperm(ProxiedPlayer p, String setperm)
	  {
		  
		String status = "broadcastperm";
		status = setperm;
		Update.Update("UPDATE `InfoPerm` SET `KICK`='" + status + "' WHERE `UUID`='" + p.getUniqueId() + "'");
	  }
}
