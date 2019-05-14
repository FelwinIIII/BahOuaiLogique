package fr.WalexFelwin.OktaliaAPI.BungeeCord.CMD.Server;

import java.io.IOException;
import java.sql.ResultSet;

import fr.WalexFelwin.OktaliaAPI.BungeeCord.Update;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;
import net.md_5.bungee.config.Configuration;

public class Slots extends Command {
	
	
	public static int slots = 0;
	
	public Slots() {
		
	    super("slots", null, new String[0]);
	    
	}

	 
	 
	  public static int getslots()
	  {
	    int c = 0;
	    try
	    {
	      ResultSet rs = Update.Query("SELECT `Slots` FROM `ServerSlots` WHERE `id`='1'");
	      while (rs.next()) {
	        c = rs.getInt(1);
	      }
	    }
	    catch (Exception err)
	    {
	      System.err.print(err);
	      err.printStackTrace();
	    }
	    return c;
	  }
	  
	  public static void setslots(int z)
	  {
	    int c;
	    int a = 0;
	    c = a + z;
	    Update.Update("UPDATE `ServerSlots` SET `Slots`='" + c + "' WHERE `id`='1'");
	  }
	  
	@Override
	public void execute(CommandSender sender, String[] args) {
		
		if(sender.hasPermission("admin")){
			
		
	    if (args.length == 0)
	    {
	    	sender.sendMessage(("§7§l[§eOktalia§7§l] "+ChatColor.GREEN + "/slots set/reload§e| Systéme de slots"));
	      return;
	    }
	    if (args.length == 1)
	    {
	    	if(args[0].equalsIgnoreCase("set")){

	    		int slots = Integer.valueOf(args[1]);
	    		
	    		setslots(slots);
	    		Slots.slots = slots;
	         
	    	} else if(args[0].equalsIgnoreCase("reload")){
	    		
	    		int slots = getslots();
	    		Slots.slots = slots;
	    	}
	    }}
	}
}