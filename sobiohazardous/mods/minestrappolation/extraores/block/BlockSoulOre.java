package sobiohazardous.mods.minestrappolation.extraores.block;

import java.util.Random;

import sobiohazardous.mods.minestrappolation.core.block.MBlock;
import sobiohazardous.mods.minestrappolation.extraores.lib.EOBlocks;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;

public class BlockSoulOre extends MBlock
{
	Random	rand	= new Random();
	
	public BlockSoulOre()
	{
		super(Material.sand);
		this.setCreativeTab(EOBlocks.tabOresBlocks);
	}
	
	/**
	 * Returns a bounding box from the pool of bounding boxes (this means this
	 * box can change after the pool has been cleared to be reused)
	 */
	@Override
	public AxisAlignedBB getCollisionBoundingBoxFromPool(World par1World, int par2, int par3, int par4)
	{
		float f = 0.125F;
		return AxisAlignedBB.getAABBPool().getAABB(par2, par3, par4, par2 + 1, par3 + 1 - f, par4 + 1);
	}
	
	@Override
	public int quantityDropped(Random par1Random)
	{
		return 1 + par1Random.nextInt(2);
	}
	
	/**
	 * Triggered whenever an entity collides with this block (enters into the
	 * block). Args: world, x, y, z, entity
	 */
	@Override
	public void onEntityCollidedWithBlock(World par1World, int par2, int par3, int par4, Entity par5Entity)
	{
		par5Entity.motionX *= 0.4D;
		par5Entity.motionZ *= 0.4D;
	}
	
	@Override
	public Item getItemDropped(int par1, Random par2Random, int par3)
	{
		return EOBlocks.SoulGem;
	}
	
	@Override
	public void onBlockDestroyedByPlayer(World par1World, int par2, int par3, int par4, int par5)
	{
		this.dropXpOnBlockBreak(par1World, par2, par3, par4, this.rand.nextInt(6) + 4); /*
																						 * the
																						 * 1
																						 * means
																						 * it
																						 * drops
																						 * 1
																						 * xp
																						 * ,
																						 * change
																						 * it
																						 * to
																						 * 20
																						 * ,
																						 * 100
																						 * ,
																						 * as
																						 * much
																						 * as
																						 * you
																						 * want
																						 * .
																						 */
	}
}
