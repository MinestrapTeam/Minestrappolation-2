package minestrapteam.minestrap_core.block;

import java.util.Random;

import minestrapteam.minestrappolation.lib.MBlocks;
import minestrapteam.minestrappolation.lib.MItems;

import net.minecraft.block.BlockPane;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.world.World;

public class MCBlockPane extends BlockPane
{
	public MCBlockPane(Material material, String iconName, String sideIconName, boolean drops)
	{
		super(iconName, sideIconName, material, drops);
	}
	
	@Override
	public Item getItem(World world, int x, int y, int z)
	{
		if (this == MBlocks.cardboard)
			return MItems.cardboardItem;
		return super.getItem(world, x, y, z);
	}
	
	@Override
	public Item getItemDropped(int metadata, Random random, int fortune)
	{
		if (this == MBlocks.cardboard)
			return MItems.cardboardItem;
		return super.getItemDropped(metadata, random, fortune);
	}
}
