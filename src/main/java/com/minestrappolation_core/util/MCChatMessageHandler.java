package com.minestrappolation_core.util;

import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.IChatComponent;

public class MCChatMessageHandler
{
	public static IChatComponent createChatComponent(String message)
	{
		ChatComponentText c = new ChatComponentText(message);
		return c;
	}
	
	public static void sendChatToPlayer(EntityPlayer player, String message)
	{
		player.addChatComponentMessage(createChatComponent(message));
	}
	
	public static void sendChatToCommandSender(ICommandSender sender, String message)
	{
		if (sender instanceof EntityPlayer)
		{
			sendChatToPlayer((EntityPlayer) sender, message);
		}
	}
	
	public static void broadcastMessageToPlayers(String message)
	{
		MinecraftServer.getServer().getConfigurationManager().sendChatMsg(createChatComponent(message));
	}
}