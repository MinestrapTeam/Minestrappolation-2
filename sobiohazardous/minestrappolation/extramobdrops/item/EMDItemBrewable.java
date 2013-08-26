package sobiohazardous.minestrappolation.extramobdrops.item;

import sobiohazardous.minestrappolation.api.item.MItem;

public class EMDItemBrewable extends MItem
{
	public EMDItemBrewable(int id)
	{
		super(id);
	}
	
	public boolean isPotionIngredient()
	{
		return true;
	}
}
