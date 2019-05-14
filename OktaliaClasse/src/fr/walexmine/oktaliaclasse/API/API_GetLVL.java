package fr.walexmine.oktaliaclasse.API;

import java.util.ArrayList;

import org.bukkit.entity.Player;

import fr.walexmine.oktaliaclasse.PRESTIGE;

public class API_GetLVL {

	  public static Integer checkLevel(Player p)
	  {
		  
		return null;
		  
	  }
	  
	  public static Integer getObjectif(Player p)
	  {
		  
		  
		  int Level1 = 1600;
		  int Level2 = 3200;
		  int Level3 = 5100;
		  int Level4 =  8300;
		  int Level5 = 14000;
		  int Level6 =  26500;
		  int Level7 = 50000;
		  int Level8 = 80500;
		  int Level9 = 120000;
		  int Level10 = 180000;
		  int Level11 = 216000;
		  int Level12 = 260000;
		  int Level13 = 312000;
		  int Level14 = 375000;
		  int Level15 = 450000;
		  int Level16 = 540000;
		  int Level17 = 645000;
		  int Level18 = 775000;
		  int Level19 = 930000;
		  int Level20 = 1150000;
		  
		  int EXP = (int) PRESTIGE.getEXP(p);
			
		  ArrayList<Integer> lvl = new ArrayList<>();
		  
		  lvl.add(Level1);
		  lvl.add(Level2);
		  lvl.add(Level3);
		  lvl.add(Level4);
		  lvl.add(Level5);
		  lvl.add(Level6);
		  lvl.add(Level7);
		  lvl.add(Level8);
		  lvl.add(Level9);
		  lvl.add(Level10);
		  lvl.add(Level11);
		  lvl.add(Level12);
		  lvl.add(Level13);
		  lvl.add(Level14);
		  lvl.add(Level15);
		  lvl.add(Level16);
		  lvl.add(Level17);
		  lvl.add(Level18);
		  lvl.add(Level19);
		  lvl.add(Level20);

		    
			int nblvl = lvl.size();
			
	  		for(int i = 0; i <= nblvl; i++) {
	  			
	  			int expto = lvl.get(i);
	  			
	  			if(EXP > expto) {
	  				
	  				
	  				
	  			} else {
	  				
	  				break;
	  			}
	  			
	  		}

			  return Level1;
		  
		  
		  
	  }
	
}
