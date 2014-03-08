package clashsoft.cslib.minecraft.inventory.itemmatcher;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

public class ItemMatcherID implements IItemMatcher
{
	public Item	item;
	public int	itemDamage;
	
	public ItemMatcherID(Item item)
	{
		this(item, OreDictionary.WILDCARD_VALUE);
	}
	
	public ItemMatcherID(Item item, int itemDamage)
	{
		this.item = item;
		this.itemDamage = itemDamage;
	}
	
	@Override
	public boolean isItemValid(ItemStack stack)
	{
		return stack != null && stack.getItem() == this.item && (this.itemDamage == OreDictionary.WILDCARD_VALUE || stack.getItemDamage() == this.itemDamage);
	}
	
}
