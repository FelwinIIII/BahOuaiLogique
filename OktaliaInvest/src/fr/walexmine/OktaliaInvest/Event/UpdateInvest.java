package fr.walexmine.OktaliaInvest.Event;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import com.sk89q.worldguard.bukkit.WGBukkit;
import com.sk89q.worldguard.protection.ApplicableRegionSet;

import fr.WalexFelwin.OktaliaAPI.Bukkit.API.API_Title;
import fr.walexmine.OktaliaInvest.Main;
import fr.walexmine.OktaliaInvest.API.API_Invest;
import fr.walexmine.OktaliaInvest.API.API_Temps;


public class UpdateInvest extends BukkitRunnable
{
	  public void run()
	  {
		for (Player pi : PlayerMove.GetInfo.keySet() ) {
		

			for (Player pi2 : PlayerMove.Investzone.keySet() ) {
				
	
				
		Location loc = pi2.getLocation();
	  
		ApplicableRegionSet set = WGBukkit.getRegionManager(loc.getWorld()).getApplicableRegions(loc);

		String regions = set.getRegions().toString();
		
		if(regions.contains("id='"+Main.ZoneInvest+"'")) {
			
			
			
			if(!PlayerMove.Invest.get(pi2).equalsIgnoreCase("NULL")) {
				
				/*
				String rep = API_Temps.getRemainingTime(pi2);
				
				if(rep.equalsIgnoreCase("end")) {

				    API_Title.sendTitle(pi2, "§f» §6Invest §7["+API_Invest.GetInvestT(pi2)+"§7]", " §aLe temps d'investisements est terminées ! ", -20);
				    
				} else {
					
				API_Title.sendTitleTime(pi2, 0, 22, 0, "§f» §6Invest §7["+API_Invest.GetInvestT(pi2)+"§7] §f«", "§f "+rep+" §6!");

				
				}*/
				
				int time = Integer.valueOf(PlayerMove.Timeleft.get(pi2));
				
				if(time == 0){
				
				PlayerMove.Invest.put(pi2, "NULL");

			    API_Title.sendTitle(pi2, "§f» §6Invest §7["+API_Invest.GetInvestT(pi2)+"§7]", " §aLe temps d'investisements est terminées ! ", -20);
			    
				
				} else {
					
					int newtime = time - 1;
							
					PlayerMove.Timeleft.put(pi2, ""+newtime);		
					
				}
			}
			
		}
			
			
		}
		
		
		
		}
	  }

}
