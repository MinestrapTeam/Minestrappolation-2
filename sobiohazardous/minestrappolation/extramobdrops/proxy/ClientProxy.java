package sobiohazardous.minestrappolation.extramobdrops.proxy;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.entity.player.EntityPlayer;
import cpw.mods.fml.client.registry.RenderingRegistry;

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
        /* Register Renderers for Blocks, Entities ... etc 
         * use RenderingRegistry.registerEntityRenderingHandler for entities
         * look at RenderingRegistry for more
         */        
    }
    
   public static int addArmor(String armor)
    {
        return RenderingRegistry.addNewArmourRendererPrefix(armor);
    }
}
