package sobiohazardous.minestrappolation.extradecor.tileentity;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;

public class TileEntity100 extends TileEntity{
	int metadata = 1000;
	
	public int getMetaData(){
		return metadata;
	}
	
	@Override
	public void writeToNBT(NBTTagCompound nbt)
	{
	nbt.setInteger("metadata", this.blockMetadata);
	super.writeToNBT(nbt);
	}
	
	@Override
	public void readFromNBT(NBTTagCompound nbt)
	{
		metadata = nbt.getInteger("metadata");
		super.readFromNBT(nbt);
	}

}
