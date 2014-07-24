package minestrapteam.minestrappolation.creativetab;

import minestrapteam.minestrappolation.lib.MTools;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class MTabTools extends CreativeTabs
{
	public MTabTools(String label)
	{
		super(label);
	}
	
	@Override
	public Item getTabIconItem()
	{
		return MTools.blaziumPickaxe;
	}
}
