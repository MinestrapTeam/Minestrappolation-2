package sobiohazardous.minestrappolation.extraores.block;

import java.util.List;
import java.util.Random;

import sobiohazardous.minestrappolation.extraores.ExtraOres;

import net.minecraft.block.Block;
import net.minecraft.block.BlockHalfSlab;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLiving;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class PinkQuartzSlab extends BlockHalfSlab
{
	public static final String[] woodType = { "pinkquartz" };

	public PinkQuartzSlab(int par1, boolean par2)
	{
		super(par1, par2, Material.rock);
		setBurnProperties(this.blockID, 5, 20);
		useNeighborBrightness[this.blockID] = true;
	}

	public void registerIcons(IconRegister par1IconRegister)
	{
		this.blockIcon = par1IconRegister.registerIcon("extraores:block_PinkQuartzSmooth");
	}

	public int idDropped(int par1, Random par2Random, int par3)
	{
		return ExtraOres.PinkQuartzSingleSlab.blockID;
	}

	public void onBlockPlacedBy(World par1World, int par2, int par3, int par4, EntityLiving par5EntityLiving)
	{
		if(par1World.getBlockId(par2, par3 - 1, par4) == ExtraOres.PinkQuartzSingleSlab.blockID)
		{
			par1World.setBlock(par2, par3, par4, 0);
			par1World.setBlock(par2, par3 - 1, par4, ExtraOres.PinkQuartzDoubleSlab.blockID);
		}
		if(par1World.getBlockId(par2, par3 + 1, par4) == ExtraOres.PinkQuartzSingleSlab.blockID)
		{
			par1World.setBlock(par2, par3, par4, 0);
			par1World.setBlock(par2, par3 + 1, par4, ExtraOres.PinkQuartzDoubleSlab.blockID);
		}
	}

	protected ItemStack createStackedBlock(int par1)
	{
		return new ItemStack(ExtraOres.PinkQuartzSingleSlab.blockID, 2, par1 & 7);
	}

	public String getFullSlabName(int par1)
	{
         if ((par1 < 0) || (par1 >= woodType.length))
         {
         par1 = 0;
         }

         return super.getUnlocalizedName() + "." + woodType[par1];
	}

	public void getSubBlocks(int par1, CreativeTabs par2CreativeTabs, List par3List)
	{
         if (par1 != ExtraOres.PinkQuartzDoubleSlab.blockID)
         {
         par3List.add(new ItemStack(par1, 1, 0));
         }
	}
	
	 private static boolean isBlockSingleSlab(int par0)
	    {
	        return par0 == ExtraOres.PinkQuartzSingleSlab.blockID;
	    }
	 
	 public int idPicked(World par1World, int par2, int par3, int par4)
	    {
		 	return ExtraOres.PinkQuartzSingleSlab.blockID;
	    }

}