package minestrapteam.minestrap_core.util;

import cpw.mods.fml.common.registry.GameData;
import cpw.mods.fml.common.registry.GameRegistry;
import minestrapteam.minestrap_core.block.MCBlockStone;
import minestrapteam.minestrap_core.block.MCBlockStone2;
import minestrapteam.minestrap_core.block.MCBlockWood;
import minestrapteam.minestrap_core.block.MCBlockWood2;
import minestrapteam.minestrap_core.item.block.MCItemBlockWood2;
import minestrapteam.minestrap_core.item.block.MCItemBlockStone;
import minestrapteam.minestrap_core.item.block.MCItemBlockStone2;
import minestrapteam.minestrap_core.item.block.MCItemBlockWood;
import minestrapteam.minestrap_core.lib.MCReference;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;

/**
 * A utility class for adding various types of blocks.
 * 
 * @author SoBiohazardous
 * @author Clashsoft
 */
public class MCBlockHelper
{
	public static final String[]	stoneTypes	= new String[] { "raw", "bricks", "pattern_bricks", "tiles", "road", "refined", "chiseled", "cracked", "mossy", null, null, null, null, null, "glowstone_lamp", "sunstone_lamp" };
	public static final String[]	stoneTypes2	= new String[] { "pillar", "raw_slab", "brick_slab", "tile_slab", "refined_slab" };
	
	public static final String[]	woodTypes	= new String[] { "bevel", "boards", "panel", "mossy_planks" };
	public static final String[]	woodTypes2	= new String[] { "bevel_slab", "boards_slab", "panel_slab", "mossy_planks_slab" };
	
	public static MCBlockWood createWoodBlock(String name, CreativeTabs tab)
	{
		return createWoodBlock(woodTypes, name, tab);
	}
	
	public static MCBlockWood createWoodBlock(String[] types, String name, CreativeTabs tab)
	{
		String name1 = "wood_" + name;
		MCBlockWood block = new MCBlockWood(types, name);
		block.setBlockName(name1).setBlockTextureName(MCAssetManager.getWoodTexture(name)).setCreativeTab(tab);
		GameRegistry.registerBlock(block, MCItemBlockWood.class, name1);
		return block;
	}
	
	public static MCBlockWood2 createWoodBlock2(String name, CreativeTabs tab)
	{
		return createWoodBlock2(woodTypes2, name, tab);
	}
	
	public static MCBlockWood2 createWoodBlock2(String[] types, String name, CreativeTabs tab)
	{
		String name1 = "wood_slab_" + name;
		MCBlockWood2 block = new MCBlockWood2(woodTypes2, name);
		block.setBlockName(name1).setBlockTextureName(MCAssetManager.getWoodTexture(name)).setCreativeTab(tab);
		GameRegistry.registerBlock(block, MCItemBlockWood2.class, name1);
		return block;
	}
	
	public static MCBlockStone createStoneBlock(String name, float hardness, int harvestLevel, CreativeTabs tab)
	{
		return createStoneBlock(stoneTypes, name, hardness, harvestLevel, tab);
	}
	
	public static MCBlockStone createStoneBlock(String[] types, String name, float hardness, int harvestLevel, CreativeTabs tab)
	{
		String name1 = "stone_" + name;
		MCBlockStone block = new MCBlockStone(types, name, hardness);
		block.setBlockName(name1).setBlockTextureName(MCAssetManager.getStonecutterTexture(name)).setCreativeTab(tab);
		block.setHarvestLevel("pickaxe", harvestLevel);
		GameRegistry.registerBlock(block, MCItemBlockStone.class, name1);
		return block;
	}
	
	public static MCBlockStone2 createStoneBlock2(String name, float hardness, int harvestLevel, CreativeTabs tab)
	{
		return createStoneBlock2(stoneTypes2, name, hardness, harvestLevel, tab);
	}
	
	public static MCBlockStone2 createStoneBlock2(String[] types, String name, float hardness, int harvestLevel, CreativeTabs tab)
	{
		String name1 = "stone_slab_" + name;
		MCBlockStone2 block = new MCBlockStone2(types, name, hardness);
		block.setBlockName(name1).setBlockTextureName(MCAssetManager.getStonecutterTexture(name)).setCreativeTab(tab);
		block.setHarvestLevel("pickaxe", harvestLevel);
		GameRegistry.registerBlock(block, MCItemBlockStone2.class, name1);
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
