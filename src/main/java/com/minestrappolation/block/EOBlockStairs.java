package com.minestrappolation.block;

import com.minestrappolation.Minestrappolation;

import net.minecraft.block.Block;
import net.minecraft.block.BlockStairs;

public class EOBlockStairs extends BlockStairs
{
	public EOBlockStairs(Block block, int blockmeta)
	{
		super(block, blockmeta);
		this.setCreativeTab(Minestrappolation.tabBuildingBlocks);
		this.setLightOpacity(255);
	}
}
