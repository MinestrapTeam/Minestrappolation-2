package com.minestrappolation_core.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class MCBlock extends Block
{
	/**
	 * @deprecated as of 1.7.2 update. No longer needed as of now, this does
	 *             nothing different then vanilla.
	 * @param par2Material
	 */
	@Deprecated
	public MCBlock(Material material)
	{
		super(material);
	}
	
	/*
	 * @Override public void registerBlockIcons(IIconRegister r) { blockIcon =
	 * r.registerIcon("minestrappolation:" +
	 * this.getUnlocalizedName().substring(5)); }
	 */
}
