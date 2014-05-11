package sobiohazardous.mods.minestrappolation.core.common;

import sobiohazardous.mods.minestrappolation.core.lib.MReference;
import sobiohazardous.mods.minestrappolation.core.util.MChatMessageHandler;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent;

import net.minecraft.util.EnumChatFormatting;

public class MEventHandler
{
	@SubscribeEvent
	public void onPlayerLogin(PlayerEvent.PlayerLoggedInEvent event)
	{
		String url = MVersionChecker.versionURL;
		if (MVersionChecker.doesFileExist(url))
		{
			MChatMessageHandler.sendChatToPlayer(event.player, MVersionChecker.updateCheck(MReference.VERSION, url));
			MChatMessageHandler.sendChatToPlayer(event.player, MVersionChecker.getMOTD(url));
			
			MVersionChecker.updateFile = null;
		}
		else
		{
			MChatMessageHandler.sendChatToPlayer(event.player, EnumChatFormatting.RED + "Could not find version file or you may not be connected to the internet");
		}
	}
}
