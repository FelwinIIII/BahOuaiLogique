package fr.walexmine.OktaliaMinage.SQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import net.md_5.bungee.api.ChatColor;

import org.bukkit.Bukkit;

import fr.WalexFelwin.OktaliaAPI.Bukkit.MySQLConnection;
import fr.WalexFelwin.OktaliaAPI.Bukkit.API.Update.Mysql;
import fr.walexmine.OktaliaMinage.Main;



public class MySQL {
	
	
	
	  public static Connection openConnection()
	  {
	    try
	    {
	      Class.forName("com.mysql.jdbc.Driver");
	    }
	    catch (ClassNotFoundException e1)
	    {
	      System.err.println(e1);
	      e1.printStackTrace();
	    }
	    try
	    {
	      Connection conn = DriverManager.getConnection("jdbc:mysql://" + Main.host + ":" + Main.port + "/" + Main.database, Main.user, Main.pass);
	      System.out.println(org.bukkit.ChatColor.GREEN+"OktaliaMine est bien connect�e a la base de donn�es");
	      return conn;
	    }
	    catch (SQLException e)
	    {
	      System.out.println(org.bukkit.ChatColor.RED+"OktaliaMine n'est pas bien connect�e a la base de donn�es");
	      System.err.println(e);
	      e.printStackTrace();
	    }
	    return null;
	  }

		public static int clock;
		
		
		  public static void clock()
		  {
		    clock = Bukkit.getScheduler().scheduleSyncRepeatingTask(Bukkit.getPluginManager().getPlugin("OktaliaMine"), new Runnable()
		    {
		      public void run()
		      {
		    	  try {
						Main.conn.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		    	        Main.conn = openConnection();	
		    	        
		      }
		    }, 1*60*60*20, 1*60*60*20);
		  }
		  
}
