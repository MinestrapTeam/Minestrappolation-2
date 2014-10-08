package minestrapteam.minestrappolation.spell.data;

import java.util.Random;

import clashsoft.cslib.minecraft.lang.I18n;
import minestrapteam.minestrappolation.util.MAssetManager;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;

public class SpellCategory
{
	public static SpellCategory[]		SPELL_CATEGORIES	= new SpellCategory[4];
	
	public static final SpellCategory	OFFENSE				= new SpellCategory(0, "offense");
	public static final SpellCategory	DEFENSE				= new SpellCategory(1, "defense");
	public static final SpellCategory	ALTERATION			= new SpellCategory(2, "alteration");
	public static final SpellCategory	SUMMONING			= new SpellCategory(3, "summoning");
	
	public final int					id;
	public String						name;
	
	public IIcon						icon;
	
	private SpellCategory(int id, String name)
	{
		this.id = id;
		this.name = name;
		
		SPELL_CATEGORIES[id] = this;
	}
	
	public String getUnlocalizedName()
	{
		return "spellcategory." + this.name;
	}
	
	public String getDisplayName()
	{
		return I18n.getString(this.getUnlocalizedName());
	}
	
	public void registerIcons(IIconRegister iconRegister)
	{
		this.icon = iconRegister.registerIcon(MAssetManager.getSpellTexture("category_" + this.name));
	}
	
	public static SpellCategory get(int id)
	{
		return SPELL_CATEGORIES[id];
	}
	
	public static SpellCategory random(Random random)
	{
		return get(random.nextInt(SPELL_CATEGORIES.length));
	}
}
