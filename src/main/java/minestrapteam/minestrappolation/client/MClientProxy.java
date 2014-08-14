package minestrapteam.minestrappolation.client;

import clashsoft.cslib.minecraft.cape.Capes;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import minestrapteam.minestrappolation.client.gui.*;
import minestrapteam.minestrappolation.client.renderer.RenderHangGlider;
import minestrapteam.minestrappolation.client.renderer.RenderNukePrimed;
import minestrapteam.minestrappolation.client.renderer.block.*;
import minestrapteam.minestrappolation.client.renderer.tileentity.RenderLocked;
import minestrapteam.minestrappolation.client.renderer.tileentity.RenderSawmill;
import minestrapteam.minestrappolation.client.renderer.tileentity.RenderStonecutter;
import minestrapteam.minestrappolation.client.renderer.tileentity.RenderWorkbench2;
import minestrapteam.minestrappolation.common.MCommonProxy;
import minestrapteam.minestrappolation.entity.*;
import minestrapteam.minestrappolation.lib.MItems;
import minestrapteam.minestrappolation.tileentity.*;

import net.minecraft.client.renderer.entity.RenderSnowball;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.client.MinecraftForgeClient;

public class MClientProxy extends MCommonProxy
{
	@Override
	public void preInit(FMLPreInitializationEvent event)
	{
		custom2RenderID = RenderingRegistry.getNextAvailableRenderId();
		RenderingRegistry.registerBlockHandler(custom2RenderID, new RenderBlockCustom2());
		
		platingRenderID = RenderingRegistry.getNextAvailableRenderId();
		RenderingRegistry.registerBlockHandler(platingRenderID, new RenderBlockPlating());
		
		lockedRenderID = RenderingRegistry.getNextAvailableRenderId();
		RenderingRegistry.registerBlockHandler(lockedRenderID, new RenderBlockLocked());
		
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityStonecutter.class, new RenderStonecutter());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntitySawmill.class, new RenderSawmill());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityGoblet.class, new RenderGoblet());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityPlate.class, new RenderPlate());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityLocked.class, new RenderLocked());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityWorkbench2.class, new RenderWorkbench2());
		
		MinecraftForgeClient.registerItemRenderer(MItems.hangGlider, new RenderHangGlider());
		
		RenderingRegistry.registerEntityRenderingHandler(EntityGrenade.class, new RenderSnowball(MItems.grenade));
		RenderingRegistry.registerEntityRenderingHandler(EntityGrenadeImpact.class, new RenderSnowball(MItems.grenadeImpact));
		RenderingRegistry.registerEntityRenderingHandler(EntityGrenadeSticky.class, new RenderSnowball(MItems.grenadeSticky));
		RenderingRegistry.registerEntityRenderingHandler(EntityGrenadeNuke.class, new RenderSnowball(MItems.grenadeNuke));
		RenderingRegistry.registerEntityRenderingHandler(EntityNukePrimed.class, new RenderNukePrimed());
	}
	
	@Override
	public void init(FMLInitializationEvent event)
	{
		Capes.setLocalCape("SoBiohazardous", new ResourceLocation("minestrappolation", "textures/misc/cape_sobiohazardous.png"));
		Capes.setLocalCape("AdrianKunz", new ResourceLocation("minestrappolation", "textures/misc/cape_clashsoft.png"));
		Capes.setLocalCape("Delocuro", new ResourceLocation("minestrappolation", "textures/misc/cape_delocuro.png"));
		Capes.setLocalCape("Thewerty1124", new ResourceLocation("minestrappolation", "textures/misc/cape_thewerty.png"));
		Capes.setLocalCape("LandKingdom", new ResourceLocation("minestrappolation", "textures/misc/cape_landkingdom.png"));
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
			return new GuiStonecutter(player.inventory, (TileEntityStonecutter) world.getTileEntity(x, y, z));
		}
		else if (id == 4)
		{
			return new GuiSawmill(player.inventory, (TileEntitySawmill) world.getTileEntity(x, y, z));
		}
		return null;
	}
	
	@Override
	public int addArmor(String armor)
	{
		return RenderingRegistry.addNewArmourRendererPrefix(armor);
	}
	
	@Override
	public boolean isClient()
	{
		return true;
	}
}
