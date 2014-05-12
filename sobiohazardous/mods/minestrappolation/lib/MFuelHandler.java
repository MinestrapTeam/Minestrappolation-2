package sobiohazardous.mods.minestrappolation.lib;

import sobiohazardous.mods.minestrappolation.extramobdrops.lib.EMDItems;
import sobiohazardous.mods.minestrappolation.extraores.lib.EOItems;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.IFuelHandler;

public class MFuelHandler implements IFuelHandler
{
	@Override
	public int getBurnTime(ItemStack fuel)
	{
		if (fuel.getItem() == EOItems.Plutonium)
		{
			return 35000;
		}
		if (fuel.getItem() == EOItems.Uranium)
		{
			return 30000;
		}
		if (fuel.getItem() == EMDItems.guano)
		{
			return 2000;
		}
		return 0;
	}
}
