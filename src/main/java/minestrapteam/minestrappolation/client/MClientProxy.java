package minestrapteam.minestrappolation.client;

import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.IGuiHandler;
import minestrapteam.minestrappolation.client.gui.GuiBarrel;
import minestrapteam.minestrappolation.client.gui.GuiCrate;
import minestrapteam.minestrappolation.client.gui.GuiMelter;
import minestrapteam.minestrappolation.client.gui.GuiStonecutter;
import minestrapteam.minestrappolation.client.renderer.RenderHangGlider;
import minestrapteam.minestrappolation.client.renderer.RenderNukePrimed;
import minestrapteam.minestrappolation.client.renderer.block.RenderBlockCustom2;
import minestrapteam.minestrappolation.client.renderer.block.RenderBlockPlating;
import minestrapteam.minestrappolation.client.renderer.block.RenderGoblet;
import minestrapteam.minestrappolation.client.renderer.block.RenderPlate;
import minestrapteam.minestrappolation.client.renderer.tileentity.RenderStonecutter;
import minestrapteam.minestrappolation.common.MCommonProxy;
import minestrapteam.minestrappolation.entity.EntityGrenade;
import minestrapteam.minestrappolation.entity.EntityGrenadeImpact;
import minestrapteam.minestrappolation.entity.EntityGrenadeSticky;
import minestrapteam.minestrappolation.entity.EntityNukePrimed;
import minestrapteam.minestrappolation.lib.MItems;
import minestrapteam.minestrappolation.tileentity.*;

import net.minecraft.client.renderer.entity.RenderSnowball;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraftforge.client.MinecraftForgeClient;

public class MClientProxy extends MCommonProxy implements IGuiHandler
{
	@Override
	public void preInit(FMLPreInitializationEvent event)
	{
		custom2RenderID = RenderingRegistry.getNextAvailableRenderId();
		RenderingRegistry.registerBlockHandler(custom2RenderID, new RenderBlockCustom2());
		
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityStonecutter.class, new RenderStonecutter());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityGoblet.class, new RenderGoblet());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityPlate.class, new RenderPlate());
		
		platingRenderID = RenderingRegistry.getNextAvailableRenderId();
		RenderingRegistry.registerBlockHandler(platingRenderID, new RenderBlockPlating());
		
		MinecraftForgeClient.registerItemRenderer(MItems.hangGlider, new RenderHangGlider());
	}
	
	@Override
	public void init(FMLInitializationEvent event)
	{
		RenderingRegistry.registerEntityRenderingHandler(EntityNukePrimed.class, new RenderNukePrimed());
		RenderingRegistry.registerEntityRenderingHandler(EntityGrenade.class, new RenderSnowball(MItems.grenade));
		RenderingRegistry.registerEntityRenderingHandler(EntityGrenadeImpact.class, new RenderSnowball(MItems.grenadeNuke));
		RenderingRegistry.registerEntityRenderingHandler(EntityGrenadeSticky.class, new RenderSnowball(MItems.grenadeSticky));
	}
	
	@Override
	public Object getClientGuiElement(int id, EntityPlayer player, World world, int x, int y, int z)
	{
		if (id == 0)
		{
			return new GuiCrate(player, (TileEntityCrate) world.getTileEntity(x, y, z));
		}
		else if (id == 1)
		{
			return new GuiBarrel(player, (TileEntityBarrel) world.getTileEntity(x, y, z));
		}
		else if (id == 2)
		{
			return new GuiMelter(player, (TileEntityMelter) world.getTileEntity(x, y, z));
		}
		else if (id == 3)
		{
			return new GuiStonecutter(player.inventory, (TileEntityStonecutter) world.getTileEntity(x, y, z), world, x, y, z);
		}
		return null;
	}
	
	@Override
	public int addArmor(String armor)
	{
		return RenderingRegistry.addNewArmourRendererPrefix(armor);
	}
}
