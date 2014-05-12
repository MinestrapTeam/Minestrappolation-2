package com.minestrappolation.block;

import com.minestrappolation.Minestrappolation;
import com.minestrappolation.core.block.MCBlock;

import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.world.World;

public class BlockInvincium extends MCBlock
{
	public BlockInvincium(Material material)
	{
		super(material);
		this.setCreativeTab(Minestrappolation.tabBuildingBlocks);
	}
	
	@Override
	public void onEntityWalking(World world, int x, int y, int z, Entity entity)
	{
		super.onEntityWalking(world, x, y, z, entity);
		entity.setFire(15);
	}
	
	@Override
	public void onEntityCollidedWithBlock(World world, int x, int y, int z, Entity entity)
	{
		super.onEntityCollidedWithBlock(world, x, y, z, entity);
		entity.setFire(15);
	}
	
}
