package fr.walexmine.oktaliaclasse;

import java.util.HashMap;

import org.bukkit.entity.Player;

import fr.WalexFelwin.OktaliaAPI.Bukkit.Main;
import fr.WalexFelwin.OktaliaAPI.Bukkit.Utils.HASHMAP;

public class PRESTIGE {

	  public static HashMap<Player, Integer> EXP = new HashMap();
	  public static HashMap<Player, Integer> LEVEL = new HashMap();
	  

	  
	  public static float getEXP(Player p)
	  {
		  float c = 0;
		  c = EXP.get(p);
		  
	    return c;
	  }
	  
	  public static void removeEXP(Player p, float coins)
	  {
		  
		  float c = getEXP(p);
		  
		  c -= coins;
		  
		  EXP.put(p, (int) c);
	  }
	  
	  public static void addEXP(Player p, float coins) 
	  {
		  float c = getEXP(p);
		  c += coins;
		  EXP.put(p, (int) c);
	  }
	  
	  public static void setEXP(Player p, float coins)
	  {
		  float c;
		  c = coins;
		  EXP.put(p, (int) c);
	  }

	  
	  public static float getLVL(Player p)
	  {
		  float c = LEVEL.get(p);

	    return c;
	  }
	  
	  public static void removeLVL(Player p, float coins)
	  {
		  float c = getLVL(p);
		  c -= coins;
		  LEVEL.put(p, (int) c);
	  }
	  
	  public static void addLVL(Player p, float coins)
	  {
		  float c = getLVL(p);
		  c += coins;
		  LEVEL.put(p, (int) c);
	  }
	  
	  public static void setLVL(Player p, float coins)
	  {
		  float c = 0;
		  c = coins;
		  LEVEL.put(p, (int) c);
	  }
}
