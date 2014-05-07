package sobiohazardous.mods.minestrappolation.core.itemblocks;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class MItemBlockMulti extends ItemBlock
{
	public MItemBlockMulti(Block block)
	{
		super(block);
		this.setMaxDamage(0);
		this.setHasSubtypes(true);
	}
	
	@Override
	public String getUnlocalizedName(ItemStack itemstack)
	{
		return this.getUnlocalizedName() + "." + itemstack.getItemDamage();
	}
	
	@Override
	public int getMetadata(int par1)
	{
		return par1;
	}
}
