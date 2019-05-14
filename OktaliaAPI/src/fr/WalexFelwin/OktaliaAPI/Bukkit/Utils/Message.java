package fr.WalexFelwin.OktaliaAPI.Bukkit.Utils;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Message {

	
	
	// MESSAGE PERMISSION
	public static String PERMISSION_MESSAGE= "§cVous n'avez pas la permission !";

	public static void RETURNNOPERMISSION(CommandSender sender){
		sender.sendMessage(PERMISSION_MESSAGE);
	}
	//
	
	// MESSAGE PLAYER NULL
	public static String PLAYERNULL_MESSAGE= "§cLe joueur n'est pas connectée.";

	public static void RETURNPLAYERNULL(Player p){
		p.sendMessage(PLAYERNULL_MESSAGE);
	}
	//
	/*
	 * 
	 * 
	 * 
	 */
	
	
}
