package minestrapteam.minestrappolation.creativetab;

import minestrapteam.minestrappolation.lib.MItems;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class MTabMisc extends CreativeTabs
{
	public MTabMisc(String label)
	{
		super(label);
	}
	
	@Override
	public Item getTabIconItem()
	{
		return MItems.animalBones;
	}
	
}
