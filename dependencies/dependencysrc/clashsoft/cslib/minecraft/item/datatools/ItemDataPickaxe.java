package clashsoft.cslib.minecraft.item.datatools;

import java.util.Set;

import clashsoft.cslib.reflect.CSReflection;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;

public class ItemDataPickaxe extends ItemDataTool
{
	public static final float baseDamage = 2F;
	public static final Set	blocksEffectiveAgainst	= CSReflection.getStaticValue(ItemPickaxe.class, 0);
	
	public ItemDataPickaxe(ToolMaterial toolMaterial)
	{
		super(baseDamage, toolMaterial, blocksEffectiveAgainst, "Pickaxe");
	}
	
	public static boolean isEfficientOnMaterial(Material material)
	{
		return material == Material.rock || material == Material.iron || material == Material.anvil;
	}
	
	@Override
	public boolean canHarvestBlock(Block block, ItemStack stack)
	{
		if (this.isEfficientOnMaterial(block.getMaterial()))
		{
			return true;
		}
		else if (block == Blocks.obsidian)
		{
			return (this.toolMaterial.getHarvestLevel() == 3);
		}
		else if ((block == Blocks.diamond_block) || (block == Blocks.diamond_ore))
		{
			return (this.toolMaterial.getHarvestLevel() >= 2);
		}
		else if ((block == Blocks.emerald_ore) || (block == Blocks.emerald_block))
		{
			return (this.toolMaterial.getHarvestLevel() >= 2);
		}
		else if ((block == Blocks.gold_block) || (block == Blocks.gold_ore))
		{
			return (this.toolMaterial.getHarvestLevel() >= 2);
		}
		else if ((block == Blocks.iron_block) || (block == Blocks.iron_ore))
		{
			return (this.toolMaterial.getHarvestLevel() >= 1);
		}
		else if ((block == Blocks.lapis_block) || (block == Blocks.lapis_ore))
		{
			return (this.toolMaterial.getHarvestLevel() >= 1);
		}
		else if ((block == Blocks.redstone_ore) || (block == Blocks.lit_redstone_ore))
		{
			return (this.toolMaterial.getHarvestLevel() >= 2);
		}
		return false;
	}
	
	@Override
	public float getDigSpeed(ItemStack stack, Block block, int metadata)
	{
		if (isEfficientOnMaterial(block.getMaterial()))
		{
			return this.efficiencyOnProperMaterial;
		}
		return super.getDigSpeed(stack, block, metadata);
	}
}
