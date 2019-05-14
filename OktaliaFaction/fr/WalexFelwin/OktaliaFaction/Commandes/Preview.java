package fr.WalexFelwin.OktaliaFaction.Commandes;

import fr.WalexFelwin.OktaliaFaction.Inventaire.PreviewALL.Legionnaire;
import fr.WalexFelwin.OktaliaFaction.Inventaire.PreviewALL.Maitre;
import fr.WalexFelwin.OktaliaFaction.Inventaire.PreviewALL.Monarque;
import fr.WalexFelwin.OktaliaFaction.Inventaire.PreviewALL.VIP;
import fr.WalexFelwin.OktaliaFaction.Inventaire.PreviewALL.VIPPLUS;
import fr.WalexFelwin.OktaliaFaction.Inventaire.PreviewALL.Voyageur;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Preview
  implements CommandExecutor
{
  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
  {
    Player p = (Player)sender;
    if (!(sender instanceof Player)) {
      return false;
    }
    if ((args.length == 0) || (args.length > 1))
    {
      p.sendMessage("§6/§epreview §7(§fVoyageur,Legionnaire,Maitre,Monarque,Vip,Vipplus§7)");
    }
    else
    {
      if (args[0].equalsIgnoreCase("voyageur")) {
        Voyageur.VoyageurPreview(p);
      }
      if (args[0].equalsIgnoreCase("legionnaire")) {
        Legionnaire.LegionnairePreview(p);
      }
      if (args[0].equalsIgnoreCase("maitre")) {
        Maitre.MaitrePreview(p);
      }
      if (args[0].equalsIgnoreCase("monarque")) {
        Monarque.MonarquePreview(p);
      }
      if (args[0].equalsIgnoreCase("vip")) {
        VIP.VIPPreview(p);
      }
      if (args[0].equalsIgnoreCase("vipplus")) {
        VIPPLUS.VIPPLUSPreview(p);
      }
    }
    return false;
  }
}
