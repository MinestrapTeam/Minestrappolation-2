package sobiohazardous.mods.minestrappolation.extraores;

import sobiohazardous.mods.minestrappolation.extraores.*;
import sobiohazardous.mods.minestrappolation.extraores.lib.EOItems;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public final class CreativeTabExtraoresItems extends CreativeTabs
{
	public CreativeTabExtraoresItems(int par1, String par2Str)
	{
		super(par1, par2Str);
	}

	public String getTranslatedTabLabel()
	{
		return "Extrapolated Ores - Items";
	}

	@Override
	public Item getTabIconItem()
	{
		return EOItems.CopperIngot;
	}
}