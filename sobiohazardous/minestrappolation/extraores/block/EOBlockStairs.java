package sobiohazardous.minestrappolation.extraores.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockStairs;
import sobiohazardous.minestrappolation.extraores.lib.EOBlockManager;

public class EOBlockStairs extends BlockStairs
{
	public EOBlockStairs(int id, Block block, int blockmeta)
	{
		super(id, block, blockmeta);
		this.setCreativeTab(EOBlockManager.tabOresBlocks);
	}
}
