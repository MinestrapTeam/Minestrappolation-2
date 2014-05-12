package sobiohazardous.mods.minestrappolation.block;

import sobiohazardous.mods.minestrappolation.Minestrappolation;
import sobiohazardous.mods.minestrappolation.core.util.MCAssetManager;
import net.minecraft.block.BlockGlass;
import net.minecraft.block.material.Material;

public class BlockGlowGlass extends BlockGlass
{
	public BlockGlowGlass(Material material, boolean flag)
	{
		super(material, flag);
		this.setBlockTextureName(MCAssetManager.getTexture("GlowGlass"));
		this.setCreativeTab(Minestrappolation.tabDecorationBlocks);
	}
}
