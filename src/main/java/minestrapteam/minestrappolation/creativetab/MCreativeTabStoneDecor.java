package minestrapteam.minestrappolation.creativetab;

import minestrapteam.minestrappolation.lib.MBlocks;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class MCreativeTabStoneDecor extends CreativeTabs
{
	public MCreativeTabStoneDecor(String label)
	{
		super(label);
	}
	
	@Override
	public Item getTabIconItem()
	{
		return Item.getItemFromBlock(MBlocks.flint);
	}
}
