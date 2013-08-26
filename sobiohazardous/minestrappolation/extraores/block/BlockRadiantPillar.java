package sobiohazardous.minestrappolation.extraores.block;

import java.util.Random;

import sobiohazardous.minestrappolation.extraores.ExtraOres;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.src.*;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.Icon;
import net.minecraft.world.World;

public class BlockRadiantPillar extends Block
{
	private Icon top;
	public BlockRadiantPillar(int par1)
    {
        super(par1, Material.rock);
        this.setCreativeTab(CreativeTabs.tabBlock);
    }

	public void registerIcons(IconRegister iconRegister)
	{
	         blockIcon = iconRegister.registerIcon("Minestrappolation:block_PillarRadiantQuartz");
	         this.top = iconRegister.registerIcon("Minestrappolation:block_SmoothRadiantQuartz");    
	}

    /**
     * Returns the ID of the items to drop on destruction.
     */
    public int idDropped(int par1, Random par2Random, int par3)
    {
        return this.blockID == ExtraOres.BlaziumOre.blockID ? Item.blazePowder.itemID : (this.blockID == ExtraOres.SunstoneOre.blockID ? ExtraOres.SunstoneDust.itemID : (this.blockID == ExtraOres.SoulOre.blockID ? ExtraOres.SoulGem.itemID : (this.blockID == ExtraOres.PlutoniumOre.blockID ? ExtraOres.Plutonium.itemID : (this.blockID == ExtraOres.UraniumOre.blockID ? ExtraOres.Uranium.itemID : this.blockID))));
    }

    /**
     * Returns the quantity of items to drop on block destruction.
     */
    public int quantityDropped(Random par1Random)
    {
    	return this.blockID == ExtraOres.BlaziumOre.blockID ? 2 + par1Random.nextInt(3) : (this.blockID == ExtraOres.SunstoneOre.blockID ? 2 + par1Random.nextInt(4) : (this.blockID == ExtraOres.SoulOre.blockID ? 2 + par1Random.nextInt(3) : (this.blockID == ExtraOres.PlutoniumOre.blockID ? 1 + par1Random.nextInt(2) : (this.blockID == ExtraOres.UraniumOre.blockID ? 1 + par1Random.nextInt(2) : 1))));
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
    
    
    /**
     * From the specified side and block metadata retrieves the blocks texture. Args: side, metadata
     */
    public Icon getIcon(int par1, int par2)
    {
        int k = par2 & 12;
        int l = par2 & 3;
        return k == 0 && (par1 == 1 || par1 == 0) ? top : (k == 4 && (par1 == 5 || par1 == 4) ? top : (k == 8 && (par1 == 2 || par1 == 3) ? top : this.blockIcon));
    }
    
    /**
     * Called when a block is placed using its ItemBlock. Args: World, X, Y, Z, side, hitX, hitY, hitZ, block metadata
     */
    public int onBlockPlaced(World par1World, int par2, int par3, int par4, int par5, float par6, float par7, float par8, int par9)
    {
        int j1 = par9 & 3;
        byte b0 = 0;

        switch (par5)
        {
            case 0:
            case 1:
                b0 = 0;
                break;
            case 2:
            case 3:
                b0 = 8;
                break;
            case 4:
            case 5:
                b0 = 4;
        }

        return j1 | b0;
    }
    
    /**
     * The type of render function that is called for this block
     */
    public int getRenderType()
    {
        return 31;
    }
}
    
