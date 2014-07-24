package minestrapteam.minestrappolation.block;

import java.util.Random;

import minestrapteam.minestrappolation.util.MUtil;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.world.World;

public class BlockEnderblock extends Block
{
	public BlockEnderblock()
	{
		super(Material.rock);
		this.setLightLevel(0.6F);
		this.setLightOpacity(1);
	}
	
	@Override
	public boolean isOpaqueCube()
	{
		return false;
	}
	
	@Override
	public boolean renderAsNormalBlock()
	{
		return false;
	}
	
	@Override
	public void randomDisplayTick(World world, int x, int y, int z, Random random)
	{
		for (int i = 0; i < 3; ++i)
		{
			MUtil.spawnParticle(world, x, y, z, random, "portal");
		}
	}
}
