package sobiohazardous.mods.minestrappolation.item;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import net.minecraft.item.ItemStack;

import sobiohazardous.mods.minestrappolation.core.item.MCItem;

public class ItemAmulet extends MCItem
{
	public ItemAmulet(int maxDamage)
	{
		super();
		this.setMaxStackSize(1);
		this.setMaxDamage(maxDamage);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public boolean hasEffect(ItemStack stack)
	{
		return true;
	}
}
