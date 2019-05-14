package fr.WalexFelwin.OktaliaAPI.Bukkit.API;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import net.minecraft.server.v1_8_R3.IChatBaseComponent;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import net.minecraft.server.v1_8_R3.PacketPlayOutChat;
import net.minecraft.server.v1_8_R3.PacketPlayOutTitle;
import net.minecraft.server.v1_8_R3.PlayerConnection;

public class API_Title {  
	
public static void sendTitle(Player player, String msgTitle, String msgSubTitle, int ticks)
  {
    IChatBaseComponent chatTitle = IChatBaseComponent.ChatSerializer.a("{\"text\": \"" + msgTitle + "\"}");
    IChatBaseComponent chatSubTitle = IChatBaseComponent.ChatSerializer.a("{\"text\": \"" + msgSubTitle + "\"}");
    PacketPlayOutTitle p = new PacketPlayOutTitle(PacketPlayOutTitle.EnumTitleAction.TITLE, chatTitle);
    PacketPlayOutTitle p2 = new PacketPlayOutTitle(PacketPlayOutTitle.EnumTitleAction.SUBTITLE, chatSubTitle);
    ((CraftPlayer)player).getHandle().playerConnection.sendPacket(p);
    ((CraftPlayer)player).getHandle().playerConnection.sendPacket(p2);
    sendTime(player, ticks);
  }
  
  private static void sendTime(Player player, int ticks)
  {
    PacketPlayOutTitle p = new PacketPlayOutTitle(PacketPlayOutTitle.EnumTitleAction.TIMES, null, 20, ticks, 20);
    ((CraftPlayer)player).getHandle().playerConnection.sendPacket(p);
  }
  
  public static void sendActionBar(Player player, String message)
  {
    IChatBaseComponent cbc = IChatBaseComponent.ChatSerializer.a("{\"text\": \"" + message + "\"}");
    PacketPlayOutChat ppoc = new PacketPlayOutChat(cbc, (byte)2);
    ((CraftPlayer)player).getHandle().playerConnection.sendPacket(ppoc);
  }

  
  public static void sendActionBarTime(final Player player, final String message, int ticks)
  {
	    sendActionBar(player, message);
	    if (ticks >= 0) {
	      new BukkitRunnable()
	      {
	        public void run()
	        {
	          sendActionBar(player, message);
	        }
	      }.runTaskLater(Bukkit.getPluginManager().getPlugin("OktaliaAPI"), ticks + 1);
	    }
	    while (ticks > 60)
	    {
	    	ticks -= 60;
	      int sched = ticks % 60;
	      new BukkitRunnable()
	      {
	        public void run()
	        {
	          sendActionBar(player, message);
	        }
	      }.runTaskLater(Bukkit.getPluginManager().getPlugin("OktaliaAPI"), sched);
	    }
  }

  
  public static void sendTitleTime(Player player, Integer fadeIn, Integer stay, Integer fadeOut, String title, String subtitle){
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
  
}
