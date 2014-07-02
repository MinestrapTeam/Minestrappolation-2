package minestrapteam.minestrappolation.handler;

import minestrapteam.minestrappolation.lib.MItems;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.IFuelHandler;

public class FuelHandler implements IFuelHandler 
{
	@Override
	public int getBurnTime(ItemStack fuel) 
	{
		//ticks it takes to melt. One mc day == 20 minutes, or 24,000 ticks.
		
		if(fuel.getItem() == MItems.uranium)
		{
			return 36000;
		}	
		else if(fuel.getItem() == MItems.plutonium)
		{
			return 48000;
		}		
		else
		{
			return 0;
		}
	}
}