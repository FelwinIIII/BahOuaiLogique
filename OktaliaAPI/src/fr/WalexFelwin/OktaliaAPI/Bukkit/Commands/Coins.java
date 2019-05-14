package fr.WalexFelwin.OktaliaAPI.Bukkit.Commands;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.WalexFelwin.OktaliaAPI.Bukkit.API.API_OktaCoins;
import fr.WalexFelwin.OktaliaAPI.Bukkit.API.API_Redirect;
import fr.WalexFelwin.OktaliaAPI.Bukkit.Utils.COINS;
import fr.WalexFelwin.OktaliaAPI.Bukkit.Utils.HASHMAP;


public class Coins implements CommandExecutor{
	

	 
	  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
	  {
		  
	  
		  if (label.equalsIgnoreCase("pay"))
		    {
	    	   
	    	   if(sender instanceof Player) {


	    	Player p = (Player)sender;
		    	   

	    	    
	    	    if (args.length == 2)
			      {
	    	    	

			          Player target = sender.getServer().getPlayer(args[0]);
	    	    	
			          if(!target.isOnline()) {
		    	    	p.sendMessage("§cLe joueur n'est pas connectée");
			          }

		        	  float c = Float.parseFloat(args[1]);
	    	    	
		        	  COINS.removeoktacoins(p, c);
		        	  COINS.addoktacoins(target, c);
		        	  
		        	  p.sendMessage("Vous avez bien donnée "+c+" au joueur "+target.getName());
		        	  
			      } else {

		    	    	p.sendMessage("§a/pay <joueur> <OktaCoins>");
			      }
	    	    	
	    	   }
			  
		    }
		  
	    if (label.equalsIgnoreCase("coins")||label.equalsIgnoreCase("money")||label.equalsIgnoreCase("coin"))
	    {                  
	    	
    	    if (args.length == 0)
		      {
    	    	
    	    	   Player p = (Player)sender;
   	    	    
 		          p.sendMessage("§7§lInfo COINS: §a§l"+p.getName());
 		          p.sendMessage("§aOktaCoins: §e"+ COINS.getoktacoins(p) + "$ §7§l| §6§lGolds: §b"+ COINS.getBoutiquecoins(p));
 		          


		      }
	    	
	    	
	    	if(sender.hasPermission("perm.admin")||sender.hasPermission("perm.owner")||sender.isOp()){
	    		

			      
			      if (sender.hasPermission("perm.coins"))
			      {
			    	    if (args.length == 1)
					      {
			         if (args[0].equalsIgnoreCase("help"))
			        {
				            sender.sendMessage("");
				            sender.sendMessage("§e§lCOINS §7| §cHelp");
				            sender.sendMessage("§7---------------------------------------------");
				            sender.sendMessage("§a/coins add <type> <joueur> <nombre>");
				            sender.sendMessage("§a/coins get <joueur>");
				            sender.sendMessage("§a/coins set <type> <joueur> <nombre>");
				            sender.sendMessage("§a/coins remove <type> <joueur> <nombre>");
				            sender.sendMessage("§eType: §5okta, golds");
				            sender.sendMessage("§7---------------------------------------------");
			        }
			        
					      }
			    	    
			        if ((args.length == 2) && 
			          (args[0].equalsIgnoreCase("get")))
			        {
				          Player target = sender.getServer().getPlayer(args[1]);

			            if(target == null) {

					          String uuid = API_OktaCoins.getuuid(args[1]);
				            
					          sender.sendMessage("§7§lInfo COINS: §a§l"+args[1]);
					          sender.sendMessage("§aOktaCoins: §e"+ API_OktaCoins.getoktacoinsof(uuid) + "$ §7§l| §6§lGolds: §b"+ API_OktaCoins.getBoutiquecoinsof(uuid));
			            } else {
			            	
			            
			          sender.sendMessage("§7§lInfo COINS: §a§l"+target.getName());
			          sender.sendMessage("§aOktaCoins: §e"+ COINS.getoktacoins(target) + "$ §7§l| §6§lGolds: §b"+ COINS.getBoutiquecoins(target));
			            }
			            
			        }
			        
			        
			        if (args.length == 4)
			        {
			        
			            

			            Player target = sender.getServer().getPlayer(args[2]);
			            String type = args[1];
			            
			            if(target == null) {
				             
					          if (args[0].equalsIgnoreCase("add"))
					          {
					        	  
					        	if(type.equalsIgnoreCase("Okta")) {
					        		
					            float c = Float.parseFloat(args[3]);
					            ByteArrayOutputStream b = new ByteArrayOutputStream();
						        DataOutputStream out = new DataOutputStream(b);
								
								
								try {
									out.writeUTF("Coins");
									out.writeUTF(args[2]);
									out.writeUTF("ADD");
									out.writeFloat(c);
									
								} catch (IOException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
								Bukkit.getServer().sendPluginMessage(Bukkit.getPluginManager().getPlugin("OktaliaAPI"), "BungeeInterconnect", b.toByteArray());
								
								
					        	} 	else if(type.equalsIgnoreCase("Golds")) {
					        		
						            float c = Float.parseFloat(args[3]);
						            ByteArrayOutputStream b = new ByteArrayOutputStream();
							        DataOutputStream out = new DataOutputStream(b);
									
									
									try {
										out.writeUTF("Golds");
										out.writeUTF(args[2]);
										out.writeUTF("ADD");
										out.writeFloat(c);
										
									} catch (IOException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
									Bukkit.getServer().sendPluginMessage(Bukkit.getPluginManager().getPlugin("OktaliaAPI"), "BungeeInterconnect", b.toByteArray());
					        		
					        	}
					          }
					        	  
					          
					          if (args[0].equalsIgnoreCase("set"))
					          {
						        	if(type.equalsIgnoreCase("Okta")) {
						        		
							            float c = Float.parseFloat(args[3]);
							            ByteArrayOutputStream b = new ByteArrayOutputStream();
								        DataOutputStream out = new DataOutputStream(b);
										
										
										try {
											out.writeUTF("Coins");
											out.writeUTF(args[2]);
											out.writeUTF("SET");
											out.writeFloat(c);
											
										} catch (IOException e) {
											// TODO Auto-generated catch block
											e.printStackTrace();
										}
										Bukkit.getServer().sendPluginMessage(Bukkit.getPluginManager().getPlugin("OktaliaAPI"), "BungeeInterconnect", b.toByteArray());
										
										
							        	} 	else if(type.equalsIgnoreCase("Golds")) {
							        		
								            float c = Float.parseFloat(args[3]);
								            ByteArrayOutputStream b = new ByteArrayOutputStream();
									        DataOutputStream out = new DataOutputStream(b);
											
											
											try {
												out.writeUTF("Golds");
												out.writeUTF(args[2]);
												out.writeUTF("SET");
												out.writeFloat(c);
												
											} catch (IOException e) {
												// TODO Auto-generated catch block
												e.printStackTrace();
											}
											Bukkit.getServer().sendPluginMessage(Bukkit.getPluginManager().getPlugin("OktaliaAPI"), "BungeeInterconnect", b.toByteArray());
							        		
							        	}
					          }					          
					          if (args[0].equalsIgnoreCase("remove"))
					          {
						        	if(type.equalsIgnoreCase("Okta")) {
						        		
							            float c = Float.parseFloat(args[3]);
							            ByteArrayOutputStream b = new ByteArrayOutputStream();
								        DataOutputStream out = new DataOutputStream(b);
										
										
										try {
											out.writeUTF("Coins");
											out.writeUTF(args[2]);
											out.writeUTF("REMOVE");
											out.writeFloat(c);
											
										} catch (IOException e) {
											// TODO Auto-generated catch block
											e.printStackTrace();
										}
										Bukkit.getServer().sendPluginMessage(Bukkit.getPluginManager().getPlugin("OktaliaAPI"), "BungeeInterconnect", b.toByteArray());
										
										
							        	} 	else if(type.equalsIgnoreCase("Golds")) {
							        		
								            float c = Float.parseFloat(args[3]);
								            ByteArrayOutputStream b = new ByteArrayOutputStream();
									        DataOutputStream out = new DataOutputStream(b);
											
											
											try {
												out.writeUTF("Golds");
												out.writeUTF(args[2]);
												out.writeUTF("REMOVE");
												out.writeFloat(c);
												
											} catch (IOException e) {
												// TODO Auto-generated catch block
												e.printStackTrace();
											}
											Bukkit.getServer().sendPluginMessage(Bukkit.getPluginManager().getPlugin("OktaliaAPI"), "BungeeInterconnect", b.toByteArray());
							        	}
							        	}
			            	return false;
			            }
			            
			            
			          if (args[0].equalsIgnoreCase("add"))
			          {
			        	  

				        if(type.contains("Okta") || type.contains("okta")) {

				            float c = Float.parseFloat(args[3]);
				           	COINS.addoktacoins(target, c);
				            sender.sendMessage( "§aTu as ajouté " + c + " oktaCoins au compte de " + target.getName());
				        	
			        	} 	else if(type.contains("Golds") || type.contains("golds")) {
			        		
				            float c = Float.parseFloat(args[3]);
				           	COINS.addBoutiquecoins(target, c);
				            sender.sendMessage( "§aTu as ajouté " + c + " Golds au compte de " + target.getName());
			        		
				        }

			            
			          }
			          if (args[0].equalsIgnoreCase("set"))
			          {
			        	  
			          
					        if(type.contains("Okta") || type.contains("okta")) {

			        	  float c = Float.parseFloat(args[3]);

				           	COINS.setoktacoins(target, c);
			            sender.sendMessage( "§aVous avez défini " + c + " oktaCoins au compte de " + target.getName());
			
				        	} 	else if(type.contains("Golds") || type.contains("golds")) {
			        		

				        	  float c = Float.parseFloat(args[3]);

					           	COINS.setBoutiquecoins(target, c);
				            sender.sendMessage( "§aVous avez défini " + c + " Golds au compte de " + target.getName());
			        		
			        	}
			            
			          }
			          if (args[0].equalsIgnoreCase("remove"))
			          {
			        	  

					        if(type.contains("Okta") || type.contains("okta")) {
					        	
					        
			        	  float c = Float.parseFloat(args[3]);

			             	COINS.removeoktacoins(target, c);
			            sender.sendMessage( "§aVous avez suprimée " + c + " oktaCoins au compte de " + target.getName());
			       
			            

			        	} 	else if(type.contains("Golds") || type.contains("golds")) {
			        		

				        	  float c = Float.parseFloat(args[3]);

				             	COINS.removeBoutiquecoins(target, c);
				            sender.sendMessage( "§aVous avez suprimée " + c + " Golds au compte de " + target.getName());
			        		
			        	}
			        		
			          }
			
			        
			        }
			     
			      } else {
				    	
			      }
			        
	    		
	    	}
	    	} else {

	    	    Player p = (Player)sender;
	    	    
		          p.sendMessage("§7§lInfo COINS: §a§l"+p.getName());
		          p.sendMessage("§aOktaCoins: §e"+ COINS.getoktacoins(p) + "$ §7§l| §6§lGolds: §b"+ COINS.getBoutiquecoins(p));
	  
	    	
	    }
	    return true;
	  }

	  
}