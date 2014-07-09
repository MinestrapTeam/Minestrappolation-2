package minestrapteam.minestrap_core.block;

import java.util.Random;

import minestrapteam.minestrappolation.lib.MBlocks;
import minestrapteam.minestrappolation.lib.MItems;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;

public class MCBlock extends Block
{
	public MCBlock(Material material)
	{
		super(material);
	}
	
	@Override
	public int quantityDropped(Random random)
	{
		return 1;
	}
	
	@Override
	public Item getItemDropped(int metadata, Random random, int fortune)
	{
		if (this == MBlocks.meuroditeOre)
		{
			return MItems.meuroditeGem;
		}
		if (this == MBlocks.radiantQuartzOre)
		{
			return MItems.radiantQuartz;
		}
		
		return Item.getItemFromBlock(this);
	}
	
	@Override
	protected boolean canSilkHarvest()
	{
		if (this == MBlocks.meuroditeOre || this == MBlocks.radiantQuartzOre)
		{
			return true;
		}
		return super.canSilkHarvest();
	}
}
