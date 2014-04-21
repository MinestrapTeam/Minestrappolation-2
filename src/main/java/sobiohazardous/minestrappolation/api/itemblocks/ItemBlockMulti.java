package sobiohazardous.minestrappolation.api.itemblocks;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemBlockMulti extends ItemBlock 
{
	public ItemBlockMulti(Block block) 
	{
		super(block);
		setHasSubtypes(true);
	}

	@Override
	public String getUnlocalizedName(ItemStack itemstack)
	{
		return getUnlocalizedName() + "." + itemstack.getItemDamage();
	}

	@Override
	public int getMetadata(int par1) 
	{
		return par1;
	}
}