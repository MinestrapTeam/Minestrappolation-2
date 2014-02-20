package sobiohazardous.minestrappolation.api.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;

public class MBlock extends Block
{
	public MBlock(int par1, Material par2Material) 
	{
		super(par1, par2Material);
	}
	
	public void registerIcons(IconRegister r)
	{
		blockIcon = r.registerIcon("minestrappolation:" + this.getUnlocalizedName().substring(5));
	}
}
