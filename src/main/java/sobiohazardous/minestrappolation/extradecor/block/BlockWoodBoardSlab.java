package sobiohazardous.minestrappolation.extradecor.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import java.util.List;
import java.util.Random;

import sobiohazardous.minestrappolation.extradecor.ExtraDecor;
import sobiohazardous.minestrappolation.extradecor.lib.EDBlocks;
import net.minecraft.block.BlockSlab;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.common.util.ForgeDirection;

public class BlockWoodBoardSlab extends BlockSlab
{
    /** The type of tree this slab came from. */
    public static final String[] woodType = new String[] {"oak", "birch", "spruce", "jungle"};

    public BlockWoodBoardSlab(boolean par2)
    {
        super(par2, Material.wood);
        this.setCreativeTab(EDBlocks.tabDecorBlocks);
    }

    @SideOnly(Side.CLIENT)

    /**
     * From the specified side and block metadata retrieves the blocks texture. Args: side, metadata
     */
    public IIcon getIcon(int par1, int par2)
    {
        return EDBlocks.woodBoards.getIcon(par1, par2 & 7);
    }

    /**
     * Returns the slab block name with step type.
     */
    public String func_150002_b(int par1)
    {
        if (par1 < 0 || par1 >= woodType.length)
        {
            par1 = 0;
        }

        return super.getUnlocalizedName() + "." + woodType[par1];
    }

    @SideOnly(Side.CLIENT)

    /**
     * returns a list of blocks with the same ID, but different meta (eg: wood returns 4 blocks)
     */
    public void getSubBlocks(Item par1, CreativeTabs par2CreativeTabs, List par3List)
    {
        if (par1 != Item.getItemFromBlock(EDBlocks.woodBoardsDoubleSlab))
        {
            for (int j = 0; j < 4; ++j)
            {
                par3List.add(new ItemStack(par1, 1, j));
            }
        }
    }

    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister par1IconRegister) {}
    
    public int getFlammability(IBlockAccess world, int x, int y, int z,ForgeDirection face)
    {
    	if(world.getBlock(x, y, z) == EDBlocks.woodBoardsSingleSlab || world.getBlock(x, y, z) == EDBlocks.woodBoardsDoubleSlab)
    	{
    		if(face == ForgeDirection.UP || face == ForgeDirection.DOWN || face == ForgeDirection.NORTH || face == ForgeDirection.SOUTH || face == ForgeDirection.EAST || face == ForgeDirection.WEST)
    		{
                return 75;
    		}
    		else
    			return 0;
    	}
    	else
    		return 0;
    }
}
