package com.minestrappolation.block;

import com.minestrappolation.Minestrappolation;
import com.minestrappolation.core.block.MCBlock;
import com.minestrappolation.core.util.MCAssetManager;

import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;

public class BlockCopperTarnished extends MCBlock
{
	public IIcon	top;
	
	public BlockCopperTarnished()
	{
		super(Material.iron);
		this.setCreativeTab(Minestrappolation.tabBuildingBlocks);
	}
	
	@Override
	public void registerBlockIcons(IIconRegister iconRegister)
	{
		this.blockIcon = iconRegister.registerIcon(MCAssetManager.getTexture("blockCopperTarnishedSide"));
		this.top = iconRegister.registerIcon(MCAssetManager.getTexture("blockCopperTarnishedTop"));
	}
	
	@Override
	public IIcon getIcon(int side, int metadata)
	{
		if (side == 0)
		{
			return this.blockIcon;
		}
		else if (side == 1)
		{
			return this.top;
		}
		
		return this.blockIcon;
	}
}
