package clashsoft.cslib.minecraft.inventory.itemmatcher;

import net.minecraft.item.ItemStack;

public class ItemMatcherClass implements IItemMatcher
{
	public Class classToMatch;
	
	public ItemMatcherClass(Class classToMatch)
	{
		this.classToMatch = classToMatch;
	}
	
	@Override
	public boolean isItemValid(ItemStack stack)
	{
		return stack != null && stack.getItem() != null && classToMatch.isAssignableFrom(stack.getItem().getClass());
	}
	
}
