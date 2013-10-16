package sobiohazardous.minestrappolation.extraores.block;

import java.util.Random;

import net.minecraft.block.material.Material;
import net.minecraft.world.World;
import sobiohazardous.minestrappolation.api.block.MBlock;
import sobiohazardous.minestrappolation.extraores.lib.EOBlockManager;

public class BlockSoulBlock extends MBlock
{
	Random rand = new Random();

	public BlockSoulBlock(int par1) 
	{
		super(par1, Material.iron);
		this.setCreativeTab(EOBlockManager.tabOresBlocks);
	}

	/**
     * A randomly called display update to be able to add particles or other items for display
     */
    public void randomDisplayTick(World par1World, int par2, int par3, int par4, Random par5Random)
    {
        if (par5Random.nextInt(100) == 0)
        {
            par1World.playSound((double)par2 + 0.5D, (double)par3 + 0.5D, (double)par4 + 0.5D, "portal.portal", 0.5F, par5Random.nextFloat() * 0.4F + 0.8F, false);
        }

        for (int l = 0; l < 4; ++l)
        {
            double d0 = (double)((float)par2 + par5Random.nextFloat());
            double d1 = (double)((float)par3 + par5Random.nextFloat());
            double d2 = (double)((float)par4 + par5Random.nextFloat());
            double d3 = 0.0D;
            double d4 = 0.0D;
            double d5 = 0.0D;
            int i1 = par5Random.nextInt(2) * 2 - 1;
            d3 = ((double)par5Random.nextFloat() - 0.5D) * 0.5D;
            d4 = ((double)par5Random.nextFloat() - 0.5D) * 0.5D;
            d5 = ((double)par5Random.nextFloat() - 0.5D) * 0.5D;

            if (par1World.getBlockId(par2 - 1, par3, par4) != this.blockID && par1World.getBlockId(par2 + 1, par3, par4) != this.blockID)
            {
                d0 = (double)par2 + 0.5D + 0.25D * (double)i1;
                d3 = (double)(par5Random.nextFloat() * 2.0F * (float)i1);
            }
            else
            {
                d2 = (double)par4 + 0.5D + 0.25D * (double)i1;
                d5 = (double)(par5Random.nextFloat() * 2.0F * (float)i1);
            }

            par1World.spawnParticle("portal", d0, d1, d2, d3, d4, d5);
        }
    }
    
    public int quantityDropped(Random par1Random)
    {
    	return 1 + par1Random.nextInt(4);
    }
    
    public int idDropped(int par1, Random par2Random, int par3)
    {
    	return EOBlockManager.SoulGem.itemID;
    }
    
}
