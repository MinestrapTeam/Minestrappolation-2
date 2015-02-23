package minestrapteam.minestrappolation.block.storage;

import java.util.Random;

import minestrapteam.minestrappolation.block.MBlock;
import minestrapteam.minestrappolation.lib.MItems;
import minestrapteam.minestrappolation.util.MUtil;

import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockSoulBlock extends MBlock
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
		for (int i = 0; i < 3; ++i)
		{
			MUtil.spawnParticle(world, x, y, z, random, "portal");
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
	public void onBlockHarvested(World world, int x, int y, int z, int metadata, EntityPlayer player)
	{
		int amount = MathHelper.getRandomIntegerInRange(world.rand, 140, 220);
		this.dropXpOnBlockBreak(world, x, y, z, amount);
	}
	
	@Override
	public boolean isBeaconBase(IBlockAccess world, int x, int y, int z, int beaconX, int beaconY, int beaconZ)
	{
		return true;
	}
}
