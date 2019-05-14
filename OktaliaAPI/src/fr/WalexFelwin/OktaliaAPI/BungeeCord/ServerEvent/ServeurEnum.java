package fr.WalexFelwin.OktaliaAPI.BungeeCord.ServerEvent;

import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Plugin;


public enum ServeurEnum {

	FULLJOIN(false), MAINTENANCE(false);

	
	public ServeurEnum pl;
	public static boolean bool;
	public static ServeurEnum stats;
	
	private ServeurEnum(boolean bool){
		pl.bool = bool;
	}
	
	public boolean canjoin(){
		return bool;
	}
	public void refusereason(ProxiedPlayer p){
	
	}
	
	public static void setState(ServeurEnum state, boolean b){
		ServeurEnum.stats = state;
		ServeurEnum.bool = b;
	}
	
	public static boolean isState(ServeurEnum state){
		return ServeurEnum.stats == state;
	}
	
	public static ServeurEnum getState() {
		return stats;
	}
}
