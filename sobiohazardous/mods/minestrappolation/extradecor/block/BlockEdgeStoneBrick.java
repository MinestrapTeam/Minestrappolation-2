package sobiohazardous.mods.minestrappolation.extradecor.block;

import sobiohazardous.mods.minestrappolation.core.util.MAssetManager;
import sobiohazardous.mods.minestrappolation.extradecor.lib.EDBlocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.init.Blocks;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;

public class BlockEdgeStoneBrick extends Block
{
	private IIcon	left;
	private IIcon	right;
	
	public BlockEdgeStoneBrick()
	{
		super(Material.rock);
		this.setCreativeTab(EDBlocks.tabDecor);
	}
	
	@Override
	public void registerBlockIcons(IIconRegister iconRegister)
	{
		this.blockIcon = iconRegister.registerIcon(MAssetManager.getEDStonecutterTexture("EdgeStone_Bricks_0_Full"));
		this.left = iconRegister.registerIcon(MAssetManager.getEDStonecutterTexture("EdgeStone_Bricks_0_Left"));
		this.right = iconRegister.registerIcon(MAssetManager.getEDStonecutterTexture("EdgeStone_Bricks_0_Right"));
	}
	
	@Override
	public IIcon getIcon(IBlockAccess world, int x, int y, int z, int side)
	{
		boolean x1 = isBrick(world, x + 1, y, z);
		boolean z1 = isBrick(world, x, y, z + 1);
		boolean x2 = isBrick(world, x - 1, y, z);
		boolean z2 = isBrick(world, x, y, z - 1);
		if (side == 2) // NORTH
		{
			if (x1 != x2)
			{
				if (x1)
					return this.left;
				else if (x2)
					return this.right;
			}
		}
		else if (side == 3) // SOUTH
		{
			if (x1 != x2)
			{
				if (x1)
					return this.left;
				else if (x2)
					return this.right;
			}
		}
		else if (side == 4)
		{
			if (z1 != z2)
			{
				if (z1)
					return this.left;
				else if (z2)
					return this.right;
			}
		}
		else if (side == 5)
		{
			if (z1 != z2)
			{
				if (z1)
					return this.left;
				else if (z2)
					return this.right;
			}
		}
		
		return this.blockIcon;
	}
	
	public boolean isBrick(IBlockAccess world, int x, int y, int z)
	{
		Block block = world.getBlock(x, y, z);
		return block == this || block == Blocks.stonebrick;
	}
}
