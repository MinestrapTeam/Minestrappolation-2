package sobiohazardous.minestrappolation.extradecor.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import java.util.List;
import java.util.Random;

import sobiohazardous.minestrappolation.extradecor.ExtraDecor;
import sobiohazardous.minestrappolation.extradecor.lib.EDBlockManager;
import sobiohazardous.minestrappolation.extradecor.lib.EDItemManager;
import net.minecraft.block.Block;
import net.minecraft.block.BlockPane;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;

public class EDBlockPane extends Block
{
    /**
     * Holds the texture index of the side of the pane (the thin lateral side)
     */
    private final String sideTextureIndex;

    /**
     * If this field is true, the pane block drops itself when destroyed (like the iron fences), otherwise, it's just
     * destroyed (like glass panes)
     */
    private final boolean canDropItself;
    private final String field_94402_c;
    @SideOnly(Side.CLIENT)
    private IIcon theIcon;

    public EDBlockPane(String texture, String edgeTexture, Material par4Material, boolean par5)
    {
        super(par4Material);
        this.sideTextureIndex = "Minestrappolation:" + edgeTexture;
        this.canDropItself = par5;
        this.field_94402_c = "Minestrappolation:" + texture;
    }

    /**
     * Returns the ID of the items to drop on destruction.
     */
	public Item getItemDropped(int p_149650_1_, Random p_149650_2_, int p_149650_3_)    
    {
		return !this.canDropItself ? null : super.getItemDropped(p_149650_1_, p_149650_2_, p_149650_3_);    
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

    /**
     * The type of render function that is called for this block
     */
    public int getRenderType()
    {
        return ExtraDecor.paneRenderId;
    }

    @SideOnly(Side.CLIENT)

    /**
     * Returns true if the given side of this block type should be rendered, if the adjacent block is at the given
     * coordinates.  Args: blockAccess, x, y, z, side
     */
    public boolean shouldSideBeRendered(IBlockAccess p_149646_1_, int p_149646_2_, int p_149646_3_, int p_149646_4_, int p_149646_5_)
    {
        return p_149646_1_.getBlock(p_149646_2_, p_149646_3_, p_149646_4_) == this ? false : super.shouldSideBeRendered(p_149646_1_, p_149646_2_, p_149646_3_, p_149646_4_, p_149646_5_);
    }

    /**
     * Adds all intersecting collision boxes to a list. (Be sure to only add boxes to the list if they intersect the
     * mask.) Parameters: World, X, Y, Z, mask, list, colliding entity
     */
    public void addCollisionBoxesToList(World p_149743_1_, int p_149743_2_, int p_149743_3_, int p_149743_4_, AxisAlignedBB p_149743_5_, List p_149743_6_, Entity p_149743_7_)
    {
        boolean var8 = this.canThisPaneConnectToThisBlockID(p_149743_1_.getBlock(p_149743_2_, p_149743_3_, p_149743_4_ - 1));
        boolean var9 = this.canThisPaneConnectToThisBlockID(p_149743_1_.getBlock(p_149743_2_, p_149743_3_, p_149743_4_ + 1));
        boolean var10 = this.canThisPaneConnectToThisBlockID(p_149743_1_.getBlock(p_149743_2_ - 1, p_149743_3_, p_149743_4_));
        boolean var11 = this.canThisPaneConnectToThisBlockID(p_149743_1_.getBlock(p_149743_2_ + 1, p_149743_3_, p_149743_4_));

        if ((!var10 || !var11) && (var10 || var11 || var8 || var9))
        {
            if (var10 && !var11)
            {
                this.setBlockBounds(0.0F, 0.0F, 0.4375F, 0.5F, 1.0F, 0.5625F);
                super.addCollisionBoxesToList(p_149743_1_, p_149743_2_, p_149743_3_, p_149743_4_, p_149743_5_, p_149743_6_, p_149743_7_);
            }
            else if (!var10 && var11)
            {
                this.setBlockBounds(0.5F, 0.0F, 0.4375F, 1.0F, 1.0F, 0.5625F);
                super.addCollisionBoxesToList(p_149743_1_, p_149743_2_, p_149743_3_, p_149743_4_, p_149743_5_, p_149743_6_, p_149743_7_);
            }
        }
        else
        {
            this.setBlockBounds(0.0F, 0.0F, 0.4375F, 1.0F, 1.0F, 0.5625F);
            super.addCollisionBoxesToList(p_149743_1_, p_149743_2_, p_149743_3_, p_149743_4_, p_149743_5_, p_149743_6_, p_149743_7_);
        }

        if ((!var8 || !var9) && (var10 || var11 || var8 || var9))
        {
            if (var8 && !var9)
            {
                this.setBlockBounds(0.4375F, 0.0F, 0.0F, 0.5625F, 1.0F, 0.5F);
                super.addCollisionBoxesToList(p_149743_1_, p_149743_2_, p_149743_3_, p_149743_4_, p_149743_5_, p_149743_6_, p_149743_7_);
            }
            else if (!var8 && var9)
            {
                this.setBlockBounds(0.4375F, 0.0F, 0.5F, 0.5625F, 1.0F, 1.0F);
                super.addCollisionBoxesToList(p_149743_1_, p_149743_2_, p_149743_3_, p_149743_4_, p_149743_5_, p_149743_6_, p_149743_7_);
            }
        }
        else
        {
            this.setBlockBounds(0.4375F, 0.0F, 0.0F, 0.5625F, 1.0F, 1.0F);
            super.addCollisionBoxesToList(p_149743_1_, p_149743_2_, p_149743_3_, p_149743_4_, p_149743_5_, p_149743_6_, p_149743_7_);
        }
    }
    
    /**
     * Sets the block's bounds for rendering it as an item
     */
    public void setBlockBoundsForItemRender()
    {
        this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
    }

    /**
     * Updates the blocks bounds based on its current state. Args: world, x, y, z
     */
    public void setBlockBoundsBasedOnState(IBlockAccess par1IBlockAccess, int par2, int par3, int par4)
    {
        float f = 0.4375F;
        float f1 = 0.5625F;
        float f2 = 0.4375F;
        float f3 = 0.5625F;
        boolean flag = this.canThisPaneConnectToThisBlockID(par1IBlockAccess.getBlock(par2, par3, par4 - 1));
        boolean flag1 = this.canThisPaneConnectToThisBlockID(par1IBlockAccess.getBlock(par2, par3, par4 + 1));
        boolean flag2 = this.canThisPaneConnectToThisBlockID(par1IBlockAccess.getBlock(par2 - 1, par3, par4));
        boolean flag3 = this.canThisPaneConnectToThisBlockID(par1IBlockAccess.getBlock(par2 + 1, par3, par4));

        if ((!flag2 || !flag3) && (flag2 || flag3 || flag || flag1))
        {
            if (flag2 && !flag3)
            {
                f = 0.0F;
            }
            else if (!flag2 && flag3)
            {
                f1 = 1.0F;
            }
        }
        else
        {
            f = 0.0F;
            f1 = 1.0F;
        }

        if ((!flag || !flag1) && (flag2 || flag3 || flag || flag1))
        {
            if (flag && !flag1)
            {
                f2 = 0.0F;
            }
            else if (!flag && flag1)
            {
                f3 = 1.0F;
            }
        }
        else
        {
            f2 = 0.0F;
            f3 = 1.0F;
        }

        this.setBlockBounds(f, 0.0F, f2, f1, 1.0F, f3);
    }

    @SideOnly(Side.CLIENT)

    /**
     * Returns the texture index of the thin side of the pane.
     */
    public IIcon getSideTextureIndex()
    {
        return this.theIcon;
    }

    /**
     * Gets passed in the blockID of the block adjacent and supposed to return true if its allowed to connect to the
     * type of blockID passed in. Args: blockID
     */
    public final boolean canThisPaneConnectToThisBlockID(Block par1)
    {
    	return par1.func_149730_j() || par1 == this || par1 == Blocks.glass || par1 == Blocks.stained_glass || par1 == Blocks.stained_glass_pane || par1 instanceof BlockPane;    
    }

    /**
     * Return true if a player with Silk Touch can harvest this block directly, and not its normal drops.
     */
    protected boolean canSilkHarvest()
    {
        return true;
    }

    /**
     * Returns an item stack containing a single instance of the current block type. 'i' is the block's subtype/damage
     * and is ignored for blocks which do not support subtypes. Blocks which cannot be harvested should return null.
     */
    protected ItemStack createStackedBlock(int par1)
    {
        return new ItemStack(this, 1, par1);
    }

    @SideOnly(Side.CLIENT)

    /**
     * When this method is called, your block should register all the icons it needs with the given IconRegister. This
     * is the only chance you get to register icons.
     */
    public void registerBlockIcons(IIconRegister par1IconRegister)
    {
        this.blockIcon = par1IconRegister.registerIcon(this.field_94402_c);
        this.theIcon = par1IconRegister.registerIcon(this.sideTextureIndex);
    }
    
    public int getFlammability(IBlockAccess world, int x, int y, int z,ForgeDirection face)
    {
    	if(world.getBlock(x, y, z) == EDBlockManager.cardboard)
    	{
    		if(face == ForgeDirection.UP || face == ForgeDirection.DOWN || face == ForgeDirection.NORTH || face == ForgeDirection.SOUTH || face == ForgeDirection.EAST || face == ForgeDirection.WEST)
    		{
                return 255;
    		}
    		else
    			return 0;
    	}
    	else
    		return 0;
    }
    
    public boolean canPaneConnectTo(IBlockAccess access, int x, int y, int z, ForgeDirection dir)
    {
        return canThisPaneConnectToThisBlockID(access.getBlock(x+dir.offsetX, y+dir.offsetY, z+dir.offsetZ)) || access.isSideSolid(x+dir.offsetX, y+dir.offsetY, z+dir.offsetZ, dir.getOpposite(), false);
    }
}
