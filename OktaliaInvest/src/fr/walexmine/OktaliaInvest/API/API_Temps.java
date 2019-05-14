package fr.walexmine.OktaliaInvest.API;


import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;
import fr.walexmine.OktaliaInvest.Event.PlayerMove;
import net.minecraft.server.v1_8_R3.IChatBaseComponent;
import net.minecraft.server.v1_8_R3.PacketPlayOutTitle;

public class API_Temps {
	  

	
	  public static String getRemainingTime(Player p)
	  {
		  

			long timeco = Long.parseLong(PlayerMove.TimeStart.get(p));
			long timenow = System.currentTimeMillis();

			long timetoend = System.currentTimeMillis() + Long.parseLong(PlayerMove.TimeEND.get(p));
			
			
			long timesession = timenow - timeco;
			
			long newtimeBDD = 0;
		  
			if(PlayerMove.TimetoSave.containsKey(p)) {
				
				long timeh = Long.parseLong(PlayerMove.TimetoSave.get(p));

				newtimeBDD = timesession + timeh;
				
			} else {
				
				
				newtimeBDD = timesession;
				
				
			}
		  
	    String remainingTime = "";
	      long a = newtimeBDD + System.currentTimeMillis();
	      long difference =  Long.parseLong(PlayerMove.TimeEND.get(p)) - newtimeBDD;
		//    p.sendMessage("NEWTI "+a+"");
	      if(difference < 0 ) {
	    	  

	    	  PlayerMove.Invest.put(p, "NULL");
	    	  PlayerMove.TimeEND.put(p, "0");
	    	  PlayerMove.TimeStart.put(p, "0");
	    	  PlayerMove.TimetoSave.remove(p);
	    	  
	    	  
	    	  return "end";
	    	  
	      }
	      int seconds = 0;
	      int minutes = 0;
	      int hours = 0;
	      int days = 0;
	      int weeks = 0;
	      while (difference >= 1000L)
	      {
	        difference -= 1000L;
	        seconds++;
	      }
	      while (seconds >= 60)
	      {
	        seconds -= 60;
	        minutes++;
	      }
	      while (minutes >= 60)
	      {
	        minutes -= 60;
	        hours++;
	      }
	      while (hours >= 24)
	      {
	        hours -= 24;
	        days++;
	      }
	      while (days >= 7)
	      {
	        days -= 7;
	        weeks++;
	      }
	      remainingTime = 
	        "§e" + days + " Jour(s), " + hours + " heure(s), " + minutes + " minutes(s) et " + seconds + " secondes.";
	    
	      if(days == 0) {
	    	  remainingTime = remainingTime.replace("§e" + days +" Jour(s),", "");
	      } if(hours == 0) {
	     	  remainingTime = remainingTime.replace(" " + hours +" heure(s),", "");
	      } if(minutes == 0) {
	     	  remainingTime = remainingTime.replace(" " + minutes +" minutes(s) et", "");
	      }
	    return remainingTime;
	}
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
	  
}
