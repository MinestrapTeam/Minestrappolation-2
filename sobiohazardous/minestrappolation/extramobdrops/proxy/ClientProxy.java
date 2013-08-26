package sobiohazardous.minestrappolation.extramobdrops.proxy;

import java.util.EnumSet;
import java.util.Map;

import sobiohazardous.minestrappolation.extramobdrops.ExtraMobDrops;
import sobiohazardous.minestrappolation.extramobdrops.potion.EMDEntityPotion;
import sobiohazardous.minestrappolation.extramobdrops.potion.EMDRenderPotion;
import net.minecraft.client.renderer.entity.RenderSnowball;
import net.minecraft.item.Item;
import net.minecraft.src.ModLoader;
import net.minecraftforge.client.MinecraftForgeClient;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.TickType;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import cpw.mods.fml.common.registry.TickRegistry;
import cpw.mods.fml.relauncher.Side;

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
    	RenderingRegistry.registerEntityRenderingHandler(EMDEntityPotion.class, new EMDRenderPotion(ExtraMobDrops.potion, 16384));
    }
    
   public static int addArmor(String armor)
    {
        return RenderingRegistry.addNewArmourRendererPrefix(armor);
    }
}
