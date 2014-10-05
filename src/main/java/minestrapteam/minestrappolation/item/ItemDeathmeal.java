package minestrapteam.minestrappolation.item;

import minestrapteam.minestrappolation.lib.MBlocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemDeathmeal extends MItem
{
	@Override
	public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int meta, float hitX, float hitY, float hitZ)
	{
		Block block = world.getBlock(x, y, z);
		Material material = block.getMaterial();
		if (material == Material.plants || material == Material.vine)
		{
			world.setBlock(x, y, z, MBlocks.witherLayer);
			return true;
		}
		if (material == Material.leaves || material == Material.cactus || material == Material.gourd)
		{
			world.setBlock(x, y, z, MBlocks.witherBlock);
			return true;
		}
		return false;
	}
}
