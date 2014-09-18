package minestrapteam.minestrappolation.block;

import minestrapteam.minestrappolation.lib.MBlocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.world.IBlockAccess;

public class MBlock extends Block
{
	public MBlock(Material material)
	{
		super(material);
	}
	
	@Override
	public boolean isBeaconBase(IBlockAccess world, int x, int y, int z, int beaconX, int beaconY, int beaconZ)
	{
		return this == MBlocks.bronzeBlock || this == MBlocks.titaniumBlock || this == MBlocks.titaniumBlock || this == MBlocks.toriteBlock;
	}
}
