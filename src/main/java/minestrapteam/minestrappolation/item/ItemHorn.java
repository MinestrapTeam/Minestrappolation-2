package minestrapteam.minestrappolation.item;

import net.minecraft.item.ItemStack;

public class ItemHorn extends MItem implements IPlating
{
	public ItemHorn()
	{
		platings.put("horn", this);
		addons.add(this);
	}
	
	@Override
	public boolean canApply(ItemStack platable)
	{
		if (platable.getItem() instanceof IPlatable)
		{
			IPlatable iplatable = (IPlatable) platable.getItem();
			return "sword".equals(iplatable.getType());
		}
		return false;
	}
	
	@Override
	public void apply(ItemStack platable)
	{
		MItemTool.setPlating(platable, this);
	}
	
	@Override
	public void unapply(ItemStack platable)
	{
		MItemTool.setPlating(platable, null);
	}
	
	@Override
	public boolean isApplied(ItemStack platable)
	{
		return MItemTool.getPlating(platable) == this;
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
	public float getEntityDamage()
	{
		return 1F;
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
	
	@Override
	public int getCount(ItemStack platable)
	{
		return 2;
	}
}
