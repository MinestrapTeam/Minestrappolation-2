package sobiohazardous.mods.minestrappolation.core.block;

import sobiohazardous.mods.minestrappolation.core.MinestrappolationCore;
import sobiohazardous.mods.minestrappolation.core.tileentity.TileEntityStonecutter;
import sobiohazardous.mods.minestrappolation.core.util.MCAssetManager;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class MCBlockStonecutter extends BlockContainer
{
	public MCBlockStonecutter()
	{
		super(Material.rock);
		this.setCreativeTab(MinestrappolationCore.creativeTabStone);
	}
	
	@Override
	public void registerBlockIcons(IIconRegister iconRegister)
	{
		this.blockIcon = iconRegister.registerIcon(MCAssetManager.getMAPITexture("stonecutter"));
	}
	
	@Override
	public TileEntity createNewTileEntity(World world, int metadata)
	{
		return new TileEntityStonecutter();
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
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ)
	{
		if (world.isRemote)
		{
			return true;
		}
		else
		{
			if (world.getTileEntity(x, y, z) instanceof TileEntityStonecutter)
			{
				player.openGui(MinestrappolationCore.instance, 0, world, x, y, z);
			}
			
			return true;
		}
	}
	
	@Override
	public void onBlockAdded(World world, int x, int y, int z)
	{
		super.onBlockAdded(world, x, y, z);
		this.setDefaultDirection(world, x, y, z);
	}
	
	private void setDefaultDirection(World world, int x, int y, int z)
	{
		if (!world.isRemote)
		{
			Block l = world.getBlock(x, y, z - 1);
			Block i1 = world.getBlock(x, y, z + 1);
			Block j1 = world.getBlock(x - 1, y, z);
			Block k1 = world.getBlock(x + 1, y, z);
			byte b0 = 3;
			
			if (!Block.isEqualTo(l, i1))
			{
				b0 = 3;
			}
			
			if (!Block.isEqualTo(i1, l))
			{
				b0 = 2;
			}
			
			if (!Block.isEqualTo(j1, k1))
			{
				b0 = 5;
			}
			
			if (!Block.isEqualTo(k1, j1))
			{
				b0 = 4;
			}
			
			world.setBlockMetadataWithNotify(x, y, z, b0, 2);
		}
	}
	
	@Override
	public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase player, ItemStack stack)
	{
		int l = MathHelper.floor_double(player.rotationYaw * 4.0F / 360.0F + 0.5D) & 3;
		
		if (l == 0)
		{
			world.setBlockMetadataWithNotify(x, y, z, 2, 2);
		}
		
		if (l == 1)
		{
			world.setBlockMetadataWithNotify(x, y, z, 5, 2);
		}
		
		if (l == 2)
		{
			world.setBlockMetadataWithNotify(x, y, z, 3, 2);
		}
		
		if (l == 3)
		{
			world.setBlockMetadataWithNotify(x, y, z, 4, 2);
		}
	}
}