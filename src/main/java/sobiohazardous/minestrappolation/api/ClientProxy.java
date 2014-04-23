package sobiohazardous.minestrappolation.api;

import sobiohazardous.minestrappolation.api.lib.MAPIBlocks;
import sobiohazardous.minestrappolation.api.tileentity.RendererStonecutter;
import sobiohazardous.minestrappolation.api.tileentity.TileEntityStonecutter;
import cpw.mods.fml.client.registry.ClientRegistry;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.ThreadDownloadImageData;
import net.minecraft.client.renderer.texture.ITextureObject;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.MinecraftForgeClient;

public class ClientProxy extends CommonProxy
{	
	@Override
	public void registerRenderers()
	{
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityStonecutter.class, new RendererStonecutter());
		this.addDevCapes();
	}	
	
	public static void addDevCapes() 
	{
		String capeURL = "https://raw.github.com/SoBiohazardous/Minestrappolation-Recode/master/src/main/resources/assets/minestrappolation/textures/misc/cape_dev.png";
		String[] devs = {"SoBiohazardous", "Delocuro", "triplg3", "thewerty1124"};

		ThreadDownloadImageData image = new ThreadDownloadImageData(capeURL, null, null);

		for (String username : devs) 
		{
			Minecraft.getMinecraft().renderEngine.loadTexture(new ResourceLocation("cloaks/" + username), (ITextureObject) image);
		}
	}
}
