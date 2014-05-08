package sobiohazardous.mods.minestrappolation.extramobdrops;

import sobiohazardous.mods.minestrappolation.extramobdrops.lib.EMDItems;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public final class CreativeTabEMDItems extends CreativeTabs
{
	public CreativeTabEMDItems(int id, String label)
	{
		super(id, label);
	}
	
	@Override
	public Item getTabIconItem()
	{
		return EMDItems.pigHoof;
	}
}