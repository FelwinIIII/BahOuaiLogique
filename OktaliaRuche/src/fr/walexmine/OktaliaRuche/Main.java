package fr.walexmine.OktaliaRuche;

import org.bukkit.event.Listener;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import fr.walexmine.OktaliaRuche.Event.Break;
import fr.walexmine.OktaliaRuche.Event.Place;


public class Main extends JavaPlugin implements Listener{

	@Override
	public void onDisable() {
		
		
	}

	@Override
	public void onEnable() {

		registerevent();

		  this.getCommand("ruche").setExecutor(new RucheCommand());
		  
	}

	@Override
	public void onLoad() {

		
	}
	
	
	
	public void registerevent(){

	    PluginManager pm = getServer().getPluginManager();
	    getServer().getPluginManager().registerEvents(this, this);

	    pm.registerEvents(new Place(this), this);
	    pm.registerEvents(new Break(this), this);
	}
	
	
}
