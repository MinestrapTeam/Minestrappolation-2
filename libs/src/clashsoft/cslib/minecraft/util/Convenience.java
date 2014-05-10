package clashsoft.cslib.minecraft.util;

import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ChatComponentText;

public class Convenience
{
	public static void addChatMessage(EntityPlayer player, String message)
	{
		player.addChatMessage(new ChatComponentText(message));
	}
	
	public static void shutdown()
	{
		try
		{
			Minecraft mc = Minecraft.getMinecraft();
			mc.theWorld.sendQuittingDisconnectingPacket();
			mc.theWorld.sendQuittingDisconnectingPacket();
			mc.loadWorld((WorldClient) null);
			
			mc.shutdown();
		}
		catch (Exception ex)
		{
		}
	}
}
