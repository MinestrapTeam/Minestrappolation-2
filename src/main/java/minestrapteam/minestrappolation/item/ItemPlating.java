package minestrapteam.minestrappolation.item;

import net.minecraft.block.Block;
import net.minecraft.item.ItemReed;
import net.minecraft.item.ItemStack;

public class ItemPlating extends ItemReed implements IPlating
{
	private String	plating;
	private float	entityDamage;
	private int		durability;
	private float	digSpeed;
	
	public ItemPlating(Block block, String plating, float entityDamage, int durability, float digSpeed)
	{
		super(block);
		this.plating = plating;
		this.entityDamage = entityDamage;
		this.durability = durability;
		this.digSpeed = digSpeed;
		
		platings.put(plating, this);
		addons.add(this);
	}
	
	public static IPlating getPlating(String plating)
	{
		return platings.get(plating);
	}
	
	@Override
	public boolean canApply(ItemStack platable)
	{
		return platable.getItem() instanceof IPlatable && !this.isApplied(platable);
	}
	
	@Override
	public void apply(ItemStack platable)
	{
		MItemTool.setPlating(platable, this);
	}
	
	@Override
	public void unapply(ItemStack platable)
	{
		MItemTool.setPlating(platable, null);
	}
	
	@Override
	public boolean isApplied(ItemStack platable)
	{
		return MItemTool.getPlating(platable) == this;
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
	public float getEntityDamage()
	{
		return this.entityDamage;
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
	
	@Override
	public int getCount(ItemStack platable)
	{
		return ((IPlatable) platable.getItem()).getPlatingCount(platable);
	}
}
