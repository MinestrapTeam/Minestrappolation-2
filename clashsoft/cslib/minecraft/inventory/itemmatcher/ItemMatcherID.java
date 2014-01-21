package clashsoft.cslib.minecraft.inventory.itemmatcher;

import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

public class ItemMatcherID implements IItemMatcher
{
	public int	itemID;
	public int	itemDamage;
	
	public ItemMatcherID(int itemID)
	{
		this(itemID, OreDictionary.WILDCARD_VALUE);
	}
	
	public ItemMatcherID(int itemID, int itemDamage)
	{
		this.itemID = itemID;
		this.itemDamage = itemDamage;
	}
	
	@Override
	public boolean isItemValid(ItemStack stack)
	{
		return stack != null && stack.itemID == this.itemID && (this.itemDamage == OreDictionary.WILDCARD_VALUE || stack.getItemDamage() == this.itemDamage);
	}
	
}
