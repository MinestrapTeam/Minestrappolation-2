package sobiohazardous.mods.minestrappolation.extradecor.creativetab;

import sobiohazardous.mods.minestrappolation.extradecor.lib.EDItems;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public final class CreativeTabEDItems extends CreativeTabs
{
	public CreativeTabEDItems(int id, String label)
	{
		super(id, label);
	}
	
	@Override
	public Item getTabIconItem()
	{
		return EDItems.sandstoneBrick;
	}
}