package minestrapteam.minestrap_core.item;

import java.util.List;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

public class MCItemMulti extends Item
{
	protected final String[]	iconNames;
	protected IIcon[]			icons;
	protected String			texturePrefix;
	
	public MCItemMulti(String texturePrefix, String[] iconNames)
	{
		this.setHasSubtypes(true);
		this.setMaxDamage(0);
		this.iconNames = iconNames;
		this.texturePrefix = texturePrefix;
	}
	
	@Override
	public IIcon getIconFromDamage(int metadata)
	{
		return this.icons[metadata % this.icons.length];
	}
	
	@Override
	public String getUnlocalizedName(ItemStack stack)
	{
		return super.getUnlocalizedName() + "." + stack.getItemDamage();
	}
	
	@Override
	public void getSubItems(Item item, CreativeTabs tab, List list)
	{
		for (int i = 0; i < this.iconNames.length; ++i)
		{
			list.add(new ItemStack(item, 1, i));
		}
	}
	
	@Override
	public void registerIcons(IIconRegister iconRegister)
	{
		this.icons = new IIcon[this.iconNames.length];
		
		for (int i = 0; i < this.iconNames.length; ++i)
		{
			String s = this.texturePrefix == null ? this.iconNames[i] : this.texturePrefix + ":" + this.iconNames[i];
			this.icons[i] = iconRegister.registerIcon(s);
		}
	}
}
