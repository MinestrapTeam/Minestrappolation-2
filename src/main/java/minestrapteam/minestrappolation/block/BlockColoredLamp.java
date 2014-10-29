package minestrapteam.minestrappolation.block;

import net.minecraft.item.ItemDye;
import net.minecraft.world.IBlockAccess;

import clashsoft.cslib.minecraft.block.BlockCustomLamp;
import clashsoft.cslib.minecraft.block.CSBlocks;

public class BlockColoredLamp extends BlockCustomLamp
{
	public BlockColoredLamp(String[] names, Object icons)
	{
		super(names, icons, true);
	}
	
	@Override
	public int getLightValue(IBlockAccess world, int x, int y, int z)
	{
		int metadata = world.getBlockMetadata(x, y, z);
		return CSBlocks.getLightValue(ItemDye.field_150922_c[metadata], 1F);
	}
}
