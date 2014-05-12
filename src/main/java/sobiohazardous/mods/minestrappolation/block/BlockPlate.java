package sobiohazardous.mods.minestrappolation.block;

import sobiohazardous.mods.minestrappolation.core.util.MCAssetManager;
import sobiohazardous.mods.minestrappolation.tileentity.TileEntityPlate;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockPlate extends BlockContainer
{
	public BlockPlate(Material material)
	{
		super(material);
		this.setBlockBounds(0.0625F, 0F, 0.0625F, 0.9375F, 0.125F, 0.9375F);
	}
	
	@Override
	public void registerBlockIcons(IIconRegister iconRegister)
	{
		this.blockIcon = iconRegister.registerIcon(MCAssetManager.getTexture("plate"));
	}
	
	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ)
	{
		if (!world.isRemote)
		{
			ItemStack stack = player.inventory.getCurrentItem();
			if (stack != null)
			{
				TileEntityPlate te = (TileEntityPlate) world.getTileEntity(x, y, z);
				if (stack != null)
				{
					te.setItem(stack);
				}
				
				if (!player.capabilities.isCreativeMode)
				{
					stack.stackSize--;
				}
			}
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
	public TileEntity createNewTileEntity(World world, int metadata)
	{
		return new TileEntityPlate();
	}
	
}
