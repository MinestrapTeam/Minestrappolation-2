package sobiohazardous.minestrappolation.api.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockMultiLamp extends BlockMulti
{
	public BlockMultiLamp(Material mat, String[] textures) 
	{
		super(mat, textures);
		this.setStepSound(Block.soundTypeGlass);
		this.setLightLevel(1F);
	}

}
