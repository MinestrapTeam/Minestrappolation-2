package minestrapteam.minestrappolation.creativetab;

import minestrapteam.minestrappolation.lib.MItems;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class MCreativeTabBrewing extends CreativeTabs
{
	public MCreativeTabBrewing(String label)
	{
		super(label);
	}
	
	@Override
	public Item getTabIconItem()
	{
		return MItems.airSack;
	}
}
