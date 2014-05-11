package clashsoft.cslib.minecraft.util;

import gnu.trove.strategy.HashingStrategy;
import clashsoft.cslib.minecraft.crafting.SimpleRecipeManager;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

/**
 * An {@link HashingStrategy} for comparing {@link ItemStack}s. Use the
 * {@link #instance} if you want to compare the items and item damage, for
 * example in a {@link SimpleRecipeManager}. If you do want to compare the stack
 * size, you can use the {@link #stackSizeInstance}.
 * 
 * @author Clashsoft
 */
public class ItemStackHashingStrategy implements HashingStrategy<ItemStack>
{
	/**
	 * True if the equals method should also compare the stack size.
	 */
	private boolean							compareStackSize;
	
	public static ItemStackHashingStrategy	instance			= new ItemStackHashingStrategy(false);
	public static ItemStackHashingStrategy	stackSizeInstance	= new ItemStackHashingStrategy(true);
	
	public ItemStackHashingStrategy(boolean stackSize)
	{
		this.compareStackSize = stackSize;
	}
	
	@Override
	public int computeHashCode(ItemStack stack)
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + (stack.getItem() == null ? 0 : Item.getIdFromItem(stack.getItem()));
		result = prime * result + stack.getItemDamage();
		if (this.compareStackSize)
		{
			result = prime * result + stack.stackSize;
		}
		result = prime * result + (stack.stackTagCompound == null ? 0 : stack.stackTagCompound.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(ItemStack o1, ItemStack o2)
	{
		int damage1 = o1.getItemDamage();
		int damage2 = o2.getItemDamage();
		
		if (o1 == o2)
		{
			return true;
		}
		if (o1 == null != (o2 == null))
		{
			return false;
		}
		if (o1.getClass() != o2.getClass())
		{
			return false;
		}
		if (o1.getItem() != o2.getItem())
		{
			return false;
		}
		if (damage1 != damage2 && damage1 != 32767 && damage2 != 32767)
		{
			return false;
		}
		if (this.compareStackSize && o1.stackSize != o2.stackSize)
		{
			return false;
		}
		if (o1.stackTagCompound == null)
		{
			if (o2.stackTagCompound != null)
			{
				return false;
			}
		}
		else if (!o1.stackTagCompound.equals(o2.stackTagCompound))
		{
			return false;
		}
		return true;
	}
}
