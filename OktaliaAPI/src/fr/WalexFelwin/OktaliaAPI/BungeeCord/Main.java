package fr.WalexFelwin.OktaliaAPI.BungeeCord;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Logger;

import fr.WalexFelwin.OktaliaAPI.BungeeCord.API.API_YamlConfig;
import fr.WalexFelwin.OktaliaAPI.BungeeCord.CMD.Server.Info;
import fr.WalexFelwin.OktaliaAPI.BungeeCord.CMD.Server.Slots;
import fr.WalexFelwin.OktaliaAPI.BungeeCord.CMD.Server.WhiteList;
import fr.WalexFelwin.OktaliaAPI.BungeeCord.CrashPinger.ReconnectOnCrash;
import fr.WalexFelwin.OktaliaAPI.BungeeCord.ServerEvent.PlayerJoinFullEvent;
import fr.WalexFelwin.OktaliaAPI.BungeeCord.ServerEvent.ServerMotd;
import fr.WalexFelwin.OktaliaAPI.BungeeCord.ServerEvent.ServerPingTxT;
import fr.WalexFelwin.OktaliaAPI.BungeeCord.ServerEvent.ServerProxy;
import fr.WalexFelwin.OktaliaAPI.BungeeCord.ServerEvent.Join.ChatMute;
import fr.WalexFelwin.OktaliaAPI.BungeeCord.ServerEvent.Join.PlayerJoin;
import fr.WalexFelwin.OktaliaAPI.BungeeCord.SystémeModération.Ban;
import fr.WalexFelwin.OktaliaAPI.BungeeCord.SystémeModération.BanIp;
import fr.WalexFelwin.OktaliaAPI.BungeeCord.SystémeModération.BroadCast;
import fr.WalexFelwin.OktaliaAPI.BungeeCord.SystémeModération.Mute;
import fr.WalexFelwin.OktaliaAPI.BungeeCord.SystémeModération.TempBan;
import fr.WalexFelwin.OktaliaAPI.BungeeCord.SystémeModération.TempMute;
import fr.WalexFelwin.OktaliaAPI.BungeeCord.SystémeModération.UnBan;
import fr.WalexFelwin.OktaliaAPI.BungeeCord.SystémeModération.UnMute;
import net.md_5.bungee.BungeeCord;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.api.plugin.Plugin;
import net.md_5.bungee.config.Configuration;
import net.md_5.bungee.config.ConfigurationProvider;
import net.md_5.bungee.config.YamlConfiguration;

public class Main extends Plugin implements Listener{

    public static Main instance;
    private static Configuration config;
	  public static Connection conn;
    static String host;
	static String database;
    static String username;
    static String password;
    static int port;
    public static Logger log;

    public static API_YamlConfig yamlConfig;

    public static API_YamlConfig config2;
    
	@Override
	public void onDisable() {
	saveConfig();	
	}

