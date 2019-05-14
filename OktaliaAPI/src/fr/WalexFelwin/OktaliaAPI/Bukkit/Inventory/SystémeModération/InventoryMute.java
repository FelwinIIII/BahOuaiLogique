package fr.WalexFelwin.OktaliaAPI.Bukkit.Inventory.SystémeModération;

import java.util.ArrayList;

import net.minecraft.server.v1_8_R3.ChatMessage;
import net.minecraft.server.v1_8_R3.EntityPlayer;
import net.minecraft.server.v1_8_R3.PacketPlayOutOpenWindow;

import org.bukkit.ChatColor;
import org.bukkit.DyeColor;
import org.bukkit.Material;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import fr.WalexFelwin.OktaliaAPI.Bukkit.Inventory.FakeAnvil;

public class InventoryMute {
	
		
	  	public static void InventaireMute(Player p)
	  {
		    ItemStack ban = new ItemStack(Material.STAINED_CLAY, 1,DyeColor.ORANGE.getData());
		    ItemMeta banmeta = ban.getItemMeta();
		    banmeta.setDisplayName(ChatColor.YELLOW+"<Raison>");
		    ArrayList<String> banlore = new ArrayList();
		    banlore.add("§6✖  Mute ✖");
		    banmeta.setLore(banlore);
		    ban.setItemMeta(banmeta);

		    
	        EntityPlayer entityPlayer = ((CraftPlayer) p).getHandle();
	        FakeAnvil fakeAnvil = new FakeAnvil(entityPlayer);
	        int containerId = entityPlayer.nextContainerCounter();

	      
	        ((CraftPlayer) p).getHandle().playerConnection.sendPacket(new PacketPlayOutOpenWindow(containerId, "minecraft:anvil", new ChatMessage("Repairing", new Object[]{}), 0));
	   
	        entityPlayer.activeContainer = fakeAnvil;
	        entityPlayer.activeContainer.windowId = containerId;
	        entityPlayer.activeContainer.addSlotListener(entityPlayer);
	        entityPlayer.activeContainer = fakeAnvil;
	        entityPlayer.activeContainer.windowId = containerId;
	   
	        Inventory inv = fakeAnvil.getBukkitView().getTopInventory();
	        
	        inv.setItem(0, ban); //Remove this if you don't want to add stuff into slots. This is what I needed it for my GUI.

	  }
}
