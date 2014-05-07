package sobiohazardous.mods.minestrappolation.extramobdrops;

import sobiohazardous.mods.minestrappolation.extramobdrops.lib.EMDItems;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public final class CreativeTabExtraMobDropsPotions extends CreativeTabs
{
	public CreativeTabExtraMobDropsPotions(int par1, String par2Str)
	{
		super(par1, par2Str);
	}
	
	@Override
	public String getTranslatedTabLabel()
	{
		return "Extrappolated Mob Drops - Potions";
	}
	
	@Override
	public Item getTabIconItem()
	{
		return EMDItems.poisonSack;
	}
}