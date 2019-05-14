package fr.WalexFelwin.OktaliaAPI.BungeeCord.API;

import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;


import fr.WalexFelwin.OktaliaAPI.BungeeCord.Update;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Listener;

public class API_BAN implements Listener{
	
	  @SuppressWarnings("null")
	public static void CreateBan(ProxiedPlayer p, String TYPE, String TIME, String Raison, ProxiedPlayer BanPar){
		    boolean exist = false;

		    int ping = 0;
		    
		    String UUID = null;
		    
		    String date = new SimpleDateFormat("d/MMMMM/y / HH:mm:ss").format(new Date(System.currentTimeMillis()));
		    
		    
		    if(p == null) {
		    	
		    	UUID = ""+API_OktaCoins.getuuid(p.getName());
		    	
		    } else {
		    	UUID = ""+p.getUniqueId();
		    	ping = p.getPing();
		    }
		    
		    try
		    {
		      ResultSet rs = Update.Query("SELECT `TYPE` FROM `PlayerBan` WHERE `UUID`='" + p.getUniqueId() + "'");
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
		      Update.Update("INSERT INTO `PlayerBan` (`UUID`, `Pseudo`, `RaisonDuBan`, `TYPE`, `Ping`, `FinDuBan`, `DateDuBan`, `BanPar`) VALUES "
		      		+ "('" + UUID+ "', '" + p.getName() + "', '"+Raison+"', '"+TYPE+"', '"+ping+"', '"+TIME+"', '"+date+"', '"+BanPar.getName()+"')");
		    }

		  
	  }
	
	  public static int getban(ProxiedPlayer p)
	  {
	    int c = 0;
	    try
	    {
	      ResultSet rs = Update.Query("SELECT `TYPE` FROM `PlayerBan` WHERE `UUID`='" + p.getUniqueId() + "'");
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
	      ResultSet rs = Update.Query("SELECT `TYPE` FROM `PlayerBan` WHERE `Pseudo`='" + string + "'");
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
	      ResultSet rs = Update.Query("SELECT `RaisonDuBan` FROM `PlayerBan` WHERE `Pseudo`='" + p + "'");
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
	      ResultSet rs = Update.Query("SELECT `Ping` FROM `PlayerBan` WHERE `Pseudo`='" + p + "'");
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
		Update.Update("UPDATE `PlayerBan` SET `RaisonDuBan`='" + status + "' WHERE `Pseudo`='" + p + "'");
	  }
	  public static void setdate(String p, String setdate)
	  {
		  
		String status = "UNban";
		status = setdate;
		Update.Update("UPDATE `PlayerBan` SET `DateDuBan`='" + status + "' WHERE `Pseudo`='" + p + "'");
	  }
	  public static void setping(String p, int i)
	  {
		  
		    int c = getping(p);
		    int a = 0;
		    c = a + i;
		Update.Update("UPDATE `PlayerBan` SET `Ping`='" + c + "' WHERE `Pseudo`='" + p + "'");
	  }
	  
	  public static void setpseudo(UUID uuid, String setpseudo)
	  {
		  
		String status = "UNban";
		status = setpseudo;
		Update.Update("UPDATE `PlayerBan` SET `Pseudo`='" + status + "' WHERE `UUID`='" + uuid + "'");
	  }
	  
	  public static void setbanpar(String p, String setban)
	  {
		  
		String status = "";
		status = setban;
		Update.Update("UPDATE `PlayerBan` SET `BanPar`='" + status + "' WHERE `Pseudo`='" + p + "'");
	  }
	  
	  public static void setbanTYPE(ProxiedPlayer p, int RubyzCoins)
	  {
	    int c = getban(p);
	    int a = 0;
	    c = a + RubyzCoins;
	    Update.Update("UPDATE `PlayerBan` SET `TYPE`='" + c + "' WHERE `UUID`='" + p.getUniqueId() + "'");
	  }
	  public static void setbanTYPEDeco(String p, int RubyzCoins)
	  {
	    int c = getbandeco(p);
	    int a = 0;
	    c = a + RubyzCoins;
	    Update.Update("UPDATE `PlayerBan` SET `TYPE`='" + c + "' WHERE `Pseudo`='" + p + "'");
	  }

}
