package sobiohazardous.minestrappolation.extradecor.proxy;

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
}