package minestrapteam.minestrappolation.item;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.item.ItemStack;

public interface IItemAddon
{
	public static final List<IItemAddon>	addons	= new ArrayList();
	
	public boolean canApply(ItemStack stack);
	
	public void apply(ItemStack stack);
	
	public void unapply(ItemStack stack);
	
	public boolean isApplied(ItemStack stack);
	
	public int getCount(ItemStack stack);
}
