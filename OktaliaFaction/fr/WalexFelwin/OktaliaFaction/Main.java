package fr.WalexFelwin.OktaliaFaction;

import org.bukkit.event.Listener;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import fr.WalexFelwin.OktaliaAPI.Bukkit.API.API_PingServeur.ServerInfo;
import fr.WalexFelwin.OktaliaAPI.BungeeCord.ServerEvent.Join.PlayerJoin;
import fr.WalexFelwin.OktaliaFaction.Box.ClickEventBox;
import fr.WalexFelwin.OktaliaFaction.Commandes.Givenewitem;
import fr.WalexFelwin.OktaliaFaction.Commandes.MagasinCommand;
import fr.WalexFelwin.OktaliaFaction.Commandes.Menu;
import fr.WalexFelwin.OktaliaFaction.Commandes.Preview;
import fr.WalexFelwin.OktaliaFaction.Commandes.cooldown;
import fr.WalexFelwin.OktaliaFaction.Event.BlockEvent;
import fr.WalexFelwin.OktaliaFaction.Event.InvClickEvent;
import fr.WalexFelwin.OktaliaFaction.Event.InvCloseEvent;
import fr.WalexFelwin.OktaliaFaction.Event.hachelegendaire;
import fr.WalexFelwin.OktaliaFaction.Event.nerf;
import fr.WalexFelwin.OktaliaFaction.Event.randomkit;
import fr.WalexFelwin.OktaliaFaction.Event.replanteuse;
import fr.WalexFelwin.OktaliaFaction.Event.Portal.PlayerDeath;
import fr.WalexFelwin.OktaliaFaction.Event.Portal.PlayerMove;
import fr.WalexFelwin.OktaliaFaction.Inventaire.MagasinALL.Interact.InteractBlock;
import fr.WalexFelwin.OktaliaFaction.Inventaire.Utils.FinalInv;
import fr.WalexFelwin.OktaliaFaction.Scoreboard.UpdateScoreboard;

public class Main extends JavaPlugin implements Listener {


	  public void onEnable()
	  {
	    System.out.println("Plugin OktaliaFaction lancer !");
	    
	    getCommand("menu").setExecutor(new Menu());
	    getCommand("magasin").setExecutor(new MagasinCommand());
	    getCommand("preview").setExecutor(new Preview());
	    getCommand("giveitem").setExecutor(new Givenewitem());
	    
	    // Update scoreboard
	    
	    UpdateScoreboard.clock();
	    
	    // SERVEUR
	    
		ServerInfo Minage = fr.WalexFelwin.OktaliaAPI.Bukkit.Main.getInstance().getPingAPI().addServer("Minage", "localhost", 25591, 4000);
		Minage.pingToServer();
	    
	    
	    registerEvents();
	  }
	  
	  public void onDisable() {}
	  
	  public void registerEvents()
	  {
	    PluginManager pm = getServer().getPluginManager();
	    getServer().getPluginManager().registerEvents(this, this);
	    pm.registerEvents(new InvCloseEvent(), this);
	    pm.registerEvents(new ClickEventBox(), this);
	    pm.registerEvents(new nerf(), this);
	    pm.registerEvents(new FinalInv(this), this);
	    pm.registerEvents(new randomkit(), this);
	    pm.registerEvents(new hachelegendaire(), this);
	    pm.registerEvents(new InteractBlock(this), this);
	    pm.registerEvents(new replanteuse(), this);
	    pm.registerEvents(new InvClickEvent(), this);
	    pm.registerEvents(new BlockEvent(), this);
	    pm.registerEvents(new cooldown(), this);
	    pm.registerEvents(new PlayerMove(), this);
	    pm.registerEvents(new PlayerDeath(), this);
	    pm.registerEvents(new fr.WalexFelwin.OktaliaFaction.Event.PlayerJoin(), this);
	    
	  }
	}
