package sobiohazardous.minestrappolation.api.itemblocks;

import sobiohazardous.minestrappolation.api.block.BlockMultiSlab;
import net.minecraft.block.Block;
import net.minecraft.item.ItemSlab;
import net.minecraft.item.ItemStack;

public class ItemBlockMultiSlab extends ItemSlab
{
	public ItemBlockMultiSlab(Block block, BlockMultiSlab singleSlab, BlockMultiSlab doubleSlab) 
	{
		super(block, singleSlab, doubleSlab, block == doubleSlab);
		this.hasSubtypes = true;
	}

	@Override
	public int getMetadata(int meta)
	{
		return meta & 7;
	}

	@Override
	public String getUnlocalizedName(ItemStack itemStack) 
	{
		return super.getUnlocalizedName() + "." + itemStack.getItemDamage();
	}
}