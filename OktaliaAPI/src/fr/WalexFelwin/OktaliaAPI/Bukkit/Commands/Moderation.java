package fr.WalexFelwin.OktaliaAPI.Bukkit.Commands;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.SystemMenuBar;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;

import fr.WalexFelwin.OktaliaAPI.Bukkit.Main;
import fr.WalexFelwin.OktaliaAPI.Bukkit.MySQLConnection;
import fr.WalexFelwin.OktaliaAPI.Bukkit.Inventory.InventoryPlayerMod�ration;
import fr.WalexFelwin.OktaliaAPI.Bukkit.Inventory.Permission;
import fr.WalexFelwin.OktaliaAPI.Bukkit.Inventory.Syst�meMod�ration.HotBarItem;
import fr.WalexFelwin.OktaliaAPI.Bukkit.Utils.Message;
import fr.WalexFelwin.OktaliaAPI.BungeeCord.MySQL;


public class Moderation implements CommandExecutor{

	  public static HashMap<Player, Player> playermodo = new HashMap();
	

	  public static HashMap<Player, Inventory> Syst�meModo = new HashMap();
	
	  
	  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
	  {
	    Player p = (Player)sender;
	    
	    
	    if (label.equalsIgnoreCase("systemmodo"))
	    {
	    	if(p.hasPermission("perm.moderation")){
	    		
	    		if(args.length == 0){
	    			
	    			
	    			if(Syst�meModo.containsKey(p)){
	    			p.sendMessage("�cLe syst�me de mod�ration a �t� d�sactiv�e !");
	    			p.getInventory().clear();
	    			
	    			Syst�meModo.remove(p);
	    			} else {
	    				
	    				p.sendMessage("�aLe syst�me de mod�ration a �t� activ�e");
	    				HotBarItem.itemmod�ration(p);
	    				Syst�meModo.put(p, p.getInventory());
	    			}
	    		}
	    		
	    		
	    		if(args.length >= 1){
	    			p.sendMessage("");
	    		}
	    	} else {
	    		Message.RETURNNOPERMISSION(p);
	    	}
	    	
	    }
	    if (label.equalsIgnoreCase("permission"))
	    {
	    	if(p.hasPermission("perm.respmodo")){
	    	
	      	if(args.length == 0){
	    		sender.sendMessage("�a/permission <joueur> �e| Syst�me de permission pour les r�sponsables mod�rateurs");
	    	}

	      	if(args.length == 1){
	      		
	      		Player mp = p.getServer().getPlayer(args[0]);
	      		
	      		 
	      	if(mp == null){
  			  
  			  p.sendMessage(Message.PLAYERNULL_MESSAGE);
  			  return false;
  		  }    try {
  			
  			
  			  PreparedStatement preparedStatement = Main.conn.prepareStatement("SELECT id FROM InfoPerm WHERE UUID = ?");
  			preparedStatement.setString(1, mp.getUniqueId().toString());
  			
  			ResultSet rs = preparedStatement.executeQuery();
  			if(!rs.next()) {
  				preparedStatement.close();
  				preparedStatement = Main.conn.prepareStatement("INSERT INTO InfoPerm (UUID, Pseudo, BAN, TEMPBAN, MUTE, TEMPMUTE, CHATSTAFF, BROADCAST, KICK) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)");
  				preparedStatement.setString(1, mp.getUniqueId().toString());
  				preparedStatement.setString(2, mp.getName());
  				preparedStatement.setString(3, "FALSE");
  				preparedStatement.setString(4, "FALSE");
  				preparedStatement.setString(5, "FALSE");
  				preparedStatement.setString(6, "FALSE");
  				preparedStatement.setString(7, "FALSE");
  				preparedStatement.setString(8, "FALSE");
  				preparedStatement.setString(9, "FALSE");
  				preparedStatement.executeUpdate();
  		        
  				preparedStatement.close();
  			}
  			
  			
  		} catch (SQLException e1) {
  			e1.printStackTrace();
  			MySQLConnection.openConnection();
  		}
	      Permission.InventaireServeur(p, mp);
	      	}}
	    }
	    if (label.equalsIgnoreCase("modo"))
	    {
	    	if(p.hasPermission("perm.moderation")){
	    		
	    	
	    	if(args.length == 0){
	    		sender.sendMessage("�a/modo <joueur> �e| Syst�me de mod�ration server");
	    	}
	    	
	    	if(args.length == 1){
	    		
	    		  Player target = p.getServer().getPlayer(args[0]);
	    		  
	    		  if(target == null){
	    			  
	    			  p.sendMessage(Message.PLAYERNULL_MESSAGE);
	    			  return false;
	    		  }
	    		  /*
	    		  if(p == target){
	    			  
	    			  p.sendMessage("");
	    			  return false;
	    		  }*/
	    	InventoryPlayerMod�ration.InventoryMod�ration(p, target);
	    	
	    	if(playermodo.containsKey(p)){
	    	playermodo.remove(p);
	    	playermodo.put(p, target);
	    	} else {
	    	playermodo.put(p, target);
	    	}
	    	
	    	}
	    	
	    	if(args.length >= 2){
	    		sender.sendMessage("�a/modo <joueur> �e| Syst�me de mod�ration server");
	    	}
	    	
	    	} else {
	    		
	    		sender.sendMessage(Message.PERMISSION_MESSAGE);
	    		
	    	}
	            
	    }
	  
	        
	        
	        
	    
	    
	
	  return true;
	  }

}
