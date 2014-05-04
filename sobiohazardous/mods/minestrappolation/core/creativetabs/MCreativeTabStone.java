package sobiohazardous.mods.minestrappolation.core.creativetabs;

import sobiohazardous.mods.minestrappolation.core.lib.MBlocks;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;

public final class MCreativeTabStone extends CreativeTabs
{
	public MCreativeTabStone(int par1, String par2Str)
	{
		super(par1, par2Str);
	}

	public String getTranslatedTabLabel()
	{
		return "Minestrappolation - Stone";
	}

	@Override
	public Item getTabIconItem()
	{
		return Item.getItemFromBlock(MBlocks.stoneCutter);
	}
}