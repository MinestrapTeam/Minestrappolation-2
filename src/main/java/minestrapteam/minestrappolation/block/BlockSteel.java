package minestrapteam.minestrappolation.block;

import minestrapteam.minestrappolation.util.MAssetManager;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;

public class BlockSteel extends Block
{
	public IIcon	top;
	public IIcon	bottom;
	
	public BlockSteel()
	{
		super(Material.iron);
	}
	
	@Override
	public void registerBlockIcons(IIconRegister iconRegister)
	{
		this.blockIcon = iconRegister.registerIcon(MAssetManager.getMineralTexture("steel_block_side"));
		this.top = iconRegister.registerIcon(MAssetManager.getMineralTexture("steel_block_top"));
		this.bottom = iconRegister.registerIcon(MAssetManager.getMineralTexture("steel_block_bottom"));
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
	
	@Override
	public boolean isBeaconBase(IBlockAccess world, int x, int y, int z, int beaconX, int beaconY, int beaconZ)
	{
		return true;
	}
}
