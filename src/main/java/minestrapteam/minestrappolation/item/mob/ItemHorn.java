package minestrapteam.minestrappolation.item.mob;

import minestrapteam.minestrappolation.item.IItemAddon;
import minestrapteam.minestrappolation.item.MItem;
import minestrapteam.minestrappolation.item.tool.MItemSword;
import minestrapteam.minestrappolation.item.tool.MItemTool;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ItemHorn extends MItem implements IItemAddon
{
	public ItemHorn()
	{
		addons.add(this);
	}
	
	@Override
	public boolean canApply(ItemStack stack)
	{
		Item item = stack.getItem();
		return item instanceof MItemSword && ((MItemSword) item).isPlatable(stack);
	}
	
	@Override
	public void apply(ItemStack stack)
	{
		MItemTool.setHorned(stack, true);
	}
	
	@Override
	public void unapply(ItemStack stack)
	{
		MItemTool.setHorned(stack, false);
	}
	
	@Override
	public boolean isApplied(ItemStack stack)
	{
		return MItemTool.isHorned(stack);
	}
	
	@Override
	public int getCount(ItemStack stack)
	{
		return 2;
	}
}
