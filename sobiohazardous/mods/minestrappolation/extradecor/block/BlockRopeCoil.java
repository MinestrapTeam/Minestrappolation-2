package sobiohazardous.mods.minestrappolation.extradecor.block;

import sobiohazardous.mods.minestrappolation.core.util.MAssetManager;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;

public class BlockRopeCoil extends Block
{
	private IIcon	top;
	
	public BlockRopeCoil()
	{
		super(Material.cloth);
	}
	
	@Override
	public void registerBlockIcons(IIconRegister par1IconRegister)
	{
		this.blockIcon = par1IconRegister.registerIcon(MAssetManager.getEDTexture("ropeSide"));
		this.top = par1IconRegister.registerIcon(MAssetManager.getEDTexture("ropeTop"));
	}
	
	@Override
	public IIcon getIcon(int i, int j)
	{
		if (i == 0)
		{
			return this.top;
		}
		if (i == 1)
		{
			return this.top;
		}
		
		if (i == 2)
		{
			return this.blockIcon;
		}
		if (i == 3)
		{
			return this.blockIcon;
		}
		if (i == 4)
		{
			return this.blockIcon;
		}
		if (i == 5)
		{
			return this.blockIcon;
		}
		
		if (j == 1)
		{
			return this.blockIcon;
		}
		return this.blockIcon;
	}
}
