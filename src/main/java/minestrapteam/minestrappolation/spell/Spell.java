package minestrapteam.minestrappolation.spell;

import clashsoft.cslib.minecraft.lang.I18n;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;

public class Spell
{
	public static final Spell	test	= new Spell("test");
	
	public String				name;
	public String				iconName;
	
	protected IIcon				icon;
	
	public Spell(String name)
	{
		this.name = name;
	}
	
	public Spell setIconName(String name)
	{
		this.iconName = name;
		return this;
	}
	
	public String getUnlocalizedName()
	{
		return "spell." + this.name;
	}
	
	public String getDisplayName()
	{
		return I18n.getString(this.getUnlocalizedName() + ".name");
	}
	
	public void registerIcons(IIconRegister register)
	{
		this.icon = register.registerIcon(this.iconName);
	}
}
