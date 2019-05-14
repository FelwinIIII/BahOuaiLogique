package fr.walexmine.OktaliaInvest.API;

import java.sql.ResultSet;

import org.bukkit.entity.Player;

import fr.walexmine.OktaliaInvest.Event.PlayerMove;
import fr.walexmine.OktaliaInvest.SQL.Update;

public class API_Invest {


	public static String GetInvestT(Player p ) {
		
		String Invest = PlayerMove.Invest.get(p);
		
		String Investti = null;
		
		if(Invest.equalsIgnoreCase("30m")) {
			
			Investti = "§6§l30 Minutes";
			
		}
		
		return Investti;
		
		
		
	}
	
	
	public static void Register(Player p ) {
	    boolean exist = false;
	    try
	    {
	      ResultSet rs = Update.Query("SELECT `id` FROM `InfoInvest` WHERE `UUID`='" + p.getUniqueId() + "'");
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
	      Update.Update("INSERT INTO `InfoInvest` (`UUID`, `Pseudo`, `Invest`, `Temps`, `TRestant`) VALUES ('" + p.getUniqueId()+ "', '" + p.getName() + "', 'NULL', '0', '0')");
	    }
	}
	
	
	
	  public static String getInvest(Player p)
	  {
	    String c = "";
	    try
	    {
	      ResultSet rs = Update.Query("SELECT `Invest` FROM `InfoInvest` WHERE `UUID`='" + p.getUniqueId() + "'");
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
	  
	  
	  
	  public static void setInvest(Player p, String invest)
	  {
		  
		String status = "UNban";
		status = invest;
		Update.Update("UPDATE `InfoInvest` SET `Invest`='" + status + "' WHERE `UUID`='" + p.getUniqueId() + "'");
	  }
	  
	  public static long getTempsRestant(Player p)
	  {
		    long end = -1L;
		    try
		    {
		      ResultSet rs = Update.Query("SELECT `TRestant` FROM `InfoInvest` WHERE `UUID`='" + p.getUniqueId() + "'");
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
	  
	  
	  
	  public static void setTempsRestant(Player p, Long long1)
	  {
		  
		    long a = 0;
		    
		      a = long1;
		      
		Update.Update("UPDATE `InfoInvest` SET `TRestant`='" + a + "' WHERE `UUID`='" + p.getUniqueId() + "'");
	  }
	  
	  
	  
	  
	  public static long getTemps(Player p)
	  {
		    long end = -1L;
		    try
		    {
		      ResultSet rs = Update.Query("SELECT `Temps` FROM `InfoInvest` WHERE `UUID`='" + p.getUniqueId() + "'");
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
	  
	  
	  
	  public static void setTemps(Player p, Long long1)
	  {
		  
		    long a = 0;
		    
		      a = long1;
		      
		Update.Update("UPDATE `InfoInvest` SET `Temps`='" + a + "' WHERE `UUID`='" + p.getUniqueId() + "'");
	  }
	  
}
