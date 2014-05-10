package clashsoft.playerinventoryapi.client;

import clashsoft.playerinventoryapi.PlayerInventoryAPI;
import clashsoft.playerinventoryapi.common.PIProxy;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainerCreative;
import net.minecraft.client.gui.inventory.GuiInventory;
import net.minecraft.entity.player.EntityPlayer;

public class PIClientEventHandler
{
	@SubscribeEvent
	public void onTick(TickEvent.ClientTickEvent event)
	{
		EntityPlayer player = Minecraft.getMinecraft().thePlayer;
		if (PlayerInventoryAPI.customSurvivalInventory && Minecraft.getMinecraft().currentScreen instanceof GuiInventory)
		{
			player.openGui(PlayerInventoryAPI.instance, PIProxy.GUI_SURVIVAL_ID, player.worldObj, 0, 0, 0);
		}
		else if (PlayerInventoryAPI.customCreativeInventory && Minecraft.getMinecraft().currentScreen instanceof GuiContainerCreative)
		{
			player.openGui(PlayerInventoryAPI.instance, PIProxy.GUI_CREATIVE_ID, player.worldObj, 0, 0, 0);
		}
	}
}
