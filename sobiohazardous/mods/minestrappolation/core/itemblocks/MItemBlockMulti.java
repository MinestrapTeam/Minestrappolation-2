package sobiohazardous.mods.minestrappolation.core.itemblocks;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

public class MItemBlockMulti extends ItemBlock 
{
	public MItemBlockMulti(Block block) 
	{
		super(block);
		setMaxDamage(0);
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
