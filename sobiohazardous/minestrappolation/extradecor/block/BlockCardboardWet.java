package sobiohazardous.minestrappolation.extradecor.block;

import java.util.Random;

import sobiohazardous.minestrappolation.api.util.MiscFunctions;
import sobiohazardous.minestrappolation.extradecor.ExtraDecor;
import sobiohazardous.minestrappolation.extradecor.lib.EDBlockManager;
import sobiohazardous.minestrappolation.extradecor.lib.EDItemManager;
import sobiohazardous.minestrappolation.extradecor.tileentity.TileEntityCardboardWet;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;
import net.minecraft.world.World;

public class BlockCardboardWet extends BlockContainer
{
	private Icon top;
	public boolean isDry = true;
	
	public BlockCardboardWet(int id, Material mat)
	{
		super(id, mat);
	}
    
    protected boolean canSilkHarvest()
    {
    	return true;
    }
    
    public int idDropped(int par1, Random par2Random, int par3)
    {
    	return EDBlockManager.cardboard.blockID;
    }
    
    /**
     * Returns the quantity of items to drop on block destruction.
     */
    public int quantityDropped(Random par1Random)
    {
        return 2 + par1Random.nextInt(3);
    }
    
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
		return blockIcon;
    }
    
	public void registerIcons(IconRegister iconRegister)
	{
		blockIcon = iconRegister.registerIcon("Minestrappolation:block_CardboardWetSide");
		top = iconRegister.registerIcon("Minestrappolation:block_CardboardWetTop");
	}

	@Override
	public TileEntity createNewTileEntity(World world) 
	{
		return new TileEntityCardboardWet();
	}
    

    /**
     * Lets the block know when one of its neighbor changes. Doesn't know which neighbor changed (coordinates passed are
     * their own) Args: x, y, z, neighbor blockID
     */
    public void onNeighborBlockChange(World par1World, int par2, int par3, int par4, int par5) 
    {
    	if(par5 == Block.waterMoving.blockID || par5 == Block.waterStill.blockID)
    	{
            this.isDry = false;
            par1World.setBlock(par2, par3, par4, EDBlockManager.cardboardWet.blockID);
    	}
    	
    	if(par5 != Block.waterMoving.blockID || par5 != Block.waterStill.blockID)
    	{
            this.isDry = true;
    	}
    }

    /**
     * Called whenever the block is added into the world. Args: world, x, y, z
     */
    public void onBlockAdded(World par1World, int par2, int par3, int par4) 
    {
    	if(MiscFunctions.isWaterTouchingAllSides(par1World, par2, par3, par4))
    	{
            this.isDry = false;
    		par1World.setBlock(par2, par3, par4, EDBlockManager.cardboardWet.blockID);
    	}
    	
    	if(!MiscFunctions.isWaterTouchingAllSides(par1World, par2, par3, par4))
    	{
            this.isDry = true;
    	}
    }
    
    public void onEntityWalking(World par1World, int par2, int par3, int par4, Entity par5Entity)
    {
        super.onEntityWalking(par1World, par2, par3, par4, par5Entity);
        par1World.destroyBlock(par2, par3, par4, true);
    }
}
