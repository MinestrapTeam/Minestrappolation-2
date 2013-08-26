package sobiohazardous.minestrappolation.extramobdrops.item;

public class EMDItemBrewable extends EMDItem
{
	public EMDItemBrewable(int id, String texture)
	{
		super(id, texture);
	}
	
	public boolean isPotionIngredient()
	{
		return true;
	}
}
