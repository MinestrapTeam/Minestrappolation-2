package sobiohazardous.mods.minestrappolation.extraores.block;

import java.util.Random;

import sobiohazardous.mods.minestrappolation.core.util.MAssetManager;
import sobiohazardous.mods.minestrappolation.extraores.ExtraOres;
import sobiohazardous.mods.minestrappolation.extraores.lib.EOItems;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.src.*;
import net.minecraft.util.MathHelper;

public class BlockSunstone extends Block
{
    public BlockSunstone( Material par3Material)
    {
        super(par3Material);
        this.setCreativeTab(CreativeTabs.tabBlock);
    }
    
    public void registerBlockIcons(IIconRegister iconRegister)
    {
    	blockIcon = iconRegister.registerIcon(MAssetManager.getEOTexture("blockSunstone"));
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
        return 2 + par1Random.nextInt(3);
    }

    /**
     * Returns the ID of the items to drop on destruction.
     */
    public Item getItemDropped(int par1, Random par2Random, int par3)
    {
        return EOItems.SunstoneDust;
    }
}
