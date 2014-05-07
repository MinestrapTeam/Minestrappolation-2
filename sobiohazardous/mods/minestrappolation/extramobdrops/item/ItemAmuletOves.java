package sobiohazardous.mods.minestrappolation.extramobdrops.item;

import net.minecraft.item.ItemStack;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import sobiohazardous.mods.minestrappolation.core.item.MItem;

public class ItemAmuletOves extends MItem
{
	public ItemAmuletOves()
	{
		super();
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public boolean hasEffect(ItemStack par1ItemStack)
	{
		return true;
	}
	
	// reduce damage to player occaisonally.
}
