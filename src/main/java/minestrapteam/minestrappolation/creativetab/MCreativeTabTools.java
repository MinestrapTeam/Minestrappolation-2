package minestrapteam.minestrappolation.creativetab;

import minestrapteam.minestrappolation.lib.MTools;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class MCreativeTabTools extends CreativeTabs
{
	public MCreativeTabTools(String label)
	{
		super(label);
	}
	
	@Override
	public Item getTabIconItem()
	{
		return MTools.blaziumPickaxe;
	}
}
