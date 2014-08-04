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
		Minestrappolation.magmaFluid.setBlock(this);
		this.setQuantaPerBlock(4);
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
		return side == 0 || side == 1 ? this.blockIcon : this.flowingIcon;
	}
}