package minestrapteam.minestrappolation.item;

import minestrapteam.minestrappolation.lib.MBlocks;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.world.World;

public class ItemLock extends ItemKey
{
	public ItemLock()
	{
		super();
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
			player.addChatMessage(new ChatComponentTranslation("lock.already_locked"));
			return false;
		}
		
		if (MBlocks.lockedBlock.lock(name, world, x, y, z))
		{
			stack.stackSize--;
			player.addChatMessage(new ChatComponentTranslation("lock.added"));
			return true;
		}
		else
		{
			player.addChatMessage(new ChatComponentTranslation("lock.not_applicable"));
		}
		
		return false;
	}
}
