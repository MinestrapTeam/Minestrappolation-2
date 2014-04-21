package sobiohazardous.minestrappolation.api.creativetabs;

import sobiohazardous.minestrappolation.api.lib.MAPIBlocks;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;

public final class CreativeTabMAPI extends CreativeTabs
{
	public CreativeTabMAPI(int par1, String par2Str)
	{
		super(par1, par2Str);
	}

	public String getTranslatedTabLabel()
	{
		return "MAPI";
	}

	@Override
	public Item getTabIconItem()
	{
		return Item.getItemFromBlock(MAPIBlocks.stoneCutter);
	}
}