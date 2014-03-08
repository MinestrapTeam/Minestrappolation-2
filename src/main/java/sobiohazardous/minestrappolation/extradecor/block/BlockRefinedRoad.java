package sobiohazardous.minestrappolation.extradecor.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import java.util.List;

import sobiohazardous.minestrappolation.api.util.MAssetManager;
import sobiohazardous.minestrappolation.extradecor.ExtraDecor;
import sobiohazardous.minestrappolation.extradecor.lib.EDBlockManager;
import net.minecraft.block.Block;
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

public class BlockRefinedRoad extends Block
{
	public Entity entity;
	public EntityLivingBase living;
	private IIcon top;
	private IIcon bottom;
	
    public BlockRefinedRoad()
    {
        super(Material.ground);
    }

    
    public boolean getBlocksMovement(IBlockAccess par1IBlockAccess, int par2, int par3, int par4)
    {
        return false;
    }

    @SideOnly(Side.CLIENT)

    /**
     * When this method is called, your block should register all the icons it needs with the given IconRegister. This
     * is the only chance you get to register icons.
     */
    public void registerBlockIcons(IIconRegister par1IconRegister)
    {
    	if(this == EDBlockManager.refinedRoad)
    	{
    		this.blockIcon = par1IconRegister.registerIcon("Minestrappolation:block_RefinedRoadSide");
    		this.top = par1IconRegister.registerIcon("Minestrappolation:block_RefinedRoadTop");
    		this.bottom = par1IconRegister.registerIcon("Minestrappolation:block_RefinedRoadBottom");
    	}
    	else if(this == EDBlockManager.refinedNetherroad)
    	{
    		this.blockIcon = par1IconRegister.registerIcon("Minestrappolation:block_RefinedNetherroadSide");
    		this.top = par1IconRegister.registerIcon("Minestrappolation:block_RefinedNetherroadTop");
    		this.bottom = par1IconRegister.registerIcon("Minestrappolation:block_NetherroadBottom");
    	}
    	else
    	{
    		this.blockIcon = par1IconRegister.registerIcon(MAssetManager.getEDTexture("roadNetherrackSide"));
    		this.top = par1IconRegister.registerIcon(MAssetManager.getEDTexture("roadNetherrackTop"));
    		this.bottom = par1IconRegister.registerIcon(MAssetManager.getEDTexture("roadNetherrackBottom"));
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
    	if(this == EDBlockManager.refinedRoad)
    	{
    		par5Entity.motionX *= 1.6;
    		par5Entity.motionZ *= 1.6;
    	}
    	else if(this == EDBlockManager.refinedNetherroad)
    	{
    		par5Entity.motionX *= 2.4;
    		par5Entity.motionZ *= 2.4;
    	}
        else
        {
        	par5Entity.motionX *= 1.9;
    		par5Entity.motionZ *= 1.9;
        }
    }
}