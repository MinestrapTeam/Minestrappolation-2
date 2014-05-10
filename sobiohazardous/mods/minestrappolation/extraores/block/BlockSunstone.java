package sobiohazardous.mods.minestrappolation.extraores.block;

import java.util.Random;

import sobiohazardous.mods.minestrappolation.core.util.MAssetManager;
import sobiohazardous.mods.minestrappolation.extraores.lib.EOItems;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;

public class BlockSunstone extends Block
{
	public BlockSunstone(Material material)
	{
		super(material);
		this.setBlockTextureName(MAssetManager.getEOTexture("blockSunstone"));
	}
	
	@Override
	public int quantityDroppedWithBonus(int fortune, Random random)
	{
		return this.quantityDropped(random) + random.nextInt(fortune + 1);
	}
	
	@Override
	public int quantityDropped(Random random)
	{
		return 2 + random.nextInt(3);
	}
	
	@Override
	public Item getItemDropped(int metadata, Random random, int fortune)
	{
		return EOItems.SunstoneDust;
	}
}
