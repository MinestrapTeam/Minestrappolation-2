package sobiohazardous.minestrappolation.extraores.handler;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import net.minecraft.network.packet.Packet250CustomPayload;
import net.minecraft.network.INetworkManager;
import cpw.mods.fml.common.network.IPacketHandler;
import cpw.mods.fml.common.network.PacketDispatcher;
import cpw.mods.fml.common.network.Player;

public class ClientPacketHandler implements IPacketHandler
{
    /**
     * Only packets sent from a server to this specific client arrive here
     */
    @Override
    public void onPacketData(INetworkManager manager, Packet250CustomPayload packet, Player player)
    {
        DataInputStream data = new DataInputStream(new ByteArrayInputStream(packet.data));
        
        /* Now do data.read... to retrieve your packet data
         * It would be wise to start all your packets with an Int to distinguish them
         * 
         * to send a response packet to the server who sent the packet to the client, use
         * manager.addToSendQueue
         * 
         * to send a packet to the server outside of this onPacket method, simply use
         * PacketDispatcher.sendPacketToServer
         */
    }
}
