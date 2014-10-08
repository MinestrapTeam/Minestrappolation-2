package minestrapteam.minestrappolation.spell;

import static minestrapteam.minestrappolation.spell.data.SpellCategory.*;
import static minestrapteam.minestrappolation.spell.data.SpellType.*;
import minestrapteam.minestrappolation.util.MAssetManager;

public class SpellList
{
	public static ISpell	waterGun;
	public static ISpell	waterShield;
	public static ISpell	fireBreath;
	public static ISpell	fireWheel;
	public static ISpell	rockCrusher;
	public static ISpell	metalShield;
	public static ISpell	windAttack;
	public static ISpell airStream;
	public static ISpell	iceSpikes;
	public static ISpell	iceBall;
	public static ISpell	thunderstorm;
	public static ISpell	electroShock;
	public static ISpell	heal;
	public static ISpell	antiHunger;
	public static ISpell	teleport;
	public static ISpell	deathBlast;
	
	private SpellList()
	{
	}
	
	public static void init()
	{
		waterGun = new SpellPreset(WATER, DEFENSE, "water_gun").setIconName("bucket_water").register();
		waterShield = new SpellPreset(WATER, ATTACK, "water_shield").setIconName("diamond").register();
		fireBreath = new SpellPreset(FIRE, ATTACK, "fire_breath").setIconName("blaze_powder").register();
		fireWheel = new SpellPreset(FIRE, ATTACK, "fire_wheel").setIconName("fireball").register();
		rockCrusher = new SpellPreset(EARTH, ATTACK, "rock_crusher").setIconName(MAssetManager.getMineralTexture("stone_chunk")).register();
		metalShield = new SpellPreset(EARTH, DEFENSE, "metal_shield").setIconName("iron_ingot").register();
		windAttack = new SpellPreset(WIND, ATTACK, "wind_attack").setIconName("quartz").register();
		airStream = new SpellPreset(WIND, DEFENSE, "air_stream").setIconName("bucket_empty").register();
		iceSpikes = new SpellPreset(FROST, ATTACK, "ice_spikes").setIconName("feather").register();
		iceBall = new SpellPreset(FROST, DEFENSE, "ice_ball").setIconName("snowball").register();
		thunderstorm = new SpellPreset(ELECTRICITY, ATTACK, "thunderstorm").setIconName("book_normal").register();
		electroShock = new SpellPreset(ELECTRICITY, ATTACK, "electroshock").setIconName("paper").register();
		heal = new SpellPreset(LIFE, ALTERATION, "heal").setIconName("nether_wart").register();
		antiHunger = new SpellPreset(LIFE, ALTERATION, "anti_hunger").setIconName("bread").register();
		teleport = new SpellPreset(ARCANE, ALTERATION, "teleport").setIconName("ender_pearl").register();
		deathBlast = new SpellPreset(ARCANE, ALTERATION, "death_blast").setIconName("skull_skeleton").register();
	}
}
