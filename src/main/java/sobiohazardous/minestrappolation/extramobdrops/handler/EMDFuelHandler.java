package sobiohazardous.minestrappolation.extramobdrops.handler;

import sobiohazardous.minestrappolation.extramobdrops.lib.EMDItemManager;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.IFuelHandler;

public class EMDFuelHandler implements IFuelHandler 
{
	@Override
	public int getBurnTime(ItemStack fuel) 
	{
		if(fuel.itemID == EMDItemManager.guano.itemID)
		{
			return 2000;
		}
		return 0;
	}
}