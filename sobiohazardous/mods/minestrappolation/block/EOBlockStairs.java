package sobiohazardous.mods.minestrappolation.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockStairs;
import sobiohazardous.mods.minestrappolation.Minestrappolation;

public class EOBlockStairs extends BlockStairs
{
	public EOBlockStairs(Block block, int blockmeta)
	{
		super(block, blockmeta);
		this.setCreativeTab(Minestrappolation.tabBuildingBlocks);
		this.setLightOpacity(255);
	}
}
