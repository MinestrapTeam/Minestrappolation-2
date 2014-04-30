package sobiohazardous.minestrappolation.extraores.block;

import java.util.Random;

import sobiohazardous.minestrappolation.api.util.MAssetManager;
import sobiohazardous.minestrappolation.extraores.ExtraOres;


import sobiohazardous.minestrappolation.extraores.lib.EOBlockManager;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.src.*;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class BlockBlaziumOre extends Block
{
    public BlockBlaziumOre()
    {
        super(Material.rock);
        this.setCreativeTab(EOBlockManager.tabOresBlocks);
    }
    
    public void registerBlockIcons(IIconRegister iconRegister)
    {
    	blockIcon = iconRegister.registerIcon(MAssetManager.getEOTexture("oreBlazium"));
    }

    /**
     * Returns the usual quantity dropped by the block plus a bonus of 1 to 'i' (inclusive).
     */
    public int quantityDroppedWithBonus(int par1, Random par2Random)
    {
        return MathHelper.clamp_int(this.quantityDropped(par2Random) + par2Random.nextInt(par1 + 1), 1, 4);
    }

    /**
     * Returns the quantity of items to drop on block destruction.
     */
    public int quantityDropped(Random par1Random)
    {
        return 2 + par1Random.nextInt(1);
    }

    public Item getItemDropped(int par1, Random par2Random, int par3)
    {
        return Items.blaze_powder;
    }
    
    public void onBlockDestroyedByPlayer(World par1World, int par2, int par3, int par4, int par5) 
    {
    	this.dropXpOnBlockBreak(par1World, par2, par3, par4, 1); /* the 1 means it drops 1 xp, change it to 20, 100, as much as you want.*/
    }
}
