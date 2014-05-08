package sobiohazardous.mods.minestrappolation.extradecor.block;

import java.util.Random;

import sobiohazardous.mods.minestrappolation.core.block.MBlock;
import sobiohazardous.mods.minestrappolation.extradecor.lib.EDBlocks;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.common.util.ForgeDirection;

public class EDBlock extends MBlock
{
	public EDBlock(Material material)
	{
		super(material);
		this.setCreativeTab(EDBlocks.tabDecor);
	}
	
	@Override
	public Item getItemDropped(int p_149650_1_, Random p_149650_2_, int p_149650_3_)
	{
		return Item.getItemFromBlock(this);
	}
	
	/*
	 * public boolean canDragonDestroy(World world, int x, int y, int z) {
	 * return blockID != obsidian.blockID && blockID != whiteStone.blockID &&
	 * blockID != bedrock.blockID; }
	 */
	
	@Override
	public int getFlammability(IBlockAccess world, int x, int y, int z, ForgeDirection face)
	{
		if (world.getBlock(x, y, z) == EDBlocks.woodPanel || world.getBlock(x, y, z) == EDBlocks.woodBeveled)
		{
			if (face == ForgeDirection.UP || face == ForgeDirection.DOWN || face == ForgeDirection.NORTH || face == ForgeDirection.SOUTH || face == ForgeDirection.EAST || face == ForgeDirection.WEST)
			{
				return 75;
			}
			else
			{
				return 0;
			}
		}
		else
		{
			return 0;
		}
	}
}
