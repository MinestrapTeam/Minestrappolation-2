package sobiohazardous.mods.minestrappolation.core;

import sobiohazardous.mods.minestrappolation.core.util.MChatMessageHandler;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent;

import net.minecraft.util.EnumChatFormatting;

public class MEventHandler
{
	public static String	url	= "https://raw.githubusercontent.com/SoBiohazardous/Minestrappolation-Recode/master/version.txt";
	
	@SubscribeEvent
	public void onPlayerLogin(PlayerEvent.PlayerLoggedInEvent event)
	{
		if (MVersionChecker.doesFileExist(url))
		{
			MChatMessageHandler.sendChatToPlayer(event.player, MVersionChecker.checkIfCurrent("2.1.2", url, "You are using a outdated version. Version " + MVersionChecker.getVersion(url) + " of Minestrappolation is out!\n"));
			MChatMessageHandler.sendChatToPlayer(event.player, MVersionChecker.getMOTDColor(url) + MVersionChecker.getMOTD((url)));
		}
		else
		{
			MChatMessageHandler.sendChatToPlayer(event.player, EnumChatFormatting.RED + "Could not find version file or you may not be connected to the internet");
		}
	}
}
