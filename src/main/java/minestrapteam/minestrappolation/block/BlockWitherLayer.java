package minestrapteam.minestrappolation.block;

import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import minestrapteam.minestrappolation.lib.MItems;
import minestrapteam.minestrappolation.util.MAssetManager;

import net.minecraft.block.BlockSnow;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;

public class BlockWitherLayer extends BlockSnow
{
	public BlockWitherLayer()
	{
		super();
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister iconRegister)
	{
		this.blockIcon = iconRegister.registerIcon(MAssetManager.getMineralTexture("wither_ash_block"));
	}
	
	@Override
	public Item getItemDropped(int metadata, Random random, int fortune)
	{
		return MItems.witherAsh;
	}
}