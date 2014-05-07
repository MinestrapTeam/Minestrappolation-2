package sobiohazardous.mods.minestrappolation.extramobdrops;

import sobiohazardous.mods.minestrappolation.extramobdrops.lib.EMDItems;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public final class CreativeTabExtraMobDropsItems extends CreativeTabs
{
	public CreativeTabExtraMobDropsItems(int par1, String par2Str)
	{
		super(par1, par2Str);
	}
	
	@Override
	public String getTranslatedTabLabel()
	{
		return "Extrappolated Mob Drops - Items";
	}
	
	@Override
	public Item getTabIconItem()
	{
		return EMDItems.pigHoof;
	}
}