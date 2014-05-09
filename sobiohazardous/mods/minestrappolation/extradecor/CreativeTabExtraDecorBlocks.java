package sobiohazardous.mods.minestrappolation.extradecor;

import sobiohazardous.mods.minestrappolation.extradecor.lib.EDItems;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public final class CreativeTabExtraDecorBlocks extends CreativeTabs
{
	public CreativeTabExtraDecorBlocks(int id, String label)
	{
		super(id, label);
	}
	
	@Override
	public Item getTabIconItem()
	{
		return EDItems.sandstoneBrickItem;
	}
}