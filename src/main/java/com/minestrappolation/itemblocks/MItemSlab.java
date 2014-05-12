package com.minestrappolation.itemblocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockSlab;
import net.minecraft.item.ItemSlab;
import net.minecraft.item.ItemStack;

public class MItemSlab extends ItemSlab
{
	public MItemSlab(Block block, BlockSlab singleSlab, BlockSlab doubleSlab)
	{
		super(block, singleSlab, doubleSlab, block == doubleSlab);
	}
	
	@Override
	public int getMetadata(int meta)
	{
		return meta & 7;
	}
	
	@Override
	public String getUnlocalizedName(ItemStack stack)
	{
		BlockSlab slab = (BlockSlab) Block.getBlockFromItem(stack.getItem());
		
		return super.getUnlocalizedName() + "." + slab.func_150002_b(stack.getItemDamage()).toString();
	}
}