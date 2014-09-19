package minestrapteam.minestrappolation.block;

import java.util.Random;

import minestrapteam.minestrappolation.lib.MBlocks;
import minestrapteam.minestrappolation.lib.MItems;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.world.IBlockAccess;

// FIXME extends BlockOre2
public class MBlockOre extends Block
{
	public MBlockOre()
	{
		super(Material.rock);
	}
	
	@Override
	public int quantityDropped(int meta, int fortune, Random random)
	{
		if (this == MBlocks.meuroditeOre || this == MBlocks.radiantQuartzOre)
		{
			return 1 + random.nextInt(fortune + 1);
		}
		return super.quantityDropped(meta, fortune, random);
	}
	
	@Override
	public Item getItemDropped(int metadata, Random random, int fortune)
	{
		if (this == MBlocks.meuroditeOre)
		{
			return MItems.meuroditeGem;
		}
		else if (this == MBlocks.radiantQuartzOre)
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
	
	@Override
	public int getExpDrop(IBlockAccess world, int metadata, int fortune)
	{
		if (this == MBlocks.meuroditeOre)
		{
			return 10;
		}
		else if (this == MBlocks.radiantQuartzOre)
		{
			return 5;
		}
		return super.getExpDrop(world, metadata, fortune);
	}
}
