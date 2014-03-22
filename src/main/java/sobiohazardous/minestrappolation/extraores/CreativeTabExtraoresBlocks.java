package sobiohazardous.minestrappolation.extraores;

import sobiohazardous.minestrappolation.extraores.*;
import sobiohazardous.minestrappolation.extraores.lib.EOBlockManager;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public final class CreativeTabExtraoresBlocks extends CreativeTabs
{
	public CreativeTabExtraoresBlocks(int par1, String par2Str)
	{
		super(par1, par2Str);
	}

	public String getTranslatedTabLabel()
	{
		return "Extrapolated Ores - Blocks";
	}

	@Override
	public Item getTabIconItem()
	{
		return Item.getItemFromBlock(EOBlockManager.CopperBlock);
	}
}