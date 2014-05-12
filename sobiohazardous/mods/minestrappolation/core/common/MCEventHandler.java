package sobiohazardous.mods.minestrappolation.core.common;

import sobiohazardous.mods.minestrappolation.core.lib.MCReference;
import sobiohazardous.mods.minestrappolation.core.util.MCChatMessageHandler;
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
			MCChatMessageHandler.sendChatToPlayer(event.player, MCVersionChecker.updateCheck(MCReference.VERSION, url));
			MCChatMessageHandler.sendChatToPlayer(event.player, MCVersionChecker.getMOTD(url));
			
			MCVersionChecker.updateFile = null;
		}
		else
		{
			MCChatMessageHandler.sendChatToPlayer(event.player, EnumChatFormatting.RED + "Could not find version file or you may not be connected to the internet");
		}
	}
}
