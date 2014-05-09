package sobiohazardous.mods.minestrappolation.extradecor.block;

import java.util.Random;

import sobiohazardous.mods.minestrappolation.extradecor.lib.EDItems;

import net.minecraft.block.BlockDoor;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;

public class BlockGlassDoor extends BlockDoor
{
	public BlockGlassDoor(Material material)
	{
		super(material);
	}
	
	@Override
	public Item getItemDropped(int metadata, Random random, int fortune)
	{
		return EDItems.glassDoor;
	}
}
