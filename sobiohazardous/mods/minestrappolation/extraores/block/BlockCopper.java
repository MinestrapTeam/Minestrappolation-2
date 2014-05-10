package sobiohazardous.mods.minestrappolation.extraores.block;

import java.util.Random;

import sobiohazardous.mods.minestrappolation.core.util.MAssetManager;
import sobiohazardous.mods.minestrappolation.extraores.lib.EOBlocks;
import sobiohazardous.mods.minestrappolation.extraores.lib.EOConfig;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.world.World;

public class BlockCopper extends Block
{
	public BlockCopper(Material material)
	{
		super(material);
		this.setBlockTextureName(MAssetManager.getEOTexture("blockCopper"));
	}
	
	@Override
	public int tickRate(World world)
	{
		return EOConfig.daysUntilTarnish;
	}
	
	@Override
	public void updateTick(World world, int x, int y, int z, Random random)
	{
		world.setBlock(x, y, z, EOBlocks.CopperBlockTarnished);
	}
}
