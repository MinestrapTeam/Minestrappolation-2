package com.minestrappolation.block;

import java.util.Random;

import com.minestrappolation.lib.MItems;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.world.World;

public class BlockSunstoneOre extends Block
{
	public BlockSunstoneOre()
	{
		super(Material.rock);
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
		return MItems.SunstoneDust;
	}
	
	@Override
	public void onBlockDestroyedByPlayer(World world, int x, int y, int z, int metadata)
	{
		this.dropXpOnBlockBreak(world, x, y, z, world.rand.nextInt(5) + 3);
	}
}
