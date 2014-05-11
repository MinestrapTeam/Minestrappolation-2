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
	private IIcon	half;
	
	public BlockEdgeStoneBrick()
	{
		super(Material.rock);
		this.setCreativeTab(EDBlocks.tabBlocks);
	}
	
	@Override
	public void registerBlockIcons(IIconRegister iconRegister)
	{
		this.blockIcon = iconRegister.registerIcon(MAssetManager.getEDTextureSC("EdgeStone_Bricks_0_Full"));
		this.left = iconRegister.registerIcon(MAssetManager.getEDTextureSC("EdgeStone_Bricks_0_Left"));
		this.right = iconRegister.registerIcon(MAssetManager.getEDTextureSC("EdgeStone_Bricks_0_Right"));
		this.half = iconRegister.registerIcon(MAssetManager.getEDTextureSC("EdgeStone_Bricks_0_Half"));
	}
	
	@Override
	public IIcon getIcon(IBlockAccess world, int x, int y, int z, int side)
	{
		boolean x1 = isBrick(world, x + 1, y, z);
		boolean z1 = isBrick(world, x, y, z + 1);
		boolean x2 = isBrick(world, x - 1, y, z);
		boolean z2 = isBrick(world, x, y, z - 1);
		byte b = 0;
		if (side == 2) // NORTH
		{
			if (x1)
				b |= 1;
			if (x2)
				b |= 2;
		}
		else if (side == 3) // SOUTH
		{
			if (x1)
				b |= 1;
			if (x2)
				b |= 2;
		}
		else if (side == 4)
		{
			if (z1)
				b |= 1;
			if (z2)
				b |= 2;
		}
		else if (side == 5)
		{
			if (z1)
				b |= 1;
			if (z2)
				b |= 2;
		}
		
		switch (b)
		{
		case 0:
			return this.blockIcon;
		case 1:
			return this.left;
		case 2:
			return this.right;
		case 3:
			return this.half;
		}
		return this.blockIcon;
	}
	
	public boolean isBrick(IBlockAccess world, int x, int y, int z)
	{
		Block block = world.getBlock(x, y, z);
		return block == this || block == Blocks.stonebrick;
	}
}
