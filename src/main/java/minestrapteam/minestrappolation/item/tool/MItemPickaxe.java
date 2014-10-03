package minestrapteam.minestrappolation.item.tool;

import clashsoft.cslib.minecraft.item.datatools.ItemDataPickaxe;
import minestrapteam.minestrappolation.lib.MConfig;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class MItemPickaxe extends MItemTool
{
	private boolean	breakBedrock	= false;
	
	public MItemPickaxe(ToolMaterial material)
	{
		this(material, false);
	}
	
	public MItemPickaxe(ToolMaterial material, boolean ignites)
	{
		super(ItemDataPickaxe.baseDamage, material, ItemDataPickaxe.blocksEffectiveAgainst, "pickaxe", ignites);
	}
	
	@Override
	public float func_150893_a(ItemStack stack, Block block)
	{
		Material material = block.getMaterial();
		if (material == Material.iron || material == Material.anvil || material == Material.rock)
		{
			return this.efficiencyOnProperMaterial;
		}
		return super.func_150893_a(stack, block);
	}
	
	@Override
	public boolean canHarvestBlock(Block block, ItemStack stack)
	{
		if (this.breakBedrock && block == Blocks.bedrock)
		{
			return this.toolMaterial.getHarvestLevel() >= 4;
		}
		if (block == Blocks.obsidian)
		{
			return this.toolMaterial.getHarvestLevel() >= 3;
		}
		if (block == Blocks.diamond_block || block == Blocks.diamond_ore)
		{
			return this.toolMaterial.getHarvestLevel() >= 2;
		}
		if (block == Blocks.emerald_ore || block == Blocks.emerald_block)
		{
			return this.toolMaterial.getHarvestLevel() >= 2;
		}
		if (block == Blocks.gold_block || block == Blocks.gold_ore)
		{
			return this.toolMaterial.getHarvestLevel() >= 2;
		}
		if (block == Blocks.iron_block || block == Blocks.iron_ore)
		{
			return this.toolMaterial.getHarvestLevel() >= 1;
		}
		if (block == Blocks.lapis_block || block == Blocks.lapis_ore)
		{
			return this.toolMaterial.getHarvestLevel() >= 1;
		}
		if (block == Blocks.redstone_ore || block == Blocks.lit_redstone_ore)
		{
			return this.toolMaterial.getHarvestLevel() >= 2;
		}
		return block.getMaterial() == Material.rock || block.getMaterial() == Material.iron || block.getMaterial() == Material.anvil;
	}
	
	@Override
	public boolean onBlockDestroyed(ItemStack itemstack, World world, Block blockDestroyed, int x, int y, int z, EntityLivingBase living)
	{
		if (blockDestroyed == Blocks.bedrock)
		{
			itemstack.damageItem(MConfig.bedrockDamage - 1, living);
		}
		
		return super.onBlockDestroyed(itemstack, world, blockDestroyed, x, y, z, living);
	}
}
