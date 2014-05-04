package sobiohazardous.mods.minestrappolation.extraores.item;

import net.minecraft.item.ItemStack;
import sobiohazardous.mods.minestrappolation.core.item.MItem;
import sobiohazardous.mods.minestrappolation.extraores.lib.EOItemManager;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class EItemFoiled extends EOItem
{
	public EItemFoiled()
	{
		super();
		this.setCreativeTab(EOItemManager.tabOresItems);
	}

	@SideOnly(Side.CLIENT)
	public boolean hasEffect(ItemStack par1ItemStack)
	{
		return true;
	}
}