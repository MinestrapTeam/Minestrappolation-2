package minestrapteam.minestrappolation.block;

import java.util.Random;

import minestrapteam.minestrappolation.lib.MBlocks;
import minestrapteam.minestrappolation.lib.MItems;

import net.minecraft.block.BlockRailBase;
import net.minecraft.item.Item;

public class BlockPlating extends BlockRailBase
{
	public BlockPlating()
	{
		super(true);
		this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.125F, 1.0F);
		this.setCreativeTab(null);
	}
	
	@Override
	public Item getItemDropped(int metadata, Random random, int fortune)
	{
		if (this == MBlocks.tinPlate)
		{
			return MItems.plateTinItem;
		}
		else if (this == MBlocks.bronzePlate)
		{
			return MItems.plateBronzeItem;
		}
		else if (this == MBlocks.steelPlate)
		{
			return MItems.plateSteelItem;
		}
		else if (this == MBlocks.meuroditePlate)
		{
			return MItems.plateMeuroditeItem;
		}
		return Item.getItemFromBlock(this);
	}
}
