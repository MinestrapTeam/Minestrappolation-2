package sobiohazardous.mods.minestrappolation.extramobdrops.client;

import sobiohazardous.mods.minestrappolation.extramobdrops.client.renderer.entity.RenderHangGlider;
import sobiohazardous.mods.minestrappolation.extramobdrops.common.CommonProxy;
import sobiohazardous.mods.minestrappolation.extramobdrops.entity.EntityHangGlider;
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
