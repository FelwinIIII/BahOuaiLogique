package fr.WalexFelwin.OktaliaAPI.BungeeCord.CMD.Server;

import java.io.IOException;
import java.util.List;

import fr.WalexFelwin.OktaliaAPI.BungeeCord.Main;
import fr.WalexFelwin.OktaliaAPI.BungeeCord.ServerEvent.ServeurEnum;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;
import net.md_5.bungee.config.Configuration;

public class WhiteList extends Command
{
	  public Configuration getConfig()
	  {
		  return Main.yamlConfig.getConfig();
	  }
	  public WhiteList()
	  {
	    super("whitelist", null, new String[] {"wh"});
	  }
	  
	  public void execute(CommandSender sender, String[] args)
	  {
		  
	    //ProxiedPlayer p = (ProxiedPlayer)sender;
	    

	    
	    
	    
	    if (!sender.hasPermission("whitelist.admin"))
	    {
	      
	      return;
	    }
	    

	    if (args.length == 0)
	    {
	      sender.sendMessage(getString("§7§l[§eOktalia§7§l]: §e/whitelist <on/off/list/add/remove>"));
	    }
	    else if(args[0].equalsIgnoreCase("on")){

		       if(ServeurEnum.isState(ServeurEnum.MAINTENANCE)){
		    	  
		    	   sender.sendMessage("§c§lLe serveur est sous whitelist !");
	    		
		       } else {

		    	   sender.sendMessage("§c§lLe serveur est maintenant sous whitelist !");
					 ServeurEnum.setState(ServeurEnum.MAINTENANCE, true);
		       }
	    }else if(args[0].equalsIgnoreCase("off")){
	    		  if(!ServeurEnum.isState(ServeurEnum.MAINTENANCE)){
	    		  
	    			  sender.sendMessage("§c§lLa whitelist n'ai pas activée !");
	    		  } else {
	    			  sender.sendMessage("§c§lLa whitelist est maintenant désactivé !");
	    			  ServeurEnum.setState(ServeurEnum.MAINTENANCE, false);
	    		  }
	    	}
	    else if (args[0].equalsIgnoreCase("reload"))
	    {
	    	sender.sendMessage(getString("§7§l[§eOktalia§7§l]: §eLa whitelist a bien été reload"));
	 	   try
		    {
		      Main.yamlConfig.saveConfig();
		    }
		    catch (IOException ex)
		    {
		      ex.printStackTrace();
		    }
	    }
	    else if (args[0].equalsIgnoreCase("add"))
	    {
	      List<String> whitelist = getConfig().getStringList("whitelist");
	      if (args.length >= 2)
	      {
	        whitelist.add(args[1]);
	        getConfig().set("whitelist", whitelist);
		      sender.sendMessage(getString("§7§l[§eOktalia§7§l]: §eLe joueur a bien été ajoutée a la whitelist"));
	      }
	      else
	      {

		      sender.sendMessage(getString("§7§l[§eOktalia§7§l]: §e/whitelist add <Joueur>"));
	      }
	    }
	    else if (args[0].equalsIgnoreCase("remove"))
	    {
	      List<String> whitelist = getConfig().getStringList("whitelist");
	      if (args.length >= 2)
	      {
	        if (!whitelist.contains(args[1]))
	        {
			      sender.sendMessage(getString("§7§l[§eOktalia§7§l]: §eLe joueur ne figure pas dans la whitelist"));
	        }
	        else
	        {
	          whitelist.remove(args[1]);
	          getConfig().set("whitelist", whitelist);
	          sender.sendMessage(getString("§7§l[§eOktalia§7§l]: §eLe joueur a bien été suprimée de la whitelist"));
	        }
	      }
	      else {
		      sender.sendMessage(getString("§7§l[§eOktalia§7§l]: §e/whitelist remove <Joueur>"));
	      }
	    }
	    else if (args[0].equalsIgnoreCase("list"))
	    {
	      List<String> whitelist = getConfig().getStringList("whitelist");
	      
	      sender.sendMessage(getString("§7§l[§eOktalia§7§l] List : §e" + whitelist));
	    }

	  }


	  private TextComponent getString(String label)
	  {
	    label = ChatColor.translateAlternateColorCodes('&', label);
	    return new TextComponent(label);
	  
	  }



}
