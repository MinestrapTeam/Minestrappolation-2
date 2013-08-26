package sobiohazardous.minestrappolation.extraores.block;

import sobiohazardous.minestrappolation.extraores.ExtraOres;
import net.minecraft.block.Block;
import net.minecraft.block.BlockStairs;

public class EOBlockStairs extends BlockStairs
{
	public EOBlockStairs(int id, Block block, int blockmeta)
	{
		super(id, block, blockmeta);
		this.setCreativeTab(ExtraOres.tabOresBlocks);
	}
}
