package sobiohazardous.minestrappolation.extraores.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockStairs;
import sobiohazardous.minestrappolation.extraores.lib.EOBlockManager;

public class EOBlockStairs extends BlockStairs
{
	public EOBlockStairs(Block block, int blockmeta)
	{
		super(block, blockmeta);
		this.setCreativeTab(EOBlockManager.tabOresBlocks);
		this.setLightOpacity(255);
	}
}
