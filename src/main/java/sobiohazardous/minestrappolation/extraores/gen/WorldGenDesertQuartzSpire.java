package sobiohazardous.minestrappolation.extraores.gen;

import java.util.Random;

import sobiohazardous.minestrappolation.extraores.lib.EOBlockManager;

import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class WorldGenDesertQuartzSpire extends WorldGenerator{

	Random rand = new Random();
	// add 2 so if you want a depth or 5 you use 3
	int maxDepth = 6;
	
	// how tall the tip of the spire is
	int maxTopHeight = 3;
	@Override
	public boolean generate(World world, Random random, int i, int j, int k) {
		if(world.getBlockId(i, j, k) != Block.sand.blockID && world.getBlockId(i, j-1, k) != Block.sand.blockID && world.getBlockId(i+1, j, k) != Block.sand.blockID && world.getBlockId(i, j-1, k) != Block.sand.blockID){
			return false;
		}else if(world.getBlockId(i, j, k) == Block.waterStill.blockID || world.getBlockId(i, j+1, k) == Block.waterStill.blockID || world.getBlockId(i, j-1, k) == Block.waterStill.blockID || world.getBlockId(i+1, j, k) == Block.waterStill.blockID || world.getBlockId(i-1, j, k) == Block.waterStill.blockID ){
			System.out.println("water found skipping");
			return false;
		}else if(world.getBlockId(i, j+1, k) != 0){
			System.out.println("not air skipping");
			return false;
		}
		
	
		int a;
		int randTopHeight;
		a = rand.nextInt(this.maxDepth);
		randTopHeight = rand.nextInt(3);
		    for(int z = 0; z <a+2; z++){
		    	world.setBlock(i, j-z, k, EOBlockManager.Quartzite.blockID);
				world.setBlock(i+1, j-z, k, EOBlockManager.Quartzite.blockID);
				world.setBlock(i-1, j-z, k, EOBlockManager.Quartzite.blockID);
				world.setBlock(i, j-z, k+1, EOBlockManager.Quartzite.blockID);
				world.setBlock(i, j-z, k-1, EOBlockManager.Quartzite.blockID);
				
		    }
		
			world.setBlock(i, j, k, EOBlockManager.Quartzite.blockID);
			world.setBlock(i+1, j, k, EOBlockManager.Quartzite.blockID);
			world.setBlock(i-1, j, k, EOBlockManager.Quartzite.blockID);
			world.setBlock(i, j, k+1, EOBlockManager.Quartzite.blockID);
			world.setBlock(i, j, k-1, EOBlockManager.Quartzite.blockID);
			
			for(int height = 0; height < randTopHeight; height++){
				world.setBlock(i, j+randTopHeight, k, EOBlockManager.Quartzite.blockID);	
			}
			
			world.setBlock(i, j+1, k, EOBlockManager.Quartzite.blockID);	
									
		System.out.println("Spire at: x-"+ i +",y-"+j+",z-"+k);
		return true;
	}

}
