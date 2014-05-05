package sobiohazardous.mods.minestrappolation.extraores.block;

import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;
import sobiohazardous.mods.minestrappolation.core.block.MBlock;
import sobiohazardous.mods.minestrappolation.extraores.lib.EOBlocks;

public class BlockInvincium extends MBlock
{
	public BlockInvincium(Material par2Material)
	{
		super(par2Material);
		this.setCreativeTab(EOBlocks.tabOresBlocks);

	}

	public void onEntityWalking(World par1World, int par2, int par3, int par4, Entity par5Entity)
	{
		super.onEntityWalking(par1World, par2, par3, par4, par5Entity);
		par5Entity.setFire(15);
	}

	public void onEntityCollidedWithBlock(World par1World, int par2, int par3, int par4, Entity par5Entity)
	{
		super.onEntityCollidedWithBlock(par1World, par2, par3, par4, par5Entity);
		par5Entity.setFire(15);
	}

}
