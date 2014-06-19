package minestrapteam.minestrappolation.block;

import minestrapteam.minestrap_core.util.MCAssetManager;

import net.minecraft.block.BlockGlass;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;

public class BlockGlowGlass extends BlockGlass
{
	public BlockGlowGlass(Material material, boolean flag)
	{
		super(material, flag);
		this.setBlockTextureName(MCAssetManager.getTexture("glow_glass"));
	}
	
	@Override
	public void registerBlockIcons(IIconRegister iconRegister)
	{
		this.blockIcon = iconRegister.registerIcon(this.textureName);
	}
	
	@Override
	public int getRenderBlockPass()
	{
		return 1;
	}
}
