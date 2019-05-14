package fr.WalexFelwin.OktaliaAPI.BungeeCord.CMD;

import java.sql.ResultSet;

import org.bukkit.Bukkit;

import fr.WalexFelwin.OktaliaAPI.BungeeCord.Update;
import fr.WalexFelwin.OktaliaAPI.BungeeCord.CMD.Server.Slots;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.plugin.Command;

public class discord extends Command {
	
	
	public static int slots = 0;
	
	public discord() {
		
	    super("discord", null, new String[0]);
	    
	}

	  
	@Override
	public void execute(CommandSender sender, String[] args) {
		
			
		sender.sendMessage("§7§l[§e§lInformation§7§l] §eVous voulez rejoindre notre communauté vocal, rendez-vous sur le discord de §bOktalia");
		sender.sendMessage("§9§lhttps://discord.gg/rNJCshC");
		
	    	sender.sendMessage(("§7§l[§eOktalia§7§l] "+ChatColor.GREEN + "/slots set/reload§e| Systéme de slots"));
	      return;
	    
	    
	}


}
