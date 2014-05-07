package sobiohazardous.mods.minestrappolation.core.proxy;

import sobiohazardous.mods.minestrappolation.core.tileentity.RendererStonecutter;
import sobiohazardous.mods.minestrappolation.core.tileentity.TileEntityStonecutter;
import cpw.mods.fml.client.registry.ClientRegistry;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.ThreadDownloadImageData;
import net.minecraft.util.ResourceLocation;

public class ClientProxy extends CommonProxy
{
	@Override
	public void registerRenderers()
	{
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityStonecutter.class, new RendererStonecutter());
		ClientProxy.addDevCapes();
	}
	
	public static void addDevCapes()
	{
		String capeURL = "https://raw.githubusercontent.com/SoBiohazardous/Minestrappolation-Recode/master/assets/minestrappolation/textures/misc/cape_dev.png";
		String[] devs = { "SoBiohazardous", "Delocuro", "triplg3", "thewerty1124" };
		
		ThreadDownloadImageData image = new ThreadDownloadImageData(capeURL, null, null);
		
		for (String username : devs)
		{
			Minecraft.getMinecraft().renderEngine.loadTexture(new ResourceLocation("cloaks/" + username), image);
		}
	}
}
