package minestrapteam.minestrappolation.block;

import minestrapteam.minestrappolation.world.WorldGenBaseTree;
import minestrapteam.minestrappolation.world.WorldGenRedWoodTree;

public class BlockRedwoodSapling extends MBlockSapling
{
	@Override
	public WorldGenBaseTree getTreeToGrow()
	{
		return new WorldGenRedWoodTree();
	}

}
