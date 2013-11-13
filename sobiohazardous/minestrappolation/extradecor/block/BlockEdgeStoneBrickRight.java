package sobiohazardous.minestrappolation.extradecor.block;

import java.util.Iterator;
import java.util.List;
import java.util.Random;

import sobiohazardous.minestrappolation.api.block.MBlock;
import sobiohazardous.minestrappolation.api.util.MUtil;
import sobiohazardous.minestrappolation.extradecor.ExtraDecor;
import sobiohazardous.minestrappolation.extradecor.lib.EDBlockManager;
import sobiohazardous.minestrappolation.extradecor.tileentity.TileEntityEdgeStoneSides;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
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
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.DamageSource;
import net.minecraft.util.Icon;
import net.minecraft.world.World;

public class BlockEdgeStoneBrickRight extends BlockContainer
{
	private Icon left;
	private Icon right;
	public BlockEdgeStoneBrickRight(int par1)
    {
        super(par1, Material.rock);
        this.setCreativeTab(EDBlockManager.tabDecorBlocks);
    }
	
	public int idDropped(int par1, Random par2Random, int par3)
    {
        return EDBlockManager.edgeStoneBrick.blockID;
    }
	
	public void registerIcons(IconRegister par1IconRegister)
    {
        this.blockIcon = par1IconRegister.registerIcon("Minestrappolation:block_EdgeStoneFull");
        this.left = par1IconRegister.registerIcon("Minestrappolation:block_EdgeStoneSideRight");
        this.right = par1IconRegister.registerIcon("Minestrappolation:block_EdgeStoneSideLeft");
        
    }
	
	public Icon getIcon(int i, int j)
    {
    	if (i == 0)//bottom
            
            return blockIcon;
    	if (i == 1)//top
           
            return blockIcon;
   
    	if (i == 2) // side
           
            return right;
    	if (i == 3)//side 
           
            return left;
    	if (i == 4) //side
   
    		return left;
    	if (i == 5) //side
   
    		return right;

    	if (j ==1)
    	{
    		return blockIcon;
    	}
		return blockIcon;
    }

	@Override
	public TileEntity createNewTileEntity(World world) {
		// TODO Auto-generated method stub
		return new TileEntityEdgeStoneSides();
	}

}
