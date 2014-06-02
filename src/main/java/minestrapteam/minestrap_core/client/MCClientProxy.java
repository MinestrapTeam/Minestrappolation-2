package minestrapteam.minestrap_core.client;

import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import minestrapteam.minestrap_core.client.gui.GuiStonecutter;
import minestrapteam.minestrap_core.client.renderer.block.RenderBlockStone2;
import minestrapteam.minestrap_core.client.renderer.tileentity.RenderStonecutter;
import minestrapteam.minestrap_core.common.MCCommonProxy;
import minestrapteam.minestrap_core.tileentity.TileEntityStonecutter;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.ThreadDownloadImageData;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

public class MCClientProxy extends MCCommonProxy
{
	public static final String	capeURL	= "https://raw.githubusercontent.com/SoBiohazardous/Minestrappolation-Recode/master/src/main/resources/assets/minestrappolation/textures/misc/cape_dev.png";
	
	@Override
	public Object getClientGuiElement(int id, EntityPlayer player, World world, int x, int y, int z)
	{
		TileEntity te = world.getTileEntity(x, y, z);
		if (te instanceof TileEntityStonecutter)
		{
			return new GuiStonecutter(player.inventory, (TileEntityStonecutter) te, world, x, y, z);
		}
		return null;
	}
	
	@Override
	public void init(FMLInitializationEvent event)
	{
		stone2RenderType = RenderingRegistry.getNextAvailableRenderId();
		RenderingRegistry.registerBlockHandler(stone2RenderType, new RenderBlockStone2());
		
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityStonecutter.class, new RenderStonecutter());

		addDevCapes();		
	}
	
	public static void addDevCapes()
	{
		String[] devs = { "SoBiohazardous", "Delocuro", "triplg3", "thewerty1124", "AdrianKunz" };
		
		ThreadDownloadImageData image = new ThreadDownloadImageData(capeURL, null, null);
		
		for (String username : devs)
		{
			Minecraft.getMinecraft().renderEngine.loadTexture(new ResourceLocation("cloaks/" + username), image);
		}
	}
}
