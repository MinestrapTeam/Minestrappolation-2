package minestrapteam.minestrappolation.tileentity;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;

public class TileEntityLocked extends TileEntity
{
	protected boolean		locked;
	protected String		owner;
	
	protected TileEntity	parent;
	
	public TileEntityLocked()
	{
	}
	
	public TileEntityLocked(String owner, TileEntity parent)
	{
		this.owner = owner;
		this.parent = parent;
	}
	
	@Override
	public void readFromNBT(NBTTagCompound nbt)
	{
		super.readFromNBT(nbt);
		this.owner = nbt.getString("Owner");
		this.locked = nbt.getBoolean("Locked");
		
		if (nbt.hasKey("TileEntity"))
		{
			this.parent = TileEntity.createAndLoadEntity(nbt.getCompoundTag("TileEntity"));
		}
	}
	
	@Override
	public void writeToNBT(NBTTagCompound nbt)
	{
		super.writeToNBT(nbt);
		nbt.setString("Owner", this.owner);
		nbt.setBoolean("Locked", this.locked);
		if (this.parent != null)
		{
			NBTTagCompound nbt1 = new NBTTagCompound();
			this.parent.writeToNBT(nbt1);
			nbt.setTag("TileEntity", nbt1);
		}
	}
	
	public boolean isOwner(String name)
	{
		return this.owner.equals(name);
	}
	
	public void lock()
	{
		this.locked = true;
	}
	
	public void unlock()
	{
		this.locked = false;
	}
	
	public boolean isLocked()
	{
		return this.locked;
	}
}
