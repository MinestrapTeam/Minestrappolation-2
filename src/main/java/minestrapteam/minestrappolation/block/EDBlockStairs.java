package minestrapteam.minestrappolation.block;

import minestrapteam.minestrappolation.lib.MBlocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockStairs;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.common.util.ForgeDirection;

public class EDBlockStairs extends BlockStairs
{
	public EDBlockStairs(Block block, int blockmeta)
	{
		super(block, blockmeta);
		this.setLightOpacity(255);
	}
	
	@Override
	public int getFlammability(IBlockAccess world, int x, int y, int z, ForgeDirection face)
	{
		if (world.getBlock(x, y, z) == MBlocks.woodBoardsStairsOak || world.getBlock(x, y, z) == MBlocks.woodBoardsStairsBirch || world.getBlock(x, y, z) == MBlocks.woodBoardsStairsSpruce || world.getBlock(x, y, z) == MBlocks.woodBoardsStairsJungle)
		{
			return 75;
		}
		return 0;
	}
}
