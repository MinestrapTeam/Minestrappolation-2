package clashsoft.cslib.minecraft.creativetab;

import clashsoft.cslib.minecraft.item.CSStacks;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class CustomCreativeTab extends CreativeTabs
{
	public Item			item;
	public int			metadata;
	
	public ItemStack	stack;
	
	public CustomCreativeTab(String label)
	{
		this(label, CSStacks.air);
	}
	
	public CustomCreativeTab(String label, ItemStack stack)
	{
		this(label, null, 0);
		this.stack = stack;
	}
	
	public CustomCreativeTab(String label, Item item, int metadata)
	{
		super(label);
		this.item = item;
		this.metadata = metadata;
	}
	
	public void setIconItemStack(ItemStack stack)
	{
		this.stack = stack;
	}
	
	@Override
	public ItemStack getIconItemStack()
	{
		return this.stack == null ? this.stack = new ItemStack(this.item, 1, this.metadata) : this.stack;
	}
	
	@Override
	public Item getTabIconItem()
	{
		return this.item;
	}
}
