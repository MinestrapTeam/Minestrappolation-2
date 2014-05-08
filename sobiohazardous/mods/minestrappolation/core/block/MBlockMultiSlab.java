package sobiohazardous.mods.minestrappolation.core.block;

import java.util.List;
import java.util.Random;

import net.minecraft.block.BlockSlab;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

public class MBlockMultiSlab extends BlockSlab
{
	private IIcon[]		sideIcons;
	private IIcon[]		topIcons;
	
	private String[]	sideIconNames;
	private String[]	topIconNames;
	
	public MBlockMultiSlab(boolean isDouble, String[] sideIconNames, String[] topIconNames)
	{
		super(isDouble, Material.rock);
		this.sideIconNames = sideIconNames;
		this.topIconNames = topIconNames;
	}
	
	@Override
	public IIcon getIcon(int side, int meta)
	{
		int var3 = meta & 12;
		int var4 = meta & 3;
		if (this.field_150004_a)
		{
			return var3 == 0 && (side == 1 || side == 0) ? this.topIcons[var4] : this.sideIcons[var4];
		}
		return var3 == 0 && (side == 1 || side == 0) ? this.topIcons[var4] : var3 == 4 && (side == 5 || side == 4) ? this.sideIcons[var4] : var3 == 8 && (side == 2 || side == 3) ? this.sideIcons[var4] : this.topIcons[var4];
	}
	
	@Override
	public void registerBlockIcons(IIconRegister iconRegister)
	{
		this.sideIcons = new IIcon[this.sideIconNames.length];
		this.topIcons = new IIcon[this.topIconNames.length];
		
		for (int i = 0; i < this.sideIcons.length; ++i)
		{
			this.sideIcons[i] = iconRegister.registerIcon(this.sideIconNames[i]);
		}
		
		for (int i = 0; i < this.topIcons.length; ++i)
		{
			this.topIcons[i] = iconRegister.registerIcon(this.topIconNames[i]);
		}
	}
	
	@Override
	public Item getItemDropped(int metadata, Random random, int fortune)
	{
		// TODO this should be a single slab somehow.
		return Item.getItemFromBlock(this);
	}
	
	@Override
	protected ItemStack createStackedBlock(int meta)
	{
		// TODO This should be the single slab somehow.
		return new ItemStack(this, 2, meta);
	}
	
	@Override
	public String func_150002_b(int meta)
	{
		if (meta < 0 || meta >= this.topIconNames.length)
		{
			meta = 0;
		}
		
		return super.getUnlocalizedName() + "." + meta;
	}
	
	@Override
	public void getSubBlocks(Item item, CreativeTabs tab, List list)
	{
		for (int i = 0; i < this.topIconNames.length; i++)
		{
			list.add(new ItemStack(item, 1, i));
		}
	}
}
