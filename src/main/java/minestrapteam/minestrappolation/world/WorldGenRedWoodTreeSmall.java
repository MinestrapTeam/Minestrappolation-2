package minestrapteam.minestrappolation.world;

import java.util.Random;

import minestrapteam.mcore.lib.MCBlocks;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;

public class WorldGenRedWoodTreeSmall extends WorldGenBaseTree{

	int leafStart = 5;
	int leafSpacing = 2;
	
	public WorldGenRedWoodTreeSmall() {
		super(MCBlocks.redwoodLog, 1, MCBlocks.redwoodLeaves, 1, 18, 13, 1);
		
	}

	@Override
	public boolean genLeafStructure(World world, Random rand, int x, int y,int z) 
	{
		setBlock(world , x , y + this.topHeight, z, leaves, lMeta);
		
		double thickness = 4;
		for (int r = leafStart; r < this.topHeight; r++)
		{
			if ( r % leafSpacing == 0)
			{
				this.generateLeafCircles( world , rand , thickness , x , z , y + r);
				thickness -= .4;
			}
		}
		return true;
	}

	@Override
	public boolean genExtras(World world, Random rand, int x, int y, int z) 
	{
		return false;
	}

}
