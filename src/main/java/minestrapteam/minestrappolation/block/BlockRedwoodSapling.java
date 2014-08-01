package minestrapteam.minestrappolation.block;

import minestrapteam.minestrappolation.world.gen.feature.WorldGenBaseTree;
import minestrapteam.minestrappolation.world.gen.feature.WorldGenRedWoodTree;

public class BlockRedwoodSapling extends MBlockSapling
{
	@Override
	public WorldGenBaseTree getTreeToGrow()
	{
		return new WorldGenRedWoodTree();
	}

}
