package sobiohazardous.mods.minestrappolation.extraores.block;

import sobiohazardous.mods.minestrappolation.core.util.MAssetManager;
import sobiohazardous.mods.minestrappolation.extraores.lib.EOBlocks;

import net.minecraft.block.BlockGlass;
import net.minecraft.block.material.Material;

public class BlockGlowGlass extends BlockGlass
{
	public BlockGlowGlass(Material material, boolean flag)
	{
		super(material, flag);
		this.setBlockTextureName(MAssetManager.getEDTexture("GlowGlass"));
		this.setCreativeTab(EOBlocks.tabOresBlocks);
	}
}
