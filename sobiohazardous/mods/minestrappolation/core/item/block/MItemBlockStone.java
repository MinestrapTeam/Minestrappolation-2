package sobiohazardous.mods.minestrappolation.core.item.block;

import sobiohazardous.mods.minestrappolation.core.block.MBlockStone;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class MItemBlockStone extends ItemBlock
{
	private MBlockStone	theBlock;
	
	public MItemBlockStone(Block block)
	{
		super(block);
		
		if (block instanceof MBlockStone)
			this.theBlock = (MBlockStone) block;
	}
	
	@Override
	public String getUnlocalizedName(ItemStack stack)
	{
		if (this.theBlock != null)
			return this.theBlock.getUnlocalizedName(stack.getItemDamage());
		return super.getUnlocalizedName(stack);
	}
}
