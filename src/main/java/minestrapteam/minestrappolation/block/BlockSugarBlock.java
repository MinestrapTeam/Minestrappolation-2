package minestrapteam.minestrappolation.block;

import minestrapteam.minestrappolation.Minestrappolation;

import net.minecraft.block.BlockFalling;
import net.minecraft.block.material.Material;

public class BlockSugarBlock extends BlockFalling
{
	public BlockSugarBlock()
	{
		super(Material.ground);
		this.setCreativeTab(Minestrappolation.tabDecorationBlocks);
	}
	
	// TODO Add code from the features list
}