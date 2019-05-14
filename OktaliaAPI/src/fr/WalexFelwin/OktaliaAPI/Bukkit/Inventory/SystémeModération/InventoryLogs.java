package fr.WalexFelwin.OktaliaAPI.Bukkit.Inventory.SystémeModération;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.DyeColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;


public class InventoryLogs {

	  private static Inventory inv1;
	  
	public static void InventaireKits(Player p, Player mp)
	  {
		    inv1 = Bukkit.createInventory(null, 9, "§7Logs de "+mp.getName());
		    
		    
		    ItemStack logs = new ItemStack(Material.PAPER, 1);
		    ItemMeta statslogs = logs.getItemMeta();
		    statslogs.setDisplayName("§aLogs :");
		    ArrayList<String> logslore = new ArrayList();
		    logslore.add("");
		    logslore.add("§7§llogs du joueur "+mp.getName());
		    logslore.add("§aAlert CPS : §e");
		    logslore.add("§aAlert Xray : §e");
		    logslore.add("§aAlert KillAura : §cIn dév");
		    logslore.add("§aAlert AntiKb : §cIn dév");
		    logslore.add("§aAlert Fly : §cIn dév");
		    logslore.add("");
		    statslogs.setLore(logslore);
		    logs.setItemMeta(statslogs);

		    ItemStack logsminerais = new ItemStack(Material.DIAMOND_ORE, 1);
		    ItemMeta statslogsminerais = logsminerais.getItemMeta();
		    statslogsminerais.setDisplayName("§aLogs minerais §7:");
		    ArrayList<String> logsmineraislore = new ArrayList();
		    logsmineraislore.add("");
		    logsmineraislore.add("§7§llogsminerais du joueur "+mp.getName());
		    logsmineraislore.add("");
		   /* logsmineraislore.add("§bDiamant: §e"+XRAYLOG.Diamond.get(mp));
		    logsmineraislore.add("§6Or: §e"+XRAYLOG.Or.get(mp));
		    logsmineraislore.add("§7Fer: §e"+XRAYLOG.Iron.get(mp));*/
		    statslogsminerais.setLore(logsmineraislore);
		    logsminerais.setItemMeta(statslogsminerais);
		    
		    ItemStack logsreport = new ItemStack(358, 1);
		    ItemMeta statslogsreport = logsreport.getItemMeta();
		    statslogsreport.setDisplayName("§aLogs Report §7:");
		    ArrayList<String> logsreportlore = new ArrayList();
		    logsreportlore.add("");
		    logsreportlore.add("§7§llogs du joueur "+mp.getName());
		    logsreportlore.add("");
		    statslogsreport.setLore(logsreportlore);
		    logsreport.setItemMeta(statslogsreport);
		    

			   inv1.setItem(8, logsreport);
			   inv1.setItem(1, logsminerais);
			   inv1.setItem(0, logs);
		    
		    p.openInventory(inv1);
	  }
}
