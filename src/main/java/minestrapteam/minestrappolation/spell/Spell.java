package minestrapteam.minestrappolation.spell;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import clashsoft.cslib.random.CSRandom;
import minestrapteam.minestrappolation.spell.data.SpellCategory;
import minestrapteam.minestrappolation.spell.data.SpellVariety;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.EnumRarity;
import net.minecraft.util.IIcon;

public class Spell implements ISpell
{
	public static final Random	random			= new Random();
	
	public String				name;
	public SpellCategory		category;
	public SpellVariety			variety;
	
	protected int[]				potencies;
	
	private int					totalPotency;
	private int					displayColor	= -1;
	
	public Spell(SpellCategory category, SpellVariety variety, int[] potencies)
	{
		this(category, variety, potencies, CSRandom.getNextRandomName(random, 5, 8));
	}
	
	public Spell(SpellCategory category, SpellVariety variety, int[] potencies, String name)
	{
		this.name = name;
		this.category = category;
		this.variety = variety;
		this.potencies = potencies;
	}
	
	public Spell setPotencies(int[] potencies)
	{
		this.potencies = potencies;
		// FIXME
		this.displayColor = 0x0000FF;
		return this;
	}
	
	@Override
	public String getDisplayName()
	{
		return this.name;
	}
	
	@Override
	public int getDisplayColor()
	{
		return this.displayColor;
	}
	
	@Override
	public EnumRarity getRarity()
	{
		return EnumRarity.common;
	}
	
	@Override
	public boolean hasVariety(SpellVariety variety)
	{
		return this.variety == variety;
	}
	
	@Override
	public List<String> getTooltip(int level)
	{
		List<String> list = new ArrayList();
		list.add(this.getRarity().rarityColor + this.getDisplayName());
		return list;
	}
	
	@Override
	public void addInformation(List<String> list, int level)
	{
	}
	
	@Override
	public void registerIcons(IIconRegister iconRegister)
	{
	}
	
	@Override
	public IIcon getIcon(int pass)
	{
		if (pass == 1)
		{
			return this.category.icon;
		}
		else if (pass == 2)
		{
			return this.variety.icon;
		}
		return SpellHandler.SPELL_BACKGROUND;
	}
	
	@Override
	public int getRenderColor(int pass)
	{
		if (pass != 0) {
			return this.displayColor;
		}
		return 0xFFFFFF;
	}
	
	@Override
	public int getRenderPasses()
	{
		return 3;
	}
	
	@Override
	public void onSpellRightClick(PlayerSpells spells, EntityPlayerMP player)
	{
		
	}
	
	@Override
	public boolean castSpell(EntityPlayer player)
	{
		System.out.println(this.name);
		return true;
	}
}
