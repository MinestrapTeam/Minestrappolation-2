package clashsoft.cslib.minecraft.item.datatools;

import java.util.Set;

import clashsoft.cslib.reflect.CSReflection;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemStack;

public class ItemDataAxe extends ItemDataTool
{
	public static final float		baseDamage				= 3F;
	public static final Set<Block>	blocksEffectiveAgainst	= CSReflection.getStaticValue(ItemAxe.class, 0);
	
	public ItemDataAxe(ToolMaterial toolMaterial)
	{
		super(baseDamage, toolMaterial, blocksEffectiveAgainst, "Axe");
	}
	
	@Override
	public float getDigSpeed(ItemStack stack, Block block, int metadata)
	{
		Material material = block.getMaterial();
		if (isEfficientOnMaterial(material))
		{
			return this.efficiencyOnProperMaterial;
		}
		return super.getDigSpeed(stack, block, metadata);
	}
	
	public static boolean isEfficientOnMaterial(Material material)
	{
		return material == Material.wood || material == Material.plants || material == Material.vine;
	}
}