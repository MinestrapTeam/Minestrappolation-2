package sobiohazardous.mods.minestrappolation.core.block;

import java.util.List;

import sobiohazardous.mods.minestrappolation.core.Minestrappolation;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

public class MBlockMultiPillarStationary extends Block
{
    private IIcon[] sides;
    private IIcon[] top;
    
    private String[] sideImgs;
    private String[] topImgs;

    public MBlockMultiPillarStationary(Material mat, String[] tops, String[] bottoms)
    {
        super(mat);
        this.setCreativeTab(Minestrappolation.creativeTabStone);
        this.sideImgs = tops;
        this.topImgs = bottoms;
    }

    /**
     * Gets the block's texture. Args: side, meta
     */
    public IIcon getIcon(int side, int meta)
    {
        if (side != 1 && (side != 0 || meta != 1 && meta != 2))
        {
            if (side == 0)
            {
            	//bottom
                return this.top[meta];
            }
            else
            {
                if (meta < 0 || meta >= this.sides.length)
                {
                    meta = 0;
                }

                return this.sides[meta];
            }
        }
        else
        {
            return this.top[meta];
        }
    }

    /**
     * Determines the damage on the item the block drops. Used in cloth and wood.
     */
    public int damageDropped(int p_149692_1_)
    {
        return p_149692_1_;
    }

    /**
     * returns a list of blocks with the same ID, but different meta (eg: wood returns 4 blocks)
     */
    public void getSubBlocks(Item par1, CreativeTabs par2CreativeTabs, List par3List)
    {
    	for(int i=0; i < top.length; i++)
    	{
        	par3List.add(new ItemStack(par1, 1, i));
    	}
    }
    public void registerBlockIcons(IIconRegister par1IconRegister)
    {
        this.sides = new IIcon[sideImgs.length];
        this.top = new IIcon[topImgs.length];

        for (int i = 0; i < this.sides.length; ++i)
        {
            this.sides[i] = par1IconRegister.registerIcon(sideImgs[i]);
        }
        
        for (int i = 0; i < this.top.length; ++i)
        {
            this.top[i] = par1IconRegister.registerIcon(topImgs[i]);
        }
    }
}
