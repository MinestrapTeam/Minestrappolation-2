package minestrapteam.minestrappolation.block.glass;

import net.minecraft.block.BlockGlass;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;

public class BlockSlowGlass extends BlockGlass
{
	public BlockSlowGlass(Material material, boolean flag)
	{
		super(material, flag);
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
