package sobiohazardous.minestrappolation.extraores.tileentity;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;

public class TileEntityLocked extends TileEntity
{
	public static String player = "";
	public static boolean locked = false;
	
    public void readFromNBT(NBTTagCompound par1NBTTagCompound)
    {
    	super.readFromNBT(par1NBTTagCompound);
    	this.player = par1NBTTagCompound.getString("player");
    	this.locked = par1NBTTagCompound.getBoolean("locked");
    }
    
    public void writeToNBT(NBTTagCompound par1NBTTagCompound)
    {
    	super.writeToNBT(par1NBTTagCompound);
    	par1NBTTagCompound.setString("player", player);
    	par1NBTTagCompound.setBoolean("locked", locked);
    }
    
    public void setPlayer(String name)
    {
    	this.player = name;
    }

}
