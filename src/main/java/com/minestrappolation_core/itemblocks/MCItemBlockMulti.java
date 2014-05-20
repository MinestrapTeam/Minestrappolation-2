package com.minestrappolation_core.itemblocks;

import com.minestrappolation_core.block.MCBlockStone;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class MCItemBlockMulti extends ItemBlock
{
	public MCItemBlockMulti(Block block)
	{
		super(block);
		this.setMaxDamage(0);
		this.setHasSubtypes(true);
	}
	
	@Override
	public String getUnlocalizedName(ItemStack stack)
	{
		int metadata = stack.getItemDamage();
		if (this.field_150939_a instanceof MCBlockStone)
			return this.getUnlocalizedName() + "." + MCBlockStone.types[metadata];
		return this.getUnlocalizedName() + "." + stack.getItemDamage();
	}
	
	@Override
	public int getMetadata(int metadata)
	{
		return metadata;
	}
}
