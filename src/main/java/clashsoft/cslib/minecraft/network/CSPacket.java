package clashsoft.cslib.minecraft.network;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketBuffer;
import net.minecraft.world.World;
import net.minecraftforge.common.DimensionManager;

public abstract class CSPacket
{
	public CSPacket()
	{
		
	}
	
	public abstract void write(PacketBuffer buf);
	
	public abstract void read(PacketBuffer buf);
	
	public abstract void handleClient(EntityPlayer player);
	
	public abstract void handleServer(EntityPlayer player);
	
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
		buf.writeItemStackToBuffer(stack);
	}
	
	public final ItemStack readItemStack(PacketBuffer buf)
	{
		return buf.readItemStackFromBuffer();
	}
}
