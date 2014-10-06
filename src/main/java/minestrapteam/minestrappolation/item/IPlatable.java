package minestrapteam.minestrappolation.item;

import net.minecraft.item.ItemStack;

public interface IPlatable
{
	public String getType();
	
	public String getMaterialName();
	
	public boolean isPlatable(ItemStack stack);
	
	public int getPlatingCount(ItemStack stack);
}
