package sobiohazardous.mods.minestrappolation.extraores.proxy;

public class CommonProxy
{
	public static String	armorPrefix;
	
	public void registerRenderThings()
	{
	}
	
	public void registerRenders()
	{
	}
	
	public static int addArmor(String armor)
	{
		armorPrefix = armor;
		return 0;
	}
}