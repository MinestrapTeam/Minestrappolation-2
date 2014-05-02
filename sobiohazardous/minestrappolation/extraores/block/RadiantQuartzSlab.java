package sobiohazardous.minestrappolation.extraores.block;

import java.util.List;
import java.util.Random;

import net.minecraft.block.BlockSlab;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLiving;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import sobiohazardous.minestrappolation.api.util.MAssetManager;
import sobiohazardous.minestrappolation.extraores.lib.EOBlockManager;

public class RadiantQuartzSlab extends BlockSlab
{
	public static final String[] woodType =
	{ "blackWood" };

	public RadiantQuartzSlab(boolean par2)
	{
		super(par2, Material.rock);
		// setBurnProperties(this.blockID, 5, 20);
		useNeighborBrightness = true;
	}

	public void registerBlockIcons(IIconRegister par1IconRegister)
	{
		this.blockIcon = par1IconRegister.registerIcon(MAssetManager.getEOStoncutterTexture("RadiantQuartz_Raw_0_0"));
	}

	public Item getItemDropped(int par1, Random par2Random, int par3)
	{
		return Item.getItemFromBlock(EOBlockManager.RadiantQuartzSingleSlab);
	}

	protected ItemStack createStackedBlock(int par1)
	{
		return new ItemStack(EOBlockManager.RadiantQuartzSingleSlab, 2, par1 & 7);
	}

	public void getSubBlocks(Item par1, CreativeTabs par2CreativeTabs, List par3List)
	{
		if (par1 != Item.getItemFromBlock(EOBlockManager.RadiantQuartzDoubleSlab))
		{
			par3List.add(new ItemStack(par1, 1, 0));
		}
	}

	@Override
	public String func_150002_b(int par1)
	{
		if ((par1 < 0) || (par1 >= woodType.length))
		{
			par1 = 0;
		}

		return super.getUnlocalizedName() + "." + woodType[par1];
	}

}