package minestrapteam.minestrappolation.block;

import minestrapteam.minestrap_core.util.MCAssetManager;
import minestrapteam.minestrappolation.Minestrappolation;

import net.minecraft.block.BlockGlass;
import net.minecraft.block.material.Material;

public class BlockGlowGlass extends BlockGlass
{
	public BlockGlowGlass(Material material, boolean flag)
	{
		super(material, flag);
		this.setBlockTextureName(MCAssetManager.getTexture("glow_glass"));
		this.setCreativeTab(Minestrappolation.tabDecorationBlocks);
	}
}
