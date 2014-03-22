package sobiohazardous.minestrappolation.extraores.block;

import java.util.Random;

import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.registry.GameRegistry;
import sobiohazardous.minestrappolation.api.block.MBlock;
import sobiohazardous.minestrappolation.api.util.MAssetManager;
import sobiohazardous.minestrappolation.extramobdrops.ExtraMobDrops;
import sobiohazardous.minestrappolation.extramobdrops.lib.EMDItemManager;
import sobiohazardous.minestrappolation.extraores.ExtraOres;


import sobiohazardous.minestrappolation.extraores.lib.EOBlockManager;
import sobiohazardous.minestrappolation.extraores.lib.EOItemManager;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.src.*;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

public class BlockCopperTarnished extends MBlock
{
	public IIcon top;
	
	public BlockCopperTarnished()
    {
        super(Material.iron);
        this.setCreativeTab(EOBlockManager.tabOresBlocks);
    }

	public void registerBlockIcons(IIconRegister iconRegister)
	{
	         blockIcon = iconRegister.registerIcon(MAssetManager.getEOTexture("blockCopperTarnishedSide"));
	         this.top = iconRegister.registerIcon(MAssetManager.getEOTexture("blockCopperTarnishedTop"));
	}
    
    //Args: side, metadata
    
    public IIcon getIcon(int i, int j)
    {
    	if (i == 0)//bottom
            
            return blockIcon;
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
		return top;
    }
    
    public boolean onBlockActivated(World par1World, int par2, int par3, int par4, EntityPlayer par5EntityPlayer, int par6, float par7, float par8, float par9)
    { 	      
        	if (par5EntityPlayer.getCurrentEquippedItem() != null && (par5EntityPlayer.getCurrentEquippedItem().getItem() == EMDItemManager.grease || par5EntityPlayer.getCurrentEquippedItem().getItem() == Items.fire_charge))
            {
        		par5EntityPlayer.getCurrentEquippedItem().stackSize--;
            	par1World.setBlock(par2, par3, par4, EOBlockManager.CopperBlock);   
            	return true;
            }else if(par5EntityPlayer.getCurrentEquippedItem() == null){
            	return false;
            }
			return false;		      
    }
}
