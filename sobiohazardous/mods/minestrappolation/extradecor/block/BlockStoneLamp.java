package sobiohazardous.mods.minestrappolation.extradecor.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import java.util.List;

import sobiohazardous.mods.minestrappolation.core.lib.MReference;
import sobiohazardous.mods.minestrappolation.extradecor.lib.EDBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

public class BlockStoneLamp extends Block
{
	@SideOnly(Side.CLIENT)
	private IIcon[]					iconArray;
	public static final String[]	stoneLampTextures	= new String[] { MReference.MODID_ED + ":/stoneCutter/Stone_LampGlowstone_0_0", MReference.MODID_ED + ":/stoneCutter/Stone_LampSunstone_0_0" };
	
	public BlockStoneLamp()
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
		list.add(new ItemStack(item, 1, 0));
		list.add(new ItemStack(item, 1, 1));
	}
	
	@Override
	public void registerBlockIcons(IIconRegister iconRegister)
	{
		this.iconArray = new IIcon[stoneLampTextures.length];
		
		for (int i = 0; i < this.iconArray.length; ++i)
		{
			this.iconArray[i] = iconRegister.registerIcon(stoneLampTextures[i]);
		}
	}
}
