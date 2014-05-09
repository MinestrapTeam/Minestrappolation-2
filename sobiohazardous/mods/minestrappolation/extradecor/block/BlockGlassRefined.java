package sobiohazardous.mods.minestrappolation.extradecor.block;

import sobiohazardous.mods.minestrappolation.core.util.MAssetManager;

import net.minecraft.block.BlockGlass;
import net.minecraft.block.material.Material;

public class BlockGlassRefined extends BlockGlass
{
	public BlockGlassRefined(Material material, boolean flag)
	{
		super(material, flag);
		this.setBlockTextureName(MAssetManager.getEDTexture("clearGlass"));
	}
}
