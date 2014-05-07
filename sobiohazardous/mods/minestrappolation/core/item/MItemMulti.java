package sobiohazardous.mods.minestrappolation.core.item;

import java.util.List;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;

public class MItemMulti extends Item
{
	private final String[]	types;
	private IIcon[]			icons;
	
	public MItemMulti(String[] textures)
	{
		this.setHasSubtypes(true);
		this.setMaxDamage(0);
		this.types = textures;
	}
	
	@Override
	public IIcon getIconFromDamage(int par1)
	{
		int var2 = MathHelper.clamp_int(par1, 0, 15);
		return this.icons[var2];
	}
	
	@Override
	public String getUnlocalizedName(ItemStack par1ItemStack)
	{
		return super.getUnlocalizedName() + "." + par1ItemStack.getItemDamage();
	}
	
	@Override
	public void getSubItems(Item p_150895_1_, CreativeTabs p_150895_2_, List p_150895_3_)
	{
		for (int var4 = 0; var4 < this.types.length; ++var4)
		{
			p_150895_3_.add(new ItemStack(p_150895_1_, 1, var4));
		}
	}
	
	@Override
	public void registerIcons(IIconRegister par1IconRegister)
	{
		this.icons = new IIcon[this.types.length];
		
		for (int var2 = 0; var2 < this.types.length; ++var2)
		{
			this.icons[var2] = par1IconRegister.registerIcon(this.types[var2]);
		}
	}
}
