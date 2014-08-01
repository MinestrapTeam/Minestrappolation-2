package minestrapteam.minestrappolation.block;

import java.util.Random;

import minestrapteam.minestrappolation.world.gen.WorldGenBaseTree;

import net.minecraft.block.BlockBush;
import net.minecraft.block.IGrowable;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.event.terraingen.TerrainGen;

public abstract class MBlockSapling extends BlockBush implements IGrowable
{
	public MBlockSapling()
	{
		this.setBlockBounds(0.1F, 0.0F, 0.4F, 0.9F, 0.8F, 0.9F);
	}
	
	@Override
	public void updateTick(World world, int x, int y, int z, Random random)
	{
		if (!world.isRemote)
		{
			super.updateTick(world, x, y, z, random);
			
			if (world.getBlockLightValue(x, y + 1, z) >= 9 && random.nextInt(7) == 0)
			{
				this.growTree(world, x, y, z, random);
			}
		}
	}
	
	public abstract WorldGenBaseTree getTreeToGrow();
	
	public void growTree(World world, int x, int y, int z, Random rand)
	{
		if (!TerrainGen.saplingGrowTree(world, rand, x, y, z))
		{
			return;
		}
		
		int l = world.getBlockMetadata(x, y, z) & 7;
		WorldGenerator worldGen = this.getTreeToGrow();
		
		world.setBlock(x, y, z, Blocks.air, 0, 4);
		if (!worldGen.generate(world, rand, x + 0, y, z + 0))
		{
			world.setBlock(x, y, z, this, l, 4);
		}
	}
	
	@Override
	public boolean func_149851_a(World world, int x, int y, int z, boolean flag)
	{
		return true;
	}
	
	@Override
	public boolean func_149852_a(World world, Random random, int x, int y, int z)
	{
		return random.nextFloat() < 0.45F;
	}
	
	@Override
	public void func_149853_b(World world, Random random, int x, int y, int z)
	{
		this.growTree(world, x, y, z, random);
	}
}
