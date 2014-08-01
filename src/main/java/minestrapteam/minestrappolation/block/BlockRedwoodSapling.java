package minestrapteam.minestrappolation.block;

import minestrapteam.minestrappolation.world.gen.WorldGenBaseTree;
import minestrapteam.minestrappolation.world.gen.WorldGenRedWoodTree;

public class BlockRedwoodSapling extends MBlockSapling
{
	@Override
	public WorldGenBaseTree getTreeToGrow()
	{
		return new WorldGenRedWoodTree();
	}

}
