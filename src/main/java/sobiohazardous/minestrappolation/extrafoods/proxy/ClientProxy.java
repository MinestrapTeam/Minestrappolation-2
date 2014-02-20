package sobiohazardous.minestrappolation.extrafoods.proxy;

import sobiohazardous.minestrappolation.extrafoods.ExtraFoods;
import sobiohazardous.minestrappolation.extrafoods.client.render.RenderCakeMan;
import sobiohazardous.minestrappolation.extrafoods.entity.mob.EntityCakeMan;
import net.minecraftforge.client.MinecraftForgeClient;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.registry.GameRegistry;

public class ClientProxy extends CommonProxy
{
    /*
     * Anything you've put in CommonProxy, you can override here to implement it differently on Clients.
     * Obvious applications include Rendering and Sound effects
     * Hint: Client has access to Classes and Methods a Server doesn't know
     */
    
    @Override
    public void registerRenderThings()
    {
        RenderingRegistry.registerEntityRenderingHandler(EntityCakeMan.class, new RenderCakeMan());
    }
    
    @Override
    public void registerRenderInformation() 
    {  

    }
}
