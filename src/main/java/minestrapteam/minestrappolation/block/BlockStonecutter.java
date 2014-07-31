package minestrapteam.minestrappolation.block;

import cpw.mods.fml.common.network.internal.FMLNetworkHandler;
import minestrapteam.minestrappolation.Minestrappolation;
import minestrapteam.minestrappolation.tileentity.TileEntityStonecutter;

import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
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
	public void openGUI(EntityPlayer player, World world, int x, int y, int z)
	{
		if (world.getTileEntity(x, y, z) instanceof TileEntityStonecutter)
		{
			FMLNetworkHandler.openGui(player, Minestrappolation.instance, 3, world, x, y, z);
		}
	}
}