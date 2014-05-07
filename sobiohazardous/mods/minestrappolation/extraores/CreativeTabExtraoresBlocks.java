package sobiohazardous.mods.minestrappolation.extraores;

import sobiohazardous.mods.minestrappolation.extraores.lib.EOBlocks;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public final class CreativeTabExtraoresBlocks extends CreativeTabs
{
	public CreativeTabExtraoresBlocks(int par1, String par2Str)
	{
		super(par1, par2Str);
	}
	
	@Override
	public String getTranslatedTabLabel()
	{
		return "Extrapolated Ores - Blocks";
	}
	
	@Override
	public Item getTabIconItem()
	{
		return Item.getItemFromBlock(EOBlocks.CopperBlock);
	}
}