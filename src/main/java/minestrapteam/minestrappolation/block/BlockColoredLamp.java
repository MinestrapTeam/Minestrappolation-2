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
		int color = ItemDye.field_150922_c[metadata];
		float r = ((color >> 16) & 0xFF) / 255F;
		float g = ((color >> 8) & 0xFF) / 255F;
		float b = ((color >> 0) & 0xFF) / 255F;
		
		float f = 1F / Math.max(Math.max(r, g), b);
		r *= f;
		g *= f;
		b *= f;
		
		return CSBlocks.getLightValue(r, g, b, 1F);
	}
}
