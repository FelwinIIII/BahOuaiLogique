package fr.walexmine.OktaliaInvest;

import java.sql.Connection;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.Listener;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import fr.walexmine.OktaliaInvest.Commands.Invest;
import fr.walexmine.OktaliaInvest.Event.PlayerJoin;
import fr.walexmine.OktaliaInvest.Event.PlayerMove;
import fr.walexmine.OktaliaInvest.Event.PlayerQuitt;
import fr.walexmine.OktaliaInvest.Event.UpdateInvest;
import fr.walexmine.OktaliaInvest.Inventaire.Interact.InvestInteract;
import fr.walexmine.OktaliaInvest.SQL.InfoInvest;
import fr.walexmine.OktaliaInvest.SQL.MySQLConnection;

public class Main  extends JavaPlugin implements Listener{
	
	
	  private FileConfiguration config = getConfig();
	  public static Connection conn;
	  public static String host;
	  public static int port;
	  public static String user;
	  public static String pass;
	  public static String database;

	  public static String ZoneInvest;
	  
	

	public void onEnable() {
		
	    this.config.addDefault("MySQL.host", "localhost");
	    this.config.addDefault("MySQL.port", Integer.valueOf(3306));
	    this.config.addDefault("MySQL.user", "oktalia");
	    this.config.addDefault("MySQL.pass", "4!jAUJ6b6&sb&@3l");
	    this.config.addDefault("MySQL.database", "oktalia");
	    
	    this.config.addDefault("ZoneInvest.regionWG", "investguard");
	    
	    host = "localhost";
	    port = this.config.getInt("MySQL.port");
	    user = this.config.getString("MySQL.user");
	    pass = this.config.getString("MySQL.pass");
	    database = this.config.getString("MySQL.database");
	    
	    ZoneInvest = this.config.getString("ZoneInvest.regionWG");
	    
	    conn = MySQLConnection.openConnection();
	    
	    this.config.options().copyDefaults(true);
	    
	    saveConfig();
	    
	    
		
	    this.getCommand("invest").setExecutor(new Invest());
	    
	    MySQLConnection.clock();

	    System.out.println("");	    
	    InfoInvest.createTable();
	    registerEvents();
	    
	    Bukkit.getScheduler().scheduleSyncRepeatingTask(this, new UpdateInvest(), 0L, 20L);

	}
	
	@Override
	public void onLoad() {
	}



	public void onDisable() {
		
		
		/*for (Player o : Bukkit.getOnlinePlayers()) {
			API_Redirect.HubSelect(o);
		}
*/

	    System.out.println("");
	    System.out.println("Mise à jour du systéme !");
	    System.out.println("");
	    

	}

	  public void registerEvents(){
		  
		    PluginManager pm = getServer().getPluginManager();
		    getServer().getPluginManager().registerEvents(this, this);
		    pm.registerEvents(new PlayerMove(this), this);
		    pm.registerEvents(new InvestInteract(this), this);
		    pm.registerEvents(new PlayerJoin(this), this);
		    pm.registerEvents(new PlayerQuitt(this), this);

	  }

}
