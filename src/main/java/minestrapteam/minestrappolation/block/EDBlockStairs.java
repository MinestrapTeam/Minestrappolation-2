package minestrapteam.minestrappolation.block;

import minestrapteam.minestrap_core.lib.MCBlocks;

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
		Block block = world.getBlock(x, y, z);
		if (block == MCBlocks.woodOak || block == MCBlocks.woodBirch || block == MCBlocks.woodJungle || block == MCBlocks.woodSpruce)
		{
			return 75;
		}
		return 0;
	}
}
