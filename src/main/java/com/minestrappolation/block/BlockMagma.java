package com.minestrappolation.block;

import com.minestrappolation.Minestrappolation;
import com.minestrappolation_core.util.MCAssetManager;

import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;
import net.minecraftforge.fluids.BlockFluidClassic;

public class BlockMagma extends BlockFluidClassic
{
	protected IIcon	stillIcon;
	protected IIcon	flowingIcon;
	
	public BlockMagma(int par1)
	{
		super(Minestrappolation.magmaFluid, Material.lava);
		this.setLightLevel(.5F);
	}
	
	@Override
	public void registerBlockIcons(IIconRegister iconRegister)
	{
		this.stillIcon = iconRegister.registerIcon(MCAssetManager.getTexture("liquid/magmaStill"));
		this.flowingIcon = iconRegister.registerIcon(MCAssetManager.getTexture("liquid/magmaFlow"));
	}
	
	@Override
	public IIcon getIcon(int side, int meta)
	{
		return meta == 1 ? this.stillIcon : this.flowingIcon;
	}
}