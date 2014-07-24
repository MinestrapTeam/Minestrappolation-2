package minestrapteam.minestrappolation.item;

import clashsoft.cslib.minecraft.item.datatools.ItemDataAxe;

import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;

public class MItemAxe extends MItemTool
{
	public MItemAxe(ToolMaterial material)
	{
		this(material, false);
	}
	
	public MItemAxe(ToolMaterial material, boolean ignites)
	{
		super(ItemDataAxe.baseDamage, material, ItemDataAxe.blocksEffectiveAgainst, "axe", ignites);
	}
	
	@Override
	public float func_150893_a(ItemStack stack, Block block)
	{
		if (ItemDataAxe.isEfficientOnMaterial(block.getMaterial()))
		{
			return this.efficiencyOnProperMaterial;
		}
		return super.func_150893_a(stack, block);
	}
}
