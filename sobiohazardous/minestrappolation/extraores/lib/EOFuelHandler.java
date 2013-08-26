package sobiohazardous.minestrappolation.extraores.lib;

import sobiohazardous.minestrappolation.extraores.ExtraOres;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.IFuelHandler;

public class EOFuelHandler implements IFuelHandler 
{

	@Override
	public int getBurnTime(ItemStack fuel) 
	{
		if(fuel.itemID == EOItemManager.Plutonium.itemID)
		{
			return 35000;
		}
		if(fuel.itemID == EOItemManager.Uranium.itemID)
		{
			return 30000;
		}
		return 0;
	}

}
