package sobiohazardous.mods.minestrappolation.extradecor.block;

import sobiohazardous.mods.minestrappolation.core.util.MAssetManager;
import sobiohazardous.mods.minestrappolation.extradecor.ExtraDecor;
import sobiohazardous.mods.minestrappolation.extradecor.tileentity.TileEntityCrate;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockCrate extends BlockBarrel
{
	public BlockCrate()
	{
	}
	
	@Override
	public void registerBlockIcons(IIconRegister iconRegister)
	{
		this.blockIcon = iconRegister.registerIcon(MAssetManager.getEDTexture("crateSide"));
		this.top = iconRegister.registerIcon(MAssetManager.getEDTexture("crateTop"));
	}
	
	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ)
	{
		if (!world.isRemote)
		{
			player.openGui(ExtraDecor.instance, 0, world, x, y, z);
			
			return true;
		}
		return false;
	}
	
	@Override
	public TileEntity createNewTileEntity(World world, int metadata)
	{
		return new TileEntityCrate();
	}
}
