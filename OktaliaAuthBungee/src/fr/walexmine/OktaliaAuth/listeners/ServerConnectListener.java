package fr.walexmine.OktaliaAuth.listeners;

import net.md_5.bungee.api.event.ServerConnectEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;

public class ServerConnectListener
  implements Listener
{
	




  @EventHandler(priority=96)
  public void onServerConnect(ServerConnectEvent paramServerConnectEvent)
  {
  /*  ServerInfo localServerInfo = paramServerConnectEvent.getTarget();
    ProxiedPlayer p = paramServerConnectEvent.getPlayer();
    DataUser localDataUser = AuthPlugin.INSTANCE.getUser(paramServerConnectEvent.getPlayer());
    if (localDataUser == null) {
      return;
    }*/
  //  if (localDataUser.isLogged()) {
    	
    /*	if(firstlog.containsKey(p)) {
    		return;
    	} else {/*

    		//paramServerConnectEvent.setCancelled(true);
        	//firstlog.put(p, "true");
    	}

    	/*if(PluginMessage.HubRedirect.containsKey(p)) {
        	ServerInfo HUB = BungeeCord.getInstance().getServerInfo(PluginMessage.HubRedirect.get(p));
        	System.out.println(""+HUB.getName());
        	paramServerConnectEvent.setTarget(HUB);   		         	
        	firstlog.put(p, "true");
    	}*/

    	//REPARTHUB(p);	        	 
    	/*ServerInfo red = BungeeCord.getInstance().getServerInfo(Lastserv.get(p));
    	paramServerConnectEvent.setTarget(red);*/
   /*   return;
    }*/
    
    /*if ((localDataUser.getPremium()) && (!localDataUser.mustRegister())) {

    //	ServerInfo hub1 = BungeeCord.getInstance().getServerInfo("hub1");
    	ServerInfo hub2 = BungeeCord.getInstance().getServerInfo("hub2");
    	
    	if(hub1.getPlayers().size() > hub2.getPlayers().size()) {
        	paramServerConnectEvent.setTarget(hub2);

        	
    	} else {        	
        	paramServerConnectEvent.setTarget(hub1);
    	}*/
    	

    /*int l = API_Login.getlogin(p);
	if(l == 1){
		return;
	
	*/
	
	
    
  }
}
