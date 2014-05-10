package sobiohazardous.mods.minestrappolation.extraores.block;

import java.util.Random;

import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

import sobiohazardous.mods.minestrappolation.core.block.MBlock;
import sobiohazardous.mods.minestrappolation.core.util.MUtil;
import sobiohazardous.mods.minestrappolation.extraores.lib.EOBlocks;

public class BlockSoulBlock extends MBlock
{
	Random	rand	= new Random();
	
	public BlockSoulBlock()
	{
		super(Material.iron);
		this.setCreativeTab(EOBlocks.tabOresBlocks);
	}
	
	@Override
	public void randomDisplayTick(World world, int x, int y, int z, Random random)
	{
		for (int var6 = 0; var6 < 3; ++var6)
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
		return EOBlocks.SoulGem;
	}
	
	@Override
	public void onBlockDestroyedByPlayer(World world, int x, int y, int z, int metadata)
	{
		int amount = MathHelper.getRandomIntegerInRange(world.rand, 140, 220);
		this.dropXpOnBlockBreak(world, x, y, z, amount);
	}
}
