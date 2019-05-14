package fr.WalexFelwin.OktaliaAPI.Bukkit.TableSQL;

import java.sql.SQLException;
import java.sql.Statement;

import fr.WalexFelwin.OktaliaAPI.Bukkit.Main;


public class InfoBan {

	public static void createTable()
	  {
	    try
	    {
	      Statement state = Main.conn.createStatement();
	      state.executeUpdate("CREATE TABLE IF NOT EXISTS `InfoBan` (`id` INT(11), `UUID` VARCHAR(36), `Pseudo` VARCHAR(36), `RaisonDuBan` VARCHAR(100), `TYPE` VARCHAR(36), `Ping` VARCHAR(36), `FinDuBan` VARCHAR(36), `DateDuBan` VARCHAR(36), `BanPar` VARCHAR(36))");
	    }
	    catch (SQLException e)
	    {
	      System.out.println("OktaliaAPI n'a pas plus crée la table d'info B du joueur ");
	      System.err.println(e);
	      e.printStackTrace();
	    }
	  }
}
