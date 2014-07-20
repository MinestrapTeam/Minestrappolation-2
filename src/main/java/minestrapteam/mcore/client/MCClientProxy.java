package minestrapteam.mcore.client;

import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import minestrapteam.mcore.client.gui.GuiStonecutter;
import minestrapteam.mcore.client.renderer.block.RenderBlockCustom2;
import minestrapteam.mcore.client.renderer.tileentity.RenderStonecutter;
import minestrapteam.mcore.common.MCCommonProxy;
import minestrapteam.mcore.tileentity.TileEntityStonecutter;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class MCClientProxy extends MCCommonProxy
{
	@Override
	public Object getClientGuiElement(int id, EntityPlayer player, World world, int x, int y, int z)
	{
		if (id == 0)
		{
			return new GuiStonecutter(player.inventory, (TileEntityStonecutter) world.getTileEntity(x, y, z), world, x, y, z);
		}
		return null;
	}
	
	@Override
	public void preInit(FMLPreInitializationEvent event)
	{
		custom2RenderType = RenderingRegistry.getNextAvailableRenderId();
		
		RenderingRegistry.registerBlockHandler(custom2RenderType, new RenderBlockCustom2());
		
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityStonecutter.class, new RenderStonecutter());
	}
}
