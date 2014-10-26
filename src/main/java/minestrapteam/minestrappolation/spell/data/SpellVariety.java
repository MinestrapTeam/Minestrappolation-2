package minestrapteam.minestrappolation.spell.data;

import static minestrapteam.minestrappolation.spell.data.SpellCategory.ALTERATION;
import static minestrapteam.minestrappolation.spell.data.SpellCategory.DEFENSE;
import static minestrapteam.minestrappolation.spell.data.SpellCategory.OFFENSE;
import static minestrapteam.minestrappolation.spell.data.SpellCategory.SUMMONING;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import clashsoft.cslib.minecraft.lang.I18n;
import minestrapteam.minestrappolation.spell.PlayerSpells;
import minestrapteam.minestrappolation.spell.Spell;
import minestrapteam.minestrappolation.spell.SpellList;
import minestrapteam.minestrappolation.spell.SpellVarietyProjectile;
import minestrapteam.minestrappolation.util.MAssetManager;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.IIcon;

public class SpellVariety
{
	public static SpellVariety[]		spellVarieties				= new SpellVariety[16];
	
	public static final SpellVariety	PROJECTILE					= new SpellVarietyProjectile(0, "projectile");
	public static final SpellVariety	BEAM						= new SpellVariety(1, OFFENSE, "beam");
	public static final SpellVariety	SPRAY						= new SpellVariety(2, OFFENSE, "spray");
	public static final SpellVariety	VORTEX						= new SpellVariety(3, OFFENSE, "vortex");
	public static final SpellVariety	BODY_ARMOR					= new SpellVariety(4, DEFENSE, "body_armor");
	public static final SpellVariety	ABRASIVE_ARMOR				= new SpellVariety(5, DEFENSE, "abrasive_armor");
	public static final SpellVariety	MIRROR_SHIELD				= new SpellVariety(6, DEFENSE, "mirror_shield");
	public static final SpellVariety	AREA_SHIELD					= new SpellVariety(7, DEFENSE, "area_shield");
	public static final SpellVariety	POWER_BOOST					= new SpellVariety(8, ALTERATION, "power_boost");
	public static final SpellVariety	DEBUFF						= new SpellVariety(9, ALTERATION, "debuff");
	public static final SpellVariety	BLOCK_TRANSFORMATION		= new SpellVariety(10, ALTERATION, "block_transformation");
	public static final SpellVariety	ENVIRONMENT_TRANSFORMATION	= new SpellVariety(11, ALTERATION, "environment_transformation");
	public static final SpellVariety	SUMMON_TOOL					= new SpellVariety(12, SUMMONING, "summon_tool");
	public static final SpellVariety	SUMMON_WEAPON				= new SpellVariety(13, SUMMONING, "summon_weapon");
	public static final SpellVariety	SUMMON_BLOCK				= new SpellVariety(14, SUMMONING, "summon_block");
	public static final SpellVariety	SUMMON_MOB					= new SpellVariety(15, SUMMONING, "summon_mob");
	
	public final byte					id;
	public final int					bit;
	
	public SpellCategory				category;
	public String						name;
	
	public IIcon						icon;
	
	public SpellVariety(int id, SpellCategory category, String name)
	{
		this.id = (byte) id;
		this.bit = 1 << id;
		this.category = category;
		this.name = name;
		
		spellVarieties[id] = this;
	}
	
	public String getUnlocalizedName()
	{
		return "spellvariety." + this.name;
	}
	
	public String getDisplayName()
	{
		return I18n.getString(this.getUnlocalizedName());
	}
	
	public void registerIcons(IIconRegister iconRegister)
	{
		this.icon = iconRegister.registerIcon(MAssetManager.getSpellTexture("variety_" + this.name));
	}
	
	public void cast(EntityPlayer player, Spell spell)
	{
		
	}
	
	public List<Spell> getSpells(PlayerSpells spells)
	{
		List<Spell> list = new ArrayList();
		
		Iterator<? extends Spell> iterator;
		if (spells.player.capabilities.isCreativeMode)
		{
			iterator = SpellList.spells.iterator();
		}
		else
		{
			iterator = spells.spells.iterator();
		}
		while (iterator.hasNext())
		{
			Spell spell = iterator.next();
			if (spell.hasVariety(this))
			{
				list.add(spell);
			}
		}
		
		return list;
	}
	
	@Override
	public boolean equals(Object obj)
	{
		return this == obj;
	}
	
	@Override
	public int hashCode()
	{
		return this.id;
	}
	
	@Override
	public String toString()
	{
		return this.name;
	}
	
	public static SpellVariety get(int id)
	{
		return spellVarieties[id];
	}
	
	public static SpellVariety random(Random random)
	{
		return get(random.nextInt(spellVarieties.length));
	}
}
