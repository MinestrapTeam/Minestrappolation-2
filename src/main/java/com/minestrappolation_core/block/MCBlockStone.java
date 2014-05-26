package com.minestrappolation_core.block;

import java.util.List;

import com.minestrappolation.Minestrappolation;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

/**
 * The first stonecutter block type.<br>
 * This makes up the following blocks:
 * <ul>
 * <li>0: (Raw Block)
 * <li>1: Brick
 * <li>2: Patterned Brick
 * <li>3: Tiles
 * <li>4: Road
 * <li>5: Refined Block
 * <li>6: Chiseled
 * <li>7: Cracked
 * <li>8: Mossy
 * <li>14: Glowstone Lamp
 * <li>15: Sunstone Lamp
 * </ul>
 * Everything else is added by {@link MBlockStone2}
 * 
 * @author Clashsoft, SoBiohazardous
 */
public class MCBlockStone extends MCBlockStoneCustom
{
	public static final String[]	types	= new String[] { "raw", "bricks", "pattern_bricks", "tiles", "road", "refined", "chiseled", "cracked", "mossy", null, null, null, null, null, "glowstone_lamp", "sunstone_lamp" };

	public MCBlockStone(String name, float baseHardness, boolean chiseledSided)
	{
		super(types, name, baseHardness, chiseledSided);
	}	
	
	public MCBlockStone(String name, float baseHardness)
	{
		super(types, name, baseHardness, true);
	}	
}
