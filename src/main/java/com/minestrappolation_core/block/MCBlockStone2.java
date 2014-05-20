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
 * @author Clashsoft
 */
public class MCBlockStone2 extends Block
{
	public static final String[]	types	= new String[] { "pillar", "raw_slab", "brick_slab", "tile_slab", "refined_slab" };
	
	public String					name;
	public float					baseHardness;
	
	public IIcon[]					topIcons;
	public IIcon[]					sideIcons;
	
	public MCBlockStone2(String name, float baseHardness)
	{
		super(Material.rock);
		this.setCreativeTab(Minestrappolation.tabStoneDecor);
		this.name = name;
		this.baseHardness = baseHardness;
	}
	
	@Override
	public void setBlockBoundsBasedOnState(IBlockAccess world, int x, int y, int z)
	{
		int i = world.getBlockMetadata(x, y, z);
		this.setBlockBounds(i);
	}
	
	@Override
	public void addCollisionBoxesToList(World world, int x, int y, int z, AxisAlignedBB aabb, List list, Entity entity)
	{
		setBlockBoundsBasedOnState(world, x, y, z);
		super.addCollisionBoxesToList(world, x, y, z, aabb, list, entity);
	}
	
	public void setBlockBounds(int metadata)
	{
		if (metadata < 3)
		{
			this.setBlockBounds(0F, 0F, 0F, 1F, 1F, 1F);
		}
		else
		{
			int model = metadata % 3;
			
			if (model == 0)
				this.setBlockBounds(0F, 0F, 0F, 1F, 0.5F, 1F);
			else if (model == 1)
				this.setBlockBounds(0F, 0.5F, 0F, 1F, 1F, 1F);
			else
				this.setBlockBounds(0F, 0F, 0F, 1F, 1F, 1F);
		}
	}
	
	@Override
	public int onBlockPlaced(World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ, int metadata)
	{
		if (metadata < 3)
		{
			if (side == 0 || side == 1)
			{
				return 0;
			}
			else if (side == 2 || side == 3)
			{
				return 1;
			}
			else if (side == 4 || side == 5)
			{
				return 2;
			}
		}
		return metadata;
	}
	
	public int limitToValidMetadata(int metadata)
	{
		return (metadata / 3) * 3;
	}
	
	@Override
	protected ItemStack createStackedBlock(int metadata)
	{
		return super.createStackedBlock(this.limitToValidMetadata(metadata));
	}
	
	@Override
	public int damageDropped(int metadata)
	{
		return super.damageDropped(this.limitToValidMetadata(metadata));
	}
	
	public String getUnlocalizedName(int metadata)
	{
		metadata /= 3;
		if (metadata >= types.length)
			metadata = 0;
		return "tile." + this.name + "." + types[metadata];
	}
	
	@Override
	public float getBlockHardness(World world, int x, int y, int z)
	{
		return this.getHardness(world.getBlockMetadata(x, y, z));
	}
	
	public float getHardness(int metadata)
	{
		float f = this.baseHardness;
		if (metadata < 3)
			return f + 0.5F;
		else if (metadata % 3 == 2)
			return f + 1F;
		return f;
	}
	
	@Override
	public void registerBlockIcons(IIconRegister iconRegister)
	{
		this.topIcons = new IIcon[5];
		this.sideIcons = new IIcon[5];
		
		this.topIcons[0] = iconRegister.registerIcon(this.name + "_pillar_top");
		this.sideIcons[0] = iconRegister.registerIcon(this.name + "_pillar_side");
		this.topIcons[1] = iconRegister.registerIcon(this.name + "_slab_top");
		this.sideIcons[1] = iconRegister.registerIcon(this.name + "_slab_side");
		this.topIcons[2] = iconRegister.registerIcon(this.name + "_brick_slab_top");
		this.sideIcons[2] = iconRegister.registerIcon(this.name + "_brick_slab_side");
		this.topIcons[3] = iconRegister.registerIcon(this.name + "_tile_slab_top");
		this.sideIcons[3] = iconRegister.registerIcon(this.name + "_tile_slab_side");
		this.topIcons[4] = iconRegister.registerIcon(this.name + "_refined_slab_top");
		this.sideIcons[4] = iconRegister.registerIcon(this.name + "_refined_slab_side");
	}
	
	@Override
	public IIcon getIcon(int side, int metadata)
	{
		if (metadata == 0)
		{
			if (side == 0 || side == 1)
				return this.topIcons[0];
			else
				return this.sideIcons[0];
		}
		else if (metadata == 1)
		{
			if (side == 2 || side == 3)
				return this.topIcons[0];
			else
				return this.sideIcons[0];
		}
		else if (metadata == 2)
		{
			if (side == 4 || side == 5)
				return this.topIcons[0];
			else
				return this.sideIcons[0];
		}
		else if (metadata < 15)
		{
			if (side == 0 || side == 1)
				return this.topIcons[metadata / 3];
			else
				return this.sideIcons[metadata / 3];
		}
		return this.blockIcon;
	}
	
	@Override
	public boolean isOpaqueCube()
	{
		return false;
	}
	
	@Override
	public boolean renderAsNormalBlock()
	{
		return false;
	}
	
	@Override
	public int getRenderType()
	{
		return MCCommonProxy.stone2RenderType;
	}
	
	@Override
	public void getSubBlocks(Item item, CreativeTabs tab, List list)
	{
		list.add(new ItemStack(item, 1, 0));
		list.add(new ItemStack(item, 1, 3));
		list.add(new ItemStack(item, 1, 6));
		list.add(new ItemStack(item, 1, 9));
		list.add(new ItemStack(item, 1, 12));
	}
}
