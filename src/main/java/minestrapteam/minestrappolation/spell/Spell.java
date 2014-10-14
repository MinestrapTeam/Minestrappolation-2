package minestrapteam.minestrappolation.spell;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import clashsoft.cslib.minecraft.lang.I18n;
import clashsoft.cslib.random.CSRandom;
import minestrapteam.minestrappolation.spell.data.SpellCategory;
import minestrapteam.minestrappolation.spell.data.SpellEnhancement;
import minestrapteam.minestrappolation.spell.data.SpellType;
import minestrapteam.minestrappolation.spell.data.SpellVariety;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.EnumRarity;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.IIcon;

public class Spell
{
	public static final Random		random	= new Random();
	
	public String					name;
	public SpellCategory			category;
	public SpellVariety				variety;
	public SpellEnhancement			enhancement;
	
	private int[]					potencies;
	
	private transient int			totalPotency;
	private transient int			displayColor;
	private transient EnumRarity	rarity;
	
	private transient List<String>	tooltip;
	
	public Spell(SpellCategory category, SpellVariety variety, SpellEnhancement enhancement, int[] potencies)
	{
		this(null, category, variety, enhancement, potencies);
	}
	
	public Spell(String name, SpellCategory category, SpellVariety variety, SpellEnhancement enhancement, int[] potencies)
	{
		if (name == null)
		{
			name = CSRandom.getNextRandomName(random, 5, 7) + " " + CSRandom.getNextRandomName(random, 5, 7);
		}
		
		this.name = name;
		this.category = category;
		this.variety = variety;
		this.enhancement = enhancement;
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
		
		if (this.rarity == null)
		{
			if (totalPotency >= 1023)
			{
				this.rarity = EnumRarity.epic;
			}
			else if (totalPotency >= 511)
			{
				this.rarity = EnumRarity.rare;
			}
			else if (totalPotency >= 255)
			{
				this.rarity = EnumRarity.uncommon;
			}
			else
			{
				this.rarity = EnumRarity.common;
			}
		}
		
		this.displayColor = (((int) r & 0xFF) << 16) | (((int) g & 0xFF) << 8) | (((int) b & 0xFF) << 0);
		this.totalPotency = totalPotency;
		
		return this;
	}
	
	public int[] getPotencies()
	{
		return this.potencies;
	}
	
	public String getDisplayName()
	{
		return this.name;
	}
	
	public int getDisplayColor()
	{
		return this.displayColor;
	}
	
	public EnumRarity getRarity()
	{
		return this.rarity;
	}
	
	public boolean hasVariety(SpellVariety variety)
	{
		return this.variety == variety;
	}
	
	public List<String> getTooltip()
	{
		if (this.tooltip != null)
		{
			return this.tooltip;
		}
		
		List<String> list = new ArrayList();
		list.add(this.getRarity().rarityColor.toString() + EnumChatFormatting.UNDERLINE + this.getDisplayName());
		list.add(EnumChatFormatting.ITALIC + this.category.getDisplayName() + " " + this.variety.getDisplayName() + " " + I18n.getString("spell.spell"));
		
		if (this.enhancement != null)
		{
			list.add("+ " + this.enhancement.getDisplayName());
		}
		
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
			
			list.add(EnumChatFormatting.AQUA + I18n.getString("spell.total_potency", this.totalPotency));
		}
		
		this.addInformation(list);
		this.tooltip = list;
		
		return list;
	}
	
	public void addInformation(List<String> list)
	{
	}
	
	public void registerIcons(IIconRegister iconRegister)
	{
	}
	
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
		else if (pass == 3)
		{
			return this.enhancement.icon;
		}
		return SpellHandler.spellBackground;
	}
	
	public int getRenderColor(int pass)
	{
		if (pass != 0)
		{
			return this.displayColor;
		}
		return 0xFFFFFF;
	}
	
	public int getRenderPasses()
	{
		return this.enhancement == null ? 3 : 4;
	}
	
	public void onSpellRightClick(PlayerSpells spells, EntityPlayerMP player)
	{
		// TODO Subtract Mana, cast spell
	}
	
	public boolean castSpell(EntityPlayer player)
	{
		// TODO Implementation
		return true;
	}
}
