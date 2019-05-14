package fr.WalexFelwin.OktaliaAPI.Bukkit.API.SanctionAPI;

import java.sql.ResultSet;
import java.util.UUID;

import org.bukkit.entity.Player;

import fr.WalexFelwin.OktaliaAPI.Bukkit.Update;



public class API_Ban {
	  public static int getban(Player p)
	  {
	    int c = 0;
	    try
	    {
	      ResultSet rs = Update.Query("SELECT `TRUE/FALSE` FROM `InfoBan` WHERE `UUID`='" + p.getUniqueId() + "'");
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
	      ResultSet rs = Update.Query("SELECT `TRUE/FALSE` FROM `InfoBan` WHERE `Pseudo`='" + string + "'");
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
	      ResultSet rs = Update.Query("SELECT `RaisonDuBan` FROM `InfoBan` WHERE `Pseudo`='" + p + "'");
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
	      ResultSet rs = Update.Query("SELECT `Ping` FROM `InfoBan` WHERE `Pseudo`='" + p + "'");
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
		Update.Update("UPDATE `InfoBan` SET `RaisonDuBan`='" + status + "' WHERE `Pseudo`='" + p + "'");
	  }
	  public static void setdate(String p, String setdate)
	  {
		  
		String status = "UNban";
		status = setdate;
		Update.Update("UPDATE `InfoBan` SET `DateDuBan`='" + status + "' WHERE `Pseudo`='" + p + "'");
	  }
	  public static void setping(String p, int i)
	  {
		  
		    int c = getping(p);
		    int a = 0;
		    c = a + i;
		Update.Update("UPDATE `InfoBan` SET `Ping`='" + c + "' WHERE `Pseudo`='" + p + "'");
	  }
	  
	  public static void setpseudo(UUID uuid, String setpseudo)
	  {
		  
		String status = "UNban";
		status = setpseudo;
		Update.Update("UPDATE `InfoBan` SET `Pseudo`='" + status + "' WHERE `UUID`='" + uuid + "'");
	  }
	  
	  public static void setbanpar(String p, String setban)
	  {
		  
		String status = "";
		status = setban;
		Update.Update("UPDATE `InfoBan` SET `BanPar`='" + status + "' WHERE `Pseudo`='" + p + "'");
	  }
	  
	  public static void setban(Player p, int RubyzCoins)
	  {
	    int c = getban(p);
	    int a = 0;
	    c = a + RubyzCoins;
	    Update.Update("UPDATE `InfoBan` SET `TRUE/FALSE`='" + c + "' WHERE `UUID`='" + p.getUniqueId() + "'");
	  }
	  public static void setbandeco(String p, int RubyzCoins)
	  {
	    int c = getbandeco(p);
	    int a = 0;
	    c = a + RubyzCoins;
	    Update.Update("UPDATE `InfoBan` SET `TRUE/FALSE`='" + c + "' WHERE `Pseudo`='" + p + "'");
	  }

}
