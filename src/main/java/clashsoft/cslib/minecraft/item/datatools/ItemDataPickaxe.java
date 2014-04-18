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
	public static final Set	blocksEffectiveAgainst	= CSReflection.getStaticValue(ItemPickaxe.class, 0);
	
	public ItemDataPickaxe(ToolMaterial toolMaterial)
	{
		super(2F, toolMaterial, blocksEffectiveAgainst, "Pickaxe");
	}
	
	@Override
	public boolean canHarvestBlock(Block block, ItemStack stack)
	{
		if (block == Blocks.obsidian)
		{
			return (this.toolMaterial.getHarvestLevel() == 3);
		}
		if ((block == Blocks.diamond_block) || (block == Blocks.diamond_ore))
		{
			return (this.toolMaterial.getHarvestLevel() >= 2);
		}
		if ((block == Blocks.emerald_ore) || (block == Blocks.emerald_block))
		{
			return (this.toolMaterial.getHarvestLevel() >= 2);
		}
		if ((block == Blocks.gold_block) || (block == Blocks.gold_ore))
		{
			return (this.toolMaterial.getHarvestLevel() >= 2);
		}
		if ((block == Blocks.iron_block) || (block == Blocks.iron_ore))
		{
			return (this.toolMaterial.getHarvestLevel() >= 1);
		}
		if ((block == Blocks.lapis_block) || (block == Blocks.lapis_ore))
		{
			return (this.toolMaterial.getHarvestLevel() >= 1);
		}
		if ((block == Blocks.redstone_ore) || (block == Blocks.lit_redstone_ore))
		{
			return (this.toolMaterial.getHarvestLevel() >= 2);
		}
		if (block.getMaterial() == Material.rock)
		{
			return true;
		}
		if (block.getMaterial() == Material.iron)
		{
			return true;
		}
		return (block.getMaterial() == Material.anvil);
	}
	
	@Override
	public float getDigSpeed(ItemStack stack, Block block, int meta)
	{
		if ((block.getMaterial() == Material.iron) || (block.getMaterial() == Material.anvil) || (block.getMaterial() == Material.rock))
		{
			return super.getDigSpeed(stack, block, meta);
		}
		return super.func_150893_a(stack, block);
	}
}
