package sobiohazardous.minestrappolation.extramobdrops.proxy;

import java.util.EnumSet;

import sobiohazardous.minestrappolation.extramobdrops.entity.EntityHangGlider;
import sobiohazardous.minestrappolation.extramobdrops.tileentity.RenderHangGlider;
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
    	super.registerRenderThings();
    	RenderingRegistry.registerEntityRenderingHandler(EntityHangGlider.class, new RenderHangGlider());
    }
    
   public static int addArmor(String armor)
    {
        return RenderingRegistry.addNewArmourRendererPrefix(armor);
    }
}
