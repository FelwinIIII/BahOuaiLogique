package fr.WalexFelwin.OktaliaAPI.Bukkit.Commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.WalexFelwin.OktaliaAPI.Bukkit.API.API_Grades;


public class Grades implements CommandExecutor{
	
	  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
	  {

	    if (label.equalsIgnoreCase("grades"))
	    {
	    	if(sender.hasPermission("perm.grades"))
	    	{
	    	if (args.length == 0){

	    		sender.sendMessage("§e----------------------------------------");
	    		sender.sendMessage("§7Systéme des grades et de permission de HezonNetWork");
	    		sender.sendMessage("");
	    		sender.sendMessage("§a/grades set §e<joueur> <grades>");
	    		sender.sendMessage("§a/grades list");
	    		sender.sendMessage("§a/permission set/remove §e<joueur> <permission>");
	    		sender.sendMessage("§a/permission list");
	    		sender.sendMessage("");
	    		sender.sendMessage("Par: §aWalexmine");
	    		sender.sendMessage("§e----------------------------------------");
	    	}
	    	
	    	if (args.length >= 1){
	        	
	   		   if (args[0].equalsIgnoreCase("list"))
		          {
			   sender.sendMessage("§6list des Grades : ");
			   sender.sendMessage("§eDeveloppeur, Gerant, Admin, moderateur, moderatrice, manager");
			   sender.sendMessage("§ebuildeur, youtubeur, ami, vip+, vip");
			   sender.sendMessage("§7-------------------------------------");
			   sender.sendMessage("§emonarque, maitre, legionnaire, voyageur et joueur");
			   sender.sendMessage("§7-------------------------------------");
		          }
	   		   
	  		   if (args[0].equalsIgnoreCase("reload"))
		          {

	  			   sender.sendMessage("§c[Systéme] §eLe systéme de grades ont été reload");
	 	    	  for (Player o : Bukkit.getOnlinePlayers())
		    	    {
		    		  
		    	    }
		          }
		        if (args[0].equalsIgnoreCase("set"))
		          {
		        	Player target = sender.getServer().getPlayer(args[1]);
			    	
		
		            
		      
		            if (args[2].equalsIgnoreCase("developpeur"))
			          {

		            	API_Grades.register(target);
		    	    	 
		    	    	 API_Grades.setgrades(target.getUniqueId(), "developpeur");
		    	    
		    	    	 sender.sendMessage("§c[Systéme] §e"+target.getName()+" §aobtient le grade developpeur");
		    	    	 
			          }
		            if (args[2].equalsIgnoreCase("admin"))
			          {

		            	API_Grades.register(target);
		    	    	 
		    	    	 API_Grades.setgrades(target.getUniqueId(), "admin");
		    	    
		    	    	 sender.sendMessage("§c[Systéme] §e"+target.getName()+" §aobtient le grade admin");
		    	    	 
			          }
		            if (args[2].equalsIgnoreCase("gerant"))
			          {
		    	    	  
		    	    	 
		    	    	 API_Grades.setgrades(target.getUniqueId(), "gerant");
		    	    	 
		    	    	 sender.sendMessage("§c[Systéme] §e"+target.getName()+" §aobtient le grade gerant");
		    	    	 
			          }
		            
		            if (args[2].equalsIgnoreCase("moderateur"))
		            {
		    	    	  
		            	API_Grades.register(target);
		 			    API_Grades.setgrades(target.getUniqueId(), "moderateur");
		    	 
		 			    sender.sendMessage("§c[Systéme] §e"+target.getName()+"§a obtient le grade Modérateur");
		 			    	    	 
		 			}		 
		            
		            if (args[2].equalsIgnoreCase("moderatrice"))
		            {
		    	    	  

		            	API_Grades.register(target);
		 			    API_Grades.setgrades(target.getUniqueId(), "moderatrice");
		    	 
		 			    sender.sendMessage("§c[Systéme] §e"+target.getName()+"§a obtient le grade Modératrice");
		 			    	    	 
		 			}
		            if (args[2].equalsIgnoreCase("manager"))
				      {

		            	API_Grades.register(target);
			    	    	 
			    	    	 API_Grades.setgrades(target.getUniqueId(), "manager");
			    	    	 
			    	    	 sender.sendMessage("§c[Systéme] §e"+target.getName()+" §aobtient le grade manager");
			    	    	 
				      }
		            if (args[2].equalsIgnoreCase("buildeur"))
				      {

		            	API_Grades.register(target);
			    	    	 
			    	    	 API_Grades.setgrades(target.getUniqueId(), "buildeur");
			    	    	 
			    	    	 sender.sendMessage("§c[Systéme] §e"+target.getName()+" §aobtient le grade buildeur");
			    	    	 
				      }
		            if (args[2].equalsIgnoreCase("buildeurtest"))
				      {

		            	API_Grades.register(target);
			    	    	 
			    	    	 API_Grades.setgrades(target.getUniqueId(), "buildeurtest");
			    	    	 
			    	    	 sender.sendMessage("§c[Systéme] §e"+target.getName()+" §aobtient le grade buildeurtest");
			    	    	 
				      }
		            if (args[2].equalsIgnoreCase("youtubeur"))
			          {

		            	API_Grades.register(target);
		    	    	 API_Grades.setgrades(target.getUniqueId(), "youtubeur");
		    	    	 
		    	    	 sender.sendMessage("§c[Systéme] §e"+target.getName()+" §aobtient le grade youtubeur");
		    	    	 
			          }
		            if (args[2].equalsIgnoreCase("ami"))
			          {

		            	API_Grades.register(target);
		    	    	 API_Grades.setgrades(target.getUniqueId(), "ami");
		    	    	 
		    	    	 sender.sendMessage("§c[Systéme] §e"+target.getName()+" §aobtient le grade ami");
		    	    	 
			          }
		            if (args[2].equalsIgnoreCase("vip+"))
			          {
		            	API_Grades.register(target);
		    	    	  
		    	    	 API_Grades.setgrades(target.getUniqueId(), "vip+");
		    	    	 
		    	    	 sender.sendMessage("§c[Systéme] §e"+target.getName()+" §aobtient le grade VIP+");
		    	    	 
			          }
		            if (args[2].equalsIgnoreCase("vip"))
			          {
		            	API_Grades.register(target);
		    	    	  
		    	    	 API_Grades.setgrades(target.getUniqueId(), "vip");
		    	    	 
		    	    	 sender.sendMessage("§c[Systéme] §e"+target.getName()+" §aobtient le grade VIP");
		    	    	 
			          }
		            if (args[2].equalsIgnoreCase("monarque"))
			          {
		            	API_Grades.register(target);
		    	    	  
		    	    	 API_Grades.setgrades(target.getUniqueId(), "monarque");
		    	    	 
		    	    	 sender.sendMessage("§c[Systéme] §e"+target.getName()+" §aobtient le grade §9Monarque");
		    	    	 
			          }
		            if (args[2].equalsIgnoreCase("maitre"))
			          {
		            	API_Grades.register(target);
		    	    	  
		    	    	 API_Grades.setgrades(target.getUniqueId(), "maitre");
		    	    	 
		    	    	 sender.sendMessage("§c[Systéme] §e"+target.getName()+" §aobtient le grade §6Maitre");
		    	    	 
			          }
		            if (args[2].equalsIgnoreCase("legionnaire"))
			          {
		            	API_Grades.register(target);
		    	    	  
		    	    	 API_Grades.setgrades(target.getUniqueId(), "legionnaire");
		    	    	 
		    	    	 sender.sendMessage("§c[Systéme] §e"+target.getName()+" §aobtient le grade §5Legionnaire");
		    	    	 
			          }
		            if (args[2].equalsIgnoreCase("voyageur"))
			          {
		            	API_Grades.register(target);
		    	    	  
		    	    	 API_Grades.setgrades(target.getUniqueId(), "voyageur");
		    	    	 
		    	    	 sender.sendMessage("§c[Systéme] §e"+target.getName()+" §aobtient le grade §2Voyageur");
		    	    	 
			          }
		            if (args[2].equalsIgnoreCase("joueur"))
			          {

		            	API_Grades.register(target);
		    	    	 API_Grades.setgrades(target.getUniqueId(), "joueur");
		    	    	 
		    	    	 sender.sendMessage("§c[Systéme] §e"+target.getName()+" §aobtient le grade joueur");
		    	    	 
			          }		            
		            if (args[3].equalsIgnoreCase("1m"))
			          {

			    	    

						long time = System.currentTimeMillis()+ 30 * 24 * 60 * 60 * 1000L;
						
						API_Grades.setend(""+target.getUniqueId(), time);
		            	
			    	    	 
				          }
		          }
		        
		    	
		    
	  
		        
	
	    		}
		     
	    	} else {
		    	//Message.RETURNNOPERMISSION(sender);
	    	}
	    	
	        	
	    	}
	    
	    return true;
	  }
	  
}