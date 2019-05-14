package fr.WalexFelwin.OktaliaAPI.Bukkit.TableSQL;

import java.sql.SQLException;
import java.sql.Statement;

import fr.WalexFelwin.OktaliaAPI.Bukkit.Main;

public class InfoBanIp {

	
	  public static void createTable()
	  {
	    try
	    {
	      Statement state = Main.conn.createStatement();
	      state.executeUpdate("CREATE TABLE IF NOT EXISTS `InfoBanIp` (`id` INT(100), `IP` VARCHAR(360), `RaisonDuBan` VARCHAR(100), `Ping` VARCHAR(36), `FinDuBan` VARCHAR(100), `DateDuBan` VARCHAR(100), `BanPar` VARCHAR(100), `TRUE/FALSE` INT)");
	    }
	    catch (SQLException e)
	    {
	      System.out.println("Oktalia n'a pas plus crée la table d'info ban ip du joueur ");
	      System.err.println(e);
	      e.printStackTrace();
	    }
	  }
}
