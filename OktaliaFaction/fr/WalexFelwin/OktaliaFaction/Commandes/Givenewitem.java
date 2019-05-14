package fr.WalexFelwin.OktaliaFaction.Commandes;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.ItemMeta;

public class Givenewitem
  implements CommandExecutor
{
  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
  {
    Player p = (Player)sender;
    if (p.isOp())
    {
      if (args.length == 1) {
        if (args[0].equalsIgnoreCase("replanteuse"))
        {
          ItemStack replanteuse = new ItemStack(Material.SHEARS);
          ItemMeta replanteusemeta = replanteuse.getItemMeta();
          replanteusemeta.setDisplayName("§9§lReplanteuse");
          replanteuse.setItemMeta(replanteusemeta);
          p.getInventory().addItem(new ItemStack[] { replanteuse });
        }
        else if (args[0].equalsIgnoreCase("voyageur"))
        {
          ItemStack kitvoyageur = new ItemStack(Material.BOOK);
          ItemMeta kitvoyageurmeta = kitvoyageur.getItemMeta();
          kitvoyageurmeta.setDisplayName("§7§lKit §2§lVoyageur");
          kitvoyageur.setItemMeta(kitvoyageurmeta);
          p.getInventory().addItem(new ItemStack[] { kitvoyageur });
        }
        else if (args[0].equalsIgnoreCase("legionnaire"))
        {
          ItemStack kitvoyageur = new ItemStack(Material.BOOK);
          ItemMeta kitvoyageurmeta = kitvoyageur.getItemMeta();
          kitvoyageurmeta.setDisplayName("§7§lKit §b§lLegionnaire");
          kitvoyageur.setItemMeta(kitvoyageurmeta);
          p.getInventory().addItem(new ItemStack[] { kitvoyageur });
        }
        else if (args[0].equalsIgnoreCase("maitre"))
        {
          ItemStack kitvoyageur = new ItemStack(Material.BOOK);
          ItemMeta kitvoyageurmeta = kitvoyageur.getItemMeta();
          kitvoyageurmeta.setDisplayName("§7§lKit §6§lMaitre");
          kitvoyageur.setItemMeta(kitvoyageurmeta);
          p.getInventory().addItem(new ItemStack[] { kitvoyageur });
        }
        else if (args[0].equalsIgnoreCase("monarque"))
        {
          ItemStack kitvoyageur = new ItemStack(Material.BOOK);
          ItemMeta kitvoyageurmeta = kitvoyageur.getItemMeta();
          kitvoyageurmeta.setDisplayName("§7§lKit §9§lMonarque");
          kitvoyageur.setItemMeta(kitvoyageurmeta);
          p.getInventory().addItem(new ItemStack[] { kitvoyageur });
        }
        else if (args[0].equalsIgnoreCase("vip"))
        {
          ItemStack kitvoyageur = new ItemStack(Material.BOOK);
          ItemMeta kitvoyageurmeta = kitvoyageur.getItemMeta();
          kitvoyageurmeta.setDisplayName("§7§lKit §b§lVIP");
          kitvoyageur.setItemMeta(kitvoyageurmeta);
          p.getInventory().addItem(new ItemStack[] { kitvoyageur });
        }
        else if (args[0].equalsIgnoreCase("vipplus"))
        {
          ItemStack kitvoyageur = new ItemStack(Material.BOOK);
          ItemMeta kitvoyageurmeta = kitvoyageur.getItemMeta();
          kitvoyageurmeta.setDisplayName("§7§lKit §e§lVIP+");
          kitvoyageur.setItemMeta(kitvoyageurmeta);
          p.getInventory().addItem(new ItemStack[] { kitvoyageur });
        }
        else if (args[0].equalsIgnoreCase("hachelegendaire"))
        {
          ItemStack kitvoyageur = new ItemStack(Material.DIAMOND_AXE);
          ItemMeta kitvoyageurmeta = kitvoyageur.getItemMeta();
          kitvoyageurmeta.setDisplayName("§7§lHache §2§lLégendaire");
          kitvoyageurmeta.addEnchant(Enchantment.DAMAGE_ALL, 7, true);
          kitvoyageur.setItemMeta(kitvoyageurmeta);
          p.getInventory().addItem(new ItemStack[] { kitvoyageur });
        }
        else
        {
          p.sendMessage("/giveitem (replanteuse,voyageur,legionnaire,maitre,monarque,vip,vipplus)");
        }
      }
    }
    else {
      p.sendMessage("/giveitem (replanteuse,voyageur,legionnaire,maitre,monarque,vip,vipplus)");
    }
    return false;
  }
}
