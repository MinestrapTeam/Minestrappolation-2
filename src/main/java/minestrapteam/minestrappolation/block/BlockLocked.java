package minestrapteam.minestrappolation.block;

import minestrapteam.minestrappolation.common.MCommonProxy;
import minestrapteam.minestrappolation.tileentity.TileEntityLocked;

import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.world.World;

public class BlockLocked extends Block implements ITileEntityProvider
{
	public BlockLocked()
	{
		super(Material.iron);
	}
	
	@Override
	public int getRenderType()
	{
		return MCommonProxy.lockedRenderID;
	}
	
	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ)
	{
		if (!world.isRemote)
		{
			player.addChatMessage(new ChatComponentTranslation("lock.locked"));
			return false;
		}
		return true;
	}
	
	@Override
	public void onBlockClicked(World world, int x, int y, int z, EntityPlayer player)
	{
		if (!world.isRemote)
		{
			player.addChatMessage(new ChatComponentTranslation("lock.locked"));
		}
	}
	
	public boolean isLockable(Block block, int metadata)
	{
		return block == Blocks.chest;
	}
	
	public boolean lock(String owner, World world, int x, int y, int z)
	{
		Block block = world.getBlock(x, y, z);
		int metadata = world.getBlockMetadata(x, y, z);
		
		if (!this.isLockable(block, metadata))
		{
			return false;
		}
		
		TileEntity tileEntity = world.getTileEntity(x, y, z);
		TileEntityLocked locked = new TileEntityLocked(owner);
		
		world.setBlock(x, y, z, this, metadata, 3);
		world.setTileEntity(x, y, z, locked);
		
		locked.setBlock(block, tileEntity);
		
		return true;
	}
	
	public boolean unlock(String owner, World world, int x, int y, int z)
	{
		TileEntityLocked locked = (TileEntityLocked) world.getTileEntity(x, y, z);
		if (!locked.isOwner(owner))
		{
			return false;
		}
		
		Block block = locked.getBlock();
		int metadata = world.getBlockMetadata(x, y, z);
		TileEntity tileEntity = locked.getTileEntity();
		
		world.setBlock(x, y, z, block, metadata, 3);
		world.setTileEntity(x, y, z, tileEntity);
		return true;
	}
	
	@Override
	public TileEntity createNewTileEntity(World world, int metadata)
	{
		return new TileEntityLocked();
	}
}
