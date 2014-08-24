package minestrapteam.minestrappolation.item;

import minestrapteam.minestrappolation.lib.MBlocks;
import net.minecraft.block.IGrowable;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemDeathmeal extends MItem
{
	public boolean onItemUse(ItemStack item, EntityPlayer player, World world, int x, int y, int z, int meta, float something, float i, float dontknow)
    {
		if(world.getBlock(x, y, z) instanceof IGrowable && world.getBlock(x, y, z) != Blocks.grass)
		{
			world.setBlock(x, y, z, MBlocks.witherLayer);
			return true;
		}				
        return false;
    }

}
