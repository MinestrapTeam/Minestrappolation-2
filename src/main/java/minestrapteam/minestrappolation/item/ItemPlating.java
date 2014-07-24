package minestrapteam.minestrappolation.item;

import net.minecraft.block.Block;
import net.minecraft.item.ItemReed;
import net.minecraft.item.ItemStack;

public class ItemPlating extends ItemReed implements IPlating
{
	private String	plating;
	private int		durability;
	private float	digSpeed;
	
	public ItemPlating(Block block, String plating, int durability, float digSpeed)
	{
		super(block);
		this.plating = plating;
		this.durability = durability;
		this.digSpeed = digSpeed;
		
		platings.put(plating, this);
	}
	
	public static IPlating getPlating(String plating)
	{
		return platings.get(plating);
	}
	
	@Override
	public boolean canApply(String toolType)
	{
		return true;
	}
	
	@Override
	public String getType()
	{
		return this.plating;
	}
	
	@Override
	public String getType(ItemStack stack)
	{
		return this.plating;
	}
	
	@Override
	public int getDurability()
	{
		return this.durability;
	}
	
	@Override
	public float getDigSpeed()
	{
		return this.digSpeed;
	}
	
	public void setPlating(String plating)
	{
		this.plating = plating;
	}
}
