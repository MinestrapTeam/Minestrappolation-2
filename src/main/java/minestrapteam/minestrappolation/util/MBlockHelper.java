package minestrapteam.minestrappolation.util;

import cpw.mods.fml.common.registry.GameData;
import cpw.mods.fml.common.registry.GameRegistry;
import minestrapteam.minestrappolation.block.MBlockCustom;
import minestrapteam.minestrappolation.block.MBlockCustom2;
import minestrapteam.minestrappolation.block.MBlockStairs;
import minestrapteam.minestrappolation.item.block.MCItemBlockCustom;
import minestrapteam.minestrappolation.item.block.MCItemBlockCustom2;
import minestrapteam.minestrappolation.lib.MReference;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;

/**
 * A utility class for adding various types of blocks.
 * 
 * @author SoBiohazardous
 * @author Clashsoft
 */
public class MBlockHelper
{
	public static final String[]	stoneTypes	= new String[] { "raw", "bricks", "pattern_bricks", "tiles", "road", "refined", "chiseled", "cracked", "mossy", null, null, null, null, null, "lamp_glowstone", "lamp_sunstone" };
	public static final String[]	stoneTypes2	= new String[] { "pillar", "raw_slab", "brick_slab", "tile_slab", "refined_slab" };
	
	public static final String[]	woodTypes	= new String[] { "bevel", "boards", "panel", "mossy_planks", "mossy_boards", "mossy_panel" };
	public static final String[]	woodTypes2	= new String[] { "boards_slab" };
	
	public static MBlockCustom createWoodBlock(String name, float hardness, float resistance, CreativeTabs tab)
	{
		return createWoodBlock(woodTypes, name, hardness, resistance, tab);
	}
	
	public static MBlockCustom createWoodBlock(String[] types, String name, float hardness, float resistance, CreativeTabs tab)
	{
		String name1 = "wood_" + name;
		MBlockCustom block = new MBlockCustom(types, name, hardness, resistance, 0, Material.wood);
		block.setBlockName(name1);
		block.setBlockTextureName(MAssetManager.getWoodTexture(name));
		block.setCreativeTab(tab);
		block.setHarvestTool("axe");
		block.setStepSound(Block.soundTypeWood);
		GameRegistry.registerBlock(block, MCItemBlockCustom.class, name1);
		Blocks.fire.setFireInfo(block, 5, 20);
		return block;
	}
	
	public static MBlockCustom2 createWoodBlock2(String name, float hardness, float resistance, CreativeTabs tab)
	{
		return createWoodBlock2(woodTypes2, name, hardness, resistance, tab);
	}
	
	public static MBlockCustom2 createWoodBlock2(String[] types, String name, float hardness, float resistance, CreativeTabs tab)
	{
		String name1 = "wood_slab_" + name;
		MBlockCustom2 block = new MBlockCustom2(types, name, hardness, resistance, 0, Material.wood);
		block.setBlockName(name1);
		block.setBlockTextureName(MAssetManager.getWoodTexture(name));
		block.setCreativeTab(tab);
		block.setHarvestTool("axe");
		block.setStepSound(Block.soundTypeWood);
		GameRegistry.registerBlock(block, MCItemBlockCustom2.class, name1);
		Blocks.fire.setFireInfo(block, 5, 20);
		return block;
	}
	
	public static MBlockCustom createStoneBlock(String name, float hardness, float resistance, int harvestLevel, CreativeTabs tab)
	{
		return createStoneBlock(stoneTypes, name, hardness, resistance, harvestLevel, tab);
	}
	
	public static MBlockCustom createStoneBlock(String[] types, String name, float hardness, float resistance, int harvestLevel, CreativeTabs tab)
	{
		String name1 = "stone_" + name;
		MBlockCustom block = new MBlockCustom(types, name, hardness, resistance, harvestLevel, Material.rock);
		block.setBlockName(name1);
		block.setBlockTextureName(MAssetManager.getStonecutterTexture(name));
		block.setCreativeTab(tab);
		block.setHarvestTool("pickaxe");
		GameRegistry.registerBlock(block, MCItemBlockCustom.class, name1);
		return block;
	}
	
	public static MBlockCustom2 createStoneBlock2(String name, float hardness, float resistance, int harvestLevel, CreativeTabs tab)
	{
		return createStoneBlock2(stoneTypes2, name, hardness, resistance, harvestLevel, tab);
	}
	
	public static MBlockCustom2 createStoneBlock2(String[] types, String name, float hardness, float resistance, int harvestLevel, CreativeTabs tab)
	{
		String name1 = "stone_slab_" + name;
		MBlockCustom2 block = new MBlockCustom2(types, name, hardness, resistance, harvestLevel, Material.rock);
		block.setBlockName(name1);
		block.setBlockTextureName(MAssetManager.getStonecutterTexture(name));
		block.setCreativeTab(tab);
		block.setHarvestTool("pickaxe");
		GameRegistry.registerBlock(block, MCItemBlockCustom2.class, name1);
		return block;
	}
	
	public static MBlockStairs createWoodStair(Block block, String type, int metadata, CreativeTabs tab)
	{
		String name1 = type + ".raw_stairs";
		MBlockStairs stair = new MBlockStairs(block, metadata);
		stair.setBlockName(name1);
		stair.setCreativeTab(tab);
		stair.setStepSound(Block.soundTypeWood);
		GameRegistry.registerBlock(stair, name1);
		return stair;
	}
	
	public static MBlockStairs createWoodStair(MBlockCustom block, int metadata, CreativeTabs tab)
	{
		String name1 = block.name + "." + block.getType(metadata) + "_stairs";
		MBlockStairs stair = new MBlockStairs(block, metadata);
		stair.setBlockName(name1);
		stair.setCreativeTab(tab);
		stair.setStepSound(Block.soundTypeWood);
		GameRegistry.registerBlock(stair, name1);
		return stair;
	}
	
	public static MBlockStairs createStoneStair(Block block, String type, int metadata, CreativeTabs tab)
	{
		String name1 = type.indexOf('.') == -1 ? type + ".raw_stairs" : type;
		MBlockStairs stair = new MBlockStairs(block, metadata);
		stair.setBlockName(name1);
		stair.setCreativeTab(tab);
		GameRegistry.registerBlock(stair, name1);
		return stair;
	}
	
	public static MBlockStairs createStoneStair(MBlockCustom block, int metadata, CreativeTabs tab)
	{
		String name1 = block.name + "." + block.getType(metadata) + "_stairs";
		MBlockStairs stair = new MBlockStairs(block, metadata);
		stair.setBlockName(name1);
		stair.setCreativeTab(tab);
		GameRegistry.registerBlock(stair, name1);
		return stair;
	}
	
	/**
	 * Gets a block from MinestrappolationCore based on name.
	 * 
	 * @param name
	 * @return
	 */
	public static Block getMinestrappolationBlock(String name)
	{
		return GameRegistry.findBlock(MReference.MODID, name);
	}
	
	public static String getUniqueName(Block block)
	{
		return GameData.getBlockRegistry().getNameForObject(block);
	}
}
