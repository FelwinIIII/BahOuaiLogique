package fr.walexmine.OktaliaInvest.SQL;

import java.sql.SQLException;
import java.sql.Statement;

import fr.walexmine.OktaliaInvest.Main;

public class InfoInvest {
	
	public static void createTable()
	  {
	    try
	    {
	      Statement state = Main.conn.createStatement();																																							
	      state.executeUpdate("CREATE TABLE IF NOT EXISTS `InfoInvest` (`id` int(11) NOT NULL auto_increment,primary KEY (id), `UUID` VARCHAR(100), `Pseudo` VARCHAR(100), `Invest` VARCHAR(100), `Temps` VARCHAR(100), `TRestant` VARCHAR(100))");
	    }																																																																																								
	    catch (SQLException e)
	    {
	      System.out.println("OktaliaInvest n'a pas plus crée la table (InfoInvest)");
	      System.err.println(e);
	      e.printStackTrace();
	    }
	  }
}
