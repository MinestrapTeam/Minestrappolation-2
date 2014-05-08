package sobiohazardous.mods.minestrappolation.extramobdrops.handler;

import sobiohazardous.mods.minestrappolation.extramobdrops.lib.EMDItems;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.IFuelHandler;

public class EMDFuelHandler implements IFuelHandler
{
	@Override
	public int getBurnTime(ItemStack fuel)
	{
		if (fuel.getItem() == EMDItems.guano)
		{
			return 2000;
		}
		return 0;
	}
}