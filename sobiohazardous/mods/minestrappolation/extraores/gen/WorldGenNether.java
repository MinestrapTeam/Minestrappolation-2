package sobiohazardous.mods.minestrappolation.extraores.gen;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class WorldGenNether extends WorldGenerator
{
	/** The block ID of the ore to be placed using this generator. */
	private Block	minableBlockId;
	
	/** The number of blocks to generate. */
	private int		numberOfBlocks;
	
	public WorldGenNether(Block par1, int par2)
	{
		this.minableBlockId = par1;
		this.numberOfBlocks = par2;
	}
	
	@Override
	public boolean generate(World par1World, Random par2Random, int par3, int par4, int par5)
	{
		float f = par2Random.nextFloat() * (float) Math.PI;
		double d = par3 + 8 + MathHelper.sin(f) * this.numberOfBlocks / 8F;
		double d1 = par3 + 8 - MathHelper.sin(f) * this.numberOfBlocks / 8F;
		double d2 = par5 + 8 + MathHelper.cos(f) * this.numberOfBlocks / 8F;
		double d3 = par5 + 8 - MathHelper.cos(f) * this.numberOfBlocks / 8F;
		double d4 = par4 + par2Random.nextInt(3) - 2;
		double d5 = par4 + par2Random.nextInt(3) - 2;
		
		for (int i = 0; i <= this.numberOfBlocks; i++)
		{
			double d6 = d + (d1 - d) * i / this.numberOfBlocks;
			double d7 = d4 + (d5 - d4) * i / this.numberOfBlocks;
			double d8 = d2 + (d3 - d2) * i / this.numberOfBlocks;
			double d9 = par2Random.nextDouble() * this.numberOfBlocks / 16D;
			double d10 = (MathHelper.sin(i * (float) Math.PI / this.numberOfBlocks) + 1.0F) * d9 + 1.0D;
			double d11 = (MathHelper.sin(i * (float) Math.PI / this.numberOfBlocks) + 1.0F) * d9 + 1.0D;
			int j = MathHelper.floor_double(d6 - d10 / 2D);
			int k = MathHelper.floor_double(d7 - d11 / 2D);
			int l = MathHelper.floor_double(d8 - d10 / 2D);
			int i1 = MathHelper.floor_double(d6 + d10 / 2D);
			int j1 = MathHelper.floor_double(d7 + d11 / 2D);
			int k1 = MathHelper.floor_double(d8 + d10 / 2D);
			
			for (int l1 = j; l1 <= i1; l1++)
			{
				double d12 = (l1 + 0.5D - d6) / (d10 / 2D);
				
				if (d12 * d12 >= 1.0D)
				{
					continue;
				}
				
				for (int i2 = k; i2 <= j1; i2++)
				{
					double d13 = (i2 + 0.5D - d7) / (d11 / 2D);
					
					if (d12 * d12 + d13 * d13 >= 1.0D)
					{
						continue;
					}
					
					for (int j2 = l; j2 <= k1; j2++)
					{
						double d14 = (j2 + 0.5D - d8) / (d10 / 2D);
						
						if (d12 * d12 + d13 * d13 + d14 * d14 < 1.0D && par1World.getBlock(l1, i2, j2) == Blocks.netherrack)
						{
							par1World.setBlock(l1, i2, j2, this.minableBlockId);
						}
					}
				}
			}
		}
		
		return true;
	}
}
