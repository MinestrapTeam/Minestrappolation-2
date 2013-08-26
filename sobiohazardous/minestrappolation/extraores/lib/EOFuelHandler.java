package sobiohazardous.minestrappolation.extraores.lib;

import sobiohazardous.minestrappolation.extraores.ExtraOres;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.IFuelHandler;

public class EOFuelHandler implements IFuelHandler 
{

	@Override
	public int getBurnTime(ItemStack fuel) 
	{
		if(fuel.itemID == ExtraOres.Plutonium.itemID)
		{
			return 35000;
		}
		if(fuel.itemID == ExtraOres.Uranium.itemID)
		{
			return 30000;
		}
		return 0;
	}

}
