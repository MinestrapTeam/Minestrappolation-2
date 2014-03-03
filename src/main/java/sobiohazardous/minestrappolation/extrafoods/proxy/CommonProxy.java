package sobiohazardous.minestrappolation.extrafoods.proxy;

import sobiohazardous.minestrappolation.extrafoods.ExtraFoods;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.src.*;

public class CommonProxy
{
    /*
     * Anything you put in here can be implemented DIFFERENTLY on client/server. Serverside is here obviously, clientside is at ClientProxy
     * Hint: Client has access to Classes and Methods a Server doesn't know
     */
    
    public void registerRenderThings()
    {
    }
    
    public void registerRenderInformation() 
    {
    //unused server side. -- see ClientProxy for implementation
    }
}