package sobiohazardous.mods.minestrappolation.block;

import sobiohazardous.mods.minestrappolation.Minestrappolation;
import sobiohazardous.mods.minestrappolation.core.util.MCAssetManager;
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
		this.blockIcon = iconRegister.registerIcon(MCAssetManager.getEOTexture("blockSteelSide"));
		this.top = iconRegister.registerIcon(MCAssetManager.getEOTexture("blockSteelTop"));
		this.bottom = iconRegister.registerIcon(MCAssetManager.getEOTexture("blockSteelBottom"));
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
