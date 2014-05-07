package sobiohazardous.mods.minestrappolation.core.block;

import java.util.List;

import sobiohazardous.mods.minestrappolation.core.Minestrappolation;
import net.minecraft.block.BlockRotatedPillar;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

public class MBlockMultiPillar extends BlockRotatedPillar
{
	protected IIcon[]	sides;
	protected IIcon[]	top;
	
	private String[]	sidesImg;
	private String[]	topImg;
	
	public MBlockMultiPillar(Material mat, String[] sideImgs, String[] topImgs)
	{
		super(Material.wood);
		this.setCreativeTab(Minestrappolation.creativeTabStone);
		this.sidesImg = sideImgs;
		this.topImg = topImgs;
	}
	
	/**
	 * returns a list of blocks with the same ID, but different meta (eg: wood
	 * returns 4 blocks)
	 */
	@Override
	public void getSubBlocks(Item par1, CreativeTabs par2CreativeTabs, List par3List)
	{
		for (int i = 0; i < this.top.length; i++)
		{
			par3List.add(new ItemStack(par1, 1, i));
		}
	}
	
	@Override
	public void registerBlockIcons(IIconRegister par1IconRegister)
	{
		this.sides = new IIcon[this.sidesImg.length];
		this.top = new IIcon[this.topImg.length];
		
		for (int i = 0; i < this.sides.length; ++i)
		{
			this.sides[i] = par1IconRegister.registerIcon(this.sidesImg[i]);
		}
		
		for (int i = 0; i < this.top.length; ++i)
		{
			this.top[i] = par1IconRegister.registerIcon(this.topImg[i]);
		}
	}
	
	@Override
	protected IIcon getSideIcon(int meta)
	{
		return this.sides[meta % this.sides.length];
	}
	
	@Override
	protected IIcon getTopIcon(int meta)
	{
		return this.top[meta % this.top.length];
	}
}
