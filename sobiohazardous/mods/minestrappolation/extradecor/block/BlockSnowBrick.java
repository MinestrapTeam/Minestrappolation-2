package sobiohazardous.mods.minestrappolation.extradecor.block;

import java.util.Random;

import sobiohazardous.mods.minestrappolation.core.block.MBlock;
import net.minecraft.block.material.Material;
import net.minecraft.init.Items;
import net.minecraft.item.Item;

public class BlockSnowBrick extends MBlock
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
