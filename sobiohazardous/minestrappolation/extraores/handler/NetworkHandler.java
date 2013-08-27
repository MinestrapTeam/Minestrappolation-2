package sobiohazardous.minestrappolation.extraores.handler;

import net.minecraft.network.INetworkManager;
import net.minecraft.network.NetLoginHandler;
import net.minecraft.network.packet.NetHandler;
import net.minecraft.network.packet.Packet1Login;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.EnumChatFormatting;
import cpw.mods.fml.common.network.IConnectionHandler;
import cpw.mods.fml.common.network.Player;

public class NetworkHandler implements IConnectionHandler
{

	@Override
	public void playerLoggedIn(Player player, NetHandler netHandler, INetworkManager manager) 
	{
		if(netHandler.getPlayer().username.equals("SoBiohazardous") || netHandler.getPlayer().username.equals("Delocuro"))
		{
			netHandler.getPlayer().addChatMessage(EnumChatFormatting.DARK_GREEN + "[Minestrappolation] " + EnumChatFormatting.RED + "A Minestrappolation developer has arrived!");
			//TODO Make it so server says above line when devs join.
		}
		
	}

	@Override
	public String connectionReceived(NetLoginHandler netHandler, INetworkManager manager) 
	{
		return null;
	}

	@Override
	public void connectionOpened(NetHandler netClientHandler, String server, int port, INetworkManager manager) 
	{
		
	}

	@Override
	public void connectionOpened(NetHandler netClientHandler, MinecraftServer server, INetworkManager manager) 
	{
		
	}

	@Override
	public void connectionClosed(INetworkManager manager) 
	{
		
	}

	@Override
	public void clientLoggedIn(NetHandler clientHandler, INetworkManager manager, Packet1Login login) 
	{
		
	}
}
