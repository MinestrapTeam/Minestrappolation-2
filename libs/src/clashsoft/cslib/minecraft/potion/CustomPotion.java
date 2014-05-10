package clashsoft.cslib.minecraft.potion;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

import clashsoft.cslib.reflect.CSReflection;
import clashsoft.cslib.util.CSArrays;
import clashsoft.cslib.util.CSLog;

import net.minecraft.client.Minecraft;
import net.minecraft.potion.Potion;
import net.minecraft.util.ResourceLocation;

/**
 * The Class CustomPotion.
 */
public class CustomPotion extends Potion
{
	private ResourceLocation	iconFile;
	private boolean				instant;
	private int					customColor	= -1;
	private boolean				bad;
	
	public CustomPotion(String name, int color, boolean bad)
	{
		this(getNextFreeID(), name, color, bad);
	}
	
	public CustomPotion(int id, String name, int color, boolean bad)
	{
		super(id, bad, color);
		this.setPotionName(name);
		this.bad = bad;
	}
	
	public CustomPotion setIcon(ResourceLocation iconFile, int x, int y)
	{
		this.iconFile = iconFile;
		this.setIconIndex(x, y);
		return this;
	}
	
	public CustomPotion setCustomColor(int color)
	{
		if (color > 0)
		{
			this.customColor = color;
		}
		return this;
	}
	
	public CustomPotion setIsInstant(boolean instant)
	{
		this.instant = instant;
		return this;
	}
	
	@Override
	public int getStatusIconIndex()
	{
		if (this.iconFile != null)
		{
			Minecraft.getMinecraft().renderEngine.bindTexture(this.iconFile);
		}
		return super.getStatusIconIndex();
	}
	
	public int getCustomColor()
	{
		return this.customColor;
	}
	
	@Override
	public boolean isInstant()
	{
		return this.instant;
	}
	
	@Override
	public boolean isBadEffect()
	{
		return this.bad;
	}
	
	public static int getNextFreeID()
	{
		int id = CSArrays.indexOf(potionTypes, null);
		if (id == -1)
		{
			int len = potionTypes.length;
			expandPotionList(len * 2);
			return len;
		}
		return id;
	}
	
	public static void expandPotionList(int size)
	{
		if (Potion.potionTypes.length < size)
		{
			try
			{
				Field f = CSReflection.getField(Potion.class, 0);
				CSReflection.setModifier(f, Modifier.FINAL, false);
				Potion[] potionTypes = new Potion[size];
				System.arraycopy(Potion.potionTypes, 0, potionTypes, 0, Potion.potionTypes.length);
				f.set(null, potionTypes);
			}
			catch (Exception e)
			{
				CSLog.error(e);
			}
		}
	}
}
