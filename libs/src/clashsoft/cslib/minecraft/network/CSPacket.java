package clashsoft.cslib.minecraft.network;

import java.io.IOException;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketBuffer;
import net.minecraft.world.World;
import net.minecraftforge.common.DimensionManager;

public abstract class CSPacket
{
	public abstract void write(PacketBuffer buf);
	
	public abstract void read(PacketBuffer buf);
	
	public abstract void handleClient(EntityPlayer player);
	
	public abstract void handleServer(EntityPlayerMP player);
	
	// Helper methods
	
	public final void writeWorld(PacketBuffer buf, World world)
	{
		buf.writeInt(world.provider.dimensionId);
	}
	
	public final World readWorld(PacketBuffer buf)
	{
		int id = buf.readInt();
		return DimensionManager.getWorld(id);
	}
	
	public final void writeItemStack(PacketBuffer buf, ItemStack stack)
	{
		try
		{
			buf.writeItemStackToBuffer(stack);
		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public final ItemStack readItemStack(PacketBuffer buf)
	{
		try
		{
			return buf.readItemStackFromBuffer();
		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
