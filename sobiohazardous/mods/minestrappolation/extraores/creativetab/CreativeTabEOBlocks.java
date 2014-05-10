package sobiohazardous.mods.minestrappolation.extraores.creativetab;

import sobiohazardous.mods.minestrappolation.extraores.lib.EOBlocks;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class CreativeTabEOBlocks extends CreativeTabs
{
	public CreativeTabEOBlocks(int id, String label)
	{
		super(id, label);
	}
	
	@Override
	public Item getTabIconItem()
	{
		return Item.getItemFromBlock(EOBlocks.CopperBlock);
	}
}