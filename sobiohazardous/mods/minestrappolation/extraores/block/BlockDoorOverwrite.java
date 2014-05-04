package sobiohazardous.mods.minestrappolation.extraores.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import java.util.Random;

import sobiohazardous.mods.minestrappolation.core.util.MChatMessageHandler;
import sobiohazardous.mods.minestrappolation.extraores.lib.EOItemManager;
import sobiohazardous.mods.minestrappolation.extraores.tileentity.TileEntityLocked;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.BlockDoor;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.IconFlipped;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.IIcon;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockDoorOverwrite extends BlockDoor implements ITileEntityProvider
{
    @SideOnly(Side.CLIENT)
    private IIcon[] field_111044_a;
    @SideOnly(Side.CLIENT)
    private IIcon[] field_111043_b;

    TileEntityLocked te;
    
    public BlockDoorOverwrite(Material par2Material)
    {
        super(par2Material);
        float f = 0.5F;
        float f1 = 1.0F;
        this.disableStats();
        this.setBlockBounds(0.5F - f, 0.0F, 0.5F - f, 0.5F + f, f1, 0.5F + f);
    }

    public void onBlockAdded(World par1World, int par2, int par3, int par4)
    {
    	te = (TileEntityLocked)par1World.getTileEntity(par2, par3, par4);
    	super.onBlockAdded(par1World, par2, par3, par4);
    }

    @SideOnly(Side.CLIENT)

    /**
     * When this method is called, your block should register all the icons it needs with the given IconRegister. This
     * is the only chance you get to register icons.
     */
    public void registerIcons(IIconRegister par1IconRegister)
    {
        this.field_111044_a = new IIcon[2];
        this.field_111043_b = new IIcon[2];
        this.field_111044_a[0] = par1IconRegister.registerIcon(this.getTextureName() + "_upper");
        this.field_111043_b[0] = par1IconRegister.registerIcon(this.getTextureName() + "_lower");
        this.field_111044_a[1] = new IconFlipped(this.field_111044_a[0], true, false);
        this.field_111043_b[1] = new IconFlipped(this.field_111043_b[0], true, false);
    }
    
    /**
     * Called upon block activation (right click on the block.)
     */
    public boolean onBlockActivated(World par1World, int par2, int par3, int par4, EntityPlayer par5EntityPlayer, int par6, float par7, float par8, float par9)
    {      
        if (this.blockMaterial == Material.iron)
        {
        	if(te.locked && par5EntityPlayer.getItemInUse() != new ItemStack(EOItemManager.steelLock))
            {
            	MChatMessageHandler.sendChatToPlayer(par5EntityPlayer, "Locked by: " + te.player);
            }	
        	return false; //Allow items to interact with the door
        }
        else
        {
        	int i1 = this.getFullMetadata(par1World, par2, par3, par4);
        	int j1 = i1 & 7;
        	j1 ^= 4;
        		
        	if ((i1 & 8) == 0)
        	{
        		par1World.setBlockMetadataWithNotify(par2, par3, par4, j1, 2);
        		par1World.markBlockRangeForRenderUpdate(par2, par3, par4, par2, par3, par4);
        	}
        	else
        	{
        		par1World.setBlockMetadataWithNotify(par2, par3 - 1, par4, j1, 2);
        		par1World.markBlockRangeForRenderUpdate(par2, par3 - 1, par4, par2, par3, par4);
        	}

        	par1World.playAuxSFXAtEntity(par5EntityPlayer, 1003, par2, par3, par4, 0);
                
        	if(par5EntityPlayer.getItemInUse() == new ItemStack(EOItemManager.steelLock))
            {
                return true;
            }
        	
        	if(te.locked && par5EntityPlayer.getItemInUse() != new ItemStack(EOItemManager.steelLock))
            {
            	MChatMessageHandler.sendChatToPlayer(par5EntityPlayer, "Locked by: " + te.player);
            }
        	
        	return false;
        }                
     }

    /**
     * Returns the full metadata value created by combining the metadata of both blocks the door takes up.
     */
    public int getFullMetadata(IBlockAccess par1IBlockAccess, int par2, int par3, int par4)
    {
        int l = par1IBlockAccess.getBlockMetadata(par2, par3, par4);
        boolean flag = (l & 8) != 0;
        int i1;
        int j1;

        if (flag)
        {
            i1 = par1IBlockAccess.getBlockMetadata(par2, par3 - 1, par4);
            j1 = l;
        }
        else
        {
            i1 = l;
            j1 = par1IBlockAccess.getBlockMetadata(par2, par3 + 1, par4);
        }

        boolean flag1 = (j1 & 1) != 0;
        return i1 & 7 | (flag ? 8 : 0) | (flag1 ? 16 : 0);
    }

	@Override
	public TileEntity createNewTileEntity(World world, int arg) 
	{
		return new TileEntityLocked();
	}
	
    public void breakBlock(World par1World, int par2, int par3, int par4, Block par5, int par6)
    {
    	te.locked = false;
    	par1World.removeTileEntity(par2, par3, par4);
    	super.breakBlock(par1World, par2, par3, par4, par5, par6);
    }

    public boolean onBlockEventReceived(World p_149696_1_, int p_149696_2_, int p_149696_3_, int p_149696_4_, int p_149696_5_, int p_149696_6_)
    {
        super.onBlockEventReceived(p_149696_1_, p_149696_2_, p_149696_3_, p_149696_4_, p_149696_5_, p_149696_6_);
        TileEntity var7 = p_149696_1_.getTileEntity(p_149696_2_, p_149696_3_, p_149696_4_);
        return var7 != null ? var7.receiveClientEvent(p_149696_5_, p_149696_6_) : false;
    }
}
