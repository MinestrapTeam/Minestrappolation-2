package minestrapteam.minestrappolation.spell;

import static minestrapteam.minestrappolation.spell.data.SpellCategory.ALTERATION;
import static minestrapteam.minestrappolation.spell.data.SpellCategory.DEFENSE;
import static minestrapteam.minestrappolation.spell.data.SpellCategory.OFFENSE;
import static minestrapteam.minestrappolation.spell.data.SpellType.*;
import static minestrapteam.minestrappolation.spell.data.SpellVariety.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import minestrapteam.minestrappolation.spell.data.SpellCategory;
import minestrapteam.minestrappolation.spell.data.SpellType;
import minestrapteam.minestrappolation.spell.data.SpellVariety;
import minestrapteam.minestrappolation.util.MAssetManager;

public class SpellList
{
	public static final List<ISpell>	spells	= new ArrayList();
	
	public static ISpell				waterGun;
	public static ISpell				waterShield;
	public static ISpell				fireBreath;
	public static ISpell				fireWheel;
	public static ISpell				rockCrusher;
	public static ISpell				metalShield;
	public static ISpell				windAttack;
	public static ISpell				airStream;
	public static ISpell				iceSpikes;
	public static ISpell				iceBall;
	public static ISpell				thunderstorm;
	public static ISpell				electroShock;
	public static ISpell				heal;
	public static ISpell				antiHunger;
	public static ISpell				teleport;
	public static ISpell				deathBlast;
	
	private SpellList()
	{
	}
	
	public static void init()
	{
		int varieties = SpellVariety.SPELL_VARIETIES.length;
		int categories = SpellCategory.SPELL_CATEGORIES.length;
		int types = SpellType.SPELL_TYPES.length;
		for (int v = 0; v < varieties; v++)
		{
			for (int t = 0; t < types; t++)
			{
				for (int c = 0; c < categories; c++)
				{
					SpellCategory category = SpellCategory.get(c);
					SpellVariety variety = SpellVariety.get(v);
					int[] potencies = new int[types];
					potencies[t] = 255;
					spells.add(new Spell(category, variety, potencies));
				}
			}
		}
	}
	
	private static void loadPresets()
	{
		waterGun = new SpellPreset(WATER, DEFENSE, SPRAY, "water_gun").setIconName("bucket_water").register();
		waterShield = new SpellPreset(WATER, OFFENSE, AREA_SHIELD, "water_shield").setIconName("diamond").register();
		fireBreath = new SpellPreset(FIRE, OFFENSE, VORTEX, "fire_breath").setIconName("blaze_powder").register();
		fireWheel = new SpellPreset(FIRE, OFFENSE, VORTEX, "fire_wheel").setIconName("fireball").register();
		rockCrusher = new SpellPreset(EARTH, OFFENSE, PROJECTILE, "rock_crusher").setIconName(MAssetManager.getMineralTexture("stone_chunk")).register();
		metalShield = new SpellPreset(EARTH, DEFENSE, AREA_SHIELD, "metal_shield").setIconName("iron_ingot").register();
		windAttack = new SpellPreset(WIND, OFFENSE, VORTEX, "wind_attack").setIconName("quartz").register();
		airStream = new SpellPreset(WIND, DEFENSE, BEAM, "air_stream").setIconName("bucket_empty").register();
		iceSpikes = new SpellPreset(FROST, OFFENSE, PROJECTILE, "ice_spikes").setIconName("feather").register();
		iceBall = new SpellPreset(FROST, DEFENSE, BODY_ARMOR, "ice_ball").setIconName("snowball").register();
		thunderstorm = new SpellPreset(ELECTRICITY, OFFENSE, BEAM, "thunderstorm").setIconName("book_normal").register();
		electroShock = new SpellPreset(ELECTRICITY, OFFENSE, BEAM, "electroshock").setIconName("paper").register();
		heal = new SpellPreset(LIFE, ALTERATION, BEAM, "heal").setIconName("nether_wart").register();
		antiHunger = new SpellPreset(LIFE, ALTERATION, BEAM, "anti_hunger").setIconName("bread").register();
		teleport = new SpellPreset(ARCANE, ALTERATION, BEAM, "teleport").setIconName("ender_pearl").register();
		deathBlast = new SpellPreset(ARCANE, ALTERATION, BEAM, "death_blast").setIconName("skull_skeleton").register();
	}
	
	public static Spell getRandomSpell(String name, Random random)
	{
		SpellCategory category = SpellCategory.random(random);
		SpellVariety variety = SpellVariety.random(random);
		int type = random.nextInt(SpellType.SPELL_TYPES.length);
		int[] potencies = new int[8];
		potencies[type] = 255;
		
		return new Spell(category, variety, potencies, name);
	}
}
