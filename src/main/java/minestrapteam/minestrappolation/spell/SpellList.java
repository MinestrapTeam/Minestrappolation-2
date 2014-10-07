package minestrapteam.minestrappolation.spell;

import static minestrapteam.minestrappolation.spell.SpellAction.*;
import static minestrapteam.minestrappolation.spell.SpellType.*;
import minestrapteam.minestrappolation.util.MAssetManager;

public class SpellList
{
	public static Spell	waterGun;
	public static Spell	waterShield;
	public static Spell	fireBreath;
	public static Spell	fireWheel;
	public static Spell	rockCrusher;
	public static Spell	metalShield;
	public static Spell	windAttack;
	public static Spell airStream;
	public static Spell	iceSpikes;
	public static Spell	iceBall;
	public static Spell	thunderstorm;
	public static Spell	electroShock;
	public static Spell	heal;
	public static Spell	antiHunger;
	public static Spell	teleport;
	public static Spell	deathBlast;
	
	private SpellList()
	{
	}
	
	public static void init()
	{
		waterGun = new Spell(WATER, DEFENSE, "water_gun").setIconName("bucket_water").register();
		waterShield = new Spell(WATER, ATTACK, "water_shield").setIconName("diamond").register();
		fireBreath = new Spell(FIRE, ATTACK, "fire_breath").setIconName("blaze_powder").register();
		fireWheel = new Spell(FIRE, ATTACK, "fire_wheel").setIconName("fireball").register();
		rockCrusher = new Spell(EARTH, ATTACK, "rock_crusher").setIconName(MAssetManager.getMineralTexture("stone_chunk")).register();
		metalShield = new Spell(EARTH, DEFENSE, "metal_shield").setIconName("iron_ingot").register();
		windAttack = new Spell(WIND, ATTACK, "wind_attack").setIconName("quartz").register();
		airStream = new Spell(WIND, DEFENSE, "air_stream").setIconName("bucket_empty").register();
		iceSpikes = new Spell(FROST, ATTACK, "ice_spikes").setIconName("feather").register();
		iceBall = new Spell(FROST, DEFENSE, "ice_ball").setIconName("snowball").register();
		thunderstorm = new Spell(ELECTRICITY, ATTACK, "thunderstorm").setIconName("book_normal").register();
		electroShock = new Spell(ELECTRICITY, ATTACK, "electroshock").setIconName("paper").register();
		heal = new Spell(LIFE, SPECIAL, "heal").setIconName("nether_wart").register();
		antiHunger = new Spell(LIFE, SPECIAL, "anti_hunger").setIconName("bread").register();
		teleport = new Spell(ARCANE, SPECIAL, "teleport").setIconName("ender_pearl").register();
		deathBlast = new Spell(ARCANE, SPECIAL, "death_blast").setIconName("skull_skeleton").register();
	}
	
	public static void registerSpell(Spell spell, String name)
	{
		int id = Spell.spellRegistry.getFreeID();
		Spell.spellRegistry.addObject(id, name, spell);
	}
}
