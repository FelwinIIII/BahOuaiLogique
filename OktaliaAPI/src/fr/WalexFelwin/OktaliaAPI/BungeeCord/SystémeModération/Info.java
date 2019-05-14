package fr.WalexFelwin.OktaliaAPI.BungeeCord.SystémeModération;

import fr.WalexFelwin.OktaliaAPI.BungeeCord.Utils;
import fr.WalexFelwin.OktaliaAPI.BungeeCord.API.API_BAN;
import fr.WalexFelwin.OktaliaAPI.BungeeCord.API.API_Coins;
import fr.WalexFelwin.OktaliaAPI.BungeeCord.API.API_TEMPBAN;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class Info extends Command {

	public Info() {
	    super("info", null, new String[0]);
		// TODO Auto-generated constructor stub
	}

	@SuppressWarnings("deprecation")
	@Override
	public void execute(CommandSender sender, String[] arg1) {
		  if (arg1.length == 0)
		    {
		    	sender.sendMessage(new TextComponent(Utils.prefix+ChatColor.GREEN + "/info <joueur>§e | Info du joueur"));
		      return;
		    }
			//////////////////////////////////////////////////////////////
			String p = arg1[0];
			String CheckPlayer = API_Coins.getuuid(""+p);
			if(CheckPlayer.equalsIgnoreCase("0") || CheckPlayer.equalsIgnoreCase("")){
				sender.sendMessage("§cLe joueur est inconnu au bataillons !");
				return;
			}
			
			

		    ProxiedPlayer playercheck = ProxyServer.getInstance().getPlayer(arg1[0]);
		    
		    String statusplayer;
		    if(playercheck == null){
		    	statusplayer = "§c§lJoueur déconnectée";
		    } else {
		    	statusplayer = "§a§lJoueur connectée";
		    }
		     int getban = API_BAN.getbandeco(playercheck.getName());
		     int isban = API_TEMPBAN.getbandeco(playercheck.getName());
		    ////////////////////////////////////////////////////////////////
		    TextComponent Co = new TextComponent( "§eCommands: ");
		    TextComponent ban = new TextComponent( "§4[⚠BAN⚠] ");
		    ban.setClickEvent( new ClickEvent( ClickEvent.Action.SUGGEST_COMMAND, "/ban "+arg1[0]+" " ));
		    ban.setHoverEvent( new HoverEvent( HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("§4Ban ").create() ) );
		    ////////////////////////////////////////////////////////////////
		    TextComponent kick = new TextComponent( "§6[✖KICK✖] ");
		    kick.setClickEvent( new ClickEvent( ClickEvent.Action.SUGGEST_COMMAND, "/kick "+arg1[0]+" " ));
		    kick.setHoverEvent( new HoverEvent( HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("§eKick").create() ) );
		    ////////////////////////////////////////////////////////////////
		    
			    sender.sendMessage(new TextComponent("§7§l------------[§bOktalia§7§l]------------"));
			    if(playercheck != null){
				    sender.sendMessage(new TextComponent("§aPing: §e§l"+playercheck.getPing()));
			    } 
			  //  String Etat = API_INFO.checkStatusofTheaccount(playercheck.getName());
			    sender.sendMessage(new TextComponent("§aStatus: "+statusplayer));

			//    sender.sendMessage(new TextComponent("§aEtat du compte: "+Etat));
			    if(getban >= 2){
				    sender.sendMessage(new TextComponent("§aEtat du compte: banni définitivement"));

					
		      } else if (isban >= 2){

				    sender.sendMessage(new TextComponent("§aEtat du compte: banni temporairement"));
		    	   
			  } else {
				    sender.sendMessage(new TextComponent("§aEtat du compte: Non banni"));
			  }
			    if(playercheck == null){

			    	sender.sendMessage(new TextComponent(Co,ban,kick));
			    } else {
				
				    TextComponent message = new TextComponent( "§a[TP] ");
				    message.setClickEvent( new ClickEvent( ClickEvent.Action.RUN_COMMAND, "/tp "+playercheck.getName() ));
				    message.setHoverEvent( new HoverEvent( HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("§aSe téléportée au joueur").create() ) );
				    sender.sendMessage(new TextComponent(Co,message,ban,kick));
			    }

			    sender.sendMessage(new TextComponent("§7§l---------------------------------"));
		    
		    
	}
}
