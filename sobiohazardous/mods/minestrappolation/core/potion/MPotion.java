package sobiohazardous.mods.minestrappolation.core.potion;

import cpw.mods.fml.common.registry.LanguageRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import net.minecraft.client.Minecraft;
import net.minecraft.util.ResourceLocation;
import net.minecraft.potion.Potion;

public class MPotion extends Potion
{
	private ResourceLocation	customIconFile;
	private boolean				instant;
	private int					customColor;
	private boolean				bad;
	private String				name;
	
	public MPotion(String unlocalizedName, boolean isBad, int color, boolean instant, String iconFile, int iconX, int iconY)
	{
		this(unlocalizedName, isBad, color, instant, iconFile, iconX, iconY, -1);
		this.name = unlocalizedName;
	}
	
	public MPotion(String name, boolean bad, int color, boolean instant, String iconFile, int iconX, int iconY, int customColor)
	{
		super(getNextFreeID(), bad, color);
		this.setPotionName(name);
		this.instant = instant;
		this.setIconIndex(iconX, iconY);
		this.customColor = customColor;
		this.bad = bad;
		this.customIconFile = new ResourceLocation(iconFile);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public int getStatusIconIndex()
	{
		Minecraft.getMinecraft().renderEngine.bindTexture(this.customIconFile);
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
	
	public boolean getIsGoodOrNotGoodEffect()
	{
		return this.bad;
	}
	
	public static int getNextFreeID()
	{
		int id = 32;
		for (int i = 32; i < potionTypes.length; i++)
		{
			if (potionTypes[i] == null)
			{
				id = i;
				break;
			}
		}
		System.out.println("Free potion id found: " + id);
		return id;
	}
	
	/**
	 * Sets the potion in-game name to parameter value.
	 * 
	 * @param ingameName
	 * @return itself (for chain methoding)
	 */
	public MPotion setInGamePotionName(String ingameName)
	{
		LanguageRegistry.instance().addStringLocalization(this.name, ingameName);
		return this;
	}
}