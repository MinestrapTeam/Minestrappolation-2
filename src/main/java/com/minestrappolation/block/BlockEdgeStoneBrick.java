package com.minestrappolation.block;

import com.minestrappolation.Minestrappolation;
import com.minestrappolation_core.util.MCAssetManager;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.init.Blocks;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;

public class BlockEdgeStoneBrick extends Block
{
	private IIcon	left;
	private IIcon	right;
	private IIcon	half;
	
	public BlockEdgeStoneBrick()
	{
		super(Material.rock);
		this.setCreativeTab(Minestrappolation.tabDecorationBlocks);
	}
	
	@Override
	public void registerBlockIcons(IIconRegister iconRegister)
	{
		this.blockIcon = iconRegister.registerIcon(MCAssetManager.getSCTexture("EdgeStone_Bricks_0_Full"));
		this.left = iconRegister.registerIcon(MCAssetManager.getSCTexture("EdgeStone_Bricks_0_Left"));
		this.right = iconRegister.registerIcon(MCAssetManager.getSCTexture("EdgeStone_Bricks_0_Right"));
		this.half = iconRegister.registerIcon(MCAssetManager.getSCTexture("EdgeStone_Bricks_0_Half"));
	}
	
	@Override
	public IIcon getIcon(IBlockAccess world, int x, int y, int z, int side)
	{
		boolean x1 = this.isBrick(world, x + 1, y, z);
		boolean z1 = this.isBrick(world, x, y, z + 1);
		boolean x2 = this.isBrick(world, x - 1, y, z);
		boolean z2 = this.isBrick(world, x, y, z - 1);
		byte b = 0;
		if (side == 2) // NORTH
		{
			if (x1)
			{
				b |= 1;
			}
			if (x2)
			{
				b |= 2;
			}
		}
		else if (side == 3) // SOUTH
		{
			if (x1)
			{
				b |= 1;
			}
			if (x2)
			{
				b |= 2;
			}
		}
		else if (side == 4)
		{
			if (z1)
			{
				b |= 1;
			}
			if (z2)
			{
				b |= 2;
			}
		}
		else if (side == 5)
		{
			if (z1)
			{
				b |= 1;
			}
			if (z2)
			{
				b |= 2;
			}
		}
		
		switch (b)
		{
		case 0:
			return this.blockIcon;
		case 1:
			return this.left;
		case 2:
			return this.right;
		case 3:
			return this.half;
		}
		return this.blockIcon;
	}
	
	public boolean isBrick(IBlockAccess world, int x, int y, int z)
	{
		Block block = world.getBlock(x, y, z);
		return block == this || block == Blocks.stonebrick;
	}
}
