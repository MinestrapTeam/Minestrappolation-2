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
	public static final Random	random	= new Random();
	
	static
	{
		SpellList.init();
	}
	
	public String				name;
	public SpellCategory		category;
	public SpellVariety			variety;
	
	public int[]				potencies;
	
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
	
	@Override
	public String getDisplayName()
	{
		return this.name;
	}
	
	@Override
	public int getDisplayColor()
	{
		return 0xFFFFFF;
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
		return null;
	}
	
	@Override
	public int getRenderPasses()
	{
		return 1;
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
