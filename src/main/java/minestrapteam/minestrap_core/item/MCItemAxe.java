package minestrapteam.minestrap_core.item;

import clashsoft.cslib.minecraft.item.datatools.ItemDataAxe;

import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;

public class MCItemAxe extends MCItemTool
{
	public MCItemAxe(ToolMaterial material, ToolMaterial plateMaterial)
	{
		this(material, plateMaterial, false);
	}
	
	public MCItemAxe(ToolMaterial material, ToolMaterial plateMaterial, boolean ignites)
	{
		super(ItemDataAxe.baseDamage, material, plateMaterial, ItemDataAxe.blocksEffectiveAgainst, "axe", ignites);
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
