package minestrapteam.minestrappolation.spell.data;

import java.util.Random;

import clashsoft.cslib.minecraft.lang.I18n;
import minestrapteam.minestrappolation.spell.variety.SpellVariety;
import minestrapteam.minestrappolation.util.MAssetManager;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;

import static minestrapteam.minestrappolation.spell.variety.SpellVariety.*;

public class SpellEnhancement
{
	public static SpellEnhancement[]		spellEnhancements		= new SpellEnhancement[16];
	
	public static final SpellEnhancement	DAMAGE_OVER_TIME		= new SpellEnhancement(0, "damage_over_time", PROJECTILE.bit | BEAM.bit | SPRAY.bit | VORTEX.bit);
	public static final SpellEnhancement	DAMAGE_BOOST			= new SpellEnhancement(1, "damage_boost", PROJECTILE.bit | BEAM.bit | SPRAY.bit | VORTEX.bit | ABRASIVE_ARMOR.bit);
	public static final SpellEnhancement	EXPLOSIVE_IMPACT		= new SpellEnhancement(2, "explosive_impact", PROJECTILE.bit);
	public static final SpellEnhancement	KNOCKBACK				= new SpellEnhancement(3, "knockback", PROJECTILE.bit | BEAM.bit | SPRAY.bit);
	public static final SpellEnhancement	VACUUM					= new SpellEnhancement(4, "vacuum", VORTEX.bit);
	public static final SpellEnhancement	PROTECTION_BOOST		= new SpellEnhancement(5, "protection_boost", BODY_ARMOR.bit | AREA_SHIELD.bit);
	public static final SpellEnhancement	INCREASED_RADIUS		= new SpellEnhancement(6, "increased_radius", ABRASIVE_ARMOR.bit);
	public static final SpellEnhancement	POLISHED_MIRROR			= new SpellEnhancement(7, "polished_mirror", MIRROR_SHIELD.bit);
	public static final SpellEnhancement	PROJECTILE_RANGE_BOOST	= new SpellEnhancement(8, "projectile_range_boost", POWER_BOOST.bit | DEBUFF.bit | BLOCK_TRANSFORMATION.bit | ENVIRONMENT_TRANSFORMATION.bit);
	public static final SpellEnhancement	AREA_RANGE_BOOST		= new SpellEnhancement(9, "area_range_boost", POWER_BOOST.bit | DEBUFF.bit | BLOCK_TRANSFORMATION.bit | ENVIRONMENT_TRANSFORMATION.bit);
	public static final SpellEnhancement	POTENCY_BOOST			= new SpellEnhancement(10, "potency_boost", POWER_BOOST.bit | DEBUFF.bit | BLOCK_TRANSFORMATION.bit);
	public static final SpellEnhancement	WEAPON_BOOST			= new SpellEnhancement(11, "weapon_boost", SUMMON_TOOL.bit | SUMMON_WEAPON.bit);
	public static final SpellEnhancement	INCREASED_MINING_SPEED	= new SpellEnhancement(12, "increased_mining_speed", SUMMON_TOOL.bit | SUMMON_WEAPON.bit);
	public static final SpellEnhancement	SUMMON_ALTERNATE		= new SpellEnhancement(13, "summon_alternate", SUMMON_BLOCK.bit);
	public static final SpellEnhancement	INCREASED_LIFESPAN		= new SpellEnhancement(14, "increased_lifespan", SUMMON_BLOCK.bit);
	public static final SpellEnhancement	DOUBLE_SPAWN			= new SpellEnhancement(15, "double_spawn", SUMMON_MOB.bit);
	
	public final byte						id;
	public String							name;
	public int								varieties;
	
	public IIcon							icon;
	
	private SpellEnhancement(int id, String name, int varieties)
	{
		this.id = (byte) id;
		this.name = name;
		this.varieties = varieties;
		
		spellEnhancements[id] = this;
	}
	
	public String getUnlocalizedName()
	{
		return "spellenhancement." + this.name;
	}
	
	public String getDisplayName()
	{
		return I18n.getString(this.getUnlocalizedName());
	}
	
	public void registerIcons(IIconRegister iconRegister)
	{
		this.icon = iconRegister.registerIcon(MAssetManager.getSpellTexture("enhancement_" + this.name));
	}
	
	public boolean canApply(SpellVariety variety)
	{
		return (this.varieties & variety.bit) != 0;
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
	
	public static SpellEnhancement get(int id)
	{
		return spellEnhancements[id];
	}
	
	public static SpellEnhancement random(Random random)
	{
		return get(random.nextInt(spellEnhancements.length));
	}
}
