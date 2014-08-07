package minestrapteam.minestrappolation.block;

import minestrapteam.minestrappolation.tileentity.TileEntityWorkbench2;

import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockWorkbench2 extends MBlockMachine
{
	public BlockWorkbench2()
	{
		super(Material.wood, "craftingtable");
        this.setCreativeTab(CreativeTabs.tabDecorations);
	}
	
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
	
    @Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ)
    {
        if (world.isRemote)
        {
            return true;
        }
        else
        {
            player.displayGUIWorkbench(x, y, z);
            return true;
        }
    }

	@Override
	public TileEntity createNewTileEntity(World world, int metadata)
	{
		return new TileEntityWorkbench2();
	}

	@Override
	public void openGUI(EntityPlayer player, World world, int x, int y, int z)
	{		
	}
}
