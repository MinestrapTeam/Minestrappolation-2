package minestrapteam.minestrappolation.spell;

import java.io.IOException;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import minestrapteam.minestrappolation.spell.data.SpellCategory;
import minestrapteam.minestrappolation.spell.data.SpellEnhancement;
import minestrapteam.minestrappolation.spell.data.SpellType;
import minestrapteam.minestrappolation.spell.data.SpellVariety;
import minestrapteam.minestrappolation.util.MAssetManager;

import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.IIcon;

public class SpellHandler
{
	@SideOnly(Side.CLIENT)
	public static IIcon	spellBackground;
	
	public static void registerIcons(TextureMap textureMap)
	{
		if (textureMap.getTextureType() == 0)
		{
			return;
		}
		
		spellBackground = textureMap.registerIcon(MAssetManager.getSpellTexture("background"));
		
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
	
	public static void writeToBuffer(Spell spell, PacketBuffer buffer) throws IOException
	{
		buffer.writeStringToBuffer(spell.name);
		buffer.writeByte(spell.variety.id);
		buffer.writeByte(spell.enhancement.id);
		
		for (int i = 0; i < spell.potencies.length; i++)
		{
			buffer.writeInt(spell.potencies[i]);
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
		
		return new Spell(variety, enhancement, potencies, name);
	}
}
