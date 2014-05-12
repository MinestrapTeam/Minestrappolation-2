package sobiohazardous.mods.minestrappolation.block;

import java.util.Random;

import sobiohazardous.mods.minestrappolation.core.block.MCBlock;
import net.minecraft.block.material.Material;
import net.minecraft.init.Items;
import net.minecraft.item.Item;

public class BlockSnowBrick extends MCBlock
{
	public BlockSnowBrick()
	{
		super(Material.craftedSnow);
	}
	
	@Override
	public int quantityDropped(Random random)
	{
		return 4;
	}
	
	@Override
	public Item getItemDropped(int metadata, Random random, int fortune)
	{
		return Items.snowball;
	}
}
