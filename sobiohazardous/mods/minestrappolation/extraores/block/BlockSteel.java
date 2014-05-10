package sobiohazardous.mods.minestrappolation.extraores.block;

import sobiohazardous.mods.minestrappolation.core.util.MAssetManager;
import sobiohazardous.mods.minestrappolation.extraores.lib.EOBlocks;
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
		this.setCreativeTab(EOBlocks.tabOresBlocks);
	}
	
	@Override
	public void registerBlockIcons(IIconRegister iconRegister)
	{
		this.blockIcon = iconRegister.registerIcon(MAssetManager.getEOTexture("blockSteelSide"));
		this.top = iconRegister.registerIcon(MAssetManager.getEOTexture("blockSteelTop"));
		this.bottom = iconRegister.registerIcon(MAssetManager.getEOTexture("blockSteelBottom"));
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
