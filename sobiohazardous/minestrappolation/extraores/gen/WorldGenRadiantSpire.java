package sobiohazardous.minestrappolation.extraores.gen;

import java.util.Random;

import sobiohazardous.minestrappolation.extraores.lib.EOBlockManager;

import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class WorldGenRadiantSpire extends WorldGenerator{

	@Override
	public boolean generate(World world, Random random, int i, int j, int k) {
		if(world.getBlockId(i, j, k) != Block.sand.blockID && world.getBlockId(i, j-1, k) != Block.sand.blockID && world.getBlockId(i+1, j, k) != Block.sand.blockID ){
			return false;
		}
		
		world.setBlock(i, j-3, k, EOBlockManager.RadiantQuartzOre.blockID);
		world.setBlock(i+1, j-3, k, EOBlockManager.RadiantQuartzOre.blockID);
		world.setBlock(i-1, j-3, k, EOBlockManager.RadiantQuartzOre.blockID);
		world.setBlock(i, j-3, k+1, EOBlockManager.RadiantQuartzOre.blockID);
		world.setBlock(i, j-3, k-1, EOBlockManager.RadiantQuartzOre.blockID);
		
		world.setBlock(i, j-2, k, EOBlockManager.RadiantQuartzOre.blockID);
		world.setBlock(i+1, j-2, k, EOBlockManager.RadiantQuartzOre.blockID);
		world.setBlock(i-1, j-2, k, EOBlockManager.RadiantQuartzOre.blockID);
		world.setBlock(i, j-2, k+1, EOBlockManager.RadiantQuartzOre.blockID);
		world.setBlock(i, j-2, k-1, EOBlockManager.RadiantQuartzOre.blockID);
		
		world.setBlock(i, j-1, k, EOBlockManager.RadiantQuartzOre.blockID);
		world.setBlock(i+1, j-1, k, EOBlockManager.RadiantQuartzOre.blockID);
		world.setBlock(i-1, j-1, k, EOBlockManager.RadiantQuartzOre.blockID);
		world.setBlock(i, j-1, k+1, EOBlockManager.RadiantQuartzOre.blockID);
		world.setBlock(i, j-1, k-1, EOBlockManager.RadiantQuartzOre.blockID);
		
		world.setBlock(i, j, k, EOBlockManager.RadiantQuartzOre.blockID);
		world.setBlock(i+1, j, k, EOBlockManager.RadiantQuartzOre.blockID);
		world.setBlock(i-1, j, k, EOBlockManager.RadiantQuartzOre.blockID);
		world.setBlock(i, j, k+1, EOBlockManager.RadiantQuartzOre.blockID);
		world.setBlock(i, j, k-1, EOBlockManager.RadiantQuartzOre.blockID);
		
		world.setBlock(i, j+1, k, EOBlockManager.RadiantQuartzOre.blockID);
		return true;
	}

}
