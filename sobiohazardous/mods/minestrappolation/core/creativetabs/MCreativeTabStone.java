package sobiohazardous.mods.minestrappolation.core.creativetabs;

import sobiohazardous.mods.minestrappolation.core.lib.MBlocks;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public final class MCreativeTabStone extends CreativeTabs
{
	public MCreativeTabStone(int par1, String par2Str)
	{
		super(par1, par2Str);
	}
	
	@Override
	public String getTranslatedTabLabel()
	{
		return "Minestrappolation - Stone";
	}
	
	@Override
	public Item getTabIconItem()
	{
		return Item.getItemFromBlock(MBlocks.stoneCutter);
	}
}