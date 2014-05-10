package clashsoft.playerinventoryapi.client;

import clashsoft.playerinventoryapi.client.gui.GuiCreativeInventory;
import clashsoft.playerinventoryapi.client.gui.GuiSurvivalInventory;
import clashsoft.playerinventoryapi.common.PIProxy;
import clashsoft.playerinventoryapi.inventory.ContainerCreativeList;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class PIClientProxy extends PIProxy
{
	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
	{
		if (ID == GUI_CREATIVE_ID)
		{
			return new GuiCreativeInventory(player, new ContainerCreativeList(player), this.replaceInventory(player));
		}
		else if (ID == GUI_SURVIVAL_ID)
		{
			return new GuiSurvivalInventory(player, this.replaceInventory(player));
		}
		return null;
	}
	
	@Override
	public void init(FMLInitializationEvent event)
	{
		FMLCommonHandler.instance().bus().register(new PIClientEventHandler());
	}
	
	@Override
	public boolean isClient()
	{
		return true;
	}
	
	@Override
	public boolean isMinecraftClassName(String className)
	{
		return className.equals(Minecraft.class.getName());
	}
}
