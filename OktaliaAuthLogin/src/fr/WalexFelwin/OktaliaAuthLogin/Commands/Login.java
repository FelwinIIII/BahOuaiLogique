package fr.WalexFelwin.OktaliaAuthLogin.Commands;


import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.WalexFelwin.OktaliaAuthLogin.API.API_Connect;
import fr.WalexFelwin.OktaliaAuthLogin.API.API_Login;


public class Login implements CommandExecutor{
	

	
	 public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
	  {
	   final Player p = (Player)sender;
	    if (label.equalsIgnoreCase("login") || label.equalsIgnoreCase("l"))
	    {


	        long register = API_Login.getregister(p);
	        long login = API_Login.getlogin(p);

	        if (args.length == 0)
	        {
		        if (login == 1L)
		        {
		          p.sendMessage("�cVous �tes d�j� login !");
		          return false;
		        }
	          if (register == 0L)
	          {
	            p.sendMessage("�cVous n'�tes pas enregistr�!");
	            return false;
	          }
	          p.sendMessage("�c/login <MotsDePasse>");
	        }
	        if (args.length == 1)
	        {
	          String target = args[0];
	          
	          String mdp = API_Login.getmotsdepasse(p);
	          
	          
	          if (register == 0L)
	          {
	            p.sendMessage("�cVous n'�tes pas enregistr�!");
	            return false;
	          }
	          if (target == null) {
	            p.sendMessage("�cVeulliez saisir un mots de passe.");
	          }
	          if (login == 0L) {
	            if (mdp.equalsIgnoreCase(target))
	            {

	            	ByteArrayOutputStream b = new ByteArrayOutputStream();
			        DataOutputStream out = new DataOutputStream(b);
					
					
					try {
						out.writeUTF("isLogin");
						out.writeUTF(""+p.getName());
						
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				
					Bukkit.getServer().sendPluginMessage(Bukkit.getPluginManager().getPlugin("OktaliaLogin"), "BungeeLogin", b.toByteArray());
	            	
	            	
	          		API_Login.setlogin(p, 1);
					   p.playSound(p.getLocation(), Sound.LEVEL_UP , 100.0F, 1.0F);
					  p.sendMessage("�eConnexion en cours ...");
						API_Login.sendTitleTime(p, 0, 40, 0, "�b�lOKTALIA �f�lNETWORK", "�eConnexion en cours ...");
		    	    	Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Bukkit.getPluginManager().getPlugin("OktaliaLogin"), new Runnable() {
		    	              public void run() {
		    	    

		  						API_Login.sendTitleTime(p, 0, 20, 0, "�b�lOKTALIA �f�lNETWORK", "�eConnexion au serveur �aOktalia�e.");
	    						  p.sendMessage("�eConnexion au serveur �aOktalia�e.");
		    	              }
		    	      }, 30);
		    	    	Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Bukkit.getPluginManager().getPlugin("OktaliaLogin"), new Runnable() {
		    	              public void run() {
		    	    

		    		          		API_Connect.connectTo(p, "hub1");
		    	              }
		    	      }, 40);
	            }
	            else
	            {
	          
	              p.sendMessage("�cMots de passe incorect");
				  p.playSound(p.getLocation(), Sound.WOLF_GROWL , 100.0F, 1.0F);
	            }
	          
	        }
	      }
	    
	    

	  }
	  return true;
	  }
}
