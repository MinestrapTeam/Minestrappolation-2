package minestrapteam.minestrappolation.item;

import java.util.List;

import minestrapteam.minestrappolation.lib.MBlocks;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;

public class ItemKey extends MItem
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
			ItemKey.createNBT(stack, null);
		}
		
		String name = getOwner(stack);
		if (name.isEmpty())
		{
			list.add(EnumChatFormatting.GRAY + "No Owner");
		}
		else if (isOwner(name, player))
		{
			list.add(EnumChatFormatting.GRAY + "Owner: " + EnumChatFormatting.GREEN + name);
		}
		else
		{
			list.add(EnumChatFormatting.GRAY + "Owner: " + EnumChatFormatting.RED + name);
		}
	}
	
	@Override
	public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ)
	{
		if (world.isRemote)
		{
			return true;
		}
		
		String name = getOwner(stack);
		if (name.isEmpty())
		{
			createNBT(stack, player);
			return false;
		}
		else if (!isOwner(name, player))
		{
			player.addChatMessage(new ChatComponentTranslation("lock.not_owner"));
			return false;
		}
		
		if (world.getBlock(x, y, z) == MBlocks.lockedBlock)
		{
			if (MBlocks.lockedBlock.unlock(name, world, x, y, z))
			{
				return true;
			}
			else
			{
				player.addChatMessage(new ChatComponentTranslation("lock.not_owner"));
			}
		}
		else
		{
			player.addChatMessage(new ChatComponentTranslation("lock.not_locked"));
		}
		
		return false;
	}
	
	public static void createNBT(ItemStack stack, EntityPlayer player)
	{
		String name = player == null ? "" : player.getDisplayName();
		
		if (stack.stackTagCompound == null)
		{
			stack.stackTagCompound = new NBTTagCompound();
		}
		stack.stackTagCompound.setString("LockOwner", name);
	}
	
	public static String getOwner(ItemStack stack)
	{
		if (stack.stackTagCompound == null)
		{
			return "";
		}
		return stack.stackTagCompound.getString("LockOwner");
	}
	
	public static boolean isOwner(String ownerName, EntityPlayer player)
	{
		if (ownerName.isEmpty())
		{
			return true;
		}
		if (!player.getDisplayName().equals(ownerName))
		{
			return false;
		}
		return true;
	}
}
