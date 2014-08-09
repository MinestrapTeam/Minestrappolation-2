package minestrapteam.minestrappolation.block;

import minestrapteam.minestrappolation.tileentity.TileEntityWorkbench2;
import minestrapteam.minestrappolation.util.MAssetManager;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

public class BlockWorkbench2 extends BlockContainer
{
	protected IIcon	frontIcon;
	protected IIcon	topIcon;
	protected IIcon	bottomIcon;
	
	public BlockWorkbench2()
	{
		super(Material.wood);
        this.setCreativeTab(CreativeTabs.tabDecorations);
		this.setBlockTextureName(MAssetManager.getMachineTexture("crafting_table"));
	}
	
	
	@Override
	public IIcon getIcon(int side, int metadata)
	{
		if (side == 0)
		{
			return this.bottomIcon;
		}
		else if (side == 1)
		{
			return this.topIcon;
		}
		else if (side == 3 || side == 4)
		{
			return this.frontIcon;
		}
		return this.blockIcon;
	}
	

	@Override
	public void registerBlockIcons(IIconRegister iconRegister)
	{
		this.blockIcon = iconRegister.registerIcon(this.textureName + "_side");
		this.frontIcon = iconRegister.registerIcon(this.textureName + "_front");
		this.topIcon = iconRegister.registerIcon(this.textureName + "_top");
		this.bottomIcon = iconRegister.registerIcon(this.textureName + "_bottom");
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
}
