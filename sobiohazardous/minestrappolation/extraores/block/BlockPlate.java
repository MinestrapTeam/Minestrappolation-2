package sobiohazardous.minestrappolation.extraores.block;

import java.util.Random;

import sobiohazardous.minestrappolation.extraores.ExtraOres;


import sobiohazardous.minestrappolation.extraores.lib.EOBlockManager;
import sobiohazardous.minestrappolation.extraores.lib.EOItemManager;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.Item;
import net.minecraft.src.*;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockPlate extends Block
{
	 
	protected static BlockPlate plate;
	public String texture;
	public BlockPlate(int par1, String Filetexture)
	    {
	        super(par1, Material.circuits);
	        this.texture = "Minestrappolation:" + Filetexture;
	        setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.125F, 1.0F);
	    }
    
	public void registerIcons(IconRegister par1IconRegister)
	{
	         this.blockIcon = par1IconRegister.registerIcon(texture);
	}
	 
	 public static final boolean isRailBlockAt(World par0World, int par1, int par2, int par3)
	    {
	        int i = par0World.getBlockId(par1, par2, par3);
	        return i == EOBlockManager.TinPlate.blockID || i == EOBlockManager.BronzePlate.blockID || i == EOBlockManager.SteelPlate.blockID;
	        //Done. Simple as one OR statement! You're welcome. :)
	    }
	 
	 
	 public AxisAlignedBB getCollisionBoundingBoxFromPool(World par1World, int par2, int par3, int i)
	    {
	        return null;
	    }
	 
	public boolean isOpaqueCube()
    {
        return false;
    }
  
    /**
     * If this block doesn't render as an ordinary block it will return False (examples: signs, buttons, stairs, etc)
     */
    public boolean renderAsNormalBlock()
    {
        return false;
    }
    
    public MovingObjectPosition collisionRayTrace(World par1World, int par2, int par3, int par4, Vec3 par5Vec3, Vec3 par6Vec3)
    {
        this.setBlockBoundsBasedOnState(par1World, par2, par3, par4);
        return super.collisionRayTrace(par1World, par2, par3, par4, par5Vec3, par6Vec3);
    }
    
    public void setBlockBoundsBasedOnState(IBlockAccess par1IBlockAccess, int par2, int par3, int par4)
    {
        int i = par1IBlockAccess.getBlockMetadata(par2, par3, par4);

        if (i >= 2 && i <= 5)
        {
            setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.625F, 1.0F);
        }
        else
        {
            setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.125F, 1.0F);
        }
    }
    
    public int getRenderType()
    {
        return ExtraOres.plateRenderId;
    }
    
    public boolean canPlaceBlockAt(World par1World, int par2, int par3, int par4)
    {
    	return par1World.doesBlockHaveSolidTopSurface(par2, par3 - 1, par4);
    }
    
    public void onBlockAdded(World par1World, int par2, int par3, int par4)
    {
        if (!par1World.isRemote)
        {
            refreshTrackShape(par1World, par2, par3, par4, true);
        }
    }
    
    public void onNeighborBlockChange(World par1World, int par2, int par3, int par4, int par5)
    {
    	if (!par1World.isRemote)
        {
            int i1 = par1World.getBlockMetadata(par2, par3, par4);
            int j1 = i1;

            boolean flag = false;

            if (!par1World.doesBlockHaveSolidTopSurface(par2, par3 - 1, par4))
            {
                flag = true;
            }

            if (j1 == 2 && !par1World.doesBlockHaveSolidTopSurface(par2 + 1, par3, par4))
            {
                flag = true;
            }

            if (j1 == 3 && !par1World.doesBlockHaveSolidTopSurface(par2 - 1, par3, par4))
            {
                flag = true;
            }

            if (j1 == 4 && !par1World.doesBlockHaveSolidTopSurface(par2, par3, par4 - 1))
            {
                flag = true;
            }

            if (j1 == 5 && !par1World.doesBlockHaveSolidTopSurface(par2, par3, par4 + 1))
            {
                flag = true;
            }

            if (flag)
        	{
            	dropBlockAsItem(par1World, par2, par3, par4, par1World.getBlockMetadata(par2, par3, par4), 0);
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
        	(new BlockPlateLogic(this, par1World, par2, par3, par4)).refreshTrackShape(par1World.isBlockIndirectlyGettingPowered(par2, par3, par4), par5);
        	return;
        }
    }
    
    public int idDropped(int par1, Random par2Random, int par3)
    {
        return this.blockID == EOBlockManager.TinPlate.blockID ? EOItemManager.TinPlateItem.itemID : (this.blockID == EOBlockManager.BronzePlate.blockID ? EOItemManager.BronzePlateItem.itemID : (this.blockID == EOBlockManager.SteelPlate.blockID ? EOItemManager.SteelPlateItem.itemID : this.blockID));
    }
    
    public int quantityDropped(Random par1Random)
    {
    	return  1;
    }
}
