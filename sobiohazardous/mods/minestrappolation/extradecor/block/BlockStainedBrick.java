package sobiohazardous.mods.minestrappolation.extradecor.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import java.util.List;

import sobiohazardous.mods.minestrappolation.core.util.MAssetManager;
import sobiohazardous.mods.minestrappolation.extradecor.lib.EDBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

public class BlockStainedBrick extends Block
{
	@SideOnly(Side.CLIENT)
	private IIcon[]					iconArray;
	public static final String[]	stainedBrickTextures	= new String[] { MAssetManager.getEDStonecutterTexture("Clay_Bricks_0_Black"), MAssetManager.getEDStonecutterTexture("Clay_Bricks_0_Blue"), MAssetManager.getEDStonecutterTexture("Clay_Bricks_0_Brown"), MAssetManager.getEDStonecutterTexture("Clay_Bricks_0_Cyan"), MAssetManager.getEDStonecutterTexture("Clay_Bricks_0_Green"), MAssetManager.getEDStonecutterTexture("Clay_Bricks_0_Grey"), MAssetManager.getEDStonecutterTexture("Clay_Bricks_0_LightBlue"), MAssetManager.getEDStonecutterTexture("Clay_Bricks_0_Lime"), MAssetManager.getEDStonecutterTexture("Clay_Bricks_0_Magenta"), MAssetManager.getEDStonecutterTexture("Clay_Bricks_0_Orange"), MAssetManager.getEDStonecutterTexture("Clay_Bricks_0_Pink"), MAssetManager.getEDStonecutterTexture("Clay_Bricks_0_Purple"), MAssetManager.getEDStonecutterTexture("Clay_Bricks_0_Red"), MAssetManager.getEDStonecutterTexture("Clay_Bricks_0_Silver"),
			MAssetManager.getEDStonecutterTexture("Clay_Bricks_0_White"), MAssetManager.getEDStonecutterTexture("Clay_Bricks_0_Yellow") };
	
	// public static final String[] stainedBrickTextures =
	// MAssetManager.getMaterialStringArray(MAPIReference.MODID_ED, "Clay",
	// "Bricks");
	
	public BlockStainedBrick()
	{
		super(Material.rock);
		this.setCreativeTab(EDBlocks.tabDecor);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	/**
	 * From the specified side and block metadata retrieves the blocks texture. Args: side, metadata
	 */
	public IIcon getIcon(int par1, int par2)
	{
		if (par2 < 0 || par2 >= this.iconArray.length)
		{
			par2 = 0;
		}
		
		return this.iconArray[par2];
	}
	
	/**
	 * Determines the damage on the item the block drops. Used in cloth and
	 * wood.
	 */
	@Override
	public int damageDropped(int par1)
	{
		return par1;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	/**
	 * returns a list of blocks with the same ID, but different meta (eg: wood returns 4 blocks)
	 */
	public void getSubBlocks(Item par1, CreativeTabs par2CreativeTabs, List par3List)
	{
		par3List.add(new ItemStack(par1, 1, 0));
		par3List.add(new ItemStack(par1, 1, 1));
		par3List.add(new ItemStack(par1, 1, 2));
		par3List.add(new ItemStack(par1, 1, 3));
		par3List.add(new ItemStack(par1, 1, 4));
		par3List.add(new ItemStack(par1, 1, 5));
		par3List.add(new ItemStack(par1, 1, 6));
		par3List.add(new ItemStack(par1, 1, 7));
		par3List.add(new ItemStack(par1, 1, 8));
		par3List.add(new ItemStack(par1, 1, 9));
		par3List.add(new ItemStack(par1, 1, 10));
		par3List.add(new ItemStack(par1, 1, 11));
		par3List.add(new ItemStack(par1, 1, 12));
		par3List.add(new ItemStack(par1, 1, 13));
		par3List.add(new ItemStack(par1, 1, 14));
		par3List.add(new ItemStack(par1, 1, 15));
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	/**
	 * When this method is called, your block should register all the icons it needs with the given IconRegister. This
	 * is the only chance you get to register icons.
	 */
	public void registerBlockIcons(IIconRegister par1IconRegister)
	{
		this.iconArray = new IIcon[stainedBrickTextures.length];
		
		for (int i = 0; i < this.iconArray.length; ++i)
		{
			this.iconArray[i] = par1IconRegister.registerIcon(stainedBrickTextures[i]);
		}
	}
}
