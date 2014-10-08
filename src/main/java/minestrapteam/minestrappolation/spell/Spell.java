package minestrapteam.minestrappolation.spell;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import clashsoft.cslib.minecraft.lang.I18n;
import clashsoft.cslib.random.CSRandom;
import minestrapteam.minestrappolation.spell.data.SpellCategory;
import minestrapteam.minestrappolation.spell.data.SpellType;
import minestrapteam.minestrappolation.spell.data.SpellVariety;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.EnumRarity;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.IIcon;

public class Spell implements ISpell
{
	public static final Random	random	= new Random();
	
	public String				name;
	public SpellCategory		category;
	public SpellVariety			variety;
	
	protected int[]				potencies;
	
	private int					totalPotency;
	private int					displayColor;
	
	public Spell(SpellCategory category, SpellVariety variety, int[] potencies)
	{
		this(category, variety, potencies, CSRandom.getNextRandomName(random, 5, 8));
	}
	
	public Spell(SpellCategory category, SpellVariety variety, int[] potencies, String name)
	{
		this.name = name;
		this.category = category;
		this.variety = variety;
		this.setPotencies(potencies);
	}
	
	public Spell setPotencies(int[] potencies)
	{
		this.potencies = potencies;
		
		float r = 0F;
		float g = 0F;
		float b = 0F;
		float f = 0F;
		int len = this.potencies.length;
		int totalPotency = 0;
		
		if (len == 0)
		{
			this.displayColor = 0;
			this.totalPotency = 0;
			
			return this;
		}
		
		for (int i = 0; i < len; i++)
		{
			int potency = this.potencies[i];
			if (potency > 0)
			{
				int color = SpellType.get(i).color;
				float f1 = potency / 255F;
				
				if (f1 > 1F)
				{
					f1 = 1F;
				}
				
				r += ((color >> 16) & 0xFF) * f1;
				g += ((color >> 8) & 0xFF) * f1;
				b += ((color >> 0) & 0xFF) * f1;
				totalPotency += potency;
				f += f1;
			}
		}
		
		r /= f;
		g /= f;
		b /= f;
		
		this.displayColor = (((int) r & 0xFF) << 16) | (((int) g & 0xFF) << 8) | (((int) b & 0xFF) << 0);
		this.totalPotency = totalPotency;
		
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
		list.add(EnumChatFormatting.ITALIC + this.category.getDisplayName() + " " + this.variety.getDisplayName() + " " + I18n.getString("spell.spell"));
		
		if (this.totalPotency > 0)
		{
			for (int i = 0; i < this.potencies.length; i++)
			{
				int potency = this.potencies[i];
				if (potency <= 0)
				{
					continue;
				}
				
				SpellType type = SpellType.get(i);
				list.add(type.chatColor + I18n.getString(type.getUnlocalizedName() + ".potency", potency));
			}
			
			list.add(EnumChatFormatting.GOLD + I18n.getString("spell.total_potency", this.totalPotency));
		}
		
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
		if (pass != 0)
		{
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
