package sobiohazardous.minestrappolation.extramobdrops.proxy;

import java.util.EnumSet;

import sobiohazardous.minestrappolation.extramobdrops.handler.EMDRenderTickHandler;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.entity.player.EntityPlayer;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.relauncher.Side;

public class ClientProxy extends CommonProxy
{    
    @Override
    public void registerRenderThings()
    {   
    	FMLCommonHandler.instance().bus().register(new EMDRenderTickHandler(Minecraft.getMinecraft()));
    }
    
   public static int addArmor(String armor)
    {
        return RenderingRegistry.addNewArmourRendererPrefix(armor);
    }
}
