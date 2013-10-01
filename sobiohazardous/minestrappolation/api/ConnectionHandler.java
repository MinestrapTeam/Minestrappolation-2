package sobiohazardous.minestrappolation.api;

import net.minecraft.network.INetworkManager;
import net.minecraft.network.NetLoginHandler;
import net.minecraft.network.packet.NetHandler;
import net.minecraft.network.packet.Packet1Login;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.EnumChatFormatting;
import cpw.mods.fml.common.network.IConnectionHandler;
import cpw.mods.fml.common.network.Player;

public class ConnectionHandler implements IConnectionHandler {

	@Override
	public void playerLoggedIn(Player player, NetHandler netHandler,
			INetworkManager manager) {
		netHandler.getPlayer().addChatMessage(MinestrappolationVersionChecker.checkIfCurrent("1.4", "https://raw.github.com/werty1124/VersionChecker/master/version.txt","You are using a outdated version. Version "+ MinestrappolationVersionChecker.getVersion("https://raw.github.com/werty1124/VersionChecker/master/version.txt")+" of Minestrappolation is out!"));
		netHandler.getPlayer().addChatMessage(EnumChatFormatting.AQUA+MinestrappolationVersionChecker.getMOTD(("https://raw.github.com/werty1124/VersionChecker/master/version.txt")));
		
	}

	@Override
	public String connectionReceived(NetLoginHandler netHandler,
			INetworkManager manager) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void connectionOpened(NetHandler netClientHandler, String server,
			int port, INetworkManager manager) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void connectionOpened(NetHandler netClientHandler,
			MinecraftServer server, INetworkManager manager) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void connectionClosed(INetworkManager manager) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void clientLoggedIn(NetHandler clientHandler,
			INetworkManager manager, Packet1Login login) {
		// TODO Auto-generated method stub
		
	}

}
