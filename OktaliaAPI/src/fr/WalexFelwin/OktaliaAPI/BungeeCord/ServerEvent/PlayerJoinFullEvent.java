package fr.WalexFelwin.OktaliaAPI.BungeeCord.ServerEvent;

import java.util.List;
import java.util.UUID;

import fr.WalexFelwin.OktaliaAPI.BungeeCord.Main;
import fr.WalexFelwin.OktaliaAPI.BungeeCord.CMD.Server.Slots;
import net.md_5.bungee.BungeeCord;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.event.LoginEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.config.Configuration;
import net.md_5.bungee.event.EventHandler;

public class PlayerJoinFullEvent implements Listener{
	
	public static boolean Join = false;

	  
	  public Configuration getConfig()
	  {
		  return Main.yamlConfig.getConfig();
	  }
	 @EventHandler(priority=64)
	 public void onLogin(LoginEvent e)
	 {
		 UUID player = e.getConnection().getUniqueId();
		 
		 int connectplayer = BungeeCord.getInstance().getOnlineCount();


		 if(ServeurEnum.isState(ServeurEnum.MAINTENANCE)){
			 
			 List<String> whitelist = this.getConfig().getStringList("whitelist");
			    
			    if (!whitelist.contains(e.getConnection().getName()))
			    {
			    
			
			 e.setCancelled(true);
			 e.setCancelReason("§cLe serveur Oktalia est en maintenance "
			 		+ "\n "
			 		+ "\n§4§lL'accès au serveur revient des que possibles"
			 		+ "\n§cPlus d'information : §bhttps://discord.gg/rNJCshC");
			 
			    }
			    
		 } else {
			 
		 }
		 if (connectplayer >= Slots.slots){
			 
			// String getgrades = ""+API_GRADES.getgrades(player);
			 
			// if(getgrades.equalsIgnoreCase("0") || getgrades.equalsIgnoreCase("LUMI") || getgrades.isEmpty()){
				 
		
			 e.setCancelled(true);
			 e.setCancelReason("§6Le serveur oktalia est plein \n\n§6§laccès réserver au §eVIP !\n\n§aBoutique:§e http://store.oktalia.fr");
			// }
		 } else {
			 
			 
				
			 
		 }
		 
		 
		 
		 
	 }
	 
	 
}