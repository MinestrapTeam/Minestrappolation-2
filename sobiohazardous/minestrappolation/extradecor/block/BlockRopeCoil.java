package sobiohazardous.minestrappolation.extradecor.block;

import static net.minecraftforge.common.ForgeDirection.EAST;
import static net.minecraftforge.common.ForgeDirection.NORTH;
import static net.minecraftforge.common.ForgeDirection.SOUTH;
import static net.minecraftforge.common.ForgeDirection.WEST;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import java.util.List;

import sobiohazardous.minestrappolation.extradecor.ExtraDecor;
import net.minecraft.block.Block;
import net.minecraft.block.BlockLadder;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.Icon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;

public class BlockRopeCoil extends Block
{
	private Icon top;
    public BlockRopeCoil(int par1)
    {
        super(par1, Material.circuits);
    }
    
    @SideOnly(Side.CLIENT)

    /**
     * When this method is called, your block should register all the icons it needs with the given IconRegister. This
     * is the only chance you get to register icons.
     */
    public void registerIcons(IconRegister par1IconRegister)
    {
        this.blockIcon = par1IconRegister.registerIcon("Minestrappolation:block_RopeCoilSide");
        this.top = par1IconRegister.registerIcon("Minestrappolation:block_RopeCoilTop");
    }
    
    public Icon getIcon(int i, int j)
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
    
    public boolean canPlaceBlockAt(World par1World, int par2, int par3, int par4)
    {
    	if(par1World.isBlockSolidOnSide(par2, par3, par4, ForgeDirection.DOWN)){
    		return true;
    	}
		return false;
       
    }
    
    
    public int getRenderType()
    {
        return 0;
    }
    
    @Override
    public boolean isLadder(World world, int x, int y, int z, EntityLivingBase entity)
    {
        return true;
    }
    
    public boolean shouldSideBeRendered(IBlockAccess par1IBlockAccess, int par2, int par3, int par4, int par5)
    {
        return true;
    }
}
