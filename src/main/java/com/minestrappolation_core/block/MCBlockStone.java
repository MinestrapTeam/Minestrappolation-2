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
 * @author Clashsoft
 */
public class MCBlockStone extends Block
{
	public String[]	types;
	
	public String	name;
	public float	baseHardness;
	
	public IIcon	brickIcon;
	public IIcon	patternBrickIcon;
	public IIcon	tilesIcon;
	public IIcon	roadSideIcon;
	public IIcon	roadBottomIcon;
	public IIcon	refinedIcon;
	public IIcon	chiseledIcon;
	public IIcon	chiseledSideIcon;
	public IIcon	crackedIcon;
	public IIcon	mossyIcon;
	
	public IIcon	glowstoneLampIcon;
	public IIcon	sunstoneLampIcon;
	
	public boolean	chiseledSided;
	
	public MCBlockStone(String[] types, String name, float baseHardness)
	{
		super(Material.rock);
		this.setCreativeTab(Minestrappolation.tabStoneDecor);
		this.name = name;
		this.baseHardness = baseHardness;
		this.types = types;
	}
	
	public void setChiseledSided()
	{
		this.chiseledSided = true;
	}
	
	public String getUnlocalizedName(int metadata)
	{
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
		if (metadata == 0)
			return f;
		else if (metadata == 3)
			return f + 0.05F;
		else if (metadata == 4)
			return f;
		else if (metadata == 5)
			return f + 0.1F;
		else if (metadata == 6)
			return f + 0.15F;
		return f;
	}
	
	@Override
	public int getLightValue(IBlockAccess world, int x, int y, int z)
	{
		int metadata = world.getBlockMetadata(x, y, z);
		if (metadata == 14)
		{
			return Blocks.glowstone.getLightValue();
		}
		else if (metadata == 15)
		{
			return 15;
		}
		return super.getLightValue(world, x, y, z);
	}
	
	@Override
	public void registerBlockIcons(IIconRegister iconRegister)
	{
		this.blockIcon = iconRegister.registerIcon(this.getTextureName());
		this.brickIcon = iconRegister.registerIcon(this.getTextureName() + "_bricks");
		this.patternBrickIcon = iconRegister.registerIcon(this.getTextureName() + "_pattern_bricks");
		this.tilesIcon = iconRegister.registerIcon(this.getTextureName() + "_tiles");
		this.roadSideIcon = iconRegister.registerIcon(this.getTextureName() + "_road_side");
		this.roadBottomIcon = iconRegister.registerIcon(this.getTextureName() + "_road_bottom");
		this.refinedIcon = iconRegister.registerIcon(this.getTextureName() + "_refined");
		this.crackedIcon = iconRegister.registerIcon(this.getTextureName() + "_cracked");
		this.mossyIcon = iconRegister.registerIcon(this.getTextureName() + "_mossy");
		
		this.chiseledIcon = iconRegister.registerIcon(this.getTextureName() + "_chiseled");
		if (this.chiseledSided)
			this.chiseledSideIcon = iconRegister.registerIcon(this.getTextureName() + "_chiseled_side");
		
		this.glowstoneLampIcon = iconRegister.registerIcon(this.getTextureName() + "_lamp_glowstone");
		this.sunstoneLampIcon = iconRegister.registerIcon(this.getTextureName() + "_lamp_sunstone");
	}
	
	@Override
	public IIcon getIcon(int side, int metadata)
	{
		if (metadata == 0)
			return this.blockIcon;
		else if (metadata == 1)
			return this.brickIcon;
		else if (metadata == 2)
			return this.patternBrickIcon;
		else if (metadata == 3)
			return this.tilesIcon;
		else if (metadata == 4)
		{
			if (side == 0)
				return this.roadBottomIcon;
			else if (side == 1)
				return this.patternBrickIcon;
			else
				return this.roadSideIcon;
		}
		else if (metadata == 5)
			return this.refinedIcon;
		else if (metadata == 6)
		{
			if (this.chiseledSided && side > 1)
				return this.chiseledSideIcon;
			else
				return this.chiseledIcon;
		}
		else if (metadata == 7)
			return this.crackedIcon;
		else if (metadata == 8)
			return this.mossyIcon;
		else if (metadata == 14)
			return this.glowstoneLampIcon;
		else if (metadata == 15)
			return this.sunstoneLampIcon;
		
		return this.blockIcon;
	}
	
	@Override
	public void getSubBlocks(Item item, CreativeTabs tab, List list)
	{
		for (int i = 0; i < this.types.length; i++)
		{
			if (this.types[i] != null)
				list.add(new ItemStack(item, 1, i));
		}
	}
}
