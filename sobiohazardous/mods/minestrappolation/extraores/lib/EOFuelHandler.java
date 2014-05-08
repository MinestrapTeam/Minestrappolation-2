package sobiohazardous.mods.minestrappolation.extraores.lib;

import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.IFuelHandler;

public class EOFuelHandler implements IFuelHandler
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
		return 0;
	}
}
