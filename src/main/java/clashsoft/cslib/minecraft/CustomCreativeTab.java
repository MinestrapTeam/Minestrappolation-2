package clashsoft.cslib.minecraft;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class CustomCreativeTab extends CreativeTabs
{
	public int itemID = 1;
	public int itemMetadata = 0;
	
	public ItemStack item = null;
	
	public CustomCreativeTab(String label)
	{
		this(label, 1, 0);
	}
	
	public CustomCreativeTab(String label, ItemStack item)
	{
		this(label, item.itemID, item.getItemDamage());
		this.item = item;
	}
	
	public CustomCreativeTab(String label, int itemID, int itemMetadata)
	{
		super(label);
		this.itemID = itemID;
		this.itemMetadata = itemMetadata;
	}
	
	public void setIconItemStack(ItemStack stack)
	{
		this.item = stack;
	}
	
	@Override
	public ItemStack getIconItemStack()
	{
		return item == null ? item = new ItemStack(itemID, 1, itemMetadata) : item;
	}
}
