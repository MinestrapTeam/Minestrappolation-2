package minestrapteam.minestrappolation.item;

import net.minecraft.item.ItemStack;

public class ItemHorn extends MItem implements IPlating
{
	public ItemHorn()
	{
		platings.put("horn", this);
	}
	
	@Override
	public boolean canApply(String toolType)
	{
		return "sword".equals(toolType);
	}
	
	@Override
	public String getType()
	{
		return "horn";
	}
	
	@Override
	public String getType(ItemStack stack)
	{
		return "horn";
	}
	
	@Override
	public float getDigSpeed()
	{
		return 1.1F;
	}
	
	@Override
	public int getDurability()
	{
		return 16;
	}
}