	@Override
	public void onEnable() {
		log = getLogger();
		
		  log.info(ChatColor.GRAY+"-------------------------");
		  log.info(ChatColor.YELLOW+"BungeeCoord API");
		  log.info(ChatColor.YELLOW+" Version : 1.0");
		  log.info(ChatColor.YELLOW+"Plugin Start");
		  log.info(ChatColor.GRAY+"===============================");
		  
		  
	    host = "localhost";
	    port = 3306;
	    database = "oktalia";
	    username = "root";
	    password = "gx7AK27D}e}59p;Cf[";
	    conn = openConnection();
	    
	   // MySQL.clock();
	    

	    API_YamlConfig f = new API_YamlConfig("BungeeWhiteList.yml", BungeeCord.getInstance().getPluginManager().getPlugin("OktaliaAPI"));
	    API_YamlConfig co = new API_YamlConfig("config.yml", BungeeCord.getInstance().getPluginManager().getPlugin("OktaliaAPI"));
	    f.saveDefaultConfig();
	    co.saveDefaultConfig();
	    yamlConfig = f;
	    config2 =co;

		//Slots.slots = Slots.getslots();
	    Slots.slots = 200;
		HASHMAP.StatsMotd.put("full", "true");

		// COMMANDS 

		BungeeCord.getInstance().getPluginManager().registerCommand(this, new  BroadCast());
		BungeeCord.getInstance().getPluginManager().registerCommand(this, new  Ban());
		BungeeCord.getInstance().getPluginManager().registerCommand(this, new  BanIp());
		BungeeCord.getInstance().getPluginManager().registerCommand(this, new  TempBan());
		BungeeCord.getInstance().getPluginManager().registerCommand(this, new  fr.WalexFelwin.OktaliaAPI.BungeeCord.SystémeModération.Info());
		BungeeCord.getInstance().getPluginManager().registerCommand(this, new  Mute());
		BungeeCord.getInstance().getPluginManager().registerCommand(this, new  TempMute());
		BungeeCord.getInstance().getPluginManager().registerCommand(this, new  UnBan());
		BungeeCord.getInstance().getPluginManager().registerCommand(this, new  UnMute());
		BungeeCord.getInstance().getPluginManager().registerCommand(this, new  BroadCast());
		
		
		
		BungeeCord.getInstance().getPluginManager().registerCommand(this, new  WhiteList());
		BungeeCord.getInstance().getPluginManager().registerCommand(this, new  Slots());
		

	    BungeeCord.getInstance().getPluginManager().registerListener(this, new PlayerJoin());
	    BungeeCord.getInstance().getPluginManager().registerListener(this, new ChatMute());
	    BungeeCord.getInstance().getPluginManager().registerListener(this, new ReconnectOnCrash());
	    BungeeCord.getInstance().getPluginManager().registerListener(this, new ServerPingTxT());
	    BungeeCord.getInstance().getPluginManager().registerListener(this, new ServerProxy());
	    BungeeCord.getInstance().getPluginManager().registerListener(this, new ServerMotd());
	    BungeeCord.getInstance().getPluginManager().registerListener(this, new PlayerJoinFullEvent());

	    getProxy().registerChannel("BungeeInterconnect");
	    BungeeCord.getInstance().getPluginManager().registerListener(this, new PluginMessage());
	    
	    MySQL.clock();
		registercommands();
		registerevent();
		reloadConfig();
		saveConfig();
	}
	  @Override
	public ProxyServer getProxy() {
		// TODO Auto-generated method stub
		return super.getProxy();
	}

	@Override
	public void onLoad() {
	}

	public static Connection openConnection()
	  {
	    try
	    {
	      Class.forName("com.mysql.jdbc.Driver");
	    }
	    catch (ClassNotFoundException e1)
	    {
	      System.err.println(e1);
	      e1.printStackTrace();
	    }
	    try
	    {
	      Connection conn = DriverManager.getConnection("jdbc:mysql://" + host + ":" + port + "/" + database, username, password);

		  log.info(ChatColor.YELLOW+"L'API BungeeCord est bien connectée a la base de données !");
	      return conn;
	    }
	    catch (SQLException e)
	    {

			for (ProxiedPlayer all : BungeeCord.getInstance().getPlayers()) {
				all.disconnect("\n§cLes serveurs on rencontré des problémes\n§cPlus d'information :§e https://twitter.com/");
			}
		      System.out.println(ChatColor.RED+"L'API BungeeCord n'est pas bien connectée a la base de données");
		      System.out.println(ChatColor.RED+"----------------------------------------------------");
		      System.out.println(ChatColor.RED+"     Fermetture du BungeeCord MySQL déconnecté");
		      System.out.println(ChatColor.RED+"----------------------------------------------------");
		      System.err.println(e);
	      e.printStackTrace();

	    }
	    return null;
	  }
	
	public void registercommands(){

		//BungeeCord.getInstance().getPluginManager().registerCommand(this, new Friends());
	}


	public void registerevent(){
		
		//BungeeCord.getInstance().getPluginManager().registerListener(this, new PlayerJoin());
		
	}
	
	  public static Configuration getConfig()
	  {
	    return Main.config;
	  }
	 
	  public void reloadConfig()
	  {
	    try
	    {
	      Main.config = ConfigurationProvider.getProvider(YamlConfiguration.class).load(new File(getDataFolder(), "config.yml"));
	    }
	    catch (IOException e)
	    {
	      throw new RuntimeException("Chargement du config.yml Failed !", e);
	    }
	   
	  }
	  
	  public void saveConfig()
	  {
	    try
	    {
	      ConfigurationProvider.getProvider(YamlConfiguration.class).save(getConfig(), new File(getDataFolder(), "config.yml"));
	    }
	    catch (IOException e)
	    {
	      throw new RuntimeException("Save Config.yml Failed !", e);
	    }
	  }
	
	
}
