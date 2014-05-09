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
	
	public BlockStainedBrick()
	{
		super(Material.rock);
		this.setCreativeTab(EDBlocks.tabDecor);
	}
	
	@Override
	public IIcon getIcon(int side, int metadata)
	{
		return this.iconArray[metadata % this.iconArray.length];
	}
	
	@Override
	public int damageDropped(int metadata)
	{
		return metadata;
	}
	
	@Override
	public void getSubBlocks(Item item, CreativeTabs tab, List list)
	{
		for (int i = 0; i < 16; i++)
		{
			list.add(new ItemStack(item, 1, i));
		}
	}
	
	@Override
	public void registerBlockIcons(IIconRegister iconRegister)
	{
		this.iconArray = new IIcon[stainedBrickTextures.length];
		
		for (int i = 0; i < this.iconArray.length; ++i)
		{
			this.iconArray[i] = iconRegister.registerIcon(stainedBrickTextures[i]);
		}
	}
}
