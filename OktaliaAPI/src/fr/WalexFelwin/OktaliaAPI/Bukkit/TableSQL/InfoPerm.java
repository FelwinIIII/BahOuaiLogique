package fr.WalexFelwin.OktaliaAPI.Bukkit.TableSQL;

import java.sql.SQLException;
import java.sql.Statement;

import fr.WalexFelwin.OktaliaAPI.Bukkit.Main;


public class InfoPerm {
	public static void createTable()
	  {
	    try
	    {
	      Statement state = Main.conn.createStatement();
	      state.executeUpdate("CREATE TABLE IF NOT EXISTS `InfoPerm` (`id` INT(11), `UUID` VARCHAR(36), `Pseudo` VARCHAR(36), `BAN` VARCHAR(36), `TEMPBAN` VARCHAR(36), `MUTE` VARCHAR(36), `TEMPMUTE` VARCHAR(36), `CHATSTAFF` VARCHAR(36), `BROADCAST` VARCHAR(36), `KICK` VARCHAR(36))");
	    }
	    catch (SQLException e)
	    {
	      System.out.println("OktaliaAPI n'a pas plus crée la table d'infoPerm du joueur ");
	      System.err.println(e);
	      e.printStackTrace();
	    }
	  }
}
