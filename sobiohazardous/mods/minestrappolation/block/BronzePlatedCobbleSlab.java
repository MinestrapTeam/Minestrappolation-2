package sobiohazardous.mods.minestrappolation.block;

import java.util.List;
import java.util.Random;

import net.minecraft.block.BlockSlab;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import sobiohazardous.mods.minestrappolation.core.util.MCAssetManager;
import sobiohazardous.mods.minestrappolation.lib.MBlocks;

public class BronzePlatedCobbleSlab extends BlockSlab
{
	public static final String[]	woodType	= { "bronzePlatedCobble" };
	
	public BronzePlatedCobbleSlab(boolean par2)
	{
		super(par2, Material.rock);
		// setBurnProperties(this, 5, 20);
		this.useNeighborBrightness = true;
	}
	
	@Override
	public void registerBlockIcons(IIconRegister par1IconRegister)
	{
		this.blockIcon = par1IconRegister.registerIcon(MCAssetManager.getSCTexture("Stone_Cobbled_0_Bronze"));
	}
	
	@Override
	public Item getItemDropped(int par1, Random par2Random, int par3)
	{
		return Item.getItemFromBlock(MBlocks.bronzePlatedCobbleSingleSlab);
	}
	
	@Override
	protected ItemStack createStackedBlock(int par1)
	{
		return new ItemStack(MBlocks.bronzePlatedCobbleSingleSlab, 2, par1 & 7);
	}
	
	@Override
	public void getSubBlocks(Item par1, CreativeTabs par2CreativeTabs, List par3List)
	{
		if (par1 != Item.getItemFromBlock(MBlocks.bronzePlatedCobbleDoubleSlab))
		{
			par3List.add(new ItemStack(par1, 1, 0));
		}
	}
	
	@Override
	public String func_150002_b(int p_150002_1_)
	{
		if (p_150002_1_ < 0 || p_150002_1_ >= woodType.length)
		{
			p_150002_1_ = 0;
		}
		
		return super.getUnlocalizedName() + "." + woodType[p_150002_1_];
	}
	
}