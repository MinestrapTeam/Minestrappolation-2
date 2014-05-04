package sobiohazardous.mods.minestrappolation.core.util;

import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.IChatComponent;

public class MChatMessageHandler 
{

    private static final IChatComponent minestrapChatComponent = createSckChatComponent("");

    public static void iCommandSenderReply(ICommandSender player, String message) 
    {
        sendChatToPlayer((EntityPlayer)player, message);
    }

    private static IChatComponent createSckChatComponent(String string) 
    {
        ChatComponentText Component = new ChatComponentText(string);
        return Component;
    }

    public static IChatComponent createChatComponent(String message) 
    {
        ChatComponentText component = new ChatComponentText(message);
        return minestrapChatComponent.appendSibling(component);
    }

    public static void sendChatToPlayer(EntityPlayer player, String message) 
    {
        player.addChatComponentMessage(createChatComponent(message));
    }

    public static void broadcastMessageToPlayers(String message)
    {
        MinecraftServer.getServer().getConfigurationManager().sendChatMsg(createChatComponent(message));
    }
}