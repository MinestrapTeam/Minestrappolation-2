package sobiohazardous.minestrappolation.extradecor.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import java.util.List;
import java.util.Random;

import sobiohazardous.minestrappolation.extradecor.ExtraDecor;
import sobiohazardous.minestrappolation.extradecor.lib.EDBlockManager;
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
    	if(this == EDBlockManager.sandyRoad)
    	{
    		this.blockIcon = par1IconRegister.registerIcon("Minestrappolation:block_SandyRoadSide");
    		this.top = par1IconRegister.registerIcon("Minestrappolation:block_SandyRoadTop");
    		this.bottom = par1IconRegister.registerIcon("Minestrappolation:block_SandyRoadBottom");
    	}
    	else if(this == EDBlockManager.sandstoneRoad)
    	{
    		this.blockIcon = par1IconRegister.registerIcon("Minestrappolation:block_SandstoneRoadSide");
    		this.top = par1IconRegister.registerIcon("Minestrappolation:block_SandstoneRoadTop");
    		this.bottom = par1IconRegister.registerIcon("Minestrappolation:block_SandyRoadBottom");
    	}
    	else
    	{
    		this.blockIcon = par1IconRegister.registerIcon("Minestrappolation:block_GravelRoadSide");
    		this.top = par1IconRegister.registerIcon("Minestrappolation:block_GravelRoadTop");
    		this.bottom = par1IconRegister.registerIcon("Minestrappolation:block_GravelRoadBottom");
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
    	if(this == EDBlockManager.sandyRoad)
    	{
    		par5Entity.motionX *= 1.4;
    		par5Entity.motionZ *= 1.4;
    	}
    	else if(this == EDBlockManager.gravelRoad)
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