package sobiohazardous.minestrappolation.extramobdrops.proxy;

import java.util.EnumSet;
import java.util.Map;
import net.minecraft.src.ModLoader;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.TickType;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.TickRegistry;
import cpw.mods.fml.relauncher.Side;


public class CommonProxy
{
    /*
     * Anything you put in here can be implemented DIFFERENTLY on client/server. Serverside is here obviously, clientside is at ClientProxy
     * Hint: Client has access to Classes and Methods a Server doesn't know
     */
    
    public void registerRenderThings()
    {
        /* NOOP, servers do not need Renderers */
    	
    	
    }
    
    public void registerRenders(){};
    public static int addArmor(String armor) { return 0; }

}