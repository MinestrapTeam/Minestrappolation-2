package sobiohazardous.mods.minestrappolation.extraores.block;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.world.World;
import sobiohazardous.mods.minestrappolation.core.block.MBlock;
import sobiohazardous.mods.minestrappolation.extraores.lib.EOBlocks;
import sobiohazardous.mods.minestrappolation.extraores.lib.EOItems;

public class EOBlock extends MBlock
{
	public EOBlock(Material par3Material)
    {
        super(par3Material);
        this.setCreativeTab(CreativeTabs.tabBlock);
    }

    /**
     * Returns the ID of the items to drop on destruction.
     */
    public Item getItemDropped(int par1, Random par2Random, int par3)
    {
        return this == EOBlocks.RadiantQuartzOre ? EOBlocks.RadiantQuartz : this == EOBlocks.BlaziumOre ? Items.blaze_powder : (this == EOBlocks.SunstoneOre ? EOItems.SunstoneDust : (this == EOBlocks.SoulOre ? EOBlocks.SoulGem : (this == EOBlocks.PlutoniumOre ? EOItems.Plutonium : (this == EOBlocks.UraniumOre ? EOItems.Uranium : (this == EOBlocks.Quartzite ? EOItems.PinkQuartz : this == EOBlocks.meuroditeOre ? EOItems.meuroditeIngot : Item.getItemFromBlock(this))))));
    }

    /**
     * Returns the quantity of items to drop on block destruction.
     */
    public int quantityDropped(Random par1Random)
    {
    	return this == EOBlocks.RadiantQuartzOre ? 1 : this == EOBlocks.BlaziumOre ? 1 + par1Random.nextInt(3) : (this == EOBlocks.SunstoneOre ? 2 + par1Random.nextInt(4) : (this == EOBlocks.SoulOre ? 2 + par1Random.nextInt(3) : (this == EOBlocks.PlutoniumOre ? 1 + par1Random.nextInt(2) : (this == EOBlocks.UraniumOre ? 1 + par1Random.nextInt(2) : (this == EOBlocks.Quartzite ? 2 + par1Random.nextInt(3) : 1)))));
    }

    public int quantityDroppedWithBonus(int par1, Random par2Random)
    {
        if (par1 > 0 && Item.getItemFromBlock(this) != this.getItemDropped(0, par2Random, par1))
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
        if(this == EOBlocks.SoulOre)
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
    
    //TODO: READ BELOW
    /* **METHODS DON'T EXIST. PLEASE FIND ALTERNATIVE!
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
    Random rand = new Random();
    public void onBlockDestroyedByPlayer(World par1World, int par2, int par3, int par4, int par5) 
    {
    	if(this == EOBlocks.Quartzite)
    	{
    		this.dropXpOnBlockBreak(par1World, par2, par3, par4, 1); /* the 1 means it drops 1 xp, change it to 20, 100, as much as you want.*/
    	}
    	if(this == EOBlocks.RadiantQuartzOre)
    	{
    		this.dropXpOnBlockBreak(par1World, par2, par3, par4, rand.nextInt(9)+4); /* the 1 means it drops 1 xp, change it to 20, 100, as much as you want.*/
    	}
    	if(this == EOBlocks.meuroditeOre)
    	{
    		this.dropXpOnBlockBreak(par1World, par2, par3, par4, rand.nextInt(5)+2); /* the 1 means it drops 1 xp, change it to 20, 100, as much as you want.*/
    	}
    	if(this == EOBlocks.SoulOre)
    	{
    		this.dropXpOnBlockBreak(par1World, par2, par3, par4, rand.nextInt(10)+6); /* the 1 means it drops 1 xp, change it to 20, 100, as much as you want.*/
    	}
     
    }
    
}
