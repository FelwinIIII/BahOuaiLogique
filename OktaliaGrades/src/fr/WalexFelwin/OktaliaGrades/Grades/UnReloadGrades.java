package fr.WalexFelwin.OktaliaGrades.Grades;

import org.bukkit.entity.Player;

import fr.WalexFelwin.OktaliaAPI.Bukkit.API.API_Grades;
import fr.WalexFelwin.OktaliaGrades.Grades.GradesPerm.Admin;
import fr.WalexFelwin.OktaliaGrades.Grades.GradesPerm.Buildeur;
import fr.WalexFelwin.OktaliaGrades.Grades.GradesPerm.BuildeurTest;
import fr.WalexFelwin.OktaliaGrades.Grades.GradesPerm.Joueur.Joueur;
import fr.WalexFelwin.OktaliaGrades.Grades.GradesPerm.Joueur.Legionnaire;
import fr.WalexFelwin.OktaliaGrades.Grades.GradesPerm.Joueur.Maitre;
import fr.WalexFelwin.OktaliaGrades.Grades.GradesPerm.Joueur.Monarque;
import fr.WalexFelwin.OktaliaGrades.Grades.GradesPerm.Joueur.VIP;
import fr.WalexFelwin.OktaliaGrades.Grades.GradesPerm.Joueur.VIPPLUS;
import fr.WalexFelwin.OktaliaGrades.Grades.GradesPerm.Joueur.Voyageur;


public class UnReloadGrades {

	public static void UnReloadRank(Player p, String grades){
		
		long endgrades = API_Grades.getEnd(""+p.getUniqueId());
		long current = System.currentTimeMillis();
		
		if(endgrades > current){
			
		} else {
			if(endgrades == 0){
				
			} else {
			API_Grades.setgrades(p.getUniqueId(), "");
			API_Grades.setend(""+p.getUniqueId(), (long)0);
			}
		}
	
		if (grades.equalsIgnoreCase("admin")){
			
			Admin.UnPerm(p);
			
		} else if (grades.equalsIgnoreCase("gerant")){
			
			//.UnPerm(p);
			
		} else if (grades.equalsIgnoreCase("moderateur")){
			
			//Modérateur.UnPerm(p);
			
		} else if (grades.equalsIgnoreCase("moderatrice")){
			
			//Modératrice.UnPerm(p);
			
		} else if (grades.equalsIgnoreCase("buildeur")){
			
			Buildeur.UnPerm(p);
			
		} else if (grades.equalsIgnoreCase("buildeurtest")){
			
			BuildeurTest.UnPerm(p);
			
		} else if (grades.contains("youtubeur")){
			
		} else if (grades.equalsIgnoreCase("ami")){
			
			//Ami.Perm(p);
			
		} else if (grades.equalsIgnoreCase("voyageur")){
			
			Voyageur.UnPerm(p);
			
		} else if (grades.equalsIgnoreCase("legionnaire")){
			
			Legionnaire.UnPerm(p);
			
		} else if (grades.equalsIgnoreCase("maitre")){
			
			Maitre.UnPerm(p);
			
		} else if (grades.equalsIgnoreCase("monarque")){
			
			Monarque.UnPerm(p);
			
		} else if (grades.equalsIgnoreCase("vip")){
			
			VIP.UnPerm(p);
			
		} else if (grades.equalsIgnoreCase("vip+")){
			
			VIPPLUS.UnPerm(p);
			
		}	else {
		
			
		}
		Joueur.UnPerm(p);
		
	}
}
