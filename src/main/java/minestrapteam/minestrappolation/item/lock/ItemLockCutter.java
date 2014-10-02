package minestrapteam.minestrappolation.item.lock;

import minestrapteam.minestrappolation.lib.MBlocks;
import minestrapteam.minestrappolation.lib.MItems;

import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.world.World;

public class ItemLockCutter extends Item
{
	@Override
	public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ)
	{
		if (world.getBlock(x, y, z) == MBlocks.lockedBlock)
		{
			if (MBlocks.lockedBlock.unlock(null, world, x, y, z))
			{
				// Drops the broken lock
				ItemStack stack1 = new ItemStack(MItems.steelLock, 1, 1);
				double d0 = x + world.rand.nextFloat() * 0.7D + 0.15D;
	            double d1 = y + world.rand.nextFloat() * 0.7D + 0.15D;
	            double d2 = z + world.rand.nextFloat() * 0.7D + 0.15D;
	            EntityItem entityitem = new EntityItem(world, d0, d1, d2, stack1);
	            entityitem.delayBeforeCanPickup = 10;
	            world.spawnEntityInWorld(entityitem);
				
				return true;
			}
			else
			{
				player.addChatMessage(new ChatComponentTranslation("lock.not_owner"));
			}
		}
		return false;
	}
}
