package sobiohazardous.minestrappolation.extramobdrops.handler;

import java.util.EnumSet;
import java.util.Random;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import cpw.mods.fml.common.ITickHandler;
import cpw.mods.fml.common.TickType;

public class PlayerTickHandler implements ITickHandler
{
    private final EnumSet<TickType> ticksToGet;
    
    static int ticks = 0;
    
    public static boolean gTentacleEffect = false;
    
    static Random rand = new Random();
	public static int gTime = 30 + rand.nextInt(150);
	
    /*
     * This Tick Handler will fire for whatever TickType's you construct and register it with.
     */
    public PlayerTickHandler(EnumSet<TickType> ticksToGet)
    {
        this.ticksToGet = ticksToGet;
    }

    /*
     * I suggest putting all your tick Logic in EITHER of these, but staying in one
     */
    @Override
    public void tickStart(EnumSet<TickType> type, Object... tickData)
    {
    	playerTick((EntityPlayer)tickData[0]);
    }

    @Override
    public void tickEnd(EnumSet<TickType> type, Object... tickData)
    {
    }

    @Override
    public EnumSet<TickType> ticks()
    {
        return ticksToGet;
    }

    @Override
    public String getLabel()
    {
        return "ExtraMobDropsTick";
    }
    
    public static void playerTick(EntityPlayer player)
    {

    	if(gTentacleEffect)
    	{
    		ticks++;
    		if(ticks == gTime*20)
    		{
    			gTentacleEffect = false;
    			EntityPlayerMP playermp = (EntityPlayerMP)player;
    			playermp.mcServer.getConfigurationManager().transferPlayerToDimension(playermp, 0);
    		}
    	}
    	
    	if(!gTentacleEffect)
    	{
    		ticks = 0;
    	}
    }

}
