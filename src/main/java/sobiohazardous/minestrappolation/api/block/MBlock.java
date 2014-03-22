package sobiohazardous.minestrappolation.api.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;

public class MBlock extends Block
{
	/**
	 * @Deprecated as of 1.7.2 update. No longer needed as of now, this does nothing different then vanilla.
	 * @param par2Material
	 */
	@Deprecated
	public MBlock(Material par2Material) 
	{
		super(par2Material);
	}
	
	/*
	@Override
	public void registerBlockIcons(IIconRegister r)
	{
		blockIcon = r.registerIcon("minestrappolation:" + this.getUnlocalizedName().substring(5));
	}
	*/
}
