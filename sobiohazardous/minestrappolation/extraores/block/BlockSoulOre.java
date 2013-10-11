package sobiohazardous.minestrappolation.extraores.block;

import java.util.Random;

import sobiohazardous.minestrappolation.api.block.MBlock;
import sobiohazardous.minestrappolation.extraores.lib.EOBlockManager;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;

public class BlockSoulOre extends MBlock
{
    public BlockSoulOre(int par1)
    {
        super(par1, Material.sand);
        this.setCreativeTab(EOBlockManager.tabOresBlocks);
    }

    /**
     * Returns a bounding box from the pool of bounding boxes (this means this box can change after the pool has been
     * cleared to be reused)
     */
    public AxisAlignedBB getCollisionBoundingBoxFromPool(World par1World, int par2, int par3, int par4)
    {
        float f = 0.125F;
        return AxisAlignedBB.getAABBPool().getAABB((double)par2, (double)par3, (double)par4, (double)(par2 + 1), (double)((float)(par3 + 1) - f), (double)(par4 + 1));
    }
    
    public int quantityDropped(Random par1Random)
    {
        return 1 + par1Random.nextInt(2);
    }

    /**
     * Triggered whenever an entity collides with this block (enters into the block). Args: world, x, y, z, entity
     */
    public void onEntityCollidedWithBlock(World par1World, int par2, int par3, int par4, Entity par5Entity)
    {
        par5Entity.motionX *= 0.4D;
        par5Entity.motionZ *= 0.4D;
    }
    
    public int idDropped(int par1, Random par2Random, int par3)
    {
    	return EOBlockManager.SoulGem.itemID;
    }
}
