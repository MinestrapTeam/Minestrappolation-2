package sobiohazardous.minestrappolation.extraores.block;

import java.util.Random;

import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.registry.GameRegistry;
import sobiohazardous.minestrappolation.extramobdrops.ExtraMobDrops;
import sobiohazardous.minestrappolation.extramobdrops.lib.EMDItemManager;
import sobiohazardous.minestrappolation.extraores.ExtraOres;


import sobiohazardous.minestrappolation.extraores.lib.EOBlockManager;
import sobiohazardous.minestrappolation.extraores.lib.EOItemManager;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.src.*;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.Icon;
import net.minecraft.world.World;

public class BlockCopperTarnished extends Block
{
	public Icon top;
	
	public BlockCopperTarnished(int par1)
    {
        super(par1, Material.iron);
        this.setCreativeTab(EOBlockManager.tabOresBlocks);
    }

	public void registerIcons(IconRegister iconRegister)
	{
	         blockIcon = iconRegister.registerIcon("Minestrappolation:block_TarnishedCopperSide");
	         this.top = iconRegister.registerIcon("Minestrappolation:block_TarnishedCopperTop");
	}
    
    //Args: side, metadata
    
    public Icon getIcon(int i, int j)
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
    	//TODO Fix because grease is returning null, i think its because the mod hasn't been completly loaded in preinit
        
        
        	if (par5EntityPlayer.getCurrentEquippedItem() != null && (par5EntityPlayer.getCurrentEquippedItem().itemID == EMDItemManager.grease.itemID || par5EntityPlayer.getCurrentEquippedItem().itemID == Item.fireballCharge.itemID))
            {
            	par1World.setBlock(par2, par3, par4, EOBlockManager.CopperBlock.blockID);   
            	
            }
        	return true;
            
  		
       
    }
}
