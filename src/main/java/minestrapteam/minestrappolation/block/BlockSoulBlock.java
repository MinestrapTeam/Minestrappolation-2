package minestrapteam.minestrappolation.block;

import java.util.Random;

import minestrapteam.mcore.block.MCBlock;
import minestrapteam.mcore.util.MCUtil;
import minestrapteam.minestrappolation.lib.MItems;

import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class BlockSoulBlock extends MCBlock
{
	Random	rand	= new Random();
	
	public BlockSoulBlock()
	{
		super(Material.iron);
		this.setLightLevel(1F);
	}
	
	@Override
	public void randomDisplayTick(World world, int x, int y, int z, Random random)
	{
		for (int var6 = 0; var6 < 3; ++var6)
		{
			MCUtil.spawnParticle(world, x, y, z, random, "portal");
		}
	}
	
	@Override
	public int quantityDropped(Random random)
	{
		return 1 + random.nextInt(4);
	}
	
	@Override
	public Item getItemDropped(int metadata, Random random, int fortune)
	{
		return MItems.soulGem;
	}
	
	@Override
	public void onBlockDestroyedByPlayer(World world, int x, int y, int z, int metadata)
	{
		int amount = MathHelper.getRandomIntegerInRange(world.rand, 140, 220);
		this.dropXpOnBlockBreak(world, x, y, z, amount);
	}
}
