package sobiohazardous.minestrappolation.extradecor.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import java.util.List;

import sobiohazardous.minestrappolation.extradecor.ExtraDecor;
import net.minecraft.block.Block;
import net.minecraft.block.BlockLadder;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockRopeCoil extends BlockLadder
{
	private IIcon top;
    public BlockRopeCoil()
    {
        super();
        this.setBlockBounds(1F, 1F, 1F, 1F, 1F, 1F);
    }
    
    @SideOnly(Side.CLIENT)

    /**
     * When this method is called, your block should register all the icons it needs with the given IconRegister. This
     * is the only chance you get to register icons.
     */
    public void registerIcons(IIconRegister par1IconRegister)
    {
        this.blockIcon = par1IconRegister.registerIcon("Minestrappolation:block_RopeCoilSide");
        this.top = par1IconRegister.registerIcon("Minestrappolation:block_RopeCoilTop");
    }
    
    public IIcon getIcon(int i, int j)
    {
    	if (i == 0)//bottom
            
            return top;
    	if (i == 1)//top
           
            return top;
   
    	if (i == 2) // side
           
            return blockIcon;
    	if (i == 3)//side 
           
            return blockIcon;
    	if (i == 4) //side
   
    		return blockIcon;
    	if (i == 5) //side
   
    		return blockIcon;

    	if (j ==1)
    	{
    		return blockIcon;
    	}
		return blockIcon;
    }
    
    public boolean renderAsNormalBlock()
    {
        return true;
    }

    
    public int getRenderType()
    {
        return 0;
    }
    
    
    public boolean shouldSideBeRendered(IBlockAccess par1IBlockAccess, int par2, int par3, int par4, int par5)
    {
        return true;
    }
}
