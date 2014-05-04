package sobiohazardous.mods.minestrappolation.extradecor.block;

import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import sobiohazardous.mods.minestrappolation.core.util.MAssetManager;
import sobiohazardous.mods.minestrappolation.core.util.MUtil;
import sobiohazardous.mods.minestrappolation.extradecor.ExtraDecor;
import sobiohazardous.mods.minestrappolation.extradecor.lib.EDBlocks;
import sobiohazardous.mods.minestrappolation.extradecor.lib.EDItems;
import sobiohazardous.mods.minestrappolation.extradecor.tileentity.TileEntityCardboardWet;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

public class BlockCardboardWet extends BlockContainer
{
	private IIcon top;
	private IIcon bottom;
	public boolean isDry = true;
	
	public BlockCardboardWet(Material mat)
	{
		super(mat);
	}
    
    protected boolean canSilkHarvest()
    {
    	return true;
    }
    
	public Item getItemDropped(int p_149650_1_, Random p_149650_2_, int p_149650_3_)    
    {
    	return EDItems.cardboardItem;
    }
    
    /**
     * Returns the quantity of items to drop on block destruction.
     */
    public int quantityDropped(Random par1Random)
    {
        return 2;
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
    
    @Override
	public void registerBlockIcons(IIconRegister iconRegister)
	{
		blockIcon = iconRegister.registerIcon(MAssetManager.getEDTexture("cardboardWetSide"));
		top = iconRegister.registerIcon(MAssetManager.getEDTexture("cardboardWetTop"));
		bottom = iconRegister.registerIcon(MAssetManager.getEDTexture("cardboard"));
	}
    
    public void onEntityWalking(World par1World, int par2, int par3, int par4, Entity par5Entity)
    {
    	//par1World.destroyBlock(par2, par3, par4, true); 
    	//destroys block hopefully
    	par1World.func_147478_e(par2, par3, par4, true);
    }

	@Override
	public TileEntity createNewTileEntity(World var1, int var2) 
	{
		return new TileEntityCardboardWet();
	}
}
