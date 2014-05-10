package sobiohazardous.mods.minestrappolation.extraores.block;

import sobiohazardous.mods.minestrappolation.core.util.MAssetManager;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.util.IIcon;

public class BlockDesertQuartzChiseled extends Block
{
	private IIcon	top;
	
	public BlockDesertQuartzChiseled()
	{
		super(Material.rock);
		this.setCreativeTab(CreativeTabs.tabBlock);
	}
	
	@Override
	public void registerBlockIcons(IIconRegister iconRegister)
	{
		this.blockIcon = iconRegister.registerIcon(MAssetManager.getEOTextureSC("DesertQuartz_Chiseled_Side_0"));
		this.top = iconRegister.registerIcon(MAssetManager.getEOTextureSC("DesertQuartz_Chiseled_Top_0"));
	}
	
	@Override
	public int damageDropped(int metadata)
	{
		return 0;
	}
	
	@Override
	public IIcon getIcon(int side, int metadata)
	{
		if (side == 1)
		{
			return this.top;
		}
		
		return this.blockIcon;
	}
	
}
