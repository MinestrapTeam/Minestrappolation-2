package sobiohazardous.minestrappolation.extradecor.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import java.util.List;
import java.util.Random;

import sobiohazardous.minestrappolation.api.util.MAssetManager;
import sobiohazardous.minestrappolation.api.util.MUtil;
import sobiohazardous.minestrappolation.extradecor.ExtraDecor;
import sobiohazardous.minestrappolation.extradecor.lib.EDBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.BlockLadder;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockRope extends BlockLadder
{
    public BlockRope()
    {
        super();
    }

    /**
     * Updates the blocks bounds based on its current state. Args: world, x, y, z
     */
    public void setBlockBoundsBasedOnState(IBlockAccess par1IBlockAccess, int par2, int par3, int par4)
    {
        float f = 0.375F;
        float f1 = 0.625F;
        float f2 = 0.375F;
        float f3 = 0.625F;

        this.setBlockBounds(f, 0.0F, f2, f1, 1.0F, f3);
    }

    /**
     * Is this block (a) opaque and (b) a full 1m cube?  This determines whether or not to render the shared face of two
     * adjacent blocks and also whether the player can attach torches, redstone wire, etc to this block.
     */
 
    public boolean isOpaqueCube()
    {
        return false;
    }

    /**
     * If this block doesn't render as an ordinary block it will return False (examples: signs, buttons, stairs, etc)
     */
    public boolean renderAsNormalBlock()
    {
        return false;
    }
    
    public boolean getBlocksMovement(IBlockAccess par1IBlockAccess, int par2, int par3, int par4)
    {
        return false;
    }
     
    /**
     * The type of render function that is called for this block
     */
    public int getRenderType()
    {
        return ExtraDecor.ropeRenderId;
    }

    @SideOnly(Side.CLIENT)

    /**
     * Returns true if the given side of this block type should be rendered, if the adjacent block is at the given
     * coordinates.  Args: blockAccess, x, y, z, side
     */
    public boolean shouldSideBeRendered(IBlockAccess par1IBlockAccess, int par2, int par3, int par4, int par5)
    {
        return true;
    }

    @SideOnly(Side.CLIENT)

    /**
     * When this method is called, your block should register all the icons it needs with the given IconRegister. This
     * is the only chance you get to register icons.
     */
    public void registerBlockIcons(IIconRegister par1IconRegister)
    {
        this.blockIcon = par1IconRegister.registerIcon(MAssetManager.getEDTexture("ropeSide"));
    }
    
    public boolean canPlaceBlockAt(World par1World, int par2, int par3, int par4)
    {
    	if(par1World.getBlock(par2, par3+1, par4) == Blocks.glass)
    	{
    		return false;
    	}
    	if(par1World.getBlock(par2, par3+1, par4) == Blocks.torch)
    	{
    		return false;
    	}
    	if(par1World.getBlock(par2, par3+1, par4) == Blocks.redstone_torch)
    	{
    		return false;
    	}
    	if(par1World.getBlock(par2, par3+1, par4) == Blocks.redstone_torch)
    	{
    		return false;
    	}
    	if(par1World.getBlock(par2, par3+1, par4) == Blocks.web)
    	{
    		return false;
    	}
    	if(par1World.getBlock(par2, par3+1, par4) == Blocks.ladder)
    	{
    		return false;
    	}
    	if(par1World.getBlock(par2, par3+1, par4) == Blocks.water)
    	{
    		return false;
    	}
    	if(par1World.getBlock(par2, par3+1, par4) == Blocks.water)
    	{
    		return false;
    	}
    	if(par1World.getBlock(par2, par3+1, par4) == Blocks.stone_slab)
    	{
    		return false;
    	}
    	if(par1World.getBlock(par2, par3+1, par4) == Blocks.wooden_slab)
    	{
    		return false;
    	}
    	if(par1World.getBlock(par2, par3+1, par4) == Blocks.lever)
    	{
    		return false;
    	}
    	if(par1World.getBlock(par2, par3+1, par4) == Blocks.cauldron)
    	{
    		return false;
    	}
    	if(par1World.getBlock(par2, par3+1, par4) == Blocks.standing_sign)
    	{
    		return false;
    	}
    	if(par1World.getBlock(par2, par3+1, par4) == Blocks.trapdoor)
    	{
    		return false;
    	}
    	if(par1World.getBlock(par2, par3+1, par4) == Blocks.vine)
    	{
    		return false;
    	}
    	if(par1World.getBlock(par2, par3+1, par4) == Blocks.skull)
    	{
    		return false;
    	}
    	if(par1World.getBlock(par2, par3+1, par4) == Blocks.hopper)
    	{
    		return false;
    	}
    	if(par1World.getBlock(par2, par3+1, par4) == Blocks.lava)   	
    	{
    		return false;
    	}
    	if(par1World.getBlock(par2, par3+1, par4) == Blocks.lava)
    	{
    		return false;
    	}
    	if(par1World.getBlock(par2, par3+1, par4) == Blocks.fence_gate)
    	{
    		return false;
    	}
    	if(par1World.getBlock(par2, par3+1, par4) == EDBlocks.woodBoardsSingleSlab)
    	{
    		return false;
    	}
		return true;
    }
    
    
    /**
     * Returns the ID of the items to drop on destruction.
     */
	public Item getItemDropped(int p_149650_1_, Random p_149650_2_, int p_149650_3_)    
    {
        return EDBlocks.itemRope;
    }
    
    public void onBlockPlacedBy(World par1World, int par2, int par3, int par4, EntityLivingBase par5EntityLivingBase, ItemStack par6ItemStack)
    {
    	if(Block.isEqualTo(par1World.getBlock(par2, par3 +1, par4), Blocks.air))
    	{
    		par1World.setBlockToAir(par2, par3, par4);
            par1World.scheduleBlockUpdate(par2, par3, par4, this, 4);
            this.dropBlockAsItem(par1World, par2, par3, par4, par1World.getBlockMetadata(par2, par3, par4), 0);
    	}
    }
}
