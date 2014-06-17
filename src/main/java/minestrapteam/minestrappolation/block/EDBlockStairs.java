package minestrapteam.minestrappolation.block;

import minestrapteam.minestrap_core.lib.MCBlocks;
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
		if (world.getBlock(x, y, z) == MCBlocks.woodOak || world.getBlock(x, y, z) == MCBlocks.woodBirch || world.getBlock(x, y, z) == MCBlocks.woodJungle || world.getBlock(x, y, z) == MCBlocks.woodSpruce)
		{
			return 75;
		}
		return 0;
	}
}
