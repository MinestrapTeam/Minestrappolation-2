package sobiohazardous.mods.minestrappolation.block;

import java.util.Random;

import sobiohazardous.mods.minestrappolation.core.util.MCAssetManager;
import sobiohazardous.mods.minestrappolation.core.util.MCUtil;
import sobiohazardous.mods.minestrappolation.lib.MItems;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;

public class BlockCardboard extends Block
{
	private IIcon	top;
	
	public BlockCardboard(Material material)
	{
		super(material);
	}
	
	@Override
	public int getFlammability(IBlockAccess world, int x, int y, int z, ForgeDirection face)
	{
		return 255;
	}
	
	@Override
	public IIcon getIcon(int side, int metadata)
	{
		if (side == 0)
		{
			return this.blockIcon;
		}
		else if (side == 1)
		{
			return this.top;
		}
		
		return this.blockIcon;
	}
	
	@Override
	public void registerBlockIcons(IIconRegister iconRegister)
	{
		this.blockIcon = iconRegister.registerIcon(MCAssetManager.getEDTexture("cardboard"));
		this.top = iconRegister.registerIcon(MCAssetManager.getEDTexture("cardboardTop"));
	}
	
	@Override
	public Item getItemDropped(int metadata, Random random, int fortune)
	{
		return MItems.cardboardItem;
	}
	
	@Override
	public void onNeighborBlockChange(World world, int x, int y, int z, Block neighbor)
	{
		this.checkDryness(world, x, y, z);
	}
	
	@Override
	public void updateTick(World world, int x, int y, int z, Random random)
	{
		this.checkDryness(world, x, y, z);
	}
	
	public void checkDryness(World world, int x, int y, int z)
	{
		if (MCUtil.isWaterTouchingAnySide(world, x, y, z))
		{
			world.setBlockMetadataWithNotify(x, y, z, 1, 2);
		}
		else
		{
			world.setBlockMetadataWithNotify(x, y, z, 0, 2);
		}
	}
}
