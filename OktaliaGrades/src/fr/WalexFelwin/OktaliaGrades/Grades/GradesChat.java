package fr.WalexFelwin.OktaliaGrades.Grades;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import fr.WalexFelwin.OktaliaAPI.Bukkit.API.API_OktaCoins;
import fr.WalexFelwin.OktaliaAPI.Bukkit.API.API_Title;
import fr.WalexFelwin.OktaliaGrades.Main;

import net.minecraft.server.v1_8_R3.IChatBaseComponent;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import net.minecraft.server.v1_8_R3.PacketPlayOutChat;
import net.minecraft.server.v1_8_R3.PacketPlayOutTitle;
import net.minecraft.server.v1_8_R3.PlayerConnection;

public class GradesChat implements Listener{

	
	public GradesChat(Main main) {
		// TODO Auto-generated constructor stub
	}
	
    public static void sendTitle(Player player, Integer fadeIn, Integer stay, Integer fadeOut, String title, String subtitle){
    PlayerConnection connection = ((CraftPlayer)player).getHandle().playerConnection;
    
    PacketPlayOutTitle packetPlayOutTimes = new PacketPlayOutTitle(PacketPlayOutTitle.EnumTitleAction.TIMES, null, fadeIn.intValue(), stay.intValue(), fadeOut.intValue());
    connection.sendPacket(packetPlayOutTimes);
    if (subtitle != null)
    {
      subtitle = subtitle.replaceAll("%player%", player.getDisplayName());
      subtitle = ChatColor.translateAlternateColorCodes('&', subtitle);
      IChatBaseComponent titleSub = IChatBaseComponent.ChatSerializer.a("{\"text\": \"" + subtitle + "\"}");
      PacketPlayOutTitle packetPlayOutSubTitle = new PacketPlayOutTitle(PacketPlayOutTitle.EnumTitleAction.SUBTITLE, titleSub);
      connection.sendPacket(packetPlayOutSubTitle);
    }
    if (title != null)
    {
      title = title.replaceAll("%player%", player.getDisplayName());
      title = ChatColor.translateAlternateColorCodes('&', title);
      IChatBaseComponent titleMain = IChatBaseComponent.ChatSerializer.a("{\"text\": \"" + title + "\"}");
      PacketPlayOutTitle packetPlayOutTitle = new PacketPlayOutTitle(PacketPlayOutTitle.EnumTitleAction.TITLE, titleMain);
      connection.sendPacket(packetPlayOutTitle);
    }
  }
    
	@EventHandler
	public void Chat(AsyncPlayerChatEvent e){
		Player p = e.getPlayer();
		
		if(Bukkit.getServer().getPluginManager().getPlugin("OktaliaHDV") !=null) {
			
			if(me.zombie_striker.npcauctions.Main.auctionWaitingMap.containsKey(p.getUniqueId()) ||  me.zombie_striker.npcauctions.Main.auctionWaitingStage.containsKey(p.getUniqueId()) ) {
				
				return;
			}
		}
		
		fr.WalexFelwin.OktaliaGrades.Chat_Tab.Chat.sendchatmessage(p.getName(), p, e.getMessage());

        for (Player o : Bukkit.getOnlinePlayers()) {
            
        if(e.getMessage().contains(o.getName()) && p != o){

			o.playSound(o.getLocation(), Sound.SUCCESSFUL_HIT, 100.0F, 1.0F);
			
			
            sendTitle(o, 0, 30, 0, "", "§e"+p.getName()+" §avous a notifié dans le chat !");

			
        }
        
        }

     	  e.setMessage(null);
     	  e.setCancelled(true);
     	  
	}
}
