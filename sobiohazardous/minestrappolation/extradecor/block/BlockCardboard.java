package sobiohazardous.minestrappolation.extradecor.block;

import java.util.Random;

import sobiohazardous.minestrappolation.api.util.MUtil;
import sobiohazardous.minestrappolation.extradecor.ExtraDecor;
import sobiohazardous.minestrappolation.extradecor.lib.EDBlockManager;
import sobiohazardous.minestrappolation.extradecor.lib.EDItemManager;
import sobiohazardous.minestrappolation.extradecor.tileentity.TileEntityCardBoard;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;

public class BlockCardboard extends BlockContainer
{
	
	private Icon top;
	public BlockCardboard(int par1, Material material) 
	{
		super(par1, material);
	}

    
    public int getFlammability(IBlockAccess world, int x, int y, int z, int metadata, ForgeDirection face)
    {
    	if(blockID == EDBlockManager.cardboardBlock.blockID)
    	{
    		if(face == ForgeDirection.UP || face == ForgeDirection.DOWN || face == ForgeDirection.NORTH || face == ForgeDirection.SOUTH || face == ForgeDirection.EAST || face == ForgeDirection.WEST)
    		{
                return 155;
    		}
    		else
    			return 0;
    	}
    	else
    		return 0;
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
		blockIcon = iconRegister.registerIcon("Minestrappolation:block_CardboardBlock");
		top = iconRegister.registerIcon("Minestrappolation:block_CardboardBlock");
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
        return 2 + par1Random.nextInt(3);
    }

	@Override
	public TileEntity createNewTileEntity(World world) {
		// TODO Auto-generated method stub
		return new TileEntityCardBoard();
	}

}
