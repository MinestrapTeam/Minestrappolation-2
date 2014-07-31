package minestrapteam.minestrappolation.block;

import minestrapteam.minestrappolation.tileentity.TileEntityStonecutter;

import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockStonecutter extends MBlockMachine
{
	public BlockStonecutter()
	{
		super(Material.rock, "stonecutter");
		this.setBlockBounds(0F, 0F, 0F, 1F, 0.9375F, 1F);
	}
	
	@Override
	public TileEntity createNewTileEntity(World world, int metadata)
	{
		return new TileEntityStonecutter();
	}
	
	@Override
	public int getGuiID()
	{
		return 3;
	}
}