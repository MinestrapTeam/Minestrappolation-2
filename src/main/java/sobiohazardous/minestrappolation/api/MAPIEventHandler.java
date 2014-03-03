package sobiohazardous.minestrappolation.api;

import sobiohazardous.minestrappolation.api.util.ChatMessageHandler;
import net.minecraft.util.EnumChatFormatting;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent;
import cpw.mods.fml.common.network.FMLNetworkEvent;

public class MAPIEventHandler 
{
	String url = "https://raw.github.com/SoBiohazardous/Minestrappolation-Recode/master/src/main/java/version.txt";

	@SubscribeEvent
    public void onPlayerLogin(PlayerEvent.PlayerLoggedInEvent event) 
	{
		if(MinestrappolationVersionChecker.doesFileExist(url))
		{
			ChatMessageHandler.sendChatToPlayer(event.player, MinestrappolationVersionChecker.checkIfCurrent("2.0", url,"You are using a outdated version. Version "+ MinestrappolationVersionChecker.getVersion(url)+" of Minestrappolation is out!"));
			ChatMessageHandler.sendChatToPlayer(event.player, MinestrappolationVersionChecker.getMOTDColor(url)+MinestrappolationVersionChecker.getMOTD((url)));
		}
		else
		{
			ChatMessageHandler.sendChatToPlayer(event.player, EnumChatFormatting.RED+"Could not find version file or you may not be connected to the internet");
		}
	}
}
