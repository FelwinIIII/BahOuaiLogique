package fr.walexmine.OktaliaAuth;


import java.io.IOException;
import java.sql.ResultSet;

import fr.WalexFelwin.OktaliaAPI.BungeeCord.Utils;
import fr.walexmine.OktaliaAuth.data.DataUser;
import fr.walexmine.OktaliaAuth.utils.validate.MojangValidateProfile;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;
import net.md_5.bungee.config.Configuration;

public class LoginAuth extends Command {
	

	public LoginAuth() {
	    super("premium", null, new String[]{"premium"});
		// TODO Auto-generated constructor stub
	}



	@Override
	public void execute(CommandSender sender, String[] args) {
		
			
		
	    if (args.length == 0)
	    {
	    	ProxiedPlayer p = (ProxiedPlayer)sender;
	    	
	    	 DataUser localDataUser = AuthPlugin.INSTANCE.getUser(p);
	     	try {
	     		
				MojangValidateProfile localObject2 = AuthPlugin.INSTANCE.getMojangValidate().getPremiumProfile(p.getName());
				
				if(localObject2.isOnlineMode()) {
					
					   if ((localDataUser.getPremium()) && ((!localDataUser.mustRegister()) || (localDataUser.isRegister())))
			    	    {
			    	    	
			    	    	p.sendMessage(Utils.prefix+"§aVous êtes dêja répertoriée comme premium !");
			    	    	
			    	    } else {

							((DataUser)localDataUser).setPremium(((MojangValidateProfile)localObject2).isOnlineMode());
							p.disconnect(Utils.prefixTitle+"\n \n §aVotre compte est désormais activé en mode premium");
							
			    	    }
				
				} else {
					
					p.sendMessage(Utils.prefix+"§cVotre compte n'est pas éligible au mode premium");
					
				}
				
				
			} catch (Throwable e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	     	
	 
	    	
	    	
	      return;
	    }
	    if (args.length == 1)
	    {

			if(sender.hasPermission("admin")){

		    	if(args[0].equalsIgnoreCase("set")){
		    		
		    		
		    		
		    	} else if(args[0].equalsIgnoreCase("remove")){
		    		
		    		
		    		
		    	}
			}

	    }
	}
}