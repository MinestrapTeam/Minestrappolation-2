package sobiohazardous.mods.minestrappolation.extraores.proxy;

import java.util.Map;

import sobiohazardous.mods.minestrappolation.extraores.client.renderer.RenderNukePrimed;
import sobiohazardous.mods.minestrappolation.extraores.entity.EntityNukePrimed;
import sobiohazardous.mods.minestrappolation.extraores.handler.RenderingHandler;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.registry.EntityRegistry;

public class CommonProxy
{
	public static String armorPrefix;
    
    public void registerRenderThings(){}
    public void registerRenders(){}
    public static int addArmor(String armor) 
    {
    	armorPrefix = armor;
    	return 0; 
    }
}