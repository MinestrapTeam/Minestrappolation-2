package minestrapteam.minestrappolation.network;

import java.io.IOException;

import clashsoft.cslib.minecraft.network.CSPacket;
import minestrapteam.minestrappolation.tileentity.TileEntityLocked;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.PacketBuffer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class LockedPacket extends CSPacket
{
	private World		world;
	private int			x;
	private int			y;
	private int			z;
	
	private String		owner;
	private Block		block;
	private TileEntity	tileEntity;
	
	public LockedPacket()
	{
	}
	
	public LockedPacket(World world, int x, int y, int z, String owner, Block block, TileEntity tileEntity)
	{
		this.world = world;
		this.x = x;
		this.y = y;
		this.z = z;
		this.owner = owner;
		this.block = block;
		this.tileEntity = tileEntity;
	}
	
	@Override
	public void handleClient(EntityPlayer player)
	{
		World world = player.worldObj;
		TileEntity te = world.getTileEntity(this.x, this.y, this.z);
		if (te instanceof TileEntityLocked)
		{
			TileEntityLocked locked = (TileEntityLocked) te;
			locked.setOwner(this.owner);
			locked.setBlock(this.block);
			locked.setTileEntity(this.tileEntity);
		}
	}
	
	@Override
	public void handleServer(EntityPlayerMP player)
	{
	}
	
	@Override
	public void read(PacketBuffer buf)
	{
		this.world = readWorld(buf);
		this.x = buf.readInt();
		this.y = buf.readInt();
		this.z = buf.readInt();
		
		try
		{
			this.owner = buf.readStringFromBuffer(64);
			this.block = Block.getBlockById(buf.readInt());
			this.tileEntity = TileEntity.createAndLoadEntity(buf.readNBTTagCompoundFromBuffer());
		}
		catch (IOException ex)
		{
		}
	}
	
	@Override
	public void write(PacketBuffer buf)
	{
		writeWorld(buf, this.world);
		buf.writeInt(this.x);
		buf.writeInt(this.y);
		buf.writeInt(this.z);
		
		try
		{
			buf.writeStringToBuffer(this.owner);
			buf.writeInt(Block.getIdFromBlock(this.block));
			NBTTagCompound nbt = null;
			if (this.tileEntity != null)
			{
				nbt = new NBTTagCompound();
				this.tileEntity.writeToNBT(nbt);
			}
			buf.writeNBTTagCompoundToBuffer(nbt);
		}
		catch (IOException ex)
		{
		}
	}
}
