package sobiohazardous.mods.minestrappolation.extradecor.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import sobiohazardous.mods.minestrappolation.core.util.MAssetManager;
import sobiohazardous.mods.minestrappolation.extradecor.tileentity.TileEntityPlate;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

public class BlockPlate extends BlockContainer
{
	public BlockPlate(Material par2Material)
	{
		super(par2Material);
		this.setBlockBounds(1F / 16F, 0F, 1F / 16F, 1F - 1F / 16F, 1F - 1F / 16F * 14F, 1F - 1F / 16F);
	}
	
	@Override
	public void registerBlockIcons(IIconRegister par1IconRegister)
	{
		this.blockIcon = par1IconRegister.registerIcon(MAssetManager.getEDStonecutterTexture("Stone_Tiles_0_0"));
	}
	
	@Override
	public int damageDropped(int par1)
	{
		return par1;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int i, int j)
	{
		return this.blockIcon;
	}
	
	@Override
	public boolean onBlockActivated(World par1World, int par2, int par3, int par4, EntityPlayer par5EntityPlayer, int par6, float par7, float par8, float par9)
	{
		ItemStack currItem = par5EntityPlayer.inventory.getCurrentItem();
		TileEntityPlate te = (TileEntityPlate) par1World.getTileEntity(par2, par3, par4);
		if (currItem != null)
		{
			te.render(true, currItem);
		}
		
		if (!par5EntityPlayer.capabilities.isCreativeMode)
		{
			par5EntityPlayer.inventory.getCurrentItem().stackSize--;
		}
		return true;
	}
	
	@Override
	public int getRenderType()
	{
		return -1;
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
	public TileEntity createNewTileEntity(World var1, int var2)
	{
		return new TileEntityPlate();
	}
	
}
