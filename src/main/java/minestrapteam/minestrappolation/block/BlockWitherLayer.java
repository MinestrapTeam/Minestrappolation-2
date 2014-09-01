package minestrapteam.minestrappolation.block;

import java.util.Random;

import minestrapteam.minestrappolation.lib.MItems;

import net.minecraft.block.BlockSnow;
import net.minecraft.item.Item;

public class BlockWitherLayer extends BlockSnow
{
	public BlockWitherLayer()
	{
		super();
		this.setLightOpacity(0);
	}
	
	@Override
	public Item getItemDropped(int metadata, Random random, int fortune)
	{
		return MItems.witherAsh;
	}
}