package minestrapteam.minestrappolation.block;

import minestrapteam.minestrappolation.lib.MBlocks;
import minestrapteam.minestrappolation.lib.MFluids;
import minestrapteam.minestrappolation.util.MAssetManager;
import minestrapteam.minestrappolation.util.MUtil;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.init.Blocks;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import net.minecraftforge.fluids.BlockFluidClassic;
import net.minecraftforge.fluids.Fluid;

public class BlockMagma extends BlockFluidClassic
{
	protected IIcon	flowingIcon;
	
	public BlockMagma()
	{
		super(MFluids.MAGMA, Material.lava);
		MFluids.MAGMA.setBlock(this);
		this.setQuantaPerBlock(4);
	}
	
	@Override
	public Fluid getFluid()
	{
		return MFluids.MAGMA;
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
	
	@Override
	public void onNeighborBlockChange(World world, int x, int y, int z, Block block)
	{
		if (MUtil.isWaterTouchingAnySide(world, x, y, z))
		{
			if (world.getBlockMetadata(x, y, z) == 0)
			{
				world.setBlock(x, y, z, Blocks.bedrock);
			}
			else
			{
				world.setBlock(x, y, z, Blocks.cobblestone);
			}
			return;
		}
		super.onNeighborBlockChange(world, x, y, z, block);
	}
	
	@Override
	public boolean displaceIfPossible(World world, int x, int y, int z)
	{
		Block block = world.getBlock(x, y, z);
		if (block == Blocks.flowing_water)
		{
			world.setBlock(x, y, z, MBlocks.deepstone, 7, 3);
		}
		else if (block == Blocks.water)
		{
			world.setBlock(x, y, z, Blocks.obsidian);
		}
		else if (block == Blocks.flowing_lava || block == Blocks.lava)
		{
			return false;
		}
		return super.displaceIfPossible(world, x, y, z);
	}
}