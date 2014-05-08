package sobiohazardous.mods.minestrappolation.core.creativetab;

import sobiohazardous.mods.minestrappolation.core.lib.MBlocks;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public final class MCreativeTabStone extends CreativeTabs
{
	public MCreativeTabStone(int id, String label)
	{
		super(id, label);
	}
	
	@Override
	public Item getTabIconItem()
	{
		return Item.getItemFromBlock(MBlocks.stoneCutter);
	}
}