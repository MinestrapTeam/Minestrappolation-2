package minestrapteam.minestrappolation.item;

import java.util.List;

import minestrapteam.mcore.item.MCItem;
import minestrapteam.minestrappolation.tileentity.TileEntityLocked;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;

public class ItemKey extends MCItem
{
	public ItemKey()
	{
		super();
	}
	
	@Override
	public void onCreated(ItemStack stack, World world, EntityPlayer player)
	{
		if (stack.stackTagCompound == null)
		{
			ItemKey.createNBT(stack, player);
		}
	}
	
	@Override
	public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean flag)
	{
		if (stack.stackTagCompound == null)
		{
			ItemKey.createNBT(stack, player);
		}
		String name = stack.stackTagCompound.getString("player");
		if (player.getDisplayName().equals(name))
		{
			list.add(EnumChatFormatting.GRAY + "Owner: " + EnumChatFormatting.GREEN + name);
		}
		else
		{
			list.add(EnumChatFormatting.GRAY + "Owner: " + EnumChatFormatting.RED + name);
		}
		
		list.add(EnumChatFormatting.RED + "WIP");
	}
	
	@Override
	public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ)
	{
		if (world.isRemote)
		{
			return true;
		}
		
		if (stack.stackTagCompound == null)
		{
			createNBT(stack, player);
		}
		
		TileEntity te = world.getTileEntity(x, y, z);
		if (te instanceof TileEntityLocked)
		{
			String name = stack.stackTagCompound.getString("player");
			TileEntityLocked locked = (TileEntityLocked) te;
			if (locked.isOwner(name))
			{
				if (locked.isLocked())
				{
					locked.unlock();
				}
				else
				{
					locked.lock();
				}
				return true;
			}
			else
			{
				player.addChatMessage(new ChatComponentTranslation("lock.not_owner"));
			}
		}
		else
		{
			player.addChatMessage(new ChatComponentTranslation("lock.not_applicable"));
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
