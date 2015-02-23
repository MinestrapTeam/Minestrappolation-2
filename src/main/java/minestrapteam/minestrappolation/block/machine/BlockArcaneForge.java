package minestrapteam.minestrappolation.block.machine;

import cpw.mods.fml.common.network.internal.FMLNetworkHandler;
import minestrapteam.minestrappolation.Minestrappolation;
import minestrapteam.minestrappolation.tileentity.TileEntityArcaneForge;
import minestrapteam.minestrappolation.util.MAssetManager;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

public class BlockArcaneForge extends BlockContainer
{
	public IIcon	topIcon;
	public IIcon	bottomIcon;
	
	public BlockArcaneForge()
	{
		super(Material.rock);
	}
	
	@Override
	public IIcon getIcon(int side, int metadata)
	{
		if (side == 0)
		{
			return this.topIcon;
		}
		else if (side == 1)
		{
			return this.bottomIcon;
		}
		return this.blockIcon;
	}
	
	@Override
	public void registerBlockIcons(IIconRegister iconRegister)
	{
		this.blockIcon = iconRegister.registerIcon(MAssetManager.getMachineTexture("arcane_forge_side"));
		this.topIcon = iconRegister.registerIcon(MAssetManager.getMachineTexture("arcane_forge_top"));
		this.bottomIcon = iconRegister.registerIcon(MAssetManager.getMachineTexture("arcane_forge_bottom"));
	}
	
	@Override
	public TileEntity createNewTileEntity(World world, int metadata)
	{
		return new TileEntityArcaneForge();
	}
	
	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ)
	{
		if (!world.isRemote)
		{
			FMLNetworkHandler.openGui(player, Minestrappolation.instance, 7, world, x, y, z);
		}
		return true;
	}
}
