package sobiohazardous.mods.minestrappolation.block;

import sobiohazardous.mods.minestrappolation.core.util.MCAssetManager;
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
	public void registerBlockIcons(IIconRegister iconRegister)
	{
		this.blockIcon = iconRegister.registerIcon(MCAssetManager.getTexture("ropeSide"));
		this.top = iconRegister.registerIcon(MCAssetManager.getTexture("ropeTop"));
	}
	
	@Override
	public IIcon getIcon(int side, int metadata)
	{
		if (side == 0 || side == 1)
		{
			return this.top;
		}
		
		return this.blockIcon;
	}
}
