package sobiohazardous.minestrappolation.api.block;

import java.util.List;
import java.util.Random;

import sobiohazardous.minestrappolation.api.Minestrappolation;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.src.*;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

public class BlockMultiRoad extends Block
{
	private IIcon[] sides;
	private IIcon[] top;
	private IIcon[] bottom;

	private String[] sidesImg;
	private String[] topImg;	
	private String[] bottomImg;

	public BlockMultiRoad(Material mat, String[] sidesImgs, String[] topImgs, String[] bottomImgs)
    {
        super(Material.rock);
        this.sidesImg = sidesImgs;
        this.topImg = topImgs;
        this.bottomImg = bottomImgs;
        this.setCreativeTab(Minestrappolation.creativeTabStone);
    }

    public void registerBlockIcons(IIconRegister par1IconRegister)
    {
        this.sides = new IIcon[sidesImg.length];
        this.top = new IIcon[topImg.length];
        this.bottom = new IIcon[bottomImg.length];
        
        for (int i = 0; i < this.sides.length; ++i)
        {
            this.sides[i] = par1IconRegister.registerIcon(sidesImg[i]);
        }
        
        for (int i = 0; i < this.top.length; ++i)
        {
            this.top[i] = par1IconRegister.registerIcon(topImg[i]);
        }
        
        for (int i = 0; i < this.bottom.length; ++i)
        {
            this.bottom[i] = par1IconRegister.registerIcon(bottomImg[i]);
        }
    }
    
    public IIcon getIcon(int side, int meta)
    {
        if (side != 1 && (side != 0 || meta != 1 && meta != 2))
        {
            if (side == 0)
            {
            	//bottom
                return this.bottom[meta];
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
     * returns a list of blocks with the same ID, but different meta (eg: wood returns 4 blocks)
     */
    public void getSubBlocks(Item par1, CreativeTabs par2CreativeTabs, List par3List)
    {
    	for(int i=0; i < top.length; i++)
    	{
        	par3List.add(new ItemStack(par1, 1, i));
    	}
    }
}
    
