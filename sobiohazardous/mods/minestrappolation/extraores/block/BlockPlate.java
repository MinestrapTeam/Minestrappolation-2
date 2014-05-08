package sobiohazardous.mods.minestrappolation.extraores.block;

import java.util.Random;

import sobiohazardous.mods.minestrappolation.core.block.MBlock;
import sobiohazardous.mods.minestrappolation.extraores.ExtraOres;
import sobiohazardous.mods.minestrappolation.extraores.lib.EOBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockPlate extends MBlock
{
	protected static BlockPlate	plate;
	
	public BlockPlate()
	{
		super(Material.circuits);
		this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.125F, 1.0F);
	}
	
	public static final boolean isRailBlockAt(World par0World, int par1, int par2, int par3)
	{
		Block i = par0World.getBlock(par1, par2, par3);
		return i == EOBlocks.TinPlate || i == EOBlocks.BronzePlate || i == EOBlocks.SteelPlate || i == EOBlocks.meuroditePlate;
	}
	
	@Override
	public AxisAlignedBB getCollisionBoundingBoxFromPool(World par1World, int par2, int par3, int i)
	{
		return null;
	}
	
	@Override
	public boolean isOpaqueCube()
	{
		return false;
	}
	
	/**
	 * If this block doesn't render as an ordinary block it will return False
	 * (examples: signs, buttons, stairs, etc)
	 */
	@Override
	public boolean renderAsNormalBlock()
	{
		return false;
	}
	
	@Override
	public MovingObjectPosition collisionRayTrace(World par1World, int par2, int par3, int par4, Vec3 par5Vec3, Vec3 par6Vec3)
	{
		this.setBlockBoundsBasedOnState(par1World, par2, par3, par4);
		return super.collisionRayTrace(par1World, par2, par3, par4, par5Vec3, par6Vec3);
	}
	
	@Override
	public void setBlockBoundsBasedOnState(IBlockAccess par1IBlockAccess, int par2, int par3, int par4)
	{
		int i = par1IBlockAccess.getBlockMetadata(par2, par3, par4);
		
		if (i >= 2 && i <= 5)
		{
			this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.625F, 1.0F);
		}
		else
		{
			this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.125F, 1.0F);
		}
	}
	
	@Override
	public int getRenderType()
	{
		return ExtraOres.plateRenderId;
	}
	
	@Override
	public boolean canPlaceBlockAt(World par1World, int par2, int par3, int par4)
	{
		return World.doesBlockHaveSolidTopSurface(par1World, par2, par3 - 1, par4);
	}
	
	@Override
	public void onBlockAdded(World par1World, int par2, int par3, int par4)
	{
		if (!par1World.isRemote)
		{
			this.refreshTrackShape(par1World, par2, par3, par4, true);
		}
	}
	
	@Override
	public void onNeighborBlockChange(World par1World, int par2, int par3, int par4, Block par5)
	{
		if (!par1World.isRemote)
		{
			int i1 = par1World.getBlockMetadata(par2, par3, par4);
			int j1 = i1;
			
			boolean flag = false;
			
			if (!World.doesBlockHaveSolidTopSurface(par1World, par2, par3 - 1, par4))
			{
				flag = true;
			}
			
			if (j1 == 2 && !World.doesBlockHaveSolidTopSurface(par1World, par2 + 1, par3, par4))
			{
				flag = true;
			}
			
			if (j1 == 3 && !World.doesBlockHaveSolidTopSurface(par1World, par2 - 1, par3, par4))
			{
				flag = true;
			}
			
			if (j1 == 4 && !World.doesBlockHaveSolidTopSurface(par1World, par2, par3, par4 - 1))
			{
				flag = true;
			}
			
			if (j1 == 5 && !World.doesBlockHaveSolidTopSurface(par1World, par2, par3, par4 + 1))
			{
				flag = true;
			}
			
			if (flag)
			{
				this.dropBlockAsItem(par1World, par2, par3, par4, par1World.getBlockMetadata(par2, par3, par4), 0);
				par1World.setBlockToAir(par2, par3, par4);
			}
		}
		
	}
	
	private void refreshTrackShape(World par1World, int par2, int par3, int par4, boolean par5)
	{
		if (par1World.isRemote)
		{
			return;
		}
		else
		{
			new BlockPlateLogic(this, par1World, par2, par3, par4).refreshTrackShape(par1World.isBlockIndirectlyGettingPowered(par2, par3, par4), par5);
			return;
		}
	}
	
	/*
	 * public Item getItemDropped(int par1, Random par2Random, int par3) {
	 * return Item.getItemFromBlock(this) ==
	 * Item.getItemFromBlock(EOBlockManager.TinPlate) ?
	 * EOItemManager.TinPlateItem : (Item.getItemFromBlock(this) ==
	 * Item.getItemFromBlock(EOBlockManager.BronzePlate) ?
	 * EOItemManager.BronzePlateItem : (Item.getItemFromBlock(this) ==
	 * Item.getItemFromBlock(EOBlockManager.SteelPlate) ?
	 * EOItemManager.SteelPlateItem : Item.getItemFromBlock(this))); }
	 */
	
	@Override
	public int quantityDropped(Random par1Random)
	{
		return 1;
	}
}
