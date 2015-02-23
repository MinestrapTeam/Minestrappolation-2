package minestrapteam.minestrappolation.block.storage;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.world.World;

public abstract class BlockInsulatedRadiation extends BlockRadiation
{
	protected BlockInsulatedRadiation(Material material)
	{
		super(material);
	}
	
	@Override
	public void updateTick(World world, int x, int y, int z, Random random)
	{
		if (!world.isRemote && world.isBlockIndirectlyGettingPowered(x, y, z))
		{
			super.updateTick(world, x, y, z, random);
		}
	}
	
	@Override
	public void onNeighborBlockChange(World world, int x, int y, int z, Block block)
	{
		if (!world.isRemote && world.isBlockIndirectlyGettingPowered(x, y, z))
		{
			world.scheduleBlockUpdate(x, y, z, this, 1);
		}
	}
}
