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

public class ReloadGrades {

	
	public static void ReloadRank(Player p, String grades){
		
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
			
			Admin.Perm(p);
			
		} else if (grades.equalsIgnoreCase("gerant")){
			
			//.Perm(p);
			
		} else if (grades.equalsIgnoreCase("moderateur")){
			
			//Modérateur.Perm(p);
			
		} else if (grades.equalsIgnoreCase("moderatrice")){
			
			//Modératrice.Perm(p);
			
		} else if (grades.equalsIgnoreCase("buildeur")){
			
			Buildeur.Perm(p);
			
		} else if (grades.equalsIgnoreCase("buildeurtest")){
			
			BuildeurTest.Perm(p);
			
		} else if (grades.contains("youtubeur")){
			
		} else if (grades.equalsIgnoreCase("ami")){
			
			//Ami.Perm(p);
			
		} else if (grades.equalsIgnoreCase("voyageur")){
			
			Voyageur.Perm(p);
			
		} else if (grades.equalsIgnoreCase("legionnaire")){
			
			Legionnaire.Perm(p);
			
		} else if (grades.equalsIgnoreCase("maitre")){
			
			Maitre.Perm(p);
			
		} else if (grades.equalsIgnoreCase("monarque")){
			
			Monarque.Perm(p);
			
		} else if (grades.equalsIgnoreCase("vip")){
			
			VIP.Perm(p);
			
		} else if (grades.equalsIgnoreCase("vip+")){
			
			VIPPLUS.Perm(p);
			
		}	else {
		
			
		}
		Joueur.Perm(p);
	}
}
