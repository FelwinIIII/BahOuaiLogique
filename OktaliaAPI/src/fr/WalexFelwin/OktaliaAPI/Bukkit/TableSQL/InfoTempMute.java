package fr.WalexFelwin.OktaliaAPI.Bukkit.TableSQL;

import java.sql.SQLException;
import java.sql.Statement;

import fr.WalexFelwin.OktaliaAPI.Bukkit.Main;


public class InfoTempMute {
	  
	  public InfoTempMute(Main main) {
		// TODO Auto-generated constructor stub
	}

	public static void createTable()
	  {
	    try
	    {
	      Statement state = Main.conn.createStatement();
	      state.executeUpdate("CREATE TABLE IF NOT EXISTS `InfoTempMute` (`id` int(11) NOT NULL auto_increment,primary KEY (id), `UUID` VARCHAR(36), `Pseudo` VARCHAR(36), `RaisonDuMute` VARCHAR(100), `Ping` VARCHAR(36), `FinDuMute` VARCHAR(36), `DateDuMute` VARCHAR(36), `MutePar` VARCHAR(36), `TRUE/FALSE` INT)");
	    }
	    catch (SQLException e)
	    {
	      System.out.println("OktaliaAPI n'a pas plus crée la table d'info tempMute du joueur ");
	      System.err.println(e);
	      e.printStackTrace();
	    }
	  }
}
