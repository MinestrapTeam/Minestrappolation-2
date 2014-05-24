package com.minestrappolation.block;

import java.util.Random;

import com.minestrappolation.Minestrappolation;
import com.minestrappolation_core.util.MCAssetManager;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

public class BlockCopper extends Block
{
	public IIcon	tarnishedSideIcon;
	public IIcon	tarnishedTopIcon;
	
	public BlockCopper(Material material)
	{
		super(material);
		this.setTickRandomly(true);
	}
	
	@Override
	public void registerBlockIcons(IIconRegister iconRegister)
	{
		this.blockIcon = iconRegister.registerIcon(MCAssetManager.getMineralTexture("copper_block"));
		this.tarnishedSideIcon = iconRegister.registerIcon(MCAssetManager.getMineralTexture("copper_block_tarnished_side"));
		this.tarnishedTopIcon = iconRegister.registerIcon(MCAssetManager.getMineralTexture("copper_block_tarnished_top"));
	}
	
	@Override
	public IIcon getIcon(int side, int metadata)
	{
		if (metadata == 1)
		{
			if (side == 0)
				return this.blockIcon;
			else if (side == 1)
				return this.tarnishedTopIcon;
			else
				return this.tarnishedSideIcon;
		}
		
		return this.blockIcon;
	}
	
	@Override
	public int tickRate(World world)
	{
		return Minestrappolation.daysUntilTarnish;
	}
	
	@Override
	public void updateTick(World world, int x, int y, int z, Random random)
	{
		world.setBlockMetadataWithNotify(x, y, z, 1, 0);
	}
}
