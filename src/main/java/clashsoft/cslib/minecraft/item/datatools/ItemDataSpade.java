package clashsoft.cslib.minecraft.item.datatools;

import java.util.Set;

import clashsoft.cslib.collections.CSCollections;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;

public class ItemDataSpade extends ItemDataTool
{
	public static final Set	blocksEffectiveAgainst	= CSCollections.createSet(Blocks.grass, Blocks.dirt, Blocks.sand, Blocks.gravel, Blocks.snow, Blocks.snow, Blocks.clay, Blocks.farmland, Blocks.soul_sand, Blocks.mycelium);
	
	public ItemDataSpade(ToolMaterial toolMaterial)
	{
		super(1F, toolMaterial, blocksEffectiveAgainst, "Shovel");
	}
	
	@Override
	public boolean canHarvestBlock(Block block, ItemStack stack)
	{
		return block == Blocks.snow || block == Blocks.snow_layer;
	}
}
