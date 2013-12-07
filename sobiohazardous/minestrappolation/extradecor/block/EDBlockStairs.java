package sobiohazardous.minestrappolation.extradecor.block;

import sobiohazardous.minestrappolation.extradecor.ExtraDecor;
import sobiohazardous.minestrappolation.extradecor.lib.EDBlockManager;
import net.minecraft.block.Block;
import net.minecraft.block.BlockStairs;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.common.ForgeDirection;

public class EDBlockStairs extends BlockStairs
{
	public EDBlockStairs(int id, Block block, int blockmeta)
	{
		super(id, block, blockmeta);
		  this.setLightOpacity(255);
	}
	
	public int getFlammability(IBlockAccess world, int x, int y, int z, int metadata, ForgeDirection face)
    {
    	if(blockID == EDBlockManager.woodBoardsStairsOak.blockID || blockID == EDBlockManager.woodBoardsStairsBirch.blockID || blockID == EDBlockManager.woodBoardsStairsSpruce.blockID || blockID == EDBlockManager.woodBoardsStairsJungle.blockID)
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
