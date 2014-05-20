package com.minestrappolation_core.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class MCBlockMultiLamp extends MCBlockMulti
{
	public MCBlockMultiLamp(Material mat, String[] textures)
	{
		super(mat, textures);
		this.setStepSound(Block.soundTypeGlass);
		this.setLightLevel(1F);
	}
}
