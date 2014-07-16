package minestrapteam.mcore.block;

import minestrapteam.mcore.MinestrappolationCore;
import minestrapteam.mcore.tileentity.TileEntityStonecutter;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
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
	}
	
	@Override
	public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase player, ItemStack stack)
	{
		TileEntityStonecutter tile = (TileEntityStonecutter) world.getTileEntity(x, y, z);
		int l = MathHelper.floor_double(player.rotationYaw * 4.0F / 360.0F + 0.5D) & 3;
		
		if (l == 0)
		{
			tile.direction = 180;
		}
		
		if (l == 1)
		{
			tile.direction = 270;
		}
		
		if (l == 2)
		{
			tile.direction = 0;
		}
		
		if (l == 3)
		{
			tile.direction = 90;
		}
	}
}