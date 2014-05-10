package clashsoft.cslib.minecraft.item.datatools;

import java.util.Set;

import clashsoft.cslib.reflect.CSReflection;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemSpade;
import net.minecraft.item.ItemStack;

public class ItemDataSpade extends ItemDataTool
{
	public static final float	baseDamage				= 1F;
	public static final Set		blocksEffectiveAgainst	= CSReflection.getStaticValue(ItemSpade.class, 0);
	
	public ItemDataSpade(ToolMaterial toolMaterial)
	{
		super(baseDamage, toolMaterial, blocksEffectiveAgainst, "Shovel");
	}
	
	@Override
	public boolean canHarvestBlock(Block block, ItemStack stack)
	{
		return block == Blocks.snow || block == Blocks.snow_layer;
	}
}
