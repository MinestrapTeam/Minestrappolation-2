package com.minestrappolation_core.block;

import java.util.List;

import com.minestrappolation.Minestrappolation;
import com.minestrappolation_core.common.MCCommonProxy;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

/**
 * The second stonecutter block type.<br>
 * This makes up the following blocks:
 * <ul>
 * <li>0: Pillar (Up/Down)
 * <li>1: Pillar (North/South)
 * <li>2: Pillar (East/West)
 * <li>3: Raw Slab Lower
 * <li>4: Raw Slab Upper
 * <li>5: Raw Slab Double
 * <li>6: Brick Slab Lower
 * <li>7: Brick Slab Upper
 * <li>8: Brick Slab Double
 * <li>9: Tile Slab Lower
 * <li>10: Tile Slab Upper
 * <li>11: Tile Slab Double
 * <li>12: Refined Slab Lower
 * <li>13: Refined Slab Upper
 * <li>14: Refined Slab Double
 * </ul>
 * Everything else is added by {@link MBlockStone}
 * 
 * @author Clashsoft, SoBiohazardous
 */
public class MCBlockStone2 extends MCBlockStoneCustom2
{
	public static final String[]	types	= new String[] { "pillar", "raw_slab", "brick_slab", "tile_slab", "refined_slab" };

	public MCBlockStone2(String name, float baseHardness)
	{
		super(types, name, baseHardness);
	}	
}
