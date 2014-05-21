package com.minestrappolation.block;

import com.minestrappolation.Minestrappolation;
import com.minestrappolation_core.util.MCAssetManager;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;

public class BlockSteel extends Block
{
	public IIcon	top;
	public IIcon	bottom;
	
	public BlockSteel()
	{
		super(Material.iron);
		this.setCreativeTab(Minestrappolation.tabBuildingBlocks);
	}
	
	@Override
	public void registerBlockIcons(IIconRegister iconRegister)
	{
		this.blockIcon = iconRegister.registerIcon(MCAssetManager.getMineralTexture("steel_block_side"));
		this.top = iconRegister.registerIcon(MCAssetManager.getMineralTexture("steel_block_top"));
		this.bottom = iconRegister.registerIcon(MCAssetManager.getMineralTexture("steel_block_bottom"));
	}
	
	@Override
	public IIcon getIcon(int side, int metadata)
	{
		if (side == 0)
		{
			return this.bottom;
		}
		else if (side == 1)
		{
			return this.top;
		}
		
		return this.blockIcon;
	}
}
