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
	
	public static String getRandomName(Random random)
	{
		return CSRandom.getNextRandomName(random, 5, 7) + " " + CSRandom.getNextRandomName(random, 5, 7);
	}
	
	public static void writeToNBT(Spell spell, NBTTagCompound nbt)
	{
		nbt.setString("Name", spell.name);
		nbt.setByte("Variety", spell.variety.id);
		nbt.setByte("Enhancement", spell.enhancement.id);
		nbt.setIntArray("Potencies", spell.getPotencies());
	}
	
	public static Spell readFromNBT(NBTTagCompound nbt)
	{
		String name = nbt.getString("Name");
		SpellVariety variety = SpellVariety.get(nbt.getByte("Variety"));
		SpellEnhancement enhancement = SpellEnhancement.get(nbt.getByte("Enhancement"));
		int[] potencies = nbt.getIntArray("Potencies");
		return new Spell(name, variety.category, variety, enhancement, potencies);
	}
	
	public static void writeToBuffer(Spell spell, PacketBuffer buffer) throws IOException
	{
		buffer.writeStringToBuffer(spell.name);
		buffer.writeByte(spell.variety.id);
		buffer.writeByte(spell.enhancement.id);
		
		int[] potencies = spell.getPotencies();
		for (int i = 0; i < SpellType.spellTypes.length; i++)
		{
			buffer.writeInt(potencies[i]);
		}
	}
	
	public static Spell readFromBuffer(PacketBuffer buffer) throws IOException
	{
		String name = buffer.readStringFromBuffer(0xFF);
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
