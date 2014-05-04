package sobiohazardous.mods.minestrappolation.extramobdrops.handler;

import java.util.Random;

import org.lwjgl.opengl.GL11;

import sobiohazardous.mods.minestrappolation.core.util.MAssetManager;
import sobiohazardous.mods.minestrappolation.extramobdrops.lib.EMDItemManager;
import sobiohazardous.mods.minestrappolation.extramobdrops.tileentity.ModelHangGlider;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.ResourceLocation;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent.Phase;
import cpw.mods.fml.common.gameevent.TickEvent.PlayerTickEvent;

public class EMDPlayerTickHandler
{
    public static boolean gTentacleEffect = false;
    static int ticks = 0;
    static Random rand = new Random();
   	public static int gTime = 30 + rand.nextInt(150);
   	
   	@SubscribeEvent
	public void playerUpdate(PlayerTickEvent evt)
	{
   		EntityPlayer player = evt.player;
   		
		if(evt.phase == Phase.START)
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
}