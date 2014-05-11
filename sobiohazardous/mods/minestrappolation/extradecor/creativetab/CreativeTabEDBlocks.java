package sobiohazardous.mods.minestrappolation.extradecor.creativetab;

import sobiohazardous.mods.minestrappolation.extradecor.lib.EDBlocks;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class CreativeTabEDBlocks extends CreativeTabs
{
	public CreativeTabEDBlocks(int id, String label)
	{
		super(id, label);
	}
	
	@Override
	public Item getTabIconItem()
	{
		return Item.getItemFromBlock(EDBlocks.Tiles);
	}
	
	@Override
	public int func_151243_f()
	{
		return 4;
	}
}