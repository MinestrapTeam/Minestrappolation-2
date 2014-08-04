package minestrapteam.minestrappolation.block;

import java.util.Random;

import minestrapteam.minestrappolation.world.gen.WorldGenBaseTree;

import net.minecraft.block.BlockBush;
import net.minecraft.block.IGrowable;
import net.minecraft.init.Blocks;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.common.util.ForgeDirection;
import net.minecraftforge.event.terraingen.TerrainGen;

public abstract class MBlockSapling extends BlockBush implements IGrowable
{
	public MBlockSapling()
	{
		this.setBlockBounds(0.1F, 0.0F, 0.1F, 0.9F, 0.8F, 0.9F);
	}
	
	@Override
	public int getFlammability(IBlockAccess world, int x, int y, int z, ForgeDirection face)
	{
		return 255;
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
	
	public void updateState(World world, int x, int y, int z, Random random)
	{
		int l = world.getBlockMetadata(x, y, z);
		
		if ((l & 8) == 0)
		{
			world.setBlockMetadataWithNotify(x, y, z, l | 8, 4);
		}
		else
		{
			this.growTree(world, x, y, z, random);
		}
	}
	
	public void growTree(World world, int x, int y, int z, Random rand)
	{
		if (!TerrainGen.saplingGrowTree(world, rand, x, y, z))
		{
			return;
		}
		
		int metadata = world.getBlockMetadata(x, y, z) & 7;
		boolean flag = false;
		int i1 = 0;
		int j1 = 0;
		
		outer:
		for (i1 = 0; i1 >= -1; --i1)
		{
			for (j1 = 0; j1 >= -1; --j1)
			{
				if (this.isBlock(world, x + i1, y, z + j1, metadata) && this.isBlock(world, x + i1 + 1, y, z + j1, metadata) && this.isBlock(world, x + i1, y, z + j1 + 1, metadata) && this.isBlock(world, x + i1 + 1, y, z + j1 + 1, metadata))
				{
					flag = true;
					break outer;
				}
			}
		}
		
		WorldGenerator worldGen = this.getTreeToGrow(metadata & 7, flag);
		
		if (flag)
        {
            world.setBlock(x + i1, y, z + j1, Blocks.air, 0, 4);
            world.setBlock(x + i1 + 1, y, z + j1, Blocks.air, 0, 4);
            world.setBlock(x + i1, y, z + j1 + 1, Blocks.air, 0, 4);
            world.setBlock(x + i1 + 1, y, z + j1 + 1, Blocks.air, 0, 4);
        }
        else
        {
            world.setBlock(x, y, z, Blocks.air, 0, 4);
        }

        if (!worldGen.generate(world, rand, x + i1, y, z + j1))
        {
            if (flag)
            {
                world.setBlock(x + i1, y, z + j1, this, metadata, 4);
                world.setBlock(x + i1 + 1, y, z + j1, this, metadata, 4);
                world.setBlock(x + i1, y, z + j1 + 1, this, metadata, 4);
                world.setBlock(x + i1 + 1, y, z + j1 + 1, this, metadata, 4);
            }
            else
            {
                world.setBlock(x, y, z, this, metadata, 4);
            }
        }
	}
	
	public abstract WorldGenBaseTree getTreeToGrow(int metadata, boolean big);
	
	private boolean isBlock(World world, int x, int y, int z, int metadata)
	{
		return world.getBlock(x, y, z) == this && (world.getBlockMetadata(x, y, z) & 7) == metadata;
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
		this.updateState(world, x, y, z, random);
	}
}
