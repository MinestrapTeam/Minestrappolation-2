package minestrapteam.minestrappolation.spell;

import java.io.IOException;
import java.util.Iterator;

import minestrapteam.minestrappolation.spell.data.SpellCategory;
import minestrapteam.minestrappolation.spell.data.SpellVariety;

import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.network.PacketBuffer;

public class SpellHandler
{
	public static void registerIcons(TextureMap textureMap)
	{
		if (textureMap.getTextureType() == 0)
		{
			return;
		}
		
		Iterator<SpellPreset> iterator = SpellPreset.presets.values().iterator();
		while (iterator.hasNext())
		{
			SpellPreset spell = iterator.next();
			spell.registerIcons(textureMap);
		}
	}
	
	public static void writeToBuffer(ISpell spell, PacketBuffer buffer) throws IOException
	{
		if (spell instanceof SpellPreset)
		{
			buffer.writeByte(1);
			buffer.writeStringToBuffer(((SpellPreset) spell).name);
		}
		else if (spell instanceof Spell)
		{
			Spell spell1 = (Spell) spell;
			buffer.writeByte(0);
			buffer.writeStringToBuffer(spell1.name);
			buffer.writeByte(spell1.category.id);
			buffer.writeByte(spell1.variety.id);
			
			for (int i = 0; i < 8; i++)
			{
				buffer.writeInt(spell1.potencies[i]);
			}
		}
	}
	
	public static ISpell readFromBuffer(PacketBuffer buffer) throws IOException
	{
		byte b = buffer.readByte();
		String s = buffer.readStringFromBuffer(0xFF);
		if (b == 1)
		{
			return SpellPreset.presets.get(s);
		}
		
		SpellCategory category = SpellCategory.get(buffer.readByte());
		SpellVariety variety = SpellVariety.get(buffer.readByte());
		int[] potencies = new int[8];
		for (int i = 0; i < 8; i++)
		{
			potencies[i] = buffer.readInt();
		}
		
		return new Spell(category, variety, potencies, s);
	}
}
