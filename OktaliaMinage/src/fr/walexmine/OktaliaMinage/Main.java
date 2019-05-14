package fr.walexmine.OktaliaMinage;

import java.sql.Connection;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import fr.WalexFelwin.OktaliaAPI.Bukkit.API.API_PingServeur.ServerInfo;
import fr.walexmine.OktaliaMinage.API.API_Inventory;
import fr.walexmine.OktaliaMinage.API.API_Joueur;
import fr.walexmine.OktaliaMinage.API.API_Temps;
import fr.walexmine.OktaliaMinage.Commands.Inventory;
import fr.walexmine.OktaliaMinage.Commands.Reserve;
import fr.walexmine.OktaliaMinage.Event.Event;
import fr.walexmine.OktaliaMinage.Event.PlayerBreak;
import fr.walexmine.OktaliaMinage.Event.PlayerJoin;
import fr.walexmine.OktaliaMinage.Event.PlayerQuitt;
import fr.walexmine.OktaliaMinage.Inventaire.Interact.Slots;
import fr.walexmine.OktaliaMinage.Inventaire.Interact.TransfertReserve;
import fr.walexmine.OktaliaMinage.Inventaire.StatsMine.Stats;
import fr.walexmine.OktaliaMinage.Inventaire.StatsMine.Interact.InteractHub;
import fr.walexmine.OktaliaMinage.Inventaire.StatsMine.Interact.InteractMenuP;
import fr.walexmine.OktaliaMinage.Inventaire.StatsMine.Reload.InventaireHubRELOAD;
import fr.walexmine.OktaliaMinage.Inventaire.StatsMine.Reload.InventaireMenuRELOAD;
import fr.walexmine.OktaliaMinage.SQL.InfoInventory;
import fr.walexmine.OktaliaMinage.SQL.InfoJoueur;
import fr.walexmine.OktaliaMinage.SQL.MySQL;
import fr.walexmine.OktaliaMinage.ScoreBoard.Scoreboard;


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
		
	
	    if(Bukkit.getOnlinePlayers().size() == 0){
	    	
	    } else {
	    for (Player p : Bukkit.getOnlinePlayers())
	    {

			API_Inventory.saveReserveMine(p, API_Inventory.toBase64(PlayerBreak.ReserveM.get(p)));
				
			long timeco = Long.parseLong(API_Temps.TIMECO.get(p));
			long timenow = System.currentTimeMillis();
			
			long timesession = timenow - timeco;
			
			API_Joueur.addTIME(p, timesession);


			API_Joueur.SetEXP(p, Stats.EXP.get(p));
			API_Joueur.SetLVL(p, Stats.LEVEL.get(p));
			System.out.println("DATA save player: "+p.getPlayer());
	    }}
	}

	@Override
	public void onEnable() {


		this.config.addDefault("MySQL.host", "localhost");
	    this.config.addDefault("MySQL.port", Integer.valueOf(3306));
	    this.config.addDefault("MySQL.user", "root");
	    this.config.addDefault("MySQL.pass", "4!jAUJ6b6&sb&@3l");
	    this.config.addDefault("MySQL.database", "oktalia");
		    
		    
		    host = this.config.getString("MySQL.host");
		    port = this.config.getInt("MySQL.port");
		    user = this.config.getString("MySQL.user");
		    pass = this.config.getString("MySQL.pass");
		    database = this.config.getString("MySQL.database");
		    
		    
		    conn = MySQL.openConnection();
		    this.config.options().copyDefaults(true);
		    saveConfig();
		    
		    
		    InfoJoueur.createTable();
		    InfoInventory.createTable();
		    MySQL.clock();
		    
		    
		    registerEvents();
		    registerCommands();
		    
			ServerInfo Faction = fr.WalexFelwin.OktaliaAPI.Bukkit.Main.getInstance().getPingAPI().addServer("Faction", "localhost", 25590, 4000);
			Faction.pingToServer();
			ServerInfo Minage = fr.WalexFelwin.OktaliaAPI.Bukkit.Main.getInstance().getPingAPI().addServer("Minage", "localhost", 25591, 4000);
			Minage.pingToServer();

			for (Player o : Bukkit.getOnlinePlayers())
		    {
			   Scoreboard.Scoreboardstart(o);
		    }
			
		    UpdateScoreBoard.clock();

		   // new InventaireHubRELOAD().runTaskTimerAsynchronously(this, 0L, 25);

		    new InventaireMenuRELOAD().runTaskTimerAsynchronously(this, 0L, 40);
			
	}
	  
	  public void registerEvents(){
		    PluginManager pm = getServer().getPluginManager();
		    getServer().getPluginManager().registerEvents(this, this);

		    pm.registerEvents(new PlayerJoin(this), this);
		    pm.registerEvents(new PlayerBreak(this), this);
		    pm.registerEvents(new PlayerQuitt(this), this);
		    pm.registerEvents(new TransfertReserve(this), this);
		    pm.registerEvents(new Slots(this), this);
		    pm.registerEvents(new Event(this), this);
		    pm.registerEvents(new InteractMenuP(this), this);
		    pm.registerEvents(new InteractHub(this), this);
	  }

	  public void registerCommands(){

		  this.getCommand("inventaire").setExecutor(new Inventory());
		  this.getCommand("reserve").setExecutor(new Reserve());
		  
		  
	  }
}
