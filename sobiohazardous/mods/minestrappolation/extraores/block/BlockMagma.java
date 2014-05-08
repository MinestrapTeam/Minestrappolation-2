package sobiohazardous.mods.minestrappolation.extraores.block;

import sobiohazardous.mods.minestrappolation.core.util.MAssetManager;
import sobiohazardous.mods.minestrappolation.extraores.ExtraOres;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;
import net.minecraftforge.fluids.BlockFluidClassic;

public class BlockMagma extends BlockFluidClassic
{
	protected IIcon[]	iconArray;
	
	public BlockMagma(int par1)
	{
		super(ExtraOres.eoFluid, Material.lava);
		this.setLightLevel(.5F);
	}
	
	@Override
	public void registerBlockIcons(IIconRegister r)
	{
		this.iconArray = new IIcon[] { r.registerIcon(MAssetManager.getEOTexture("liquid/magmaStill")), r.registerIcon(MAssetManager.getEOTexture("liquid/magmaFlow")) };
	}
	
	@Override
	public IIcon getIcon(int side, int meta)
	{
		return meta == 1 ? this.iconArray[0] : this.iconArray[1];
	}
}