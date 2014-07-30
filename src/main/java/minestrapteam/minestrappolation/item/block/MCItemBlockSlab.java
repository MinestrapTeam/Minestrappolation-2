package minestrapteam.minestrappolation.item.block;

import minestrapteam.minestrappolation.block.MBlockMultiSlab;

import net.minecraft.block.Block;
import net.minecraft.item.ItemSlab;
import net.minecraft.item.ItemStack;

public class MCItemBlockSlab extends ItemSlab
{
	public MCItemBlockSlab(Block block, MBlockMultiSlab singleSlab, MBlockMultiSlab doubleSlab)
	{
		super(block, singleSlab, doubleSlab, block == doubleSlab);
		doubleSlab.setOtherSlab(singleSlab);
		this.hasSubtypes = true;
	}
	
	@Override
	public int getMetadata(int meta)
	{
		return meta & 7;
	}
	
	@Override
	public String getUnlocalizedName(ItemStack stack)
	{
		return super.getUnlocalizedName() + "." + stack.getItemDamage();
	}
}