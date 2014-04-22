package sobiohazardous.minestrappolation.extradecor.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import java.util.List;
import java.util.Random;

import sobiohazardous.minestrappolation.api.util.MAssetManager;
import sobiohazardous.minestrappolation.extradecor.ExtraDecor;
import sobiohazardous.minestrappolation.extradecor.lib.EDBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.BlockFalling;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockSandyRoad extends BlockFalling
{
	private IIcon top;
	private IIcon bottom;
	
    public BlockSandyRoad()
    {
        super(Material.sand);
    }
    
    
    @SideOnly(Side.CLIENT)

    /**
     * When this method is called, your block should register all the icons it needs with the given IconRegister. This
     * is the only chance you get to register icons.
     */
    public void registerBlockIcons(IIconRegister par1IconRegister)
    {
    	if(this == EDBlocks.sandyRoad)
    	{
    		this.blockIcon = par1IconRegister.registerIcon(MAssetManager.getEDTexture("roadSandSide"));
    		this.top = par1IconRegister.registerIcon(MAssetManager.getEDTexture("roadSandTop"));
    		this.bottom = par1IconRegister.registerIcon(MAssetManager.getEDTexture("roadSandBottom"));
    	}
    	else if(this == EDBlocks.sandstoneRoad)
    	{
    		this.blockIcon = par1IconRegister.registerIcon(MAssetManager.getEDStonecutterTexture("Sandstone_Road_Side_0"));
    		this.top = par1IconRegister.registerIcon(MAssetManager.getEDStonecutterTexture("Sandstone_PatternBricks_0_0"));
    		this.bottom = par1IconRegister.registerIcon(MAssetManager.getEDTexture("roadSandBottom"));
    	}
    	else
    	{
    		this.blockIcon = par1IconRegister.registerIcon(MAssetManager.getEDTexture("roadGravelSide"));
    		this.top = par1IconRegister.registerIcon(MAssetManager.getEDTexture("roadGravelTop"));
    		this.bottom = par1IconRegister.registerIcon(MAssetManager.getEDTexture("roadGravelBottom"));
    	}
    }
    
    public IIcon getIcon(int i, int j)
    {
    	if (i == 0)//bottom
            
            return bottom;
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
    
    public void onEntityWalking(World par1World, int par2, int par3, int par4, Entity par5Entity)
    {
    	if(this == EDBlocks.sandyRoad)
    	{
    		par5Entity.motionX *= 1.4;
    		par5Entity.motionZ *= 1.4;
    	}
    	else if(this == EDBlocks.gravelRoad)
    	{
    		par5Entity.motionX *= 1.6;
    		par5Entity.motionZ *= 1.6;
    	}
        else
        {
        	par5Entity.motionX *= 1.8;
    		par5Entity.motionZ *= 1.8;
        }
    }
}