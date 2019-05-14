package fr.walexmine.oktaliaclasse;

import java.sql.Connection;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.Listener;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import fr.walexmine.oktaliaclasse.Commands.Classe;
import fr.walexmine.oktaliaclasse.Event.PlayerBreak;
import fr.walexmine.oktaliaclasse.Event.PlayerJQ;
import fr.walexmine.oktaliaclasse.Inventaire.Interact.InteractClasse;
import fr.walexmine.oktaliaclasse.SQL.InfoClasse;
import fr.walexmine.oktaliaclasse.SQL.MySQLConnection;


public class Main extends JavaPlugin implements Listener{

	
	  private FileConfiguration config = getConfig();
	  
		public static Connection conn;
		public static String host;
		public static int port;
		public static String user;
		public static String pass;
		public static String database;
	
	@Override
	public void onDisable() {

		
	}

	@Override
	public void onEnable() {

			this.config.addDefault("MySQL.host", "localhost");
			this.config.addDefault("MySQL.port", Integer.valueOf(3306));
			this.config.addDefault("MySQL.user", "root");
			this.config.addDefault("MySQL.pass", "gx7AK27D}e}59p;Cf[");
			this.config.addDefault("MySQL.database", "oktalia");
		    host = this.config.getString("MySQL.host");
		    port = this.config.getInt("MySQL.port");
		    user = this.config.getString("MySQL.user");
		    pass = this.config.getString("MySQL.pass");
		    database = this.config.getString("MySQL.database");

		    this.config.options().copyDefaults(true);

		    saveConfig();
		    
		    conn = MySQLConnection.openConnection();

		    MySQLConnection.clock();
		    
		    InfoClasse.createTable();
		    
		    
		    registerEvents();
		    registerCommands();
		    
	}
	  
	  public void registerEvents(){
		    PluginManager pm = getServer().getPluginManager();
		    getServer().getPluginManager().registerEvents(this, this);

		    pm.registerEvents(new PlayerBreak(this), this);

		    pm.registerEvents(new PlayerJQ(this), this);
		    pm.registerEvents(new InteractClasse(this), this);
	  }

	  public void registerCommands(){

		  this.getCommand("classe").setExecutor(new Classe());
		  
		  
	  }

}
