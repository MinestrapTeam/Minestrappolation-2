package minestrapteam.minestrappolation.block.plant;

import minestrapteam.minestrappolation.block.MBlockSapling;
import minestrapteam.minestrappolation.world.gen.WorldGenBaseTree;
import minestrapteam.minestrappolation.world.gen.WorldGenRedWoodTree;
import minestrapteam.minestrappolation.world.gen.WorldGenRedWoodTreeSmall;

public class BlockRedwoodSapling extends MBlockSapling
{
	@Override
	public WorldGenBaseTree getTreeToGrow(int metadata, boolean big)
	{
		return big ? new WorldGenRedWoodTree() : new WorldGenRedWoodTreeSmall();
	}
	
}
