package minestrapteam.minestrap_core.item;

import net.minecraft.item.ItemFood;

public class MCItemFood extends ItemFood
{
	public MCItemFood(int healAmount, float saturationModifier)
	{
		super(healAmount, saturationModifier, false);
	}
}
