package minestrapteam.minestrappolation.item;

import net.minecraft.block.Block;
import net.minecraft.item.ItemReed;
import net.minecraft.item.ItemStack;

public class ItemPlating extends ItemReed
{
	private String	plating;
	
	public ItemPlating(Block block, String plating)
	{
		super(block);
		this.plating = plating;
	}
	
	public String getPlating()
	{
		return this.plating;
	}
	
	public String getPlating(ItemStack stack)
	{
		return this.plating;
	}
	
	public void setPlating(String plating)
	{
		this.plating = plating;
	}
}
