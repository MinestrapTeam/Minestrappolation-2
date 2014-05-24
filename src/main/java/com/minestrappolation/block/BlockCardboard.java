package com.minestrappolation.block;

import java.util.Random;

import com.minestrappolation_core.util.MCAssetManager;
import com.minestrappolation_core.util.MCUtil;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;

public class BlockCardboard extends Block
{
	private IIcon	topIcon;
	private IIcon	wetTopIcon;
	private IIcon	wetSideIcon;
	
	public BlockCardboard(Material material)
	{
		super(material);
	}
	
	@Override
	public int getFlammability(IBlockAccess world, int x, int y, int z, ForgeDirection face)
	{
		return 255;
	}
	
	@Override
	public void onEntityWalking(World world, int x, int y, int z, Entity entity)
	{
		if (!world.isRemote && world.getBlockMetadata(x, y, z) == 1)
		{
			world.func_147480_a(x, y, z, true);
		}
	}
	
	@Override
	public IIcon getIcon(int side, int metadata)
	{
		if (metadata == 0)
		{
			if (side == 0)
				return this.topIcon;
		}
		else if (metadata == 1)
		{
			if (side == 1)
				return this.wetTopIcon;
			else if (side != 0)
				return this.wetSideIcon;
		}
		
		return this.blockIcon;
	}
	
	@Override
	public void registerBlockIcons(IIconRegister iconRegister)
	{
		this.blockIcon = iconRegister.registerIcon(MCAssetManager.getTexture("cardboard"));
		this.topIcon = iconRegister.registerIcon(MCAssetManager.getTexture("cardboard_top"));
		this.wetSideIcon = iconRegister.registerIcon(MCAssetManager.getTexture("cardboard_wet_side"));
		this.wetTopIcon = iconRegister.registerIcon(MCAssetManager.getTexture("cardboard_wet_top"));
	}
	
	@Override
	public void onNeighborBlockChange(World world, int x, int y, int z, Block neighbor)
	{
		this.checkDryness(world, x, y, z);
	}
	
	@Override
	public void updateTick(World world, int x, int y, int z, Random random)
	{
		this.checkDryness(world, x, y, z);
	}
	
	public void checkDryness(World world, int x, int y, int z)
	{
		if (MCUtil.isWaterTouchingAnySide(world, x, y, z))
		{
			world.setBlockMetadataWithNotify(x, y, z, 1, 2);
		}
	}
}
