package fr.WalexFelwin.OktaliaFaction.Event.Portal;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPhysicsEvent;
import org.bukkit.event.player.PlayerMoveEvent;

import com.sk89q.worldguard.bukkit.WGBukkit;
import com.sk89q.worldguard.protection.ApplicableRegionSet;

import fr.WalexFelwin.OktaliaAPI.Bukkit.API.API_PingServeur.ServerInfo;


public class PlayerMove  implements Listener{


	public PlayerMove() {

	}

	@EventHandler
	public void Playerinvest(PlayerMoveEvent e) {
		
		Player p = e.getPlayer();
			
		Location loc = p.getLocation();
		
		
		if(p.getLocation().getY() <= 45 && p.getWorld().getName().equalsIgnoreCase("worldevenement")) {

			
			Location loc3 = new Location(Bukkit.getWorld("worldevenement"), 175.5, 120.5, -43.5);
			
			p.teleport(loc3);
			
		}
			

		
		
		ApplicableRegionSet set = WGBukkit.getRegionManager(loc.getWorld()).getApplicableRegions(loc);
	
		String regions = set.getRegions().toString();
		
		if(regions.contains("id='portailminage'")) {

			ServerInfo Minage = fr.WalexFelwin.OktaliaAPI.Bukkit.Main.getInstance().getPingAPI().getServer("Minage");
	         Minage.pingToServer();
	         
	         if(Minage.isOnline()) {
	         
			p.sendMessage("§7[§bOktalia§7] §aTéléportation au serveur minage");

			Minage.teleportPlayer(p);
	         } else {
	        	 
	 		p.sendMessage("§7[§bOktalia§7] §cLe serveur minage est indisponible"); 
	        	 
	         }Location loc2 = null;
			if(loc.getWorld().getName().equalsIgnoreCase("world")) {

				loc2 = new Location(Bukkit.getWorld("world"), 18.5, 74.5, 19.5);
				
			} else {
				
			loc2 = new Location(Bukkit.getWorld("worldevenement"), 185.5, 117.5, -63.5);
			
			}
			p.teleport(loc2);
	         
			
		}
		
		
		if(regions.contains("id='portailevent'")) {

	         
			p.sendMessage("§7[§bOktalia§7] §aTéléportation au warp évenement !");

			Location loc2 = new Location(Bukkit.getWorld("worldevenement"), 175.5, 120.5, -43.5);
			
			p.teleport(loc2);
	         
			
		}
	}
	  
	  @EventHandler
	  public void onPortalBreak(BlockPhysicsEvent e)
	  {
		  
			Location loc = e.getBlock().getLocation();
			
			ApplicableRegionSet set = WGBukkit.getRegionManager(loc.getWorld()).getApplicableRegions(loc);
		
			String regions = set.getRegions().toString();

	    if ((e.getBlock().getType() == Material.PORTAL) && regions.contains("id='portailminage'")) {
	      e.setCancelled(true);
	    }
	    
	      e.setCancelled(true);
	  }
}
