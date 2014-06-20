package minestrapteam.minestrappolation.creativetab;

import minestrapteam.minestrappolation.lib.MTools;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class MCreativeTabCombat extends CreativeTabs
{
	public MCreativeTabCombat(String label)
	{
		super(label);
	}
	
	@Override
	public Item getTabIconItem()
	{
		return MTools.blaziumSword;
	}
}
