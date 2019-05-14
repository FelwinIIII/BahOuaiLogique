package fr.WalexFelwin.OktaliaGrades.Grades.GradesPerm.Joueur;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.permissions.PermissionAttachment;

public class Maitre {

	   public static void Perm(Player p){
		   
		   PermissionAttachment attachment = p.addAttachment(Bukkit.getPluginManager().getPlugin("OktaliaGrades"));

		   attachment.setPermission("", true);
		   
	   }
	   
	   public static void UnPerm(Player p){
		   
		   PermissionAttachment attachment = p.addAttachment(Bukkit.getPluginManager().getPlugin("OktaliaGrades"));

		   attachment.setPermission("", false);
		   
	   }
}