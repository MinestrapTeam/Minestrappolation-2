package sobiohazardous.mods.minestrappolation.block;

import sobiohazardous.mods.minestrappolation.Minestrappolation;
import sobiohazardous.mods.minestrappolation.core.block.MCBlock;
import sobiohazardous.mods.minestrappolation.core.util.MCAssetManager;
import sobiohazardous.mods.minestrappolation.lib.MBlocks;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;

public class BlockCopperTarnished extends MCBlock
{
	public IIcon	top;
	
	public BlockCopperTarnished()
	{
		super(Material.iron);
		this.setCreativeTab(Minestrappolation.tabBuildingBlocks);
	}
	
	@Override
	public void registerBlockIcons(IIconRegister iconRegister)
	{
		this.blockIcon = iconRegister.registerIcon(MCAssetManager.getEOTexture("blockCopperTarnishedSide"));
		this.top = iconRegister.registerIcon(MCAssetManager.getEOTexture("blockCopperTarnishedTop"));
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
