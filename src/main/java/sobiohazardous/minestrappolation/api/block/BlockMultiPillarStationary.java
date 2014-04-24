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

public class BlockMultiPillarStationary extends Block
{
	private IIcon[] sides;
	private IIcon[] top;

	private String[] sidesImg;
	private String[] topImg;
	
	public BlockMultiPillarStationary(Material mat, String[] sidesImgs, String[] topImgs)
    {
        super(Material.rock);
        this.sidesImg = sidesImgs;
        this.topImg = topImgs;
        this.setCreativeTab(Minestrappolation.creativeTabStone);
    }

    public void registerBlockIcons(IIconRegister par1IconRegister)
    {
        this.sides = new IIcon[sidesImg.length];
        this.top = new IIcon[topImg.length];

        for (int i = 0; i < this.sides.length; ++i)
        {
            this.sides[i] = par1IconRegister.registerIcon(sidesImg[i]);
        }
        
        for (int i = 0; i < this.top.length; ++i)
        {
            this.top[i] = par1IconRegister.registerIcon(topImg[i]);
        }
    }
    
    @SideOnly(Side.CLIENT)
    @Override
    public IIcon getIcon(int par1, int par2)
    {	
        int k = par2 & 96;
        return k == 0 && (par1 == 1 || par1 == 0) ? top[par2] : (k == 4 && (par1 == 5 || par1 == 4) ? top[par2] : (k == 8 && (par1 == 2 || par1 == 3) ? top[par2] : this.sides[par2]));
    }
     
    /**
     * The type of render function that is called for this block
     */
    public int getRenderType()
    {
        return 31;
    }
    
    /**
     * Determines the damage on the item the block drops. Used in cloth and wood.
     */
    public int damageDropped(int par1)
    {
        return par1;
    }

    @SideOnly(Side.CLIENT)

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
    
