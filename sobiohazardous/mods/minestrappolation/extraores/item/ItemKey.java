package sobiohazardous.mods.minestrappolation.extraores.item;

import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;
import sobiohazardous.mods.minestrappolation.core.item.MItem;
import sobiohazardous.mods.minestrappolation.core.util.MChatMessageHandler;
import sobiohazardous.mods.minestrappolation.extraores.tileentity.TileEntityLocked;

public class ItemKey extends MItem
{
	public ItemKey()
	{
		super();
	}
	
	@Override
	public void onCreated(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
	{
		if (par1ItemStack.stackTagCompound == null)
		{
			ItemKey.createNBT(par1ItemStack, par3EntityPlayer);
		}
	}
	
	@Override
	public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4)
	{
		if (par1ItemStack.stackTagCompound == null)
		{
			ItemKey.createNBT(par1ItemStack, par2EntityPlayer);
		}
		
		if (par1ItemStack.stackTagCompound != null)
		{
			if (par2EntityPlayer.getDisplayName() != par1ItemStack.stackTagCompound.getString("player"))
			{
				par3List.add(EnumChatFormatting.GRAY + "Owner: " + EnumChatFormatting.RED + par1ItemStack.stackTagCompound.getString("player"));
			}
			
			if (par2EntityPlayer.getDisplayName() == par1ItemStack.stackTagCompound.getString("player"))
			{
				par3List.add(EnumChatFormatting.GRAY + "Owner: " + EnumChatFormatting.GREEN + par1ItemStack.stackTagCompound.getString("player"));
			}
		}
		par3List.add(EnumChatFormatting.RED + "WIP");
	}
	
	@Override
	public boolean onItemUse(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, World par3World, int par4, int par5, int par6, int par7, float par8, float par9, float par10)
	{
		TileEntityLocked te = (TileEntityLocked) par3World.getTileEntity(par4, par5, par6);
		
		if (par1ItemStack.stackTagCompound == null)
		{
			ItemKey.createNBT(par1ItemStack, par2EntityPlayer);
		}
		
		if (te != null && par1ItemStack.stackTagCompound != null && TileEntityLocked.locked == true)
		{
			// unlock
			return true;
		}
		else
		{
			MChatMessageHandler.sendChatToPlayer(par2EntityPlayer, "Not locked or not valid for lock.");
		}
		
		return false;
	}
	
	public static void createNBT(ItemStack item, EntityPlayer player)
	{
		NBTTagCompound nbt = new NBTTagCompound();
		item.stackTagCompound = nbt;
		nbt.setString("player", player.getDisplayName());
	}
}
