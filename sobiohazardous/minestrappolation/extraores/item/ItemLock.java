package sobiohazardous.minestrappolation.extraores.item;

import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;
import sobiohazardous.minestrappolation.api.item.MItem;
import sobiohazardous.minestrappolation.extraores.tileentity.TileEntityLocked;

public class ItemLock extends MItem
{

	public ItemLock(int id)
	{
		super(id);
	}
	
    public boolean onItemUse(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, World par3World, int par4, int par5, int par6, int par7, float par8, float par9, float par10)
    {
    	TileEntityLocked te = (TileEntityLocked)par3World.getBlockTileEntity(par4, par5, par6);
    	
    	if(par1ItemStack.stackTagCompound == null)
    	{
    		this.createNBT(par1ItemStack, par2EntityPlayer);
    	}
    	
    	if(te != null && par1ItemStack.stackTagCompound != null && te.locked == false)
    	{
    		te.player = par1ItemStack.stackTagCompound.getString("player");
    		te.locked = true;
    		par2EntityPlayer.addChatMessage("Lock added!");
    		par1ItemStack.stackSize--;
    		return true;
    	}
    	
    	if(te !=null && te.locked)
    	{
    		par2EntityPlayer.addChatMessage("Already locked!");
    	}
    	
    	else
    	{
    		par2EntityPlayer.addChatMessage("Not applicable for a lock!");
    	}
    	
    	return false;
    }
    
    public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4)
    {
    	if(par1ItemStack.stackTagCompound == null)
    	{
    		this.createNBT(par1ItemStack, par2EntityPlayer);
    	}
    	
    	if(par1ItemStack.stackTagCompound != null)
    	{
    		if(par2EntityPlayer.getEntityName() != par1ItemStack.stackTagCompound.getString("player"))
    		{
    			par3List.add(EnumChatFormatting.GRAY + "Owner: " + EnumChatFormatting.RED + par1ItemStack.stackTagCompound.getString("player"));
    		}   
    		
    		if(par2EntityPlayer.getEntityName() == par1ItemStack.stackTagCompound.getString("player"))
    		{
    			par3List.add(EnumChatFormatting.GRAY + "Owner: " + EnumChatFormatting.GREEN + par1ItemStack.stackTagCompound.getString("player"));
    		}
    	}  	   	
    	par3List.add(EnumChatFormatting.RED + "WIP");	
    }
    
    public static void createNBT(ItemStack item, EntityPlayer player)
	{
		NBTTagCompound nbt = new NBTTagCompound();
		item.stackTagCompound = nbt;
		nbt.setString("player", player.getEntityName());
	}
}