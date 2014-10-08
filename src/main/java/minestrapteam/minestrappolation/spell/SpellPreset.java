package minestrapteam.minestrappolation.spell;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import clashsoft.cslib.minecraft.lang.I18n;
import clashsoft.cslib.util.CSString;
import minestrapteam.minestrappolation.Minestrappolation;
import minestrapteam.minestrappolation.network.ManaLevelPacket;
import minestrapteam.minestrappolation.spell.data.SpellCategory;
import minestrapteam.minestrappolation.spell.data.SpellType;
import minestrapteam.minestrappolation.spell.data.SpellVariety;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.EnumRarity;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.IIcon;

public class SpellPreset implements ISpell
{
	public static Map<String, ISpell>	presets	= new HashMap();
	
	public SpellType					type;
	public SpellCategory				category;
	public SpellVariety					variety;
	public EnumRarity					rarity	= EnumRarity.common;
	
	public String						name;
	
	public String						iconName;
	protected IIcon						icon;
	
	public SpellPreset(SpellType type, SpellCategory category, SpellVariety variety, String name)
	{
		this.type = type;
		this.category = category;
		this.variety = variety;
		this.name = name;
	}
	
	public SpellPreset register()
	{
		presets.put(this.name, this);
		SpellList.spells.add(this);
		return this;
	}
	
	public SpellPreset setIconName(String name)
	{
		this.iconName = name;
		return this;
	}
	
	public SpellPreset setRarity(EnumRarity rarity)
	{
		this.rarity = rarity;
		return this;
	}
	
	public String getUnlocalizedName()
	{
		return "spell." + this.name;
	}
	
	@Override
	public String getDisplayName()
	{
		return I18n.getString(this.getUnlocalizedName() + ".name");
	}
	
	@Override
	public int getDisplayColor()
	{
		return this.type.color;
	}
	
	@Override
	public EnumRarity getRarity()
	{
		return this.rarity;
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
		StringBuilder buf = new StringBuilder(20);
		
		buf.append(this.getRarity().rarityColor).append(this.getDisplayName());
		if (level > 0)
		{
			buf.append(' ').append(CSString.convertToRoman(level + 1));
		}
		
		list.add(buf.toString());
		buf.delete(0, buf.length());
		
		buf.append(this.type.chatColor).append(EnumChatFormatting.ITALIC);
		buf.append(this.category.getDisplayName()).append(' ');
		buf.append(this.type.getDisplayName()).append(' ');
		buf.append(I18n.getString("spell.spell"));
		
		list.add(buf.toString());
		this.addInformation(list, level);
		
		return list;
	}
	
	@Override
	public void addInformation(List<String> list, int level)
	{
	}
	
	@Override
	public void registerIcons(IIconRegister iconRegister)
	{
		if (this.iconName != null)
		{
			this.icon = iconRegister.registerIcon(this.iconName);
		}
	}
	
	@Override
	public IIcon getIcon(int pass)
	{
		return this.icon;
	}
	
	@Override
	public int getRenderColor(int pass)
	{
		return 0xFFFFFF;
	}
	
	@Override
	public int getRenderPasses()
	{
		return 1;
	}
	
	@Override
	public void onSpellRightClick(PlayerSpells spells, EntityPlayerMP player)
	{
		int i = this.type.id;
		if (spells.manaLevels[i] > 0)
		{
			spells.manaLevels[i]--;
			if (this.castSpell(player))
			{
				spells.maxManaLevels[i]++;
			}
			
			Minestrappolation.instance.netHandler.sendTo(new ManaLevelPacket(i, spells), player);
		}
	}
	
	@Override
	public boolean castSpell(EntityPlayer player)
	{
		return false;
	}
}
