package minestrapteam.minestrappolation.tileentity;

import minestrapteam.minestrappolation.Minestrappolation;
import minestrapteam.minestrappolation.network.LockedPacket;

import net.minecraft.block.Block;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;

public class TileEntityLocked extends TileEntity
{
	protected String		owner;
	protected Block			block;
	protected TileEntity	tileEntity;
	
	private boolean			dirty;
	
	public TileEntityLocked()
	{
	}
	
	public TileEntityLocked(String owner)
	{
		this.owner = owner;
	}
	
	public void setOwner(String owner)
	{
		this.markDirty();
		this.owner = owner;
	}
	
	public void setBlock(Block block)
	{
		this.markDirty();
		this.block = block;
	}
	
	public void setTileEntity(TileEntity tileEntity)
	{
		this.markDirty();
		this.tileEntity = tileEntity;
	}
	
	public String getOwner()
	{
		return this.owner;
	}
	
	public Block getBlock()
	{
		return this.block;
	}
	
	public TileEntity getTileEntity()
	{
		return this.tileEntity;
	}
	
	public boolean isOwner(String name)
	{
		if (name == null || name.isEmpty())
		{
			return false;
		}
		else if (this.owner == null || this.owner.isEmpty())
		{
			return true;
		}
		return name.equals(this.owner);
	}
	
	@Override
	public void markDirty()
	{
		this.dirty = true;
		super.markDirty();
	}
	
	@Override
	public void updateEntity()
	{
		if (this.dirty)
		{
			this.dirty = false;
			if (!this.getWorldObj().isRemote)
			{
				Minestrappolation.instance.netHandler.sendToAll(new LockedPacket(this.getWorldObj(), this.xCoord, this.yCoord, this.zCoord, this.owner, this.block, this.tileEntity));
			}
		}
	}
	
	@Override
	public void readFromNBT(NBTTagCompound nbt)
	{
		super.readFromNBT(nbt);
		
		this.owner = nbt.getString("Owner");
		this.block = Block.getBlockById(nbt.getInteger("BlockID"));
		if (nbt.hasKey("TileEntity"))
		{
			this.tileEntity = TileEntity.createAndLoadEntity(nbt.getCompoundTag("TileEntity"));
		}
	}
	
	@Override
	public void writeToNBT(NBTTagCompound nbt)
	{
		super.writeToNBT(nbt);
		
		nbt.setString("Owner", this.owner);
		nbt.setInteger("BlockID", Block.getIdFromBlock(this.block));
		if (this.tileEntity != null)
		{
			NBTTagCompound nbt1 = new NBTTagCompound();
			this.tileEntity.writeToNBT(nbt1);
			nbt.setTag("TileEntity", nbt1);
		}
	}
}
