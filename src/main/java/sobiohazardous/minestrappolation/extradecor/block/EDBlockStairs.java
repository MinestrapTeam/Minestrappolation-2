package sobiohazardous.minestrappolation.extradecor.block;

import sobiohazardous.minestrappolation.extradecor.ExtraDecor;
import sobiohazardous.minestrappolation.extradecor.lib.EDBlockManager;
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
	
	public int getFlammability(IBlockAccess world, int x, int y, int z, ForgeDirection face)
    {
    	if(world.getBlock(x, y, z) == EDBlockManager.woodBoardsStairsOak || world.getBlock(x, y, z) == EDBlockManager.woodBoardsStairsBirch || world.getBlock(x, y, z) == EDBlockManager.woodBoardsStairsSpruce || world.getBlock(x, y, z) == EDBlockManager.woodBoardsStairsJungle)
    	{
    		if(face == ForgeDirection.UP || face == ForgeDirection.DOWN || face == ForgeDirection.NORTH || face == ForgeDirection.SOUTH || face == ForgeDirection.EAST || face == ForgeDirection.WEST)
    		{
                return 75;
    		}
    		else
    			return 0;
    	}
    	else
    		return 0;
    }
}
