package sobiohazardous.minestrappolation.extraores.block;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.world.World;
import sobiohazardous.minestrappolation.api.block.MBlock;
import sobiohazardous.minestrappolation.extraores.lib.EOBlockManager;
import sobiohazardous.minestrappolation.extraores.lib.EOItemManager;

public class EOBlock extends MBlock
{
	public EOBlock(int par1, Material par3Material)
    {
        super(par1, par3Material);
        this.setCreativeTab(CreativeTabs.tabBlock);
    }

    /**
     * Returns the ID of the items to drop on destruction.
     */
    public int idDropped(int par1, Random par2Random, int par3)
    {
        return this.blockID == EOBlockManager.RadiantQuartzOre.blockID ? EOBlockManager.RadiantQuartz.itemID : this.blockID == EOBlockManager.BlaziumOre.blockID ? Item.blazePowder.itemID : (this.blockID == EOBlockManager.SunstoneOre.blockID ? EOItemManager.SunstoneDust.itemID : (this.blockID == EOBlockManager.SoulOre.blockID ? EOBlockManager.SoulGem.itemID : (this.blockID == EOBlockManager.PlutoniumOre.blockID ? EOItemManager.Plutonium.itemID : (this.blockID == EOBlockManager.UraniumOre.blockID ? EOItemManager.Uranium.itemID : (this.blockID == EOBlockManager.Quartzite.blockID ? EOItemManager.PinkQuartz.itemID : this.blockID == EOBlockManager.meuroditeOre.blockID ? EOItemManager.meuroditeIngot.itemID : this.blockID)))));
    }

    /**
     * Returns the quantity of items to drop on block destruction.
     */
    public int quantityDropped(Random par1Random)
    {
    	return this.blockID == EOBlockManager.RadiantQuartzOre.blockID ? 1 : this.blockID == EOBlockManager.BlaziumOre.blockID ? 1 + par1Random.nextInt(3) : (this.blockID == EOBlockManager.SunstoneOre.blockID ? 2 + par1Random.nextInt(4) : (this.blockID == EOBlockManager.SoulOre.blockID ? 2 + par1Random.nextInt(3) : (this.blockID == EOBlockManager.PlutoniumOre.blockID ? 1 + par1Random.nextInt(2) : (this.blockID == EOBlockManager.UraniumOre.blockID ? 1 + par1Random.nextInt(2) : (this.blockID == EOBlockManager.Quartzite.blockID ? 2 + par1Random.nextInt(3) : 1)))));
    }

    public int quantityDroppedWithBonus(int par1, Random par2Random)
    {
        if (par1 > 0 && this.blockID != this.idDropped(0, par2Random, par1))
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
     * Determines the damage on the item the block drops. Used in cloth and wood.
     */
    public int damageDropped(int par1)
    {
        return 0;
    }
    //code for Soul Ore slow effect
    public void onEntityCollidedWithBlock(World par1World, int par2, int par3, int par4, Entity par5Entity)
    {
        if(blockID == EOBlockManager.SoulOre.blockID)
        {
        	par5Entity.motionX *= 0.4D;
            par5Entity.motionZ *= 0.4D;
        }
        else
        {
        	par5Entity.motionX *= 1D;
        	par5Entity.motionZ *= 1D;
        }
    }
    //Makes Extra Ores Bedrock and Invincium impervious to the Ender Dragon.
    public boolean canDragonDestroy(World world, int x, int y, int z)
    {
        return blockID != obsidian.blockID && blockID != whiteStone.blockID && blockID != bedrock.blockID;
    }
    //Allows for "Ingot Blocks" to be used in Beacon base.
    public boolean isBeaconBase(World worldObj, int x, int y, int z, int beaconX, int beaconY, int beaconZ)
    {
        return (blockID == blockEmerald.blockID || blockID == blockGold.blockID || blockID == blockDiamond.blockID || blockID == EOBlockManager.SteelBlock.blockID || blockID == EOBlockManager.BronzeBlock.blockID || blockID == EOBlockManager.meuroditeBlock.blockID || blockID == EOBlockManager.ToriteBlock.blockID || blockID == EOBlockManager.SteelBlock.blockID || blockID == EOBlockManager.TitaniumBlock.blockID || blockID == EOBlockManager.BlaziumBlock.blockID);
    }
    //code for Soul Ore's "sink" effect.
    
    /*
    public AxisAlignedBB getCollisionBoundingBoxFromPool(World par1World, int par2, int par3, int par4)
    {
        if (blockID == 216)
        {
        	float var5 = 0.125F;
        	return AxisAlignedBB.getAABBPool().addOrModifyAABBInPool((double)par2, (double)par3, (double)par4, (double)(par2 + 1), (double)((float)(par3 + 1) - var5), (double)(par4 + 1));
        }
        else
        {
        	float var5 = 0F;
        	return AxisAlignedBB.getAABBPool().addOrModifyAABBInPool((double)par2, (double)par3, (double)par4, (double)(par2 + 1), (double)((float)(par3 + 1) - var5), (double)(par4 + 1));
        }
    }
    
    */
    
}
