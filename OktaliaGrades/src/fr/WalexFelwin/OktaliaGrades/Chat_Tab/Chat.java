package fr.WalexFelwin.OktaliaGrades.Chat_Tab;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import fr.WalexFelwin.OktaliaAPI.Bukkit.Utils.HASHMAP;

public class Chat {

	  public static String name;
	  
	  public static void sendchatmessage(String name, Player p, String msg){
			

	    String changemessage = ChatUtils.getpreffix(p) + name + " §f: " + msg;
	    
	    for (Player pls : Bukkit.getOnlinePlayers()) {
	    	
	    	if(msg.contains(pls.getName()) && p != pls) {

	    		String msg2 = msg;
	    		String msgn = msg2.replace(pls.getName(), "§9@"+pls.getName());
	    		String newmsg = changemessage.replace(msg, msgn);

	  	      pls.sendMessage(newmsg);
	    	} else {

	  	      pls.sendMessage(changemessage);
	    	}
	    	
	    }
	    
	    System.out.println("[Chat] " + p.getName() + " : " + msg);
	  
	 /*else if (grades.equalsIgnoreCase("admin"))
	  {
	    String changemessage = ChatUtils.getadminprefix() + name + " §f: " + msg;
	    for (Player pls : Bukkit.getOnlinePlayers()) {
	    	
	    	if(msg.contains(pls.getName()) && p != pls) {

	    		String msg2 = msg;
	    		String msgn = msg2.replace(pls.getName(), "§9@"+pls.getName());
	    		String newmsg = changemessage.replace(msg, msgn);

	  	      pls.sendMessage(newmsg);
	    	} else {

	  	      pls.sendMessage(changemessage);
	    	}
	    	
	    }
	    System.out.println("[Chat] " + p.getName() + " : " + msg);
	  }
	  else if (grades.equalsIgnoreCase("gerant"))
	  {
	    String changemessage =  ChatUtils.getgerantprefix() + name + " §f: " + msg;
	    for (Player pls : Bukkit.getOnlinePlayers()) {
	      pls.sendMessage(changemessage);
	    }
	    System.out.println("[Chat] " + p.getName() + " : " + msg);
	  }
	  else if (grades.equalsIgnoreCase("manager"))
	  {
	    String changemessage =  ChatUtils.getmanagerprefix() + name + " §f: " + msg;
	    for (Player pls : Bukkit.getOnlinePlayers()) {
	      pls.sendMessage(changemessage);
	    }
	    System.out.println("[Chat] " + p.getName() + " : " + msg);
	  }
	  else if (grades.equalsIgnoreCase("moderateur"))
	  {
	    String changemessage =  ChatUtils.getmodoprefix() + name + " §f: " + msg;
	    for (Player pls : Bukkit.getOnlinePlayers()) {
	      pls.sendMessage(changemessage);
	    }
	    System.out.println("[Chat] " + p.getName() + " : " + msg);
	  }
	  else if (grades.equalsIgnoreCase("moderatrice"))
	  {
	    String changemessage =  ChatUtils.getmodaprefix() + name + " §f: " + msg;
	    for (Player pls : Bukkit.getOnlinePlayers()) {
	      pls.sendMessage(changemessage);
	    }
	    System.out.println("[Chat] " + p.getName() + " : " + msg);
	  }
	  else if (grades.equalsIgnoreCase("buildeur"))
	  {
	    String changemessage =  ChatUtils.builderprefix() + name + " §f: " + msg;
	    for (Player pls : Bukkit.getOnlinePlayers()) {
	      pls.sendMessage(changemessage);
	    }
	    System.out.println("[Chat] " + p.getName() + " : " + msg);
	  }
	  else if (grades.contains("youtubeur"))
	  {
	    String changemessage =  ChatUtils.getyoutubeurprefix() + name + " §f: " + msg;
	    for (Player pls : Bukkit.getOnlinePlayers()) {
	      pls.sendMessage(changemessage);
	    }
	    System.out.println("[Chat] " + p.getName() + " : " + msg);
	  }
	  else if (grades.equalsIgnoreCase("ami"))
	  {
	    String changemessage =  ChatUtils.amiprefix() + name + " §f: " + msg;
	    for (Player pls : Bukkit.getOnlinePlayers()) {
	      pls.sendMessage(changemessage);
	    }
	    System.out.println("[Chat] " + p.getName() + " : " + msg);
	  }
	  else if (grades.equalsIgnoreCase("vip"))
	  {
	    String changemessage =  ChatUtils.getVIPprefix() + name + " §f: " + msg;
	    for (Player pls : Bukkit.getOnlinePlayers()) {
	      pls.sendMessage(changemessage);
	    }
	    System.out.println("[Chat] " + p.getName() + " : " + msg);
	  }
	  else if (grades.equalsIgnoreCase("vip+"))
	  {
	    String changemessage =  ChatUtils.getVIPPlusprefix() + name + " §f: " + msg;
	    for (Player pls : Bukkit.getOnlinePlayers()) {
	      pls.sendMessage(changemessage);
	    }
	    System.out.println("[Chat] " + p.getName() + " : " + msg);
	  }
	  else if (grades.equalsIgnoreCase("monarque"))
	  {
	    String changemessage =  ChatUtils.getmonarqueprefix() + name + " §f: " + msg;
	    for (Player pls : Bukkit.getOnlinePlayers()) {
	      pls.sendMessage(changemessage);
	    }
	    System.out.println("[Chat] " + p.getName() + " : " + msg);
	  }
	  else if (grades.equalsIgnoreCase("maitre"))
	  {
	    String changemessage =  ChatUtils.getMaitreprefix() + name + " §f: " + msg;
	    for (Player pls : Bukkit.getOnlinePlayers()) {
	      pls.sendMessage(changemessage);
	    }
	    System.out.println("[Chat] " + p.getName() + " : " + msg);
	  }
	  else if (grades.equalsIgnoreCase("legionnaire"))
	  {
	    String changemessage =  ChatUtils.getLegionnaireprefix() + name + " §f: " + msg;
	    for (Player pls : Bukkit.getOnlinePlayers()) {
	      pls.sendMessage(changemessage);
	    }
	    System.out.println("[Chat] " + p.getName() + " : " + msg);
	  }
	  else if (grades.equalsIgnoreCase("voyageur"))
	  {
	    String changemessage =  ChatUtils.getVoyageurprefix() + name + " §f: " + msg;
	    for (Player pls : Bukkit.getOnlinePlayers()) {
	      pls.sendMessage(changemessage);
	    }
	    System.out.println("[Chat] " + p.getName() + " : " + msg);
	  }
	  else
	  {
	    String changemessage = "§7" + name + " §7: " + msg;
	    for (Player pls : Bukkit.getOnlinePlayers()) {
	      pls.sendMessage(changemessage);
	    }
	    System.out.println("[Chat] " + p.getName() + " : " + msg);
	  }
	  }*/
	  }
}
