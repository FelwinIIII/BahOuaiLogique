package fr.WalexFelwin.OktaliaAPI.Bukkit.API.Update;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import fr.WalexFelwin.OktaliaAPI.Bukkit.Main;
import fr.WalexFelwin.OktaliaAPI.Bukkit.MySQLConnection;

public class Mysql {
	

	  public static Connection conn;
	  
		
	  public static void ConnectUpdateur()
	  {
		  conn = openConnectionUpdate();
	  }
	  
	  
	
	  public static Connection openConnectionUpdate()
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
	      Connection conn = DriverManager.getConnection("jdbc:mysql://atlas.tchadelicard.fr:3306/oktalia", "oktalia", "4n76BZRKxlfNaXiN");
	      System.out.println(org.bukkit.ChatColor.GREEN+"OktaliaAPI est bien connectée a la base de données update");
	      return conn;
	    }
	    catch (SQLException e)
	    {
	      System.out.println(org.bukkit.ChatColor.RED+"OktaliaAPI n'est pas bien connectée a la base de données update");
	      System.err.println(e);
	      e.printStackTrace();
	    }
	    return null;
	  }
	  
	  
	  public static void Update(String qry)
	  {
	    try
	    {
	      Statement stmt = conn.createStatement();
	      stmt.executeUpdate(qry);
	      
	      stmt.close();
	    }
	    catch (Exception ex)
	    {
	    	openConnectionUpdate();
	      System.err.println(ex);
	    }
	  }
	  
	  public static Connection getConnection()
	  {
	    return Main.conn;
	  }
	  
	  public static ResultSet Query(String qry)
	  {
	    ResultSet rs = null;
	    try
	    {
	      Statement stmt = conn.createStatement();
	      rs = stmt.executeQuery(qry);
	    }
	    catch (Exception ex)
	    {
	    	openConnectionUpdate();
	      System.err.println(ex);
	    }
	    return rs;
	  }
}
