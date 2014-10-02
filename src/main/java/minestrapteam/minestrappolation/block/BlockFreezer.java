package minestrapteam.minestrappolation.block;

import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockFreezer extends MBlockMachine
{
	public BlockFreezer()
	{
		super(Material.iron, "freezer");
	}

	@Override
	public TileEntity createNewTileEntity(World world, int metadata)
	{
		return null;
	}
	
	@Override
	public void openGUI(EntityPlayer player, World world, int x, int y, int z)
	{
	}
}
