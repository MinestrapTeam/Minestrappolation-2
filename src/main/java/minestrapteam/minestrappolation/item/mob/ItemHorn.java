package minestrapteam.minestrappolation.item.mob;

import minestrapteam.minestrappolation.item.IItemAddon;
import minestrapteam.minestrappolation.item.MItem;
import minestrapteam.minestrappolation.item.tool.MItemSword;
import minestrapteam.minestrappolation.item.tool.MItemTool;

import net.minecraft.item.ItemStack;

public class ItemHorn extends MItem implements IItemAddon
{
	public ItemHorn()
	{
		addons.add(this);
	}
	
	@Override
	public boolean canApply(ItemStack platable)
	{
		return platable.getItem() instanceof MItemSword;
	}
	
	@Override
	public void apply(ItemStack platable)
	{
		MItemTool.setHorned(platable, true);
	}
	
	@Override
	public void unapply(ItemStack platable)
	{
		MItemTool.setHorned(platable, false);
	}
	
	@Override
	public boolean isApplied(ItemStack platable)
	{
		return MItemTool.isHorned(platable);
	}
	
	@Override
	public int getCount(ItemStack platable)
	{
		return 2;
	}
}
