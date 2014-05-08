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
	public String getUnlocalizedName(ItemStack stack)
	{
		return this.getUnlocalizedName() + "." + stack.getItemDamage();
	}
	
	@Override
	public int getMetadata(int metadata)
	{
		return metadata;
	}
}
