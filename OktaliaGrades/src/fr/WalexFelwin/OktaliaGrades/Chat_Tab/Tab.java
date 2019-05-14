package fr.WalexFelwin.OktaliaGrades.Chat_Tab;

import java.util.UUID;
import java.util.logging.Level;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

import fr.WalexFelwin.OktaliaAPI.Bukkit.Utils.HASHMAP;


public class Tab {

	 public static Scoreboard sb;
	  public static Objective obj;
	  public boolean vault;
	  public static Team DEVELOPPEUR;
	  public static Team GERANTSTAFF;
	  public static Team ADMIN;
	  public static Team MANAGER;
	  public static Team BUILDER;
	  public static Team MODERATEUR;
	  public static Team MODERATRICE;
	  public static Team YOUTUBEUR;
	  public static Team AMI;
	  public static Team VIPPLUS;
	  public static Team VIP;
	  public static Team MONARQUE;
	  public static Team MAITRE;
	  public static Team LEGIONNAIRE;
	  public static Team VOYAGEUR;
	  public static Team JOUEUR;

	 
	  public static void registerTeams()
	  {
		  ADMIN = (sb.getTeam("1ADMIN") == null ? sb.registerNewTeam("1ADMIN") : sb.getTeam("1ADMIN"));
		  DEVELOPPEUR = (sb.getTeam("2DEVELOPPEUR") == null ? sb.registerNewTeam("2DEVELOPPEUR") : sb.getTeam("2DEVELOPPEUR"));
		  GERANTSTAFF = (sb.getTeam("3GERANTSTAFF") == null ? sb.registerNewTeam("3GERANTSTAFF") : sb.getTeam("3GERANTSTAFF"));
		  MANAGER = (sb.getTeam("5MANAGER") == null ? sb.registerNewTeam("5MANAGER") : sb.getTeam("5MANAGER"));
		  BUILDER = (sb.getTeam("6BUILDER") == null ? sb.registerNewTeam("6BUILDER") : sb.getTeam("6BUILDER"));
		  MODERATEUR = (sb.getTeam("7MODERATEUR") == null ? sb.registerNewTeam("7MODERATEUR") : sb.getTeam("7MODERATEUR"));
		  MODERATRICE = (sb.getTeam("8MODERATRICE") == null ? sb.registerNewTeam("8MODERATRICE") : sb.getTeam("8MODERATRICE"));
		  YOUTUBEUR = (sb.getTeam("9YOUTUBEUR") == null ? sb.registerNewTeam("9YOUTUBEUR") : sb.getTeam("9YOUTUBEUR"));
		  AMI = (sb.getTeam("99AMI") == null ? sb.registerNewTeam("99AMI") : sb.getTeam("99AMI"));
		  VIPPLUS = (sb.getTeam("991VIP+") == null ? sb.registerNewTeam("991VIP+") : sb.getTeam("991VIP+"));
		  VIP = (sb.getTeam("992VIP") == null ? sb.registerNewTeam("992VIP") : sb.getTeam("992VIP"));
		  MONARQUE = (sb.getTeam("993MONARQUE") == null ? sb.registerNewTeam("993MONARQUE") : sb.getTeam("993MONARQUE"));
		  MAITRE = (sb.getTeam("994MAITRE") == null ? sb.registerNewTeam("994MAITRE") : sb.getTeam("994MAITRE"));
		  LEGIONNAIRE = (sb.getTeam("995LEGIONNAIRE") == null ? sb.registerNewTeam("995LEGIONNAIRE") : sb.getTeam("995LEGIONNAIRE"));
		  VOYAGEUR = (sb.getTeam("996VOYAGEUR") == null ? sb.registerNewTeam("996VOYAGEUR") : sb.getTeam("996VOYAGEUR"));
		  JOUEUR = (sb.getTeam("9999JOUEUR") == null ? sb.registerNewTeam("9999JOUEUR") : sb.getTeam("9999JOUEUR"));
	  
		  Bukkit.getLogger().log(Level.INFO, "Les Teams sont bien register !");
	  }
	  
	  public static void setprefixtab()
	  {   
		  DEVELOPPEUR.setPrefix(ChatUtils.getdeveloppeurprefix());
		  ADMIN.setPrefix(ChatUtils.getadminprefix());
		  GERANTSTAFF.setPrefix(ChatUtils.getgerantprefix());
		  MANAGER.setPrefix(ChatUtils.getmanagerprefix());
		  BUILDER.setPrefix(ChatUtils.builderprefix());
		  MODERATEUR.setPrefix(ChatUtils.getmodoprefix());
		  MODERATRICE.setPrefix(ChatUtils.getmodaprefix());
		  YOUTUBEUR.setPrefix(ChatUtils.getyoutubeurprefix());
		  AMI.setPrefix(ChatUtils.amiprefix());
		  VIPPLUS.setPrefix(ChatUtils.getVIPPlusprefix());
		  VIP.setPrefix(ChatUtils.getVIPprefix());
		  MONARQUE.setPrefix("§9[Monarque] ");
		  MAITRE.setPrefix("§6[Maitre] ");
		  LEGIONNAIRE.setPrefix("§5[Legion] ");
		  VOYAGEUR.setPrefix("§2[Voyageur] ");
		  JOUEUR.setPrefix("§8[§7§lJ§8] ");
		  Bukkit.getLogger().log(Level.INFO, "Les prefix ont bien été reload !");
	  }
	  
	  
	  public static void ReloadTeam(Player p){
		  
		  String grades = HASHMAP.Grades.get(p);
		  if (grades.equalsIgnoreCase("admin")){
			  ADMIN.addPlayer(p);
		  } 
		  else if (grades.equalsIgnoreCase("developpeur")){
			  DEVELOPPEUR.addPlayer(p);
		  }
		  else if (grades.equalsIgnoreCase("gerant")){
			  GERANTSTAFF.addPlayer(p);
		  }

		  else if (grades.equalsIgnoreCase("manager")){
			  MANAGER.addPlayer(p);
		  }
		  else if (grades.equalsIgnoreCase("buildeur")){
			  BUILDER.addPlayer(p);
		  }
		  else if (grades.contains("youtubeur")){
			  YOUTUBEUR.addPlayer(p);
		  }
		  else if (grades.equalsIgnoreCase("ami")){
			  AMI.addPlayer(p);
		  } 
		  else if (grades.equalsIgnoreCase("moderateur")){
			  MODERATEUR.addPlayer(p);
		  } 
		  else if (grades.equalsIgnoreCase("moderatrice")){
			  MODERATRICE.addPlayer(p);
		  }  
		  else if (grades.equalsIgnoreCase("vip+")){
			  VIPPLUS.addPlayer(p);
		  }
		  else if (grades.equalsIgnoreCase("vip")){
			  VIP.addPlayer(p);
		  }
		  else if (grades.equalsIgnoreCase("monarque")){
			  MONARQUE.addPlayer(p);
		  }
		  else if (grades.equalsIgnoreCase("maitre")){
			  MAITRE.addPlayer(p);
		  }
		  else if (grades.equalsIgnoreCase("legionnaire")){
			  LEGIONNAIRE.addPlayer(p);
		  }
		  else if (grades.equalsIgnoreCase("voyageur")){
			  VOYAGEUR.addPlayer(p);
		  }
		  else {
			  JOUEUR.addPlayer(p);
		  }
		  
		  
	  }
}
