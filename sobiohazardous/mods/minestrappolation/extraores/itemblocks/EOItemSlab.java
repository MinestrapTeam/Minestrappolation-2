package sobiohazardous.mods.minestrappolation.extraores.itemblocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockSlab;
import net.minecraft.item.ItemSlab;
import net.minecraft.item.ItemStack;

public class EOItemSlab extends ItemSlab
{
	public EOItemSlab(Block block, BlockSlab singleSlab, BlockSlab doubleSlab)
	{
		super(block, singleSlab, doubleSlab, block == doubleSlab);
	}
	
	@Override
	public int getMetadata(int meta)
	{
		return meta & 7;
	}
	
	@Override
	public String getUnlocalizedName(ItemStack itemStack)
	{
		// TODO: getBlockFromItem
		BlockSlab slab = (BlockSlab) Block.getBlockFromItem(itemStack.getItem());
		
		// TODO: getFullSlabName()
		return super.getUnlocalizedName() + "." + new StringBuilder().append(slab.func_150002_b(itemStack.getItemDamage())).toString();
	}
}