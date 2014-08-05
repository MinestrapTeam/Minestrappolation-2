package minestrapteam.minestrappolation.item;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ItemPoisonSack extends Item implements IItemAddon
{
	public ItemPoisonSack()
	{
		addons.add(this);
	}
	
	@Override
	public boolean canApply(ItemStack platable)
	{
		return platable.getItem() instanceof MItemSword && MItemTool.getPoisonLevel(platable) < 4F;
	}

	@Override
	public void apply(ItemStack platable)
	{
		MItemTool.setPoisonLevel(platable, 4F);
	}

	@Override
	public void unapply(ItemStack platable)
	{
		MItemTool.setPoisonLevel(platable, 0F);
	}

	@Override
	public boolean isApplied(ItemStack platable)
	{
		return MItemTool.getPoisonLevel(platable) == 4F;
	}

	@Override
	public int getCount(ItemStack platable)
	{
		return 1;
	}
}
