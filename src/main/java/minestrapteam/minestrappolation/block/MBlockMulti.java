package minestrapteam.minestrappolation.block;

import java.util.List;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

public class MBlockMulti extends Block
{
	@SideOnly(Side.CLIENT)
	private IIcon[]		icons;
	private String[]	iconNames;
	
	public MBlockMulti(Material mat, String[] textures)
	{
		super(mat);
		this.iconNames = textures;
	}
	
	@Override
	public IIcon getIcon(int side, int metadata)
	{
		return this.icons[metadata];
	}
	
	@Override
	public int damageDropped(int metadata)
	{
		return metadata;
	}
	
	@Override
	public void getSubBlocks(Item item, CreativeTabs tab, List list)
	{
		for (int i = 0; i < this.iconNames.length; i++)
		{
			list.add(new ItemStack(item, 1, i));
		}
	}
	
	@Override
	public void registerBlockIcons(IIconRegister iconRegister)
	{
		this.icons = new IIcon[this.iconNames.length];
		
		for (int i = 0; i < this.icons.length; ++i)
		{
			this.icons[i] = iconRegister.registerIcon(this.iconNames[i]);
		}
	}
}
