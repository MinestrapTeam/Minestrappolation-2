package minestrapteam.minestrappolation.spell;

import static minestrapteam.minestrappolation.spell.SpellAction.*;
import static minestrapteam.minestrappolation.spell.SpellType.*;

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
		waterGun = new Spell(WATER, DEFENSE, "water_gun").register();
		waterShield = new Spell(WATER, ATTACK, "water_shield").register();
		fireBreath = new Spell(FIRE, ATTACK, "fire_breath").register();
		fireWheel = new Spell(FIRE, ATTACK, "fire_wheel").register();
		rockCrusher = new Spell(EARTH, ATTACK, "rock_crusher").register();
		metalShield = new Spell(EARTH, DEFENSE, "metal_shield").register();
		windAttack = new Spell(WIND, ATTACK, "wind_attack").register();
		airStream = new Spell(WIND, DEFENSE, "air_stream").register();
		iceSpikes = new Spell(FROST, ATTACK, "ice_spikes").register();
		iceBall = new Spell(FROST, DEFENSE, "ice_ball").register();
		thunderstorm = new Spell(ELECTRICITY, ATTACK, "thunderstorm").register();
		electroShock = new Spell(ELECTRICITY, ATTACK, "electroshock").register();
		heal = new Spell(LIFE, SPECIAL, "heal").register();
		antiHunger = new Spell(LIFE, SPECIAL, "anti_hunger").register();
		teleport = new Spell(ARCANE, SPECIAL, "teleport").register();
		deathBlast = new Spell(ARCANE, SPECIAL, "death_blast").register();
	}
	
	public static void registerSpell(Spell spell, String name)
	{
		int id = Spell.spellRegistry.getFreeID();
		Spell.spellRegistry.addObject(id, name, spell);
	}
}
