package sobiohazardous.minestrappolation.extradecor.block;

import java.util.Random;

import sobiohazardous.minestrappolation.extradecor.ExtraDecor;
import sobiohazardous.minestrappolation.extradecor.lib.EDBlockManager;
import net.minecraft.block.Block;
import net.minecraft.block.BlockFalling;
import net.minecraft.block.material.Material;
import net.minecraft.world.World;

public class BlockSugarBlock extends BlockFalling
{
	public BlockSugarBlock()
	{
		super(Material.ground);
		this.setCreativeTab(EDBlockManager.tabDecorBlocks);
	}
	
	//TODO Add code from the features list
}
