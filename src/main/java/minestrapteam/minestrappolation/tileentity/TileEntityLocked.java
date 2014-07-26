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
	
	public TileEntityLocked()
	{
	}
	
	public TileEntityLocked(String owner)
	{
		this.owner = owner;
	}
	
	public void setOwner(String owner)
	{
		this.owner = owner;
	}
	
	public void setBlock(Block block, TileEntity tileEntity)
	{
		this.block = block;
		this.tileEntity = tileEntity;
		
		if (!this.getWorldObj().isRemote)
		{
			Minestrappolation.instance.netHandler.sendToAll(new LockedPacket(this.getWorldObj(), this.xCoord, this.yCoord, this.zCoord, this.owner, block, tileEntity));
		}
	}
	
	public void setBlock(Block block)
	{
		this.block = block;
	}
	
	public void setTileEntity(TileEntity tileEntity)
	{
		this.tileEntity = tileEntity;
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
		return this.owner.equals(name);
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
