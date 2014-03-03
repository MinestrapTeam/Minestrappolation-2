package sobiohazardous.minestrappolation.extramobdrops.handler;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;

import net.minecraft.network.packet.Packet250CustomPayload;
import net.minecraft.network.INetworkManager;
import cpw.mods.fml.common.network.IPacketHandler;
import cpw.mods.fml.common.network.PacketDispatcher;
import cpw.mods.fml.common.network.Player;

public class EMDPacketHandler implements IPacketHandler
{
    public static boolean damageItem;

	@Override
    public void onPacketData(INetworkManager manager, Packet250CustomPayload packet, Player player) 
	{            
            if (packet.channel.equals("emdPacketChan")) 
            {
                    handleRandom(packet);
            }
    }
    
    private void handleRandom(Packet250CustomPayload packet) 
    {
            DataInputStream inputStream = new DataInputStream(new ByteArrayInputStream(packet.data));           
            
            try 
            {
                    damageItem = inputStream.readBoolean();
            } 
            catch (IOException e) 
            {
                    e.printStackTrace();
                    return;
            }       
            
    }
}
