package fr.walexmine.OktaliaInvest.SQL;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import fr.walexmine.OktaliaInvest.Main;


public class Update
{
  public Update(Main main) {}
  
  public static void Update(String qry)
  {
    try
    {
      Statement stmt = Main.conn.createStatement();
      stmt.executeUpdate(qry);
      
      stmt.close();
    }
    catch (Exception ex)
    {
    MySQLConnection.openConnection();
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
      Statement stmt = Main.conn.createStatement();
      rs = stmt.executeQuery(qry);
    }
    catch (Exception ex)
    {
    	MySQLConnection.openConnection();
      System.err.println(ex);
    }
    return rs;
  }
}