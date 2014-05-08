package sobiohazardous.mods.minestrappolation.extramobdrops.creativetabs;

import sobiohazardous.mods.minestrappolation.extramobdrops.lib.EMDItems;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public final class CreativeTabEMDPotions extends CreativeTabs
{
	public CreativeTabEMDPotions(int id, String label)
	{
		super(id, label);
	}
	
	@Override
	public Item getTabIconItem()
	{
		return EMDItems.poisonSack;
	}
}