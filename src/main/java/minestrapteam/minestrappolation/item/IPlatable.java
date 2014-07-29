package minestrapteam.minestrappolation.item;

import net.minecraft.item.ItemStack;

public interface IPlatable
{
	public String getType();
	
	public int getPlatingCount(ItemStack stack);
}
