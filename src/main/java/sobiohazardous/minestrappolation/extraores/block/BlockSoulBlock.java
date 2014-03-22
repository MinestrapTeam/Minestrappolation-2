package sobiohazardous.minestrappolation.extraores.block;

import java.util.Random;

import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import sobiohazardous.minestrappolation.api.block.MBlock;
import sobiohazardous.minestrappolation.extraores.lib.EOBlockManager;

public class BlockSoulBlock extends MBlock
{
	Random rand = new Random();

	public BlockSoulBlock() 
	{
		super(Material.iron);
		this.setCreativeTab(EOBlockManager.tabOresBlocks);
	}

	/**
     * A randomly called display update to be able to add particles or other items for display
     */
    public void randomDisplayTick(World p_149734_1_, int p_149734_2_, int p_149734_3_, int p_149734_4_, Random p_149734_5_)
    {
        for (int var6 = 0; var6 < 3; ++var6)
        {
            double var10000 = (double)((float)p_149734_2_ + p_149734_5_.nextFloat());
            double var9 = (double)((float)p_149734_3_ + p_149734_5_.nextFloat());
            var10000 = (double)((float)p_149734_4_ + p_149734_5_.nextFloat());
            double var13 = 0.0D;
            double var15 = 0.0D;
            double var17 = 0.0D;
            int var19 = p_149734_5_.nextInt(2) * 2 - 1;
            int var20 = p_149734_5_.nextInt(2) * 2 - 1;
            var13 = ((double)p_149734_5_.nextFloat() - 0.5D) * 0.125D;
            var15 = ((double)p_149734_5_.nextFloat() - 0.5D) * 0.125D;
            var17 = ((double)p_149734_5_.nextFloat() - 0.5D) * 0.125D;
            double var11 = (double)p_149734_4_ + 0.5D + 0.25D * (double)var20;
            var17 = (double)(p_149734_5_.nextFloat() * 1.0F * (float)var20);
            double var7 = (double)p_149734_2_ + 0.5D + 0.25D * (double)var19;
            var13 = (double)(p_149734_5_.nextFloat() * 1.0F * (float)var19);
            p_149734_1_.spawnParticle("portal", var7, var9, var11, var13, var15, var17);
        }
    }

    
    public int quantityDropped(Random par1Random)
    {
    	return 1 + par1Random.nextInt(4);
    }
    
    public Item getItemDropped(int par1, Random par2Random, int par3)
    {
    	return EOBlockManager.SoulGem;
    }
    
    public void dropBlockAsItemWithChance(World par1World, int par2, int par3, int par4, int par5, float par6, int par7)
    {
    	super.dropBlockAsItemWithChance(par1World, par2, par3, par4, par5, par6, par7);
        int j1 = MathHelper.getRandomIntegerInRange(par1World.rand, 140, 220);
        this.dropXpOnBlockBreak(par1World, par2, par3, par4, j1);
    }
    
}
