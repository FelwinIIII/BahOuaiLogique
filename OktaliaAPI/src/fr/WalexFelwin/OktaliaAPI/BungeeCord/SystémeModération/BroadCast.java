package fr.WalexFelwin.OktaliaAPI.BungeeCord.SystémeModération;

import fr.WalexFelwin.OktaliaAPI.BungeeCord.Utils;
import fr.WalexFelwin.OktaliaAPI.BungeeCord.API.API_GRADES;
import fr.WalexFelwin.OktaliaAPI.BungeeCord.API.API_INFOPERM;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class BroadCast extends Command
{
	
	  public BroadCast()
	  {
	    super("broadcast", null, new String[] {"bc"});
	  }
	  
	  public void execute(CommandSender sender, String[] args)
	  {
		  
	    ProxiedPlayer p = (ProxiedPlayer)sender;
	    
	    String rang = null;
	    String rangname = API_GRADES.getgrades(p.getUniqueId());

	      if (rangname.equalsIgnoreCase("admin"))
	      {
	        rang = "§c[Admin]";
	      }
	      else
	      {
	        if (rangname.equalsIgnoreCase("resp.modo"))
	        {
	          rang = "§6[Resp.Modo]";
	        }
	        else
	        {
	          if (rangname.equalsIgnoreCase("developpeur"))
	          {
	            rang = "§a[Développeur]";
	          } else {
	        	    if (rangname.equalsIgnoreCase("moderateur"))
	  	          {
	  	            rang = "§5[Modérateur]";
	  	          } else if(rangname.equalsIgnoreCase("moderatrice")){
		  	            rang = "§5[Modératrice]";
	  	        	  
	  	          }
	          }
	          
	        }
	      }
	    
	    
	    
	    if (!API_INFOPERM.getbroadcastperm(p.getName()).equalsIgnoreCase("TRUE"))
	    {
	      p.sendMessage(color("&cTu n'a pas la permission de faire cette commande"));
	      return;
	    }
	    if (args.length < 1)
	    {
	    	p.sendMessage(new TextComponent(Utils.prefix+ChatColor.GREEN + "/bc <Message> §e| Envoyer un message a tout les joueurs du serveur"));
	    	
	    	return;
	    }
	    for (ProxiedPlayer on : ProxyServer.getInstance().getPlayers())
	    {
	      on.sendMessage(color("&c&l[Annonce]&7 "+ rang +" "+p.getName()+ " : &7" + getMessage(args)));
	    }
	  }
	  
	  private String getMessage(String[] args)
	  {
	    StringBuilder sb = new StringBuilder();
	    for (int i = 0; i < args.length; i++) {
	      sb.append(args[i]).append(" ");
	    }
	    return sb.toString();
	  }
	  
	  private String color(String msg)
	  {
	    return ChatColor.translateAlternateColorCodes('&', msg);
	  }

}
