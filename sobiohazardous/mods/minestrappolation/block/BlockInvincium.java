package sobiohazardous.mods.minestrappolation.block;

import sobiohazardous.mods.minestrappolation.Minestrappolation;
import sobiohazardous.mods.minestrappolation.core.block.MCBlock;
import sobiohazardous.mods.minestrappolation.lib.MBlocks;
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
