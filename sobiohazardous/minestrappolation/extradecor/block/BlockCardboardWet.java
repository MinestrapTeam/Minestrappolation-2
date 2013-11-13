package sobiohazardous.minestrappolation.extradecor.block;

import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import sobiohazardous.minestrappolation.api.util.MUtil;
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
import net.minecraft.item.ItemStack;
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
    	return EDItemManager.cardboardItem.itemID;
    }
    
    /**
     * Returns the quantity of items to drop on block destruction.
     */
    public int quantityDropped(Random par1Random)
    {
        return 2;
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
    

   
    
    public void onEntityWalking(World par1World, int par2, int par3, int par4, Entity par5Entity)
    {
    	par1World.destroyBlock(par2, par3, par4, true);        
    }
}
