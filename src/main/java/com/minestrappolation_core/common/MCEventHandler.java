package com.minestrappolation_core.common;

import com.minestrappolation_core.lib.MCReference;
import com.minestrappolation_core.util.MCChatMessageHandler;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent;

import net.minecraft.util.EnumChatFormatting;

public class MCEventHandler
{
	@SubscribeEvent
	public void onPlayerLogin(PlayerEvent.PlayerLoggedInEvent event)
	{
		String url = MCVersionChecker.versionURL;
		if (MCVersionChecker.doesFileExist(url))
		{
			MCChatMessageHandler.sendChatToPlayer(event.player, MCVersionChecker.updateCheck(MCReference.MINESTRAP_CORE_VERSION, url));
			MCChatMessageHandler.sendChatToPlayer(event.player, MCVersionChecker.getMOTD(url));
			
			MCVersionChecker.updateFile = null;
		}
		else
		{
			MCChatMessageHandler.sendChatToPlayer(event.player, EnumChatFormatting.RED + "Could not find version file or you may not be connected to the internet");
		}
	}
}
