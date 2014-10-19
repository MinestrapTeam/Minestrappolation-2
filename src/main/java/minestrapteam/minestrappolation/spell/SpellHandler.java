package minestrapteam.minestrappolation.spell;

import java.io.IOException;
import java.util.Random;

import clashsoft.cslib.random.CSRandom;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import minestrapteam.minestrappolation.spell.data.SpellCategory;
import minestrapteam.minestrappolation.spell.data.SpellEnhancement;
import minestrapteam.minestrappolation.spell.data.SpellType;
import minestrapteam.minestrappolation.spell.data.SpellVariety;
import minestrapteam.minestrappolation.util.MAssetManager;

import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.IIcon;

public class SpellHandler
{
	// ICONS
	
	@SideOnly(Side.CLIENT)
	public static IIcon[]	spellBackgrounds;
	
	public static void registerIcons(TextureMap textureMap)
	{
		if (textureMap.getTextureType() == 0)
		{
			return;
		}
		
		spellBackgrounds = new IIcon[6];
		for (int i = 0; i < 6; i++)
		{
			spellBackgrounds[i] = textureMap.registerIcon(MAssetManager.getSpellTexture("background_" + i));
		}
		
		for (SpellCategory category : SpellCategory.spellCategories)
		{
			if (category != null)
			{
				category.registerIcons(textureMap);
			}
		}
		
		for (SpellVariety variety : SpellVariety.spellVarieties)
		{
			if (variety != null)
			{
				variety.registerIcons(textureMap);
			}
		}
		
		for (SpellEnhancement enhancement : SpellEnhancement.spellEnhancements)
		{
			if (enhancement != null)
			{
				enhancement.registerIcons(textureMap);
			}
		}
	}
	
	// NAMES
	
	public static String getRandomName(Random random)
	{
		return CSRandom.getNextRandomName(random, 5, 7) + " " + CSRandom.getNextRandomName(random, 5, 7);
	}
	
	// MANA
	
	public static boolean consumeMana(int[] manaLevels, int type, int potency)
	{
		int amount = potency / 100;
		
		if ((amount = tryConsumeMana(manaLevels, type, amount)) != 0)
		{
			amount *= 2;
			if (type == SpellType.WATER.id)
			{
				return tryConsumeMana(manaLevels, SpellType.FROST.id, amount) == 0 & tryConsumeMana(manaLevels, SpellType.FIRE.id, amount) == 0;
			}
			else if (type == SpellType.WIND.id)
			{
				return tryConsumeMana(manaLevels, SpellType.WATER.id, amount) == 0 & tryConsumeMana(manaLevels, SpellType.FIRE.id, amount) == 0;
			}
			else if (type == SpellType.FROST.id)
			{
				return tryConsumeMana(manaLevels, SpellType.WATER.id, amount) == 0 & tryConsumeMana(manaLevels, SpellType.WIND.id, amount) == 0;
			}
			else if (type == SpellType.ELECTRICITY.id)
			{
				return tryConsumeMana(manaLevels, SpellType.FIRE.id, amount) == 0 & tryConsumeMana(manaLevels, SpellType.ARCANE.id, amount) == 0;
			}
			
			return false;
		}
		
		return true;
	}
	
	public static int tryConsumeMana(int[] manaLevels, int type, int amount)
	{
		if (manaLevels[type] >= amount)
		{
			manaLevels[type] -= amount;
			return 0;
		}
		amount -= manaLevels[type];
		manaLevels[type] = 0;
		return amount;
	}
	
	// SERIALIZATION
	
	public static void writeToNBT(Spell spell, NBTTagCompound nbt)
	{
		if (spell == null)
		{
			return;
		}
		
		nbt.setString("Name", spell.name);
		nbt.setByte("Variety", spell.variety.id);
		nbt.setByte("Enhancement", spell.enhancement.id);
		nbt.setIntArray("Potencies", spell.getPotencies());
	}
	
	public static Spell readFromNBT(NBTTagCompound nbt)
	{
		String name = nbt.getString("Name");
		if (name.isEmpty())
		{
			return null;
		}
		
		SpellVariety variety = SpellVariety.get(nbt.getByte("Variety"));
		SpellEnhancement enhancement = SpellEnhancement.get(nbt.getByte("Enhancement"));
		int[] potencies = nbt.getIntArray("Potencies");
		return new Spell(name, variety.category, variety, enhancement, potencies);
	}
	
	public static void writeToBuffer(Spell spell, PacketBuffer buffer) throws IOException
	{
		try
		{
			if (spell == null)
			{
				buffer.writeStringToBuffer("");
				return;
			}
			
			buffer.writeStringToBuffer(spell.name);
			buffer.writeByte(spell.variety.id);
			buffer.writeByte(spell.enhancement.id);
			
			int[] potencies = spell.getPotencies();
			for (int i = 0; i < SpellType.spellTypes.length; i++)
			{
				buffer.writeInt(potencies[i]);
			}
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
		}
	}
	
	public static Spell readFromBuffer(PacketBuffer buffer) throws IOException
	{
		String name = buffer.readStringFromBuffer(0xFF);
		
		if (name.isEmpty())
		{
			return null;
		}
		
		SpellVariety variety = SpellVariety.get(buffer.readByte());
		SpellEnhancement enhancement = SpellEnhancement.get(buffer.readByte());
		
		int len = SpellType.spellTypes.length;
		int[] potencies = new int[len];
		for (int i = 0; i < len; i++)
		{
			potencies[i] = buffer.readInt();
		}
		
		return new Spell(name, variety.category, variety, enhancement, potencies);
	}
}
