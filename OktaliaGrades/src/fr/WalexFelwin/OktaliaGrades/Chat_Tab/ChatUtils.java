package fr.WalexFelwin.OktaliaGrades.Chat_Tab;

import org.bukkit.entity.Player;

import fr.WalexFelwin.OktaliaAPI.Bukkit.Utils.HASHMAP;

public class ChatUtils {
	
	
	
	
	public static String getpreffix(Player p){
		
		String grades = ""+HASHMAP.Grades.get(p);
		if (grades.equalsIgnoreCase("developpeur")){
			  return ChatUtils.getdeveloppeurprefix();
		  }
		  else if (grades.equalsIgnoreCase("gerant")){
			  return ChatUtils.getgerantprefix();
		  }
		  else if (grades.equalsIgnoreCase("admin")){
			  return ChatUtils.getadminprefix();
		  }
		  else if (grades.equalsIgnoreCase("manager")){
			  return ChatUtils.getmanagerprefix();
		  }
		  else if (grades.equalsIgnoreCase("buildeur")){
			  return ChatUtils.builderprefix();
		  }
		  else if (grades.contains("youtubeur")){
			  return ChatUtils.getyoutubeurprefix();
		  }
		  else if (grades.equalsIgnoreCase("ami")){
			  return ChatUtils.amiprefix();
		  } 
		  else if (grades.equalsIgnoreCase("moderateur")){
			  return ChatUtils.getmodoprefix();
		  } 
		  else if (grades.equalsIgnoreCase("moderatrice")){
			  return ChatUtils.getmodaprefix();
		  }  
		  else if (grades.equalsIgnoreCase("vip+")){
			  return ChatUtils.getVIPPlusprefix();
		  }  
		  else if (grades.equalsIgnoreCase("vip")){
			  return ChatUtils.getVIPprefix();
		  }
		  else if (grades.equalsIgnoreCase("monarque")){
			  return ChatUtils.getmonarqueprefix();
		  }
		  else if (grades.equalsIgnoreCase("maitre")){
			  return ChatUtils.getMaitreprefix();
		  }
		  else if (grades.equalsIgnoreCase("legionnaire")){
			  return ChatUtils.getLegionnaireprefix();
		  }
		  else if (grades.equalsIgnoreCase("voyageur")){
			  return ChatUtils.getVoyageurprefix();
		  }
		  else {
				return "§7Joueur";
		  }
		
	}
	
	
	
	
	
	
	  static String developpeurprefix = "§a[Développeur] ";
	  
	  public static String getdeveloppeurprefix()
	  {
	    return developpeurprefix;
	  }

	  static String adminprefix = "§c[Admin] ";
	  
	  public static String getadminprefix()
	  {
	    return adminprefix;
	  }
	  
	  static String gerantprefix = "§6[Gérant] ";
	  
	  public static String getgerantprefix()
	  {
	    return gerantprefix;
	  }
	  static String managerprefix = "§b[Manager] ";
	  
	  public static String getmanagerprefix()
	  {
	    return managerprefix;
	  }
	  static String modoprefix = "§9[Modérateur] ";
	  
	  public static String getmodoprefix()
	  {
	    return modoprefix;
	  }	  
	  
	  	static String modaprefix = "§d[Modératrice] ";
	  
	  public static String getmodaprefix()
	  {
	    return modaprefix;
	  }
	  
	  static String builderprefix = "§b[Buildeur] ";
	  
	  public static String builderprefix()
	  {
	    return builderprefix;
	  }
	  static String youtubeurprefix = "§f[Yout§fubeur] ";
	  
	  public static String getyoutubeurprefix()
	  {
	    return youtubeurprefix;
	  }  
	  static String amiprefix = "§d[Ami] ";
	  
	  public static String amiprefix()
	  {
	    return amiprefix;
	  }
	  static String VIPprefix = "§b[VIP] ";
	  
	  public static String getVIPprefix()
	  {
	    return VIPprefix;
	  }
	  static String VIPPlusprefix = "§e[VIP+] ";
	  
	  public static String getVIPPlusprefix()
	  {
	    return VIPPlusprefix;
	  }
	  static String Voyageurprefix = "§2Voyageur ";
	  
	  public static String getVoyageurprefix()
	  {
	    return Voyageurprefix;
	  }
	  
	  static String Legionnaireprefix = "§5Legionnaire ";
	  
	  public static String getLegionnaireprefix()
	  {
	    return Legionnaireprefix;
	  }
	  
	  static String Maitreprefix = "§6Maitre ";
	  
	  public static String getMaitreprefix()
	  {
	    return Maitreprefix;
	  }
	  
	  static String Monarqueprefix = "§9Monarque ";
	  
	  public static String getmonarqueprefix()
	  {
	    return Monarqueprefix;
	  }
}
