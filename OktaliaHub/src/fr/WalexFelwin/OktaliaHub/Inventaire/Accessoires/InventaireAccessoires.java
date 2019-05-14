package fr.WalexFelwin.OktaliaHub.Inventaire.Accessoires;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

import fr.WalexFelwin.OktaliaAPI.Bukkit.API.API_Inventaire;

public class InventaireAccessoires {

	private static Inventory inv1;
	

	
	  public static void InventoryAccessoires(Player p)
	  {
		  
		  inv1 = Bukkit.createInventory(null, 9, "§6§lAccessoires");
		  
			 ArrayList<String> Particule = new ArrayList();
			 Particule.add("");
			 Particule.add("");
			 Particule.add("§fMontre les auras et les maîtrises de");
			 Particule.add("§fla magie que tu as acquise pendant ces");
			 Particule.add("§flongues années de jeux !");
			 Particule.add("");
			 Particule.add("§eNOUVELLE Particule: §4§lL'aura de feu !");
			 Particule.add("");
			 Particule.add(" §b§l» §aClic pour accéder aux particules !");
			 Particule.add("");
			 
			 API_Inventaire.additems(369, 1, 0, inv1, "§6§lParticule §7(NOUVEAU !) §e=)", Particule, 2);

			 ArrayList<String> mascotte = new ArrayList();
			 mascotte.add("");
			 mascotte.add("");
			 mascotte.add("§fParcours les vallées du §eHub§f avec");
			 mascotte.add("§fta mascotte préfère et vie des moments");
			 mascotte.add("§finoubliables !");
			 mascotte.add("");
			 mascotte.add("§eNOUVELLE mascotte: §8§l! WITHER !");
			 mascotte.add("");
			 mascotte.add(" §b§l» §aClic pour accéder aux mascottes !");
			 mascotte.add("");
			 
			 API_Inventaire.additems(383, 1, 0, inv1, "§a§lMascotte §7(NOUVEAU !) §e=)", mascotte, 1);
			 
			 ArrayList<String> Monture = new ArrayList();
			 Monture.add("");
			 Monture.add("");
			 Monture.add("§fParcours les vallées du §eHub§f avec");
			 Monture.add("§fta monture préfère et vie des moments");
			 Monture.add("§finoubliables !");
			 Monture.add("");
			 Monture.add("§eNOUVELLE MONTURE: §a§lMouton §4a§6r§ec§f-§ae§2n§f-§bc§1i§de§5l");
			 Monture.add("");
			 Monture.add(" §b§l» §aClic pour accéder aux montures !");
			 Monture.add("");
			 
			 API_Inventaire.additems(419, 1, 0, inv1, "§b§lMonture §7(NOUVEAU !) §e=)", Monture, 0);
			 

			 
		    p.openInventory(inv1);
		    
	  }
}
