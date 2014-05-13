package com.minestrappolation.block;

import com.minestrappolation.Minestrappolation;
import com.minestrappolation.lib.MBlocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;

public class BlockOoze extends Block
{
	public BlockOoze(Material material)
	{
		super(material);
		this.setCreativeTab(Minestrappolation.tabBuildingBlocks);
	}
	
	@Override
	public boolean isOpaqueCube()
	{
		return false;
	}
	
	@Override
	public void onEntityCollidedWithBlock(World world, int x, int y, int z, Entity entity)
	{
		entity.setInWeb();
		entity.addVelocity(0D, -0.3D, 0D);
		
		/*
		 * if(blockID == ExtraDecor.oozeSlime.blockID) { ticks++;
		 * System.out.println(ticks); if(ticks<=10) { par5Entity.setAir(300);
		 * System.out.println("set"); } if(ticks>=11) {
		 * par5Entity.setAir(par5Entity.getAir() - 1); } }
		 */
		
		if (world.getBlock(x, y, z) == MBlocks.magmaOoze)
		{
			entity.setFire(1);
		}
	}
	
	@Override
	public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int x, int y, int z)
	{
		return null;
	}
}
