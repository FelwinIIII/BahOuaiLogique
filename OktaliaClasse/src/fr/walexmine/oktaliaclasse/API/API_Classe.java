package fr.walexmine.oktaliaclasse.API;

import java.sql.ResultSet;

import org.bukkit.entity.Player;

import fr.walexmine.oktaliaclasse.SQL.Update;


public class API_Classe {

	
	public static void CreateProfil(Player p) {
		
	    boolean exist = false;
	    try
	    {
	      ResultSet rs = Update.Query("SELECT `id` FROM `InfoClasse` WHERE `UUID`='" + p.getUniqueId() + "'");
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
	      Update.Update("INSERT INTO `InfoClasse` (`UUID`, `Pseudo`, `Level`, `EXP`) VALUES ('" + p.getUniqueId()+ "', '" + p.getName() +"', '1', '0')");
	    }
	    
	}

	
	  public static void SetLVL(Player p, Integer s)
	  {
		  int i = s;
		  
		Update.Update("UPDATE `InfoClasse` SET `Level`='" + i + "' WHERE `UUID`='" + p.getUniqueId() + "'");
	  }
	  
	  
	  public static Integer getlevel(Player p)
	  {
		  Integer i = null;
		    try
		    {
		      ResultSet rs = Update.Query("SELECT `Level` FROM `InfoClasse` WHERE `UUID`='" + p.getUniqueId() + "'");
		      while (rs.next()) {
		        i = rs.getInt(1);
		      }
		    }
		    catch (Exception err)
		    {
		      System.err.println(err);
		      err.printStackTrace();
		    }
	    return i;
	  }
	  
	  

		
	  public static void SetEXP(Player p, Integer s)
	  {
		  int i = s;
		  
		Update.Update("UPDATE `InfoClasse` SET `EXP`='" + i + "' WHERE `UUID`='" + p.getUniqueId() + "'");
		
	  }
	  
	  public static int getEXP(Player p)
	  {
		  int i = 0;
		    try
		    {
		      ResultSet rs = Update.Query("SELECT `EXP` FROM `InfoClasse` WHERE `UUID`='" + p.getUniqueId() + "'");
		      while (rs.next()) {
		    	  String inventory;
		        i = rs.getInt(1);
		      }
		    }
		    catch (Exception err)
		    {
		      System.err.println(err);
		      err.printStackTrace();
		    }
	    return i;
	  }
	  
}
