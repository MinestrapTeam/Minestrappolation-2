package minestrapteam.minestrappolation.item;

import java.util.HashMap;
import java.util.Map;

import net.minecraft.block.Block;
import net.minecraft.item.ItemReed;
import net.minecraft.item.ItemStack;

public class ItemPlating extends ItemReed
{
	public static final Map<String, ItemPlating> platings = new HashMap();
	
	private String	plating;
	public int durability;
	public float digSpeed;
	
	public ItemPlating(Block block, String plating, int durability, float digSpeed)
	{
		super(block);
		this.plating = plating;
		this.durability = durability;
		this.digSpeed = digSpeed;
		
		platings.put(plating, this);
	}
	
	public static ItemPlating getItem(String plating)
	{
		return platings.get(plating);
	}
	
	public static int getDurability(String plating)
	{
		ItemPlating item = getItem(plating);
		return item == null ? 0 : item.durability;
	}
	
	public static float getDigSpeed(String plating)
	{
		ItemPlating item = getItem(plating);
		return item == null ? 1F : item.digSpeed;
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
