package sobiohazardous.mods.minestrappolation.core.item;

import clashsoft.cslib.minecraft.item.datatools.ItemDataAxe;

import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;

public class MItemAxe extends MItemTool
{
	public MItemAxe(ToolMaterial material, ToolMaterial plateMaterial)
	{
		this(material, plateMaterial, false);
	}
	
	public MItemAxe(ToolMaterial material, ToolMaterial plateMaterial, boolean ignites)
	{
		super(ItemDataAxe.baseDamage, material, plateMaterial, ItemDataAxe.blocksEffectiveAgainst, "overlayToolAxeBronze", ignites);
	}
	
	@Override
	public float getDigSpeed(ItemStack stack, Block block, int meta)
	{
		if (ItemDataAxe.isEfficientOnMaterial(block.getMaterial()))
		{
			return this.efficiencyOnProperMaterial;
		}
		return super.getDigSpeed(stack, block, meta);
	}
}
