package minestrapteam.minestrappolation.block;

import minestrapteam.minestrappolation.tileentity.TileEntitySawmill;

import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockSawmill extends MBlockMachine
{
	public BlockSawmill()
	{
		super(Material.wood, "sawmill");
	}
	
	@Override
	public TileEntity createNewTileEntity(World world, int metadata)
	{
		return new TileEntitySawmill();
	}
	
	@Override
	public int getGuiID()
	{
		return 4;
	}
}
