package sobiohazardous.mods.minestrappolation.tileentity;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;

public class TileEntityLocked extends TileEntity
{
	protected boolean		locked;
	protected String		player;
	
	protected TileEntity	parent;
	
	@Override
	public void readFromNBT(NBTTagCompound nbt)
	{
		super.readFromNBT(nbt);
		this.player = nbt.getString("player");
		this.locked = nbt.getBoolean("locked");
		
		if (nbt.hasKey("TileEntity"))
		{
			this.parent = TileEntity.createAndLoadEntity(nbt.getCompoundTag("TileEntity"));
		}
	}
	
	@Override
	public void writeToNBT(NBTTagCompound nbt)
	{
		super.writeToNBT(nbt);
		nbt.setString("player", this.player);
		nbt.setBoolean("locked", this.locked);
		if (this.parent != null)
		{
			NBTTagCompound nbt1 = new NBTTagCompound();
			this.parent.writeToNBT(nbt1);
			nbt.setTag("TileEntity", nbt1);
		}
	}
	
	public void setParent(TileEntity parent)
	{
		this.parent = parent;
	}
	
	public TileEntity getParent()
	{
		return this.parent;
	}
	
	public void setPlayer(String name)
	{
		this.player = name;
	}
	
	public String getPlayer()
	{
		return this.player;
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
