package sobiohazardous.mods.minestrappolation.core.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class MBlockMultiLamp extends MBlockMulti
{
	public MBlockMultiLamp(Material mat, String[] textures)
	{
		super(mat, textures);
		this.setStepSound(Block.soundTypeGlass);
		this.setLightLevel(1F);
	}	
}
