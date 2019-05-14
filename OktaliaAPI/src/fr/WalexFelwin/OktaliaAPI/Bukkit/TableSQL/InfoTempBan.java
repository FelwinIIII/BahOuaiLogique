package fr.WalexFelwin.OktaliaAPI.Bukkit.TableSQL;

import java.sql.SQLException;
import java.sql.Statement;

import fr.WalexFelwin.OktaliaAPI.Bukkit.Main;


public class InfoTempBan {
	  public InfoTempBan(Main main) {
		// TODO Auto-generated constructor stub
	}

	public static void createTable()
	  {
	    try
	    {
	      Statement state = Main.conn.createStatement();
	      state.executeUpdate("CREATE TABLE IF NOT EXISTS `InfoTempBan` (`id` int(11) NOT NULL auto_increment,primary KEY (id), `UUID` VARCHAR(36), `Pseudo` VARCHAR(36), `RaisonDuBan` VARCHAR(100), `Ping` VARCHAR(36), `FinDuBan` VARCHAR(36), `DateDuBan` VARCHAR(36), `BanPar` VARCHAR(36), `TRUE/FALSE` INT)");
	    }
	    catch (SQLException e)
	    {
	      System.out.println("OktaliaAPI n'a pas plus crée la table d'info tempban du joueur ");
	      System.err.println(e);
	      e.printStackTrace();
	    }
	  }
	
}
