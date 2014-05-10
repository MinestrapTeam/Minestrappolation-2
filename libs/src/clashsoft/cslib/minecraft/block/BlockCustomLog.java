package clashsoft.cslib.minecraft.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockCustomLog extends BlockCustomPillar
{
	public BlockCustomLog(String name, String topIcon, String sideIcon)
	{
		super(Material.wood, name, topIcon, sideIcon);
	}
	
	public BlockCustomLog(String[] names, String[] topIcons, String[] sideIcons)
	{
		super(Material.wood, names, topIcons, sideIcons);
		this.setStepSound(Block.soundTypeWood);
		this.setHardness(2F);
	}
	
	@Override
	public void breakBlock(World world, int x, int y, int z, Block oldBlock, int oldBlockMetadata)
	{
		byte b0 = 4;
		int j1 = b0 + 1;
		
		if (world.checkChunksExist(x - j1, y - j1, z - j1, x + j1, y + j1, z + j1))
		{
			for (int k1 = -b0; k1 <= b0; ++k1)
			{
				for (int l1 = -b0; l1 <= b0; ++l1)
				{
					for (int i2 = -b0; i2 <= b0; ++i2)
					{
						Block block = world.getBlock(x + k1, y + l1, z + i2);
						block.beginLeavesDecay(world, x + k1, y + l1, z + i2);
					}
				}
			}
		}
	}
	
	@Override
	public boolean canSustainLeaves(IBlockAccess world, int x, int y, int z)
	{
		return true;
	}
	
	@Override
	public boolean isWood(IBlockAccess world, int x, int y, int z)
	{
		return true;
	}
}
