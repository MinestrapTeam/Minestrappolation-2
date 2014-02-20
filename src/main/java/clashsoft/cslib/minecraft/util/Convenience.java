package clashsoft.cslib.minecraft.util;

import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.util.ChatComponentText;

public class Convenience
{
	public static void addChatMessage(EntityPlayer player, String message)
	{
		player.addChatMessage(new ChatComponentText(message));
	}
	
	public static void addSmelting(FurnaceRecipes recipes, ItemStack input, ItemStack output, float exp)
	{
		recipes.func_151394_a(input, output, exp);
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
