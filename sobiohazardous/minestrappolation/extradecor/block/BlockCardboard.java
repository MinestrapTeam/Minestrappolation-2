package sobiohazardous.minestrappolation.extradecor.block;

import java.util.Random;

import sobiohazardous.minestrappolation.api.util.MUtil;
import sobiohazardous.minestrappolation.extradecor.ExtraDecor;
import sobiohazardous.minestrappolation.extradecor.lib.EDBlockManager;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;

public class BlockCardboard extends EDBlock
{
	public BlockCardboard(int par1, Material material) 
	{
		super(par1, material);
	}

    /**
     * Lets the block know when one of its neighbor changes. Doesn't know which neighbor changed (coordinates passed are
     * their own) Args: x, y, z, neighbor blockID
     */
    public void onNeighborBlockChange(World par1World, int par2, int par3, int par4, int par5) 
    {
    	if(par5 == Block.waterMoving.blockID || par5 == Block.waterStill.blockID)
    	{
            par1World.setBlock(par2, par3, par4, EDBlockManager.cardboardWet.blockID);
    	}
    }

    /**
     * Called whenever the block is added into the world. Args: world, x, y, z
     */
    public void onBlockAdded(World par1World, int par2, int par3, int par4) 
    {
    	if(MUtil.isWaterTouchingAllSides(par1World, par2, par3, par4))
    	{
    		par1World.setBlock(par2, par3, par4, EDBlockManager.cardboardWet.blockID);
    	}
    }
    
    public void onBlockPlacedBy(World par1World, int par2, int par3, int par4, EntityLivingBase par5EntityLivingBase, ItemStack par6ItemStack)
    {
    	if(MUtil.isWaterTouchingAllSides(par1World, par2, par3, par4))
    	{
    		par1World.setBlock(par2, par3, par4, EDBlockManager.cardboardWet.blockID);
    	}
    }
    
    public int getFlammability(IBlockAccess world, int x, int y, int z, int metadata, ForgeDirection face)
    {
    	if(blockID == EDBlockManager.cardboardBlock.blockID)
    	{
    		if(face == ForgeDirection.UP || face == ForgeDirection.DOWN || face == ForgeDirection.NORTH || face == ForgeDirection.SOUTH || face == ForgeDirection.EAST || face == ForgeDirection.WEST)
    		{
                return 100;
    		}
    		else
    			return 0;
    	}
    	else
    		return 0;
    }

}
