package minestrapteam.minestrappolation.item;

import net.minecraft.item.ItemFood;

public class MItemFood extends ItemFood
{
	public MItemFood(int healAmount, float saturationModifier)
	{
		super(healAmount, saturationModifier, false);
	}
}
