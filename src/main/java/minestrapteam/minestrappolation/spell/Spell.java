package minestrapteam.minestrappolation.spell;

import java.util.ArrayList;
import java.util.List;

import clashsoft.cslib.minecraft.lang.I18n;
import clashsoft.cslib.minecraft.util.CSRegistry;
import clashsoft.cslib.util.CSString;
import minestrapteam.minestrappolation.Minestrappolation;
import minestrapteam.minestrappolation.network.ManaLevelPacket;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.EnumRarity;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.IIcon;

public class Spell
{
	public static CSRegistry	spellRegistry	= new CSRegistry();
	
	static
	{
		SpellList.init();
	}
	
	public SpellType			type;
	public SpellCategory		category;
	public EnumRarity			rarity			= EnumRarity.common;
	
	public String				name;
	public String				iconName;
	
	protected IIcon				icon;
	
	public Spell(SpellType type, SpellCategory category, String name)
	{
		this.type = type;
		this.category = category;
		this.name = name;
	}
	
	public static Spell getSpellByName(String name)
	{
		return (Spell) spellRegistry.getObject(name);
	}
	
	public static Spell getSpellByID(int id)
	{
		return (Spell) spellRegistry.getObjectById(id);
	}
	
	protected Spell register()
	{
		SpellList.registerSpell(this, this.name);
		return this;
	}
	
	public Spell setIconName(String name)
	{
		this.iconName = name;
		return this;
	}
	
	public Spell setRarity(EnumRarity rarity)
	{
		this.rarity = rarity;
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
	
	public int getDisplayColor()
	{
		return this.type.color;
	}
	
	public EnumRarity getRarity()
	{
		return this.rarity;
	}
	
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
	
	public void addInformation(List<String> list, int level)
	{
	}
	
	public void registerIcons(IIconRegister iconRegister)
	{
		if (this.iconName != null)
		{
			this.icon = iconRegister.registerIcon(this.iconName);
		}
	}
	
	public IIcon getIcon()
	{
		return this.icon;
	}
	
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
	
	public boolean castSpell(EntityPlayer player)
	{
		System.out.println(this.name);
		return true;
	}
}
