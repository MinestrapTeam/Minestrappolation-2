package sobiohazardous.minestrappolation.extradecor.proxy;

import sobiohazardous.minestrappolation.extradecor.handler.PaneRenderingHandler;
import sobiohazardous.minestrappolation.extradecor.handler.RopeRenderingHandler;
import sobiohazardous.minestrappolation.extradecor.lib.EDBlockManager;
import sobiohazardous.minestrappolation.extradecor.tileentity.RendererGoblet;
import sobiohazardous.minestrappolation.extradecor.tileentity.RendererPlate;
import sobiohazardous.minestrappolation.extradecor.tileentity.TileEntityGoblet;
import sobiohazardous.minestrappolation.extradecor.tileentity.TileEntityPlate;
import net.minecraft.item.Item;
import net.minecraftforge.client.MinecraftForgeClient;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

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
    	ClientRegistry.bindTileEntitySpecialRenderer(TileEntityGoblet.class, new RendererGoblet());
    	ClientRegistry.bindTileEntitySpecialRenderer(TileEntityPlate.class, new RendererPlate());
    	MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(EDBlockManager.Plate), new ItemRendererPlate());
    	RenderingRegistry.registerBlockHandler(new PaneRenderingHandler());
    	RenderingRegistry.registerBlockHandler(new RopeRenderingHandler());
    }
}