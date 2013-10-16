package sobiohazardous.minestrappolation.extraores.block;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import sobiohazardous.minestrappolation.extraores.lib.EOBlockManager;
import sobiohazardous.minestrappolation.extraores.lib.EOItemManager;

public class BlockSunstoneOre extends Block
{
	Random rand = new Random();
    public BlockSunstoneOre(int par1)
    {
        super(par1, Material.rock);
        this.setCreativeTab(EOBlockManager.tabOresBlocks);
    }
    
    public void registerIcons(IconRegister iconRegister)
    {
             blockIcon = iconRegister.registerIcon("Minestrappolation:block_SunstoneOre");
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
    public int idDropped(int par1, Random par2Random, int par3)
    {
        return EOItemManager.SunstoneDust.itemID;
    }
    
    public void onBlockDestroyedByPlayer(World par1World, int par2, int par3, int par4, int par5) 
    {
     this.dropXpOnBlockBreak(par1World, par2, par3, par4, rand.nextInt(5)+3); /* the 1 means it drops 1 xp, change it to 20, 100, as much as you want.*/
    }
}
