package minestrapteam.minestrappolation.creativetab;

import minestrapteam.minestrappolation.lib.MBlocks;
import minestrapteam.minestrappolation.lib.MItems;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class MTabDecoration extends CreativeTabs
{
	public MTabDecoration(String label)
	{
		super(label);
	}
	
	@Override
	public Item getTabIconItem()
	{
		return MItems.ropeItem;
	}
	
}
