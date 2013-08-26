package sobiohazardous.minestrappolation.extradecor.block;

import java.util.Iterator;
import java.util.List;
import java.util.Random;

import sobiohazardous.minestrappolation.api.util.BlockFunctions;
import sobiohazardous.minestrappolation.extradecor.ExtraDecor;
import sobiohazardous.minestrappolation.extradecor.lib.EDBlockManager;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.src.*;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.DamageSource;
import net.minecraft.util.Icon;
import net.minecraft.world.World;

public class BlockEdgeStoneBrick extends Block
{
	private Icon left;
	private Icon right;
	public BlockEdgeStoneBrick(int par1)
    {
        super(par1, Material.rock);
        this.setCreativeTab(EDBlockManager.tabDecorBlocks);
    }
	
	public void registerIcons(IconRegister par1IconRegister)
    {
        this.blockIcon = par1IconRegister.registerIcon("Minestrappolation:block_EdgeStoneFull");
        this.left = par1IconRegister.registerIcon("Minestrappolation:block_EdgeStoneLeft");
        this.right = par1IconRegister.registerIcon("Minestrappolation:block_EdgeStoneRight");
    }
    
    public Icon getIcon(int i, int j)
    {
    	if (i == 0)//bottom
            
            return blockIcon;
    	if (i == 1)//top
           
            return blockIcon;
   
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
	
    /*
    public void onBlockPlacedBy(World par1World, int par2, int par3, int par4, EntityLiving par5EntityLiving, ItemStack par6ItemStack)
    {
    	
    	 * TODO:
    	 * -Add isBlockTouchingFront and isBlockTouchingBack methods to BlockFunctions.
    	 * -Make the block change textures based on the stone brick position, rather than changing what block it is.
    	 * -Improve logic to allow for corner edges, etc.
    	 
    }
	*/
    /*
	public void onBlockPlacedBy(World par1World, int par2, int par3, int par4, EntityLiving par5EntityLiving, ItemStack par6ItemStack)
	{
		if(BlockFunctions.isBlockTouchingLeft(par1World, par2, par3, par4, Block.stoneBrick.blockID))
		{
			par1World.setBlock(par2, par3, par4, ExtraDecor.edgeStoneBrickLeft.blockID);
		}
		
		if(BlockFunctions.isBlockTouchingRight(par1World, par2, par3, par4, Block.stoneBrick.blockID))
		{
			par1World.setBlock(par2, par3, par4, ExtraDecor.edgeStoneBrickRight.blockID);
		}
		
	}
	
	public void onNeighborBlockChange(World par1World, int par2, int par3, int par4, int neighborBlockId)
	{
		if (neighborBlockId == Block.stoneBrick.blockID)
		{
			par1World.setBlock(par2, par3, par4, ExtraDecor.edgeStoneBrickLeft.blockID);
		}
		
		if (neighborBlockId == Block.stoneBrick.blockID)
		{
			par1World.setBlock(par2, par3, par4, ExtraDecor.edgeStoneBrickRight.blockID);
		}
	}    
	*/
}
