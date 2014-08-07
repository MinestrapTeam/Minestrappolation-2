package minestrapteam.minestrappolation.block;

import minestrapteam.minestrappolation.tileentity.TileEntityWorkbench2;
import minestrapteam.minestrappolation.util.MAssetManager;
import net.minecraft.block.Block;
import net.minecraft.block.BlockWorkbench;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

public class BlockWorkbench2 extends MBlockMachine
{
	public BlockWorkbench2()
	{
		super(Material.wood, "craftingtable");
        this.setCreativeTab(CreativeTabs.tabDecorations);
	}
	
	/*
	@Override
	public void registerBlockIcons(IIconRegister iconRegister)
	{
		this.blockIcon = iconRegister.registerIcon("crafting_table_front");
	}
	*/
	
	@Override
	public boolean isOpaqueCube()
	{
		return false;
	}
	
	@Override
	public boolean renderAsNormalBlock()
	{
		return false;
	}
	
	/**
     * Called upon block activation (right click on the block.)
     */
    public boolean onBlockActivated(World p_149727_1_, int p_149727_2_, int p_149727_3_, int p_149727_4_, EntityPlayer p_149727_5_, int p_149727_6_, float p_149727_7_, float p_149727_8_, float p_149727_9_)
    {
        if (p_149727_1_.isRemote)
        {
            return true;
        }
        else
        {
            p_149727_5_.displayGUIWorkbench(p_149727_2_, p_149727_3_, p_149727_4_);
            return true;
        }
    }

	@Override
	public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_)
	{
		return new TileEntityWorkbench2();
	}

	@Override
	public void openGUI(EntityPlayer player, World world, int x, int y, int z)
	{		
	}
}
