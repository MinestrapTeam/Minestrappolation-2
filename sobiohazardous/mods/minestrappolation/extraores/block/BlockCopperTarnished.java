package sobiohazardous.mods.minestrappolation.extraores.block;

import sobiohazardous.mods.minestrappolation.core.block.MBlock;
import sobiohazardous.mods.minestrappolation.core.util.MAssetManager;
import sobiohazardous.mods.minestrappolation.extraores.lib.EOBlocks;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;

public class BlockCopperTarnished extends MBlock
{
	public IIcon	top;
	
	public BlockCopperTarnished()
	{
		super(Material.iron);
		this.setCreativeTab(EOBlocks.tabOresBlocks);
	}
	
	@Override
	public void registerBlockIcons(IIconRegister iconRegister)
	{
		this.blockIcon = iconRegister.registerIcon(MAssetManager.getEOTexture("blockCopperTarnishedSide"));
		this.top = iconRegister.registerIcon(MAssetManager.getEOTexture("blockCopperTarnishedTop"));
	}
	
	@Override
	public IIcon getIcon(int side, int metadata)
	{
		if (side == 0)
		{
			return this.blockIcon;
		}
		else if (side == 1)
		{
			return this.top;
		}
		
		return this.blockIcon;
	}
}
