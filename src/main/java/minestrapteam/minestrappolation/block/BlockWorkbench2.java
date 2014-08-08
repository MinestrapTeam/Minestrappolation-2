package minestrapteam.minestrappolation.block;

import minestrapteam.minestrappolation.tileentity.TileEntityWorkbench2;
import minestrapteam.minestrappolation.util.MAssetManager;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.BlockWorkbench;
import net.minecraft.block.ITileEntityProvider;
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
		this.setBlockTextureName(MAssetManager.getMachineTexture("CraftingTable"));
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
}
