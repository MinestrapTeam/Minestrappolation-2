package minestrapteam.minestrappolation.item;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.item.ItemStack;

public interface IItemAddon
{
	public static final List<IItemAddon>	addons	= new ArrayList();
	
	public boolean canApply(ItemStack platable);
	
	public void apply(ItemStack platable);
	
	public void unapply(ItemStack platable);
	
	public boolean isApplied(ItemStack platable);
	
	public int getCount(ItemStack platable);
}
