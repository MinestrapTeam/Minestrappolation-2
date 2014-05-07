package sobiohazardous.mods.minestrappolation.extraores.proxy;

import sobiohazardous.mods.minestrappolation.extraores.client.renderer.RenderGrenade;
import sobiohazardous.mods.minestrappolation.extraores.client.renderer.RenderNukePrimed;
import sobiohazardous.mods.minestrappolation.extraores.entity.EntityGrenade;
import sobiohazardous.mods.minestrappolation.extraores.entity.EntityGrenadeImpact;
import sobiohazardous.mods.minestrappolation.extraores.entity.EntityGrenadeSticky;
import sobiohazardous.mods.minestrappolation.extraores.entity.EntityNukePrimed;
import sobiohazardous.mods.minestrappolation.extraores.handler.RenderingHandler;
import sobiohazardous.mods.minestrappolation.extraores.lib.EOItems;
import cpw.mods.fml.client.registry.RenderingRegistry;

public class ClientProxy extends CommonProxy
{
	public static String	armorPrefix;
	
	@Override
	public void registerRenderThings()
	{
		RenderingRegistry.registerBlockHandler(new RenderingHandler());
		
		RenderingRegistry.registerEntityRenderingHandler(EntityNukePrimed.class, new RenderNukePrimed());
		RenderingRegistry.registerEntityRenderingHandler(EntityGrenade.class, new RenderGrenade(EOItems.grenade));
		RenderingRegistry.registerEntityRenderingHandler(EntityGrenadeImpact.class, new RenderGrenade(EOItems.grenadeImpact));
		RenderingRegistry.registerEntityRenderingHandler(EntityGrenadeSticky.class, new RenderGrenade(EOItems.grenadeSticky));
	}
	
	public static int addArmor(String armor)
	{
		armorPrefix = armor;
		return RenderingRegistry.addNewArmourRendererPrefix(armor);
	}
}
