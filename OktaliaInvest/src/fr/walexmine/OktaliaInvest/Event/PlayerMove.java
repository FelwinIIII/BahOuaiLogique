package fr.walexmine.OktaliaInvest.Event;

import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

import com.sk89q.worldguard.bukkit.WGBukkit;
import com.sk89q.worldguard.protection.ApplicableRegionSet;

import fr.walexmine.OktaliaInvest.Main;
import fr.walexmine.OktaliaInvest.API.API_Invest;


public class PlayerMove implements Listener{


	  public static HashMap<Player, Boolean> GetInfo = new HashMap();
	  
	  public static HashMap<Player, Boolean> Investzone = new HashMap();

	  public static HashMap<Player, String> TimeStart = new HashMap(); // LONG START
	  public static HashMap<Player, String> TimeEND = new HashMap(); // LONG END

	  public static HashMap<Player, String> Invest = new HashMap(); // TIME

	  public static HashMap<Player, String> TimetoSave = new HashMap();
	  
	  
	public PlayerMove(Main main) {

	}

	@EventHandler
	public void Playerinvest(PlayerMoveEvent e) {
		
		Player p = e.getPlayer();
			
		Location loc = p.getLocation();
		
		ApplicableRegionSet set = WGBukkit.getRegionManager(loc.getWorld()).getApplicableRegions(loc);
		World w = (World)Bukkit.getWorld(""+p.getWorld().getName());
		String regions = set.getRegions().toString();
		
		if(regions.contains("id='"+Main.ZoneInvest+"'")) {
			
			
			
			if(!GetInfo.containsKey(p)) {
				
				String GInvest = API_Invest.getInvest(p);
				

					p.sendMessage("INVEST :" +GInvest);
				
				if(GInvest.equalsIgnoreCase("NULL")) {
					
					Invest.put(p, GInvest);

				} else {

					TimeEND.put(p, ""+API_Invest.getTemps(p));
					
					long getstart = API_Invest.getTempsRestant(p);
					
					long time = System.currentTimeMillis()+getstart;
					
					TimeStart.put(p, ""+time);
					
					Invest.put(p, GInvest);
					
					Investzone.put(p, true);
					
					System.out.println("LOAD INVEST Player: "+ p.getName() +" Invest: "+GInvest+" TimeA: "+getstart+ " TimeE: "+TimeEND.get(p));
				
				
				}
				
				GetInfo.put(p, true);
			}
			
			
			if(!Investzone.containsKey(p)) {
				

				Investzone.put(p, true);

				TimeStart.put(p, ""+System.currentTimeMillis());
				p.sendMessage("1er enter");
				return;
				
			}
			
			
			if(!Investzone.get(p)) {
				
				TimeStart.put(p, ""+System.currentTimeMillis());

				Investzone.put(p, true);
				p.sendMessage("enter");
			}
			
		} else {
			
			
			if(Investzone.get(p)) {

				p.sendMessage("SORTIE");
				Investzone.put(p, false);
				
				
				
				
				
				
				
				long Timeadd =  System.currentTimeMillis() - Long.parseLong(TimeStart.get(p));
				
				if(TimetoSave.containsKey(p)) {
					
					long timeh = Long.parseLong(TimetoSave.get(p));
					
					long timea = timeh + Timeadd;
					
					TimetoSave.put(p, ""+timea);

					TimeStart.remove(p);
				} else {
					
					
					
					TimetoSave.put(p, ""+Timeadd);
					
					TimeStart.remove(p);
				}
				
			}
			
		}
		
	}
	
}
