package minestrapteam.minestrappolation.block.ore;

import java.util.Random;

import clashsoft.cslib.minecraft.block.ore.BlockOre2;
import clashsoft.cslib.minecraft.block.ore.OreBase;
import minestrapteam.minestrappolation.lib.MItems;

import net.minecraft.item.Item;
import net.minecraft.world.IBlockAccess;

public class BlockSunstoneOre extends BlockOre2
{
	public BlockSunstoneOre()
	{
		super(OreBase.TYPE_OVERWORLD);
		this.setLightLevel(1F);
	}
	
	@Override
	public int quantityDroppedWithBonus(int fortune, Random random)
	{
		return this.quantityDropped(random) + random.nextInt(fortune + 1);
	}
	
	@Override
	public int quantityDropped(Random random)
	{
		return 2 + random.nextInt(3);
	}
	
	@Override
	public Item getItemDropped(int metadata, Random random, int fortune)
	{
		return MItems.sunstoneDust;
	}
	
	@Override
	public int getExpDrop(IBlockAccess world, int metadata, int fortune)
	{
		return 8 + fortune;
	}
}
