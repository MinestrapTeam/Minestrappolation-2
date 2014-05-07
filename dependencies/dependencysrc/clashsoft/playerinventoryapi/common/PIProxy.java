package clashsoft.playerinventoryapi.common;

import clashsoft.cslib.minecraft.common.BaseProxy;
import clashsoft.playerinventoryapi.inventory.ContainerInventory;
import cpw.mods.fml.common.event.FMLInitializationEvent;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class PIProxy extends BaseProxy
{
	public static int	GUI_SURVIVAL_ID	= 0;
	public static int	GUI_CREATIVE_ID	= 1;
	
	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
	{
		if (ID == GUI_SURVIVAL_ID || ID == GUI_CREATIVE_ID)
		{
			return this.replaceInventory(player);
		}
		return null;
	}
	
	public ContainerInventory replaceInventory(EntityPlayer player)
	{
		if (player.inventoryContainer instanceof ContainerInventory)
		{
			return (ContainerInventory) player.inventoryContainer;
		}
		
		ContainerInventory container = new ContainerInventory(player.inventory, player);
		player.inventoryContainer = player.openContainer = container;
		return container;
	}
	
	@Override
	public void init(FMLInitializationEvent event)
	{
	}
	
	public boolean isMinecraftClassName(String className)
	{
		return false;
	}
}
