package sobiohazardous.mods.minestrappolation.extraores.tileentity;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;

public class TileEntityLocked extends TileEntity
{
	public static String	player	= "";
	public static boolean	locked	= false;
	
	@Override
	public void readFromNBT(NBTTagCompound par1NBTTagCompound)
	{
		super.readFromNBT(par1NBTTagCompound);
		TileEntityLocked.player = par1NBTTagCompound.getString("player");
		TileEntityLocked.locked = par1NBTTagCompound.getBoolean("locked");
	}
	
	@Override
	public void writeToNBT(NBTTagCompound par1NBTTagCompound)
	{
		super.writeToNBT(par1NBTTagCompound);
		par1NBTTagCompound.setString("player", player);
		par1NBTTagCompound.setBoolean("locked", locked);
	}
	
	public void setPlayer(String name)
	{
		TileEntityLocked.player = name;
	}
	
}
