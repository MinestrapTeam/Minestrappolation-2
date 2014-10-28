package minestrapteam.minestrappolation.spell;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import clashsoft.cslib.minecraft.lang.I18n;
import clashsoft.cslib.util.CSString;
import minestrapteam.minestrappolation.spell.data.SpellCategory;
import minestrapteam.minestrappolation.spell.data.SpellEnhancement;
import minestrapteam.minestrappolation.spell.data.SpellType;
import minestrapteam.minestrappolation.spell.variety.SpellVariety;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
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
	private transient int			rarity;
	
	private transient List<String>	tooltip;
	
	public Spell(SpellCategory category, SpellVariety variety, SpellEnhancement enhancement, int[] potencies)
	{
		this(null, category, variety, enhancement, potencies);
	}
	
	public Spell(String name, SpellCategory category, SpellVariety variety, SpellEnhancement enhancement, int[] potencies)
	{
		this.category = category;
		this.variety = variety;
		this.enhancement = enhancement;
		this.setPotencies(potencies);
		
		if (name == null)
		{
			random.setSeed(this.hashCode());
			this.name = SpellHandler.getRandomName(random);
		}
		else
		{
			this.name = name;
		}
	}
	
	public Spell setPotencies(int[] potencies)
	{
		this.potencies = SpellRecipes.combinePotencies(potencies);
		
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
				float f1 = potency / 100F;
				
				if (f1 > 1F)
				{
					f1 = 1F;
				}
				
				r += (color >> 16 & 0xFF) * f1;
				g += (color >> 8 & 0xFF) * f1;
				b += (color >> 0 & 0xFF) * f1;
				totalPotency += potency;
				f += f1;
			}
		}
		
		r /= f;
		g /= f;
		b /= f;
		
		this.rarity = totalPotency / 100;
		
		this.displayColor = ((int) r & 0xFF) << 16 | ((int) g & 0xFF) << 8 | ((int) b & 0xFF) << 0;
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
	
	public int getTotalPotency()
	{
		return this.totalPotency;
	}
	
	public int getDisplayColor()
	{
		return this.displayColor;
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
		
		list.add(this.getDisplayName());
		list.add("\u00a77\u00a7o" + I18n.getString("spell.info", CSString.convertToRoman(this.rarity + 1), this.variety.getDisplayName()));
		
		if (this.enhancement != null)
		{
			list.add("\u00a77" + I18n.getString("spell.enhancement", this.enhancement.getDisplayName()));
		}
		
		if (this.totalPotency > 0)
		{
			list.add("");
			
			int count = 0;
			
			for (int i = 0; i < this.potencies.length; i++)
			{
				int potency = this.potencies[i];
				if (potency <= 0)
				{
					continue;
				}
				
				SpellType type = SpellType.get(i);
				list.add(type.chatColor + I18n.getString(type.getUnlocalizedName() + ".potency", potency));
				count++;
			}
			
			if (count > 1)
			{
				list.add(EnumChatFormatting.AQUA + I18n.getString("spell.total_potency", this.totalPotency));
			}
		}
		else
		{
			list.add(EnumChatFormatting.RED + I18n.getString("spell.no_potency"));
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
		return SpellHandler.spellBackgrounds[this.rarity > 5 ? 5 : this.rarity];
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
	
	public void onSpellRightClick(PlayerSpells spells, EntityPlayer player)
	{
		int[] manaLevels = spells.manaLevels;
		int[] maxManaLevels = spells.maxManaLevels;
		
		if (!player.capabilities.isCreativeMode)
		{
			// Consume Mana
			for (int i = 0; i < SpellType.spellTypes.length; i++)
			{
				int potency = this.potencies[i];
				if (potency > 0 && !SpellHandler.consumeMana(manaLevels, i, potency))
				{
					// Spell cannot be cast
					return;
				}
			}
		}
		
		// Cast Spell
		if (!this.castSpell(player))
		{
			// Do not increase max mana levels
			return;
		}
		
		// Increase Max Mana Levels
		for (int i = 0; i < SpellType.spellTypes.length; i++)
		{
			int potency = this.potencies[i];
			if (potency > 0 && random.nextInt(10) == 0)
			{
				maxManaLevels[i]++;
			}
		}
	}
	
	public boolean castSpell(EntityPlayer player)
	{
		this.variety.cast(player, this);
		return true;
	}
	
	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + (this.category == null ? 0 : this.category.hashCode());
		result = prime * result + (this.variety == null ? 0 : this.variety.hashCode());
		result = prime * result + (this.enhancement == null ? 0 : this.enhancement.hashCode());
		result = prime * result + Arrays.hashCode(this.potencies);
		return result;
	}
	
	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
		{
			return true;
		}
		if (obj == null)
		{
			return false;
		}
		if (this.getClass() != obj.getClass())
		{
			return false;
		}
		Spell other = (Spell) obj;
		if (this.category != other.category)
		{
			return false;
		}
		if (this.enhancement != other.enhancement)
		{
			return false;
		}
		if (this.variety != other.variety)
		{
			return false;
		}
		if (!Arrays.equals(this.potencies, other.potencies))
		{
			return false;
		}
		return true;
	}
	
	@Override
	public String toString()
	{
		StringBuilder builder = new StringBuilder();
		builder.append("Spell [name=").append(this.name);
		builder.append(", category=").append(this.category);
		builder.append(", variety=").append(this.variety);
		builder.append(", enhancement=").append(this.enhancement);
		builder.append(", potencies=").append(Arrays.toString(this.potencies)).append("]");
		return builder.toString();
	}
}
