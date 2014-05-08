package sobiohazardous.mods.minestrappolation.extraores.block;

import java.util.Random;

import sobiohazardous.mods.minestrappolation.core.block.MBlock;
import sobiohazardous.mods.minestrappolation.core.util.MAssetManager;
import sobiohazardous.mods.minestrappolation.extraores.lib.EOBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.monster.EntityBlaze;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockBlazium extends MBlock
{
	public BlockBlazium()
	{
		super(Material.iron);
		this.setCreativeTab(CreativeTabs.tabBlock);
	}
	
	@Override
	public void registerBlockIcons(IIconRegister iconRegister)
	{
		this.blockIcon = iconRegister.registerIcon(MAssetManager.getEOTexture("blockBlazium"));
	}
	
	/**
	 * Returns the ID of the items to drop on destruction.
	 */
	@Override
	public Item getItemDropped(int par1, Random par2Random, int par3)
	{
		return Item.getItemFromBlock(EOBlocks.BlaziumBlock);
	}
	
	/**
	 * Returns the quantity of items to drop on block destruction.
	 */
	@Override
	public int quantityDropped(Random par1Random)
	{
		return 1;
	}
	
	@Override
	public int quantityDroppedWithBonus(int par1, Random par2Random)
	{
		if (par1 > 0 && this != Block.getBlockFromItem(this.getItemDropped(0, par2Random, par1)))
		{
			int var3 = par2Random.nextInt(par1 + 2) - 1;
			
			if (var3 < 0)
			{
				var3 = 0;
			}
			
			return this.quantityDropped(par2Random) * (var3 + 1);
		}
		else
		{
			return this.quantityDropped(par2Random);
		}
	}
	
	/**
	 * Determines the damage on the item the block drops. Used in cloth and
	 * wood.
	 */
	@Override
	public int damageDropped(int par1)
	{
		return 0;
	}
	
	// code to create fire particles
	@Override
	public void randomDisplayTick(World par1World, int par2, int par3, int par4, Random par5Random)
	{
		for (int var5 = 0; var5 < 3; ++var5)
		{
			float var7 = par2 + 0.5F;
			float var8 = par3 + 0.0F + par5Random.nextFloat() * 16.0F / 16.0F;
			float var9 = par4 + 0.5F;
			float var10 = 0.52F;
			float var11 = par5Random.nextFloat() * 0.6F - 0.3F;
			
			par1World.spawnParticle("smoke", var7 - var10, var8, var9 + var11, 0.0D, 0.0D, 0.0D);
			par1World.spawnParticle("flame", var7 - var10, var8, var9 + var11, 0.0D, 0.0D, 0.0D);
			par1World.spawnParticle("smoke", var7 + var10, var8, var9 + var11, 0.0D, 0.0D, 0.0D);
			par1World.spawnParticle("flame", var7 + var10, var8, var9 + var11, 0.0D, 0.0D, 0.0D);
			par1World.spawnParticle("smoke", var7 + var11, var8, var9 - var10, 0.0D, 0.0D, 0.0D);
			par1World.spawnParticle("flame", var7 + var11, var8, var9 - var10, 0.0D, 0.0D, 0.0D);
			par1World.spawnParticle("smoke", var7 + var11, var8, var9 + var10, 0.0D, 0.0D, 0.0D);
			par1World.spawnParticle("flame", var7 + var11, var8, var9 + var10, 0.0D, 0.0D, 0.0D);
		}
	}
	
	// code for Blaze-Summoning (Place blazium block over fire)
	@Override
	public void onBlockAdded(World par1World, int par2, int par3, int par4)
	{
		super.onBlockAdded(par1World, par2, par3, par4);
		
		if (par1World.getBlock(par2, par3 - 1, par4) == Blocks.fire)
		{
			if (!par1World.isRemote)
			{
				par1World.setBlock(par2, par3, par4, Blocks.air);
				par1World.setBlock(par2, par3 - 1, par4, Blocks.air);
				par1World.setBlock(par2, par3 - 2, par4, Blocks.air);
				EntityBlaze var9 = new EntityBlaze(par1World);
				var9.setLocationAndAngles(par2 + 0.5D, par3 - 1.95D, par4 + 0.5D, 0.0F, 0.0F);
				par1World.spawnEntityInWorld(var9);
				par1World.notifyBlockChange(par2, par3, par4, Blocks.air);
				par1World.notifyBlockChange(par2, par3 - 1, par4, Blocks.air);
				par1World.notifyBlockChange(par2, par3 - 2, par4, Blocks.air);
			}
			
			for (int var10 = 0; var10 < 120; ++var10)
			{
				par1World.spawnParticle("smoke", par2 + par1World.rand.nextDouble(), par3 - 2 + par1World.rand.nextDouble() * 2.5D, par4 + par1World.rand.nextDouble(), 0.0D, 0.0D, 0.0D);
			}
		}
	}
	
	@Override
	public boolean isBeaconBase(IBlockAccess worldObj, int x, int y, int z, int beaconX, int beaconY, int beaconZ)
	{
		return this == Blocks.emerald_block || this == Blocks.gold_block || this == Blocks.diamond_block || this == Blocks.iron_block || this == EOBlocks.BlaziumBlock;
	}
}