package sobiohazardous.minestrappolation.extraores.gen;

import java.util.Random;

import sobiohazardous.minestrappolation.extraores.lib.EOBlockManager;

import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class WorldGenRadiantSpire extends WorldGenerator{

	Random rand = new Random();
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
		int b;
		a = rand.nextInt(6);
		b = rand.nextInt(3);
		    for(int z = 0; z <a+2; z++){
		    	world.setBlock(i, j-z, k, EOBlockManager.RadiantQuartzOre.blockID);
				world.setBlock(i+1, j-z, k, EOBlockManager.RadiantQuartzOre.blockID);
				world.setBlock(i-1, j-z, k, EOBlockManager.RadiantQuartzOre.blockID);
				world.setBlock(i, j-z, k+1, EOBlockManager.RadiantQuartzOre.blockID);
				world.setBlock(i, j-z, k-1, EOBlockManager.RadiantQuartzOre.blockID);
				
		    }
		
			world.setBlock(i, j, k, EOBlockManager.RadiantQuartzOre.blockID);
			world.setBlock(i+1, j, k, EOBlockManager.RadiantQuartzOre.blockID);
			world.setBlock(i-1, j, k, EOBlockManager.RadiantQuartzOre.blockID);
			world.setBlock(i, j, k+1, EOBlockManager.RadiantQuartzOre.blockID);
			world.setBlock(i, j, k-1, EOBlockManager.RadiantQuartzOre.blockID);
			
			for(int height = 0; height < b; height++){
				world.setBlock(i, j+b, k, EOBlockManager.RadiantQuartzOre.blockID);	
			}
			
			world.setBlock(i, j+1, k, EOBlockManager.RadiantQuartzOre.blockID);	
									
		System.out.println("Spire at: x"+ i +"y,"+j+",z"+k);
		return true;
	}

}
