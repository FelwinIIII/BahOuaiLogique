package fr.WalexFelwin.OktaliaAPI.Bukkit.API;

import java.sql.ResultSet;

import org.bukkit.entity.Player;

import fr.WalexFelwin.OktaliaAPI.Bukkit.Update;

public class API_Infoperm {

	  public static String getbanperm(Player sender)
	  {
	    String c = "";
	    try
	    {
	      ResultSet rs = Update.Query("SELECT `BAN` FROM `InfoPerm` WHERE `UUID`='" + sender.getUniqueId() + "'");
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
	  
	  public static void setbanperm(Player p, String setperm)
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
	  public static String gettempbanperm(Player p)
	  {
	    String c = "";
	    try
	    {
	      ResultSet rs = Update.Query("SELECT `TEMPBAN` FROM `InfoPerm` WHERE `UUID`='" + p.getUniqueId() + "'");
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
	  
	  public static void settempbanperm(Player p, String setperm)
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
	  public static String getmuteperm(Player p)
	  {
	    String c = "";
	    try
	    {
	      ResultSet rs = Update.Query("SELECT `MUTE` FROM `InfoPerm` WHERE `UUID`='" + p.getUniqueId() + "'");
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
	  
	  public static void setmuteperm(Player p, String setperm)
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
	  public static String gettempmuteperm(Player p)
	  {
	    String c = "";
	    try
	    {
	      ResultSet rs = Update.Query("SELECT `TEMPMUTE` FROM `InfoPerm` WHERE `UUID`='" + p.getUniqueId() + "'");
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
	  
	  public static void settempmuteperm(Player p, String setperm)
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
	  public static String getCHATSTAFFperm(Player p)
	  {
	    String c = "";
	    try
	    {
	      ResultSet rs = Update.Query("SELECT `CHATSTAFF` FROM `InfoPerm` WHERE `UUID`='" + p.getUniqueId() + "'");
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
	  
	  public static void setCHATSTAFFperm(Player p, String setperm)
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
	  public static String getbroadcastperm(Player p)
	  {
	    String c = "";
	    try
	    {
	      ResultSet rs = Update.Query("SELECT `BROADCAST` FROM `InfoPerm` WHERE `UUID`='" + p.getUniqueId() + "'");
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
	  
	  public static void setbroadcastperm(Player p, String setperm)
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
	  public static String getkickperm(Player p)
	  {
	    String c = "";
	    try
	    {
	      ResultSet rs = Update.Query("SELECT `KICK` FROM `InfoPerm` WHERE `UUID`='" + p.getUniqueId() + "'");
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
	  
	  public static void setkickperm(Player p, String setperm)
	  {
		  
		String status = "broadcastperm";
		status = setperm;
		Update.Update("UPDATE `InfoPerm` SET `KICK`='" + status + "' WHERE `UUID`='" + p.getUniqueId() + "'");
	  }

}
