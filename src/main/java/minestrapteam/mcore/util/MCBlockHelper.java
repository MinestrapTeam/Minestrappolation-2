package minestrapteam.mcore.util;

import cpw.mods.fml.common.registry.GameData;
import cpw.mods.fml.common.registry.GameRegistry;
import minestrapteam.mcore.block.MCBlockCustom;
import minestrapteam.mcore.block.MCBlockCustom2;
import minestrapteam.mcore.block.MCBlockStairs;
import minestrapteam.mcore.item.block.MCItemBlockCustom;
import minestrapteam.mcore.item.block.MCItemBlockCustom2;
import minestrapteam.mcore.lib.MCReference;
import net.minecraft.block.Block;
import net.minecraft.block.BlockStairs;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;

/**
 * A utility class for adding various types of blocks.
 * 
 * @author SoBiohazardous
 * @author Clashsoft
 */
public class MCBlockHelper
{
	public static final String[]	stoneTypes	= new String[] { "raw", "bricks", "pattern_bricks", "tiles", "road", "refined", "chiseled", "cracked", "mossy", null, null, null, null, null, "lamp_glowstone", "lamp_sunstone" };
	public static final String[]	stoneTypes2	= new String[] { "pillar", "raw_slab", "brick_slab", "tile_slab", "refined_slab" };
	
	public static final String[]	woodTypes	= new String[] { "bevel", "boards", "panel", "mossy_planks" };
	public static final String[]	woodTypes2	= new String[] { "bevel", "boards" };
	
	public static MCBlockCustom createWoodBlock(String name, float hardness, float resistance, CreativeTabs tab)
	{
		return createWoodBlock(woodTypes, name, hardness, resistance, tab);
	}
	
	public static MCBlockCustom createWoodBlock(String[] types, String name, float hardness, float resistance, CreativeTabs tab)
	{
		String name1 = "wood_" + name;
		MCBlockCustom block = new MCBlockCustom(types, name, hardness, resistance, 0, Material.wood);
		block.setBlockName(name1);
		block.setBlockTextureName(MCAssetManager.getWoodTexture(name));
		block.setCreativeTab(tab);
		block.setHarvestTool("axe");
		GameRegistry.registerBlock(block, MCItemBlockCustom.class, name1);
		Blocks.fire.setFireInfo(block, 5, 20);
		return block;
	}
	
	public static MCBlockCustom2 createWoodBlock2(String name, float hardness, float resistance, CreativeTabs tab)
	{
		return createWoodBlock2(woodTypes2, name, hardness, resistance, tab);
	}
	
	public static MCBlockCustom2 createWoodBlock2(String[] types, String name, float hardness, float resistance, CreativeTabs tab)
	{
		String name1 = "wood_slab_" + name;
		MCBlockCustom2 block = new MCBlockCustom2(woodTypes2, name, hardness, resistance, 0, Material.wood);
		block.setBlockName(name1);
		block.setBlockTextureName(MCAssetManager.getWoodTexture(name));
		block.setCreativeTab(tab);
		block.setHarvestTool("axe");
		GameRegistry.registerBlock(block, MCItemBlockCustom2.class, name1);
		Blocks.fire.setFireInfo(block, 5, 20);
		return block;
	}
	
	public static MCBlockCustom createStoneBlock(String name, float hardness, float resistance, int harvestLevel, CreativeTabs tab)
	{
		return createStoneBlock(stoneTypes, name, hardness, resistance, harvestLevel, tab);
	}
	
	public static MCBlockCustom createStoneBlock(String[] types, String name, float hardness, float resistance, int harvestLevel, CreativeTabs tab)
	{
		String name1 = "stone_" + name;
		MCBlockCustom block = new MCBlockCustom(types, name, hardness, resistance, harvestLevel, Material.rock);
		block.setBlockName(name1);
		block.setBlockTextureName(MCAssetManager.getStonecutterTexture(name));
		block.setCreativeTab(tab);
		block.setHarvestTool("pickaxe");
		GameRegistry.registerBlock(block, MCItemBlockCustom.class, name1);
		return block;
	}
	
	public static MCBlockCustom2 createStoneBlock2(String name, float hardness, float resistance, int harvestLevel, CreativeTabs tab)
	{
		return createStoneBlock2(stoneTypes2, name, hardness, resistance, harvestLevel, tab);
	}
	
	public static MCBlockCustom2 createStoneBlock2(String[] types, String name, float hardness, float resistance, int harvestLevel, CreativeTabs tab)
	{
		String name1 = "stone_slab_" + name;
		MCBlockCustom2 block = new MCBlockCustom2(types, name, hardness, resistance, harvestLevel, Material.rock);
		block.setBlockName(name1);
		block.setBlockTextureName(MCAssetManager.getStonecutterTexture(name));
		block.setCreativeTab(tab);
		block.setHarvestTool("pickaxe");
		GameRegistry.registerBlock(block, MCItemBlockCustom2.class, name1);
		return block;
	}
	
	/**
	 * Gets a block from MinestrappolationCore based on name.
	 * 
	 * @param name
	 * @return
	 */
	public static Block getMCoreBlock(String name)
	{
		return GameRegistry.findBlock(MCReference.CORE_MODID, name);
	}
	
	/**
	 * Gets a block from MinestrappolationCore based on name.
	 * 
	 * @param name
	 * @return
	 */
	public static Block getMinestrappolationBlock(String name)
	{
		return GameRegistry.findBlock(MCReference.MODID, name);
	}
	
	public static String getUniqueName(Block block)
	{
		return GameData.getBlockRegistry().getNameForObject(block);
	}
}
