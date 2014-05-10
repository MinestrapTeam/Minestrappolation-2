package sobiohazardous.mods.minestrappolation.extraores.block;

import sobiohazardous.mods.minestrappolation.core.block.MBlock;
import sobiohazardous.mods.minestrappolation.extraores.lib.EOBlocks;

import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.world.World;

public class BlockInvincium extends MBlock
{
	public BlockInvincium(Material material)
	{
		super(material);
		this.setCreativeTab(EOBlocks.tabOresBlocks);
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
