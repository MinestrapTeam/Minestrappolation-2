package minestrapteam.minestrappolation.block;

import minestrapteam.minestrappolation.Minestrappolation;
import minestrapteam.minestrappolation.util.MAssetManager;

import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;
import net.minecraftforge.fluids.BlockFluidClassic;
import net.minecraftforge.fluids.Fluid;

public class BlockMagma extends BlockFluidClassic
{
	protected IIcon	flowingIcon;
	
	public BlockMagma()
	{
		super(Minestrappolation.magmaFluid, Material.lava);
		this.setLightLevel(0.5F);
	}
	
	@Override
	public Fluid getFluid()
	{
		return Minestrappolation.magmaFluid;
	}
	
	@Override
	public void registerBlockIcons(IIconRegister iconRegister)
	{
		this.blockIcon = iconRegister.registerIcon(MAssetManager.getLiquidTexture("magma_still"));
		this.flowingIcon = iconRegister.registerIcon(MAssetManager.getLiquidTexture("magma_flowing"));
	}
	
	@Override
	public IIcon getIcon(int side, int meta)
	{
		return meta == 0 ? this.blockIcon : this.flowingIcon;
	}
}