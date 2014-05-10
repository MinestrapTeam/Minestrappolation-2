package sobiohazardous.mods.minestrappolation.extraores.creativetab;

import sobiohazardous.mods.minestrappolation.extraores.lib.EOItems;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class CreativeTabEOItems extends CreativeTabs
{
	public CreativeTabEOItems(int id, String label)
	{
		super(id, label);
	}
	
	@Override
	public Item getTabIconItem()
	{
		return EOItems.CopperIngot;
	}
}