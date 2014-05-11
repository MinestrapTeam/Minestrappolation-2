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
	/**
	 * Writes this packet to the {@link PacketBuffer} {@code buf}.
	 * 
	 * @param buf
	 *            the buffer
	 */
	public abstract void write(PacketBuffer buf);
	
	/**
	 * Reads this packet from the {@link PacketBuffer} {@code buf}.
	 * 
	 * @param buf
	 *            the buffer
	 */
	public abstract void read(PacketBuffer buf);
	
	/**
	 * Handles this packet client-side.
	 * 
	 * @param player
	 *            the player
	 */
	public abstract void handleClient(EntityPlayer player);
	
	/**
	 * Handler this packet server-side.
	 * 
	 * @param player
	 *            the player
	 */
	public abstract void handleServer(EntityPlayerMP player);
	
	// Helper methods
	
	/**
	 * Writes the given {@link World} to the {@link PacketBuffer} {@code buf}.
	 * This method only writes the dimension ID of the world to the buffer.
	 * 
	 * @param buf
	 *            the buffer
	 * @param world
	 *            the world
	 */
	public final void writeWorld(PacketBuffer buf, World world)
	{
		buf.writeInt(world.provider.dimensionId);
	}
	
	/**
	 * Reads a world object from the given {@link PacketBuffer} {@code buf}.
	 * This method only reads the dimension ID of the world from the buffer, and
	 * then uses {@link DimensionManager#getWorld(int)} to get the actual world
	 * object.
	 * 
	 * @param buf
	 *            the buffer
	 * @return the world
	 */
	public final World readWorld(PacketBuffer buf)
	{
		int id = buf.readInt();
		return DimensionManager.getWorld(id);
	}
	
	/**
	 * Writes the {@link ItemStack} {@code stack} to the {@link PacketBuffer}
	 * {@code buf}.
	 * 
	 * @param buf
	 * @param stack
	 */
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
	
	/**
	 * Reads an {@link ItemStack} from the given {@link PacketBuffer}
	 * {@code buf}.
	 * 
	 * @param buf
	 *            the buffer
	 * @param stack
	 *            the stack
	 */
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
