package minestrapteam.minestrappolation.block.machine;

import cpw.mods.fml.common.network.internal.FMLNetworkHandler;
import minestrapteam.minestrappolation.Minestrappolation;
import minestrapteam.minestrappolation.block.MBlockMachine;
import minestrapteam.minestrappolation.tileentity.TileEntitySawmill;
import minestrapteam.minestrappolation.util.MAssetManager;

import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

public class BlockSawmill extends MBlockMachine
{
	public BlockSawmill()
	{
		super(Material.wood, "sawmill");
	}
	
	@Override
	public void registerBlockIcons(IIconRegister iconRegister)
	{
		this.blockIcon = iconRegister.registerIcon(MAssetManager.getMachineTexture("carpenters_bench"));
	}
	
	@Override
	public IIcon getIcon(int side, int metadata)
	{
		return this.blockIcon;
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
	
	@Override
	public void setFacing(World world, int x, int y, int z, int l)
	{
		world.setBlockMetadataWithNotify(x, y, z, l + 2 & 3, 2);
	}
}
