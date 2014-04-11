package sobiohazardous.minestrappolation.extradecor.itemblocks;

import sobiohazardous.minestrappolation.extradecor.lib.EDBlockManager;
import net.minecraft.block.Block;
import net.minecraft.block.BlockSlab;
import net.minecraft.item.ItemSlab;

public class ItemBlockWoodBoardSlab extends ItemSlab
{
	public ItemBlockWoodBoardSlab(Block block)
	{
		super(block, EDBlockManager.woodBoardsSingleSlab, EDBlockManager.woodBoardsDoubleSlab, false);
	}

}
