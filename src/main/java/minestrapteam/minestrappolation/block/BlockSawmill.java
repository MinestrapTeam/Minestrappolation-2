package minestrapteam.minestrappolation.block;

import cpw.mods.fml.common.network.internal.FMLNetworkHandler;
import minestrapteam.minestrappolation.Minestrappolation;
import minestrapteam.minestrappolation.tileentity.TileEntitySawmill;

import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockSawmill extends MBlockMachine
{
	public BlockSawmill()
	{
		super(Material.wood, "sawmill");
		this.setBlockBounds(0F, 0F, 0F, 1F, 0.9375F, 1F);
	}
	
	@Override
	public TileEntity createNewTileEntity(World world, int metadata)
	{
		return new TileEntitySawmill();
	}
	
	@Override
	public void openGUI(EntityPlayer player, World world, int x, int y, int z)
	{
		if (world.getTileEntity(x, y, z) instanceof TileEntitySawmill)
		{
			FMLNetworkHandler.openGui(player, Minestrappolation.instance, 4, world, x, y, z);
		}
	}
}
