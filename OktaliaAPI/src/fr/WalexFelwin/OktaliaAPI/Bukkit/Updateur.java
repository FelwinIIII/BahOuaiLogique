package fr.WalexFelwin.OktaliaAPI.Bukkit;

import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.Effect;
import org.bukkit.GameMode;
import org.bukkit.Server.Spigot;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

import fr.WalexFelwin.OktaliaAPI.Bukkit.API.API_Update;
import fr.WalexFelwin.OktaliaAPI.Bukkit.API.Update.Mysql;


public class Updateur extends BukkitRunnable
{
	static int task;
	public static int countdown = 61;
	  public void run()
	  {

	
		Plugin p = Bukkit.getPluginManager().getPlugin("OktaliaAPI");
		  if(!API_Update.getversions(p.getName()).equalsIgnoreCase(p.getDescription().getVersion())){

			 	task = Bukkit.getScheduler().scheduleSyncRepeatingTask(Bukkit.getPluginManager().getPlugin("OktaliaAPI"), new Runnable() {
					
					@Override
					public void run()
					{

						countdown--;

						if(Bukkit.getOnlinePlayers().size() == 0){

						    Bukkit.spigot().restart();
						}
						
						if(countdown == 10 || countdown == 15 || countdown == 30 || countdown == 45 || countdown == 60){
			

							  Bukkit.broadcastMessage("§7[§cSystéme§7] §7Le §eHub "+Bukkit.getServerName().replace("Hub", "")+"§7 va redémarrer dans §e"+countdown+" §7secondes");

								for (Player o : Bukkit.getOnlinePlayers()) { o.playSound(o.getLocation(), Sound.CLICK, 100.0F, 1.0F);}
							
						}
						if(countdown == 5){

							for (Player o : Bukkit.getOnlinePlayers()) { o.playSound(o.getLocation(), Sound.CLICK, 100.0F, 1.0F);}
							
						}
						if(countdown <= 5){

							  Bukkit.broadcastMessage("§7[§cSystéme§7] §7Le §eHub "+Bukkit.getServerName().replace("Hub", "")+"§7 va redémarrer dans §e"+countdown+" §7secondes");
								for (Player o : Bukkit.getOnlinePlayers()) { o.playSound(o.getLocation(), Sound.CLICK, 100.0F, 1.0F);}
							
						}
					if(countdown == 0){
						Bukkit.getScheduler().cancelTask(task);
						
							
						  
							for (Player o : Bukkit.getOnlinePlayers()) {

								o.playSound(o.getLocation(), Sound.ENDERDRAGON_GROWL, 100.0F, 1.0F);

								}
					  	      Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Bukkit.getPluginManager().getPlugin("OktaliaAPI"), new Runnable() {
					              public void run() {
									    Bukkit.spigot().restart();
					              }
					      }, 20);
						   
						
						
						}
					}
				}, 20, 20);
			
		  }
		  
	  }
}