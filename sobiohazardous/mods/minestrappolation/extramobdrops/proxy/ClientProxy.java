package sobiohazardous.mods.minestrappolation.extramobdrops.proxy;

import sobiohazardous.mods.minestrappolation.extramobdrops.entity.EntityHangGlider;
import sobiohazardous.mods.minestrappolation.extramobdrops.tileentity.RenderHangGlider;
import cpw.mods.fml.client.registry.RenderingRegistry;

public class ClientProxy extends CommonProxy
{
	@Override
	public void registerRenderThings()
	{
		super.registerRenderThings();
		RenderingRegistry.registerEntityRenderingHandler(EntityHangGlider.class, new RenderHangGlider());
	}
	
	public static int addArmor(String armor)
	{
		return RenderingRegistry.addNewArmourRendererPrefix(armor);
	}
}
