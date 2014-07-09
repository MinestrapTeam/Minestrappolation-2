package minestrapteam.minestrappolation.creativetab;

import minestrapteam.mcore.lib.MCBlocks;

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
		return Item.getItemFromBlock(MCBlocks.flint);
	}
}
