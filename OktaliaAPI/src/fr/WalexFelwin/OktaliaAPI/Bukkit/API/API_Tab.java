package fr.WalexFelwin.OktaliaAPI.Bukkit.API;

import java.lang.reflect.Field;

import net.minecraft.server.v1_8_R3.IChatBaseComponent;
import net.minecraft.server.v1_8_R3.PacketPlayOutPlayerListHeaderFooter;

import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;

public class API_Tab {
	 public static void setPlayerList(Player player, String header, String footer)
	  {
	    IChatBaseComponent hj = IChatBaseComponent.ChatSerializer.a("{\"text\": \"" + header + "\"}");
	    IChatBaseComponent fj = IChatBaseComponent.ChatSerializer.a("{\"text\": \"" + footer + "\"}");
	    PacketPlayOutPlayerListHeaderFooter packet = (PacketPlayOutPlayerListHeaderFooter)constructHeaderAndFooterPacket(hj, fj);
	    ((CraftPlayer)player).getHandle().playerConnection.sendPacket(packet);
	  }
	  
	  private static Object constructHeaderAndFooterPacket(Object header, Object footer)
	  {
	    try
	    {
	      Object packet = PacketPlayOutPlayerListHeaderFooter.class.newInstance();
	      if (header != null)
	      {
	        Field field = PacketPlayOutPlayerListHeaderFooter.class.getDeclaredField("a");
	        field.setAccessible(true);
	        field.set(packet, header);
	        field.setAccessible(false);
	      }
	      if (footer != null)
	      {
	        Field field = PacketPlayOutPlayerListHeaderFooter.class.getDeclaredField("b");
	        field.setAccessible(true);
	        field.set(packet, footer);
	        field.setAccessible(false);
	      }
	      return packet;
	    }
	    catch (InstantiationException|IllegalAccessException|NoSuchFieldException e)
	    {
	      e.printStackTrace();
	    }
	    return null;
	  }
}
