package sobiohazardous.mods.minestrappolation.extraores.block;

import java.util.List;
import java.util.Random;

import net.minecraft.block.BlockSlab;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import sobiohazardous.mods.minestrappolation.core.util.MAssetManager;
import sobiohazardous.mods.minestrappolation.extraores.lib.EOBlocks;

public class TinPlatedGraniteBrickSlab extends BlockSlab
{
	public static final String[]	woodType	= { "tinPlatedGraniteBrick" };
	
	public TinPlatedGraniteBrickSlab(boolean par2)
	{
		super(par2, Material.rock);
		// setBurnProperties(this.blockID, 5, 20);
		this.useNeighborBrightness = true;
	}
	
	@Override
	public void registerBlockIcons(IIconRegister par1IconRegister)
	{
		this.blockIcon = par1IconRegister.registerIcon(MAssetManager.getEOStonecutterTexture("Granite_Bricks_0_Tin"));
	}
	
	@Override
	public Item getItemDropped(int par1, Random par2Random, int par3)
	{
		return Item.getItemFromBlock(EOBlocks.tinPlatedGraniteBrickSingleSlab);
	}
	
	@Override
	protected ItemStack createStackedBlock(int par1)
	{
		return new ItemStack(EOBlocks.tinPlatedGraniteBrickSingleSlab, 2, par1 & 7);
	}
	
	@Override
	public String func_150002_b(int par1)
	{
		if (par1 < 0 || par1 >= woodType.length)
		{
			par1 = 0;
		}
		
		return super.getUnlocalizedName() + "." + woodType[par1];
	}
	
	@Override
	public void getSubBlocks(Item par1, CreativeTabs par2CreativeTabs, List par3List)
	{
		if (par1 != Item.getItemFromBlock(EOBlocks.tinPlatedGraniteBrickDoubleSlab))
		{
			par3List.add(new ItemStack(par1, 1, 0));
		}
	}
	
}