package clashsoft.cslib.minecraft.potion;

import clashsoft.cslib.util.CSArrays;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import net.minecraft.client.Minecraft;
import net.minecraft.potion.Potion;
import net.minecraft.util.ResourceLocation;

/**
 * The Class CustomPotion.
 */
public class CustomPotion extends Potion
{
	/** The custom icon file. */
	private ResourceLocation	customIconFile;
	
	/** The instant. */
	private boolean				instant;
	
	/** The custom color. */
	private int					customColor;
	
	/** The bad. */
	private boolean				bad;
	
	/**
	 * Instantiates a new custom potion.
	 * 
	 * @param name
	 *            the name
	 * @param bad
	 *            the bad
	 * @param color
	 *            the color
	 * @param instant
	 *            the instant
	 * @param iconFile
	 *            the icon file
	 * @param iconX
	 *            the icon x location
	 * @param iconY
	 *            the icon y location
	 */
	public CustomPotion(String name, boolean bad, int color, boolean instant, String iconFile, int iconX, int iconY)
	{
		this(name, bad, color, instant, iconFile, iconX, iconY, -1);
	}
	
	/**
	 * Instantiates a new custom potion.
	 * 
	 * @param name
	 *            the name
	 * @param bad
	 *            the bad
	 * @param color
	 *            the color
	 * @param instant
	 *            the instant
	 * @param iconFile
	 *            the icon file
	 * @param iconX
	 *            the icon x location
	 * @param iconY
	 *            the icon y location
	 * @param customColor
	 *            the custom color
	 */
	public CustomPotion(String name, boolean bad, int color, boolean instant, String iconFile, int iconX, int iconY, int customColor)
	{
		super(getNextFreeID(), bad, color);
		this.setPotionName(name);
		this.instant = instant;
		this.setIconIndex(iconX, iconY);
		this.customColor = customColor;
		this.bad = bad;
		this.customIconFile = new ResourceLocation(iconFile);
	}
	
	/*
	 * (non-Javadoc)
	 * @see net.minecraft.potion.Potion#getStatusIconIndex()
	 */
	@Override
	@SideOnly(Side.CLIENT)
	public int getStatusIconIndex()
	{
		Minecraft.getMinecraft().renderEngine.bindTexture(this.customIconFile);
		return super.getStatusIconIndex();
	}
	
	/**
	 * Gets the custom color.
	 * 
	 * @return the custom color
	 */
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
	
	/**
	 * Gets the next free potion id.
	 * 
	 * @return the next free potion id
	 */
	public static int getNextFreeID()
	{
		int id = CSArrays.indexOf(potionTypes, null);
		if (id == -1)
			throw new IllegalStateException("No more empty potion IDs!");
		return id;
	}
}
