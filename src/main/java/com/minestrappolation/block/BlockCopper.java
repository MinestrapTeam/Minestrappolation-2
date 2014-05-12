package com.minestrappolation.block;

import java.util.Random;

import com.minestrappolation.core.util.MCAssetManager;
import com.minestrappolation.lib.MBlocks;
import com.minestrappolation.lib.MConfig;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.world.World;

public class BlockCopper extends Block
{
	public BlockCopper(Material material)
	{
		super(material);
		this.setBlockTextureName(MCAssetManager.getTexture("blockCopper"));
	}
	
	@Override
	public int tickRate(World world)
	{
		return MConfig.daysUntilTarnish;
	}
	
	@Override
	public void updateTick(World world, int x, int y, int z, Random random)
	{
		world.setBlock(x, y, z, MBlocks.CopperBlockTarnished);
	}
}
