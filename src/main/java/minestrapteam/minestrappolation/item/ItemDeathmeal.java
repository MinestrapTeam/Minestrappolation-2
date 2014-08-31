package minestrapteam.minestrappolation.item;

import minestrapteam.minestrappolation.lib.MBlocks;

import net.minecraft.block.Block;
import net.minecraft.block.IGrowable;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemDeathmeal extends MItem
{
	@Override
	public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int meta, float hitX, float hitY, float hitZ)
	{
		Block block = world.getBlock(x, y, z);
		if (block != Blocks.grass && block instanceof IGrowable)
		{
			world.setBlock(x, y, z, MBlocks.witherLayer);
			return true;
		}
		return false;
	}
}
