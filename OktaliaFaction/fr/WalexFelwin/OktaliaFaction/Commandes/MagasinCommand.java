package fr.WalexFelwin.OktaliaFaction.Commandes;

import fr.WalexFelwin.OktaliaFaction.Inventaire.Magasin;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class MagasinCommand
  implements CommandExecutor
{
  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
  {
    Player p = (Player)sender;
    
    Magasin.MagasinAll(p);
    return false;
  }
}
