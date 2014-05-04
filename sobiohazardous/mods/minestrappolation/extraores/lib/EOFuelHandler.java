package sobiohazardous.mods.minestrappolation.extraores.lib;

import sobiohazardous.mods.minestrappolation.extraores.ExtraOres;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.IFuelHandler;

public class EOFuelHandler implements IFuelHandler 
{
	@Override
	public int getBurnTime(ItemStack fuel) 
	{
		if(fuel.getItem() == EOItemManager.Plutonium)
		{
			return 35000;
		}
		if(fuel.getItem() == EOItemManager.Uranium)
		{
			return 30000;
		}
		return 0;
	}
}
