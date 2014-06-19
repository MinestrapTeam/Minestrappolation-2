package minestrapteam.minestrappolation.block;

import minestrapteam.minestrap_core.util.MCAssetManager;

import net.minecraft.block.BlockGlass;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;

public class BlockGlassRefined extends BlockGlass
{
	public BlockGlassRefined(Material material, boolean flag)
	{
		super(material, flag);
		this.setBlockTextureName(MCAssetManager.getTexture("refined_glass"));
	}
	
	@Override
	public void registerBlockIcons(IIconRegister iconRegister)
	{
		this.blockIcon = iconRegister.registerIcon(this.textureName);
	}
}
