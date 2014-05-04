package sobiohazardous.mods.minestrappolation.core.block;

import java.util.List;
import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.BlockSlab;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

public class MBlockMultiSlab extends BlockSlab
{ 
    private IIcon[] sides;
    private IIcon[] top;
    
    private String[] sideImgs;
    private String[] topImgs;

    public MBlockMultiSlab(boolean isDouble, String[] sideTextures, String[] topTextures)
    {
        super(isDouble, Material.rock);
        this.sideImgs = sideTextures;
        this.topImgs = topTextures;
    }
    
    public IIcon getIcon(int side, int meta)
    {
        int var3 = meta & 12;
        int var4 = meta & 3;
        if(this.field_150004_a)
        {
            return var3 == 0 && (side == 1 || side == 0) ? this.top[var4] : this.sides[var4];
        }
        return var3 == 0 && (side == 1 || side == 0) ? this.top[var4] : (var3 == 4 && (side == 5 || side == 4) ? this.sides[var4] : (var3 == 8 && (side == 2 || side == 3) ? this.sides[var4] : this.top[var4]));
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

    public Item getItemDropped(int p_149650_1_, Random p_149650_2_, int p_149650_3_)
    {
    	//TODO this should be a single slab somehow.
        return Item.getItemFromBlock(this);
    }

    /**
     * Returns an item stack containing a single instance of the current block type. 'i' is the block's subtype/damage
     * and is ignored for blocks which do not support subtypes. Blocks which cannot be harvested should return null.
     */
    protected ItemStack createStackedBlock(int meta)
    {
    	//TODO This should be the single slab somehow.
        return new ItemStack(this, 2, meta);
    }

    public String func_150002_b(int meta)
    {
        if (meta < 0 || meta >= topImgs.length)
        {
        	meta = 0;
        }

        return super.getUnlocalizedName() + "." + meta;
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
