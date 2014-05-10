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
	public static final String[]	stainedBrickTextures	= new String[] { MAssetManager.getEDTextureSC("Clay_Bricks_0_Black"), MAssetManager.getEDTextureSC("Clay_Bricks_0_Blue"), MAssetManager.getEDTextureSC("Clay_Bricks_0_Brown"), MAssetManager.getEDTextureSC("Clay_Bricks_0_Cyan"), MAssetManager.getEDTextureSC("Clay_Bricks_0_Green"), MAssetManager.getEDTextureSC("Clay_Bricks_0_Grey"), MAssetManager.getEDTextureSC("Clay_Bricks_0_LightBlue"), MAssetManager.getEDTextureSC("Clay_Bricks_0_Lime"), MAssetManager.getEDTextureSC("Clay_Bricks_0_Magenta"), MAssetManager.getEDTextureSC("Clay_Bricks_0_Orange"), MAssetManager.getEDTextureSC("Clay_Bricks_0_Pink"), MAssetManager.getEDTextureSC("Clay_Bricks_0_Purple"), MAssetManager.getEDTextureSC("Clay_Bricks_0_Red"), MAssetManager.getEDTextureSC("Clay_Bricks_0_Silver"),
			MAssetManager.getEDTextureSC("Clay_Bricks_0_White"), MAssetManager.getEDTextureSC("Clay_Bricks_0_Yellow") };
	
	public BlockStainedBrick()
	{
		super(Material.rock);
		this.setCreativeTab(EDBlocks.tabBlocks);
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
