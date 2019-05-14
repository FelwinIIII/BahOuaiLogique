package fr.walexmine.OktaliaMinage.Inventaire.StatsMine;

import java.util.ArrayList;
import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

import fr.WalexFelwin.OktaliaAPI.Bukkit.Main;
import fr.WalexFelwin.OktaliaAPI.Bukkit.API.API_Inventaire;
import fr.WalexFelwin.OktaliaAPI.Bukkit.API.API_PingServeur.ServerInfo;


public class MenuP {

	private static Inventory inv1;
	

	  public static HashMap<Player, String> InvMenu = new HashMap();
	
	  public static void InventoryMenuPrincipale(Player p)
	  {
		  
		  inv1 = Bukkit.createInventory(null, 9, "§aMenu Principal");
		  
	  int playerFaction;
         ServerInfo Factions = Main.getInstance().getPingAPI().getServer("Faction");
         Factions.pingToServer();
         playerFaction = Factions.getPlayerCount() ;			  
		  int playerMinage;
	         ServerInfo Minages = Main.getInstance().getPingAPI().getServer("Minage");
	         Minages.pingToServer();
	         playerMinage = Minages.getPlayerCount() ;

	         String SOnlineF = (Factions.isOnline() ? "§a§lEn Ligne" : "§c§lDéconnectée");
	         String SOnlineM = (Minages.isOnline() ? "§a§lEn Ligne" : "§c§lDéconnectée");

			 ArrayList<String> Faction = new ArrayList();
			 Faction.add("");
			 Faction.add("§8§l FACTIONS §7| §e§l★★ §cNEW ! §e§l★★");
			 Faction.add("");
			 Faction.add("§7"+playerFaction+" §eJoueurs connectés ");
			 Faction.add("");
			 Faction.add("§eEtat: "+SOnlineF);
			 Faction.add("");
			 Faction.add("§aPrincipe: §fà décrire");
			 
			 API_Inventaire.additems(133, 1, 0, inv1, "§6§l★ §e§lFACTIONS §6§l★", Faction, 0);
			 

			 

			 API_Inventaire.additems(399, 1, 0, inv1, "§aListe des Hubs", null, 8);

		    p.openInventory(inv1);
		    
		    InvMenu.put(p, "");
	  }
}