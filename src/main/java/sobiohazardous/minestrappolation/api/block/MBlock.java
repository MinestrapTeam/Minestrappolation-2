package sobiohazardous.minestrappolation.api.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;

public class MBlock extends Block
{
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
	//TODO test textures
}
