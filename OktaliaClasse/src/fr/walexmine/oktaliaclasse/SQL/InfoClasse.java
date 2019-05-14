package fr.walexmine.oktaliaclasse.SQL;

import java.sql.SQLException;
import java.sql.Statement;

import org.bukkit.ChatColor;

import fr.walexmine.oktaliaclasse.Main;


public class InfoClasse {

	
	  public static void createTable()
	  {
	    try
	    {
	      Statement state = Main.conn.createStatement();
	      state.executeUpdate("CREATE TABLE IF NOT EXISTS `InfoClasse` (`id` int(11) NOT NULL auto_increment,primary KEY (id), `UUID` VARCHAR(36), `Pseudo` VARCHAR(36), `Level` VARCHAR(100), `EXP` VARCHAR(100))");
	    }
	    catch (SQLException e)
	    {
	      System.out.println(ChatColor.RED+"OktaliaClasse n'a pas plus crée la table d'info classe des joueurs ");
	      System.err.println(e);
	      e.printStackTrace();
	    }
	  }
}
