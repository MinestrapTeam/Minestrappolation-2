package minestrapteam.minestrappolation.network;

import java.io.IOException;

import clashsoft.cslib.minecraft.network.CSPacket;
import minestrapteam.minestrappolation.tileentity.TileEntityPlate;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketBuffer;
import net.minecraft.world.World;

public class PlatePacket extends CSPacket
{
	private World		world;
	private int			x;
	private int			y;
	private int			z;
	private ItemStack	stack;
	
	public PlatePacket()
	{
	}
	
	public PlatePacket(World world, int x, int y, int z, ItemStack stack)
	{
		this.world = world;
		this.x = x;
		this.y = y;
		this.z = z;
		this.stack = stack;
	}
	
	@Override
	public void handleClient(EntityPlayer player)
	{
		TileEntityPlate plate = (TileEntityPlate) player.worldObj.getTileEntity(this.x, this.y, this.z);
		if (plate != null)
		{
			plate.setItem(this.stack, false);
		}
	}
	
	@Override
	public void handleServer(EntityPlayerMP player)
	{
		TileEntityPlate plate = (TileEntityPlate) this.world.getTileEntity(this.x, this.y, this.z);
		if (plate != null)
		{
			plate.setItem(this.stack);
		}
	}
	
	@Override
	public void read(PacketBuffer buf) throws IOException
	{
		this.world = readWorld(buf);
		this.x = buf.readInt();
		this.y = buf.readInt();
		this.z = buf.readInt();
		this.stack = readItemStack(buf);
	}
	
	@Override
	public void write(PacketBuffer buf) throws IOException
	{
		writeWorld(buf, this.world);
		buf.writeInt(this.x);
		buf.writeInt(this.y);
		buf.writeInt(this.z);
		writeItemStack(buf, this.stack);
	}
}
